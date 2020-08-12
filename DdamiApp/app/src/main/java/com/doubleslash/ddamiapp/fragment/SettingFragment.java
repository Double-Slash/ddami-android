package com.doubleslash.ddamiapp.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.doubleslash.ddamiapp.R;

public class SettingFragment extends Fragment{

    ImageButton setBack;
    TextView linkedAddress, updatePW,dropout, logout
            , versionInform, currentVersion, addReview, contactUs, provision
            , privacyPolicy, informOpenSource;
    Switch setAlarm, soundChatAlarm;


    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성
    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        setBack = (ImageButton) view.findViewById(R.id.set_back);
        linkedAddress = (TextView) view.findViewById(R.id.linked_address);
        updatePW = (TextView) view.findViewById(R.id.update_pw);
        dropout = (TextView) view.findViewById(R.id.dropout);
        logout = (TextView) view.findViewById(R.id.logout);
        versionInform = (TextView) view.findViewById(R.id.version_inform);
        currentVersion = (TextView) view.findViewById(R.id.current_version);
        addReview = (TextView) view.findViewById(R.id.add_review);
        contactUs = (TextView) view.findViewById(R.id.contact_us);
        provision = (TextView) view.findViewById(R.id.provision);
        privacyPolicy = (TextView) view.findViewById(R.id.privacy_policy);
        informOpenSource = (TextView) view.findViewById(R.id.inform_openSource);
        setAlarm = (Switch) view.findViewById(R.id.set_alarm);
        soundChatAlarm = (Switch) view.findViewById(R.id.sound_chat_alarm);


        currentVersion.setText(getAppVersionName());

        setAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //알림 설정
                if (isChecked){ //알림 ON, 서버와 연결

                }else{ //알림 OFF, 서버 연결 안함

                }
            }
        });
        soundChatAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //채팅 알림 소리
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ //소리 ON

                }else{ //소리 OFF

                }
            }
        });

        return view;
    }

    //앱버전 명
    public String getAppVersionName(){
        PackageInfo packageInfo = null;         //패키지에 대한 전반적인 정보

        //PackageInfo 초기화
        try{
            packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return "";
        }

        return packageInfo.versionName;
    }

    //앱버전 코드
    public int getAppVersionCode(){
        PackageInfo packageInfo = null;         //패키지에 대한 전반적인 정보

        //PackageInfo 초기화
        try{
            packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return -1;
        }

        return packageInfo.versionCode;
    }

}

