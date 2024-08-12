package com.design.cache.entity

data class DLLNode<T> (
    var data: T?,
    var next: DLLNode<T>? = null,
    var prev: DLLNode<T>? = null
)