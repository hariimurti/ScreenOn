package net.harimurti.screenon;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PreService {
    private static Class<?> serviceClass = ScreenOnService.class;

    public static void Start(Context context) {
        ConfigManager cm = new ConfigManager(context);
        if (cm.getBoolean("KeepScreenOn")) {
            if (!isServiceRunning(context)) {
                Intent background = new Intent(context, serviceClass);
                context.startService(background);
                Toast.makeText(context, R.string.toast_start, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static boolean Stop(Context context) {
        if (isServiceRunning(context)) {
            Intent background = new Intent(context, serviceClass);
            context.stopService(background);
            Toast.makeText(context, R.string.toast_stop, Toast.LENGTH_SHORT).show();
            return true;
        } else return false;
    }

    private static boolean isServiceRunning(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
