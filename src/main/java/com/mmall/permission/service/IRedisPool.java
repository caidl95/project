package com.mmall.permission.service;

import redis.clients.jedis.ShardedJedis;

public interface IRedisPool {

    void safeClose(ShardedJedis shardedJedis);
}
