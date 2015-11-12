package com.angcyo.pagescaledemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    int[] imgs = new int[]{R.drawable.img_meizi1, R.drawable.img_meizi2, R.drawable.img_meizi3};
    String[] texts = new String[]{"第一页", "第二页", "第三页"};
    List views;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initViews();
    }


    private void initViews() {
        views = new ArrayList();
        View item1 = View.inflate(this, R.layout.layout_item, null);
        ((ImageView) item1.findViewById(R.id.img)).setImageResource(imgs[0]);
        ((TextView) item1.findViewById(R.id.text)).setText(texts[0]);
        views.add(item1);

        View item2 = View.inflate(this, R.layout.layout_item, null);
        ((ImageView) item2.findViewById(R.id.img)).setImageResource(imgs[1]);
        ((TextView) item2.findViewById(R.id.text)).setText(texts[1]);
        views.add(item2);

        View item3 = View.inflate(this, R.layout.layout_item, null);
        ((ImageView) item3.findViewById(R.id.img)).setImageResource(imgs[2]);
        ((TextView) item3.findViewById(R.id.text)).setText(texts[2]);
        views.add(item3);

        viewPager = (ViewPager) findViewById(R.id.pageView);
        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView((View) views.get(position));
                container.setBackgroundColor(Color.TRANSPARENT);
                return views.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) views.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
