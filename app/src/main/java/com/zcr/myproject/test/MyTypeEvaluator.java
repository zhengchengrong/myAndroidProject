package com.zcr.myproject.test;

import android.animation.TypeEvaluator;

import com.vondear.rxtools.RxLogUtils;

/**
 * 要实现抛物线的效果，水平方向100px/s，垂直方向加速度200px/s*s，
 * 你会发现我们只需要知道时间的变化，就可以求出某刻小球的水平位移（即x）和竖直位移（即y）。
 * 那么公式就是：x = 200t ; y=at²
 * Created by zhengchengrong on 2017/9/13.
 */
// 你需要指定一个泛型，这里我们操作的是Point 对象，当我们指定Point 为泛型时，evaluate的返回值也是Point
public class MyTypeEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        Point point = new Point();
        // 我们并没有用到startValue和endValue，而是使用了一个写死的1.5f，
        // 因为没必要，我们的抛物线是与时间挂钩的，不用他们也是完全可以的，这样写的话，出来的效果就是：球运行1.5s的轨迹图
        point.x = 200 * (fraction * 1.5f);//fraction * 1.5f就是时间，fraction代表时间流逝的百分比，1.5代表1500ms即1.5s
        point.y = 200 * (fraction * 1.5f) * (fraction * 1.5f);
        RxLogUtils.d("MyTypeEvaluator:"+fraction); // 0.0 - 1.0
        return point;
    }
}
