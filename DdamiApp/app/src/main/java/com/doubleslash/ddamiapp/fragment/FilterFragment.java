package com.doubleslash.ddamiapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.doubleslash.ddamiapp.R;
import com.doubleslash.ddamiapp.activity.MainActivity;

import static android.graphics.Color.rgb;

public class FilterFragment extends Fragment {
    AppCompatButton allSpace, livingSpace, build, interior, inner, envir
            , allModern, painting, sculp
            , allCraft, pottery, metals, fiber, woodworking
            , picture, illust
            , allVideo, animation,movie,motion,docu
            , allIndus, goods, industSpace, UXUI, car
            , allClothes
            , reset, apply;

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static FilterFragment newInstance() {
        return new FilterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);


        allSpace = (AppCompatButton)view.findViewById(R.id.btn_allSpace);
        livingSpace = (AppCompatButton)view.findViewById(R.id.btn_livingSpace);
        build = (AppCompatButton)view.findViewById(R.id.btn_build);
        interior = (AppCompatButton)view.findViewById(R.id.btn_interior);
        inner = (AppCompatButton)view.findViewById(R.id.btn_inner);
        envir = (AppCompatButton)view.findViewById(R.id.btn_envir);
        allModern = (AppCompatButton)view.findViewById(R.id.btn_allMA);
        painting = (AppCompatButton)view.findViewById(R.id.btn_painting);
        sculp = (AppCompatButton)view.findViewById(R.id.btn_sculp);
        allCraft = (AppCompatButton)view.findViewById(R.id.btn_allCraft);
        pottery = (AppCompatButton)view.findViewById(R.id.btn_pottery);
        metals = (AppCompatButton)view.findViewById(R.id.btn_metals);
        fiber = (AppCompatButton)view.findViewById(R.id.btn_fiber);
        woodworking = (AppCompatButton)view.findViewById(R.id.btn_woodworking);
        picture = (AppCompatButton)view.findViewById(R.id.btn_pic);
        allVideo = (AppCompatButton)view.findViewById(R.id.btn_allVideo);
        allIndus = (AppCompatButton)view.findViewById(R.id.btn_allIndus);
        reset = (AppCompatButton)view.findViewById(R.id.reset_btn);
        apply = (AppCompatButton)view.findViewById(R.id.apply_btn);
        illust = (AppCompatButton)view.findViewById(R.id.btn_illust);
        animation = (AppCompatButton)view.findViewById(R.id.btn_animation);
        movie = (AppCompatButton)view.findViewById(R.id.btn_movie);
        motion = (AppCompatButton)view.findViewById(R.id.btn_motion);
        docu = (AppCompatButton)view.findViewById(R.id.btn_docu);
        goods = (AppCompatButton)view.findViewById(R.id.btn_goods);
        industSpace = (AppCompatButton)view.findViewById(R.id.btn_IndusSpace);
        UXUI = (AppCompatButton)view.findViewById(R.id.btn_UXUI);
        car = (AppCompatButton)view.findViewById(R.id.btn_car);
        allClothes = (AppCompatButton)view.findViewById(R.id.btn_allClothes);


        /*각 버튼 클릭 이벤트*/
        apply_Enabled();

        allSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
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
                apply_Enabled();
                if(livingSpace.isSelected()) {
                    livingSpace.setSelected(false);
                    livingSpace.setTextColor(rgb(128, 128, 128));

                } else if(!livingSpace.isSelected()){

                    livingSpace.setSelected(true);
                    livingSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(build.isSelected()) {
                    build.setSelected(false);
                    build.setTextColor(rgb(128, 128, 128));

                } else if(!build.isSelected()){

                    build.setSelected(true);
                    build.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        interior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(interior.isSelected()) {
                    interior.setSelected(false);
                    interior.setTextColor(rgb(128, 128, 128));

                } else if(!interior.isSelected()){

                    interior.setSelected(true);
                    interior.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        inner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(inner.isSelected()) {
                    inner.setSelected(false);
                    inner.setTextColor(rgb(128, 128, 128));

                } else if(!inner.isSelected()){

                    inner.setSelected(true);
                    inner.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        envir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(envir.isSelected()) {
                    envir.setSelected(false);
                    envir.setTextColor(rgb(128, 128, 128));

                } else if(!envir.isSelected()){

                    envir.setSelected(true);
                    envir.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        allModern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(allModern.isSelected()) {
                    allModern.setSelected(false);
                    allModern.setTextColor(rgb(128, 128, 128));

                } else if(!allModern.isSelected()){

                    allModern.setSelected(true);
                    allModern.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        painting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(painting.isSelected()) {
                    painting.setSelected(false);
                    painting.setTextColor(rgb(128, 128, 128));

                } else if(!painting.isSelected()){

                    painting.setSelected(true);
                    painting.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        sculp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(sculp.isSelected()) {
                    sculp.setSelected(false);
                    sculp.setTextColor(rgb(128, 128, 128));

                } else if(!sculp.isSelected()){

                    sculp.setSelected(true);
                    sculp.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        allCraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(allCraft.isSelected()) {
                    allCraft.setSelected(false);
                    allCraft.setTextColor(rgb(128, 128, 128));

                } else if(!allCraft.isSelected()){

                    allCraft.setSelected(true);
                    allCraft.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        pottery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(pottery.isSelected()) {
                    pottery.setSelected(false);
                    pottery.setTextColor(rgb(128, 128, 128));

                } else if(!pottery.isSelected()){

                    pottery.setSelected(true);
                    pottery.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        metals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(metals.isSelected()) {
                    metals.setSelected(false);
                    metals.setTextColor(rgb(128, 128, 128));

                } else if(!metals.isSelected()){

                    metals.setSelected(true);
                    metals.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        fiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(fiber.isSelected()) {
                    fiber.setSelected(false);
                    fiber.setTextColor(rgb(128, 128, 128));

                } else if(!fiber.isSelected()){

                    fiber.setSelected(true);
                    fiber.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        woodworking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(woodworking.isSelected()) {
                    woodworking.setSelected(false);
                    woodworking.setTextColor(rgb(128, 128, 128));

                } else if(!woodworking.isSelected()){

                    woodworking.setSelected(true);
                    woodworking.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(picture.isSelected()) {
                    picture.setSelected(false);
                    picture.setTextColor(rgb(128, 128, 128));

                } else if(!picture.isSelected()){

                    picture.setSelected(true);
                    picture.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        allVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(allVideo.isSelected()) {
                    allVideo.setSelected(false);
                    allVideo.setTextColor(rgb(128, 128, 128));

                } else if(!allVideo.isSelected()){

                    allVideo.setSelected(true);
                    allVideo.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        allIndus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(allIndus.isSelected()) {
                    allIndus.setSelected(false);
                    allIndus.setTextColor(rgb(128, 128, 128));

                } else if(!allIndus.isSelected()){
                    allIndus.setSelected(true);
                    allIndus.setTextColor(rgb(50, 47, 160));
                }
            }
        });

        illust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(illust.isSelected()) {
                    illust.setSelected(false);
                    illust.setTextColor(rgb(128, 128, 128));

                } else if(!illust.isSelected()){
                    illust.setSelected(true);
                    illust.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(animation.isSelected()) {
                    animation.setSelected(false);
                    animation.setTextColor(rgb(128, 128, 128));

                } else if(!animation.isSelected()){
                    animation.setSelected(true);
                    animation.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(movie.isSelected()) {
                    movie.setSelected(false);
                    movie.setTextColor(rgb(128, 128, 128));

                } else if(!movie.isSelected()){
                    movie.setSelected(true);
                    movie.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(motion.isSelected()) {
                    motion.setSelected(false);
                    motion.setTextColor(rgb(128, 128, 128));

                } else if(!motion.isSelected()){
                    motion.setSelected(true);
                    motion.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        docu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(docu.isSelected()) {
                    docu.setSelected(false);
                    docu.setTextColor(rgb(128, 128, 128));

                } else if(!docu.isSelected()){
                    docu.setSelected(true);
                    docu.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(goods.isSelected()) {
                    goods.setSelected(false);
                    goods.setTextColor(rgb(128, 128, 128));

                } else if(!goods.isSelected()){
                    goods.setSelected(true);
                    goods.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        industSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(industSpace.isSelected()) {
                    industSpace.setSelected(false);
                    industSpace.setTextColor(rgb(128, 128, 128));

                } else if(!industSpace.isSelected()){
                    industSpace.setSelected(true);
                    industSpace.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        UXUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UXUI.isSelected()) {
                    UXUI.setSelected(false);
                    UXUI.setTextColor(rgb(128, 128, 128));

                } else if(!UXUI.isSelected()){
                    UXUI.setSelected(true);
                    UXUI.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(car.isSelected()) {
                    car.setSelected(false);
                    car.setTextColor(rgb(128, 128, 128));

                } else if(!car.isSelected()){
                    car.setSelected(true);
                    car.setTextColor(rgb(50, 47, 160));
                }
            }
        });
        allClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply_Enabled();
                if(allClothes.isSelected()) {
                    allClothes.setSelected(false);
                    allClothes.setTextColor(rgb(128, 128, 128));

                } else if(!allClothes.isSelected()){
                    allClothes.setSelected(true);
                    allClothes.setTextColor(rgb(50, 47, 160));
                }
            }
        });


        /***************************************************/

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //버튼이 활성화 되어있는 경우
                if(apply.isEnabled()==true) {
                    //클릭된 버튼 서버likeField에 추가

                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭된 버튼 모두 unclick //작용하기 비활성화
                allSpace.setSelected(false);  livingSpace.setSelected(false);  build.setSelected(false);  interior.setSelected(false);
                inner.setSelected(false);  envir.setSelected(false);  allModern.setSelected(false);  painting.setSelected(false);
                sculp.setSelected(false);  allCraft.setSelected(false);  pottery.setSelected(false);  metals.setSelected(false);
                fiber.setSelected(false);  woodworking.setSelected(false);  picture.setSelected(false);  illust.setSelected(false);
                allVideo.setSelected(false);  animation.setSelected(false);  movie.setSelected(false);  motion.setSelected(false);
                docu.setSelected(false);  allIndus.setSelected(false);  goods.setSelected(false);  industSpace.setSelected(false);
                UXUI.setSelected(false);  car.setSelected(false);  allClothes.setSelected(false);

                allSpace.setTextColor(rgb(128, 128, 128));  livingSpace.setTextColor(rgb(128, 128, 128));
                build.setTextColor(rgb(128, 128, 128));  interior.setTextColor(rgb(128, 128, 128));
                inner.setTextColor(rgb(128, 128, 128));  envir.setTextColor(rgb(128, 128, 128));
                allModern.setTextColor(rgb(128, 128, 128));  painting.setTextColor(rgb(128, 128, 128));
                sculp.setTextColor(rgb(128, 128, 128));  allCraft.setTextColor(rgb(128, 128, 128));
                pottery.setTextColor(rgb(128, 128, 128));  metals.setTextColor(rgb(128, 128, 128));
                fiber.setTextColor(rgb(128, 128, 128));  woodworking.setTextColor(rgb(128, 128, 128));
                picture.setTextColor(rgb(128, 128, 128));  illust.setTextColor(rgb(128, 128, 128));
                allVideo.setTextColor(rgb(128, 128, 128));  animation.setTextColor(rgb(128, 128, 128));
                movie.setTextColor(rgb(128, 128, 128));  motion.setTextColor(rgb(128, 128, 128));
                docu.setTextColor(rgb(128, 128, 128));  allIndus.setTextColor(rgb(128, 128, 128));
                goods.setTextColor(rgb(128, 128, 128));  industSpace.setTextColor(rgb(128, 128, 128));
                UXUI.setTextColor(rgb(128, 128, 128));  car.setTextColor(rgb(128, 128, 128));
                allClothes.setTextColor(rgb(128, 128, 128));

                apply.setEnabled(false);

                //서버 likeField 배열 모두 삭제


            }
        });


        return view;
    }
    public void apply_Enabled(){
        //아무것도 클릭 안 한 경우 버튼 비활성화
        /*if((!allSpace.isSelected()) && (!livingSpace.isSelected()) && (!build.isSelected()) && (!interior.isSelected())
                && (!inner.isSelected()) && (!envir.isSelected()) && (!allModern.isSelected()) && (!painting.isSelected())
                && (!sculp.isSelected()) && (!allCraft.isSelected()) && (!pottery.isSelected()) && (!metals.isSelected())
                && (!fiber.isSelected()) && (!woodworking.isSelected()) && (!picture.isSelected()) && (!illust.isSelected())
                && (!allVideo.isSelected()) && (!animation.isSelected()) && (!movie.isSelected()) && (!motion.isSelected())
                && (!docu.isSelected()) && (!allIndus.isSelected()) && (!goods.isSelected()) && (!industSpace.isSelected())
                && (!UXUI.isSelected()) && (!car.isSelected()) && (!allClothes.isSelected())){

            apply.setEnabled(false);*/
        if((allSpace.isSelected()) || (livingSpace.isSelected()) || (build.isSelected()) || (interior.isSelected())
                || (inner.isSelected()) || (envir.isSelected()) || (allModern.isSelected()) || (painting.isSelected())
                || (sculp.isSelected()) || (allCraft.isSelected()) || (pottery.isSelected()) || (metals.isSelected())
                || (fiber.isSelected()) || (woodworking.isSelected()) || (picture.isSelected()) || (illust.isSelected())
                || (allVideo.isSelected()) || (animation.isSelected()) || (movie.isSelected()) || (motion.isSelected())
                || (docu.isSelected()) || (allIndus.isSelected()) || (goods.isSelected()) || (industSpace.isSelected())
                || (UXUI.isSelected()) || (car.isSelected()) || (allClothes.isSelected())){

            apply.setEnabled(true);

        }else{
            apply.setEnabled(false);
        }
    }

}
