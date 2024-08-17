package com.design.cache.service.exception

open class KeyNotFoundException(key: Any) : Exception("Key : $key not found inside the storage.")