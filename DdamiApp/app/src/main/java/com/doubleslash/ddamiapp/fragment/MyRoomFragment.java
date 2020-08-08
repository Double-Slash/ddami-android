package com.doubleslash.ddamiapp.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.WritingActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRoomFragment extends Fragment {
    TabLayout tabLayout;
    TextView name, id, program, field, followerNum, followingNum;
    CircleImageView profileImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_room, container, false);

        //getting values from Bundle
        String input_id = getArguments().getString("Id");
        int input_field_size = getArguments().getInt("FieldCount");
        int input_follow = getArguments().getInt("Follow");
        int input_follower = getArguments().getInt("Follower");
        String input_file = getArguments().getString("File0");
        String input_username = getArguments().getString("Username");
        String input_profile_img = getArguments().getString("ProfileImg");
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

        //FloatingActionButton onClick event
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), WritingActivity.class));
            }
        });

        return view;
    }

}
