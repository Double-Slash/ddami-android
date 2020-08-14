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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.DetailActivity;
import com.doubleslash.ddamiapp.activity.WritingActivity;
import com.doubleslash.ddamiapp.adapter.MyroomAdapter;
import com.doubleslash.ddamiapp.model.MyroomItem;
import com.doubleslash.ddamiapp.model.UserRoomInfo;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MyRoomFragment extends Fragment {
    TabLayout tabLayout;
    TextView name, id, program, field, followerNum, followingNum;
    CircleImageView profileImg;
    GridView gridView;
    RecyclerView recyclerView;
    Button btn_modify, btn_follow;
    FloatingActionButton btn_fab;
    //Bundle bundle = new Bundle();
    ArrayList<MyroomItem> itemL = new ArrayList<>();
    int flag = 1;
    String token;
    String authId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_room, container, false);

        token = getArguments().getString("token");
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
        authId = getArguments().getString("AuthId");

        if(getArguments().getBoolean("Myroom")) {
            btn_fab.setVisibility(View.VISIBLE);
            btn_modify.setVisibility(View.VISIBLE);
            btn_follow.setVisibility(View.GONE);
            myroom();
        } else {
            JsonObject json = new JsonObject();
            json.addProperty("token", token);
            ApiService.INSTANCE.getMyInfo().myinfo(json)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            it -> {
                                //if authid == myid show myroom()
                                if(it.getMyInfo().getId().equals(authId)) {
                                    btn_fab.setVisibility(View.VISIBLE);
                                    btn_modify.setVisibility(View.VISIBLE);
                                    btn_follow.setVisibility(View.GONE);
                                    userroom();
                                    //if authid != myid show userroom()
                                } else if(!it.getMyInfo().getId().equals(getArguments().getString("AuthId"))){
                                    btn_fab.setVisibility(View.GONE);
                                    btn_modify.setVisibility(View.GONE);
                                    btn_follow.setVisibility(View.VISIBLE);
                                    userroom();
                                }
                            },
                            it -> {
                                Log.e("fff@@@!!!", it.toString());
                            }
                    );
        }

        followUnfollow(authId);

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

        //when recyclerview item clicked, go to DetailActivity
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
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    //intent.putExtra("FileId", currentItem.getId());
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

        //FloatingActionButton onClick event
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), WritingActivity.class));

            }
        });


        //button display depends on the state
        btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService.INSTANCE.getFollowService().follow(token,authId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                it -> {
                                    Log.e("follow/unfollow!!", it.toString());
                                    if(btn_follow.getText().toString().equals("+ Follow")) {
                                        btn_follow.setText("Unfollow");
                                    } else if(btn_follow.getText().toString().equals("Unfollow")) {
                                        btn_follow.setText("+ Follow");
                                    }
                                    userroom();
                                    flag++;
                                },
                                it -> {
                                    Log.e("fail!!!", it.toString());
                                }
                        );
            }
        });
        return view;

    }

    public void myroom() {
        String fields = "";
        for (int i = 0; i < getArguments().getInt("FieldCount"); i++) {
            String input_like_field = getArguments().getString("LikeField" + String.valueOf(i));
            if (i != 0) {
                fields = fields.concat(" · " + input_like_field);
            } else fields = fields.concat(input_like_field);
        }

        for (int i = 0; i < getArguments().getInt("FileCount"); i++) {
            String input_file = getArguments().getString("File" + String.valueOf(i));
            String input_file_id = getArguments().getString("FileId" + String.valueOf(i));
            MyroomItem item = new MyroomItem(input_file, input_file_id);
            itemL.add(item);
        }

        UserRoomInfo user = new UserRoomInfo(
                getArguments().getString("Username"),
                getArguments().getString("UserId"),
                getArguments().getString("Program"),
                fields,
                getArguments().getInt("Follow"),
                getArguments().getInt("Follower"),
                itemL,
                getArguments().getString("ProfileImg")
        );

        name.setText(user.getName());
        id.setText(user.getUserId());
        program.setText(user.getProgram());
        field.setText(user.getField());
        followerNum.setText(String.valueOf(user.getFollower()));
        followingNum.setText(String.valueOf(user.getFollowing()));
        Picasso.get().load(user.getProfile()).into(profileImg);
        createTab(getArguments().getInt("FileCount"));
    }

    public void userroom() {
        ApiService.INSTANCE.getUserRoomService().userroom(authId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            Log.e("sssssssssssssssssucc", it.toString());
                            String str = "";
                            for (int i = 0; i < it.getUser().getLikeField().size(); i++) {
                                if (i != 0) {
                                    str = str.concat(" · " + it.getUser().getLikeField().get(i));
                                } else
                                    str = str.concat(it.getUser().getLikeField().get(i).toString());
                            }

                            for (int i = 0; i < it.getUser().getMyPieces().size(); i++) {
                                String input_file = it.getUser().getMyPieces().get(i).getFileUrl().get(0);
                                String input_file_id = it.getUser().getMyPieces().get(i).getId();
                                MyroomItem item = new MyroomItem(input_file, input_file_id);
                                itemL.add(item);
                            }

                            UserRoomInfo user = new UserRoomInfo(
                                    it.getUser().getUserName(),
                                    it.getUser().getUserId(),
                                    it.getUser().getStudent().getDepartment(),
                                    str,
                                    it.getUser().getFollow(),
                                    it.getUser().getFollowerCount(),
                                    itemL,
                                    it.getUser().getImageUrl()
                            );

                            name.setText(user.getName());
                            id.setText(user.getUserId());
                            field.setText(user.getField());
                            program.setText(user.getProgram());
                            followerNum.setText(String.valueOf(user.getFollower()));
                            followingNum.setText(String.valueOf(user.getFollowing()));
                            Picasso.get().load(user.getProfile()).into(profileImg);
                            if(flag==1) {
                                createTab(user.getFile().size());
                            }
                        },
                        it -> {
                            Log.e("fffffffffffail", it.toString());
                        }
                );
    }

    public void createTab(int i) {
        //Create tabs on TabLayout
        TabLayout.Tab tab = null;
        tab = tabLayout.newTab().setText("전체분야 " + String.valueOf(i));
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록1");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록2");
        tabLayout.addTab(tab);
        tab = tabLayout.newTab().setText("커스텀목록3");
        tabLayout.addTab(tab);
    }

    private void followUnfollow(String authId) {
        JsonObject input = new JsonObject();
        ApiService.INSTANCE.getFollowService().checkFollow(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            for(int i=0; i<it.getAuthors().size(); i++) {
                                if(it.getAuthors().get(i).getId().equals(authId)) {
                                    if(it.getAuthors().get(i).getFollowByMe()) {
                                        btn_follow.setText("Unfollow");
                                    } btn_follow.setText("+ Follow");
                                    break;
                                }
                            }
                        },
                        it -> {
                            Log.e("followfail!!!", it.toString());
                        }
                );
    }
}
