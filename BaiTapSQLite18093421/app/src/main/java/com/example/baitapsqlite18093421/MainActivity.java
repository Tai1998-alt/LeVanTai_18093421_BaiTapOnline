package com.example.baitapsqlite18093421;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnInsert, btnCancel;
    TextView editName;
    DataUser dataUser;
    MyAdapter adapter;
    ArrayList arrayList;
    List<User> list;
    ArrayList arrayListDelete;
    int index;
    ImageView imageDelete, imageEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataUser = new DataUser(this,"SQLite.data",null,1);
        arrayList = new ArrayList();
        arrayListDelete = new ArrayList();
        getName();
        list = new ArrayList<>();
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.list_name,null);
        imageDelete = convertView.findViewById(R.id.imageDelete);
        imageEdit = convertView.findViewById(R.id.imageEdit);
        listView = findViewById(R.id.listView);
        btnInsert = findViewById(R.id.btnInsert);
        btnCancel = findViewById(R.id.btnCancel);
        editName = findViewById(R.id.editName);
        for(int i=0 ; i< getName().size(); i++)
        {
            list.add(new User((String) arrayList.get(i),R.drawable.edit,R.drawable.delete));
        }
        adapter = new MyAdapter(this, R.layout.list_name,list);
        listView.setAdapter(adapter);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataUser.addUser(new User(editName.getText().toString()));
                for(int i=0 ; i< getName().size(); i++)
                {
                    list.add(new User((String) getName().get(i),R.drawable.edit,R.drawable.delete));
                }
                adapter.notifyDataSetChanged();
            }
        });
        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public ArrayList getName()
    {
        arrayList.clear();
        arrayListDelete.clear();
        for (Iterator<User> iterator = dataUser.getAll().iterator(); iterator.hasNext(); ) {
            User user = (User) iterator.next();
            arrayList.add(user.getId()+". "+user.getName());
            arrayListDelete.add(user.getId());
        }
        return arrayList;
    }
}