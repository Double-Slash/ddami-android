package com.doubleslash.ddamiapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;

public class FilterFragment extends Fragment {
    Button allSpace, livingSpace, build, interior, inner, envir
            , allModern, painting, sculp
            , allCraft, pottery, metals, fiber, woodworking
            , picture, video, indus
            , reset, apply;

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static FilterFragment newInstance() {
        return new FilterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_filter, null);

        allSpace = (Button)view.findViewById(R.id.btn_allSpace);
        livingSpace = (Button)view.findViewById(R.id.btn_livingSpace);
        build = (Button)view.findViewById(R.id.btn_build);
        interior = (Button)view.findViewById(R.id.btn_interior);
        inner = (Button)view.findViewById(R.id.btn_inner);
        envir = (Button)view.findViewById(R.id.btn_envir);
        allModern = (Button)view.findViewById(R.id.btn_allMA);
        painting = (Button)view.findViewById(R.id.btn_painting);
        sculp = (Button)view.findViewById(R.id.btn_sculp);
        allCraft = (Button)view.findViewById(R.id.btn_allCraft);
        pottery = (Button)view.findViewById(R.id.btn_pottery);
        metals = (Button)view.findViewById(R.id.btn_metals);
        fiber = (Button)view.findViewById(R.id.btn_fiber);
        woodworking = (Button)view.findViewById(R.id.btn_woodworking);
        picture = (Button)view.findViewById(R.id.btn_pic);
        video = (Button)view.findViewById(R.id.btn_allVideo);
        indus = (Button)view.findViewById(R.id.btn_allIndus);
        reset = (Button)view.findViewById(R.id.reset_btn);
        apply = (Button)view.findViewById(R.id.apply_btn);


        return view;
    }
}
