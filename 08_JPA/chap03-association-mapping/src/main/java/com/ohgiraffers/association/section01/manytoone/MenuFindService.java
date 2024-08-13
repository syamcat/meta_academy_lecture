package com.ohgiraffers.association.section01.manytoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
//@Transactional(TxType.REQUIRED)
// Lazy방식으로 불러왔을 때 어떤 메소드에 @Transactional을 달아야 하는지 모르는 경우
// Service객체에다 달아버린다.
public class MenuFindService {

    private MenuRepository menuRepository;

    @Autowired
    public MenuFindService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Transactional  // Lazy방식으로 작동할 때 사용
    public Menu findMenuByMenuCode(int menuCode) {

        return menuRepository.findMenuByMenuCode(menuCode);
    }
}
