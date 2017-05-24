package com.virendra.recyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.virendra.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by virendra on 24/5/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    List data = new ArrayList();
    Context context;

    public HomeAdapter(Context context, List<Object> list) {
        this.data = list;
        this.context = context;
    }

    public HomeAdapter(List<Object> list) {
        this.data = list;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_home_list, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.textView.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return null != data ? data.size() : 0;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public HomeViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}