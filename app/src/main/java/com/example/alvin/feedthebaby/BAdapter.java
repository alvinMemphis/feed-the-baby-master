package com.example.alvin.feedthebaby;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class BAdapter extends RecyclerView.Adapter<BAdapter.BViewHolder> {

    List<Diet> dietsList;
    public BAdapter(List<Diet> dietsList) {
        this.dietsList = dietsList;
    }

    @Override
    public BAdapter.BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet_list_row,parent,false);
        BViewHolder vh = new BViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(BAdapter.BViewHolder holder, int position) {
        holder.age.setText(dietsList.get(position).getAge());
        holder.food.setText(dietsList.get(position).getFood());
        holder.quantity.setText(dietsList.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return dietsList.size();
    }

    public class BViewHolder extends RecyclerView.ViewHolder{
        public TextView age, food, quantity;
        public BViewHolder(View view) {
            super(view);
            age = (TextView) view.findViewById(R.id.age);
            food = (TextView) view.findViewById(R.id.food);
            quantity = (TextView) view.findViewById(R.id.quantity);
        }
    }
}
