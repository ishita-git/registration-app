package com.praxware.registrationprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    Button btn;
    EditText txtname,txtpassword,txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        txtname=findViewById(R.id.editTextTextPersonName);
        txtpassword=findViewById(R.id.editTextTextPassword);
        txtemail=findViewById(R.id.editTextTextEmailAddress);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txtname.getText().toString();
                String password=txtpassword.getText().toString();
                String email=txtemail.getText().toString();
                APIInterface apiInterface=APPClient.getclient().create(APIInterface.class);
                Call<String >call=apiInterface.insertdata(name,email,password);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        /*sucess*/

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("Error","DONE");
                        Intent intent=new Intent(MainActivity.this,ShowData.class);
                        startActivity(intent);
                    /*fail*/
                    }
                });
            }
        });
    }

}