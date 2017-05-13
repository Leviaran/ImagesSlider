package com.singletonbase.randy.imageslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var adapter : SliderPagerAdapter
    lateinit var indikator : IndikatorSlider

    lateinit var slider : SliderView
    lateinit var linearLayout : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        slider = findViewById(R.id.slider) as SliderView
        linearLayout = findViewById(R.id.pagesContainer) as LinearLayout
        setupSlider()

    }

    fun setupSlider (){
        slider.setDurationScroll(800)
        var fragment : MutableList<Fragment> = ArrayList()
        fragment.add(FragmentSlider.newInstance("http://image.priceprice.k-img.com/service/id/images/article/2779_ID/MLY_summary.jpg"))
        fragment.add(FragmentSlider.newInstance("http://image.priceprice.k-img.com/service/id/images/article/2779_ID/MLY_summary.jpg"))
        fragment.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"))
        fragment.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"))

        adapter = SliderPagerAdapter(supportFragmentManager, fragment)
        slider.adapter = adapter
        indikator = IndikatorSlider(this, linearLayout, slider,R.drawable.indicator_circle)
        indikator.setPageCount(fragment.size)
        indikator.show()

    }
}
