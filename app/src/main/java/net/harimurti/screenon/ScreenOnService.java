package net.harimurti.screenon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

public class ScreenOnService extends Service {
    PowerManager.WakeLock wakeLock;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    @SuppressWarnings("deprecation")
    public int onStartCommand(Intent intent, int flags, int startId) {
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "ScreenOn");
        wakeLock.acquire();
        Log.i("ScreenOn", "this will keep screen on");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wakeLock.release();
        Log.i("ScreenOn", "release screen");
    }
}
