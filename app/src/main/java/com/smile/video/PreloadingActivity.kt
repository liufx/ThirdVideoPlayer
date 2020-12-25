package com.smile.video

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.jzvd.Jzvd
import kotlinx.android.synthetic.main.activity_preloading.*


/**
 * 视频预加载
 */
class PreloadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar!!.setDisplayUseLogoEnabled(false)
        supportActionBar!!.title = getString(R.string.preloading)
        setContentView(R.layout.activity_preloading)
        jz_video.setUp(
            "http://jzvd.nathen.cn/4f965ad507ef4194a60a943a34cfe147/32af151ea132471f92c9ced2cff785ea-5287d2089db37e62345123a1be272f8b.mp4",
            "饺子存钱",
            Jzvd.SCREEN_NORMAL
        );
    }

    fun clickStartPreloading(view: View?) {
        jz_video.startPreloading()
    }

    fun clickStartVideoAfterPreloading(view: View?) {
        jz_video.startVideoAfterPreloading()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }

    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return
        }
        super.onBackPressed()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                false
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}