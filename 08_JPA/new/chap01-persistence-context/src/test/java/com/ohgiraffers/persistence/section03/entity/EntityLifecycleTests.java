package com.ohgiraffers.persistence.section03.entity;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.stream.Stream;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class EntityLifecycleTests {

    /* 엔티티의 생명주기
    *  비영속 (new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 상태
    *
    * */

    private EntityLifecycle lifecycle;

    @BeforeEach
    void setUp() {
        lifecycle = new EntityLifecycle();
    }

//    @DisplayName("비영속성 테스트")
//    @ParameterizedTest
//    @ValueSource(ints = {1, 2})
//    void testTransient(int menuCode) {
//
//        Menu foundMenu = lifecycle.findMenuByMenuCode(menuCode);
//        System.out.println("foundMenu = " + foundMenu);
//    }

    @DisplayName("비영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testTransient(int menuCode) {

        Menu foundMenu = lifecycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                menuCode,
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );
        Assertions.assertNotEquals(newMenu, foundMenu); // 동일 객체인지 확인 => 서로 다르면 통과

    }

    @DisplayName("다른 엔티티 메니저가 관리하는 엔티티의 영속성 조회 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testManagedOtherEntityManager(int menuCode) {
        Menu menu1 = lifecycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifecycle.findMenuByMenuCode(menuCode);

        Assertions.assertNotEquals(menu1, menu2);
    }


    @DisplayName("같은 엔티티 메니저가 관리하는 엔티티의 영속성 조회 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void tsetManagedSameEntityManager(int menuCode) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();

//        Menu menu1 = lifecycle.findMenuByMenuCode(menuCode);
//        Menu menu2 = lifecycle.findMenuByMenuCode(menuCode);
        Menu menu1 = manager.find(Menu.class, menuCode);
        Menu menu2 = manager.find(Menu.class, menuCode);

        Assertions.assertEquals(menu1, menu2);
    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of("새로운 메뉴", 5000, 4, "Y")
        );
    }


    @DisplayName("엔티티 영속성 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testManagedNewEntity(String menuName, int menuPrice, int categoryCode, String orderableStatus) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);

        transaction.begin();    // transaction 시작
        manager.persist(menu);  // 메뉴 객체를 영속화
        manager.flush();        // git merge 같은 개념

        Assertions.assertTrue(manager.contains(menu)); // manager.contains => 해당 메뉴를 영속성 컨텍스트에 가지고 있으면(영속화 되어있으면) true 반환
        transaction.rollback(); // transaction 되돌리기
    }

    @DisplayName("엔티티 속성 변경 테스트")
    @ParameterizedTest
    @CsvSource({"1, 메론죽", "2, 김치딸기죽"})
    void tsetManagedNewEntityModify(int menuCode, String menuName) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        Menu foundMenu = manager.find(Menu.class, menuCode);    // 메뉴 영속화
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        foundMenu.setMenuName(menuName);
        manager.flush();

        Menu expectedMenu = manager.find(Menu.class, menuCode);
        Assertions.assertEquals(expectedMenu.getMenuName(), foundMenu.getMenuName());
        transaction.rollback();

    }

    @DisplayName("준영속성 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachEntity(int menuCode, int menuPrice) {
        // 준 영속성 = entity manager 가 더이상 관리하지 않게 만든다. (detach)
        // 비 영속성 = entity manager 가 처음부터 관리하지 않았다.


        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        Menu foundMenu = manager.find(Menu.class, menuCode);    // 메뉴 영속화

        transaction.begin();
        manager.detach(foundMenu);  // 준 영속화

        foundMenu.setMenuPrice(menuPrice);
        manager.flush();            // DB에 반영(준 영속화 했기 때문에 동작 안 함)

        Assertions.assertNotEquals(foundMenu.getMenuPrice(), manager.find(Menu.class, menuCode).getMenuPrice()); // 새로운 메뉴 다시 영속화
        transaction.rollback();
    }

    @DisplayName("준 영속성 detach 후 다시 영속화 테스트")   // merge
    @ParameterizedTest(name = "[{index}] 준영속화 된 {0}번 메뉴를 {1}원 으로 변경하고 다시 영속화 되는 지 확인")  //[index]: 번호, {0}: 0번 파라미터, {1}: 1번 파라미터
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachAndPersist(int menuCode, int menuPrice) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        Menu foundMenu = manager.find(Menu.class, menuCode);


        transaction.begin();
        manager.detach(foundMenu);  // 준 영속화 (.gitignore 같은 녀석)
        foundMenu.setMenuPrice(menuPrice);
        manager.merge(foundMenu);   // 다시 영속화 및 DB에서 Select해서 차이점 비교
        manager.flush();            // flush 할 때 다시 영속화(merge)할 때 비교해서 차이가 있었다면 update를 진행

        Assertions.assertEquals(foundMenu.getMenuPrice(), manager.find(Menu.class, menuCode).getMenuPrice());
        transaction.rollback();

    }

    @DisplayName("준영속성 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testClearPersistenceContest(int menuCode) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();

        Menu foundMenu = manager.find(Menu.class, menuCode);    // 영속화
        manager.clear();                                        // 영속성 컨텍스트 내부 엔티티들 전부 준영속화

        Menu expectedMenu = manager.find(Menu.class, menuCode); // 새로운 엔티티를 DB에서 불러와 영속화

        Assertions.assertNotEquals(expectedMenu, foundMenu);    // 서로 다름
    }

    @DisplayName("준영속성 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void TestClosePersistenceContest(int menuCode) {

        // close는 영속성 컨텍스트를 종료시킨다.
        // 종료시킨 이후 다시 영속성 컨텍스트를 사용하려면 IlleaalStateException이 발생하게 된다.

        EntityManager manager = EntityManagerGenerator.getManagerInstance();

        Menu foundMenu = manager.find(Menu.class, menuCode);
        manager.close();    // manager 영업 종료 = 창고 닫기

        Assertions.assertThrows(
                IllegalStateException.class, () -> manager.find(Menu.class, menuCode)   // 영업 종료했다는 에러 발생
        );
    }


    @DisplayName("영속성 엔티티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void tsetRemoveEntity(int menuCode) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        Menu foundMenu = manager.find(Menu.class, menuCode);
        manager.remove(foundMenu);  // 제거할 메뉴 manager에 등록

        manager.flush();    // DB에 delete 쿼리 실행시킴

        Assertions.assertFalse(manager.contains(foundMenu));
        transaction.rollback();
    }
}
