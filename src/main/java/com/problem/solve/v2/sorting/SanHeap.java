package com.problem.solve.v2.sorting;

import java.util.ArrayList;

public class SanHeap {
    public static void main(String args[]) {
        SanHeap sanHeap = new SanHeap();
        ArrayList<Integer> items = new ArrayList<>();
        sanHeap.insert(items, 3);
        sanHeap.insert(items, 4);
        sanHeap.insert(items, 9);
        sanHeap.insert(items, 5);
        sanHeap.insert(items, 2);

        sanHeap.printHeap(items);
        sanHeap.deleteNode(items,3);
        System.out.println("::Hello Heap::");
        sanHeap.printHeap(items);

    }
    public void printHeap(ArrayList<Integer> datas)
    {
        datas.stream().forEach(item-> {
            System.out.println(item);
        });
    }
    public void heapify(ArrayList<Integer> ht, int i) {
        int size = ht.size();
        int largest = i;
        int left = i*2 + 1;
        int right = i*2 + 2;
        if(left < size && ht.get(largest)<ht.get(left)) {
            largest = left;
        }
        if(right < size && ht.get(largest) <ht.get(right)) {
            largest = right;
        }
        if(i != largest) {
            // swap
            int temp = ht.get(i);
            ht.set(i, ht.get(largest));
            ht.set(largest, temp);
            heapify(ht, largest);
        }
    }
    public boolean deleteNode(ArrayList<Integer> ht,  int item) {
        int i;
        for (i=0; i< ht.size(); i++) {
            if(ht.get(i) == item){
                break;
            }
        }
        // swap with last node
        int temp = ht.get(i);
        ht.set(i , ht.get(ht.size()-1));
        ht.set(ht.size()-1, temp);

        ht.remove(ht.size()-1);
        // heapify
        for(int j = ht.size()/2-1; j>=0; j--) {
            heapify(ht, j);
        }
        return Boolean.TRUE;
    }
    public void insert(ArrayList<Integer> ht, int item)
    {
        if(ht.size() == 0) {
            ht.add(item);
        } else {
            ht.add(item);
            for(int i=ht.size()/2-1;i>=0;i--) {
                heapify(ht, i);
            }
        }
    }
}
