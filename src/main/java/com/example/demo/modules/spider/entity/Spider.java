package com.example.demo.modules.spider.entity;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
public class Spider {
    private Integer spiderId;
    private String spiderName;
    private String spiderPhoto;
    private Integer spiderSample;
    private String spiderDetails;

    public Integer getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(Integer spiderId) {
        this.spiderId = spiderId;
    }

    public String getSpiderName() {
        return spiderName;
    }

    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName;
    }

    public String getSpiderPhoto() {
        return spiderPhoto;
    }

    public void setSpiderPhoto(String spiderPhoto) {
        this.spiderPhoto = spiderPhoto;
    }

    public Integer getSpiderSample() {
        return spiderSample;
    }

    public void setSpiderSample(Integer spiderSample) {
        this.spiderSample = spiderSample;
    }

    public String getSpiderDetails() {
        return spiderDetails;
    }

    public void setSpiderDetails(String spiderDetails) {
        this.spiderDetails = spiderDetails;
    }

    @Override
    public String toString() {
        return "Spider{" +
                "spiderId=" + spiderId +
                ", spiderName='" + spiderName + '\'' +
                ", spiderPhoto='" + spiderPhoto + '\'' +
                ", spiderSample=" + spiderSample +
                ", spiderDetails='" + spiderDetails + '\'' +
                '}';
    }
}
