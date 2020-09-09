package com.mydanielm;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int binarySearch(int[] arr, int searchElem) {
        int low = 0;
        int height = arr.length-1;

        while (low <= height) {
            int mid = (low+height)/2;
            if(arr[mid] == searchElem) return mid;
            if(arr[mid] > searchElem) height = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    public static void display(int[] array) {
        for (int a: array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static int[] generateArray(int n) {
        Random rnd = new Random();

        int[] newArray = new int[n];
        for (int i =0; i <newArray.length;i++)
            newArray[i] = rnd.nextInt(1000);

        return newArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
	        System.out.print("Создание массива. \nВведите количество элементов: ");
            int countOfElements = in.nextInt();

            int[] arr = generateArray(countOfElements);
            display(arr);

            System.out.println("Массив отсортирован: ");
            insertionSort(arr);
            display(arr);

            System.out.print("Введите элемент для поиска: ");
            int searchElem = in.nextInt();
            int result = binarySearch(arr,searchElem);

            if(result == -1) System.out.println("Такого элемента нет в массиве.");
            else System.out.printf("Искомый элемент находится на позиции %d", result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
