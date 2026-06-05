package org.zerock.ex00.domain;

import lombok.Data;

@Data
public class Criteria {
    private int pageNum = 1;
    private int amount = 10;

    private String[] types; // null, 제목, 내용, 작성자, 제목&내용, 제목&작성자, 제목&내용&작성자 총 7가지 방법의 검색조건이 있음.
    private String keyword;

    private String typeStr;

    public void setTypes(String[] types){
        this.types = types;

        if(types != null && types.length > 0){
            typeStr = String.join("", types);
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if(pageNum <= 0){
            this.pageNum= 1;
            return;
        }
        this.pageNum = pageNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if(amount <= 10 || amount >= 100){
            this.amount = 10;
            return;
        }
        this.amount = amount;
    }

    public int getSkip(){
        return (this.pageNum - 1) * this.amount;
    }
}
