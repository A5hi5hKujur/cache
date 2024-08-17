package com.design.cache.service.algorithm

import com.design.cache.entity.DLLNode
import org.springframework.stereotype.Repository

@Repository
class DoublyLinkedList<T> {
    private var dummyHead: DLLNode<T> = DLLNode(null)
    private var dummyTail: DLLNode<T> = DLLNode(null)
    private var size = 0

    init {
        dummyHead.next  = dummyTail
        dummyTail.prev = dummyHead
    }

    private fun addNodeAtLast(node: DLLNode<T>) {
        val tailPrev = dummyTail.prev
        tailPrev?.next = node
        node.next = dummyTail
        dummyTail.prev = node
        node.prev = tailPrev
        size += 1
    }

    fun isItemPresent(): Boolean {
        return dummyHead.next !== dummyTail
    }

    fun detachNode(node: DLLNode<T>) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        node.next = null
        node.prev = null
        size -= 1
    }

    fun addElementAtLast(data: T?): DLLNode<T> {
        val newNode: DLLNode<T> = DLLNode(data)
        if (data != null) {
            addNodeAtLast(newNode)
        }
        return newNode
    }

    fun getFirstNode(): DLLNode<T>? {
        if (!isItemPresent()) {
            return null
        }
        return dummyHead.next
    }

    fun getLastNode(): DLLNode<T>? {
        if (!isItemPresent()) {
            return null
        }
        return dummyTail.prev
    }

    fun length(): Int {
        return size
    }

}