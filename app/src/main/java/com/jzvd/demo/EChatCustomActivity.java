package com.jzvd.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.echat.jzvd.JZVideoPlayer;
import com.echat.jzvd.JZVideoPlayerStandard;

public class EChatCustomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_echat_custom);
        JZVideoPlayerStandard.startFullscreen(this, CustomVideoPlayerStandard.class, VideoConstant.videoUrlList[6], "饺子辛苦了");
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        JZVideoPlayer.backPress();
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
