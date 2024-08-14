package com.design.cache.service.cache

import com.design.cache.service.exception.KeyNotFoundException
import com.design.cache.service.exception.StorageFullException
import com.design.cache.service.policy.LRUEvictionPolicy
import com.design.cache.service.storage.InMemoryHashMapStorage
import org.springframework.stereotype.Repository

@Repository
class HashMapLRUCache<Key : Any, Value>(
    private val evictionPolicy: LRUEvictionPolicy<Key>,
    private val storage: InMemoryHashMapStorage<Key, Value>
) {
    fun put(key: Key, value: Value) {
        try {
            storage.add(key, value)
            evictionPolicy.keyAccessed(key)
        } catch (exception: StorageFullException) {
            println("Got storage full. Will try to evict.")
            val keyToRemove: Key = evictionPolicy.evictKey()
                ?: throw RuntimeException("Unexpected State. Storage full and no key to evict.")
            storage.remove(keyToRemove)
            println("Creating space by evicting item...$keyToRemove")
            put(key, value)
        }
    }

    fun get(key: Key): Value? {
        try {
            val value = storage.get(key)
            evictionPolicy.keyAccessed(key)
            return value
        } catch (notFoundException: KeyNotFoundException) {
            println("Tried to access non-existing key.")
            return null
        }
    }

    fun getAllKeys(): List<Key> {
        return storage.getAllKeys()
    }

    fun getLastAccessed(): Key? {
        return evictionPolicy.getLastAccessedKey()
    }

    fun getLRUKey(): Key? {
        return evictionPolicy.getLRUKey()
    }
}