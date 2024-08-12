package com.design.cache.service.exception

class StorageFullException(message: String = "No storage space left to cache data.") : Exception(message)