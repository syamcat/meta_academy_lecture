package com.ohgiraffers.jpql.section04.paging;

import com.ohgiraffers.jpql.section01.simple.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootTest
public class PagingTests {

    @Autowired
    private MenuFindWithPagingService menuFindWithPagingService;

    @DisplayName("페이징 API를 이용한 조회 테스트")
    @ParameterizedTest
    @CsvSource({"0,5", "1,5"})
    void testFindAllMenuWithPaging(int offset, int limit) {

        Assertions.assertDoesNotThrow(() -> {
            List<Menu> menus
        })
    }
}
