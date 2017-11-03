package com.eaphone.g08android.test;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.vondear.rxtools.RxLogUtils;
import com.vondear.rxtools.view.RxToast;
import com.zcr.g08android.R;

/**
 * Created by zhengchengrong on 2017/9/13.
 */

public class ValueAnimatorDemo extends Activity {
    private ImageView mBlueBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_value_animator_layout);
        RxToast.showToast(this,"测试补丁版本1",false);
        mBlueBall = (ImageView) findViewById(R.id.id_ball);
        RxToast.showToast(this,"测试补丁版本2",false);
        RxToast.showToast(this,"测试补丁版本3",false);
        test();

    }

    public void test(){
        RxToast.showToast(this,"山重水复疑无路，柳暗花明又一村",false);

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
