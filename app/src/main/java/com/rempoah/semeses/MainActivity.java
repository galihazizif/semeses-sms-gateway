package com.rempoah.semeses;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by azizy on 9/7/17.
 */
public class MainActivity extends Activity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String fcmToken = sp.getString("fcmToken", "-");
        Boolean aktif = sp.getBoolean("aktif",false);
        Switch switchAktif = (Switch) findViewById(R.id.on_off_switch);
        switchAktif.setChecked(aktif);

        if(aktif == true){
            Toast.makeText(MainActivity.this, "Semeses Aktif", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Tidak Aktif", Toast.LENGTH_SHORT).show();
        }

        if(fcmToken == "-"){
            Intent msgIntent = new Intent(this, RegistrationIntentService.class);
            startService(msgIntent);
        }

        switchAktif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences pengaturan = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Semeses Diaktifkan", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Semeses Dinonaktifkan", Toast.LENGTH_SHORT).show();
                }

                pengaturan.edit().putBoolean("aktif",isChecked).apply();
            }
            }
        );

        EditText etToken = (EditText)findViewById(R.id.et_reg_id);
        etToken.setText(fcmToken);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
