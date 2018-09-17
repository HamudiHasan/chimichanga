package com.uiutesseract.nidavellir.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by hhsonet on 3/2/2018.
 * Use this class for Storing data in SharedPreferences.
 */

public class TinyDB {
    private Context context;
    private String SP_DEFAULT_VALUE_STR = "nil";
    private int SP_DEFAULT_VALUE_INT = 0;
    private boolean SP_DEFAULT_VALUE_BOOL = false;
    private SharedPreferences preferences;

    /**
     * Constructor
     * @param context
     */
    public TinyDB(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * save data (String) to Shared Pref.
     * @param name
     * @param value
     */
    public void putString(String name, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(name, value);
        editor.commit();
    }
    /**
     * save data (int) to Shared Pref.
     * @param name
     * @param value
     */
    public void putInt(String name, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(name, value);
        editor.commit();
    }

    /**
     * save data (boolean) to Shared Pref.
     * @param name
     * @param value
     */
    public void putBoolean(String name, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(name, value);
        editor.commit();
    }

    /**
     *
     * fetch data from Shared Pref.
     * @param name
     * @return value (String)
     */
    public String getString(String name) {
        return preferences.getString(name, SP_DEFAULT_VALUE_STR);
    }

    /**
     *
     * fetch data from Shared Pref.
     * @param name
     * @return value (int)
     */
    public int getInt(String name) {
        return preferences.getInt(name, SP_DEFAULT_VALUE_INT);
    }

    /**
     *
     * fetch data from Shared Pref.
     * @param name
     * @return value (boolean)
     */
    public boolean getBoolean(String name) {
        return preferences.getBoolean(name, SP_DEFAULT_VALUE_BOOL);
    }

}
