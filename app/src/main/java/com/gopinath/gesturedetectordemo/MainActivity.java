package com.gopinath.gesturedetectordemo;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private Matrix mMatrix = new Matrix();
    private float mFocusX = 0.f;
    private float mFocusY = 0.f;
    private int mImageHeight, mImageWidth;
    private float mScaleFactor = .4f;

    private ScaleGestureDetector mScaleDetector;
    private RotateGestureDetector mRotateGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        mFocusX = display.getWidth()/2f;
        mFocusY = display.getHeight()/2f;

        ImageView view = (ImageView)findViewById(R.id.imageView);
        view.setOnTouchListener(this);

        Drawable d = this.getResources().getDrawable(R.drawable.ic_launcher);
        mImageHeight = d.getIntrinsicHeight();
        mImageWidth = d.getIntrinsicWidth();

        float scaledImageCenterX = (mImageWidth*mScaleFactor)/2;
        float scaledImageCenterY = (mImageHeight*mScaleFactor)/2;

        mMatrix.postScale(mScaleFactor,mScaleFactor);
        mMatrix.postTranslate(mFocusX - scaledImageCenterX,mFocusY-scaledImageCenterY);
        view.setImageMatrix(mMatrix);




    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
