package com.doubleslash.ddamiapp.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;
import com.doubleslash.ddamiapp.activity.login.CustomBaseView;
import com.doubleslash.ddamiapp.adapter.MainAdapter;
import com.doubleslash.ddamiapp.adapter.OnItemClickListener;
import com.doubleslash.ddamiapp.model.MainItem;
import com.doubleslash.ddamiapp.model.Piece;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainFragment extends Fragment implements OnItemClickListener {
    MainItem item;
    TextView filter;
    TextView userName;
    ImageView userThumbnail;

    private LinearLayout mChipContainer;
    private RecyclerView recyclerView;


    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String token = getActivity().getIntent().getStringExtra("token");

        getUserInfo(token);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
//
//        Bundle bundle = this.getArguments();
//        String str = bundle.getString("filter");

        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).setActionBarTitle("따미마을");
        }

        initViews(view);
        pieceSearch();

        final List<String> filters = new ArrayList<>();
        filters.add("공예 디자인");
        filters.add("필터2");
        filters.add("필터3");
        addFilters(filters);
    }

    private void initViews(View view) {
        mChipContainer = view.findViewById(R.id.chip_container);
        recyclerView = view.findViewById(R.id.main_recyclerview);
        userName = view.findViewById(R.id.tv_home_user_name);
        userThumbnail = view.findViewById(R.id.picture);

        userThumbnail.setBackground(new ShapeDrawable(new OvalShape()));
        userThumbnail.setClipToOutline(true);
    }

    @SuppressLint("CheckResult")
    private void pieceSearch() {

        ArrayList<MainItem> items = new ArrayList<>();

        JsonObject inputJson = new JsonObject();

        inputJson.addProperty("list", 0);

        ApiService.INSTANCE.getHomeService().pieceSearch(inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    for (int i = 0; i < it.getPieces().size(); i++) {
                        Piece piece = it.getPieces().get(i);
                        items.add(new MainItem(piece.getFileUrl().get(0),
                                piece.getTitle(),
                                piece.getAuthor().getUserId(),
                                piece.getAuthor().getImageUrl(),
                                piece.getViews(),
                                piece.getLikeCount()));
                    }
                    recyclerView.setAdapter(new MainAdapter(items,this::onHomeItemClicked));
                }, it -> {
                    Log.e("Failed", it.toString());
                });
    }

    @SuppressLint("CheckResult")
    private void getUserInfo(String token) {
        JsonObject inputJson = new JsonObject();

        inputJson.addProperty("token", token);
        ApiService.INSTANCE.getHomeService().userAuth(inputJson).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            userName.setText(it.getMyInfo().getUserName());
                            Picasso.get().load(it.getMyInfo().getImageUrl()).into(userThumbnail);

                        }, it -> {
                            Log.e("failed", it.toString());
                        }
                );
    }

    private void addFilters(List<String> filters) {
        mChipContainer.removeAllViews();

        for (String filter : filters) {
            final CustomBaseView filterView = new CustomBaseView(requireContext());
            filterView.setChipName(filter);

            mChipContainer.addView(filterView);
        }
    }


    @Override
    public void onHomeItemClicked(MainItem item) {
        Toast.makeText(getContext(),item.getNickname(),Toast.LENGTH_SHORT).show();
    }
}
