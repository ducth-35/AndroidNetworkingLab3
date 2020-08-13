package com.example.lab3;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    public Context context;
    public RecyclerView recyclerView;
    public List<About> getList;

    public Adapter(Context context, RecyclerView recyclerView, List<About> getList) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.getList = getList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.design, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        final About get = getList.get(position);
        viewHolder.title.setText(get.getTitle()+"");
        viewHolder.date.setText(get.getUrl()+"");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowData.class);
                intent.putExtra("link",get.url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getList.size();
    }
}
