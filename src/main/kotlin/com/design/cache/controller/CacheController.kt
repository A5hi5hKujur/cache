package com.design.cache.controller

import com.design.cache.service.CacheService
import com.design.cache.entity.Record
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class CacheController (
    private val cacheService: CacheService
) {

    @GetMapping("/")
    fun getAll(): List<Record> = cacheService.getAll()

    @GetMapping("/test")
    fun test(): String = "cacheService.getAll()"

}