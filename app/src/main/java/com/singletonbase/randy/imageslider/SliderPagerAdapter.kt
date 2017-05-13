package com.singletonbase.randy.imageslider

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by randy on 13/05/17.
 */
class SliderPagerAdapter(fm : FragmentManager, fragments : List<Fragment>) : FragmentStatePagerAdapter(fm) {

    val TAG = "SliderPagerAdapter"
    var mFragments : List<Fragment> = ArrayList()

    init {
        mFragments=fragments
    }


    override fun getItem(position: Int): Fragment {
        //var fragment : Fragment
        var index : Int = position % mFragments.size
                //fragment = FragmentSlider()
        //return fragment
        return FragmentSlider.newInstance(mFragments.get(index).arguments.getString("params"))
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }
}