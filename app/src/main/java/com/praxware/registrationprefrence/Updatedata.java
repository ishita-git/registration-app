package com.praxware.registrationprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Updatedata extends AppCompatActivity {
    Button   btn;
    EditText txtname,txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);
        btn=findViewById(R.id.button);
        txtname=findViewById(R.id.editTextTextPersonName);
        txtemail=findViewById(R.id.editTextTextEmailAddress);
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        String name1=intent.getStringExtra("name");
        String email1=intent.getStringExtra("email");
        txtname.setText(name1);
        txtemail.setText(email1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txtname.getText().toString();
                String email=txtemail.getText().toString();
                APIInterface apiInterface=APPClient.getclient().create(APIInterface.class);
                Call<Resultlogin>call=apiInterface.update(name,email,id);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        Intent intent1=new Intent(Updatedata.this,ShowData.class);
                        startActivity(intent1);
                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {

                    }
                });
            }
        });
    }
}