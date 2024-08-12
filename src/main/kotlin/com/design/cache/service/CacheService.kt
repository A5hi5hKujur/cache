package com.design.cache.service

import com.design.cache.entity.Record
import org.springframework.stereotype.Service
import java.time.LocalDateTime

var cachedRecrods: MutableList<Record> = mutableListOf()

@Service
class CacheService {

    init {
        cachedRecrods.add(
            Record("key1","val1", 200, LocalDateTime.now(), 1)
        )
        cachedRecrods.add(
            Record("key2","val2", 300, LocalDateTime.now(), 1)
        )
    }
    fun getAll(): MutableList<Record> {
        return cachedRecrods
    }
}