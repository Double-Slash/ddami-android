package com.doubleslash.ddamiapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.WritingActivity;
import com.doubleslash.ddamiapp.adapter.MainAdapter;
import com.doubleslash.ddamiapp.adapter.MyroomAdapter;
import com.doubleslash.ddamiapp.model.MainItem;
import com.doubleslash.ddamiapp.model.MyroomItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRoomFragment extends Fragment {
    TabLayout tabLayout;
    TextView name, id, program, field, followerNum, followingNum;
    CircleImageView profileImg;
    GridView gridView;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_room, container, false);
        Bundle bundle = new Bundle();

        //getting values from Bundle
        String input_id = getArguments().getString("Id");
        int input_field_size = getArguments().getInt("FieldCount");
        int input_follow = getArguments().getInt("Follow");
        int input_follower = getArguments().getInt("Follower");
        String input_file = getArguments().getString("File0");
        String input_username = getArguments().getString("Username");
        String input_profile_img = getArguments().getString("ProfileImg");
        String input_fileId = getArguments().getString("FileId");
        String fields = "";
        for(int i=0; i<input_field_size; i++) {
            String input_like_field = getArguments().getString("LikeField" + String.valueOf(i));
            if(i != 0) {
                fields = fields.concat(" · " + input_like_field);
            } else fields=fields.concat(input_like_field);
        }

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        FloatingActionButton btn_fab = (FloatingActionButton)view.findViewById(R.id.fab_myroom);
        name = (TextView)view.findViewById(R.id.name);
        id = (TextView)view.findViewById(R.id.id);
        program = (TextView)view.findViewById(R.id.program);
        field = (TextView)view.findViewById(R.id.field);
        followerNum = (TextView)view.findViewById(R.id.followerNum);
        followingNum = (TextView)view.findViewById(R.id.followingNum);
        profileImg = (CircleImageView)view.findViewById(R.id.profileImage);
        gridView = (GridView)view.findViewById(R.id.gridView);
        recyclerView = (RecyclerView)view.findViewById(R.id.myroom_recyclerview);

        name.setText(input_username);
        //id.setText(input_id);
        //program.setText(input_file);
        field.setText(fields);
        followerNum.setText(String.valueOf(input_follower));
        followingNum.setText(String.valueOf(input_follow));
        Picasso.get().load(input_file).into(profileImg);

        //Create tabs on TabLayout
        TabLayout.Tab tab = null;
        tab = tabLayout.newTab().setText("전체분야");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록1");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록2");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록3");
        tabLayout.addTab(tab);

        ArrayList<MyroomItem> itemL = new ArrayList<>();

        MyroomItem item = new MyroomItem("https://mblogthumb-phinf.pstatic.net/20160929_86/uidesignmage_1475139514655cRcSa_JPEG/%B5%F0%C0%DA%C0%CE%B8%DE%C0%CC%C1%F6_1.JPG?type=w800");
        MyroomItem item2 = new MyroomItem("https://lh3.googleusercontent.com/proxy/BXVOUTQo6OCR28ccw3o3t9ktZRmfGUubrZTb4YVt8Rw13keFUVAwZtRw5dSx7-NNmIfOUBrl27_uZS7Ryfw1Y8xZRt_BqyQxRBFxU_C7g7IlIOvbxrEUXQ");
        MyroomItem item3 = new MyroomItem("https://t1.daumcdn.net/cfile/tistory/2744FB4058719BE733");
        MyroomItem item4 = new MyroomItem("https://www.enewstoday.co.kr/news/photo/201805/1188725_303007_1317.jpg");

        itemL.add(item);
        itemL.add(item2);
        itemL.add(item3);
        itemL.add(item4);

        RecyclerView.Adapter adapter = new MyroomAdapter(itemL);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        //FloatingActionButton onClick event
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getActivity().startActivity(new Intent(getActivity(), WritingActivity.class));

                bundle.putString("FileId", input_fileId);
                DetailFragment detail = new DetailFragment();
                detail.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
                        .add(R.id.nav_host_fragment, detail)
                        .commit();
            }
        });

        return view;
    }
}
