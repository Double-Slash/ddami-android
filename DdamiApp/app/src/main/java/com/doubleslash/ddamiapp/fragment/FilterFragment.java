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
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!allSpace.isSelected()){

                    allSpace.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        livingSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livingSpace.isSelected()) {
                    livingSpace.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!livingSpace.isSelected()){

                    livingSpace.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(build.isSelected()) {
                    build.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!build.isSelected()){

                    build.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        interior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interior.isSelected()) {
                    interior.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!interior.isSelected()){

                    interior.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        inner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inner.isSelected()) {
                    inner.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!inner.isSelected()){

                    inner.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        envir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(envir.isSelected()) {
                    envir.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!envir.isSelected()){

                    envir.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        allModern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allModern.isSelected()) {
                    allModern.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!allModern.isSelected()){

                    allModern.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        painting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(painting.isSelected()) {
                    painting.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!painting.isSelected()){

                    painting.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        sculp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sculp.isSelected()) {
                    sculp.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!sculp.isSelected()){

                    sculp.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        allCraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allCraft.isSelected()) {
                    allCraft.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!allCraft.isSelected()){

                    allCraft.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        pottery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pottery.isSelected()) {
                    pottery.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!pottery.isSelected()){

                    pottery.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        metals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(metals.isSelected()) {
                    metals.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!metals.isSelected()){

                    metals.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        fiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fiber.isSelected()) {
                    fiber.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!fiber.isSelected()){

                    fiber.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        woodworking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(woodworking.isSelected()) {
                    woodworking.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!woodworking.isSelected()){

                    woodworking.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(picture.isSelected()) {
                    picture.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!picture.isSelected()){

                    picture.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(video.isSelected()) {
                    video.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!video.isSelected()){

                    video.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        indus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indus.isSelected()) {
                    indus.setSelected(false);
                    allSpace.setTextColor(rgb(128, 128, 128));

                } else if(!indus.isSelected()){
                    indus.setSelected(true);
                    allSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        /***************************************************/

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //아무것도 클릭 안 한 경우 버튼 비활성화, (버튼 배경색 #BBBBBB)

                //클릭된 버튼 서버likeField에 추가


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭된 버튼 모두 unclick

                //서버 likeField 배열 모두 삭제, 전체 추가
            }
        });


        return view;
    }

}
