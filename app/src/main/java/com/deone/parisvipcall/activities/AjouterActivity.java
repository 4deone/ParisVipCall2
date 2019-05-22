package com.deone.parisvipcall.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.deone.parisvipcall.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

public class AjouterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button btnAjouterInfo;
    private Button btnAnnulerAjouterInfo;
    private Spinner spTypeInformation;
    private CheckBox cbPrivateMode;
    private EditText edtvLogin;
    private EditText edtvPassword;
    private EditText edtvCommentaire;

    private String spinnerTypeChoose;
    private String checkboxPrivateMode;
    private String login;
    private String password;
    private String commentaire;

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
        this.spinnerTypeChoose = "";

        this.cbPrivateMode=(CheckBox)findViewById(R.id.cbPrivateMode);
        this.checkboxPrivateMode = "";
    }

    public class SendRequest extends AsyncTask<String, Void, String> {

        ProgressDialog dialog;

        protected void onPreExecute(){
            dialog = new ProgressDialog(AjouterActivity.this);
            dialog.setTitle("Hey Wait Please...");
            dialog.setMessage("Chargement des informations");
            dialog.show();
        }

        protected String doInBackground(String... arg0) {

            try{

                URL url = new URL("https://script.google.com/macros/s/AKfycbyoi3Ai5kayzWt-CApbytsb2fUt4dSQ5_AHEOnEkUFLFZ2ImGM8/exec");
                JSONObject postDataParams = new JSONObject();

                String id= "1v6Dfn0BR73mU1QHBvJYbW2JCmgS8kUMO6axjXrNlpQc";

                postDataParams.put("login",login);
                postDataParams.put("password",password);
                postDataParams.put("typeChoose",spinnerTypeChoose);
                postDataParams.put("privateMode",checkboxPrivateMode);
                postDataParams.put("commentaire",commentaire);
                postDataParams.put("id",id);


                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            dialog.dismiss();
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(AjouterActivity.this, MainActivity.class));
        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    @Override
    public void onClick(View v) {
        if(v == btnAjouterInfo){
            this.login = edtvLogin.getText().toString().trim();
            this.password = edtvPassword.getText().toString().trim();
            this.commentaire = edtvCommentaire.getText().toString().trim();

            if(login.isEmpty()){
                Snackbar.make(findViewById(R.id.llAjouterInfo), "le champs LOGIN est vide", Snackbar.LENGTH_LONG).show();
                return;
            }

            if(password.isEmpty()){
                Snackbar.make(findViewById(R.id.llAjouterInfo), "le champs PASSWORD est vide", Snackbar.LENGTH_LONG).show();
                return;
            }
            if(commentaire.isEmpty()){
                Snackbar.make(findViewById(R.id.llAjouterInfo), "le champs COMMENTAIRE est vide", Snackbar.LENGTH_LONG).show();
                return;
            }
            if(spinnerTypeChoose.isEmpty()){
                Snackbar.make(findViewById(R.id.llAjouterInfo), "Aucun choix de type", Snackbar.LENGTH_LONG).show();
                return;
            }
            if(cbPrivateMode.isChecked()){
                this.checkboxPrivateMode = "OUI";
            }else {
                this.checkboxPrivateMode = "NON";
            }

            new SendRequest().execute();
        }else if(v == btnAnnulerAjouterInfo){
            finish();
            startActivity(new Intent(AjouterActivity.this, MainActivity.class));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.spinnerTypeChoose = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        this.spinnerTypeChoose = "";
    }
}
