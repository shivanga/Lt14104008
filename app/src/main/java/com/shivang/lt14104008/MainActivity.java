package com.shivang.lt14104008;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int count,del;
    ListView listView;
    CheckBox checkBox;
    CustomAdapter cust;

    public String[] arr={"Android","Windows","Mac OS X","Tizen","Ubuntu","Kali Linux","Symbian","Elementary OS","Fedora","Arch Linux","Sailfish OS",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
count=0;del=0;
        listView=(ListView) findViewById(R.id.lv);
        cust= new CustomAdapter(getApplicationContext(),arr,del);
        listView.setAdapter(cust);



        //  listView.setOnItemClickListener(this);

    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }


    public void show(View view)
    {
        count=0;
        for ( int i=0; i< listView.getCount(); i++ ) {
            checkBox=(CheckBox)getViewByPosition(i,listView).findViewById(R.id.checkBox);
            if(checkBox.isChecked())
                count++;

        }
        Toast.makeText(this, "No. of Items Selected "+count+" ", Toast.LENGTH_LONG).show();
    }
    public void selectall(View view)
    {
        for ( int i=0; i< listView.getCount(); i++ ) {
            checkBox=(CheckBox)getViewByPosition(i,listView).findViewById(R.id.checkBox);
            if(!checkBox.isChecked())
                checkBox.setChecked(true);

        }

    }
    public void delete(View view)
    {
        for ( int i=0; i< listView.getCount(); i++ ) {
            checkBox=(CheckBox)getViewByPosition(i,listView).findViewById(R.id.checkBox);
            if(checkBox.isChecked())
                deletet(i);

        }
        cust.updateResults(arr);


    }

    private void deletet(int a) {
        for ( int i=0; i< arr.length; i++ ) {
            if(i==a)
            {
                for ( int j=i; j< arr.length-1; j++ ) {

                    arr[j]=arr[j+1];
            }

        }
    del++;
    }
    }
}
