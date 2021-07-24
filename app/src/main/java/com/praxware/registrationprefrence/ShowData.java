package com.praxware.registrationprefrence;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowData extends AppCompatActivity {

    ListView lv;
    ArrayList<Registration>arrayList;
    Customadapter customadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        lv = findViewById(R.id.lstview);
        arrayList=new ArrayList<>();
        registerForContextMenu(lv);
        APIInterface apiInterface=APPClient.getclient().create(APIInterface.class);
        Call<Resultlogin>call=apiInterface.getalldata();
        call.enqueue(new Callback<Resultlogin>() {
            @Override
            public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                arrayList= (ArrayList<Registration>) response.body().getRegistration();
                customadapter=new Customadapter(ShowData.this,arrayList);
                lv.setAdapter(customadapter);
            }

            @Override
            public void onFailure(Call<Resultlogin> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int pos=customadapter.posname();
        if(item.getItemId()==1)
        {
            String id=arrayList.get(pos).getId();
            APIInterface apiInterface=APPClient.getclient().create(APIInterface.class);
            Call<Resultlogin>call=apiInterface.delete(id);
            call.enqueue(new Callback<Resultlogin>() {
                @Override
                public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                    arrayList= (ArrayList<Registration>) response.body().getRegistration();
                    customadapter=new Customadapter(ShowData.this,arrayList);
                    lv.setAdapter(customadapter);
                }

                @Override
                public void onFailure(Call<Resultlogin> call, Throwable t) {

                }
            });
        }
        return super.onContextItemSelected(item);
    }
}