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

public class Frag4Floor extends Fragment {

    private View view;

    Switch room401, room402, room403, room404, room405, room406, room407, room408, room409, room410,
            room411, room412, room413, room414, room415, room416, room417, room418, room419, room420;

    boolean all, third;

    public static Frag4Floor newInstance(){
        Frag4Floor frag4Floor = new Frag4Floor();

        return frag4Floor;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_4floor, container, false);

        room401 = (Switch)view.findViewById(R.id.room401);
        room402 = (Switch)view.findViewById(R.id.room402);
        room403 = (Switch)view.findViewById(R.id.room404);
        room404 = (Switch)view.findViewById(R.id.room404);
        room405 = (Switch)view.findViewById(R.id.room404);
        room406 = (Switch)view.findViewById(R.id.room406);
        room407 = (Switch)view.findViewById(R.id.room407);
        room408 = (Switch)view.findViewById(R.id.room408);
        room409 = (Switch)view.findViewById(R.id.room409);
        room410 = (Switch)view.findViewById(R.id.room410);
        room411 = (Switch)view.findViewById(R.id.room411);
        room412 = (Switch)view.findViewById(R.id.room412);
        room413 = (Switch)view.findViewById(R.id.room414);
        room414 = (Switch)view.findViewById(R.id.room414);
        room415 = (Switch)view.findViewById(R.id.room414);
        room416 = (Switch)view.findViewById(R.id.room416);
        room417 = (Switch)view.findViewById(R.id.room417);
        room418 = (Switch)view.findViewById(R.id.room418);
        room419 = (Switch)view.findViewById(R.id.room419);
        room420 = (Switch)view.findViewById(R.id.room420);

        return  view;
    }
}
