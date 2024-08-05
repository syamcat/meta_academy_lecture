package com.ohgiraffers.persistence.section03.entity;

import javax.persistence.*;

@Entity(name = "Section03Menu")
@Table(name = "tbl_menu")
public class Menu {


    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;


    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;

    // 기본생성자
    public Menu() {}

    // key 값 불포함
    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    // key 값 포함하는 생성자
    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
