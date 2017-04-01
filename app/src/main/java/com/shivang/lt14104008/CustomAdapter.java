package com.shivang.lt14104008;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by sa on 3/8/2017.
 */
public class CustomAdapter extends BaseAdapter{
    String[] arr;
    Context context;

    int del;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, String[] a,int de)
    {
        this.context=applicationContext;
        this.arr=a;
        del=de;
    }

    @Override
    public int getCount() {

        return (arr.length-del);
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    public void updateResults(String[] a) {
        arr = a;
        //Triggers the list update
        notifyDataSetChanged();
    }




    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        view=inflater.inflate(R.layout.mylist, null);
        TextView os=(TextView)view.findViewById((R.id.textView));

        os.setText(arr[i]);

        return view;
    }

}
