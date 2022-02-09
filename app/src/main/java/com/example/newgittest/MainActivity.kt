package com.example.newgittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var fl:FrameLayout? = null
    var little:View?=null
    var big:View?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun initView(){
         fl=findViewById<FrameLayout>(R.id.fl)
         little=findViewById<View>(R.id.tv_little)
         big=findViewById<View>(R.id.tv_big)
         little!!.setOnClickListener(this)
         big!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_little->{
                checkMainTab(0)
            }
            R.id.tv_big->{
                checkMainTab(1)
            }
        }
    }

    fun checkMainTab(index:Int){
        when(index){
            0->{
              //  showFragment()
            }
            1->{
                //showFragment()
            }
        }
    }

    fun showFragment(fragment:Fragment){
        if(fragment!=null){

        }
    }

}