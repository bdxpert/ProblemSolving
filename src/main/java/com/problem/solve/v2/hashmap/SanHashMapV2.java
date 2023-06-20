package com.problem.solve.v2.hashmap;

class SanHashMapV2<K, V>{
    Node<K,V>[] node = new Node[100];
    static class Node<K,V>{
        final K key;
        V val;
        Node<K,V> next;
        Node(K key, V val) {
            this.key=key;
            this.val=val;
        }
    }
    public SanHashMapV2()
    {
        node = new Node[100];
    }
    public V get(K key)
    {
        int index = getIndex(key);
        Node<K,V> node = findEle(index, key);
        return node.next == null? null: node.next.val;
    }
    void put(K key, V value) {
        int index = getIndex(key);
        Node<K,V> node = findEle(index, key);
        if(node.next == null) {
            node.next = new Node(key, value);
        } else {
            node.next.val = value;
        }
    }
    void delete(K key)
    {
        int index = getIndex(key);
        Node<K,V> node = findEle(index, key);
        if(node!=null){
            node = node.next.next;
        }
    }
    int getIndex(K key)
    {
        return key.hashCode()%100;
    }
    Node<K,V> findEle(int index, K key)
    {
        if(node[index] == null) {
            return node[index] = new Node(-1,-1);
        }
        Node<K,V> node = this.node[index];
        while(node.next!=null && node.next.key!=key) {
            node = node.next;
        }
        return node;
    }
    /*
    private void resize() {
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = new Node[newCapacity];
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = table[i];
            while (node != null) {
                Node<K, V> next = node.next;
                int index = hash(node.key);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }
     */
}
