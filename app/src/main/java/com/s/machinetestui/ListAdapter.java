package com.s.machinetestui;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {
    Context mContext;
    ArrayList<DataList> dataLists;


    public ListAdapter(Context mContext, ArrayList<DataList> dataLists) {
        this.mContext = mContext;
        this.dataLists = dataLists;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item_view, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        DataList dataList = dataLists.get(position);
        holder.textView4.setText(dataList.getName());
        holder.textView2.setText(dataList.getDate());
    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.circleImageView)
        CircleImageView circleImageView;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textView4)
        TextView textView4;
        @BindView(R.id.textView5)
        TextView textView5;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Collections.swap(dataLists, getAdapterPosition(), 0);
                    notifyItemMoved(getAdapterPosition(), 0);
                }
            });
        }
    }
}
