package tct.digital.tctassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import util.UserSessionManager;

public class MainActivity extends AppCompatActivity {

    private EditText username, userPassword;
    public static final String MyPREFERENCES = "LoginCredentials";
    public static final String name = "tctdigital";
    public static final String password = "P@ssw0rd";

    UserSessionManager session;

    SharedPreferences  sharedPreferences;
    SharedPreferences.Editor editor;

    TextInputLayout usernameInputEditText, passwordInputEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //session = new UserSessionManager(this);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        username = findViewById(R.id.username);
        userPassword = findViewById(R.id.password);
        usernameInputEditText = findViewById(R.id.usernameTextInput);
        passwordInputEditText = findViewById(R.id.PasswordTextInput);
        button = findViewById(R.id.button_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   String uName = username.getText().toString();
                   String uPassword = userPassword.getText().toString();

                   if(uName.equalsIgnoreCase("")){
                       usernameInputEditText.setError("Field cannot be empty");
                   }
                   if(uPassword.equalsIgnoreCase("")){
                       passwordInputEditText.setError("Field cannot be empty");
                   }

                   if(!uName.equalsIgnoreCase(name)){
                       usernameInputEditText.setError("Incorrect input");
                   }
                    if(!uPassword.equalsIgnoreCase(password)){
                        passwordInputEditText.setError("Incorrect input");
                    }

                   if(!(uName.equalsIgnoreCase("")
                           && uPassword.equalsIgnoreCase(""))) {
                       if (uName.equalsIgnoreCase(name)
                               && uPassword.equalsIgnoreCase(password)) {
                           editor = sharedPreferences.edit();

                           editor.putString("Username", uName);
                           editor.putString("Password", uPassword);
                           editor.commit();
                           startActivity(new Intent(MainActivity.this, HomeActivity.class));
                           finish();
                       }
                   }
                    //startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Main Activity", "onClick: " + e.getMessage());
                }
            }
    });
}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //    void login(View view){
//        // TODO
//        // Verify correct user credentials and log user in
//        // Take the user to the tabbed navigation activity
//    }
}
