package com.jzvd.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.bumptech.glide.Glide;

import com.echatsoft.jzvd.JZVideoPlayer;
import com.echatsoft.jzvd.JZVideoPlayerStandard;
import com.jzvd.demo.CustomView.JZVideoPlayerStandardAutoCompleteAfterFullscreen;
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
        jzVideoPlayerStandardWithShareButton.setUp(VideoConstant.videoUrlList[3], JZVideoPlayer.SCREEN_WINDOW_NORMAL
                , "饺子想呼吸");
        Glide.with(this)
                .load(VideoConstant.videoThumbList[3])
                .into(jzVideoPlayerStandardWithShareButton.thumbImageView);


        jzVideoPlayerStandardShowTitleAfterFullscreen = findViewById(R.id.custom_videoplayer_standard_show_title_after_fullscreen);
        jzVideoPlayerStandardShowTitleAfterFullscreen.setUp(VideoConstant.videoUrlList[4], JZVideoPlayer.SCREEN_WINDOW_NORMAL
                , "饺子想摇头");
        Glide.with(this)
                .load(VideoConstant.videoThumbList[4])
                .into(jzVideoPlayerStandardShowTitleAfterFullscreen.thumbImageView);

        jzVideoPlayerStandardShowTextureViewAfterAutoComplete = findViewById(R.id.custom_videoplayer_standard_show_textureview_aoto_complete);
        jzVideoPlayerStandardShowTextureViewAfterAutoComplete.setUp(VideoConstant.videoUrlList[5], JZVideoPlayer.SCREEN_WINDOW_NORMAL
                , "饺子想旅行");
        Glide.with(this)
                .load(VideoConstant.videoThumbList[5])
                .into(jzVideoPlayerStandardShowTextureViewAfterAutoComplete.thumbImageView);

        jzVideoPlayerStandardAutoCompleteAfterFullscreen = findViewById(R.id.custom_videoplayer_standard_aoto_complete);
        jzVideoPlayerStandardAutoCompleteAfterFullscreen.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_WINDOW_NORMAL
                , "饺子没来");
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandardAutoCompleteAfterFullscreen.thumbImageView);

        jzVideoPlayerStandard_1_1 = findViewById(R.id.jz_videoplayer_1_1);
        jzVideoPlayerStandard_1_1.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_WINDOW_NORMAL
                , "饺子有事吗");
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandard_1_1.thumbImageView);
        jzVideoPlayerStandard_1_1.widthRatio = 1;
        jzVideoPlayerStandard_1_1.heightRatio = 1;

        jzVideoPlayerStandard_16_9 = findViewById(R.id.jz_videoplayer_16_9);
        jzVideoPlayerStandard_16_9.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_WINDOW_NORMAL
                , "饺子来不了");
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandard_16_9.thumbImageView);
        jzVideoPlayerStandard_16_9.widthRatio = 16;
        jzVideoPlayerStandard_16_9.heightRatio = 9;

        jzVideoPlayerStandardVolumeAfterFullscreen = findViewById(R.id.jz_videoplayer_volume);
        jzVideoPlayerStandardVolumeAfterFullscreen.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_WINDOW_NORMAL
                , "饺子摇摆");
        Glide.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jzVideoPlayerStandardVolumeAfterFullscreen.thumbImageView);

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
