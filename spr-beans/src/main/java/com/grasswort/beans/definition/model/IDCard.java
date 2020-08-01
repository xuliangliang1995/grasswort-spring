package com.grasswort.beans.definition.model;

/**
 * @author xuliangliang
 * @Description 身份证
 * @Date 2020/8/1
 */
public class IDCard {
    /**
     * 身份证号
     */
    private String idNumber;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "IDCard{" +
                "idNumber='" + idNumber + '\'' +
                '}';
    }
}
