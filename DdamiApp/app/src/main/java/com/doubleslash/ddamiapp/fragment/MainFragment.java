//package com.doubleslash.ddamiapp.fragment;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.graphics.drawable.ShapeDrawable;
//import android.graphics.drawable.shapes.OvalShape;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.doubleslash.ddamiapp.R;
//import com.doubleslash.ddamiapp.activity.DetailActivity;
//import com.doubleslash.ddamiapp.activity.MainActivity;
//import com.doubleslash.ddamiapp.activity.login.CustomBaseView;
//import com.doubleslash.ddamiapp.adapter.MainAdapter;
//import com.doubleslash.ddamiapp.adapter.OnItemClickListener;
//import com.doubleslash.ddamiapp.adapter.OnItemProfileClickListener;
//import com.doubleslash.ddamiapp.model.MainItem;
//import com.doubleslash.ddamiapp.model.Piece;
//import com.doubleslash.ddamiapp.network.kotlin.ApiService;
//import com.google.gson.JsonObject;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.rxkotlin.Observables;
//import io.reactivex.schedulers.Schedulers;
//import io.reactivex.subjects.BehaviorSubject;
//
//public class MainFragmentKotlin extends Fragment implements OnItemClickListener, OnItemProfileClickListener {
//    MainItem item;
//    TextView filter;
//    TextView userName;
//    TextView sort_popularity;
//    TextView sort_recent;
//
//    ImageView userThumbnail;
//
//    String token;
//
//    private LinearLayout mChipContainer;
//    private RecyclerView recyclerView;
//    private CompositeDisposable mAllDisposable;
//
//    private BehaviorSubject<String> mSortType;
//    private BehaviorSubject<String> mFilterType;
//
//
//    public static MainFragmentKotlin newInstance() {
//        return new MainFragmentKotlin();
//    }
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        token = getActivity().getIntent().getStringExtra("token");
//
//        getUserInfo(token);
////
////        getParentFragmentManager()setFragmentResultListener("key", this, new FragmentResultListener() {
////            @Override
////            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
////                // We use a String here, but any type that can be put in a Bundle is supported
////                String result = bundle.getString("bundleKey");
////                // Do something with the result...
////            }
////        });
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_main, container, false);
//
//
////
////        String strFilter = getActivity().getIntent().getStringExtra("filter");
////      //  Toast.makeText(getActivity(),"filter = " + strFilter, Toast.LENGTH_LONG).show();
////        Log.d("진희: filter :: ", strFilter);
//
//
//        return view;
//    }
//
//    @SuppressLint("CheckResult")
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
////
////
////        Bundle bundle = this.getArguments();
////        String str = bundle.getString("filter");
//
//        FragmentActivity activity = getActivity();
//        if (activity != null) {
//            ((MainActivity) activity).setActionBarTitle("따미마을");
//        }
//
//        initViews(view);
//       // pieceSearch();
//        initRx();
//
//        final List<String> filters = new ArrayList<>();
//        filters.add("공예 디자인");
//        filters.add("필터2");
//        filters.add("필터3");
//        addFilters(filters);
//    }
//
//    private void initViews(View view) {
//        mChipContainer = view.findViewById(R.id.chip_container);
//        recyclerView = view.findViewById(R.id.main_recyclerview);
//        userName = view.findViewById(R.id.tv_home_user_name);
//        userThumbnail = view.findViewById(R.id.picture);
//
//        userThumbnail.setBackground(new ShapeDrawable(new OvalShape()));
//        userThumbnail.setClipToOutline(true);
//
//        sort_popularity = view.findViewById(R.id.filter_popularity);
//        sort_recent = view.findViewById(R.id.filter_recent);
//
//        filter = view.findViewById(R.id.tv_filter);
//
//        mSortType = BehaviorSubject.createDefault("L");
//        mFilterType = BehaviorSubject.createDefault("");
//
//        mAllDisposable = new CompositeDisposable();
//
//        sort_popularity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mSortType.onNext("L");
//            }
//        });
//
//        sort_recent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mSortType.onNext("V");
//            }
//        });
//
//        filter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity)getActivity()).replaceFragment(FilterFragmentKotlin.newInstance());
//            }
//        });
//    }
//
//    @SuppressLint("CheckResult")
//    private void pieceSearch(String sortType) {
//
//        ArrayList<MainItem> items = new ArrayList<>();
//
//        JsonObject inputJson = new JsonObject();
//
//        inputJson.addProperty("list", 0);
//        inputJson.addProperty("sortingBy", sortType);
//
//        ApiService.INSTANCE.getHomeService().pieceSearch(inputJson)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(it -> {
//                    for (int i = 0; i < it.getPieces().size(); i++) {
//                        Piece piece = it.getPieces().get(i);
//                        items.add(new MainItem(piece.getId(),
//                                piece.getFileUrl().get(0),
//                                piece.getTitle(),
//                                piece.getAuthor().getUserId(),
//                                piece.getAuthor().getImageUrl(),
//                                piece.getViews(),
//                                piece.getLikeCount()));
//                    }
//                    recyclerView.setAdapter(new MainAdapter(items, this::onHomeViewItemClicked, this::onHomeProfileItemClicked));
//                }, it -> {
//                    Log.e("Failed", it.toString());
//                });
//    }
//
//    @SuppressLint("CheckResult")
//    private void getUserInfo(String token) {
//        JsonObject inputJson = new JsonObject();
//
//        inputJson.addProperty("token", token);
//        ApiService.INSTANCE.getHomeService().userAuth(inputJson).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        it -> {
//                            userName.setText(it.getMyInfo().getUserName());
//                            Picasso.get().load(it.getMyInfo().getImageUrl()).into(userThumbnail);
//
//                        }, it -> {
//                            Log.e("failed", it.toString());
//                        }
//                );
//    }
//
//    private void addFilters(List<String> filters) {
//        mChipContainer.removeAllViews();
//
//        for (String filter : filters) {
//            final CustomBaseView filterView = new CustomBaseView(requireContext());
//            filterView.setChipName(filter);
//
//            mChipContainer.addView(filterView);
//        }
//    }
//
//
//    @Override
//    public void onHomeViewItemClicked(MainItem item) {
//        Toast.makeText(getContext(), item.getNickname(), Toast.LENGTH_SHORT).show();
//
//        Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
//        detailIntent.putExtra("token", token);
//        detailIntent.putExtra("FileId", item.getPieceId());
//        startActivity(detailIntent);
//
//    }
//
//    @Override
//    public void onHomeProfileItemClicked(MainItem item) {
//        Toast.makeText(getContext(), item.getNickname(), Toast.LENGTH_SHORT).show();
//    }
//
//    private void initRx() {
//        mAllDisposable.add(Observables.INSTANCE.combineLatest(mSortType, mFilterType)
//                .doOnNext(it -> {
//                    if (it.getFirst() == null || it.getSecond() == null) {
//                        mSortType.onNext("L");
//                        mFilterType.onNext("");
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .distinctUntilChanged()
//                .doOnNext(
//                        it -> {
//                            pieceSearch(it.getFirst());
//                        }
//
//                )
//                .subscribe()
//        );
//    }
//}
