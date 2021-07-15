package com.example.fetchingmysqldatatorecyclerviewusingretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>
{

    List<ResponseModel> data;

    public MyAdapter(List<ResponseModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull MyAdapter.Holder holder, int position)
    {
        holder.textView1.setText(data.get(position).getName());
        holder.textView2.setText(data.get(position).getEmail());
        Glide.with(holder.textView1.getContext()).load("http://192.168.29.74/api/images/"+data.get(position).getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView1, textView2;
        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView1 = (TextView) itemView.findViewById(R.id.textView1);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
