package com.example.cache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class CacheRedissonApplication

fun main(args: Array<String>) {
    runApplication<CacheRedissonApplication>(*args)
}
