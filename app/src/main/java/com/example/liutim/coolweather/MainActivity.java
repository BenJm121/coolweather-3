package com.example.liutim.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private String[] provinces = new String[]{"北京市", "浙江省", "江西省"};
    private String[] city01 = new String[]{"北京"};
    private String[] city17 = new String[]{"杭州", "湖州", "嘉兴", "宁波", "绍兴"
            , "台州", "温州", "丽水", "金华", "衢州", "舟山"};

    private String[] country1701 = new String[]{"瓯海", "永嘉","鹿城"};
//1表示最顶层省直辖市级，2表示市级，3表现县区级
    private int level=1;


    private void showCities(int position) {
        level=2;
        this.backButton.setVisibility(View.VISIBLE);
        if("北京市".equals(MainActivity.this.provinces[position])){
            ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, city01);
            listView.setAdapter(adapter);
        }else{
            ArrayAdapter adapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, city17);
            listView.setAdapter(adapter);
        }
    }
    private Button backButton =null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.backButton = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, provinces);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            ///回调 callback method
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              if(level==1){
                  showCities(position);
              }else if(level==2){
                  level=3;
                  ArrayAdapter adapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, country1701);
                  listView.setAdapter(adapter);
              }else{
                  //TODO 选定区县，去显示天气界面
              }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level==3){
                    level=2;
                    ArrayAdapter adapter =
                            new ArrayAdapter<String>(MainActivity.this,
                                    android.R.layout.simple_list_item_1,city17);
                    listView.setAdapter(adapter);
                }else if(level==2){
                    level=1;
                    backButton.setVisibility(View.GONE);
                    ArrayAdapter adapter =
                            new ArrayAdapter<String>(MainActivity.this,
                                    android.R.layout.simple_list_item_1,city17);
                    listView.setAdapter(adapter);
                }



            }
        });
    }


}
