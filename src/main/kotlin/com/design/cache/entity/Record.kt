package com.design.cache.entity

import java.time.LocalDateTime

data class Record<K, V>(
    val key: K,
    val value: V,
    val ttl: Int,
    val insertedAt: LocalDateTime,
    val usage: Int
)
