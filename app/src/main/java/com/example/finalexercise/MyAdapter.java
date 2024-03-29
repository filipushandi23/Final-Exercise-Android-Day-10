package com.example.finalexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexercise.model.URLData;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {

    private List<URLData> mListURL;
    MyAdapterClickHandler mClickHandler;

    public MyAdapter(MyAdapterClickHandler clickHandler){
        mClickHandler = clickHandler;
    }

    public interface MyAdapterClickHandler{
        void onClick(URLData data);
    }

    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewHolder holder, int position) {
        String name = mListURL.get(position).getNama();
        holder.textView.setText(name);
    }

    @Override
    public int getItemCount() {
        if(mListURL.size() != 0){
            return mListURL.size();
        }
        return 0;
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        public MyAdapterViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.list_item_text);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onClick(mListURL.get(adapterPosition));
        }
    }

    public void setListURL(List<URLData> listURL){
        mListURL = listURL;
        notifyDataSetChanged();
    }
}
