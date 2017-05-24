package com.virendra.recyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.virendra.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onlyAdapter(View view) {
        openActivity("onlyAdapter");
    }

    public void adapterWithTextInJava(View view) {
        openActivity("adapterWithTextInJava");
    }

    public void adapterWithTextInXml(View view) {
        openActivity("adapterWithTextInXml");
    }

    public void adapterWithImageInJava(View view) {
        openActivity("adapterWithImageInJava");
    }

    public void adapterWithImageInXml(View view) {
        openActivity("adapterWithImageInXml");
    }

    private void openActivity(String type) {
        startActivity(new Intent(this, BasicAdapterActivity.class).putExtra("TYPE", type));
    }
}
