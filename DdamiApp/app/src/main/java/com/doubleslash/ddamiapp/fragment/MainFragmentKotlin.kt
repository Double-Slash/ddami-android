package com.doubleslash.ddamiapp.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.Preconditions
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.doubleslash.ddamiapp.R
import com.doubleslash.ddamiapp.activity.DetailActivity
import com.doubleslash.ddamiapp.activity.MainActivity
import com.doubleslash.ddamiapp.activity.login.CustomBaseView
import com.doubleslash.ddamiapp.adapter.MainAdapter
import com.doubleslash.ddamiapp.adapter.OnItemClickListener
import com.doubleslash.ddamiapp.adapter.OnItemProfileClickListener
import com.doubleslash.ddamiapp.model.MainItem
import com.doubleslash.ddamiapp.network.kotlin.ApiService.homeService
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables.combineLatest
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragmentKotlin : Fragment(R.layout.fragment_main), OnItemClickListener, OnItemProfileClickListener {

    private var mAllDisposable: CompositeDisposable? = null
    private var mSortType: BehaviorSubject<String>? = null
    private var mFilterType: BehaviorSubject<String>? = null
    private var token: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        token = requireActivity().intent.getStringExtra("token")
        getUserInfo(token)

        setUpResultListener()
        //
//        getParentFragmentManager()setFragmentResultListener("key", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
//                // We use a String here, but any type that can be put in a Bundle is supported
//                String result = bundle.getString("bundleKey");
//                // Do something with the result...
//            }
//        });
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

//        String strFilter = getActivity().getIntent().getStringExtra("filter");
//      //  Toast.makeText(getActivity(),"filter = " + strFilter, Toast.LENGTH_LONG).show();
//        Log.d("진희: filter :: ", strFilter);
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(this)
        // We use a String here, but any type that can be put in a Bundle is supported


        setUpEnterNumberButtonClickListener()
//        Bundle bundle = this.getArguments();
//        String str = bundle.getString("filter");
        val activity = activity
        if (activity != null) {
            (activity as MainActivity).setActionBarTitle("따미마을")
        }
        initViews(view)
        // pieceSearch();
        initRx()
        val filters: MutableList<String> = ArrayList()
        filters.add("공예 디자인")
        filters.add("필터2")
        filters.add("필터3")
        addFilters(filters)
    }

    private fun initViews(view: View) {


        picture?.background = ShapeDrawable(OvalShape())
        picture?.clipToOutline = true

        mSortType = BehaviorSubject.createDefault("L")
        mFilterType = BehaviorSubject.createDefault("")
        mAllDisposable = CompositeDisposable()

        filter_popularity?.setOnClickListener(View.OnClickListener { mSortType!!.onNext("L") })
        filter_recent?.setOnClickListener(View.OnClickListener { mSortType!!.onNext("V") })
        filter?.setOnClickListener(View.OnClickListener { (activity as MainActivity?)!!.replaceFragment(FilterFragmentKotlin.newInstance()) })
    }

    @SuppressLint("CheckResult")
    private fun pieceSearch(sortType: String) {
        val items = ArrayList<MainItem>()
        val inputJson = JsonObject()
        inputJson.addProperty("list", 0)
        inputJson.addProperty("sortingBy", sortType)
        homeService.pieceSearch(inputJson)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ (pieces) ->
                    for (i in pieces.indices) {
                        val (author, _, fileUrl, id, _, _, likeCount, title, views) = pieces[i]
                        items.add(MainItem(id,
                                fileUrl[0],
                                title,
                                author.userId,
                                author.imageUrl,
                                views,
                                likeCount))
                    }
                    main_recyclerview!!.adapter = MainAdapter(items, OnItemClickListener { item: MainItem -> onHomeViewItemClicked(item) }, OnItemClickListener { item: MainItem -> onHomeProfileItemClicked(item) })
                }) { it: Throwable -> Log.e("Failed", it.toString()) }
    }

    @SuppressLint("CheckResult")
    private fun getUserInfo(token: String?) {
        val inputJson = JsonObject()
        inputJson.addProperty("token", token)
        homeService.userAuth(inputJson).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { (myInfo) ->
                            tv_home_user_name!!.text = myInfo.userName
                            Picasso.get().load(myInfo.imageUrl).into(picture)
                        }
                ) { it: Throwable -> Log.e("failed", it.toString()) }
    }

    private fun addFilters(filters: List<String>) {
        chip_container!!.removeAllViews()
        for (filter in filters) {
            val filterView = CustomBaseView(requireContext())
            filterView.setChipName(filter)
            chip_container!!.addView(filterView)
        }
    }

    override fun onHomeViewItemClicked(item: MainItem) {
        Toast.makeText(context, item.nickname, Toast.LENGTH_SHORT).show()
        val detailIntent = Intent(activity, DetailActivity::class.java)
        detailIntent.putExtra("token", token)
        detailIntent.putExtra("FileId", item.pieceId)
        startActivity(detailIntent)
    }

    override fun onHomeProfileItemClicked(item: MainItem) {
        Toast.makeText(context, item.nickname, Toast.LENGTH_SHORT).show()
    }

    private fun initRx() {
        mAllDisposable!!.add(combineLatest(mSortType!!, mFilterType!!)
                .doOnNext { (first, second) ->
                    if (first == null || second == null) {
                        mSortType!!.onNext("L")
                        mFilterType!!.onNext("")
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .distinctUntilChanged()
                .doOnNext { (first) -> pieceSearch(first) }
                .subscribe()
        )
    }

    @SuppressLint("RestrictedApi", "ShowToast")
    private fun onFragmentResult(requestKey: String, result: Bundle) {
        Preconditions.checkState(REQUEST_KEY == requestKey)

        val number = result.getInt(KEY_NUMBER)
        Log.e("서어어어어어고오오옹",number.toString())
    }

    private fun setUpEnterNumberButtonClickListener() {
        tv_filter.setOnClickListener {
            childFragmentManager.beginTransaction()
                    .replace(R.id.container, FilterFragmentKotlin::class.java, null)
                    .addToBackStack(null)
                    .commit()
        }
    }


    private fun setUpResultListener() {
        childFragmentManager.setFragmentResultListener(
                REQUEST_KEY,
                this,
                FragmentResultListener { requestKey, result ->
                    onFragmentResult(requestKey, result)
                })
    }

    companion object {
        val REQUEST_KEY = "key"
        val KEY_NUMBER = "key-number"

        fun newInstance(): MainFragmentKotlin {
            return MainFragmentKotlin()
        }
    }
}