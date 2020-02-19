package com.jzvd.demo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.bumptech.glide.Glide;

import com.echat.jzvd.JZVideoPlayer;
import com.echat.jzvd.JZVideoPlayerStandard;
import com.jzvd.demo.CustomView.JZVideoPlayerStandardAutoCompleteAfterFullscreen;
import com.jzvd.demo.CustomView.JZVideoPlayerStandardMp3;
import com.jzvd.demo.CustomView.JZVideoPlayerStandardShowShareButtonAfterFullscreen;
import com.jzvd.demo.CustomView.JZVideoPlayerStandardShowTextureViewAfterAutoComplete;
import com.jzvd.demo.CustomView.JZVideoPlayerStandardShowTitleAfterFullscreen;
import com.jzvd.demo.CustomView.JZVideoPlayerStandardVolumeAfterFullscreen;


/**
 * Created by Nathen on 16/7/31.
 */
public class ActivityApiUISmallChange extends AppCompatActivity {
    JZVideoPlayerStandardShowShareButtonAfterFullscreen jzVideoPlayerStandardWithShareButton;
    JZVideoPlayerStandardShowTitleAfterFullscreen jzVideoPlayerStandardShowTitleAfterFullscreen;
    JZVideoPlayerStandardShowTextureViewAfterAutoComplete jzVideoPlayerStandardShowTextureViewAfterAutoComplete;
    JZVideoPlayerStandardAutoCompleteAfterFullscreen jzVideoPlayerStandardAutoCompleteAfterFullscreen;
    JZVideoPlayerStandardVolumeAfterFullscreen jzVideoPlayerStandardVolumeAfterFullscreen;
    JZVideoPlayerStandardMp3 jzVideoPlayerStandardMp3;

    JZVideoPlayerStandard jzVideoPlayerStandard_1_1, jzVideoPlayerStandard_16_9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("SmallChangeUI");
        setContentView(R.layout.activity_ui_small_change);

        jzVideoPlayerStandardWithShareButton = findViewById(R.id.custom_videoplayer_standard_with_share_button);
        jzVideoPlayerStandardWithShareButton.setUp(VideoConstant.videoUrlList[3], "饺子想呼吸", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbList[3])
                .into(jzVideoPlayerStandardWithShareButton.thumbImageView);


        jzVideoPlayerStandardShowTitleAfterFullscreen = findViewById(R.id.custom_videoplayer_standard_show_title_after_fullscreen);
        jzVideoPlayerStandardShowTitleAfterFullscreen.setUp(VideoConstant.videoUrlList[4], "饺子想摇头", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbList[4])
                .into(jzVideoPlayerStandardShowTitleAfterFullscreen.thumbImageView);

        jzVideoPlayerStandardShowTextureViewAfterAutoComplete = findViewById(R.id.custom_videoplayer_standard_show_textureview_aoto_complete);
        jzVideoPlayerStandardShowTextureViewAfterAutoComplete.setUp(VideoConstant.videoUrlList[5], "饺子想旅行", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbList[5])
                .into(jzVideoPlayerStandardShowTextureViewAfterAutoComplete.thumbImageView);

        jzVideoPlayerStandardAutoCompleteAfterFullscreen = findViewById(R.id.custom_videoplayer_standard_aoto_complete);
        jzVideoPlayerStandardAutoCompleteAfterFullscreen.setUp(VideoConstant.videoUrls[0][1], "饺子没来", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandardAutoCompleteAfterFullscreen.thumbImageView);

        jzVideoPlayerStandard_1_1 = findViewById(R.id.jz_videoplayer_1_1);
        jzVideoPlayerStandard_1_1.setUp(VideoConstant.videoUrls[0][1], "饺子有事吗", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandard_1_1.thumbImageView);
        jzVideoPlayerStandard_1_1.widthRatio = 1;
        jzVideoPlayerStandard_1_1.heightRatio = 1;

        jzVideoPlayerStandard_16_9 = findViewById(R.id.jz_videoplayer_16_9);
        jzVideoPlayerStandard_16_9.setUp(VideoConstant.videoUrls[0][1], "饺子来不了", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandard_16_9.thumbImageView);
        jzVideoPlayerStandard_16_9.widthRatio = 16;
        jzVideoPlayerStandard_16_9.heightRatio = 9;

        jzVideoPlayerStandardVolumeAfterFullscreen = findViewById(R.id.jz_videoplayer_volume);
        jzVideoPlayerStandardVolumeAfterFullscreen.setUp(VideoConstant.videoUrls[0][1], "饺子摇摆", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandardVolumeAfterFullscreen.thumbImageView);

        jzVideoPlayerStandardMp3 = findViewById(R.id.jz_videoplayer_mp3);
        jzVideoPlayerStandardMp3.setUp("https://in-20170815011809382-q34ludd68h.oss-cn-shanghai.aliyuncs.com/video/401edae1-16431aa8156-0007-1823-c86-de200.mp3?Expires=1532102862&OSSAccessKeyId=LTAIPZHZDaUNpnca&Signature=apruidffjNeN0O584VJiz8q1mJ4%3D", "饺子摇摆", JZVideoPlayer.SCREEN_WINDOW_NORMAL
                );
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandardMp3.thumbImageView);


    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
