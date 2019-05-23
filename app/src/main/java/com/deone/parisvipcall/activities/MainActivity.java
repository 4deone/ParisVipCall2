package com.deone.parisvipcall.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deone.parisvipcall.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnConnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initConfiguration();
    }

    private void initConfiguration() {
        this.btnConnexion = (Button)findViewById(R.id.btnConnexion);
        this.btnConnexion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnConnexion){
            finish();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
    }
}
