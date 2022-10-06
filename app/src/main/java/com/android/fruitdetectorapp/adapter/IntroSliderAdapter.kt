package com.android.fruitdetectorapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter



//adapter for slider intro activity
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