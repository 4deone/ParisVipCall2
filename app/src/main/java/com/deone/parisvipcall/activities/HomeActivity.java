package com.deone.parisvipcall.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deone.parisvipcall.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddInfo;
    private Button btnVoirInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.initConfiguration();
    }

    private void initConfiguration() {
        this.btnAddInfo = (Button)findViewById(R.id.btnAddInfo);
        this.btnVoirInfo = (Button)findViewById(R.id.btnVoirInfo);
        this.btnAddInfo.setOnClickListener(this);
        this.btnVoirInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnAddInfo){
            finish();
            startActivity(new Intent(HomeActivity.this, AjouterActivity.class));
        }else if(v == btnVoirInfo){
            startActivity(new Intent(HomeActivity.this, VoirActivity.class));
        }
    }
}
