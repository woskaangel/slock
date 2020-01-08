package com.example.slock;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Timer;
import java.util.TimerTask;

public class Frag3Floor extends Fragment {

    private View view;

    Switch room301, room302, room303, room304, room305, room306, room307, room308, room309, room310,
            room311, room312, room313, room314, room315, room316, room317, room318, room319, room320;

    boolean all, third;

    public static Frag3Floor newInstance(){
        Frag3Floor frag3Floor = new Frag3Floor();

        return frag3Floor;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_3floor, container, false);

        room301 = (Switch)view.findViewById(R.id.room301);
        room302 = (Switch)view.findViewById(R.id.room302);
        room303 = (Switch)view.findViewById(R.id.room303);
        room304 = (Switch)view.findViewById(R.id.room304);
        room305 = (Switch)view.findViewById(R.id.room305);
        room306 = (Switch)view.findViewById(R.id.room306);
        room307 = (Switch)view.findViewById(R.id.room307);
        room308 = (Switch)view.findViewById(R.id.room308);
        room309 = (Switch)view.findViewById(R.id.room309);
        room310 = (Switch)view.findViewById(R.id.room310);
        room311 = (Switch)view.findViewById(R.id.room311);
        room312 = (Switch)view.findViewById(R.id.room312);
        room313 = (Switch)view.findViewById(R.id.room313);
        room314 = (Switch)view.findViewById(R.id.room314);
        room315 = (Switch)view.findViewById(R.id.room315);
        room316 = (Switch)view.findViewById(R.id.room316);
        room317 = (Switch)view.findViewById(R.id.room317);
        room318 = (Switch)view.findViewById(R.id.room318);
        room319 = (Switch)view.findViewById(R.id.room319);
        room320 = (Switch)view.findViewById(R.id.room320);

        return  view;
    }
}
