package com.mg.axe.pathtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Chen on 2017/6/2.
 */

public class PathFillTypeActivity extends AppCompatActivity {

    private PathFillTypeView fillTypeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filltype);
        fillTypeView = (PathFillTypeView) findViewById(R.id.fillTypeView);
    }

    public void inverseEvenOdd(View view){
        fillTypeView.setFillType(PathFillTypeView.FILL_TYPE_INVERSE_EVEN_ODD);
    }

    public void inverseWinding(View view){
        fillTypeView.setFillType(PathFillTypeView.FILL_TYPE_INVERSE_WINDING);
    }

    public void evenOdd(View view){
        fillTypeView.setFillType(PathFillTypeView.FILL_TYPE_EVEN_ODD);
    }

    public void winding(View view){
        fillTypeView.setFillType(PathFillTypeView.FILL_TYPE_WINDING);
    }

}
