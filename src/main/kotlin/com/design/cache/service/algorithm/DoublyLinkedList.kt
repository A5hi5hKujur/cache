package com.design.cache.service.algorithm

import com.design.cache.entity.DLLNode


class DoublyLinkedList<T> {
    private var dummyHead: DLLNode<T> = DLLNode(null)
    private var dummyTail: DLLNode<T> = DLLNode(null)

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
    }

    private fun isItemPresent(): Boolean {
        return dummyHead.next !== dummyTail
    }

    fun detachNode(node: DLLNode<T>) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
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

}