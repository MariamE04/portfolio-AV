package searchandsort;

import searchandsort.entities.Student;

import java.util.*;

import static java.util.Collections.swap;

public class SortExamples {

    public static void bubbleSort(List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) { // hvor mange gange hele processen køres (gentager indtil alt er sorteret)
            for (int j = 0; j < n - i - 1; j++) { // hvilke elementer vi sammenligner (- i = ignorerer de sidste elementer (de er allerede sorteret))
                if (students.get(j).getId() > students.get(j + 1).getId()) { //  sammenligner ID:  sorteres studerende efter id (stigende)
                    swap(students, j, j + 1); // bytter plads på de to studerende: stor ID ryger bagud, lille ID ryger frem
                }
            }
        }
    }

    /// OPG 1
    public static void bubbleSortInt(int[] arr){

        int n = arr.length;

        // Vi gennemgår arrayet flere gange
        for(int i = 0; i < n - 1; i++){

            // Sammenligner naboer
            for(int j = 0; j < n - i - 1; j++){

                // Hvis forkert rækkefølge → byt
                if (arr[j] > arr[j + 1]) {
                    swapInt(arr, j, j + 1);
                }
            }
        }
    }

    public static void heapSort(List<Student> students) {
        PriorityQueue<Student> heap = new PriorityQueue<>(Comparator.comparingInt(Student::getId));
        heap.addAll(students);

        students.clear();
        while (!heap.isEmpty()) {
            students.add(heap.poll());
        }
    }

    // rekursiv metode
    public static void quickSort(List<Student> students, int low, int high) {
        // base case - vi hopper ud af rekursion hvis low er >=  high
        if (low < high) {
            int pivot = partition(students, low, high);
            quickSort(students, low, pivot - 1);
            quickSort(students, pivot + 1, high);
        }
    }

    private static int partition(List<Student> students, int low, int high) {
        int pivotValue = students.get(high).getId();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students.get(j).getId() <= pivotValue) {
                i++;
                swap(students, i, j);
            }
        }
        swap(students, i + 1, high);
        return i + 1;
    }

    public static void mergeSort(Student[] students){
        // Hvis der er 1 element tilbage kan vi ikke sortere mere
        // Dette er metoden base case
        if (students.length < 2)
            return;
        // Vi finder midten af students arrayet
        int middle = students.length / 2;
        // Vi laver to sub-arrays som hver er halvdelen af student-arrayet langt
        Student[] lefthalf = new Student[middle];
        Student[] righthalf = new Student[students.length - middle];

        // Vi kopierer første halvdel af students arrayet ind i lefthalf
        for(int i = 0; i < middle; i++){
            lefthalf[i] = students[i];
        }

        // Og anden halvdel ind i righthalf
        for(int i = middle; i < students.length; i++){
            righthalf[i - middle] = students[i];
        }

        /*
        Vi kunne erstatte forloops med
        System.arraycopy(students, 0, lefthalf, 0, middle);
        System.arraycopy(students, middle, righthalf, 0, students.length - middle);
         */

        // Vi kalder metoden rekursivt med de to arrays
        mergeSort(lefthalf);
        mergeSort(righthalf);

        // Vi merger de to sorterede halvdele
        merge(students, lefthalf, righthalf);
    }

    private static void merge(Student[] input, Student[] left, Student[] right){
        // Tre hjælpevariable der skal bruges som pointere i hver deres array
        int i = 0, l = 0, r = 0;
        // Så længe der er elementer i både venstre og højre array, som ikke er
        // kopieret til input-array, så fortsætter vi sortering
        while (l < left.length && r < right.length){
            if (left[l].getId() <= right[r].getId()){
                input[i] = left[l];
                l++;
                i++;
            } else {
                input[i] = right[r];
                r++;
                i++;
            }
        }
        // Når der ikke er flere elementer i enten left eller right, lægges de
        // resterende elementer i input
        while(l < left.length){
            input[i] = left[l];
            l++;
            i++;
        }
        while(r < right.length){
            input[i] = right[r];
            r++;
            i++;
        }
    }

    /// OPG 2
    public static void mergeSortInt(int[] arr){
        // Base case
        if(arr.length < 2){
            return;
        }

        int mid = arr.length / 2;

        //Split array
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Kopier værdier
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // Rekursion
        mergeSortInt(left);
        mergeSortInt(right);

        // Merge
        mergeInt(arr, left, right);
    }

    public static void mergeSortList(List<Student> students) {
        if (students.size() > 1) {
            int mid = students.size() / 2;
            List<Student> left = new ArrayList<>(students.subList(0, mid));
            List<Student> right = new ArrayList<>(students.subList(mid, students.size()));

            mergeSortList(left);
            mergeSortList(right);

            mergeList(students, left, right);
        }
    }

    private static void mergeList(List<Student> students, List<Student> left, List<Student> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getId() <= right.get(j).getId()) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            students.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            students.set(k++, right.get(j++));
        }
    }

    /// hjælpe metoder
    // Collections.swap kan kun bruges til List, derfor lavede jeg en separat swap-metode til arrays.
    private static void swapInt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void mergeInt(int[] arr, int[] left, int[] right) {

        int i = 0; // samlet array
        int l = 0; // venstre
        int r = 0; // højre

        // Sammenligner og indsætter i rækkefølge
        while (l < left.length && r < right.length) {

            if (left[l] <= right[r]) {
                arr[i] = left[l];
                l++;
            } else {
                arr[i] = right[r];
                r++;
            }
            i++;
        }

        // Rest fra venstre
        while (l < left.length) {
            arr[i] = left[l];
            l++;
            i++;
        }

        // Rest fra højre
        while (r < right.length) {
            arr[i] = right[r];
            r++;
            i++;
        }
    }
}
