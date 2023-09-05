package HashMap;

import java.util.ArrayList;

public class heap {

    private ArrayList<Integer> arr;
    private boolean isMaxHeap = true;

    void constructHeap() {
        for (int i = this.arr.size() - 1; i >= 0; i--) {
            dowanHeapify(i);
        }
    }

    void defaultValue(boolean isMaxHeap) {
        this.arr = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }

    heap() {
        defaultValue(true);
    }

    heap(boolean isMaxHeap) {
        defaultValue(isMaxHeap);
    }

    heap(int[] arr, boolean isMaxHeap) {
        defaultValue(isMaxHeap);
        for (int ele : arr) {
            this.arr.add(ele);
        }
        constructHeap();
    }

    int size() {
        return this.arr.size();
    }

    boolean isEmpty() {
        return this.arr.size() == 0;
    }

    void add(int data) {
        this.arr.add(data);
        int n = this.arr.size();

        upHeapify(n - 1);
    }

    void swap(int i, int j) {
        int temp = this.arr.get(i);
        this.arr.set(i, this.arr.get(j));
        this.arr.set(j, temp);
    }

    int remove() {
        int rELe = this.arr.get(0);
        int n = this.arr.size();
        swap(0, n - 1);
        this.arr.remove(n - 1);
        dowanHeapify(0);
        return rELe;

    }

    int top() {
        return this.arr.get(0);
    }

    void dowanHeapify(int pi) {

        int maxidx = pi;
        int li = 2 * pi + 1;
        int ri = 2 * pi + 2;

        if (li < this.arr.size() && this.arr.get(li) > arr.get(maxidx)) {
            maxidx = li;
        }
        if (ri < this.arr.size() && this.arr.get(ri) > arr.get(maxidx)) {
            maxidx = ri;
        }
        if (maxidx != pi) {
            swap(pi, maxidx);
            dowanHeapify(maxidx);
        }

    }

    void upHeapify(int ci) {
        int pi = (ci - 1) / 2;
        if (pi <= 0 && this.arr.get(pi) < this.arr.get(ci)) {
         swap(ci, pi);

         upHeapify(pi);
        }
    }

  public static void main(String[] args) {
    int[]arr={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};

    heap pq=new heap(arr, true);

    while(pq.size()!=0){
        System.out.println(pq.remove());
    }
  }
}

