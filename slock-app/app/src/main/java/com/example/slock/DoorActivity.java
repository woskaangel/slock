package com.example.slock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

public class DoorActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    Switch all, thirdFloor, fourthFloor, fifthFloor;

//        fragment.room401, fragment.room402, fragment.room403, fragment.room404, fragment.room405, fragment.room406, fragment.room407, fragment.room408, fragment.room409, fragment.room410,
//        fragment.room411, fragment.room412, fragment.room413, fragment.room414, fragment.room415, fragment.room416, fragment.room417, fragment.room418, fragment.room419, fragment.room420;
//        fragment.room501, fragment.room502, fragment.room503, fragment.room504, fragment.room505, fragment.room506, fragment.room507, fragment.room508, fragment.room509, fragment.room510,
//        fragment.room511, fragment.room512, fragment.room513, fragment.room514, fragment.room515, fragment.room516, fragment.room517, fragment.room518, fragment.room519, fragment.room520;

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        // 뷰페이지 세팅
        viewPager = (ViewPager)findViewById(R.id.dViewPager);
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        tabLayout = (TabLayout)findViewById(R.id.dTabLayout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        backBtn = (ImageButton)findViewById(R.id.dbackBtn);

        // 프래그먼트
        all = (Switch)findViewById(R.id.dAllSw);
        thirdFloor = (Switch)findViewById(R.id.d3Sw);
        fourthFloor = (Switch )findViewById(R.id.d4Sw);
        fifthFloor = (Switch)findViewById(R.id.d5Sw);
//        // 4층
//        fragment.room401 = (Switch)findViewById(R.id.fragment.room401);
//        fragment.room402 = (Switch)findViewById(R.id.fragment.room402);
//        fragment.room403 = (Switch)findViewById(R.id.fragment.room403);
//        fragment.room404 = (Switch)findViewById(R.id.fragment.room404);
//        fragment.room405 = (Switch)findViewById(R.id.fragment.room405);
//        fragment.room406 = (Switch)findViewById(R.id.fragment.room406);
//        fragment.room407 = (Switch)findViewById(R.id.fragment.room407);
//        fragment.room408 = (Switch)findViewById(R.id.fragment.room408);
//        fragment.room409 = (Switch)findViewById(R.id.fragment.room409);
//        fragment.room410 = (Switch)findViewById(R.id.fragment.room410);
//        fragment.room411 = (Switch)findViewById(R.id.fragment.room411);
//        fragment.room412 = (Switch)findViewById(R.id.fragment.room412);
//        fragment.room413 = (Switch)findViewById(R.id.fragment.room413);
//        fragment.room414 = (Switch)findViewById(R.id.fragment.room414);
//        fragment.room415 = (Switch)findViewById(R.id.fragment.room415);
//        fragment.room416 = (Switch)findViewById(R.id.fragment.room416);
//        fragment.room417 = (Switch)findViewById(R.id.fragment.room417);
//        fragment.room418 = (Switch)findViewById(R.id.fragment.room418);
//        fragment.room419 = (Switch)findViewById(R.id.fragment.room419);
//        fragment.room420 = (Switch)findViewById(R.id.fragment.room420);
//        // 5층
//        fragment.room501 = (Switch)findViewById(R.id.fragment.room501);
//        fragment.room502 = (Switch)findViewById(R.id.fragment.room502);
//        fragment.room503 = (Switch)findViewById(R.id.fragment.room503);
//        fragment.room504 = (Switch)findViewById(R.id.fragment.room504);
//        fragment.room505 = (Switch)findViewById(R.id.fragment.room505);
//        fragment.room506 = (Switch)findViewById(R.id.fragment.room506);
//        fragment.room507 = (Switch)findViewById(R.id.fragment.room507);
//        fragment.room508 = (Switch)findViewById(R.id.fragment.room508);
//        fragment.room509 = (Switch)findViewById(R.id.fragment.room509);
//        fragment.room510 = (Switch)findViewById(R.id.fragment.room510);
//        fragment.room511 = (Switch)findViewById(R.id.fragment.room511);
//        fragment.room512 = (Switch)findViewById(R.id.fragment.room512);
//        fragment.room513 = (Switch)findViewById(R.id.fragment.room513);
//        fragment.room514 = (Switch)findViewById(R.id.fragment.room514);
//        fragment.room515 = (Switch)findViewById(R.id.fragment.room515);
//        fragment.room516 = (Switch)findViewById(R.id.fragment.room516);
//        fragment.room517 = (Switch)findViewById(R.id.fragment.room517);
//        fragment.room518 = (Switch)findViewById(R.id.fragment.room518);
//        fragment.room519 = (Switch)findViewById(R.id.fragment.room519);
//        fragment.room520 = (Switch)findViewById(R.id.fragment.room520);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//    private void setFifthFloor(boolean sw) {
//        if(sw){
//            fragment.room501.setChecked(true);
//            fragment.room502.setChecked(true);
//            fragment.room503.setChecked(true);
//            fragment.room504.setChecked(true);
//            fragment.room505.setChecked(true);
//            fragment.room506.setChecked(true);
//            fragment.room507.setChecked(true);
//            fragment.room508.setChecked(true);
//            fragment.room509.setChecked(true);
//            fragment.room510.setChecked(true);
//            fragment.room511.setChecked(true);
//            fragment.room512.setChecked(true);
//            fragment.room513.setChecked(true);
//            fragment.room514.setChecked(true);
//            fragment.room515.setChecked(true);
//            fragment.room516.setChecked(true);
//            fragment.room517.setChecked(true);
//            fragment.room518.setChecked(true);
//            fragment.room519.setChecked(true);
//            fragment.room520.setChecked(true);
//        }
//        else{
//            fragment.room501.setChecked(false);
//            fragment.room502.setChecked(false);
//            fragment.room503.setChecked(false);
//            fragment.room504.setChecked(false);
//            fragment.room505.setChecked(false);
//            fragment.room506.setChecked(false);
//            fragment.room507.setChecked(false);
//            fragment.room508.setChecked(false);
//            fragment.room509.setChecked(false);
//            fragment.room510.setChecked(false);
//            fragment.room511.setChecked(false);
//            fragment.room512.setChecked(false);
//            fragment.room513.setChecked(false);
//            fragment.room514.setChecked(false);
//            fragment.room515.setChecked(false);
//            fragment.room516.setChecked(false);
//            fragment.room517.setChecked(false);
//            fragment.room518.setChecked(false);
//            fragment.room519.setChecked(false);
//            fragment.room520.setChecked(false);
//        }
//    }
//
//    private void setFourthFloor(boolean sw) {
//        if(sw){
//            fragment.room401.setChecked(true);
//            fragment.room402.setChecked(true);
//            fragment.room403.setChecked(true);
//            fragment.room404.setChecked(true);
//            fragment.room405.setChecked(true);
//            fragment.room406.setChecked(true);
//            fragment.room407.setChecked(true);
//            fragment.room408.setChecked(true);
//            fragment.room409.setChecked(true);
//            fragment.room410.setChecked(true);
//            fragment.room411.setChecked(true);
//            fragment.room412.setChecked(true);
//            fragment.room413.setChecked(true);
//            fragment.room414.setChecked(true);
//            fragment.room415.setChecked(true);
//            fragment.room416.setChecked(true);
//            fragment.room417.setChecked(true);
//            fragment.room418.setChecked(true);
//            fragment.room419.setChecked(true);
//            fragment.room420.setChecked(true);
//        }
//        else{
//            fragment.room401.setChecked(false);
//            fragment.room402.setChecked(false);
//            fragment.room403.setChecked(false);
//            fragment.room404.setChecked(false);
//            fragment.room405.setChecked(false);
//            fragment.room406.setChecked(false);
//            fragment.room407.setChecked(false);
//            fragment.room408.setChecked(false);
//            fragment.room409.setChecked(false);
//            fragment.room410.setChecked(false);
//            fragment.room411.setChecked(false);
//            fragment.room412.setChecked(false);
//            fragment.room413.setChecked(false);
//            fragment.room414.setChecked(false);
//            fragment.room415.setChecked(false);
//            fragment.room416.setChecked(false);
//            fragment.room417.setChecked(false);
//            fragment.room418.setChecked(false);
//            fragment.room419.setChecked(false);
//            fragment.room420.setChecked(false);
//        }
//    }
//
//    private void setThirdFloor(boolean sw) {
//        Frag3Floor fragment = (Frag3Floor) getSupportFragmentManager().findFragmentById()
//
//        if(sw){
//            fragment.room301.setChecked(true);
//            fragment.room302.setChecked(true);
//            fragment.room303.setChecked(true);
//            fragment.room304.setChecked(true);
//            fragment.room305.setChecked(true);
//            fragment.room306.setChecked(true);
//            fragment.room307.setChecked(true);
//            fragment.room308.setChecked(true);
//            fragment.room309.setChecked(true);
//            fragment.room310.setChecked(true);
//            fragment.room311.setChecked(true);
//            fragment.room312.setChecked(true);
//            fragment.room313.setChecked(true);
//            fragment.room314.setChecked(true);
//            fragment.room315.setChecked(true);
//            fragment.room316.setChecked(true);
//            fragment.room317.setChecked(true);
//            fragment.room318.setChecked(true);
//            fragment.room319.setChecked(true);
//            fragment.room320.setChecked(true);
//        }
//        else{
//            fragment.room301.setChecked(false);
//            fragment.room302.setChecked(false);
//            fragment.room303.setChecked(false);
//            fragment.room304.setChecked(false);
//            fragment.room305.setChecked(false);
//            fragment.room306.setChecked(false);
//            fragment.room307.setChecked(false);
//            fragment.room308.setChecked(false);
//            fragment.room309.setChecked(false);
//            fragment.room310.setChecked(false);
//            fragment.room311.setChecked(false);
//            fragment.room312.setChecked(false);
//            fragment.room313.setChecked(false);
//            fragment.room314.setChecked(false);
//            fragment.room315.setChecked(false);
//            fragment.room316.setChecked(false);
//            fragment.room317.setChecked(false);
//            fragment.room318.setChecked(false);
//            fragment.room319.setChecked(false);
//            fragment.room320.setChecked(false);
//        }
//    }

    public boolean getAll(){
        if(all.isChecked())
            return true;
        else
            return false;
    }

    public boolean get3Floor(){
        if(thirdFloor.isChecked())
            return true;
        else
            return false;
    }

    public boolean get4Floor(){
        if(fourthFloor.isChecked())
            return true;
        else
            return false;
    }

    public boolean get5Floor(){
        if(fifthFloor.isChecked())
            return true;
        else
            return false;
    }
}
