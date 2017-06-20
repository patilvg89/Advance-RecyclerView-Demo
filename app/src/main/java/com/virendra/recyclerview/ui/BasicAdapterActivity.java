package com.virendra.recyclerview.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.virendra.recyclerview.Adapter.HomeAdapter;
import com.virendra.recyclerview.R;
import com.virendra.view.RecyclerViewCallback;
import com.virendra.view.RecyclerViewEmptySupport;

import java.util.ArrayList;
import java.util.List;

public class BasicAdapterActivity extends AppCompatActivity {

    RecyclerViewEmptySupport recyclerview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("TYPE");

        if (type.equalsIgnoreCase("adapterWithTextInXml")) {
            setContentView(R.layout.activity_basic_text_xml);
        } else if (type.equalsIgnoreCase("adapterWithImageInXml")) {
            setContentView(R.layout.activity_basic_image_xml);
        } else {//No need to add attributes in xml, if you are doing programatically
            setContentView(R.layout.activity_basic_adapter);
        }


        recyclerview1 = (RecyclerViewEmptySupport) findViewById(R.id.recyclerview1);
        List list = new ArrayList();
        HomeAdapter adapter = new HomeAdapter(list);

        initViews(type, adapter);
    }

    private void initViews(String type, RecyclerView.Adapter adapter) {

        switch (type) {
            case "onlyAdapter":
                recyclerview1.setAdapter(adapter);
                break;
            case "adapterWithTextInJava":
                recyclerview1.setAdapterWithEmptyTextView(adapter, "There are no record to show...");
                break;
            case "adapterWithTextInXml":
                recyclerview1.setAdapter(adapter);
                break;
            case "adapterWithImageInJava":
                recyclerview1.setAdapterWithEmptyImageView(adapter, ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
                //To set height/width programmatically UNIT is DP
                //recyclerview1.setAdapterWithEmptyImageView(adapter, ContextCompat.getDrawable(this, R.mipmap.ic_launcher), 100, 100);
                break;
            case "adapterWithDefaultImageInJava":
                recyclerview1.setAdapterWithEmptyImageView(adapter, null);
                break;
            case "adapterWithImageInXml":
                recyclerview1.setAdapter(adapter);
                break;
            case "pagination":
                final List list = new ArrayList();
                for (int i = 10; i < 20; i++) {
                    list.add(i + 1);
                }


                int visibleThreshold = 10;
                final int totalItemCount = 101;

                final HomeAdapter adapter1 = new HomeAdapter(list);

                recyclerview1.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

                recyclerview1.setPaginationAdapter(adapter1, visibleThreshold, totalItemCount, new RecyclerViewCallback() {
                    @Override
                    public void loadMoreItems(int pageNo) {
                        Log.d("TAG", "Page Number=" + pageNo);

                        for (int i = pageNo * 10; i < (pageNo * 10) + 10; i++) {
                            if (list.size() < totalItemCount) {
                                list.add(i + 1);
                            }
                        }
                        //update adapter
                        recyclerview1.updatePaginationAdapter(adapter1, list.size());
                    }

                    @Override
                    public void hasLoadedAllItems(boolean value) {
                        Log.d("TAG", "Reached to end");
                    }
                });

                break;
        }
    }
}
