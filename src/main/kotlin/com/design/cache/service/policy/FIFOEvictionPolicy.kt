package com.design.cache.service.policy

import com.design.cache.entity.DLLNode
import com.design.cache.service.algorithm.Queue

class FIFOEvictionPolicy<Key> (
    private val queue: Queue<Key>
): PolicyInterface<Key> {
    override fun keyAccessed(key: Key) {
        return
    }

    override fun evictKey(): Key? {
        val first = queue.pop()
        return first?.data
    }

    override fun getLastAccessedKey(): Key? {
        val last = queue.back()
        return last?.data
    }

    override fun getLRUKey(): Key? {
        return null
    }
}