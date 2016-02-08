package com.invalid.finance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    ListView lv;
    //FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //fab = (FloatingActionButton)findViewById(R.id.fab1);


        lv = (ListView)findViewById(R.id.lv);
        makelist(lv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    final String KVALUE = "value";
    final String KDATE = "date";

    private void makelist(ListView lv){

        int[] values={1,2,3,4,5,6,7,8,9};

        ArrayList<Map<String,Object>> data = new ArrayList<>(values.length);

        Map<String,Object> m;
        for(int i=0;i<values.length;i++){
            m = new HashMap<String,Object>();
            m.put(KVALUE,""+values[i]);
            m.put(KDATE,""+i);
            data.add(m);
        }

        String from[]={KVALUE,KDATE};
        int to[]={R.id.textView2,R.id.textView3};

        AmountSimpleAdapter asa =
                new AmountSimpleAdapter(this,data,R.layout.spend_list_item,from,to);

        lv.addHeaderView( getLayoutInflater()
                .inflate(R.layout.headerlay, null),
                "some text",
                false );
        lv.setAdapter(asa);
    }

    public void onClick(View v){
        Intent intent = new Intent( this , EnterField.class );
        startActivity(intent);
    }

}
