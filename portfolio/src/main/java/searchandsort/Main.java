package searchandsort;

import searchandsort.entities.Student;
import searchandsort.util.Factory;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // testComplexity();
        // testLinearAndBinarySearch();
        // testListPerformance();
        // testSetPerformance();
        // testTreeSetVsHashSetStudents();

        //testBubble(10, true, true);
        // testBubbleInt();

        //testMerge(10, true, true);
        //testMergeInt();

       // testQuick(10, true, true);
        testIntQuick(0, 4);
    }

    private static void testComplexity() {
        int n = 10000; // justér for at demonstrere tydeligt

        // O(1)
        long start = System.currentTimeMillis();
        BigOExamples.constantTime(n);
        long stop = System.currentTimeMillis();
        System.out.println("Time for O(1): " + (stop - start) + " ms\n");

        // O(log n)
        start = System.currentTimeMillis();
        BigOExamples.logTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(log n): " + (stop - start) + " ms\n");

        // O(n)
        start = System.currentTimeMillis();
        BigOExamples.linearTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(n): " + (stop - start) + " ms\n");

        // O(n²) - pas på med at vælge et for stort n!
       /* n = 2000; // mindre n for kvadratisk!
        start = System.currentTimeMillis();
        BigOExamples.quadraticTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(n²): " + (stop - start) + " ms\n");*/
    }

    private static void testLinearAndBinarySearch() {
        List<Student> students = new ArrayList<>();
        Factory.fillWithStudents(students, 100000);

        int targetId = 99999; // sidst i listen, så forskellen er tydelig!

        // Lineær søgning
        long start = System.currentTimeMillis();
        Student studentLinear = SearchExamples.linearSearch(students, targetId);
        long stop = System.currentTimeMillis();
        System.out.println("Lineær søgning fandt: " + studentLinear);
        System.out.println("Tid: " + (stop - start) + " ms");

        // Sorter listen efter ID (nødvendigt for binær søgning)
        // Hvad sorteres de studerende efter? Hvordan finder vi ud af det?
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // Binær søgning
        start = System.currentTimeMillis();
        Student studentBinary = SearchExamples.binarySearch(students, targetId);
        stop = System.currentTimeMillis();
        System.out.println("Binær søgning fandt: " + studentBinary);
        System.out.println("Tid: " + (stop - start) + " ms");
    }

    private static void testBubble(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        Collections.shuffle(list);
        if (print) printList("Bubble Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.bubbleSort(list);
        long stop = System.currentTimeMillis();
        if (print) printList("Bubble Sort - efter", list);
        if (time) System.out.println("Bubble Sort - tid: " + (stop - start) + " ms");
    }

    ///  OPGAVE 1 bubble sort
    private static void testBubbleInt() {

        int[] arr = {5, 2, 8, 1, 3};

        System.out.println("Før:");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        // Kalder metode
        SortExamples.bubbleSortInt(arr);

        System.out.println("\nEfter:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }


    private static void testHeap(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        Collections.shuffle(list);
        if (print) printList("Heap Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.heapSort(list);
        long stop = System.currentTimeMillis();
        if (print) printList("Heap Sort - efter", list);
        if (time) System.out.println("Heap Sort - tid: " + (stop - start) + " ms");
    }

    ///  OPG 3 quick Sort
    private static void testQuick(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        Collections.shuffle(list);
        if (print) printList("Quick Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.quickSort(list, 0, list.size() - 1);
        long stop = System.currentTimeMillis();
        if (print) printList("Quick Sort - efter", list);
        if (time) System.out.println("Quick Sort - tid: " + (stop - start) + " ms");
    }

    private static void testIntQuick(int low, int high){
        int[] arr = {5, 2, 8, 1, 3};

        System.out.println("Før:");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        // Kalder metode
        SortExamples.intQuickSort(arr, low, high);

        System.out.println("\nEfter:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

   private static void testMerge(int size, boolean time, boolean print) {
        List<Student> original = new ArrayList<>();
        Factory.fillWithStudents(original, size);
        Collections.shuffle(original);
        Student[] mergearray = original.toArray(new Student[0]);
        if (print) printArray("Merge Sort - før", mergearray);
        long start = System.currentTimeMillis();
        SortExamples.mergeSort(mergearray);
        long stop = System.currentTimeMillis();
        if (print) printArray("Merge Sort - efter", mergearray);
        if (time) System.out.println("Merge Sort - tid: " + (stop - start) + " ms");
    }

    /// OPG 2
    private static void testMergeInt() {

        int[] arr = {5, 2, 8, 1, 3};

        System.out.println("Før:");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        SortExamples.mergeSortInt(arr);

        System.out.println("\nEfter:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    /// Hjælpemetoder til udskrift
    private static void printList(String label, List<Student> list) {
        System.out.println(label + ": ");
        for(Student s:list){
            System.out.println(s);
        }
    }

    private static void printArray(String label, Student[] arr) {
        System.out.println(label + ": ");
        for(Student s:arr){
            System.out.println(s);
        }
    }

    private static Student[] createCardArray(){
        Student[] arr = new Student[6];
        arr[0] =  new Student("Tre", 3);
        arr[1] = new Student("Ni", 9);
        arr[2] = new Student("Syv", 7);
        arr[3] = new Student("10", 10);
        arr[4] = new Student("Dronning", 12);
        arr[5] = new Student("Fire", 4);
        return arr;
    }

    //// OPGAVE 2 Kompleksitet
    private static void testListPerformance() {
        int size = 500000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Fyld listerne
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("---- ArrayList ----");

        long start = System.nanoTime();
        arrayList.get(250000);
        long stop = System.nanoTime();
        System.out.println("get: " + (stop - start) + " ns");

        start = System.nanoTime();
        arrayList.add(250000, 99);
        stop = System.nanoTime();
        System.out.println("add: " + (stop - start) + " ns");

        start = System.nanoTime();
        arrayList.remove(250000);
        stop = System.nanoTime();
        System.out.println("remove: " + (stop - start) + " ns");

        System.out.println("\n---- LinkedList ----");

        start = System.nanoTime();
        linkedList.get(250000);
        stop = System.nanoTime();
        System.out.println("get: " + (stop - start) + " ns");

        start = System.nanoTime();
        linkedList.add(250000, 99);
        stop = System.nanoTime();
        System.out.println("add: " + (stop - start) + " ns");

        start = System.nanoTime();
        linkedList.remove(250000);
        stop = System.nanoTime();
        System.out.println("remove: " + (stop - start) + " ns");

        // Forklaring:
        // ArrayList:
        // get = O(1)
        // add/remove i midten = O(n) fordi elementer rykkes

        // LinkedList:
        // get = O(n) fordi man skal gå gennem listen
        // add/remove er hurtigere når man er fremme (ændrer links)
    }
    private static void testSetPerformance() {
        int size = 500000;

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // Fyld datastrukturer
        for (int i = 0; i < size; i++) {
            list.add(i);
            set.add(i);
        }

        int existing = 400000;
        int notExisting = 600000;

        System.out.println("\n---- ArrayList ----");

        long start = System.nanoTime();
        list.contains(existing);
        long stop = System.nanoTime();
        System.out.println("contains (findes): " + (stop - start) + " ns");

        start = System.nanoTime();
        list.contains(notExisting);
        stop = System.nanoTime();
        System.out.println("contains (findes ikke): " + (stop - start) + " ns");

        System.out.println("\n---- HashSet ----");

        start = System.nanoTime();
        set.contains(existing);
        stop = System.nanoTime();
        System.out.println("contains (findes): " + (stop - start) + " ns");

        start = System.nanoTime();
        set.contains(notExisting);
        stop = System.nanoTime();
        System.out.println("contains (findes ikke): " + (stop - start) + " ns");

        // Forklaring:
        // ArrayList: contains = O(n) (lineær søgning)
        // HashSet: contains = O(1) (hashing → direkte opslag)
    }

    private static void testTreeSetVsHashSetStudents() {
        int size = 100000;

        Set<Student> hashSet = new HashSet<>();
        Set<Student> treeSet = new TreeSet<>();

        // Fylder begge
        for (int i = 0; i < size; i++) {
            Student s = new Student("Name" + i, i);
            hashSet.add(s);
            treeSet.add(s);
        }

        Student target = new Student("Test", 50000);

        System.out.println("\n---- HashSet (Student) ----");

        long start = System.nanoTime();
        hashSet.contains(target);
        long stop = System.nanoTime();
        System.out.println("contains: " + (stop - start) + " ns");

        start = System.nanoTime();
        hashSet.add(new Student("New", 999999));
        stop = System.nanoTime();
        System.out.println("add: " + (stop - start) + " ns");

        start = System.nanoTime();
        hashSet.remove(target);
        stop = System.nanoTime();
        System.out.println("remove: " + (stop - start) + " ns");


        System.out.println("\n---- TreeSet (Student) ----");

        start = System.nanoTime();
        treeSet.contains(target);
        stop = System.nanoTime();
        System.out.println("contains: " + (stop - start) + " ns");

        start = System.nanoTime();
        treeSet.add(new Student("New", 999999));
        stop = System.nanoTime();
        System.out.println("add: " + (stop - start) + " ns");

        start = System.nanoTime();
        treeSet.remove(target);
        stop = System.nanoTime();
        System.out.println("remove: " + (stop - start) + " ns");

        // Kompleksitet:
        // HashSet: O(1)
        // TreeSet: O(log n)

    // HashSet:
    // add, remove, contains → O(1) pga hashing

    // TreeSet:
    // add, remove, contains → O(log n)
    // fordi den er baseret på et sorteret træ
    }
}