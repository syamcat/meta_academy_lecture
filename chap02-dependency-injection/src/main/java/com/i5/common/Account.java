package com.i5.common;

/*
 *   Account.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/
public interface Account {

    String getBalance();

    String deposit(int money);

    String withdraw(int money);
}
