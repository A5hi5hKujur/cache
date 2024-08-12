package com.design.cache.service.exception

class KeyNotFoundException(key: Any) : Exception("Key : $key not found inside the storage.")