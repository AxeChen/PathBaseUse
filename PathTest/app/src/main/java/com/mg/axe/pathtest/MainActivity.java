package com.mg.axe.pathtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testFillType(View view) {
        Intent intent = new Intent(this, PathFillTypeActivity.class);
        startActivity(intent);
    }

    public void testOpType(View view) {
        Intent intent = new Intent(this, PathOpTypeActivity.class);
        startActivity(intent);
    }

    public void oneLevelBezier(View view) {
        Intent intent = new Intent(this, OneLevelBezierActivity.class);
        startActivity(intent);
    }

    public void waveProgressView(View view) {
        Intent intent = new Intent(this, WaveProgressActivity.class);
        startActivity(intent);
    }
}
