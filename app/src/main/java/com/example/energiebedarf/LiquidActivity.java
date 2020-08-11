package com.example.energiebedarf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LiquidActivity extends AppCompatActivity {

    RadioGroup radiogroupeliquid;
    RadioButton firstliquid, secondliquid, thirdliquid, fourthliquid, fifthliquid;
    Button saveliquid;

    boolean isUpdated;

    String liquid;

    public static SettingDataSource dataSourceSetting;
    public static SettingDbHelper settingDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquid);

        dataSourceSetting = new SettingDataSource(this);
        settingDbHelper = new SettingDbHelper(this);

        radiogroupeliquid = (RadioGroup) findViewById(R.id.radiogroupeliquid);

        firstliquid = (RadioButton) findViewById(R.id.firstliquid);
        secondliquid = (RadioButton) findViewById(R.id.secondliquid);
        thirdliquid = (RadioButton) findViewById(R.id.thirdliquid);
        fourthliquid = (RadioButton) findViewById(R.id.fourthliquid);
        fifthliquid = (RadioButton) findViewById(R.id.fifthliquid);

        saveliquid = (Button) findViewById(R.id.saveillness);

        Toolbar toolbarliquid = (Toolbar) findViewById(R.id.toolbarliquid);
        setSupportActionBar(toolbarliquid);

        toolbarliquid.setTitleTextColor(getResources().getColor(android.R.color.darker_gray));
        toolbarliquid.setSubtitleTextColor(getResources().getColor(android.R.color.darker_gray));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Energiebedarf");
        getSupportActionBar().setSubtitle("Flüssigkeitsfaktor");

        if (ParameterClass.liquid.equals("1")) {
            firstliquid.setChecked(true);
            secondliquid.setChecked(false);
            thirdliquid.setChecked(false);
            fourthliquid.setChecked(false);
            fifthliquid.setChecked(false);
        } else if (ParameterClass.liquid.equals("1.2")) {
            firstliquid.setChecked(false);
            secondliquid.setChecked(true);
            thirdliquid.setChecked(false);
            fourthliquid.setChecked(false);
            fifthliquid.setChecked(false);
        } else if (ParameterClass.liquid.equals("1.3")) {
            firstliquid.setChecked(false);
            secondliquid.setChecked(false);
            thirdliquid.setChecked(true);
            fourthliquid.setChecked(false);
            fifthliquid.setChecked(false);
        } else if (ParameterClass.liquid.equals("0.8")) {
            firstliquid.setChecked(false);
            secondliquid.setChecked(false);
            thirdliquid.setChecked(false);
            fourthliquid.setChecked(true);
            fifthliquid.setChecked(false);
        } else if (ParameterClass.liquid.equals("1.8")) {
            firstliquid.setChecked(false);
            secondliquid.setChecked(false);
            thirdliquid.setChecked(false);
            fourthliquid.setChecked(false);
            fifthliquid.setChecked(true);
        }
    }

    public void onClickLiquid(View v) {
        switch (v.getId()) {
            case R.id.saveliquid: {

                int radioButtonID = radiogroupeliquid.getCheckedRadioButtonId();
                View radioButton = radiogroupeliquid.findViewById(radioButtonID);
                int idx = radiogroupeliquid.indexOfChild(radioButton);

                if (idx == 0){
                    liquid = "1";
                } else if (idx == 1){
                    liquid = "1.2";
                } else if (idx == 2){
                    liquid = "1.3";
                } else if (idx == 3){
                    liquid = "0.8";
                } else if (idx == 4){
                    liquid = "1.8";
                }

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                        ParameterClass.activity, ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                Intent IntentSettings = new Intent(LiquidActivity.this, MainActivity.class);
                startActivity(IntentSettings);

                break;
            }
        }
    }

    @Override
    public void onBackPressed(){

        int radioButtonID = radiogroupeliquid.getCheckedRadioButtonId();
        View radioButton = radiogroupeliquid.findViewById(radioButtonID);
        int idx = radiogroupeliquid.indexOfChild(radioButton);

        if (idx == 0){
            liquid = "1";
        } else if (idx == 1){
            liquid = "1.2";
        } else if (idx == 2){
            liquid = "1.3";
        } else if (idx == 3){
            liquid = "0.8";
        } else if (idx == 4){
            liquid = "1.8";
        }

        dataSourceSetting.open();
        isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                ParameterClass.activity, ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, liquid,
                ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
        dataSourceSetting.close();

        finish();

        Intent IntentSettings = new Intent(LiquidActivity.this, MainActivity.class);
        startActivity(IntentSettings);
    }

}