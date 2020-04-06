package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdepter extends RecyclerView.Adapter<RecyclerViewAdepter.ViewHolder>{

    private ArrayList<String> mName = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdepter(ArrayList<String> mName, Context mContext) {
        this.mName = mName;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mainmenurecyclerview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.MainMenuRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView RecyclerTextView;
        RelativeLayout MainMenuRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            RecyclerTextView = itemView.findViewById(R.id.MainMenuRecyclerView);
            MainMenuRecyclerView = itemView.findViewById(R.id.MainMenuRecyclerView);
        }
    }
}
