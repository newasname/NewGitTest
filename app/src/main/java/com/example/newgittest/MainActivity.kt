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
    private var mLittleFragment: littleFragment? = null
    private var mLittleTransaction: FragmentTransaction? = null

    private var mBigFragment: BigFragment? = null
    private var mBigTransaction: FragmentTransaction? = null

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
        initFragment()
        //切换默认的选项卡
        checkMainTab(0)
    }

    fun initFragment(){

        if (mLittleFragment == null) {
            mLittleFragment = littleFragment()
            mLittleTransaction = supportFragmentManager.beginTransaction()
            mLittleTransaction?.add(R.id.fl, mLittleFragment!!)
            mLittleTransaction?.commit()
        }

        if (mBigFragment == null) {
            mBigFragment = BigFragment()
            mBigTransaction = supportFragmentManager.beginTransaction()
            mBigTransaction?.add(R.id.fl, mBigFragment!!)
            mBigTransaction?.commit()
        }
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
               showFragment(mLittleFragment!!)
            }
            1->{
                showFragment(mBigFragment!!)
            }
        }
    }


    fun showFragment(fragment:Fragment){
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            hideAllFragment(transaction)
            transaction.show(fragment)
            transaction.commitAllowingStateLoss()
        }
    }

    /**
     * 隐藏所有的Fragment
     */
    private fun hideAllFragment(transaction: FragmentTransaction) {
        if (mLittleFragment != null) {
            transaction.hide(mLittleFragment!!)
        }
        if (mBigFragment != null) {
            transaction.hide(mBigFragment!!)
        }
    }

    /**
     * 防止重叠
     */
    override fun onAttachFragment(fragment: Fragment) {
        if (mLittleFragment == null && fragment is littleFragment) {
            mLittleFragment = fragment as littleFragment
        }
        if (mBigFragment == null && fragment is BigFragment) {
            mBigFragment = fragment as BigFragment
        }
    }
}