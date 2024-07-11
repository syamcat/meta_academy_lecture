package com.i5.handlermethod;

/*
 *   MenuDTO.java
 *   Author : syamcat
 *   Created : 24. 7. 11.
 **/
public class MenuDTO {

    private String menuName;
    private int categoryCode;
    private int menuPrice;
    private String orderableStatus;

    // 기본생성자가로 생성하고 setter메서드로 필드를 초기화 하기 때문에 옛날거는 없으면 에러난다.
    public MenuDTO() {}

    public MenuDTO(String menuName, int categoryCode, int menuPrice, String orderableStatus) {
        this.menuName = menuName;
        this.categoryCode = categoryCode;
        this.menuPrice = menuPrice;
        this.orderableStatus = orderableStatus;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", categoryCode=" + categoryCode +
                ", menuPrice=" + menuPrice +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
