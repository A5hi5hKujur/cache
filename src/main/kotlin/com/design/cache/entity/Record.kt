package com.design.cache.entity

import java.time.LocalDateTime

data class Record(
    val key: String,
    val value: String,
    val ttl: Int,
    val insertedAt: LocalDateTime,
    val usage: Int
)
