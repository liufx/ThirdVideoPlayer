package com.smile.video.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import cn.jzvd.JZDataSource
import cn.jzvd.JZUtils
import cn.jzvd.JzvdStd

class JzvdStdTinyWindow : JzvdStd {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}

    override fun setUp(jzDataSource: JZDataSource?, screen: Int, mediaInterface: Class<*>?) {
        super.setUp(jzDataSource, screen, mediaInterface)
    }

    fun gotoTinyScreen() {
        Log.i(TAG, "startWindowTiny " + " [" + this.hashCode() + "] ")
        if (state == STATE_NORMAL || state == STATE_ERROR || state == STATE_AUTO_COMPLETE) return
        val vg = parent as ViewGroup
        jzvdContext = vg.context
        blockLayoutParams = layoutParams
        blockIndex = vg.indexOfChild(this)
        blockWidth = width
        blockHeight = height
        vg.removeView(this)
        cloneAJzvd(vg)
        CONTAINER_LIST.add(vg)
        val vgg = JZUtils.scanForActivity(context).window.decorView as ViewGroup //和他也没有关系
        val lp = LayoutParams(400, 400)
        lp.gravity = Gravity.RIGHT or Gravity.BOTTOM
        //添加滑动事件等
        vgg.addView(this, lp)
        setScreenTiny()
    }
}
