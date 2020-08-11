package com.example.energiebedarf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SettingDataSource{

    private static final String LOG_TAG = SettingDataSource.class.getSimpleName();

    SQLiteDatabase database;
    private SettingDbHelper dbHelper;

    private String[] columns = {
            SettingDbHelper.COLUMN_ID,
            SettingDbHelper.COLUMN_GENDER,
            SettingDbHelper.COLUMN_ACTIVITY,
            SettingDbHelper.COLUMN_TEMPERATURE,
            SettingDbHelper.COLUMN_ILLNESS,
            SettingDbHelper.COLUMN_EGGWHITE,
            SettingDbHelper.COLUMN_LIQUID,
            SettingDbHelper.COLUMN_WIGHT,
            SettingDbHelper.COLUMN_ACTIVITYCHECKED,
            SettingDbHelper.COLUMN_TEMPERATURECHECKED,
            SettingDbHelper.COLUMN_ILLNESSCHECKED,
            SettingDbHelper.COLUMN_EGGWHITECHECKED,
            SettingDbHelper.COLUMN_LIQUIDCHECKED,
            SettingDbHelper.COLUMN_HIGH,
            SettingDbHelper.COLUMN_BMIVALUE,
            SettingDbHelper.COLUMN_ENERGYVALUE,
            SettingDbHelper.COLUMN_LIQUIDVALUE,
            SettingDbHelper.COLUMN_EGGWHITEVALUE,
            SettingDbHelper.COLUMN_GUVALUE,
            SettingDbHelper.COLUMN_BEHINDGUVALUE
    };


    public SettingDataSource(Context context) {
        Log.d(LOG_TAG, "Unsere DataSource erzeugt jetzt den dbHelper.");
        dbHelper = new SettingDbHelper(context);
    }



    public void open() {
        Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close() {
        dbHelper.close();
        Log.d(LOG_TAG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
    }

    public SettingMemo createSettingMemo(String gender, String activity, String temperatur, String illness,
                                         String eggwhite, String liquid, String activitychecked, String temperaturechecked,
                                         String illnesschecked, String eggwhitechecked, String liquidchecked, String wight,
                                         String high, String bmivalue, String energyvalue, String liquidvalue,
                                         String eggwhitevalue, String guvalue, String behindguvalue) throws SQLException {

        ContentValues values = new ContentValues();
        values.put(SettingDbHelper.COLUMN_GENDER, gender);
        values.put(SettingDbHelper.COLUMN_ACTIVITY, activity);
        values.put(SettingDbHelper.COLUMN_TEMPERATURE, temperatur);
        values.put(SettingDbHelper.COLUMN_ILLNESS, illness);
        values.put(SettingDbHelper.COLUMN_EGGWHITE, eggwhite);
        values.put(SettingDbHelper.COLUMN_LIQUID, liquid);
        values.put(SettingDbHelper.COLUMN_ACTIVITYCHECKED, activitychecked);
        values.put(SettingDbHelper.COLUMN_TEMPERATURECHECKED, temperaturechecked);
        values.put(SettingDbHelper.COLUMN_ILLNESSCHECKED, illnesschecked);
        values.put(SettingDbHelper.COLUMN_EGGWHITECHECKED, eggwhitechecked);
        values.put(SettingDbHelper.COLUMN_LIQUIDCHECKED, liquidvalue);
        values.put(SettingDbHelper.COLUMN_WIGHT, wight);
        values.put(SettingDbHelper.COLUMN_HIGH, high);
        values.put(SettingDbHelper.COLUMN_BMIVALUE, bmivalue);
        values.put(SettingDbHelper.COLUMN_ENERGYVALUE, energyvalue);
        values.put(SettingDbHelper.COLUMN_LIQUIDVALUE, liquidvalue);
        values.put(SettingDbHelper.COLUMN_EGGWHITEVALUE, eggwhitevalue);
        values.put(SettingDbHelper.COLUMN_GUVALUE, guvalue);
        values.put(SettingDbHelper.COLUMN_BEHINDGUVALUE, behindguvalue);

        long insertId = database.insert(SettingDbHelper.TABLE_SETTING_LIST, null, values);

        Cursor cursor = database.query(SettingDbHelper.TABLE_SETTING_LIST,
                columns, SettingDbHelper.COLUMN_ID + "=" + insertId,
                null, null, null, null);

        cursor.moveToFirst();
        SettingMemo settingMemo = cursorToSettingMemo(cursor);
        cursor.close();

        return settingMemo;
    }

    private SettingMemo cursorToSettingMemo(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(SettingDbHelper.COLUMN_ID);
        int idGender = cursor.getColumnIndex(SettingDbHelper.COLUMN_GENDER);
        int idActivity = cursor.getColumnIndex(SettingDbHelper.COLUMN_ACTIVITY);
        int idRTemperature = cursor.getColumnIndex(SettingDbHelper.COLUMN_TEMPERATURE);
        int idIllness = cursor.getColumnIndex(SettingDbHelper.COLUMN_ILLNESS);
        int idEggwhite = cursor.getColumnIndex(SettingDbHelper.COLUMN_EGGWHITE);
        int idLiquid = cursor.getColumnIndex(SettingDbHelper.COLUMN_LIQUID);
        int idActivitychecked = cursor.getColumnIndex(SettingDbHelper.COLUMN_ACTIVITYCHECKED);
        int idTemperaturechecked = cursor.getColumnIndex(SettingDbHelper.COLUMN_TEMPERATURECHECKED);
        int idIllnesschecked = cursor.getColumnIndex(SettingDbHelper.COLUMN_ILLNESSCHECKED);
        int idEggwhitechecked = cursor.getColumnIndex(SettingDbHelper.COLUMN_EGGWHITECHECKED);
        int idLiquidchecked = cursor.getColumnIndex(SettingDbHelper.COLUMN_LIQUIDCHECKED);
        int idWight = cursor.getColumnIndex(SettingDbHelper.COLUMN_WIGHT);
        int idHigh = cursor.getColumnIndex(SettingDbHelper.COLUMN_HIGH);
        int idBmivalue = cursor.getColumnIndex(SettingDbHelper.COLUMN_BMIVALUE);
        int idEnergyvalue = cursor.getColumnIndex(SettingDbHelper.COLUMN_ENERGYVALUE);
        int idLiquidvalue = cursor.getColumnIndex(SettingDbHelper.COLUMN_LIQUIDVALUE);
        int idEggwhitevalue = cursor.getColumnIndex(SettingDbHelper.COLUMN_EGGWHITEVALUE);
        int idGuvalue = cursor.getColumnIndex(SettingDbHelper.COLUMN_GUVALUE);
        int idBehindguvalue = cursor.getColumnIndex(SettingDbHelper.COLUMN_BEHINDGUVALUE);

        String gender = cursor.getString(idGender);
        String activity = cursor.getString(idActivity);
        String temperature = cursor.getString(idRTemperature);
        String illness = cursor.getString(idIllness);
        String eggwhite = cursor.getString(idEggwhite);
        String liquid = cursor.getString(idLiquid);
        String Activitychecked = cursor.getString(idActivitychecked);
        String Temperaturechecked = cursor.getString(idTemperaturechecked);
        String Illnesschecked = cursor.getString(idIllnesschecked);
        String Eggwhitechecked = cursor.getString(idEggwhitechecked);
        String Liquidchecked = cursor.getString(idLiquidchecked);
        String wight = cursor.getString(idWight);
        String high = cursor.getString(idHigh);
        String bmivalue = cursor.getString(idBmivalue);
        String energyvalue = cursor.getString(idEnergyvalue);
        String liquidvalue = cursor.getString(idLiquidvalue);
        String eggwhitevalue = cursor.getString(idEggwhitevalue);
        String guvalue = cursor.getString(idGuvalue);
        String behindguvalue = cursor.getString(idBehindguvalue);


        long id = cursor.getLong(idIndex);

        SettingMemo settingMemo = new SettingMemo( id, gender, activity, temperature, illness,
                eggwhite, liquid, Activitychecked, Temperaturechecked, Illnesschecked,
                Eggwhitechecked, Liquidchecked, wight, high, bmivalue, energyvalue,
                liquidvalue, eggwhitevalue, guvalue, behindguvalue);

        return settingMemo;
    }

    public Cursor retrieve(String searchTerm){
        String[] columns={
                SettingDbHelper.COLUMN_ID,
                SettingDbHelper.COLUMN_GENDER,
                SettingDbHelper.COLUMN_ACTIVITY,
                SettingDbHelper.COLUMN_TEMPERATURE,
                SettingDbHelper.COLUMN_ILLNESS,
                SettingDbHelper.COLUMN_EGGWHITE,
                SettingDbHelper.COLUMN_LIQUID,
                SettingDbHelper.COLUMN_ACTIVITYCHECKED,
                SettingDbHelper.COLUMN_TEMPERATURECHECKED,
                SettingDbHelper.COLUMN_ILLNESSCHECKED,
                SettingDbHelper.COLUMN_EGGWHITECHECKED,
                SettingDbHelper.COLUMN_LIQUIDCHECKED,
                SettingDbHelper.COLUMN_WIGHT,
                SettingDbHelper.COLUMN_HIGH,
                SettingDbHelper.COLUMN_BMIVALUE,
                SettingDbHelper.COLUMN_ENERGYVALUE,
                SettingDbHelper.COLUMN_LIQUIDVALUE,
                SettingDbHelper.COLUMN_EGGWHITEVALUE,
                SettingDbHelper.COLUMN_GUVALUE,
                SettingDbHelper.COLUMN_BEHINDGUVALUE};
        Cursor c = null;
        if(searchTerm != null && searchTerm.length()>0)
        {
            String sql="SELECT * FROM "+ SettingDbHelper.TABLE_SETTING_LIST+" WHERE "+ SettingDbHelper.COLUMN_ID+" = '"+searchTerm+"'";
            c=database.rawQuery(sql,null);
            return c;
        }
        c = database.query(SettingDbHelper.TABLE_SETTING_LIST,columns,null,null,null,null,null);
        return c;
    }
}
