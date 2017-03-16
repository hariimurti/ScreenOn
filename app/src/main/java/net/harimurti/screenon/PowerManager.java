package net.harimurti.screenon;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class PowerManager {
    public String Plugged;

    public PowerManager(Context context) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, filter);

        switch (batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)) {
            case BatteryManager.BATTERY_PLUGGED_USB:
                Plugged = "USB Source";
                break;
            case BatteryManager.BATTERY_PLUGGED_AC:
                Plugged = "AC Charger";
                break;
            case BatteryManager.BATTERY_PLUGGED_WIRELESS:
                Plugged = "Wireless Charger";
                break;
            default:
                Plugged = "Unknown Source";
                break;
        }
    }
}
