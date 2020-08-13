package com.doubleslash.ddamiapp.fragment.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.shop.ShopWritingActivity1_1;
import com.doubleslash.ddamiapp.activity.MainActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.DetailActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ShopFirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//
//    public ShopFirstFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ShopFirstFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ShopFirstFragment newInstance(String param1, String param2) {
//        ShopFirstFragment fragment = new ShopFirstFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    // 따미샵-작품: 플로팅버튼 이벤트처리
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_shop_first, container, false);
        FloatingActionButton btn=v.findViewById(R.id.floatingBtn_1);
        TextView filter = (TextView)v.findViewById(R.id.textView7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    getActivity().startActivity(new Intent(getActivity(), ShopWritingActivity1_1.class));
            }
        });

//        DialogFragment dialogView = layoutInflater.inflate(R.layout.fragment_filter, null);
//        DialogFragment dialog = BottomSheetDialog(this);
//        dialog.setContentView(dialogView);
//        dialog.show();
//
//        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
//        bottomSheetDialog.setContentView(R.layout.fragment_filter);
//        bottomSheetDialog.show();
//

//
//
//        filter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity)getActivity()).replaceFragment(FilterFragment.newInstance());
//            }
//        });

//                FilterFragment bottomSheetDialog = FilterFragment.newInstance();
//                bottomSheetDialog.setContentView(R.layout.fragment_filter);
//                bottomSheetDialog.show(getSupportFragmentManager(),"bottomSheet");

//
//        //persistentBottomSheet로 사용할 view 획득
//        View bottomSheet = (CoordinatorLayout)v.findViewById(R.id.filter_whole_layout);
//        //획득한 view를 bottomsheet로 지정
//        BottomSheetBehavior sheetBehavior = BottomSheetBehavior.from(bottomSheet);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(R.layout.fragment_filter);
                bottomSheetDialog.show();

            }
        });


        return v;
    }

}