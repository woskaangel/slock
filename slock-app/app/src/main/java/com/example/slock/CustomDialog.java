package com.example.slock;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog {
    Context mContext;
    Button btn_ok;
    TextView dialog_text;
    String text;

    public CustomDialog(@NonNull Context context, String text) {
        super(context);
        mContext = context;
        this.text = text;

        this.setCancelable(false);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void show() {
        super.show();
        setContentView(R.layout.custom_dialog);

        btn_ok = (Button)findViewById(R.id.dialog_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        dialog_text = (TextView)findViewById(R.id.dialog_text);
        dialog_text.setText(text);
    }
}