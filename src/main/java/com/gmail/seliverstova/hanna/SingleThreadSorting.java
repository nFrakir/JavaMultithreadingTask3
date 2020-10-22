package com.gmail.seliverstova.hanna;

public class SingleThreadSorting implements Runnable {
    private int[] array;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private boolean stop = false;

    public SingleThreadSorting(int[] array, int begin, int end) {
        super();
        this.array = array;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);

        thr.start();
        this.index = begin;
    }

    public Thread getThr() {
        return thr;
    }

    public int peekElement() {
        return array[index];
    }

    public int pollElement() {
        int temp = array[index];
        check();
        return temp;
    }

    public boolean isStop() {
        return stop;
    }

    @Override
    public void run() {
        shellSort(this.array, this.begin, this.end);
    }

    private void shellSort(int[] array, int begin, int end) {
        for (int k = (end - begin) / 2; k > 0; k /= 2)
            for (int i = begin + k; i < end; i++)
                for (int j = i; (j - begin) >= k && array[j - k] > array[j]; j -= k)
                    swap(array, j, j - k);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private void check() {
        this.index++;
        if (this.index >= this.end) {
            this.stop = true;
        }
    }
}
