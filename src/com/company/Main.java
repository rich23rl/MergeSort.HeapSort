package com.company;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        int[] x = new int[10];
        int[] y = new int[10];

        // Comienzo del tiempo
        long start = System.currentTimeMillis();

        //Comienzo de la funcion
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int anArr : x) {
            queue.add(anArr);
        }
        for (int i = 0; !queue.isEmpty(); i++) {
            x[i] = queue.remove();
        }
        //Fin de la funcion

        //Fin del tiempo
        long end = System.currentTimeMillis();
        System.out.println("Heap Sort " + (end - start) + " milisegundos");

        // Comienzo del tiempo
        start = System.currentTimeMillis();
        y = mergeSort(y);
        end = System.currentTimeMillis();
        System.out.println("Merge Sort " +(end - start)+ " milisegundos");
        //Fin del tiempo
    }

    public  static int[] mergeSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        int medio = arr.length /2;

        int[] abajo = new int[medio];
        int[] arriba = new int[arr.length - medio];
        for (int i = 0; i < medio; i++) {
            abajo[i] = arr[i];
        }

        for (int i = 0; i < arriba.length ; i++) {
            arriba[i] = arr[i + abajo.length];
        }
        return  merge(mergeSort(abajo), mergeSort(arriba));
    }

    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0, j = 0, k = 0;
        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }
        while (j < a.length){
            retval[i++] = a[j++];
        }
        while (k < b.length){
            retval[i++] = b[k++];
        }
        return retval;
    }
}

