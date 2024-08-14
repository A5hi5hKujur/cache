package com.design.cache.service.storage

import com.design.cache.entity.Key
import com.design.cache.entity.Value
import com.design.cache.service.exception.KeyNotFoundException
import com.design.cache.service.exception.StorageFullException
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

val CAPACITY = 10

@Repository
class InMemoryHashMapStorage <Key : Any, Value> : StorageInterface<Key, Value> {
    private var _storage: MutableMap<Key, Value> = HashMap(CAPACITY)

    override fun get(key: Key): Value? {
        if (!_storage.containsKey(key)) throw KeyNotFoundException(key)
        return _storage[key]
    }

    override fun getAllKeys(): List<Key> {
        val keyList: MutableList<Key> = mutableListOf()
        _storage.forEach { entry ->
            print("${entry.key} : ${entry.value}")
            keyList.add(entry.key)
        }
        return keyList
    }

    override fun remove(key: Key): Key {
        if (!_storage.containsKey(key)) throw KeyNotFoundException(key)
        _storage.remove(key)
        return key
    }

    override fun add(key: Key, value: Value) {
        if (isFull()) throw StorageFullException("Cannot store Key ${key}")
        _storage[key] = value
    }

    override fun getRemainingSpace(): Int {
        return CAPACITY - _storage.size
    }

    override fun isEmpty(): Boolean {
        return _storage.isEmpty()
    }

    override fun isFull(): Boolean {
        return _storage.size >= CAPACITY
    }
}