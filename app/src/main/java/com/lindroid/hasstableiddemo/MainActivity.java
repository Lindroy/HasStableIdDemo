package com.lindroid.hasstableiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linyulong
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Spinner spinner;

    private List<String> datas = new ArrayList<>();
    private MyAdapter adapter;
    private String[] spinnerDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 1; i <= 50; i++) {
            datas.add(new StringBuffer("数据").append(i).toString());
        }
        spinnerDatas =datas.toArray(new String[0]);
        adapter = new MyAdapter(this,datas);
    }

    private void initView() {
        listView = findViewById(R.id.list_view);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, spinnerDatas));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listView.setAdapter(adapter);
    }

    public void updateData(View view) {

    }


}
