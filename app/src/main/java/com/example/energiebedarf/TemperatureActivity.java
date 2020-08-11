package com.example.energiebedarf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TemperatureActivity extends AppCompatActivity {

    RadioGroup radiogroupetemperature;
    RadioButton firsttemperature, secondtemperature, thirdtemperature, fourthtemperature, fifthtemperature;
    Button savetemperature;

    boolean isUpdated;

    String temperature;

    public static SettingDataSource dataSourceSetting;
    public static SettingDbHelper settingDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        dataSourceSetting = new SettingDataSource(this);
        settingDbHelper = new SettingDbHelper(this);

        radiogroupetemperature = (RadioGroup) findViewById(R.id.radiogroupetemperature);

        firsttemperature = (RadioButton) findViewById(R.id.firsttemperature);
        secondtemperature = (RadioButton) findViewById(R.id.secondtemperature);
        thirdtemperature = (RadioButton) findViewById(R.id.thirdtemperature);
        fourthtemperature = (RadioButton) findViewById(R.id.fourthtemperature);
        fifthtemperature = (RadioButton) findViewById(R.id.fifthtemperature);

        savetemperature = (Button) findViewById(R.id.savetemperature);

        Toolbar toolbartemperature = (Toolbar) findViewById(R.id.toolbartemperature);
        setSupportActionBar(toolbartemperature);

        toolbartemperature.setTitleTextColor(getResources().getColor(android.R.color.darker_gray));
        toolbartemperature.setSubtitleTextColor(getResources().getColor(android.R.color.darker_gray));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Energiebedarf");
        getSupportActionBar().setSubtitle("Temperaturfaktor");

        if (ParameterClass.temperature.equals("1")) {
            firsttemperature.setChecked(true);
            secondtemperature.setChecked(false);
            thirdtemperature.setChecked(false);
            fourthtemperature.setChecked(false);
            fifthtemperature.setChecked(false);
        } else if (ParameterClass.temperature.equals("1.1")) {
            firsttemperature.setChecked(false);
            secondtemperature.setChecked(true);
            thirdtemperature.setChecked(false);
            fourthtemperature.setChecked(false);
            fifthtemperature.setChecked(false);
        } else if (ParameterClass.temperature.equals("1.2")) {
            firsttemperature.setChecked(false);
            secondtemperature.setChecked(false);
            thirdtemperature.setChecked(true);
            fourthtemperature.setChecked(false);
            fifthtemperature.setChecked(false);
        } else if (ParameterClass.temperature.equals("1.3")) {
            firsttemperature.setChecked(false);
            secondtemperature.setChecked(false);
            thirdtemperature.setChecked(false);
            fourthtemperature.setChecked(true);
            fifthtemperature.setChecked(false);
        } else if (ParameterClass.temperature.equals("1.4")) {
            firsttemperature.setChecked(false);
            secondtemperature.setChecked(false);
            thirdtemperature.setChecked(false);
            fourthtemperature.setChecked(false);
            fifthtemperature.setChecked(true);}
    }

    public void onClickTemperature(View v) {
        switch (v.getId()) {
            case R.id.savetemperature: {

                int radioButtonID = radiogroupetemperature.getCheckedRadioButtonId();
                View radioButton = radiogroupetemperature.findViewById(radioButtonID);
                int idx = radiogroupetemperature.indexOfChild(radioButton);

                if (idx == 0){
                    temperature = "1";
                } else if (idx == 1){
                    temperature = "1.1";
                } else if (idx == 2){
                    temperature = "1.2";
                } else if (idx == 3){
                    temperature = "1.3";
                } else if (idx == 4){
                    temperature = "1.4";
                }

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                        ParameterClass.activity, temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                Intent IntentSettings = new Intent(TemperatureActivity.this, MainActivity.class);
                startActivity(IntentSettings);

                break;
            }
        }
    }

    @Override
    public void onBackPressed(){

        int radioButtonID = radiogroupetemperature.getCheckedRadioButtonId();
        View radioButton = radiogroupetemperature.findViewById(radioButtonID);
        int idx = radiogroupetemperature.indexOfChild(radioButton);

        if (idx == 0){
            temperature = "1";
        } else if (idx == 1){
            temperature = "1.1";
        } else if (idx == 2){
            temperature = "1.2";
        } else if (idx == 3){
            temperature = "1.3";
        } else if (idx == 4){
            temperature = "1.4";
        }

        dataSourceSetting.open();
        isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                ParameterClass.activity, temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
        dataSourceSetting.close();

        finish();

        Intent IntentSettings = new Intent(TemperatureActivity.this, MainActivity.class);
        startActivity(IntentSettings);
    }
}