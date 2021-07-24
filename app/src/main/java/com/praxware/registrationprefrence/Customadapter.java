package com.praxware.registrationprefrence;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Customadapter extends BaseAdapter implements View.OnCreateContextMenuListener {

    Context context;
    ArrayList<Registration>arrayList;
    int selected;
    public Customadapter(Context context, ArrayList<Registration> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.custom,null);
        TextView tv=v.findViewById(R.id.textView2);
        TextView tv2=v.findViewById(R.id.textView3);
        TextView tv3=v.findViewById(R.id.textView4);
        tv.setText(arrayList.get(position).getId());
        tv2.setText(arrayList.get(position).getUname());
        tv3.setText(arrayList.get(position).getEmail());
        v.setOnCreateContextMenuListener(this);
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                selected=position;
                return false;
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Updatedata.class);
                intent.putExtra("id",arrayList.get(position).getId());
                intent.putExtra("name",arrayList.get(position).getUname());
                intent.putExtra("email",arrayList.get(position).getEmail());
                context.startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        menu.add(0,1,0,"Delete");
    }
    public int posname()
    {
        return selected;
    }
}
