package com.doubleslash.ddamiapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.widget.AppCompatImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;

import com.doubleslash.ddamiapp.activity.MainActivity;

import com.doubleslash.ddamiapp.activity.DetailActivity;

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
    FloatingActionButton btn_fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_room, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        btn_fab = (FloatingActionButton) view.findViewById(R.id.fab_myroom);
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
        ImageView imgView = (ImageView) view.findViewById(R.id.myroom_itemimage);

        if (!getArguments().getBoolean("Myroom")) {
            btn_fab.setVisibility(View.GONE);
            btn_modify.setVisibility(View.GONE);
            btn_follow.setVisibility(View.VISIBLE);
        }

        //get values from bundle
        String input_id = getArguments().getString("Id");
        int input_field_size = getArguments().getInt("FieldCount");
        int input_follow = getArguments().getInt("Follow");
        int input_follower = getArguments().getInt("Follower");
        String input_username = getArguments().getString("Username");
        String input_profile_img = getArguments().getString("ProfileImg");
        int input_file_count = getArguments().getInt("FileCount");
        String input_program = getArguments().getString("Program");

        String fields = "";
        for (int i = 0; i < input_field_size; i++) {
            String input_like_field = getArguments().getString("LikeField" + String.valueOf(i));
            if (i != 0) {
                fields = fields.concat(" · " + input_like_field);
            } else fields = fields.concat(input_like_field);
        }

        ArrayList<MyroomItem> itemL = new ArrayList<>();
        for (int i = 0; i < input_file_count; i++) {
            String input_file = getArguments().getString("File" + String.valueOf(i));
            String input_file_id = getArguments().getString("FileId" + String.valueOf(i));
            MyroomItem item = new MyroomItem(input_file, input_file_id);
            itemL.add(item);
        }

        //add values to the profile layout
        name.setText(input_username);
        id.setText(input_id);
        program.setText(input_program);
        field.setText(fields);
        followerNum.setText(String.valueOf(input_follower));
        followingNum.setText(String.valueOf(input_follow));
        Picasso.get().load(input_profile_img).into(profileImg);

        //Create tabs on TabLayout
        TabLayout.Tab tab = null;
        tab = tabLayout.newTab().setText("전체분야 " + String.valueOf(input_file_count));
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록1");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록2");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록3");
        tabLayout.addTab(tab);

        RecyclerView.Adapter adapter = new MyroomAdapter(itemL);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);


        GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        RecyclerView.OnItemTouchListener onItemTouchListener = new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                //get corresponding item
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && gestureDetector.onTouchEvent(e)) {
                    //get position of current item
                    int currentPosition = rv.getChildAdapterPosition(childView);

                    //get data
                    MyroomItem currentItem = itemL.get(currentPosition);
                    Log.e("hhhhere", "현재 터치한 item의 position은 " + currentItem.getId());

                    //switch fragment to DetailActivity onItemClicked
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("FileId", currentItem.getId());
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        };

        recyclerView.addOnItemTouchListener(onItemTouchListener);

//        bundle.putString("FileId", input_fileId);
//        DetailFragment detail = new DetailFragment();
//        detail.setArguments(bundle);
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment))
//                .add(R.id.nav_host_fragment, detail)
//                .commit();


//        GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
//            @Override
//            public boolean onSingleTapUp(MotionEvent e) {
//                return true;
//            }
//        });
//
//        RecyclerView.OnItemTouchListener onItemTouchListener = new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                //get corresponding item
//                View childView = rv.findChildViewUnder(e.getX(), e.getY());
//                if (childView != null && gestureDetector.onTouchEvent(e)) {
//                    //get position of current item
//                    int currentPosition = rv.getChildAdapterPosition(childView);
//
//                    //get data
//                    MyroomItem currentItem = itemL.get(currentPosition);
//                    Log.e("hhhhere", "현재 터치한 item의 position은 " + currentItem.getId());
//
//                    //switch fragment to DetailActivity onItemClicked
//                    Intent intent = new Intent(getActivity(), DetailActivity.class);
//                    intent.putExtra("FileId", currentItem.getId());
//                    startActivity(intent);
//                    return true;
//                }
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//            }
//        };

        recyclerView.addOnItemTouchListener(onItemTouchListener);

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