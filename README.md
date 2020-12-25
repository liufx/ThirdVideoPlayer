# ThirdVideoPlayer
第三方视频播放器使用(根据jiaozivideoplayer学习的)
主要学习来源为
[中文文档](http://jzvd.org)

[本文的下载Demo](https://github.com/liufx/ThirdVideoPlayer/tree/main/apk/app-release.apk)

## 快速开始

1.添加类库
```gradle
implementation 'cn.jzvd:jiaozivideoplayer:7.5.0'
```

2.添加布局
```xml
<cn.jzvd.JzvdStd
    android:id="@+id/jz_video"
    android:layout_width="match_parent"
    android:layout_height="200dp" />
```

3.设置视频地址、标题、缩略图地址
```java
 //设置地址和标题
  jz_video.setUp("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4", "驯龙高手")
        //设置缩略图
 Glide.with(this)
            .load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
            .into(jz_video.posterImageView);   //推荐使用Glide
```

4.在`Activity`中
```java
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
```

5.在`AndroidManifest.xml`中
```
<activity
    android:name=".MainActivity"
    android:configChanges="orientation|screenSize|keyboardHidden"
    android:screenOrientation="portrait" /> <!-- or android:screenOrientation="landscape"-->
```

6.在`proguard-rules.pro`中按需添加
```
-keep public class cn.jzvd.JZMediaSystem {*; }
-keep public class cn.jzvd.demo.CustomMedia.CustomMedia {*; }
-keep public class cn.jzvd.demo.CustomMedia.JZMediaIjk {*; }
-keep public class cn.jzvd.demo.CustomMedia.JZMediaSystemAssertFolder {*; }

-keep class tv.danmaku.ijk.media.player.** {*; }
-dontwarn tv.danmaku.ijk.media.player.*
-keep interface tv.danmaku.ijk.media.player.** { *; }
```

## 效果
![主页](https://github.com/liufx/ThirdVideoPlayer/raw/master/image/1.png)
![预加载](https://github.com/liufx/ThirdVideoPlayer/raw/master/image/2.png)
![小窗悬浮](https://github.com/liufx/ThirdVideoPlayer/raw/master/image/3.png)
