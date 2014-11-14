package com.rbarnes.recyleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RecycleActivity extends Activity {

    private RecyclerView recycleView;
    private RecycleAdapter adapter;
    private List<RecycleViewData> recycleList = new ArrayList<RecycleViewData>();
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final LinearLayoutManager lm;
        lm = new LinearLayoutManager(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);


        recycleView = (RecyclerView) findViewById(R.id.recyclerView);
        recycleView.setLayoutManager(lm);
        adapter = new RecycleAdapter(RecycleActivity.this, recycleList);
        // set adapter
        recycleView.setAdapter(adapter);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        toInfinity();

        //Detect end keep adding more
        recycleView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                visibleItemCount = recycleView.getChildCount();
                totalItemCount = lm.getItemCount();
                firstVisibleItem = lm.findFirstVisibleItemPosition();

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {


                    toInfinity();
                    adapter.notifyDataSetChanged();

                    loading = true;
                }

                          }
        });

    }

    private void toInfinity(){
        for (int i = 0; i <100; i++) {


            RecycleViewData item = new RecycleViewData(DateFormat.getDateTimeInstance().format(new Date()));

            recycleList.add(item);
        }


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recycle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
