package com.singletonbase.randy.imageslider

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.animation.DecelerateInterpolator
import android.widget.Scroller
import java.lang.reflect.Field
import javax.xml.datatype.Duration

/**
 * Created by randy on 13/05/17.
 */
class SliderView : ViewPager {

    val DEFAULT_SCROLL_DURATION =200
    val SLIDE_MODE_SCROLL_DURATION = 1000

    constructor(context: Context) : super(context){init()}
    constructor(context: Context, attributeSet: AttributeSet) : super(context,attributeSet){init()}

    fun init() {
        setDurationScroll(DEFAULT_SCROLL_DURATION)
        this.setOnTouchListener { v, event -> true }
    }

    fun setDurationScroll(millis :Int){

        try{
            var viewPager : Class<*> = ViewPager::class.java
            var scroller : Field = viewPager.getDeclaredField("mScroller")
            scroller.isAccessible = true
            scroller.set(this,OwnScroller(context,millis))
        } catch (e : Exception){
            Log.i("info",e.message)
        }
    }
    inner class OwnScroller(context: Context,durationScroll : Int) : Scroller(context,DecelerateInterpolator()){
        private var durationScrollMillis = 1
        init {
            this.durationScrollMillis = durationScroll
        }

        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, durationScrollMillis)
        }
    }
}