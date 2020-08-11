package com.example.energiebedarf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IllnessActivity extends AppCompatActivity {

    RadioGroup radiogroupeillness;
    RadioButton firstillness, secondillness, thirdillness, fourthillness, fifthillness, sixillness;
    Button saveillness;

    boolean isUpdated;

    String illness;

    public static SettingDataSource dataSourceSetting;
    public static SettingDbHelper settingDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness);

        dataSourceSetting = new SettingDataSource(this);
        settingDbHelper = new SettingDbHelper(this);

        radiogroupeillness = (RadioGroup) findViewById(R.id.radiogroupeillness);

        firstillness = (RadioButton) findViewById(R.id.firstillness);
        secondillness = (RadioButton) findViewById(R.id.secondillness);
        thirdillness = (RadioButton) findViewById(R.id.thirdillness);
        fourthillness = (RadioButton) findViewById(R.id.fourthillness);
        fifthillness = (RadioButton) findViewById(R.id.fifthillness);
        sixillness = (RadioButton) findViewById(R.id.sixillness);

        saveillness = (Button) findViewById(R.id.saveillness);

        Toolbar toolbarillness = (Toolbar) findViewById(R.id.toolbarillness);
        setSupportActionBar(toolbarillness);

        toolbarillness.setTitleTextColor(getResources().getColor(android.R.color.darker_gray));
        toolbarillness.setSubtitleTextColor(getResources().getColor(android.R.color.darker_gray));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Energiebedarf");
        getSupportActionBar().setSubtitle("Krankheitsfaktor");

        if (ParameterClass.illness.equals("0.9")) {
            firstillness.setChecked(true);
            secondillness.setChecked(false);
            thirdillness.setChecked(false);
            fourthillness.setChecked(false);
            fifthillness.setChecked(false);
            sixillness.setChecked(false);
        } else if (ParameterClass.illness.equals("1")) {
            firstillness.setChecked(false);
            secondillness.setChecked(true);
            thirdillness.setChecked(false);
            fourthillness.setChecked(false);
            fifthillness.setChecked(false);
            sixillness.setChecked(false);
        } else if (ParameterClass.illness.equals("1.3")) {
            firstillness.setChecked(false);
            secondillness.setChecked(false);
            thirdillness.setChecked(true);
            fourthillness.setChecked(false);
            fifthillness.setChecked(false);
            sixillness.setChecked(false);
        } else if (ParameterClass.illness.equals("1.4")) {
            firstillness.setChecked(false);
            secondillness.setChecked(false);
            thirdillness.setChecked(false);
            fourthillness.setChecked(true);
            fifthillness.setChecked(false);
            sixillness.setChecked(false);
        } else if (ParameterClass.illness.equals("1.5")) {
            firstillness.setChecked(false);
            secondillness.setChecked(false);
            thirdillness.setChecked(false);
            fourthillness.setChecked(false);
            fifthillness.setChecked(true);
            sixillness.setChecked(false);
        } else if (ParameterClass.illness.equals("1.7")) {
            firstillness.setChecked(false);
            secondillness.setChecked(false);
            thirdillness.setChecked(false);
            fourthillness.setChecked(false);
            fifthillness.setChecked(false);
            sixillness.setChecked(true);
        }
    }

    public void onClickIllness(View v) {
        switch (v.getId()) {
            case R.id.saveillness: {

                int radioButtonID = radiogroupeillness.getCheckedRadioButtonId();
                View radioButton = radiogroupeillness.findViewById(radioButtonID);
                int idx = radiogroupeillness.indexOfChild(radioButton);

                if (idx == 0){
                    illness = "0.9";
                } else if (idx == 1){
                    illness = "1";
                } else if (idx == 2){
                    illness = "1.3";
                } else if (idx == 3){
                    illness = "1.4";
                } else if (idx == 4){
                    illness = "1.5";
                } else if (idx == 5){
                    illness = "1.7";
                }

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                        ParameterClass.activity, ParameterClass.temperature, illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                Intent IntentSettings = new Intent(IllnessActivity.this, MainActivity.class);
                startActivity(IntentSettings);

                break;
            }
        }
    }

    @Override
    public void onBackPressed(){

        int radioButtonID = radiogroupeillness.getCheckedRadioButtonId();
        View radioButton = radiogroupeillness.findViewById(radioButtonID);
        int idx = radiogroupeillness.indexOfChild(radioButton);

        if (idx == 0){
            illness = "0.9";
        } else if (idx == 1){
            illness = "1";
        } else if (idx == 2){
            illness = "1.3";
        } else if (idx == 3){
            illness = "1.4";
        } else if (idx == 4){
            illness = "1.5";
        } else if (idx == 5){
            illness = "1.7";
        }

        dataSourceSetting.open();
        isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender,
                ParameterClass.activity, ParameterClass.temperature, illness, ParameterClass.eggwhite, ParameterClass.liquid,
                ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
        dataSourceSetting.close();

        finish();

        Intent IntentSettings = new Intent(IllnessActivity.this, MainActivity.class);
        startActivity(IntentSettings);
    }
}