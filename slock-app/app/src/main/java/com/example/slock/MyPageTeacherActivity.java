package com.example.slock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

public class MyPageTeacherActivity extends AppCompatActivity {

    TextView userName;
    ImageButton backBtn,  deleteNowPwdBtn, deletePwd1Btn, deletePwd2Btn, seeNowBtn, see1Btn, see2Btn;;
    Button continueBtn;
    EditText NowPwd, Pwd1, Pwd2;
    int pwflg = 0;
    CustomDialog customDialog;
    Boolean flag0= true, flag1 = true, flag2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_teacher);

        final RequestQueue queue = Volley.newRequestQueue(this);

        userName = (TextView)findViewById(R.id.mytUser);

        backBtn = (ImageButton)findViewById(R.id.mytbackBtn);
        deleteNowPwdBtn = (ImageButton)findViewById(R.id.mytNowPwdDel);
        deletePwd1Btn = (ImageButton)findViewById(R.id.mytPwd1Del);
        deletePwd2Btn = (ImageButton)findViewById(R.id.mytPwd2Del);
        seeNowBtn = (ImageButton)findViewById(R.id.mytNowPwdSee);
        see1Btn = (ImageButton)findViewById(R.id.mytPwd1See);
        see2Btn = (ImageButton)findViewById(R.id.mytPwd2See);

        continueBtn = (Button)findViewById(R.id.mytContinueBtn);

        NowPwd = (EditText)findViewById(R.id.mytNowPwd);
        Pwd1 = (EditText)findViewById(R.id.mytPwd1);
        Pwd2 = (EditText)findViewById(R.id.mytPwd2);

        userName.setText(SharedPreference.getAttribute(getApplicationContext(), "name"));

        NowPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!NowPwd.getText().toString().equals("")){
                    deleteNowPwdBtn.setVisibility(View.VISIBLE);
                }
                else{
                    deleteNowPwdBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        Pwd1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!Pwd1.getText().toString().equals("")){
                    deletePwd1Btn.setVisibility(View.VISIBLE);
                }
                else{
                    deletePwd1Btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        Pwd2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!Pwd2.getText().toString().equals("")){
                    deletePwd2Btn.setVisibility(View.VISIBLE);
                }
                else{
                    deletePwd2Btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        NowPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){ // 만약 포커스가 되어있지 않으면
                    deleteNowPwdBtn.setVisibility(View.GONE);
                }
                else{
                    if(!NowPwd.getText().toString().equals("")){
                        deleteNowPwdBtn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        Pwd1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){ // 만약 포커스가 되어있지 않으면
                    deletePwd1Btn.setVisibility(View.GONE);
                }
                else{
                    if(!Pwd1.getText().toString().equals("")){
                        deletePwd1Btn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        Pwd2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) { // EdiText에 포커스가 있는지 확인
                if(!hasFocus){ // 만약 포커스가 되어있지 않으면
                    deletePwd2Btn.setVisibility(View.GONE);
                }
                else{
                    if(!Pwd2.getText().toString().equals("")){
                        deletePwd2Btn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        deleteNowPwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NowPwd.setText("");
            }
        });
        deletePwd1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pwd1.setText("");
            }
        });
        deletePwd2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pwd2.setText("");
            }
        });

        seeNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag0 == true){
                    seeNowBtn.setImageResource(R.drawable.eye_open);
                    NowPwd.setInputType(InputType.TYPE_CLASS_TEXT  | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                    flag0 = false;
                }
                else{
                    seeNowBtn.setImageResource(R.drawable.eye_close);
                    NowPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                    flag0 = true;
                }
                NowPwd.setSelection(NowPwd.length());
            }
        });

        see1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag1 == true){
                    see1Btn.setImageResource(R.drawable.eye_open);
                    Pwd1.setInputType(InputType.TYPE_CLASS_TEXT  | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                    flag1 = false;
                }
                else{
                    see1Btn.setImageResource(R.drawable.eye_close);
                    Pwd1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                    flag1 = true;
                }
                Pwd1.setSelection(Pwd1.length());
            }
        });

        see2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag2 == true){
                    see2Btn.setImageResource(R.drawable.eye_open);
                    Pwd2.setInputType(InputType.TYPE_CLASS_TEXT  | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                    flag2 = false;
                }
                else{
                    see2Btn.setImageResource(R.drawable.eye_close);
                    Pwd2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                    flag2 = true;
                }
                Pwd2.setSelection(Pwd2.length());
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        NowPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                HashMap<String, String> data = new HashMap<>();
                String id=SharedPreference.getAttribute(getApplicationContext(), "id");
                data.put("id", id);
                data.put("pw", NowPwd.getText().toString());
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://192.168.1.12:8080/login", new JSONObject(data), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            String result = jsonObject.getString("level");
                            if (result.equals("1") || result.equals("2")) {
                                pwflg = 1;
                            } else {
                                pwflg = 0;
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
                request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queue.add(request);
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pwflg == 1){ // 현재 비밀번호가 일치하는지 확인
                    String id = SharedPreference.getAttribute(getApplicationContext(), "id");
                    HashMap<String, String> data = new HashMap<>();
                    data.put("id", id);

                    if(!Pwd1.getText().toString().equals("") && !Pwd2.getText().toString().equals("")){ // 바꿀 비밀번호 두개가 비어있지 않은지 확인
                        if(Pwd1.getText().toString().equals(Pwd2.getText().toString())) { // 비밀번호가 두개가 일치하는지 확인
                            data.put("cpw", Pwd1.getText().toString());
                            JsonObjectRequest request = request = new JsonObjectRequest(Request.Method.POST, "http://192.168.1.12:8080/pwchange", new JSONObject(data),
                                    new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            ToastCustom("비밀번호가 변경되었습니다.");

                                            finish();
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            ExitDialog();
                                        }
                                    }
                            );
                            request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                            queue.add(request);
                        }
                        else{
                            customDialog = new CustomDialog(MyPageTeacherActivity.this, "새로운 비밀번호를 확인해 주세요.");
                            customDialog.show();
                        }
                    }
                }
                else{
                    if(NowPwd.getText().length() == 0){
                        customDialog = new CustomDialog(MyPageTeacherActivity.this, "현재 비밀번호를 입력해 주세요.");
                    }
                    else{
                        customDialog = new CustomDialog(MyPageTeacherActivity.this, "현재 비밀번호를 확인해 주세요.");
                    }
                    customDialog.show();
                }
            }
        });

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

    public void ToastCustom(String word){
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.toastborder, (ViewGroup)findViewById(R.id.toast_layout_root));
        TextView text = layout.findViewById(R.id.toastTxt);

        Toast toast = new Toast(getApplicationContext());
        text.setText(word);
//        toast.setGravity(Gravity.CENTER, 0, 500);
        toast.setDuration(Toast.LENGTH_SHORT);

        toast.setView(layout);
        toast.show();
    }
}
