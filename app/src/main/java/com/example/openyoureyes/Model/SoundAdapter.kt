package com.example.openyoureyes.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.openyoureyes.R

class SoundAdapter (val context: Context, val SoundList: ArrayList<Sound>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_sound_list, null)

        val name = view.findViewById<TextView>(R.id.sound_name)
        val sound = SoundList[position]

        name.text = sound.name

        return view

    }

    override fun getCount(): Int = SoundList.size

    override fun getItem(position: Int): Sound = SoundList[position]

    override fun getItemId(position: Int): Long = position.toLong()

}