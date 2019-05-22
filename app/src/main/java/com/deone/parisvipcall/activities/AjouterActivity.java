package com.deone.parisvipcall.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.deone.parisvipcall.R;

public class AjouterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button btnAjouterInfo;
    private Button btnAnnulerAjouterInfo;
    private Spinner spTypeInformation;
    private Spinner spPrivateMode;
    private EditText edtvLogin;
    private EditText edtvPassword;
    private EditText edtvCommentaire;

    private String spinnerTypeChoice;
    private String spinnerPrivateMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        this.btnAjouterInfo=(Button)findViewById(R.id.AjouterInfo);
        this.btnAjouterInfo.setOnClickListener(this);

        this.btnAnnulerAjouterInfo=(Button)findViewById(R.id.annulerInfo);
        this.btnAnnulerAjouterInfo.setOnClickListener(this);

        this.edtvLogin=(EditText)findViewById(R.id.edtvLogin);
        this.edtvPassword=(EditText)findViewById(R.id.edttvPassword);
        this.edtvCommentaire=(EditText)findViewById(R.id.edttvCommentaire);

        this.spTypeInformation=(Spinner)findViewById(R.id.spinerType);
        this.spTypeInformation.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(this,
                R.array.liste_type_choose, android.R.layout.simple_spinner_item);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spTypeInformation.setAdapter(adapterOne);
        this.spinnerTypeChoice = "";

        this.spPrivateMode=(Spinner)findViewById(R.id.spinerPrivate);
        this.spPrivateMode.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this,
                R.array.liste_private_mode, android.R.layout.simple_spinner_item);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spPrivateMode.setAdapter(adapterTwo);
        this.spinnerPrivateMode = "";
    }

    @Override
    public void onClick(View v) {
        if(v == btnAjouterInfo){

        }else if(v == btnAnnulerAjouterInfo){

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view == spTypeInformation){
            this.spinnerTypeChoice = parent.getItemAtPosition(position).toString();
        }else if(view == spPrivateMode){
            this.spinnerPrivateMode = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
