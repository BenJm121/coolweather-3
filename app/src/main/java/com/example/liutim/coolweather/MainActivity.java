package com.example.liutim.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> datasource=new ArrayList<String>();
    private List<String> provinces = Arrays.asList(new String[]{"北京市", "浙江省", "江西省"});
    private List<String> city01 = Arrays.asList(new String[]{"北京"});
    private List<String> city17 = Arrays.asList(new String[]{"杭州", "湖州", "嘉兴", "宁波", "绍兴"
            , "台州", "温州", "丽水", "金华", "衢州", "舟山"});
    private ArrayAdapter<String>  adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        this.datasource.clear();
        this.datasource.addAll(provinces);
        this.adapter =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, datasource);
        listView.setAdapter(this.adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, datasource.get(position), Toast.LENGTH_LONG).show();
                showCities();
            }
        });
    }

    void showCities(){
        this.datasource.clear();
        this.datasource.addAll(this.city01);
        this.adapter.notifyDataSetChanged();
    }
}
