package com.design.cache.service.policy

import com.design.cache.entity.DLLNode
import com.design.cache.service.algorithm.DoublyLinkedList
import org.springframework.stereotype.Service

@Service
class LRUEvictionPolicy<Key> (
    private val dll: DoublyLinkedList<Key>
): PolicyInterface<Key> {
//    private val dll: DoublyLinkedList<Key> = DoublyLinkedList()
    private val mapper: MutableMap<Key, DLLNode<Key>> = HashMap()

    override fun keyAccessed(key: Key) {
       if (mapper.containsKey(key)) {
           mapper[key]?.let { dll.detachNode(it) }
           dll.addElementAtLast(key)
       } else {
           val newNode: DLLNode<Key> = dll.addElementAtLast(key)
           mapper[key] = newNode
       }
    }

    override fun evictKey(): Key? {
        val first = dll.getFirstNode() ?: return null
        dll.detachNode(first)
        return first.data
    }

    override fun getLastAccessedKey(): Key? {
        val last = dll.getLastNode() ?: return null
        return last.data
    }

    fun getLRUKey(): Key? {
        val first = dll.getFirstNode() ?: return null
        return first.data
    }
}