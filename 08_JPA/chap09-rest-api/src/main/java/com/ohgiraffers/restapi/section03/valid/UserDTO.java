package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.constraints.*;

import java.util.Date;

public class UserDTO {

    private int no;

//    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")   // null만 금지
//    @NotEmpty // null, 공백을 허용하지 않음
    @NotBlank(message = "아이디는 공백일 수 없습니다.") // null, 공백, 띄어쓰기 모두 금지
    private String id;
    private String pwd;

    @NotNull(message = "이름은 반드시 입력되어야 합니다.")
    @Size(min = 2, message = "이름은 2글자 이상 입력해야 합니다.")
    private String name;

//    @Future // 현재보다 미래 날짜만 입력 가능
    @Past   // 현재보다 과거 날짜만 입력 가능
    private java.util.Date enrollDate;

    public UserDTO() {}

    public UserDTO(int no, String id, String pwd, String name, Date enrollDate) {
        this.no = no;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
