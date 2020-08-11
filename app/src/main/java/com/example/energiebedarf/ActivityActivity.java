package com.example.energiebedarf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityActivity extends AppCompatActivity {

    RadioGroup radiogroupeactivity;
    RadioButton firstactivity, secondactivity, thirdactivity;
    Button saveactivity;

    boolean isUpdated;

    String activity;

    public static SettingDataSource dataSourceSetting;
    public static SettingDbHelper settingDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        dataSourceSetting = new SettingDataSource(this);
        settingDbHelper = new SettingDbHelper(this);

        radiogroupeactivity = (RadioGroup) findViewById(R.id.radiogroupeactivity);

        firstactivity = (RadioButton) findViewById(R.id.firstactivity);
        secondactivity = (RadioButton) findViewById(R.id.secondactivity);
        thirdactivity = (RadioButton) findViewById(R.id.thirdactivity);

        saveactivity = (Button) findViewById(R.id.saveactivity);

        Toolbar toolbaractivity = (Toolbar) findViewById(R.id.toolbaractivity);
        setSupportActionBar(toolbaractivity);

        toolbaractivity.setTitleTextColor(getResources().getColor(android.R.color.darker_gray));
        toolbaractivity.setSubtitleTextColor(getResources().getColor(android.R.color.darker_gray));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Energiebedarf");
        getSupportActionBar().setSubtitle("Aktivitätsfaktor");

        if (ParameterClass.activity.equals("1.2")) {
            firstactivity.setChecked(true);
            secondactivity.setChecked(false);
            thirdactivity.setChecked(false);

        } else if (ParameterClass.activity.equals("1.5")) {
            firstactivity.setChecked(false);
            secondactivity.setChecked(true);
            thirdactivity.setChecked(false);
        } else if (ParameterClass.activity.equals("1.75")) {
            firstactivity.setChecked(false);
            secondactivity.setChecked(false);
            thirdactivity.setChecked(true);
        }
    }

    public void onClickActivity(View v) {
        switch (v.getId()) {
            case R.id.saveactivity: {

                int radioButtonID = radiogroupeactivity.getCheckedRadioButtonId();
                View radioButton = radiogroupeactivity.findViewById(radioButtonID);
                int idx = radiogroupeactivity.indexOfChild(radioButton);

                if (idx == 0){
                    activity = "1.2";
                } else if (idx == 1){
                    activity = "1.5";
                } else if (idx == 2){
                    activity = "1.75";
                }

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, activity,
                        ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                Intent IntentSettings = new Intent(ActivityActivity.this, MainActivity.class);
                startActivity(IntentSettings);

                break;
            }
        }
    }

    @Override
    public void onBackPressed(){

        int radioButtonID = radiogroupeactivity.getCheckedRadioButtonId();
        View radioButton = radiogroupeactivity.findViewById(radioButtonID);
        int idx = radiogroupeactivity.indexOfChild(radioButton);

        if (idx == 0){
            activity = "1.2";
        } else if (idx == 1){
            activity = "1.5";
        } else if (idx == 2){
            activity = "1.75";
        }

        dataSourceSetting.open();
        isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, activity,
                ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
        dataSourceSetting.close();

        finish();

        Intent IntentSettings = new Intent(ActivityActivity.this, MainActivity.class);
        startActivity(IntentSettings);
    }
}