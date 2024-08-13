package com.design.cache.service.constant

enum class StorageConstant(val store: String) {
    HASHMAP("hashmap"),
    H2DB("h2db"),
    POSTGRES("postgres")
}