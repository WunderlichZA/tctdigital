package util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import tct.digital.tctassignment.MainActivity;

public class UserSessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    private static final String PREFERENCE_NAME = "login_credentials";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static final String KEY_NAME = "username";
    public static final String KEY_PASSWORD = "password";

    public UserSessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void createUserLoginSession(String name, String password){
        // Storing login value as TRUE
        editor.putBoolean(IS_USER_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing email in pref
        editor.putString(KEY_PASSWORD, password);

        // commit changes
        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){

        //Use hashmap to store user credentials
        HashMap<String, String> user = new HashMap<String, String>();

        // user name
        user.put(KEY_NAME, sharedPreferences.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_PASSWORD, sharedPreferences.getString(KEY_PASSWORD, null));

        // return user
        return user;
    }

    public boolean checkLogin(){
        // Check login status
        if(!this.isUserLoggedIn()){

            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(context, MainActivity.class);

            // Closing all the Activities from stack
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            context.startActivity(i);

            return true;
        }
        return false;
    }

    public void logoutUser(){

        // Clearing all user data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Login Activity
        Intent i = new Intent(context, MainActivity.class);

        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);
    }

    public boolean isUserLoggedIn(){
        return sharedPreferences.getBoolean(IS_USER_LOGIN, false);
    }
}
