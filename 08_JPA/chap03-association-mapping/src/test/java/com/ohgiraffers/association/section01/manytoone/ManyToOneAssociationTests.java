package com.ohgiraffers.association.section01.manytoone;

import org.hibernate.annotations.Parameter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ManyToOneAssociationTests {

    // Association Mapping은 Entity간의 관계를 매핑하는 것을 의미한다.
    // 이를 통해 객체를 이용해 데이터베이스 테이블 간의 관계를 매핑할 수 있다.

    // 다중성에 의한 분류
    // 연관관계가 있는 객체 관계에서 실제로 연관을 가지는 객체의 수에 따라 분류
    // N:1(ManyToOne), 1:N(OneToMany), 1:1(OneToOne), N:N(ManyToMany)

    // 방향에 따른 분류
    // 테이블의 연관 관계는 외래키를 이용하여 야방향 연관관계의 특징을 가진다.
    // 참조에 의한 객체의 연관 관계는 단방향이다.
    // 단방향 연관관계, 양방향 연관관계
    // 객체간의 연관관계를 양방향으로 만들고 싶은 경우 반대쪽에서도 필드를 추가해서 참조를 보관하면 된다.
    // 하지만 엄밀하게 이는 양방향 관계가 아닌 단방향 관계 2개로 볼 수 있다.

    // ManyToOne : 다수의 엔티티가 하나의 엔티티를 참조하는 상황에서 사용한다.

    @Autowired
    private MenuFindService menuFindService;

    @DisplayName("메뉴 코드로 메뉴 조회하여 메뉴 이름이 일치하는지 테스트")
    @ParameterizedTest
    @CsvSource({"1, 망고빙수", "2, 우럭스무디"})
    void testSelectMenuCompareToMenuName(int menuCode, String menuName) {

        Menu foundMenu = menuFindService.findMenuByMenuCode(menuCode);

        Assertions.assertEquals(menuName, foundMenu.getMenuName());
    }

    @DisplayName("메뉴 코드로 메뉴 조회하여 카테고리 이름이 일치하는지 테스트")
    @ParameterizedTest
    @CsvSource({"1, 식사", "2, 기타"})
    @Transactional // Lazy방식으로 하면 select를 두 번 해오기 때문에 @Transactional 어노테이션을 붙여야함
    // 지연 로딩의 경우 트랜젝션이 종료되면 session이 close되면서 준영속 상태가 된다.
    // 엔티티 매니저가 관리하지 않는 객체가 되는 것이기 때문에 세션이 종료되었다는 에러가 발생한다.
    // 지연로딩을
    void testSelectMenuCompareToCategoryName(int menuCode, String categoryName) {

        Menu foundMenu = menuFindService.findMenuByMenuCode(menuCode);

        Assertions.assertEquals(categoryName, foundMenu.getCategory().getCategoryName());
    }

}
