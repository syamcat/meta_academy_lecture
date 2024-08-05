package com.ohgiraffers.persistence.section01.entitymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;

public class EntityManagerGeneratorTests {

    // 엔티티 메니저란?
    // 엔티티를 저장하는 메모리상의 데이터베이스라고 생각하면 된다.
    // 엔티티를 저장하고 수정하고 삭제하고 조회하는 등의 엔티티와 관련되 모든 일을 한다.
    // 스레드 세이프 하지 않아서 동시성문제가 발생할 수 있다.
    // 따라서 스레드간 공유를 하면 안된다. (Web의 경우 request scope와 일치시킨다.)

    // 영속성 컨텍스트(Persistence Context)란?
    // 영속성 컨텍스트는 엔티티를 영구 저장하는 환경을 말한다.
    // 엔티티 매니저에 엔티티를 저장하거나 조회하면 엔티티 매니저는 영속성 컨텍스트에 엔티티를 보관하고 관리한다.
    // 영속성 엔티티를 key value 방식으로 저장하는 저장소 역할을 한다.
    // 영속성 컨텍스트는 엔티티 매니저를 생설할 때 하나 만들어진다.
    // 엔티티 매니저를 통해서 영속성 컨텍스트에 접근할 수 있고 영속성 컨텍스트를 관리할 수 있다.

    // 엔티티 매니저 팩토리(EntityManagerFactory)란?
    // 엔티티 매니저를 생성할 수 있는 기능을 제공하는 팩토리 클래스이다.
    // 스레드 세이프 하기 때문에 여러 스레드가 동시에 접근해도 안전하다
    // 서로 다른 스레드간 공유해서 재사용한다.
    // 하지만 스레드 세이프한 기능을 요청 스코프마다 생성하기에는 비용(시간, 메모리) 부담이 크기 때문에
    // application 스코프와 동일한 싱글톤으로 생성해서 관리하게 된다.
    // 따라서 데이터베이스를 사용하는 애플리케이션 당 한 개의 EntityManagerFactory를 생성한다.

    @Test
    @DisplayName("엔티티 매니저 팩토리 생성 확인")
    void testGeneratorEntityManagerFactory() {
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();

        Assertions.assertNotNull(factory);
    }

    @Test
    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스 확인")
    void testIsEntityManagerFactorySingletonInstance() {


        // given
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();

        // when
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();

        // then
        Assertions.assertEquals(factory1, factory2);
    }
}
