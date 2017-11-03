package com.eaphone.g08android.test;

/**
 * Created by zhengchengrong on 2017/9/13.
 * 所以我们可以创建一个Point类来保存这两个值。前面我们使用过ValueAnimator的ofFloat()和ofInt()方法，分别用于对浮点型和整型的数据进行动画操作的，但实际上ValueAnimator中还有一个ofObject()方法，是用于对任意对象进行动画操作的。
 * 但是相比于浮点型或整型数据，对象的动画操作明显要更复杂一些，因为系统将完全无法知道如何从初始对象过度到结束对象，
 * 因此这个时候我们就需要实现一个自己的TypeEvaluator来告知系统如何进行过度。
 * 这里我们要过度的对象就是Point对象。
 */

public class Point {
    float x;
    float y;
    public Point(){

    }
    public Point(float x,float y){
        this.x = x;
        this.y = y;
    }
}
