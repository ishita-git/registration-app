package com.praxware.registrationprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Secondpage extends AppCompatActivity {
    Button   btn;
    EditText txtname,txtpassword;
    ArrayList<Registration>arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        btn=findViewById(R.id.button);
        arrayList=new ArrayList<>();
        txtname=findViewById(R.id.editTextTextPersonName);
        txtpassword=findViewById(R.id.editTextTextPassword);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txtname.getText().toString();
                String            password =txtpassword.getText().toString();
                APIInterface apiInterface =APPClient.getclient().create(APIInterface.class);
                Call<Resultlogin >call=apiInterface.login(name,password);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        arrayList= (ArrayList<Registration>) response.body().getRegistration();
                        if(name.equals(arrayList.get(0).getEmail()) && password.equals(arrayList.get(0).getPassword()))
                        {
                            Toast.makeText(Secondpage.this, "Success", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Secondpage.this, "Not Correct", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {
                        Toast.makeText(Secondpage.this, "Not Correct", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}