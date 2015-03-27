package com.michael.actionbardemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity
{

    private ListView lvList;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniComponent();
        iniData();
    }

    private void iniComponent()
    {
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                onListViewItemClick(position);
            }
        });
    }

    private void iniData()
    {
        dataList = new ArrayList<String>();
        dataList.add("自定义返回按钮样式");
        dataList.add("自定义更多按钮样式");
        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, dataList);
        lvList.setAdapter(adapter);
    }

    /**
     * ListView中的Item被点击的时候，跳转到不同的界面
     * */
    private void onListViewItemClick(int position)
    {
        Toast.makeText(MainActivity.this, dataList.get(position), Toast.LENGTH_SHORT).show();
        switch (position)
        {
            case 0:
                break;
        }
    }

    /**
     * 数据源适配器
     * */
    private class StableArrayAdapter extends ArrayAdapter<String>
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects)
        {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i)
            {
                map.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position)
        {
            String item = getItem(position);
            return map.get(item);
        }

        @Override
        public boolean hasStableIds()
        {
            return true;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
