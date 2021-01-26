package com.s.machinetestui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mRecyclerViewMenu)
    RecyclerView mRecyclerViewMenu;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View action_bar_view = inflater.inflate(R.layout.custom_bar_image, null);
        actionBar.setCustomView(action_bar_view);
        TextView textViewDisplayName = action_bar_view.findViewById(R.id.textViewDisplayName);
        CircleImageView profileImage = action_bar_view.findViewById(R.id.profile_image);
        textViewDisplayName.setText("Connects");
        Picasso.get()
                .load("https://st1.bollywoodlife.com/wp-content/uploads/2020/05/Akshay-Kumar-.jpg")
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(profileImage);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);


        bindMenus();
        getList();
    }

    private void getList() {
        ArrayList<DataList> dataLists=new ArrayList<>();
        dataLists.add(new DataList("2 days ago","Hindustan Feeds, India"));
        dataLists.add(new DataList("Feb 20, 2020","Hari Inc, Iran"));
        dataLists.add(new DataList("Feb 20, 2020","Hind Traders., India"));
        dataLists.add(new DataList("Feb 20, 2020","Herry Ltd, India"));
        ListAdapter adapter=new ListAdapter(this,dataLists);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }

    private void bindMenus() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            menuItems.add(new MenuItem("" + i, false));
//        }
        menuItems.add(new MenuItem("Leads", false));
        menuItems.add(new MenuItem("Distributors", false));
        menuItems.add(new MenuItem("Retailers" , false));


        MenuItemListAdpater adpater = new MenuItemListAdpater(this, menuItems);
        mRecyclerViewMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewMenu.setAdapter(adpater);
    }
}