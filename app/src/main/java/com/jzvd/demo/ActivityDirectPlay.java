package com.jzvd.demo;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.echat.jzvd.JZDataSource;
import com.echat.jzvd.JZVideoPlayer;
import com.echat.jzvd.JZVideoPlayerStandard;
import com.jzvd.demo.CustomMediaPlayer.JZExoPlayer;
import com.jzvd.demo.CustomMediaPlayer.JZMediaIjkplayer;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;

/**
 * Created by Nathen on 16/7/31.
 */
public class ActivityDirectPlay extends AppCompatActivity implements View.OnClickListener {
    Button mStartFullscreen, mStartTiny;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("DirectPlay");
        setContentView(R.layout.activity_directly_play);

        mStartFullscreen = findViewById(R.id.fullscreen);
        mStartTiny = findViewById(R.id.tiny_window);

        mStartFullscreen.setOnClickListener(this);
        mStartTiny.setOnClickListener(this);
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .rationale(new PermissionUtils.OnRationaleListener() {
                    @Override
                    public void rationale(ShouldRequest shouldRequest) {

                    }
                }).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied() {

            }
        }).request();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fullscreen:
                JZVideoPlayer.setMediaInterface(new JZMediaIjkplayer());
                Uri uri = Uri.parse("content://media/external/video/media/35556");
                ParcelFileDescriptor rPd = null;
                try {
                    rPd = getContentResolver().openFileDescriptor(uri, "r");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                FileDescriptor fileDescriptor = rPd.getFileDescriptor();
//                JZDataSource jzDataSource = new JZDataSource("content://media/external/video/media/35556", "title");
                JZDataSource jzDataSource = new JZDataSource(fileDescriptor);
                jzDataSource.title = "title";

                JZVideoPlayerStandard.startFullscreen(
                        this,
                        CustomVideoPlayerStandard.class,
                        jzDataSource);
                break;
            case R.id.tiny_window:
                JZVideoPlayer.setMediaInterface(new JZExoPlayer());
                JZDataSource jzDataSourceex = new JZDataSource("content://media/external/video/media/35556", "title");
                JZVideoPlayerStandard.startFullscreen(
                        this,
                        CustomVideoPlayerStandard.class,
                        jzDataSourceex);
                break;
        }
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
