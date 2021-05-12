package com.example.baitapsqlite18093421;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> list;

    public MyAdapter(Context context, int layout, List<User> list) {
        this.context=context;
        this.layout=layout;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        User user = list.get(position);
        TextView txtName = convertView.findViewById(R.id.txtName);
        ImageView imageEdit = convertView.findViewById(R.id.imageEdit);
        ImageView imageDelete =convertView.findViewById(R.id.imageDelete);
        txtName.setText(user.getName());
        imageEdit.setImageResource(user.getEdit());
        imageDelete.setImageResource(user.getDelete());
        return convertView;
    }
}
