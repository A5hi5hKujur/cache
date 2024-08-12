package com.design.cache.service.exception

class StorageEmptyException(message: String = "Cannot access data since storage is empty.") : Exception(message)