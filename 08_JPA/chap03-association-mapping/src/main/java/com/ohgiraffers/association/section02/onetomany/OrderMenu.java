package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity // 라이프 사이클이 같은 경우에만 같은 패키지 안에 @Entity 여러개 둘 수 있음
@Table(name="tbl_order_menu")
public class OrderMenu {

    @EmbeddedId
    private OrderMenuPK orderMenuPK;

    @Column(name="ORDER_AMOUNT")
    private int orderAmount;

    public OrderMenu() {}

    public OrderMenu(OrderMenuPK orderMenuPK, int orderAmount) {
        this.orderMenuPK = orderMenuPK;
        this.orderAmount = orderAmount;
    }

    public OrderMenuPK getOrderMenuPK() {
        return orderMenuPK;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderMenuPK=" + orderMenuPK +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
