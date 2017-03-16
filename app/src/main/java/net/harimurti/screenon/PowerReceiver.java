package net.harimurti.screenon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = new PowerManager(context);

        if (pm.Plugged.contains("USB")) {
            PreService.Start(context);
        } else {
            PreService.Stop(context);
        }
    }
}
