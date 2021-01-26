package com.s.machinetestui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuItemListAdpater extends RecyclerView.Adapter<MenuItemListAdpater.Holder> {

    Context mContext;
    ArrayList<MenuItem> menuItems;
    int checkedPosition = 0;


    public MenuItemListAdpater(Context mContext, ArrayList<MenuItem> menuItems) {
        this.mContext = mContext;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        MenuItem menuItem = menuItems.get(position);

        holder.mTextViewTitle.setText(menuItem.getTitle());

        if (position == 0) {
            holder.mLayoutBackground.setBackground(mContext.getResources().getDrawable(R.drawable.select_bg));
            holder.mTextViewTitle.setTextColor(mContext.getResources().getColor(R.color.colorWhite));
        } else if (menuItem.isChecked() == true) {
            holder.mLayoutBackground.setBackground(mContext.getResources().getDrawable(R.drawable.select_bg));
            holder.mTextViewTitle.setTextColor(mContext.getResources().getColor(R.color.colorWhite));
        } else {
            menuItems.set(position, new MenuItem(false));
            holder.mLayoutBackground.setBackground(mContext.getResources().getDrawable(R.drawable.unselect_bg));
            holder.mTextViewTitle.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
        }
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.mTextViewTitle)
        TextView mTextViewTitle;
        @BindView(R.id.mLayoutBackground)
        ConstraintLayout mLayoutBackground;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

    }
}
