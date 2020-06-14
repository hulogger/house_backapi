package com.team.house_backapi.domain;

import com.team.house_backapi.util.PageParmeter;

public class HouseCondition extends PageParmeter {
    private String title;
    private String price;
    private Integer districtid;
    private Integer streetid;
    private Integer typeid;
    private String floorage;
    private Integer startFloorage;
    private Integer endFloorage;
    private Long startPrice;
    private Long endPrice;

    public Integer getStartFloorage() {
        return startFloorage;
    }

    public void setStartFloorage(Integer startFloorage) {
        this.startFloorage = startFloorage;
    }

    public Integer getEndFloorage() {
        return endFloorage;
    }

    public void setEndFloorage(Integer endFloorage) {
        this.endFloorage = endFloorage;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Long endPrice) {
        this.endPrice = endPrice;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getStreetid() {
        return streetid;
    }

    public void setStreetid(Integer streetid) {
        this.streetid = streetid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getFloorage() {
        return floorage;
    }

    public void setFloorage(String floorage) {
        this.floorage = floorage;
    }

    @Override
    public String toString() {
        return "HouseCondition{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", districtid='" + districtid + '\'' +
                ", streetid='" + streetid + '\'' +
                ", typeid='" + typeid + '\'' +
                ", floorage='" + floorage + '\'' +
                '}';
    }
}
