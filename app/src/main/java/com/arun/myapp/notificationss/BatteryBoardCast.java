package com.arun.myapp.notificationss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arun.myapp.R;

public class BatteryBoardCast extends AppCompatActivity {

    BatteryReceiver batteryReceiver;

    TextView textview;
    Button button;
    IntentFilter intentfilter;
    int deviceStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_board_cast);

        button = (Button) findViewById(R.id.btnBattery);
        textview = (TextView) findViewById(R.id.tvBattery);

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BatteryBoardCast.this.registerReceiver(broadcastReceiver, intentfilter);
            }
        });

        //for %age
        TextView tv = (TextView) findViewById(R.id.tvPerBattery);
        batteryReceiver = new BatteryReceiver(tv);
        registerReceiver(batteryReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            if (deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING) {
                textview.setText("Battery Status = Charging");
            }
            if (deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING) {
                textview.setText("Battery Status = Discharging ");
            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL) {
                textview.setText("Battery Status = Battery Full ");
            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN) {
                textview.setText("Battery Status = Unknown ");
            }
            if (deviceStatus == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {
                textview.setText("Battery Status = Not Charging ");
            }
        }
    };


    //for %age battery
    public class BatteryReceiver extends BroadcastReceiver {

        TextView tv;

        BatteryReceiver(TextView tv) {
            this.tv = tv;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            int batteryPercentage = intent.getIntExtra("level", 0);
            if (batteryPercentage != 0) {
                tv.setText(batteryPercentage + "% of battery");
            }
        }
    }
}