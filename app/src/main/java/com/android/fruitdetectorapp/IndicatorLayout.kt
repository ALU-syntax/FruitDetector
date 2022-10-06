package com.android.fruitdetectorapp

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout


/**
 * Created by Ardian Iqbal Yusmartito on 12/09/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
class IndicatorLayout : LinearLayout{

    //reference for indicator position
    private var indicatorCount : Int = 0
    private var selectedPosition : Int = 0

    //constructor 1
    constructor(context: Context): super(context)

    //constructor 2
    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {
        initIndicators(context, attrs, 0)
    }

    //constructor 3
    constructor(
        context: Context, attrs: AttributeSet, defStyleAttr: Int
    ): super(context, attrs, defStyleAttr) {
        initIndicators(context, attrs, defStyleAttr)
    }

    //initialize all indicator
    private fun initIndicators(context: Context, attrs: AttributeSet, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.IndicatorLayout, defStyleAttr, 0)
        try {
            indicatorCount = typedArray.getInt(R.styleable.IndicatorLayout_indicatorCount, 0)
        } finally {
            typedArray.recycle()
        }
        updateIndicators()
    }

    //set position view group / fragment
    private fun px(dpValue: Float): Int {
        return (dpValue * context.resources.displayMetrics.density).toInt()
    }

    //update indicator position
    private fun updateIndicators() {
        removeAllViews()
        for (i in 0 until indicatorCount) {
            val indicator = View(context)
            // setting indicator layout margin
            val layoutParams = LinearLayout.LayoutParams(px(10f), px(10f))
            layoutParams.setMargins(px(3f), px(3f), px(3f), px(3f))
            indicator.layoutParams = layoutParams
            indicator.setBackgroundResource(R.drawable.indicator_unselected)
            // add the view to indicator layout
            addView(indicator)
        }
    }

    //set indicator position
    fun setIndicatorCount(count: Int) {
        indicatorCount = count
        updateIndicators()
    }

    //get current indicator position
    fun selectCurrentPosition(position: Int) {
        if (position >= 0 && position <= indicatorCount) {
            selectedPosition = position
            for (index in 0 until indicatorCount) {
                val indicator = getChildAt(index)
                if (index == selectedPosition) {
                    indicator.setBackgroundResource(R.drawable.indicator_selected)
                } else {
                    indicator.setBackgroundResource(R.drawable.indicator_unselected)
                }
            }
        }
    }

}