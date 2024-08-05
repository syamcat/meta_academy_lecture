package com.ohgiraffers.persistence.section02.crud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class EntityManagerCRUDTests {

    private EntityManagerCRUD manager;

    @BeforeEach
    void initManager() {
        manager = new EntityManagerCRUD();
    }

    @DisplayName("메뉴 코드로 메뉴 조회");
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"}) // 테스트를 시작하면 매개변수에 각각 세트를 넣어줌
    void testFindMenuByMenuCode(int menuCode, int expected) {
        Menu menu = manager.findMenuByMenuCode(menuCode);

        Assertions.assertEquals(expected, menu.getMenuCode());
    }
}
