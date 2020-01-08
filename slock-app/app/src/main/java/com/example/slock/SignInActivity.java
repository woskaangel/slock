package com.example.slock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class SignInActivity extends AppCompatActivity {

    Button signupBtn, continueBtn;
    EditText inId, inPwd;
    ImageView loadingImage;
    Vibrator vibrator;
    CustomAnimation customAnimation;
    TextView warnId, warnPwd;
    InputMethodManager imm;
    ImageButton deleteIdBtn, deletePwdBtn, seeBtn;
    Boolean flag = true;
    CheckBox check;
    CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        final RequestQueue queue = Volley.newRequestQueue(this);

        signupBtn = (Button)findViewById(R.id.inSignupBtn);
        continueBtn = (Button)findViewById(R.id.inContinueBtn);

        inId = (EditText)findViewById(R.id.inId);
        inPwd = (EditText)findViewById(R.id.inPwd);

        loadingImage = (ImageView)findViewById(R.id.loadingImage);

        customAnimation = new CustomAnimation(SignInActivity.this);

        warnId = (TextView)findViewById(R.id.inWarnId);
        warnPwd = (TextView)findViewById(R.id.inWarnPwd);

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        deleteIdBtn = (ImageButton)findViewById(R.id.inIdDel);
        deletePwdBtn = (ImageButton)findViewById(R.id.inPwdDel);
        seeBtn = (ImageButton)findViewById(R.id.inPwdSee);

        check = (CheckBox)findViewById(R.id.checkbox);

        inId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                warnId.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                warnId.setVisibility(View.INVISIBLE);

                if(!inId.getText().toString().equals("")){
                    deleteIdBtn.setVisibility(View.VISIBLE);
                }
                else{
                    deleteIdBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(inId.getText().toString().equals("") || inPwd.getText().toString().equals("")){
                    continueBtn.setBackgroundResource(R.drawable.button2_background);
                    continueBtn.setTextColor(getResources().getColor(R.color.mainPurple));
                }
                else{
                    continueBtn.setBackgroundResource(R.drawable.button_background);
                    continueBtn.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        inPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                warnPwd.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                warnPwd.setVisibility(View.INVISIBLE);

                if(!inPwd.getText().toString().equals("")){
                    deletePwdBtn.setVisibility(View.VISIBLE);
                }
                else{
                    deletePwdBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(inId.getText().toString().equals("") || inPwd.getText().toString().equals("")){
                    continueBtn.setBackgroundResource(R.drawable.button2_background);
                    continueBtn.setTextColor(getResources().getColor(R.color.mainPurple));
                }
                else{
                    continueBtn.setBackgroundResource(R.drawable.button_background);
                    continueBtn.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        inId.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) { // EdiText에 포커스가 있는지 확인
                if(!hasFocus){ // 만약 포커스가 되어있지 않으면
                    deleteIdBtn.setVisibility(View.GONE);
                }
                else{
                    if(!inId.getText().toString().equals("")){
                        deleteIdBtn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        inPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    deletePwdBtn.setVisibility(View.GONE);
                }
                else{
                    if(!inPwd.getText().toString().equals("")){
                        deletePwdBtn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        inPwd.setOnEditorActionListener(new TextView.OnEditorActionListener() { // Password 입력 후 키보드의 완료 버튼을 누르면
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch(actionId) {
                    case EditorInfo.IME_ACTION_DONE:
                        continueBtn.callOnClick(); // 자동으로 continue 버튼을 눌러줌
                        break;
                }
                return false;
            }
        });

        deleteIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inId.setText("");
            }
        });
        deletePwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inPwd.setText("");
            }
        });

        seeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == true){
                    seeBtn.setImageResource(R.drawable.eye_open);
                    inPwd.setInputType(InputType.TYPE_CLASS_TEXT  | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                    flag = false;
                }
                else{
                    seeBtn.setImageResource(R.drawable.eye_close);

                    inPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                    flag = true;
                }
                inPwd.setSelection(inPwd.length());
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inId.getText().toString().equals("") || inPwd.getText().toString().equals("")){
                    vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(200);

                    if (inPwd.getText().toString().equals("")) {
                        warnPwd.setVisibility(View.VISIBLE);

                        inPwd.requestFocus();
                        imm.showSoftInput(inPwd,0);
                    }
                    if (inId.getText().toString().equals("")) {
                        warnId.setVisibility(View.VISIBLE);

                        inId.requestFocus(); // id에 자동 포커스 맞추기
                        imm.showSoftInput(inId,0); // 키보드
                    }
                }
                else{
                    customAnimation.show();

                    String url = "http://192.168.1.12:8080/login";
                    HashMap<String, String> data = new HashMap<>();
                    data.put("id", inId.getText().toString());
                    data.put("pw", inPwd.getText().toString());
                    // Request a string response from the provided URL
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(data),
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    customAnimation.dismiss();

                                    try {
                                        JSONObject jsonObject = new JSONObject(response.toString());
                                        String result = jsonObject.getString("level");
                                        String name = jsonObject.getString("name");

                                        if(result.equals("1")){
                                            String roomnumber =  jsonObject.getString("rnum");

                                            SharedPreference.setAttribute(getApplicationContext(), "job", "student");
                                            SharedPreference.setAttribute(getApplicationContext(), "name", name);
                                            SharedPreference.setAttribute(getApplicationContext(), "roomnumber", roomnumber);
                                            SharedPreference.setAttribute(getApplicationContext(), "id", inId.getText().toString());

                                            if(check.isChecked()){
                                                SharedPreference.setAttribute(getApplicationContext(), "remember", "ok");
                                            }

                                            Intent intent1 = new Intent(getApplicationContext(), MainStudentActivity.class);
                                            startActivity(intent1);

                                            finish();
                                        }
                                        else if(result.equals("2")){
                                            SharedPreference.setAttribute(getApplicationContext(), "job", "teacher");
                                            SharedPreference.setAttribute(getApplicationContext(), "name", name);
                                            SharedPreference.setAttribute(getApplicationContext(), "id", inId.getText().toString());

                                            if(check.isChecked()){
                                                SharedPreference.setAttribute(getApplicationContext(), "remember", "ok");
                                            }

                                            Intent intent2 = new Intent(getApplicationContext(), MainTeacherActivity.class);
                                            startActivity(intent2);

                                            finish();
                                        }
                                        else{
                                            customDialog = new CustomDialog(SignInActivity.this, "일치하는 회원 정보가 없습니다.\n아이디 비밀번호를 확인해 주세요.");
                                            customDialog.show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            customAnimation.dismiss();

                            ExitDialog();
                        }
                    });
                    request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    queue.add(request);
                }
            }
        });
    }

    public void ExitDialog(){
        customDialog = new CustomDialog(SignInActivity.this, "이용에 불편을 드려 죄송합니다.\n잠시 후 다시 접속해 주세요.");
        customDialog.show();

        customDialog.btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.runFinalization();
                System.exit(0);

                customDialog.dismiss();
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
