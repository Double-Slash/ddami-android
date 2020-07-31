package com.doubleslash.ddamiapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;

import static android.graphics.Color.rgb;

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
        View view = inflater.inflate(R.layout.fragment_filter, container, false);


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


        /*각 버튼 클릭 이벤트*/
        allSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(allSpace.isSelected()) {
                    allSpace.setSelected(false);
                    allSpace.setTextColor(rgb(160,160,160));

                } else if(!allSpace.isSelected()){

                    allSpace.setSelected(true);
                    allSpace.setTextColor(Color.WHITE);
                }
            }
        });

        livingSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livingSpace.isSelected()) {
                    livingSpace.setSelected(false);
                    livingSpace.setTextColor(rgb(160,160,160));

                } else if(!livingSpace.isSelected()){

                    livingSpace.setSelected(true);
                    livingSpace.setTextColor(Color.WHITE);
                }
            }
        });

        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(build.isSelected()) {
                    build.setSelected(false);
                    build.setTextColor(rgb(160,160,160));

                } else if(!build.isSelected()){

                    build.setSelected(true);
                    build.setTextColor(Color.WHITE);
                }
            }
        });

        interior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interior.isSelected()) {
                    interior.setSelected(false);
                    interior.setTextColor(rgb(160,160,160));

                } else if(!interior.isSelected()){

                    interior.setSelected(true);
                    interior.setTextColor(Color.WHITE);
                }
            }
        });

        inner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inner.isSelected()) {
                    inner.setSelected(false);
                    inner.setTextColor(rgb(160,160,160));

                } else if(!inner.isSelected()){

                    inner.setSelected(true);
                    inner.setTextColor(Color.WHITE);
                }
            }
        });

        envir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(envir.isSelected()) {
                    envir.setSelected(false);
                    envir.setTextColor(rgb(160,160,160));

                } else if(!envir.isSelected()){

                    envir.setSelected(true);
                    envir.setTextColor(Color.WHITE);
                }
            }
        });

        allModern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allModern.isSelected()) {
                    allModern.setSelected(false);
                    allModern.setTextColor(rgb(160,160,160));

                } else if(!allModern.isSelected()){

                    allModern.setSelected(true);
                    allModern.setTextColor(Color.WHITE);
                }
            }
        });

        painting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(painting.isSelected()) {
                    painting.setSelected(false);
                    painting.setTextColor(rgb(160,160,160));

                } else if(!painting.isSelected()){

                    painting.setSelected(true);
                    painting.setTextColor(Color.WHITE);
                }
            }
        });

        sculp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sculp.isSelected()) {
                    sculp.setSelected(false);
                    sculp.setTextColor(rgb(160,160,160));

                } else if(!sculp.isSelected()){

                    sculp.setSelected(true);
                    sculp.setTextColor(Color.WHITE);
                }
            }
        });

        allCraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allCraft.isSelected()) {
                    allCraft.setSelected(false);
                    allCraft.setTextColor(rgb(160,160,160));

                } else if(!allCraft.isSelected()){

                    allCraft.setSelected(true);
                    allCraft.setTextColor(Color.WHITE);
                }
            }
        });

        pottery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pottery.isSelected()) {
                    pottery.setSelected(false);
                    pottery.setTextColor(rgb(160,160,160));

                } else if(!pottery.isSelected()){

                    pottery.setSelected(true);
                    pottery.setTextColor(Color.WHITE);
                }
            }
        });

        metals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(metals.isSelected()) {
                    metals.setSelected(false);
                    metals.setTextColor(rgb(160,160,160));

                } else if(!metals.isSelected()){

                    metals.setSelected(true);
                    metals.setTextColor(Color.WHITE);
                }
            }
        });

        fiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fiber.isSelected()) {
                    fiber.setSelected(false);
                    fiber.setTextColor(rgb(160,160,160));

                } else if(!fiber.isSelected()){

                    fiber.setSelected(true);
                    fiber.setTextColor(Color.WHITE);
                }
            }
        });

        woodworking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(woodworking.isSelected()) {
                    woodworking.setSelected(false);
                    woodworking.setTextColor(rgb(160,160,160));

                } else if(!woodworking.isSelected()){

                    woodworking.setSelected(true);
                    woodworking.setTextColor(Color.WHITE);
                }
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(picture.isSelected()) {
                    picture.setSelected(false);
                    picture.setTextColor(rgb(160,160,160));

                } else if(!picture.isSelected()){

                    picture.setSelected(true);
                    picture.setTextColor(Color.WHITE);
                }
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(video.isSelected()) {
                    video.setSelected(false);
                    video.setTextColor(rgb(160,160,160));

                } else if(!video.isSelected()){

                    video.setSelected(true);
                    video.setTextColor(Color.WHITE);
                }
            }
        });

        indus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indus.isSelected()) {
                    indus.setSelected(false);
                    indus.setTextColor(rgb(160,160,160));

                } else if(!indus.isSelected()){

                    indus.setSelected(true);
                    indus.setTextColor(Color.WHITE);
                }
            }
        });
        /***************************************************/

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭된 버튼 서버로 전달

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭된 버튼 모두 unclick
            }
        });


        return view;
    }

}
