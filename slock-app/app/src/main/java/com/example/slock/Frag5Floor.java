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

public class Frag5Floor extends Fragment {

    private View view;

    Switch room501, room502, room503, room504, room505, room506, room507, room508, room509, room510,
            room511, room512, room513, room514, room515, room516, room517, room518, room519, room520;

    boolean all, third;

    public static Frag5Floor newInstance(){
        Frag5Floor frag5Floor = new Frag5Floor();

        return frag5Floor;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_5floor, container, false);

        room501 = (Switch)view.findViewById(R.id.room501);
        room502 = (Switch)view.findViewById(R.id.room502);
        room503 = (Switch)view.findViewById(R.id.room505);
        room504 = (Switch)view.findViewById(R.id.room504);
        room505 = (Switch)view.findViewById(R.id.room505);
        room506 = (Switch)view.findViewById(R.id.room506);
        room507 = (Switch)view.findViewById(R.id.room507);
        room508 = (Switch)view.findViewById(R.id.room508);
        room509 = (Switch)view.findViewById(R.id.room509);
        room510 = (Switch)view.findViewById(R.id.room510);
        room511 = (Switch)view.findViewById(R.id.room511);
        room512 = (Switch)view.findViewById(R.id.room512);
        room513 = (Switch)view.findViewById(R.id.room515);
        room514 = (Switch)view.findViewById(R.id.room514);
        room515 = (Switch)view.findViewById(R.id.room515);
        room516 = (Switch)view.findViewById(R.id.room516);
        room517 = (Switch)view.findViewById(R.id.room517);
        room518 = (Switch)view.findViewById(R.id.room518);
        room519 = (Switch)view.findViewById(R.id.room519);
        room520 = (Switch)view.findViewById(R.id.room520);

        return  view;
    }
}
