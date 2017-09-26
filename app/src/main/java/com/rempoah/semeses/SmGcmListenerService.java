
package com.rempoah.semeses;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

public class SmGcmListenerService extends GcmListenerService {

    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        super.onMessageReceived(s, bundle);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean aktif = sharedPreferences.getBoolean("aktif", false);
        if(aktif){
            sendSms(bundle);
        }
    }

    public void sendSms(Bundle bundle){
        String destination = bundle.getString("destination");
        String text = bundle.getString("text");

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(destination,null,text,null,null);
    }
}