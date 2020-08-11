package com.example.energiebedarf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class EggwhiteActivity extends AppCompatActivity {

    RadioGroup radiogroupeeggwhite;
    RadioButton firsteggwhite, secondeggwhite, thirdeggwhite;
    Button saveeggwhite;

    boolean isUpdated;

    String eggwhite;

    public static SettingDataSource dataSourceSetting;
    public static SettingDbHelper settingDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eggwhite);

        dataSourceSetting = new SettingDataSource(this);
        settingDbHelper = new SettingDbHelper(this);

        radiogroupeeggwhite = (RadioGroup) findViewById(R.id.radiogroupeeggwhite);

        firsteggwhite = (RadioButton) findViewById(R.id.firsteggwhite);
        secondeggwhite = (RadioButton) findViewById(R.id.secondeggwhite);
        thirdeggwhite = (RadioButton) findViewById(R.id.thirdeggwhite);

        saveeggwhite = (Button) findViewById(R.id.saveeggwhite);

        Toolbar toolbareggwhite = (Toolbar) findViewById(R.id.toolbareggwhite);
        setSupportActionBar(toolbareggwhite);

        toolbareggwhite.setTitleTextColor(getResources().getColor(android.R.color.darker_gray));
        toolbareggwhite.setSubtitleTextColor(getResources().getColor(android.R.color.darker_gray));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Energiebedarf");
        getSupportActionBar().setSubtitle("Eiweißfaktor");

        if (ParameterClass.eggwhite.equals("0.8")) {
            firsteggwhite.setChecked(true);
            secondeggwhite.setChecked(false);
            thirdeggwhite.setChecked(false);

        } else if (ParameterClass.eggwhite.equals("1")) {
            firsteggwhite.setChecked(true);
            secondeggwhite.setChecked(false);
            thirdeggwhite.setChecked(false);
        } else if (ParameterClass.eggwhite.equals("1.4")) {
            firsteggwhite.setChecked(true);
            secondeggwhite.setChecked(false);
            thirdeggwhite.setChecked(false);
        }
    }

    public void onClickEggwhite(View v) {
        switch (v.getId()) {
            case R.id.saveeggwhite: {

                int radioButtonID = radiogroupeeggwhite.getCheckedRadioButtonId();
                View radioButton = radiogroupeeggwhite.findViewById(radioButtonID);
                int idx = radiogroupeeggwhite.indexOfChild(radioButton);

                if (idx == 0){
                    eggwhite = "0.8";
                } else if (idx == 1){
                    eggwhite = "1";
                } else if (idx == 2){
                    eggwhite = "1.4";
                }

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                        ParameterClass.activity, ParameterClass.temperature, ParameterClass.illness, eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                Intent IntentSettings = new Intent(EggwhiteActivity.this, MainActivity.class);
                startActivity(IntentSettings);

                break;
            }
        }
    }

    @Override
    public void onBackPressed(){

        int radioButtonID = radiogroupeeggwhite.getCheckedRadioButtonId();
        View radioButton = radiogroupeeggwhite.findViewById(radioButtonID);
        int idx = radiogroupeeggwhite.indexOfChild(radioButton);

        if (idx == 0){
            eggwhite = "0.8";
        } else if (idx == 1){
            eggwhite = "1";
        } else if (idx == 2){
            eggwhite = "1.4";
        }

        dataSourceSetting.open();
        isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                ParameterClass.activity, ParameterClass.temperature, ParameterClass.illness, eggwhite, ParameterClass.liquid,
                ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
        dataSourceSetting.close();

        finish();

        Intent IntentSettings = new Intent(EggwhiteActivity.this, MainActivity.class);
        startActivity(IntentSettings);
    }
}