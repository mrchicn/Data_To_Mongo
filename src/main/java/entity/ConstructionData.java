package entity;

import org.bson.Document;

import java.util.Date;

/***
 @author mrchi
 @Project Data_To_Mongo
 @File ConstructionData.java
 @date 2019年05月15日 18:10
 @Website http://www.mrchi.cn
 @version 1.0
 ***/
public class ConstructionData {

    private double d1;
    private double d2;
    private int d3;
    private int d20;
    private Date d4;
    private int d5;
    private int d6;
    private int d7;
    private int d8;
    private int d9;
    private Date d999;
    private Object id;
    private String oem;
    private String pNo;
    private String sim;
    private Date time;
    private String upType;

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }
    public int getD3() {
        return d3;
    }

    public void setD3(int d3) {
        this.d3 = d3;
    }


    public int getD20() {
        return d20;
    }

    public void setD20(int d20) {
        this.d20 = d20;
    }

    public Date getD4() {
        return d4;
    }

    public void setD4(Date d4) {
        this.d4 = d4;
    }

    public int getD5() {
        return d5;
    }

    public void setD5(int d5) {
        this.d5 = d5;
    }

    public int getD6() {
        return d6;
    }

    public void setD6(int d6) {
        this.d6 = d6;
    }

    public int getD7() {
        return d7;
    }

    public void setD7(int d7) {
        this.d7 = d7;
    }

    public int getD8() {
        return d8;
    }

    public void setD8(int d8) {
        this.d8 = d8;
    }

    public int getD9() {
        return d9;
    }

    public void setD9(int d9) {
        this.d9 = d9;
    }

    public Date getD999() {
        return d999;
    }

    public void setD999(Date d999) {
        this.d999 = d999;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUpType() {
        return upType;
    }

    public void setUpType(String upType) {
        this.upType = upType;
    }

    @Override
    public String toString() {
        return "{" +
                "'d1':" + d1 +
                ", 'd2':" + d2 +
                ", 'd3':" + d3 +
                ", 'd20':" + d20 +
                ", 'd4':" + d4 +
                ", 'd5':" + d5 +
                ", 'd6':" + d6 +
                ", 'd7':" + d7 +
                ", 'd8':" + d8 +
                ", 'd9':" + d9 +
                ", 'd999':" + d999 +
                ", 'id':" + id +
                ", 'oem':" + oem +
                ", 'pNo':" + pNo +
                ", 'sim':" + sim +
                ", 'time':" + time +
                ", 'upType':" + upType +
                '}';
    }
}