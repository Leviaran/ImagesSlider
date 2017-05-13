package com.singletonbase.randy.imageslider

import android.app.ActionBar
import android.content.Context
import android.content.res.Resources
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.load.engine.Resource
import org.jetbrains.annotations.NotNull
import java.util.logging.Handler

/**
 * Created by randy on 13/05/17.
 */
class IndikatorSlider(
        @NotNull var context: Context,
        var container :LinearLayout,
        var viewPager: ViewPager,
        var drawableRes : Int) : ViewPager.OnPageChangeListener {

    private var mHal : Int =0
    private var mSize : Int =0
    private var mSpasi : Int =0
    private var mHalInit : Int =0

    val DEFAULTSIZE = 12
    val DEFAULTSPACING = 12

    fun setPageCount (jmlhPage : Int){
        mHal = jmlhPage
    }

    fun setInitialHalaman ( hal : Int){
        mHalInit = hal
    }

    fun setDrawable(@DrawableRes drawable : Int) {
        drawableRes = drawable
    }

    fun setSpasi (@DimenRes spacingRes :Int){
        mSpasi = spacingRes
    }

    fun setSize (@DimenRes dimenRes : Int){
        mSize = dimenRes
    }

    fun show (){
        InitIndikator()
        setIndikatorSelek(mHalInit)
        android.os.Handler().postDelayed({  ->viewPager.setCurrentItem(1) },2500)
    }

    fun InitIndikator (){
        if (container == null || mHal <= 0) {
            return
        }
        viewPager.addOnPageChangeListener(this)
        var res : Resources = context.resources
        container.removeAllViews()
        for(i in 0..mHal-1){
            var view : View = View(context)
            var dimens : Int = if (mSize !=0) res.getDimensionPixelSize(mSize) else ((res.displayMetrics.density * DEFAULTSIZE).toInt())
            var margin : Int = if (mSpasi !=0) res.getDimensionPixelSize(mSpasi) else ((res.displayMetrics.density * DEFAULTSPACING).toInt())
            var lp : LinearLayout.LayoutParams = LinearLayout.LayoutParams(dimens,dimens)
            lp.setMargins(if (i==0) 0 else margin,0,0,0)
            view.layoutParams = lp
            view.setBackgroundResource(drawableRes)
            view.isSelected = i==0
            container.addView(view)
        }
    }

    fun setIndikatorSelek (index : Int){
        container?.let {
            for(i in 0..container.childCount-1){
                var view : View = container.getChildAt(i)
                view.isSelected = (i==index)
            }
        }
    }

    fun cleanUp (){
        viewPager.clearOnPageChangeListeners()
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {


    }

    override fun onPageSelected(position: Int) {
        var index : Int = position % mHal
        setIndikatorSelek(index)
        val moveTo : Int = position + 1
        try {
            android.os.Handler().postDelayed(Runnable { -> viewPager.setCurrentItem(moveTo) },2500)
        } catch (e : Exception){
            Log.i("Info",e.message)
        }
    }
}