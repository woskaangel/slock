package com.example.slock;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class CustomAnimation extends Dialog {

    Context c;
    ImageView img;

    public CustomAnimation(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        setCanceledOnTouchOutside(false);

        c=context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void show() {
        super.show();
        setContentView(R.layout.loading_dialog);

        img = (ImageView) findViewById(R.id.loadingImage);
        Animation a = AnimationUtils.loadAnimation(c, R.anim.anim_loading);
        a.setDuration(1300);
        img.startAnimation(a);
    }
    @Override
    public void dismiss() {
        super.dismiss();
    }
}