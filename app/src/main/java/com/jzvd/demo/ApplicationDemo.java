package com.jzvd.demo;

import android.app.Application;
import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;

/**
 * Created by Nathen
 * On 2015/12/01 11:29
 */
public class ApplicationDemo extends Application {

    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
//        LeakCanary.install(this);

    }

    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        ApplicationDemo app = (ApplicationDemo) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }
}
