package com.ceshiren;

import lombok.Data;

@Data
public class SumList {
    private String testCaseName;
    private String expect;
    private int addNumA;
    private int addNumB;

    public SumList() {
    }
    public SumList(String testCaseName,String expect, int addNumA, int addNumB) {
        this.testCaseName=testCaseName;
        this.expect = expect;
        this.addNumA = addNumA;
        this.addNumB = addNumB;
    }

    @Override
    public String toString() {
        return "SumList{" +
                " testCaseName=" + testCaseName +
                ", expect=" + expect  +
                ", addNumA=" + addNumA +
                ", addNumB=" + addNumB +
                '}';
    }
}
