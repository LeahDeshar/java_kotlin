package com.example.planetapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter (context: Context, planets:List<Planets>) :BaseAdapter(){
    private val mContext:Context = context
    private val mPlanets:List<Planets> = planets


    override fun getCount(): Int {
        return mPlanets.size
    }

    override fun getItem(p0: Int): Any {

        return mPlanets[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View
        if(p1 == null){
            view = inflater.inflate(R.layout.item_list_layout, null)
        }else{
            view = p1
        }

        val item = getItem(p0) as Planets

       val titleTxt =  view.findViewById<TextView>(R.id.planetName)
        val moonCountTxt = view.findViewById<TextView>(R.id.moonCount)
        val image = view.findViewById<ImageView>(R.id.planetImage)

        titleTxt.text = item.title
        moonCountTxt.text = item.moonCount
        image.setImageResource(item.image)
        return view



    }


}