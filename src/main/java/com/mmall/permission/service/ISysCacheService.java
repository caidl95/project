package com.mmall.permission.service;

import com.mmall.permission.beans.CacheKeyConstants;

public interface ISysCacheService {

    void saveCache(String toSavedValue, int timeoutSeconds, CacheKeyConstants prefix);

    void saveCache(String toSavedValue, int timeoutSeconds, CacheKeyConstants prefix, String... keys);

    String getFromCache(CacheKeyConstants prefix, String... keys);
}
