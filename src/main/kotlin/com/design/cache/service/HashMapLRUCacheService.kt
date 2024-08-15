package com.design.cache.service

import com.design.cache.service.cache.Cache
import org.springframework.stereotype.Service


@Service
class HashMapLRUCacheService (
    private val cache: Cache<String, String>
) {

    fun put(key: String, value: String) {
        cache.put(key, value)
    }

    fun get(key: String): String? {
        return cache.get(key)
    }

    fun getAllKeys(): List<String> {
        return cache.getAllKeys()
    }

    fun getLastAccessedKey(): String? {
        return cache.getLastAccessed()
    }

     fun getLRUKey(): String? {
         return cache.getLRUKey()
     }
}