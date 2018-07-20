package com.example.edward.bibleeducation.Classes;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.edward.bibleeducation.R;
import com.example.edward.bibleeducation.service.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Gesture extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onDown(MotionEvent event) {
        LogUtil.LogI("TAG","onDown: ");

        // don't return false here or else none of the other
        // gestures will work
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        LogUtil.LogI("TAG", "onSingleTapConfirmed: ");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
       LogUtil.LogI("TAG", "onLongPress: ");
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        LogUtil.LogI("TAG", "onDoubleTap: ");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        LogUtil.LogI("TAG", "onScroll: ");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {
        LogUtil.LogD("fling", "onFling has been called!");
        final int SWIPE_MIN_DISTANCE = 120;
        try {
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE) {
                LogUtil.LogD("fling", "Right to Left");
            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE) {
                LogUtil.LogD("fling", "Left to Right");
            }
        } catch (Exception e) {
            // nothing
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
    }

