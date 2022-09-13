package com.android.fruitdetectorapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


/**
 * Created by Ardian Iqbal Yusmartito on 12/09/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
class IntroSliderAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa){

    private val fragmentList = ArrayList<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

    fun setFragmentList(list: List<Fragment>){
        fragmentList.clear()
        fragmentList.addAll(list)
        notifyDataSetChanged()
    }

}