package com.zcr.myproject.test;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.vondear.rxtools.RxLogUtils;
import com.zcr.myproject.R;

/**
 * Created by zhengchengrong on 2017/9/13.
 */

public class ValueAnimatorDemo extends Activity {
    private ImageView mBlueBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_value_animator_layout);
        mBlueBall = (ImageView) findViewById(R.id.id_ball);
    }

    /**
     * 抛物线
     * @param view
     */
    public void paowuxian(View view){
        //设置自定义的TypeEvaluator，起始属性
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyTypeEvaluator(), new Point(0, 0));
        //设置持续时间
        valueAnimator.setDuration(1500);
        //设置线性时间插值器
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                mBlueBall.setX(point.x);
                mBlueBall.setY(point.y);
                RxLogUtils.d("MyTypeEvaluator:"+point.x+":"+point.y);

            }
        });
        valueAnimator.start();
    }
}
