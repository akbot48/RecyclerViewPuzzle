package com.aa.recyclerviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter {


    public List<AbsData> getData() {
        return data;
    }

    List<AbsData> data = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (data.get(viewType).getType()) {
            case 1:
                return new AHolder(LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_a, parent, false));
            case 2:
                return new BHolder(LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_b, parent, false));
            case 3:
                return new CHolder(LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_c, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AbsData dataInList = this.data.get(position);
        switch (dataInList.getType()) {
            case 1:
                AHolder a = (AHolder) holder;
                break;
            case 2:
                BHolder b = (BHolder) holder;
                break;
            case 3:
                CHolder c = (CHolder) holder;
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void addItem(AbsData data) {
        this.data.add(data);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
