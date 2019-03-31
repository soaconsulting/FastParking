package com.soaconsultingonline.fastparking.security;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.soaconsultingonline.fastparking.activity.LoginActivity;
import com.soaconsultingonline.fastparking.database.model.PersonalData;

import java.util.HashMap;

/**
 * Created by Jimmy on 20/07/2016.
 */
public class UserSessionManager {
    // Shared Preferences reference
    SharedPreferences pref;
    // Editor reference for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Sharedpref file name
    private static final String PREFER_NAME = "FastParkingPref";
    // All Shared Preferences Keys
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";
    // User gender (make variable public to access from outside)
    public static final String KEY_GENDER = "gender";
    // User birthday (make variable public to access from outside)
    public static final String KEY_BDAY = "birthday";
    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";
    // User Link (make variable public to access from outside)
    public static final String KEY_LINK = "link";
    // User Id (make variable public to access from outside)
    public static final String KEY_ID = "id";

    // Constructor
    public UserSessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //Create login session
    public void createUserLoginSession(PersonalData p){
        // Storing login value as TRUE
        editor.putBoolean(IS_USER_LOGIN, true);
        // Storing name in pref
        editor.putString(KEY_NAME, p.getName());
        // Storing email in pref
        editor.putString(KEY_EMAIL, p.getEmail());
        // Storing birthday in pref
        editor.putString(KEY_BDAY, p.getBirthday());
        // Storing gender in pref
        editor.putString(KEY_GENDER, p.getGender());
        // Storing id in pref
        editor.putString(KEY_ID, p.getId());
        // Storing link in pref
        editor.putString(KEY_LINK, p.getLink());
        // commit changes
        editor.commit();
    }

    /**
     * Check login method will check user login status
     * If false it will redirect user to login page
     * Else do anything
     * */
    public boolean checkLogin(){
        // Check login status
        if(!this.isUserLoggedIn() && !this.isUserFacebookLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities from stack
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Staring Login Activity
            _context.startActivity(i);
            return true;
        }
        return false;
    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        //Use hashmap to store user credentials
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        // user link id
        user.put(KEY_LINK, pref.getString(KEY_LINK, null));
        // user id
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        // user gender id
        user.put(KEY_GENDER, pref.getString(KEY_GENDER, null));
        // user birthday id
        user.put(KEY_BDAY, pref.getString(KEY_BDAY, null));
        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){

        // Clearing all user data from Shared Preferences
        editor.clear();
        editor.commit();
        // After logout redirect user to Login Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // Si está logueado con facebook
        if (this.isUserFacebookLoggedIn())
            LoginManager.getInstance().logOut();
        // Staring Login Activity
        _context.startActivity(i);
    }

    // Check for login
    public boolean isUserLoggedIn(){
        return pref.getBoolean(IS_USER_LOGIN, false);
    }

    // Check Facebook login
    public boolean isUserFacebookLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null && !accessToken.isExpired();
    }
}
