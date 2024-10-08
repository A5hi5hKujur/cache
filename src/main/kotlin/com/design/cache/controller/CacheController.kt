package com.design.cache.controller

import com.design.cache.controller.exception.KeyNotFoundHTTPException
import com.design.cache.service.HashMapLRUCacheService
import com.design.cache.entity.Record
import com.design.cache.entity.SimpleAddRequest
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/memhash")
class CacheController (
    val hashMapLRUCacheService: HashMapLRUCacheService
) {
    @GetMapping("/")
    fun getAll(): List<String> = hashMapLRUCacheService.getAllKeys()

    @GetMapping("/keys/{key}")
    fun getKey(@PathVariable key: String): String {
        val fetchedKey =  hashMapLRUCacheService.get(key)
        if (fetchedKey.isNullOrEmpty()) throw KeyNotFoundHTTPException(key)
        return fetchedKey
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/keys")
    fun addKey(@RequestBody data: SimpleAddRequest) = hashMapLRUCacheService.put(data.key, data.value)

    @GetMapping("/last")
    fun getLastAccessedKey(): String? = hashMapLRUCacheService.getLastAccessedKey()

    @GetMapping("/lru")
    fun getLRUKey(): String? = hashMapLRUCacheService.getLRUKey()

}