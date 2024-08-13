package com.design.cache.service.constant

enum class PolicyConstant(val policy: String) {
    LRU("lru"),
    FIFO("queue"),
    LIFO("stack"),
    MRU("mru")
}