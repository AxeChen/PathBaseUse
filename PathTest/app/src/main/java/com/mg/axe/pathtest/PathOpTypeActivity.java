package com.mg.axe.pathtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator on 2017/6/3.
 */

public class PathOpTypeActivity extends AppCompatActivity {

    private PathOpView opView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optype);
        opView = (PathOpView) findViewById(R.id.pathOPView);
    }

    public void difference(View view) {
        opView.setType(PathOpView.OP_TYPE_DIFFERENCE);
    }

    public void intersect(View view) {
        opView.setType(PathOpView.OP_TYPE_INTERSECT);
    }

    public void union(View view) {
        opView.setType(PathOpView.OP_TYPE_UNION);
    }

    public void xor(View view) {
        opView.setType(PathOpView.OP_TYPE_XOR);
    }

    public void reverseDifference(View view) {
        opView.setType(PathOpView.OP_TYPE_REVERSE_DIFFERENCE);
    }
}
