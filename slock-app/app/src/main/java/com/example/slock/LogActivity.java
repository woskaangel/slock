package com.example.slock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LogActivity extends AppCompatActivity {

    ImageButton backBtn, refreshBtn;
    RecyclerView recyclerView;
    LogAdapter adapter;
    CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        final RequestQueue queue = Volley.newRequestQueue(this);

        recyclerView = findViewById(R.id.lRecycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false); //레이아웃매니저 생성
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LogAdapter(getApplicationContext());

        recyclerView.setAdapter(adapter); // RecyclerView에 Adapter 연결

        backBtn = (ImageButton)findViewById(R.id.lbackBtn);
        refreshBtn = (ImageButton)findViewById(R.id.lrefreshBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 반복실행할 구문
                String url = "http://192.168.1.12:8080/log/read";
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            adapter.removeItem();
                            for (int i = 0; i <= response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String oc = jsonObject.getString("l_num");
                                String time = jsonObject.getString("l_time");
                                adapter.addItem(new LogClass(time, oc));
                                recyclerView.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ExitDialog();
                    }
                });
                queue.add(request);
            }
        });
        // 반복실행할 구문
        String url = "http://192.168.1.12:8080/log/read";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    adapter.removeItem();
                    for (int i = 0; i <= response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String oc = jsonObject.getString("l_num");
                        String time = jsonObject.getString("l_time");
                        adapter.addItem(new LogClass(time, oc));
                        recyclerView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ExitDialog();
            }
        });
        queue.add(request);
    }

    public void ExitDialog(){
        final CustomDialog customDialog = new CustomDialog(this, "이용에 불편을 드려 죄송합니다.\n잠시 후 다시 접속해 주세요.");
        customDialog.show();

        customDialog.btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();

                moveTaskToBack(true);						// 태스크를 백그라운드로 이동
                finishAndRemoveTask();						// 액티비티 종료 + 태스크 리스트에서 지우기
                android.os.Process.killProcess(android.os.Process.myPid());	// 앱 프로세스 종료
            }
        });
    }
}
