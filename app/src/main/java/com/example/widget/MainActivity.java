package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
        TextView textLight_available,textLight_reading;
        Sensor sensor;
        private SensorManager mySensorManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                textLight_available = (TextView) findViewById(R.id.textView4);

                textLight_reading = (TextView) findViewById(R.id.textView5);

                mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
                sensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }

        @Override
        protected void onPause() {
                super.onPause();
                mySensorManager.unregisterListener(this);
        }

        @Override
        protected void onResume() {

                super.onResume();
                mySensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType()==Sensor.TYPE_LIGHT)

                {
                        float  values=event.values[0];
                        if(values<25)
                        {textLight_available.setText("Room is dark :"+event.values[0]);
                        }
                        else
                        {
                                textLight_available.setText("Light is present in Room:"+event.values[0]);

                        }
                }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
}

