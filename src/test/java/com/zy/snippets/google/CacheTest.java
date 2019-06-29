package com.zy.snippets.google;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zy
 * @Date: 2018/12/31 17:13
 */
public class CacheTest {

    LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .maximumSize(1000000)
            .build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String key) {
                    return key + "-" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
                }
            });

    @Test
    public void cacheTest() throws Exception {
        Thread.sleep(10000);
        System.gc();
        System.out.println("start");
        for (int i = 0; i < 1000000; i++) {
            System.out.println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss") + " --- " + cache.get("key-" + i));
        }
        Thread.sleep(15000);
        System.gc();
        Thread.sleep(5000);
        System.gc();
        Thread.sleep(60000);
        System.gc();
        Thread.sleep(5000);
        cache.cleanUp();
        System.gc();
        Thread.sleep(Long.MAX_VALUE);
    }

}
