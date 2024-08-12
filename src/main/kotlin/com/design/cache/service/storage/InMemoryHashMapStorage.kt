package com.design.cache.service.storage

import com.design.cache.entity.Key
import com.design.cache.entity.Value
import com.design.cache.service.exception.KeyNotFoundException
import com.design.cache.service.exception.StorageFullException

class InMemoryHashMapStorage <K : Any, V>(private val capacity: Int) : StorageInterface<Key<K>, Value<V>> {
    private var _storage: MutableMap<Key<K>, Value<V>> = HashMap(capacity)

    override fun get(key: Key<K>): Value<V>? {
        if (!_storage.containsKey(key)) throw KeyNotFoundException(key.value)
        return _storage[key]
    }

    override fun remove(key: Key<K>): Key<K> {
        if (!_storage.containsKey(key)) throw KeyNotFoundException(key.value)
        _storage.remove(key)
        return key
    }

    override fun add(key: Key<K>, value: Value<V>) {
        if (isFull()) throw StorageFullException("Cannot store Key ${key.value}")
        _storage[key] = value
    }

    override fun getRemainingSpace(): Int {
        return capacity - _storage.size
    }

    override fun isEmpty(): Boolean {
        return _storage.isEmpty()
    }

    override fun isFull(): Boolean {
        return _storage.size >= capacity
    }
}