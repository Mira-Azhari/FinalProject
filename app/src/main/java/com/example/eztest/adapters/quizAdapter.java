package com.example.eztest.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eztest.R;

import java.util.List;

public class quizAdapter extends RecyclerView.Adapter<quizAdapter.ViewHolder> {

    private List<String> Data;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    public quizAdapter(Context context, List<String> data) {
        Log.i("Mira", "quizadapter: ");
        this.mInflater = LayoutInflater.from(context);
        this.Data = data;
        Log.i("Mira", "quizadapter: ");
    }

    String getItem(int id) {
        return Data.get(id);
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.quiz_row, parent, false);
        Log.i("Mira", "oncreateViewHolder: ");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("Mira", "onBindViewHolder: ");
        String quiz = Data.get(position);
        holder.myTextView.setText(quiz);
        Log.i("Mira", "onBindViewHolder: "+quiz);
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.quizName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }




}