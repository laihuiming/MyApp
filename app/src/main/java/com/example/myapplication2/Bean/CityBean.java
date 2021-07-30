package com.example.myapplication2.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityBean {

    @SerializedName("province")
    private String province;
    @SerializedName("city_list")
    private List<String> cityList;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }
}
