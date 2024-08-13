package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="tbl_order")
public class Order {

    @Id
    @Column(name="ORDER_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderCode;

    @Column(name="ORDER_DATE") // 기간별 주문조회 하기 위해 String형식으로 변환과, 날짜-시간 분리
    private String orderDate;

    @Column(name="ORDER_TIME")
    private String orderTime;

    @Column(name="TOTAL_ORDER_PRICE")
    private int totalOrderPrice;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="ORDER_CODE", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private List<OrderMenu> orderMenus;

    public Order() {}

    public Order(LocalDate orderDate, LocalTime orderTime, int totalOrderPrice, List<OrderMenu> orderMenus) {

        this.orderDate = orderDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.orderTime = orderTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.totalOrderPrice = totalOrderPrice;
        this.orderMenus = orderMenus;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", totalOrderPrice=" + totalOrderPrice +
                ", orderMenus=" + orderMenus +
                '}';
    }
}
