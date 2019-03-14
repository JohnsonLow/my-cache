package com.example.cache

import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*


interface SysConfigRepository : JpaRepository<SysConfig, Long> {
    fun findByKey(key: String): SysConfig?
}

@Service
@CacheConfig(cacheNames = ["SYS_CONFIG"])
class SysConfigService(val configRepository: SysConfigRepository) {
    val log = logger<SysConfigService>()
    @Cacheable("SYS_CONFIG_DETAIL", key = "#name + '_' + #i")
    fun findByName(name: String, i: Int): SysConfig? {
        log.info("load from db {} {}", name, i)
        return configRepository.findByKey(name)
    }

    @Cacheable("SYS_CONFIG_ALL")
    fun all(): List<SysConfig> {
        log.info("load from db")
        return configRepository.findAll()
    }
}

@RestController
@RequestMapping("config")
class SysConfigController(val sysConfigService: SysConfigService) {

    @GetMapping("/{name}")
    fun config(@PathVariable("name") name: String,
               @RequestParam(value = "i", required = false, defaultValue = "0")i: Int) = sysConfigService.findByName(name, i)

    @GetMapping("")
    fun config() = sysConfigService.all()
}