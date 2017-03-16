package net.harimurti.screenon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConfigManager cm = new ConfigManager(this);

        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setChecked(cm.getBoolean("KeepScreenOn"));
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cm.setBoolean("KeepScreenOn", isChecked);
            }
        });
    }

    public void onClick(View view) {
        if (!PreService.Stop(this)) {
            Toast.makeText(this, R.string.toast_notstop, Toast.LENGTH_SHORT).show();
        }
    }
}
