package com.example.energiebedarf;

public class SettingMemo  {
    private long id;

    private String gender;
    private String activity;
    private String temperature;
    private String illness;
    private String eggwhite;
    private String liquid;
    private String activitychecked;
    private String temperaturechecked;
    private String illnesschecked;
    private String eggwhitechecked;
    private String liquidchecked;
    private String wight;
    private String high;
    private String bmivalue;
    private String energyvalue;
    private String liquidvalue;
    private String eggwhitevalue;
    private String guvalue;
    private String behindguvalue;

    public SettingMemo(long id, String gender, String activity, String temperature, String illness, String eggwhite,
                       String liquid, String activitychecked, String temperaturechecked, String illnesschecked,
                       String eggwhitechecked, String liquidchecked ,String wight, String high, String bmivalue,
                       String energyvalue, String liquidvalue, String eggwhitevalue, String guvalue, String behindguvalue) {

        this.gender = gender;
        this.activity = activity;
        this.temperature = temperature;
        this.illness = illness;
        this.eggwhite = eggwhite;
        this.id = id;
        this.liquid = liquid;
        this.activitychecked = activitychecked;
        this.temperaturechecked = temperaturechecked;
        this.illnesschecked = illnesschecked;
        this.eggwhitechecked = eggwhitechecked;
        this.liquidchecked = liquidchecked;
        this.wight = wight;
        this.high = high;
        this.bmivalue = bmivalue;
        this.energyvalue = energyvalue;
        this.liquidvalue = liquidvalue;
        this.eggwhitevalue = eggwhitevalue;
        this.guvalue = guvalue;
        this.behindguvalue = behindguvalue;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getEggwhite() {
        return eggwhite;
    }

    public void setEggwhite(String eggwhite) {
        this.eggwhite = eggwhite;
    }

    public String getLiquid() {
        return liquid;
    }

    public void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    public String getActivitychecked() {
        return activitychecked;
    }

    public void setActivitychecked(String activitychecked) {
        this.activitychecked = activitychecked;
    }

    public String getTemperaturechecked() {
        return temperaturechecked;
    }

    public void setTemperaturechecked(String temperaturechecked) {
        this.temperaturechecked = temperaturechecked;
    }

    public String getIllnesschecked() {
        return illnesschecked;
    }

    public void setIllnesschecked(String illnesschecked) {
        this.illnesschecked = illnesschecked;
    }

    public String getEggwhitechecked() {
        return eggwhitechecked;
    }

    public void setEggwhitechecked(String eggwhitechecked) {
        this.eggwhitechecked = eggwhitechecked;
    }

    public String getLiquidchecked() {
        return liquidchecked;
    }

    public void setLiquidchecked(String liquidchecked) {
        this.liquidchecked = liquidchecked;
    }

    public String getWight() {
        return wight;
    }

    public void setWight(String wight) {
        this.wight = wight;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getBmivalue() {
        return bmivalue;
    }

    public void setBmivalue(String bmivalue) {
        this.bmivalue = bmivalue;
    }

    public String getEnergyvalue() {
        return energyvalue;
    }

    public void setEnergyvalue(String energyvalue) {
        this.energyvalue = energyvalue;
    }

    public String getLiquidvalue() {
        return liquidvalue;
    }

    public void setLiquidvalue(String liquidvalue) {
        this.liquidvalue = liquidvalue;
    }

    public String getEggwhitevalue() {
        return eggwhitevalue;
    }

    public void setEggwhitevalue(String eggwhitevalue) {
        this.eggwhitevalue = eggwhitevalue;
    }

    public String getGuvalue() {
        return guvalue;
    }

    public void setGuvalue(String guvalue) {
        this.guvalue = guvalue;
    }

    public String getBehindguvalue() {
        return behindguvalue;
    }

    public void setBehindguvalue(String behindguvalue) {
        this.behindguvalue = behindguvalue;
    }

}

