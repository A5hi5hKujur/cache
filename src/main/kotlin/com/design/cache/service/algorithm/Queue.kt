package com.design.cache.service.algorithm

import com.design.cache.entity.DLLNode
import org.springframework.stereotype.Repository

@Repository
class Queue<T> (
    val dll: DoublyLinkedList<T>
) {
    fun push(data: T) {
        dll.addElementAtLast(data)
    }

    fun pop(): DLLNode<T>? {
        val first = dll.getFirstNode()
        if (first != null)
            dll.detachNode(first)
        return first
    }

    fun front(): DLLNode<T>? {
        return dll.getFirstNode()
    }

    fun size(): Int {
        return dll.length()
    }

    fun back(): DLLNode<T>? {
        return dll.getLastNode()
    }

    fun isEmpty(): Boolean {
        return dll.isItemPresent()
    }

}