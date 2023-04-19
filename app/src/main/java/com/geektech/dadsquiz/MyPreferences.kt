package com.geektech.dadsquiz

import android.content.Context
import android.content.SharedPreferences

class MyPreferences(context: Context) {
companion object{
    private val PREFS_NAME = "MyPrefs"
    private val POINT_KEY = "point_key"
    private val KEY_BOOLEAN = "CREATOR_KEY"
    private var points: Int = 0}

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun plusOne() {
        points++
        preferences.edit().putInt(POINT_KEY, points).apply()
    }
    fun cleanPoints(){
        points = 0
        preferences.edit().putInt(POINT_KEY, points).apply()
    }
    fun getPoints():Int{
        return preferences.getInt(POINT_KEY, 0)
    }
    fun iWillPlayWithPoints() {
        preferences.edit().putBoolean(KEY_BOOLEAN, true).apply()
    }

    fun iWillPlayWithRestart() {
        preferences.edit().putBoolean(KEY_BOOLEAN, false).apply()
    }

    fun doUPlayWithPoints(): Boolean {
        return preferences.getBoolean(KEY_BOOLEAN, false)
    }
}