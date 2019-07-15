package com.mmall.permission;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PermissionApplication.class);
    }

    @Bean
    public ShardedJedisPool shardedJedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisShardInfo jedisShardInfo = new JedisShardInfo("192.168.1.155",6379,3000);
        List<JedisShardInfo> list = new ArrayList<>();
        list.add(jedisShardInfo);
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,list);
        return shardedJedisPool;
    }

}
