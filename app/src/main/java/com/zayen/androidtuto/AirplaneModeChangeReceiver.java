package com.zayen.androidtuto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ALADIN", "Event Received");
        if ((intent.getAction() != null) && (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))) {
            Log.d("ALADIN", "Boot completed");
        }
        if ((intent.getAction() != null) && (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))) {
            Log.d("ALADIN", "Airplane Mode Change Receiver");
        }
    }
}

