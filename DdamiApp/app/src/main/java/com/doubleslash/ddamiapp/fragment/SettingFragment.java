package com.doubleslash.ddamiapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.doubleslash.ddamiapp.R;

public class SettingFragment extends Fragment {

    ImageButton setBack;
    TextView linkedAddress, updatePW,dropout, logout, setAlarm, soundChatAlarm
            , versionInform, currentVersion, addReview, contactUs, provision
            , privacyPolicy, informOpenSource;


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
        setAlarm = (TextView) view.findViewById(R.id.set_alarm);
        soundChatAlarm = (TextView) view.findViewById(R.id.sound_chat_alarm);
        versionInform = (TextView) view.findViewById(R.id.version_inform);
        currentVersion = (TextView) view.findViewById(R.id.current_version);
        addReview = (TextView) view.findViewById(R.id.add_review);
        contactUs = (TextView) view.findViewById(R.id.contact_us);
        provision = (TextView) view.findViewById(R.id.provision);
        privacyPolicy = (TextView) view.findViewById(R.id.privacy_policy);
        informOpenSource = (TextView) view.findViewById(R.id.inform_openSource);





        return view;
    }
}
