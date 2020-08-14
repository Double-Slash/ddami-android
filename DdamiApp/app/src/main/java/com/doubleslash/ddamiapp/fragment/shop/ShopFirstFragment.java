package com.doubleslash.ddamiapp.fragment.shop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.shop.ShopNormalActivity;
import com.doubleslash.ddamiapp.activity.shop.ShopWorkDetailActivity;
import com.doubleslash.ddamiapp.adapter.OnItemClickListener;
import com.doubleslash.ddamiapp.adapter.OnShopItemClickListener;
import com.doubleslash.ddamiapp.model.Product;
import com.doubleslash.ddamiapp.model.ShopWorkItem;
import com.doubleslash.ddamiapp.activity.shop.ShopWritingActivity1_1;

import com.doubleslash.ddamiapp.adapter.ShopWorkAdapter;
import com.doubleslash.ddamiapp.network.kotlin.ApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class ShopFirstFragment extends Fragment implements OnShopItemClickListener {

    // 따미샵-작품샵 배열
    ArrayList<ShopWorkItem> mData=null;
    RecyclerView.Adapter mAdapter=null;
    RecyclerView recyclerView=null;

    Context context;
    //static ShopWorkItem shopWorkItem;

    TextView sort_popularity;
    TextView sort_recent;

    TextView filter;

    private CompositeDisposable mAllDisposable;

    private BehaviorSubject<String> mSortType;
    private BehaviorSubject<String> mFilterType;

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.shop_first_recyclerview);
        mData = new ArrayList<ShopWorkItem>();

        initViews(view);
        //initRx();

        final List<String> filters = new ArrayList<>();
        filters.add("공예 디자인");
        filters.add("필터2");
        filters.add("필터3");
        //addFilters(filters);
    }


    private void initViews(View view) {

        sort_popularity = view.findViewById(R.id.tv_shop_order_popularity);
        sort_recent = view.findViewById(R.id.tv_shop_order_recent);

        filter = view.findViewById(R.id.tv_shop_filter);

        mSortType = BehaviorSubject.createDefault("L");
        mFilterType = BehaviorSubject.createDefault("");

        mAllDisposable = new CompositeDisposable();

        sort_popularity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("정렬 확인", "인기순");
                mSortType.onNext("L");
            }
        });

        sort_recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("정렬 확인", "최신순");
                mSortType.onNext("V");
            }
        });


        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFilterType.onNext("sample19");
            }
        });

    }


    /*
    @SuppressLint("CheckResult")
    private void pieceSearch(String sortType) {

        ArrayList<ShopWorkItem> items = new ArrayList<>();

        JsonObject inputJson = new JsonObject();

        inputJson.addProperty("list", 0);
        inputJson.addProperty("sortingBy", sortType);

        ApiService.INSTANCE.getShopWorkService().shopWork(inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    Toast.makeText(context, "정렬 확인해보자: "+it.getProducts().get(0).getHasField()+"",Toast.LENGTH_LONG).show();
                    for (int i = 0; i < it.getProducts().size(); i++) {
                        Product product = it.getProducts().get(i);
                        items.add(new ShopWorkItem(product.getPieces().get(0).getFileUrl(),
                                product.getHasField(),
                                product.getTitle(),
                                product.getLocationName(),
                                product.getPrice(),
                                product.getViews(),
                                product.getLikeCount(),
                                product.get_id()));
                    }
                    recyclerView.setAdapter(new ShopWorkAdapter(items, this::onShopWorkClicked));
                }, it -> {
                    Log.e("Failed", it.toString());
                });
    }




    private void initRx() {
        mAllDisposable.add(Observables.INSTANCE.combineLatest(mSortType, mFilterType)
                .doOnNext(it -> {
                    if (it.getFirst() == null || it.getSecond() == null) {
                        mSortType.onNext("L");
                        mFilterType.onNext("");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .distinctUntilChanged()
                .doOnNext(
                        it -> {
                            pieceSearch(it.getFirst());
                        }

                )
                .subscribe()
        );
    }
*/

    @SuppressLint("CheckResult")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 따미샵 - 작품샵 - 서버연결
        JsonObject input = new JsonObject();
        ApiService.INSTANCE.getShopWorkService().shopWork(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            Toast.makeText(context, "서버 연결 성공"+it.getProducts().get(0).get_id(), Toast.LENGTH_SHORT).show();
                            Log.e("서버 연결 확인",it.getProducts().get(0).getPieces().get(0).getFileUrl().toString());

                            for(int i = 0; i<it.getProducts().size(); i++){
                                Product product = it.getProducts().get(i);
                                mData.add(new ShopWorkItem(product.getPieces().get(0).getFileUrl(), product.getHasField(), product.getTitle(), product.getLocationName(), product.getPrice(), product.getViews(), product.getLikeCount(),product.get_id()));
                            }

                            mAdapter = new ShopWorkAdapter(mData,this::onShopWorkClicked);
                            recyclerView.setAdapter(mAdapter);

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
                            recyclerView.setLayoutManager(gridLayoutManager);

                        }, it -> {
                            Toast.makeText(context, "서버 연결 실패", Toast.LENGTH_SHORT).show();


                        });

    }

    // 따미샵-작품: 플로팅버튼 이벤트처리
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=container.getContext();

        View v=inflater.inflate(R.layout.fragment_shop_first, container, false);
        FloatingActionButton btn=v.findViewById(R.id.floatingBtn_1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token=getActivity().getIntent().getStringExtra("token");

                // 미대생 인증 확인
                getUserInfo(token);

            }
        });

        return v;
    }

    @SuppressLint("CheckResult")
    private void getUserInfo(String token) {
        JsonObject inputJson = new JsonObject();

        inputJson.addProperty("token", token);
        Log.e("test",token);
        ApiService.INSTANCE.getHomeService().userAuth(inputJson).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        it -> {
                            ApiService.INSTANCE.getShopUser().shopUserAuth(it.getMyInfo().getId())
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(
                                            subs -> {
                                                //if(!subs.getUser().getState()){
                                                //getActivity().startActivity(new Intent(getActivity(), ShopNormalActivity.class));
                                                //}
                                                //if(subs.getUser().getState()){

                                                Intent intent=new Intent(getActivity(), ShopWritingActivity1_1.class);
                                                intent.putExtra("token", token);
                                                startActivity(intent);

                                                //getActivity().startActivity(new Intent(getActivity(), ShopWritingActivity1_1.class));
                                                //}
                                            },
                                            subs -> {
                                                Log.e("미대생 인증 확인 오류", it.toString());
                                            }
                                    );
                        }, it -> {
                            Log.e("failed", it.toString());
                        }
                );
    }

    @Override
    public void onShopWorkClicked(ShopWorkItem shopWorkItem) {
        Toast.makeText(getContext(), shopWorkItem.getmWork(), Toast.LENGTH_LONG).show();
        Intent detailShopIntent = new Intent(getActivity(),ShopWorkDetailActivity.class);
        detailShopIntent.putExtra("id",shopWorkItem.getId());
        startActivity(detailShopIntent);
    }

    //public static ShopWorkItem getShopWorkItem(){
    //return shopWorkItem;
    //}
}