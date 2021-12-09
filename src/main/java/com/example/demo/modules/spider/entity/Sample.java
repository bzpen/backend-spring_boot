package com.example.demo.modules.spider.entity;

import javax.xml.crypto.Data;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
public class Sample {

    private Integer sampleId;
    private String sampleNumber;
    private Integer spiderId;
    private Integer userId;
    private String sampleGenetic;
    private String sampleTime;
    private String sampleLocations;
    private String sampleJdu;
    private String sampleWdu;
    private String sampleList;
    private Integer sampleLength;
    private String sampleInstruct;

    public Integer getSampleId() {
        return sampleId;
    }

    public void setSampleId(Integer sampleId) {
        this.sampleId = sampleId;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public Integer getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(Integer spiderId) {
        this.spiderId = spiderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSampleGenetic() {
        return sampleGenetic;
    }

    public void setSampleGenetic(String sampleGenetic) {
        this.sampleGenetic = sampleGenetic;
    }

    public String getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime;
    }

    public String getSampleLocations() {
        return sampleLocations;
    }

    public void setSampleLocations(String sampleLocations) {
        this.sampleLocations = sampleLocations;
    }

    public String getSampleJdu() {
        return sampleJdu;
    }

    public void setSampleJdu(String sampleJdu) {
        this.sampleJdu = sampleJdu;
    }

    public String getSampleWdu() {
        return sampleWdu;
    }

    public void setSampleWdu(String sampleWdu) {
        this.sampleWdu = sampleWdu;
    }

    public String getSampleList() {
        return sampleList;
    }

    public void setSampleList(String sampleList) {
        this.sampleList = sampleList;
    }

    public Integer getSampleLength() {
        return sampleLength;
    }

    public void setSampleLength(Integer sampleLength) {
        this.sampleLength = sampleLength;
    }

    public String getSampleInstruct() {
        return sampleInstruct;
    }

    public void setSampleInstruct(String sampleInstruct) {
        this.sampleInstruct = sampleInstruct;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "sampleId=" + sampleId +
                ", sampleNumber='" + sampleNumber + '\'' +
                ", spiderId=" + spiderId +
                ", userId=" + userId +
                ", sampleGenetic='" + sampleGenetic + '\'' +
                ", sampleTime='" + sampleTime + '\'' +
                ", sampleLocations='" + sampleLocations + '\'' +
                ", sampleJdu='" + sampleJdu + '\'' +
                ", sampleWdu='" + sampleWdu + '\'' +
                ", sampleList='" + sampleList + '\'' +
                ", sampleLength=" + sampleLength +
                ", sampleInstruct='" + sampleInstruct + '\'' +
                '}';
    }
}
