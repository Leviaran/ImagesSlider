package com.singletonbase.randy.imageslider


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


/**
 * A simple [Fragment] subclass.
 */
class FragmentSlider : Fragment() {



    lateinit private var image :String

    companion object {
        private val ARG_PARAM1 = "params"
        @JvmStatic fun newInstance (param : String) : FragmentSlider {
            var fragment :FragmentSlider = FragmentSlider()
            var arg : Bundle = Bundle()
            arg.putString(ARG_PARAM1,param)
            fragment.arguments = arg
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //image = arguments.getString(ARG_PARAM1)
        var view : View = inflater.inflate(R.layout.fragment_fragment_slider,container,false)
        var img : ImageView = view.findViewById(R.id.img) as ImageView
//        Log.i("Image",image)
        Picasso.with(context).load("http://image.priceprice.k-img.com/service/id/images/article/2779_ID/MLY_summary.jpg").into(img)
        //Glide.with(activity).load("http://image.priceprice.k-img.com/service/id/images/article/2779_ID/MLY_summary.jpg").into(img)
        return view
    }

}// Required empty public constructor
