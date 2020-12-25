package com.smile.video

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.jzvd.Jzvd
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 视频播放
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    fun initView() {
        //预加载
        preloading.setOnClickListener(this)
        //方向设置
        orientation.setOnClickListener(this)
        //小窗播放
        tiny_window.setOnClickListener(this)
    }

    /**
     * 初始化数据
     */
    fun initData() {

        //设置地址和标题
        jz_video.setUp("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4", "驯龙高手")
        //设置缩略图
        Glide.with(this)
            .load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
            .into(jz_video.posterImageView);   //推荐使用Glide
    }

    /**
     * 点击返回按钮
     */
    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos();

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.preloading -> activityTiaozhuan(this, PreloadingActivity().javaClass)
            R.id.orientation -> activityTiaozhuan(this, OrientationActivity().javaClass)
            R.id.tiny_window -> activityTiaozhuan(this, TinyWindowActivity().javaClass)

        }
    }

    fun activityTiaozhuan(ctx: Context, clazz: Class<Any>) {
        var intent = Intent()
        intent.setClass(ctx, clazz)
        startActivity(intent)
    }
}