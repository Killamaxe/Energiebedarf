package com.example.energiebedarf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;

import com.google.android.material.appbar.AppBarLayout;

import butterknife.internal.Utils;

import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener {

    RadioGroup radiogroupe;
    RadioButton woman, man;
    CheckBox activity, temperatur, illness, eggwhite, liquid;
    EditText wight, high;
    MenuItem action_activity, action_temperatur, action_illness, action_eggwhite, action_liquid;
    TextView bmitext2, energytext, bmifield2, energyfield, liquidtext2, eggwhitetext, liquidfield2, eggwhitefield, guvalue, behindguvalue;
    Button calculat;
    LinearLayout bmitext, bmifield;

    boolean isUpdated;

    public static SettingDataSource dataSourceSetting;
    public static SettingDbHelper settingDbHelper;

    Intent IntentSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSourceSetting = new SettingDataSource(this);
        settingDbHelper = new SettingDbHelper(this);

        radiogroupe = (RadioGroup) findViewById(R.id.radiogroupe);
        woman = (RadioButton) findViewById(R.id.woman);
        man = (RadioButton) findViewById(R.id.man);

        activity = (CheckBox) findViewById(R.id.activity);
        temperatur = (CheckBox) findViewById(R.id.temperatur);
        illness = (CheckBox) findViewById(R.id.illness);
        eggwhite = (CheckBox) findViewById(R.id.eggwhite);
        liquid = (CheckBox) findViewById(R.id.liquid);

        wight = (EditText) findViewById(R.id.wight);
        high = (EditText) findViewById(R.id.high);

        bmitext2 = (TextView) findViewById(R.id.bmitext2);
        energytext = (TextView) findViewById(R.id.energytext);
        bmifield2 = (TextView) findViewById(R.id.bmifield2);
        energyfield = (TextView) findViewById(R.id.energyfield);
        liquidtext2 = (TextView) findViewById(R.id.liquidtext2);
        eggwhitetext = (TextView) findViewById(R.id.eggwhitetext);
        liquidfield2 = (TextView) findViewById(R.id.liquidfield2);
        eggwhitefield = (TextView) findViewById(R.id.eggwhitefield);
        guvalue = (TextView) findViewById(R.id.guvalue);
        behindguvalue = (TextView) findViewById(R.id.behindguvalue);

        calculat = (Button) findViewById(R.id.calculat);

        bmitext = (LinearLayout) findViewById(R.id.bmitext);
        bmifield = (LinearLayout) findViewById(R.id.bmifield);

        Toolbar toolbarmain = (Toolbar) findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbarmain);

        toolbarmain.setTitleTextColor(getResources().getColor(android.R.color.darker_gray));
        toolbarmain.setSubtitleTextColor(getResources().getColor(android.R.color.darker_gray));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Energiebedarf");
        getSupportActionBar().setSubtitle("Berechnen");

        getSetting("1");

        try {
            if (ParameterClass.gender.equals("null") == true || ParameterClass.gender.isEmpty() == true) {
            }
        } catch (Exception e){

            dataSourceSetting.open();

            SettingMemo settingMemo = dataSourceSetting.createSettingMemo("1", "0",
                    "1", "1", "1", "1", "0", "0",
                    "0","0", "0", "80", "180",
                    "24", "1500", "2200", "53",
                    "1258", "1.2");

            dataSourceSetting.close();

        }

        getSetting("1");

        if (ParameterClass.gender.equals("0") == true) {
            woman.setChecked(true);
            man.setChecked(false);
        } else {
            woman.setChecked(false);
            man.setChecked(true);        }

        wight.setText(ParameterClass.wight);
        high.setText(ParameterClass.high);

        if (ParameterClass.activitychecked.equals("0") == true){

            activity.setChecked(false);

        } else {

            activity.setChecked(true);

        }

        if (ParameterClass.temperaturechecked.equals("0") == true){

            temperatur.setChecked(false);

        } else {

            temperatur.setChecked(true);

        }

        if (ParameterClass.illnesschecked.equals("0") == true){

            illness.setChecked(false);

        } else {

            illness.setChecked(true);

        }

        if (ParameterClass.eggwhitechecked.equals("0") == true){

            eggwhite.setChecked(false);

        } else {

            eggwhite.setChecked(true);

        }

        if (ParameterClass.liquidchecked.equals("0") == true){

            liquid.setChecked(false);

        } else {

            liquid.setChecked(true);

        }

        bmifield2.setText(ParameterClass.bmivalue);
        energyfield.setText(ParameterClass.energyvalue);
        liquidfield2.setText(ParameterClass.liquidvalue);
        eggwhitefield.setText(ParameterClass.eggwhitevalue);
        guvalue.setText(ParameterClass.guvalue);
        behindguvalue.setText(ParameterClass.behindguvalue);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_energy, menu);
        action_activity = menu.findItem(R.id.action_activity);
        action_temperatur = menu.findItem(R.id.action_temperatur);
        action_illness = menu.findItem(R.id.action_illness);
        action_eggwhite = menu.findItem(R.id.action_eggwhite);
        action_liquid = menu.findItem(R.id.action_liquid);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_activity:

                int radioButtonID = radiogroupe.getCheckedRadioButtonId();
                View radioButton = radiogroupe.findViewById(radioButtonID);
                int idx = radiogroupe.indexOfChild(radioButton);


                ParameterClass.gender = Integer.toString(idx);
                ParameterClass.high = high.getText().toString();
                ParameterClass.wight = wight.getText().toString();

                if (activity.isChecked() == true){
                    ParameterClass.activitychecked = "1";
                } else {
                    ParameterClass.activitychecked = "0";
                }

                if (temperatur.isChecked() == true){
                    ParameterClass.temperaturechecked = "1";
                } else {
                    ParameterClass.temperaturechecked = "0";
                }

                if (illness.isChecked() == true){
                    ParameterClass.illnesschecked = "1";
                } else {
                    ParameterClass.illnesschecked = "0";
                }

                if (eggwhite.isChecked() == true){
                    ParameterClass.eggwhitechecked = "1";
                } else {
                    ParameterClass.eggwhitechecked = "0";
                }

                if (liquid.isChecked() == true){
                    ParameterClass.liquidchecked = "1";
                } else {
                    ParameterClass.liquidchecked = "0";
                }


                ParameterClass.bmivalue = bmifield2.getText().toString();
                ParameterClass.energyvalue = energyfield.getText().toString();
                ParameterClass.liquidvalue = liquidfield2.getText().toString();
                ParameterClass.eggwhitevalue = eggwhitefield.getText().toString();

                ParameterClass.guvalue = guvalue.getText().toString();
                ParameterClass.behindguvalue = behindguvalue.getText().toString();

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, ParameterClass.activity,
                        ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                IntentSettings = new Intent(MainActivity.this, ActivityActivity.class);
                startActivity(IntentSettings);

                break;

            case R.id.action_temperatur:

                int radioButtonIDTemp = radiogroupe.getCheckedRadioButtonId();
                View radioButtonTemp = radiogroupe.findViewById(radioButtonIDTemp);
                int idxTemp = radiogroupe.indexOfChild(radioButtonTemp);


                ParameterClass.gender = Integer.toString(idxTemp);
                ParameterClass.high = high.getText().toString();
                ParameterClass.wight = wight.getText().toString();

                if (activity.isChecked() == true){
                    ParameterClass.activitychecked = "1";
                } else {
                    ParameterClass.activitychecked = "0";
                }

                if (temperatur.isChecked() == true){
                    ParameterClass.temperaturechecked = "1";
                } else {
                    ParameterClass.temperaturechecked = "0";
                }

                if (illness.isChecked() == true){
                    ParameterClass.illnesschecked = "1";
                } else {
                    ParameterClass.illnesschecked = "0";
                }

                if (eggwhite.isChecked() == true){
                    ParameterClass.eggwhitechecked = "1";
                } else {
                    ParameterClass.eggwhitechecked = "0";
                }

                if (liquid.isChecked() == true){
                    ParameterClass.liquidchecked = "1";
                } else {
                    ParameterClass.liquidchecked = "0";
                }


                ParameterClass.bmivalue = bmifield2.getText().toString();
                ParameterClass.energyvalue = energyfield.getText().toString();
                ParameterClass.liquidvalue = liquidfield2.getText().toString();
                ParameterClass.eggwhitevalue = eggwhitefield.getText().toString();

                ParameterClass.guvalue = guvalue.getText().toString();
                ParameterClass.behindguvalue = behindguvalue.getText().toString();

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, ParameterClass.activity,
                        ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                IntentSettings = new Intent(MainActivity.this, TemperatureActivity.class);
                startActivity(IntentSettings);

                break;

            case R.id.action_illness:

                int radioButtonIDIll = radiogroupe.getCheckedRadioButtonId();
                View radioButtonIll = radiogroupe.findViewById(radioButtonIDIll);
                int idxIll = radiogroupe.indexOfChild(radioButtonIll);


                ParameterClass.gender = Integer.toString(idxIll);
                ParameterClass.high = high.getText().toString();
                ParameterClass.wight = wight.getText().toString();

                if (activity.isChecked() == true){
                    ParameterClass.activitychecked = "1";
                } else {
                    ParameterClass.activitychecked = "0";
                }

                if (temperatur.isChecked() == true){
                    ParameterClass.temperaturechecked = "1";
                } else {
                    ParameterClass.temperaturechecked = "0";
                }

                if (illness.isChecked() == true){
                    ParameterClass.illnesschecked = "1";
                } else {
                    ParameterClass.illnesschecked = "0";
                }

                if (eggwhite.isChecked() == true){
                    ParameterClass.eggwhitechecked = "1";
                } else {
                    ParameterClass.eggwhitechecked = "0";
                }

                if (liquid.isChecked() == true){
                    ParameterClass.liquidchecked = "1";
                } else {
                    ParameterClass.liquidchecked = "0";
                }


                ParameterClass.bmivalue = bmifield2.getText().toString();
                ParameterClass.energyvalue = energyfield.getText().toString();
                ParameterClass.liquidvalue = liquidfield2.getText().toString();
                ParameterClass.eggwhitevalue = eggwhitefield.getText().toString();

                ParameterClass.guvalue = guvalue.getText().toString();
                ParameterClass.behindguvalue = behindguvalue.getText().toString();

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, ParameterClass.activity,
                        ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                IntentSettings = new Intent(MainActivity.this, IllnessActivity.class);
                startActivity(IntentSettings);

                break;

            case R.id.action_eggwhite:

                int radioButtonIDEgg = radiogroupe.getCheckedRadioButtonId();
                View radioButtonEgg = radiogroupe.findViewById(radioButtonIDEgg);
                int idxEgg = radiogroupe.indexOfChild(radioButtonEgg);


                ParameterClass.gender = Integer.toString(idxEgg);
                ParameterClass.high = high.getText().toString();
                ParameterClass.wight = wight.getText().toString();

                if (activity.isChecked() == true){
                    ParameterClass.activitychecked = "1";
                } else {
                    ParameterClass.activitychecked = "0";
                }

                if (temperatur.isChecked() == true){
                    ParameterClass.temperaturechecked = "1";
                } else {
                    ParameterClass.temperaturechecked = "0";
                }

                if (illness.isChecked() == true){
                    ParameterClass.illnesschecked = "1";
                } else {
                    ParameterClass.illnesschecked = "0";
                }

                if (eggwhite.isChecked() == true){
                    ParameterClass.eggwhitechecked = "1";
                } else {
                    ParameterClass.eggwhitechecked = "0";
                }

                if (liquid.isChecked() == true){
                    ParameterClass.liquidchecked = "1";
                } else {
                    ParameterClass.liquidchecked = "0";
                }


                ParameterClass.bmivalue = bmifield2.getText().toString();
                ParameterClass.energyvalue = energyfield.getText().toString();
                ParameterClass.liquidvalue = liquidfield2.getText().toString();
                ParameterClass.eggwhitevalue = eggwhitefield.getText().toString();

                ParameterClass.guvalue = guvalue.getText().toString();
                ParameterClass.behindguvalue = behindguvalue.getText().toString();

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, ParameterClass.activity,
                        ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                IntentSettings = new Intent(MainActivity.this, EggwhiteActivity.class);
                startActivity(IntentSettings);

                break;

            case R.id.action_liquid:

                int radioButtonIDLiqu = radiogroupe.getCheckedRadioButtonId();
                View radioButtonLiqu = radiogroupe.findViewById(radioButtonIDLiqu);
                int idxLiqu = radiogroupe.indexOfChild(radioButtonLiqu);

                ParameterClass.gender = Integer.toString(idxLiqu);
                ParameterClass.high = high.getText().toString();
                ParameterClass.wight = wight.getText().toString();

                if (activity.isChecked() == true){
                    ParameterClass.activitychecked = "1";
                } else {
                    ParameterClass.activitychecked = "0";
                }

                if (temperatur.isChecked() == true){
                    ParameterClass.temperaturechecked = "1";
                } else {
                    ParameterClass.temperaturechecked = "0";
                }

                if (illness.isChecked() == true){
                    ParameterClass.illnesschecked = "1";
                } else {
                    ParameterClass.illnesschecked = "0";
                }

                if (eggwhite.isChecked() == true){
                    ParameterClass.eggwhitechecked = "1";
                } else {
                    ParameterClass.eggwhitechecked = "0";
                }

                if (liquid.isChecked() == true){
                    ParameterClass.liquidchecked = "1";
                } else {
                    ParameterClass.liquidchecked = "0";
                }


                ParameterClass.bmivalue = bmifield2.getText().toString();
                ParameterClass.energyvalue = energyfield.getText().toString();
                ParameterClass.liquidvalue = liquidfield2.getText().toString();
                ParameterClass.eggwhitevalue = eggwhitefield.getText().toString();

                ParameterClass.guvalue = guvalue.getText().toString();
                ParameterClass.behindguvalue = behindguvalue.getText().toString();

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, ParameterClass.activity,
                        ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                finish();

                IntentSettings = new Intent(MainActivity.this, LiquidActivity.class);
                startActivity(IntentSettings);

                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public static void getSetting(String searchTerm) {
        dataSourceSetting.open();

        Cursor loginc = dataSourceSetting.retrieve(searchTerm);
        while (loginc.moveToNext()) {
            ParameterClass.gender = loginc.getString(1);
            ParameterClass.activity = loginc.getString(2);
            ParameterClass.temperature = loginc.getString(3);
            ParameterClass.illness = loginc.getString(4);
            ParameterClass.eggwhite = loginc.getString(5);
            ParameterClass.liquid = loginc.getString(6);
            ParameterClass.activitychecked = loginc.getString(7);
            ParameterClass.temperaturechecked = loginc.getString(8);
            ParameterClass.illnesschecked = loginc.getString(9);
            ParameterClass.eggwhitechecked = loginc.getString(10);
            ParameterClass.liquidchecked = loginc.getString(11);
            ParameterClass.wight = loginc.getString(12);
            ParameterClass.high = loginc.getString(13);
            ParameterClass.bmivalue = loginc.getString(14);
            ParameterClass.energyvalue = loginc.getString(15);
            ParameterClass.liquidvalue = loginc.getString(16);
            ParameterClass.eggwhitevalue = loginc.getString(17);
            ParameterClass.guvalue = loginc.getString(18);
            ParameterClass.behindguvalue = loginc.getString(19);
        }
        dataSourceSetting.close();
    }

    public void onClickMain(View v) {
        switch (v.getId()) {
            case R.id.calculat: {

                double bmi, energy, liquidvalue, eggwhitevalue, gu, behindgu, wightvalue, highvalue;

                if (!wight.getText().toString().isEmpty() && !high.getText().toString().isEmpty()) {

                    wightvalue = Double.parseDouble(String.valueOf(wight.getText()));
                    ParameterClass.wight = Double.toString(wightvalue);

                    highvalue = Double.parseDouble(String.valueOf(high.getText()));
                    ParameterClass.high = Double.toString(highvalue);

                    if (liquid.isChecked() == true) {

                        if (ParameterClass.liquid.equals("1.8")) {

                            liquidvalue = round(((Double.parseDouble(String.valueOf(wight.getText())) - 20) * 15 + 1500 * Double.parseDouble("0.8")), 2);

                        } else {
                            liquidvalue = round(((Double.parseDouble(String.valueOf(wight.getText())) - 20) * 15 + 1500 * Double.parseDouble(ParameterClass.liquid)), 2);
                        }

                        liquidfield2.setText(Double.toString(liquidvalue));
                        ParameterClass.liquidvalue = Double.toString(liquidvalue);
                    } else {
                        liquidvalue = 0;
                        liquidfield2.setText(Double.toString(liquidvalue));
                        ParameterClass.liquidvalue = Double.toString(liquidvalue);
                    }

                    bmi = round(wightvalue / ((highvalue / 100) * (highvalue / 100)), 2);

                    bmifield2.setText(Double.toString(bmi));
                    ParameterClass.bmivalue = Double.toString(bmi);

                    if (eggwhite.isChecked() == true) {

                        eggwhitevalue = round(Double.parseDouble(String.valueOf(wight.getText())) * Double.parseDouble(ParameterClass.eggwhite), 2);

                        eggwhitefield.setText(Double.toString(eggwhitevalue));
                        ParameterClass.eggwhitevalue = Double.toString(eggwhitevalue);
                    } else {
                        eggwhitevalue = 0;
                        eggwhitefield.setText(Double.toString(eggwhitevalue));
                        ParameterClass.eggwhitevalue = Double.toString(eggwhitevalue);
                    }
                }

                int radioButtonIDcalc = radiogroupe.getCheckedRadioButtonId();
                View radioButtoncalc = radiogroupe.findViewById(radioButtonIDcalc);
                int idxcalc = radiogroupe.indexOfChild(radioButtoncalc);

                ParameterClass.gender = Integer.toString(idxcalc);

                if (ParameterClass.gender.equals("0") == true) {
                    gu = (0.0377 * Double.parseDouble(String.valueOf(wight.getText()))+2.75) * 239;
                    double gu2 = round(gu, 2);

                    guvalue.setText(Double.toString(gu2));
                    ParameterClass.guvalue = Double.toString(gu2);

                } else {
                    gu = (0.0491 * Double.parseDouble(String.valueOf(wight.getText()))+2.46) * 239;
                    double gu2 = round(gu, 2);

                    guvalue.setText(Double.toString(gu2));
                    ParameterClass.guvalue = Double.toString(gu2);
                }

                getSetting("1");

                if (activity.isChecked() == true && illness.isChecked() == true && temperatur.isChecked() == true){

                    energy = round (gu * Double.parseDouble(ParameterClass.activity) * Double.parseDouble(ParameterClass.illness) *
                            Double.parseDouble(ParameterClass.temperature), 2);

                    energyfield.setText(Double.toString(energy));
                    ParameterClass.energyvalue = Double.toString(energy);

                } else {
                    energy = 0;
                    energyfield.setText(Double.toString(energy));
                    ParameterClass.energyvalue = Double.toString(energy);
                }

                if (activity.isChecked() == true && illness.isChecked() == true && temperatur.isChecked() == true) {

                    behindgu = round(Double.parseDouble(ParameterClass.activity) * Double.parseDouble(ParameterClass.illness) *
                            Double.parseDouble(ParameterClass.temperature), 2);

                    behindguvalue.setText(Double.toString(behindgu));
                    ParameterClass.behindguvalue = Double.toString(behindgu);

                } else {
                    behindgu = 0;
                    behindguvalue.setText(Double.toString(behindgu));
                    ParameterClass.behindguvalue = Double.toString(behindgu);
                }

                if (activity.isChecked() == true){
                    ParameterClass.activitychecked = "1";
                } else {
                    ParameterClass.activitychecked = "0";
                }

                if (temperatur.isChecked() == true){
                    ParameterClass.temperaturechecked = "1";
                } else {
                    ParameterClass.temperaturechecked = "0";
                }

                if (illness.isChecked() == true){
                    ParameterClass.illnesschecked = "1";
                } else {
                    ParameterClass.illnesschecked = "0";
                }

                if (eggwhite.isChecked() == true){
                    ParameterClass.eggwhitechecked = "1";
                } else {
                    ParameterClass.eggwhitechecked = "0";
                }

                if (liquid.isChecked() == true){
                    ParameterClass.liquidchecked = "1";
                } else {
                    ParameterClass.liquidchecked = "0";
                }

                dataSourceSetting.open();
                isUpdated = settingDbHelper.updateSettingMemo("1", ParameterClass.gender, ParameterClass.activity,
                        ParameterClass.temperature, ParameterClass.illness, ParameterClass.eggwhite, ParameterClass.liquid,
                        ParameterClass.activitychecked, ParameterClass.temperaturechecked, ParameterClass.illnesschecked,
                        ParameterClass.eggwhitechecked, ParameterClass.liquidchecked, ParameterClass.wight, ParameterClass.high,
                        ParameterClass.bmivalue, ParameterClass.energyvalue, ParameterClass.liquidvalue,
                        ParameterClass.eggwhitevalue, ParameterClass.guvalue, ParameterClass.behindguvalue);
                dataSourceSetting.close();

                break;
            }
        }
    }

    private double round(double value, int i) {
        if (i < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, i);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}