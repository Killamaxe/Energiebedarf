package com.example.energiebedarf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SettingDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = SettingDbHelper.class.getSimpleName();

    public static final String DB_NAME = "SettingDbHelper.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_SETTING_LIST = "SettingDbHelper";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_ACTIVITY = "activity";
    public static final String COLUMN_TEMPERATURE = "temperature";
    public static final String COLUMN_ILLNESS = "illness";
    public static final String COLUMN_EGGWHITE = "eggwhite";
    public static final String COLUMN_LIQUID = "liquid";
    public static final String COLUMN_ACTIVITYCHECKED = "activitychecked";
    public static final String COLUMN_TEMPERATURECHECKED = "temperaturechecked";
    public static final String COLUMN_ILLNESSCHECKED = "illnesschecked";
    public static final String COLUMN_EGGWHITECHECKED = "eggwhitechecked";
    public static final String COLUMN_LIQUIDCHECKED = "liquidchecked";
    public static final String COLUMN_WIGHT = "wight";
    public static final String COLUMN_HIGH = "high";
    public static final String COLUMN_BMIVALUE = "bmivalue";
    public static final String COLUMN_ENERGYVALUE = "energyvalue";
    public static final String COLUMN_LIQUIDVALUE = "liquidvalue";
    public static final String COLUMN_EGGWHITEVALUE = "eggwhitevalue";
    public static final String COLUMN_GUVALUE = "guvalue";
    public static final String COLUMN_BEHINDGUVALUE = "behindguvalue";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_SETTING_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_ACTIVITY + " TEXT, " +
                    COLUMN_TEMPERATURE + " TEXT, " +
                    COLUMN_ILLNESS + " TEXT, " +
                    COLUMN_EGGWHITE + " TEXT, " +
                    COLUMN_LIQUID + " TEXT, " +
                    COLUMN_ACTIVITYCHECKED + " TEXT, " +
                    COLUMN_TEMPERATURECHECKED + " TEXT, " +
                    COLUMN_ILLNESSCHECKED + " TEXT, " +
                    COLUMN_EGGWHITECHECKED + " TEXT, " +
                    COLUMN_LIQUIDCHECKED + " TEXT, " +
                    COLUMN_WIGHT + " TEXT, " +
                    COLUMN_HIGH + " TEXT, " +
                    COLUMN_BMIVALUE + " TEXT, " +
                    COLUMN_ENERGYVALUE + " TEXT, " +
                    COLUMN_LIQUIDVALUE + " TEXT, " +
                    COLUMN_EGGWHITEVALUE + " TEXT, " +
                    COLUMN_GUVALUE + " TEXT, " +
                    COLUMN_BEHINDGUVALUE + " TEXT); ";

    private static String DB_PATH = "";

    public SettingDbHelper(Context context) {
        /*super(context, DB_NAME, null, DB_VERSION);
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    }*/
        super(context, DB_NAME, null, DB_VERSION);// 1? its Database Version
        if(android.os.Build.VERSION.SDK_INT >= 4.2){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";

        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE + " angelegt.");
            db.execSQL(SQL_CREATE);
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean updateSettingMemo(String id, String gender, String activity, String temperature, String illness,
                                     String eggwhite, String liquid, String activityhecked, String temperaturechecked,
                                     String illnesschecked, String eggwhitechecked, String liquidchecked,
                                     String wight, String high, String bmivalue,
                                     String energyvalue, String liquidvalue, String eggwhitevalue,
                                     String guvalue, String behindvalue ) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, id);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_ACTIVITY, activity);
        values.put(COLUMN_TEMPERATURE, temperature);
        values.put(COLUMN_ILLNESS, illness);
        values.put(COLUMN_EGGWHITE, eggwhite);
        values.put(COLUMN_LIQUID, liquid);
        values.put(COLUMN_ACTIVITYCHECKED, activityhecked);
        values.put(COLUMN_TEMPERATURECHECKED, temperaturechecked);
        values.put(COLUMN_ILLNESSCHECKED, illnesschecked);
        values.put(COLUMN_EGGWHITECHECKED, eggwhitechecked);
        values.put(COLUMN_LIQUIDCHECKED, liquidchecked);
        values.put(COLUMN_WIGHT, wight);
        values.put(COLUMN_HIGH, high);
        values.put(COLUMN_BMIVALUE, bmivalue);
        values.put(COLUMN_ENERGYVALUE, energyvalue);
        values.put(COLUMN_LIQUIDVALUE, liquidvalue);
        values.put(COLUMN_EGGWHITEVALUE, eggwhitevalue);
        values.put(COLUMN_GUVALUE, guvalue);
        values.put(COLUMN_BEHINDGUVALUE, behindvalue);

        database.update(TABLE_SETTING_LIST, values, COLUMN_ID + "=" + id, null);
        return true;
    }
}

