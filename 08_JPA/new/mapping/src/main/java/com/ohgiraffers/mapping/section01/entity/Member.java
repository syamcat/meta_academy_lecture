package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// 주의사항
// 1. 기본 생성자는 필수로 작성해야 한다.
// 2. final 클래스, enum, interface, inner class 에서는 사용할 수 없다.
// 3. 기본키가 한 개는 반드시 존재해야 한다.
// 4. 저장할 필드에 final을 사용하면 안된다.

// 해당 클래스를 엔티티로 설정하기 위한 어노테이션이다.
// 프로젝트 내 다른 패키지에도 동일한 엔티티가 존재하는 경우 엔티티를 식별하기 위한 값
// 중복되지 않는 name을 지정해 주어야 한다.
@Entity // 생략하면 default name 은 Entity 가 된다.
@Table(name="tbl_member") // 매핑될 테이블의 이름을 작성한다. 생략하면 default name = Class name
public class Member {

    @Id // 자바 기본형, Wrapper, String, java.util.Date, java.sql.Date, java.math.BigDecimal, java.math.BigInteger 자료형 외에는 사용 불가
    @Column(name="MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 1. IDENTITY : 기본 키 생성을 데이터베이스에 위임한다. DB의 ID Column 의 설정이 AUTO_INCREMENT 인 경우 사용
    // 2. SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본 키를 할당한다. ORACLE DB 사용할 때 사용
    // 3. TABLE : 키 생성 테이블을 사용한다. 수동으로 키 생성을 관리할 때 사용
    // 4. AUTO : DB 설정에 맞춤
    private int memberNo;

    @Column(name="MEMBER_ID", unique = true, nullable = false, columnDefinition = "varchar(10)") // 중복허용, not null, 추가 column 설정
    private String memberId;    // 기본 크기 varchar(5)

    @Column(name="MEMBER_PWD", nullable = false)
    private String memberPwd;

    @Column(name="MEMBER_NAME")
    private String memberName;

    @Column(name="PHONE")
    private String phone;

    @Column(name="ADDRESS", length = 500) // 문자열의 길이 설정
    private String address;

    @Column(name="ENROLL_DATE")
    private LocalDateTime enrollDate;

    @Column(name="MEMBER_ROLE")
//    @Enumerated(EnumType.ORDINAL) 기존 enum 처럼 0, 1로 매핑, 용량은 적어서 더 빠르다.
    @Enumerated(EnumType.STRING)    // 적어놓은 문자열로 매핑 "ROLE_MEMBER"
    private MemberRole memberRole;


    @Column(name="STATUS", columnDefinition = "char(1) default 'Y'")
    private String status;

    public Member() {}

    public Member(String memberId, String memberPwd, String memberName, String phone, String address, LocalDateTime enrollDate, MemberRole memberRole, String status) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }
}
