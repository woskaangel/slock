package com.example.slock;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class HardwareActivity extends AppCompatActivity {

    ImageButton backBtn;
    CustomDialog customDialog;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_state);

        final RequestQueue queue = Volley.newRequestQueue(this);

        backBtn = (ImageButton)findViewById(R.id.hBackBtn);
        tv1 = (TextView)findViewById(R.id.hState1);
        tv2 = (TextView)findViewById(R.id.hState2);
        tv3 = (TextView)findViewById(R.id.hState3);

        final Timer timer = new Timer();
        TimerTask TT = new TimerTask() {
            @Override
            public void run() {
                String url = "http://192.168.1.12:8080/log/hardware";
                HashMap<String, String> data = new HashMap<>();
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(data),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                JSONObject jsonObject = null;
                                try {
                                    jsonObject = new JSONObject(response.toString());
                                    String main = jsonObject.getString("main");
                                    String sub1 = jsonObject.getString("sub1");
                                    String sub2 = jsonObject.getString("sub2");

                                    if(main.equals("1")){
                                        tv1.setText("정상작동중");
                                        tv1.setTextColor(getResources().getColor(R.color.green));
                                    }
                                    else{
                                        tv1.setText("통신오류");
                                        tv1.setTextColor(getResources().getColor(R.color.red));
                                    }
                                    if(sub1.equals("1")){
                                        tv2.setText("정상작동중");
                                        tv2.setTextColor(getResources().getColor(R.color.green));
                                    }
                                    else{
                                        tv2.setText("통신오류");
                                        tv2.setTextColor(getResources().getColor(R.color.red));
                                    }
                                    if(sub2.equals("1")){
                                        tv3.setText("정상작동중");
                                        tv3.setTextColor(getResources().getColor(R.color.green));
                                    }
                                    else{
                                        tv3.setText("통신오류");
                                        tv3.setTextColor(getResources().getColor(R.color.red));
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                customDialog = new CustomDialog(HardwareActivity.this, "이용에 불편을 드려 죄송합니다.\n잠시 후 다시 접속해 주세요.");
                                customDialog.show();
                            }
                        }
                );
                queue.add(request);
            }
        };
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                finish();
            }
        });
        timer.schedule(TT, 0, 1000); //Timer 실행
    }
}
