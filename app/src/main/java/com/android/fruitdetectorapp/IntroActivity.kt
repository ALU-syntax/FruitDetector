package com.android.fruitdetectorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.android.fruitdetectorapp.adapter.IntroSliderAdapter
import com.android.fruitdetectorapp.databinding.ActivityIntroBinding
import com.android.fruitdetectorapp.fragment.IntroDuaFragment
import com.android.fruitdetectorapp.fragment.IntroSatuFragment
import com.android.fruitdetectorapp.fragment.IntroTigaFragment

class IntroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityIntroBinding

    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = IntroSliderAdapter(this)
        binding.vpIntro.adapter = adapter

        fragmentList.addAll(listOf(
            IntroSatuFragment(), IntroDuaFragment(), IntroTigaFragment()
        ))
        adapter.setFragmentList(fragmentList)

        binding.indicatorLayout.setIndicatorCount(adapter.itemCount)
        binding.indicatorLayout.selectCurrentPosition(0)

        binding.btnSkip.setOnClickListener{
            Intent(this, CoreActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnImgBack.setOnClickListener{
            finish()
        }
        registerListener()
    }

    private fun registerListener() {
        binding.vpIntro.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.indicatorLayout.selectCurrentPosition(position)

                if (position < fragmentList.lastIndex){
                    binding.fabNext.visibility = View.INVISIBLE
                }else{
                    binding.fabNext.visibility = View.VISIBLE
                    binding.fabNext.setOnClickListener{
                        Intent(this@IntroActivity, CoreActivity::class.java).apply{
                            startActivity(this)
                            finish()
                        }
                    }
                }
            }
        })
    }

}