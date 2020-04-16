package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msg;
        String str = "SMS from ";
        if(bundle != null){
            msg = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (int i=0; i<msg.length; i++){
                str += msg[i].getMessageBody().toString();
            }
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            Log.d("SMSReceiver", str);
        }
    }
}
