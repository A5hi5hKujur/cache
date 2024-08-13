package com.design.cache.service.storage

interface StorageInterface<Key, Value> {
    fun add(key:Key, value:Value)

    fun remove(key:Key): Key

    fun get(key:Key): Value?

    fun getAllKeys(): List<Key>

    fun isEmpty(): Boolean

    fun isFull(): Boolean

    fun getRemainingSpace(): Int
}