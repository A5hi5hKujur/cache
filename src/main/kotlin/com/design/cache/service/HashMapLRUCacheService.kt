package com.design.cache.service

import com.design.cache.entity.Key
import com.design.cache.service.cache.HashMapLRUCache
import com.design.cache.service.policy.LRUEvictionPolicy
import com.design.cache.service.storage.InMemoryHashMapStorage
import org.springframework.stereotype.Service


@Service
class HashMapLRUCacheService (
    private val cache: HashMapLRUCache<String, String>
) {

//    private val dataStore: InMemoryHashMapStorage<String, String> = InMemoryHashMapStorage(10)
//    private val evictionPolicy: LRUEvictionPolicy<String> = LRUEvictionPolicy()
//    private val cache = HashMapLRUCache(evictionPolicy, dataStore)

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