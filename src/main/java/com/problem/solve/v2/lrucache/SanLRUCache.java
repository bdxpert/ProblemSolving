package com.problem.solve.v2.lrucache;

import java.util.HashMap;
import java.util.Map;

public class SanLRUCache {
    static class Node{
        int key, val;
        Node prev, next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    private static int capacity, size;
    private static Node head, tail;
    private static Map<Integer, Node> map;
    public SanLRUCache(int capacity)
    {
        SanLRUCache.capacity = capacity;
        SanLRUCache.size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    static void add(Node node)
    {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    static void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    static void rearrange(Node node)
    {
        remove(node);
        add(node);
    }
    static Node getTail()
    {
        Node node = tail.prev;
        remove(node);
        return node;
    }
    static int get(int key)
    {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        rearrange(node);

        return node.val;
    }
    static void put(int key, int val) {
        Node node = map.get(key);
        if(node == null) {
            Node newNode = new Node(key, val);
            map.put(key, newNode);
            add(newNode);
            size++;
            if(size > capacity) {
                // cache is full
                Node tailNode = getTail();

                map.remove(tailNode.key);
                size--;
            }
        } else {
            node.val = val;
            rearrange(node);
        }
    }
    public static void main(String args[]){
        // Initializing the cache, with capacity 3.
        new SanLRUCache(3);

        // Performing operations.
        put(1, 1);
        put(2, 2);
        put(3, 3);

        System.out.println(get(2));
        System.out.println(get(1));

        put(4,4);

        System.out.println(get(1));
        System.out.println(get(2));

        put(5,5);

        System.out.println(get(3));

    }
}
/*
2
1
1
2
-1
 */
