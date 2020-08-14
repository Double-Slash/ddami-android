package com.doubleslash.ddamiapp.fragment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import com.doubleslash.ddamiapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_filter.*
import java.util.*


class FilterFragmentKotlin : BottomSheetDialogFragment() {

    val REQUEST_KEY = "result-listener-request-key"
    val KEY_NUMBER = "key-number"

    var allSpace: AppCompatButton? = null
    var livingSpace: AppCompatButton? = null
    var build: AppCompatButton? = null
    var interior: AppCompatButton? = null
    var inner: AppCompatButton? = null
    var envir: AppCompatButton? = null
    var allModern: AppCompatButton? = null
    var painting: AppCompatButton? = null
    var sculp: AppCompatButton? = null
    var allCraft: AppCompatButton? = null
    var pottery: AppCompatButton? = null
    var metals: AppCompatButton? = null
    var fiber: AppCompatButton? = null
    var woodworking: AppCompatButton? = null
    var picture: AppCompatButton? = null
    var illust: AppCompatButton? = null
    var allVideo: AppCompatButton? = null
    var animation: AppCompatButton? = null
    var movie: AppCompatButton? = null
    var motion: AppCompatButton? = null
    var docu: AppCompatButton? = null
    var allIndus: AppCompatButton? = null
    var goods: AppCompatButton? = null
    var industSpace: AppCompatButton? = null
    var UXUI: AppCompatButton? = null
    var car: AppCompatButton? = null
    var allClothes: AppCompatButton? = null
    var reset: AppCompatButton? = null
    var apply: AppCompatButton? = null
    private var likeFieldList: ArrayList<String>? = null

    interface OnResultListener {
        fun onResult(value: String?)
    }

    private var listener: OnResultListener? = null
    fun setListener(listener: OnResultListener?) {
        this.listener = listener
    }

    private fun clickDone() {
        listener!!.onResult("filter")
        parentFragmentManager.popBackStack()
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpResultDoneButtonClickListener()
    }

