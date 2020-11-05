package com.example.healthmate;

public class MainData {

    private int iv_profile;
    private String tv_name;
    private String tv_age;
    private String tv_sports;

    public MainData(int iv_profile, String tv_name, String tv_age, String tv_sports) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_age = tv_age;
        this.tv_sports = tv_sports;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_age() {
        return tv_age;
    }

    public void setTv_age(String tv_age) {
        this.tv_age = tv_age;
    }

    public String getTv_sports() {
        return tv_sports;
    }

    public void setTv_sports(String tv_sports) {
        this.tv_sports = tv_sports;
    }
}
