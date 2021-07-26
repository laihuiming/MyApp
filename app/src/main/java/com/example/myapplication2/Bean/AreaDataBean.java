package com.example.myapplication2.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaDataBean {
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public class CityBean {

        @SerializedName("name")
        private String name;
        @SerializedName("code")
        private String code;
        @SerializedName("city")
        private List<CityDTO> city;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<CityDTO> getCity() {
            return city;
        }

        public void setCity(List<CityDTO> city) {
            this.city = city;
        }
        class CityDTO {
            @SerializedName("name")
            private String name;
            @SerializedName("code")
            private String code;
            @SerializedName("area")
            private List<AreaDataBean> area;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public List<AreaDataBean> getArea() {
                return area;
            }

            public void setArea(List<AreaDataBean> area) {
                this.area = area;
            }
        }
    }
}
