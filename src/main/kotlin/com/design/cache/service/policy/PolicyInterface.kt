package com.design.cache.service.policy

interface PolicyInterface<Key> {
    fun keyAccessed(key: Key)

    fun evictKey(): Key?
}