package com.deone.parisvipcall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddInfo;
    private Button btnVoirInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnAddInfo = (Button)findViewById(R.id.btnAddInfo);
        this.btnVoirInfo = (Button)findViewById(R.id.btnVoirInfo);
        this.btnAddInfo.setOnClickListener(this);
        this.btnVoirInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnAddInfo){

        }else if(v == btnVoirInfo){

        }
    }
}
