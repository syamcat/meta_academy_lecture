package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LikedMemberNo {

    @Column(name="LIKED_MEMBER_NO")
    private int likedMemberNO;

    protected LikedMemberNo() {}

    protected LikedMemberNo(int likedMemberNO) {
        this.likedMemberNO = likedMemberNO;
    }

    public int getLikedMemberNO() {
        return likedMemberNO;
    }

    @Override
    public String toString() {
        return "LikedMemberNo{" +
                "likedMemberNO=" + likedMemberNO +
                '}';
    }
}
