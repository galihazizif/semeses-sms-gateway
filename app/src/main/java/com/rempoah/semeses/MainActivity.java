package com.rempoah.semeses;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by azizy on 9/7/17.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String fcmToken = sp.getString("fcmToken","-");
        if(fcmToken == "-"){
            Intent msgIntent = new Intent(this, RegistrationIntentService.class);
            startService(msgIntent);
        }
        EditText etToken = (EditText)findViewById(R.id.et_reg_id);
        etToken.setText(fcmToken);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