    private fun setUpResultDoneButtonClickListener() {
        apply_btn.setOnClickListener {
            try {
                val number = 10
                setResult(number)
                parentFragmentManager.popBackStack()
            } catch (exception: NumberFormatException) {
                Toast.makeText(
                        requireContext(),
                        "error",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setResult(number: Int) {
        parentFragmentManager.setFragmentResult(
                MainFragmentKotlin.REQUEST_KEY,
                bundleOf(MainFragmentKotlin.KEY_NUMBER to number)
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstaceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_filter, container, false)
        allSpace = view.findViewById<View>(R.id.btn_allSpace) as AppCompatButton
        livingSpace = view.findViewById<View>(R.id.btn_livingSpace) as AppCompatButton
        build = view.findViewById<View>(R.id.btn_build) as AppCompatButton
        interior = view.findViewById<View>(R.id.btn_interior) as AppCompatButton
        inner = view.findViewById<View>(R.id.btn_inner) as AppCompatButton
        envir = view.findViewById<View>(R.id.btn_envir) as AppCompatButton
        allModern = view.findViewById<View>(R.id.btn_allMA) as AppCompatButton
        painting = view.findViewById<View>(R.id.btn_painting) as AppCompatButton
        sculp = view.findViewById<View>(R.id.btn_sculp) as AppCompatButton
        allCraft = view.findViewById<View>(R.id.btn_allCraft) as AppCompatButton
        pottery = view.findViewById<View>(R.id.btn_pottery) as AppCompatButton
        metals = view.findViewById<View>(R.id.btn_metals) as AppCompatButton
        fiber = view.findViewById<View>(R.id.btn_fiber) as AppCompatButton
        woodworking = view.findViewById<View>(R.id.btn_woodworking) as AppCompatButton
        picture = view.findViewById<View>(R.id.btn_pic) as AppCompatButton
        allVideo = view.findViewById<View>(R.id.btn_allVideo) as AppCompatButton
        allIndus = view.findViewById<View>(R.id.btn_allIndus) as AppCompatButton
        reset = view.findViewById<View>(R.id.reset_btn) as AppCompatButton
        apply = view.findViewById<View>(R.id.apply_btn) as AppCompatButton
        illust = view.findViewById<View>(R.id.btn_illust) as AppCompatButton
        animation = view.findViewById<View>(R.id.btn_animation) as AppCompatButton
        movie = view.findViewById<View>(R.id.btn_movie) as AppCompatButton
        motion = view.findViewById<View>(R.id.btn_motion) as AppCompatButton
        docu = view.findViewById<View>(R.id.btn_docu) as AppCompatButton
        goods = view.findViewById<View>(R.id.btn_goods) as AppCompatButton
        industSpace = view.findViewById<View>(R.id.btn_IndusSpace) as AppCompatButton
        UXUI = view.findViewById<View>(R.id.btn_UXUI) as AppCompatButton
        car = view.findViewById<View>(R.id.btn_car) as AppCompatButton
        allClothes = view.findViewById<View>(R.id.btn_allClothes) as AppCompatButton

        /*각 버튼 클릭 이벤트*/apply_Enabled()
        allSpace!!.setOnClickListener {
            apply_Enabled()
            if (allSpace!!.isSelected) {
                allSpace!!.isSelected = false
                allSpace!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!allSpace!!.isSelected) {
                allSpace!!.isSelected = true
                allSpace!!.setTypeface(null, Typeface.BOLD)
                allSpace!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        livingSpace!!.setOnClickListener {
            apply_Enabled()
            if (livingSpace!!.isSelected) {
                livingSpace!!.isSelected = false
                livingSpace!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!livingSpace!!.isSelected) {
                livingSpace!!.isSelected = true
                livingSpace!!.setTypeface(null, Typeface.BOLD)
                livingSpace!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        build!!.setOnClickListener {
            apply_Enabled()
            if (build!!.isSelected) {
                build!!.isSelected = false
                build!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!build!!.isSelected) {
                build!!.isSelected = true
                build!!.setTypeface(null, Typeface.BOLD)
                build!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        interior!!.setOnClickListener {
            apply_Enabled()
            if (interior!!.isSelected) {
                interior!!.isSelected = false
                interior!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!interior!!.isSelected) {
                interior!!.isSelected = true
                interior!!.setTypeface(null, Typeface.BOLD)
                interior!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        inner!!.setOnClickListener {
            apply_Enabled()
            if (inner!!.isSelected) {
                inner!!.isSelected = false
                inner!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!inner!!.isSelected) {
                inner!!.isSelected = true
                inner!!.setTypeface(null, Typeface.BOLD)
                inner!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        envir!!.setOnClickListener {
            apply_Enabled()
            if (envir!!.isSelected) {
                envir!!.isSelected = false
                envir!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!envir!!.isSelected) {
                envir!!.isSelected = true
                envir!!.setTypeface(null, Typeface.BOLD)
                envir!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        allModern!!.setOnClickListener {
            apply_Enabled()
            if (allModern!!.isSelected) {
                allModern!!.isSelected = false
                allModern!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!allModern!!.isSelected) {
                allModern!!.isSelected = true
                allModern!!.setTypeface(null, Typeface.BOLD)
                allModern!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        painting!!.setOnClickListener {
            apply_Enabled()
            if (painting!!.isSelected) {
                painting!!.isSelected = false
                painting!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!painting!!.isSelected) {
                painting!!.isSelected = true
                painting!!.setTypeface(null, Typeface.BOLD)
                painting!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        sculp!!.setOnClickListener {
            apply_Enabled()
            if (sculp!!.isSelected) {
                sculp!!.isSelected = false
                sculp!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!sculp!!.isSelected) {
                sculp!!.isSelected = true
                sculp!!.setTypeface(null, Typeface.BOLD)
                sculp!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        allCraft!!.setOnClickListener {
            apply_Enabled()
            if (allCraft!!.isSelected) {
                allCraft!!.isSelected = false
                allCraft!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!allCraft!!.isSelected) {
                allCraft!!.isSelected = true
                allCraft!!.setTypeface(null, Typeface.BOLD)
                allCraft!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        pottery!!.setOnClickListener {
            apply_Enabled()
            if (pottery!!.isSelected) {
                pottery!!.isSelected = false
                pottery!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!pottery!!.isSelected) {
                pottery!!.isSelected = true
                pottery!!.setTypeface(null, Typeface.BOLD)
                pottery!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        metals!!.setOnClickListener {
            apply_Enabled()
            if (metals!!.isSelected) {
                metals!!.isSelected = false
                metals!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!metals!!.isSelected) {
                metals!!.isSelected = true
                metals!!.setTypeface(null, Typeface.BOLD)
                metals!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        fiber!!.setOnClickListener {
            apply_Enabled()
            if (fiber!!.isSelected) {
                fiber!!.isSelected = false
                fiber!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!fiber!!.isSelected) {
                fiber!!.isSelected = true
                fiber!!.setTypeface(null, Typeface.BOLD)
                fiber!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        woodworking!!.setOnClickListener {
            apply_Enabled()
            if (woodworking!!.isSelected) {
                woodworking!!.isSelected = false
                woodworking!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!woodworking!!.isSelected) {
                woodworking!!.isSelected = true
                woodworking!!.setTypeface(null, Typeface.BOLD)
                woodworking!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        picture!!.setOnClickListener {
            apply_Enabled()
            if (picture!!.isSelected) {
                picture!!.isSelected = false
                picture!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!picture!!.isSelected) {
                picture!!.isSelected = true
                picture!!.setTypeface(null, Typeface.BOLD)
                picture!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        allVideo!!.setOnClickListener {
            apply_Enabled()
            if (allVideo!!.isSelected) {
                allVideo!!.isSelected = false
                allVideo!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!allVideo!!.isSelected) {
                allVideo!!.isSelected = true
                allVideo!!.setTypeface(null, Typeface.BOLD)
                allVideo!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        allIndus!!.setOnClickListener {
            apply_Enabled()
            if (allIndus!!.isSelected) {
                allIndus!!.isSelected = false
                allIndus!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!allIndus!!.isSelected) {
                allIndus!!.isSelected = true
                allIndus!!.setTypeface(null, Typeface.BOLD)
                allIndus!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        illust!!.setOnClickListener {
            apply_Enabled()
            if (illust!!.isSelected) {
                illust!!.isSelected = false
                illust!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!illust!!.isSelected) {
                illust!!.isSelected = true
                illust!!.setTypeface(null, Typeface.BOLD)
                illust!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        animation!!.setOnClickListener {
            apply_Enabled()
            if (animation!!.isSelected) {
                animation!!.isSelected = false
                animation!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!animation!!.isSelected) {
                animation!!.isSelected = true
                animation!!.setTypeface(null, Typeface.BOLD)
                animation!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        movie!!.setOnClickListener {
            apply_Enabled()
            if (movie!!.isSelected) {
                movie!!.isSelected = false
                movie!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!movie!!.isSelected) {
                movie!!.isSelected = true
                movie!!.setTypeface(null, Typeface.BOLD)
                movie!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        motion!!.setOnClickListener {
            apply_Enabled()
            if (motion!!.isSelected) {
                motion!!.isSelected = false
                motion!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!motion!!.isSelected) {
                motion!!.isSelected = true
                motion!!.setTypeface(null, Typeface.BOLD)
                motion!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        docu!!.setOnClickListener {
            apply_Enabled()
            if (docu!!.isSelected) {
                docu!!.isSelected = false
                docu!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!docu!!.isSelected) {
                docu!!.isSelected = true
                docu!!.setTypeface(null, Typeface.BOLD)
                docu!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        goods!!.setOnClickListener {
            if (goods!!.isSelected) {
                goods!!.isSelected = false
                goods!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!goods!!.isSelected) {
                goods!!.isSelected = true
                goods!!.setTypeface(null, Typeface.BOLD)
                goods!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        industSpace!!.setOnClickListener {
            if (industSpace!!.isSelected) {
                industSpace!!.isSelected = false
                industSpace!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!industSpace!!.isSelected) {
                industSpace!!.isSelected = true
                industSpace!!.setTypeface(null, Typeface.BOLD)
                industSpace!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        UXUI!!.setOnClickListener {
            if (UXUI!!.isSelected) {
                UXUI!!.isSelected = false
                UXUI!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!UXUI!!.isSelected) {
                UXUI!!.isSelected = true
                UXUI!!.setTypeface(null, Typeface.BOLD)
                UXUI!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        car!!.setOnClickListener {
            if (car!!.isSelected) {
                car!!.isSelected = false
                car!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!car!!.isSelected) {
                car!!.isSelected = true
                car!!.setTypeface(null, Typeface.BOLD)
                car!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        allClothes!!.setOnClickListener {
            apply_Enabled()
            if (allClothes!!.isSelected) {
                allClothes!!.isSelected = false
                allClothes!!.setTextColor(Color.rgb(128, 128, 128))
            } else if (!allClothes!!.isSelected) {
                allClothes!!.isSelected = true
                allClothes!!.setTypeface(null, Typeface.BOLD)
                allClothes!!.setTextColor(Color.rgb(50, 47, 160))
            }
        }
        /** */
        apply!!.setOnClickListener {
            //버튼이 활성화 되어있는 경우
            if (apply!!.isEnabled == true) {
                //클릭된 버튼 텍스트 메인으로 보내기
                if (allSpace!!.isSelected) {
                    val fragment = MainFragmentKotlin()
                    val strAllSpa = allSpace!!.text.toString()
                    val bundle = Bundle()
                    bundle.putString("filter", strAllSpa)
                    fragment.arguments = bundle
                    //Navigation.findNavController(view).navigate(R.id.btn_allSpace, bundle);
                    //                      String strAllSpa = "공간 디자인 "+allSpace.getText().toString();


//                        //    MainFragmentKotlin fragment = new MainFragmentKotlin();
////                        Intent intent = new Intent(getActivity(),MainFragmentKotlin.class);
////
////                        intent.putExtra("filter",strAllSpa);
//
//                        Bundle bundle = new Bundle();
//                        bundle.putString("filter", strAllSpa);
//                        //fragment.setArguments(intent);
////
////                        getParentFragmentManager().setFramentResult("filter",bundle);
//
//                        //  Toast.makeText(getActivity(),"filter = " + bundle, Toast.LENGTH_LONG).show();
//                        //Navigation.findNavController(view).navigate(R.id.btn_allSpace, bundle);
//
                }
            }
        }
        /***************************************서버 */
        likeFieldList = ArrayList()

        //사용자 살세보기의 likeField 사용
        reset!!.setOnClickListener { //                //서버에 있는 likeField배열 모두 삭제 //list.removeAll();
//                Log.e("ttttttt",it.getUser().getLikeField().toString());
//                it.getUser().getLikeField().clear();
//                Log.e("ttttttt",it.getUser().getLikeField().toString());

            //클릭된 버튼 모두 unclick //작용하기 비활성화
            allSpace!!.isSelected = false
            livingSpace!!.isSelected = false
            build!!.isSelected = false
            interior!!.isSelected = false
            inner!!.isSelected = false
            envir!!.isSelected = false
            allModern!!.isSelected = false
            painting!!.isSelected = false
            sculp!!.isSelected = false
            allCraft!!.isSelected = false
            pottery!!.isSelected = false
            metals!!.isSelected = false
            fiber!!.isSelected = false
            woodworking!!.isSelected = false
            picture!!.isSelected = false
            illust!!.isSelected = false
            allVideo!!.isSelected = false
            animation!!.isSelected = false
            movie!!.isSelected = false
            motion!!.isSelected = false
            docu!!.isSelected = false
            allIndus!!.isSelected = false
            goods!!.isSelected = false
            industSpace!!.isSelected = false
            UXUI!!.isSelected = false
            car!!.isSelected = false
            allClothes!!.isSelected = false
            allSpace!!.setTextColor(Color.rgb(128, 128, 128))
            livingSpace!!.setTextColor(Color.rgb(128, 128, 128))
            build!!.setTextColor(Color.rgb(128, 128, 128))
            interior!!.setTextColor(Color.rgb(128, 128, 128))
            inner!!.setTextColor(Color.rgb(128, 128, 128))
            envir!!.setTextColor(Color.rgb(128, 128, 128))
            allModern!!.setTextColor(Color.rgb(128, 128, 128))
            painting!!.setTextColor(Color.rgb(128, 128, 128))
            sculp!!.setTextColor(Color.rgb(128, 128, 128))
            allCraft!!.setTextColor(Color.rgb(128, 128, 128))
            pottery!!.setTextColor(Color.rgb(128, 128, 128))
            metals!!.setTextColor(Color.rgb(128, 128, 128))
            fiber!!.setTextColor(Color.rgb(128, 128, 128))
            woodworking!!.setTextColor(Color.rgb(128, 128, 128))
            picture!!.setTextColor(Color.rgb(128, 128, 128))
            illust!!.setTextColor(Color.rgb(128, 128, 128))
            allVideo!!.setTextColor(Color.rgb(128, 128, 128))
            animation!!.setTextColor(Color.rgb(128, 128, 128))
            movie!!.setTextColor(Color.rgb(128, 128, 128))
            motion!!.setTextColor(Color.rgb(128, 128, 128))
            docu!!.setTextColor(Color.rgb(128, 128, 128))
            allIndus!!.setTextColor(Color.rgb(128, 128, 128))
            goods!!.setTextColor(Color.rgb(128, 128, 128))
            industSpace!!.setTextColor(Color.rgb(128, 128, 128))
            UXUI!!.setTextColor(Color.rgb(128, 128, 128))
            car!!.setTextColor(Color.rgb(128, 128, 128))
            allClothes!!.setTextColor(Color.rgb(128, 128, 128))
            apply!!.isEnabled = false
        }
        return view
    }

    fun apply_Enabled() {
        //아무것도 클릭 안 한 경우 버튼 비활성화
        /*if((!allSpace.isSelected()) && (!livingSpace.isSelected()) && (!build.isSelected()) && (!interior.isSelected())
                && (!inner.isSelected()) && (!envir.isSelected()) && (!allModern.isSelected()) && (!painting.isSelected())
                && (!sculp.isSelected()) && (!allCraft.isSelected()) && (!pottery.isSelected()) && (!metals.isSelected())
                && (!fiber.isSelected()) && (!woodworking.isSelected()) && (!picture.isSelected()) && (!illust.isSelected())
                && (!allVideo.isSelected()) && (!animation.isSelected()) && (!movie.isSelected()) && (!motion.isSelected())
                && (!docu.isSelected()) && (!allIndus.isSelected()) && (!goods.isSelected()) && (!industSpace.isSelected())
                && (!UXUI.isSelected()) && (!car.isSelected()) && (!allClothes.isSelected())){

            apply.setEnabled(false);*/
        if (allSpace!!.isSelected || livingSpace!!.isSelected || build!!.isSelected || interior!!.isSelected
                || inner!!.isSelected || envir!!.isSelected || allModern!!.isSelected || painting!!.isSelected
                || sculp!!.isSelected || allCraft!!.isSelected || pottery!!.isSelected || metals!!.isSelected
                || fiber!!.isSelected || woodworking!!.isSelected || picture!!.isSelected || illust!!.isSelected
                || allVideo!!.isSelected || animation!!.isSelected || movie!!.isSelected || motion!!.isSelected
                || docu!!.isSelected || allIndus!!.isSelected || goods!!.isSelected || industSpace!!.isSelected
                || UXUI!!.isSelected || car!!.isSelected || allClothes!!.isSelected) {
            apply!!.isEnabled = true
        } else {
            apply!!.isEnabled = false
        }
    }

    companion object {
        // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
        fun newInstance(): FilterFragmentKotlin {
            return FilterFragmentKotlin()
        }
    }
}