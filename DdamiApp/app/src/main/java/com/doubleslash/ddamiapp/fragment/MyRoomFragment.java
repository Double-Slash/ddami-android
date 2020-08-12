package com.doubleslash.ddamiapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.WritingActivity;
import com.doubleslash.ddamiapp.adapter.MyroomAdapter;
import com.doubleslash.ddamiapp.model.MyroomItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;



public class MyRoomFragment extends Fragment {
    TabLayout tabLayout;
    TextView name, id, program, field, followerNum, followingNum;
    CircleImageView profileImg;
    GridView gridView;
    RecyclerView recyclerView;
    Button btn_modify, btn_follow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_room, container, false);

        //get values from bundle
        String input_id = getArguments().getString("Id");
        int input_field_size = getArguments().getInt("FieldCount");
        int input_follow = getArguments().getInt("Follow");
        int input_follower = getArguments().getInt("Follower");
        String input_file = getArguments().getString("File0");
        String input_username = getArguments().getString("Username");
        String input_profile_img = getArguments().getString("ProfileImg");
        String input_fileId = getArguments().getString("FileId");
        Boolean input_state = getArguments().getBoolean("State");
        String fields = "";
        for (int i = 0; i < input_field_size; i++) {
            String input_like_field = getArguments().getString("LikeField" + String.valueOf(i));
            if (i != 0) {
                fields = fields.concat(" · " + input_like_field);
            } else fields = fields.concat(input_like_field);
        }


        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        FloatingActionButton btn_fab = (FloatingActionButton) view.findViewById(R.id.fab_myroom);

        name = (TextView) view.findViewById(R.id.name);
        id = (TextView) view.findViewById(R.id.id);
        program = (TextView) view.findViewById(R.id.program);
        field = (TextView) view.findViewById(R.id.field);
        followerNum = (TextView) view.findViewById(R.id.followerNum);
        followingNum = (TextView) view.findViewById(R.id.followingNum);
        profileImg = (CircleImageView) view.findViewById(R.id.profileImage);
        recyclerView = (RecyclerView) view.findViewById(R.id.myroom_recyclerview);
        btn_modify = (Button) view.findViewById(R.id.btn_modify);
        btn_follow = (Button) view.findViewById(R.id.btn_follow);

        //add values to the profile layout
       name.setText(input_username);
         id.setText(input_id);
        //program.setText(input_file);
        field.setText(fields);
        followerNum.setText(String.valueOf(input_follower));
        followingNum.setText(String.valueOf(input_follow));
        Picasso.get().load(input_profile_img).into(profileImg);


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


        //add fileUrls to the recyclerview
        ArrayList<MyroomItem> itemL = new ArrayList<>();
        MyroomItem item = new MyroomItem(input_file);
        itemL.add(item);

        RecyclerView.Adapter adapter = new MyroomAdapter(itemL);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);


//        bundle.putString("FileId", input_fileId);
//        DetailFragment detail = new DetailFragment();
//        detail.setArguments(bundle);
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
//                .add(R.id.nav_host_fragment, detail)
//                .commit();


        //FloatingActionButton onClick event
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), WritingActivity.class));

            }
        });

        //button display depends on the state

        return view;
    }
}
