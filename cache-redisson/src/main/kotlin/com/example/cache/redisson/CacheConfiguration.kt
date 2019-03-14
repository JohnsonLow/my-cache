package com.example.cache

import org.redisson.api.RedissonClient
import org.redisson.codec.JsonJacksonCodec
import org.redisson.spring.cache.CacheConfig
import org.redisson.spring.cache.RedissonSpringCacheManager
import org.redisson.spring.starter.RedissonAutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@AutoConfigureAfter(RedissonAutoConfiguration::class)
class CacheConfiguration {
    @Bean
    fun cacheManager(client: RedissonClient): RedissonSpringCacheManager {
        val config = java.util.HashMap<String, CacheConfig>()
        config["METHOD_CONFIG_DETAIL"] = CacheConfig((30 * 60 * 1000).toLong(), (15 * 60 * 1000).toLong())
        return RedissonSpringCacheManager(client, config, JsonJacksonCodec())
    }
}