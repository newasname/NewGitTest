package com.example.newgittest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class littleFragment : Fragment() {
    val API_WAN_ANDROID = "https://www.wanandroid.com/"
    var rv:RecyclerView?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view= inflater.inflate(R.layout.fragment_little, container, false)
        initView(view)
        initData()
        return view
    }

    private fun initData() {

    }

    private fun initView(view: View?) {
        rv=view?.findViewById(R.id.little_rv)

    }


}