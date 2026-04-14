package searchandsort;

import searchandsort.entities.Student;
import searchandsort.util.Factory;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // testComplexity();
        // testLinearAndBinarySearch();
        // testSort();
        testListPerformance();
        testSetPerformance();
        testTreeSetVsHashSetStudents();
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

        // O(n²) - brug mindre n!
        int n2 = 2000;
        start = System.currentTimeMillis();
        BigOExamples.quadraticTime(n2);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(n²): " + (stop - start) + " ms\n");

        System.out.println("------ Mine egne metoder ------");

        // DINE METODER

        // O(1)
        start = System.currentTimeMillis();
        BigOExamples.myConstant();
        stop = System.currentTimeMillis();
        System.out.println("My O(1): " + (stop - start) + " ms\n");

        // O(log n)
        start = System.currentTimeMillis();
        BigOExamples.myLog(n);
        stop = System.currentTimeMillis();
        System.out.println("My O(log n): " + (stop - start) + " ms\n");

        // O(n)
        start = System.currentTimeMillis();
        BigOExamples.myLinear(n);
        stop = System.currentTimeMillis();
        System.out.println("My O(n): " + (stop - start) + " ms\n");
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
        Collections.sort(students);

        // Binær søgning
        start = System.currentTimeMillis();
        Student studentBinary = SearchExamples.binarySearch(students, targetId);
        stop = System.currentTimeMillis();
        System.out.println("Binær søgning fandt: " + studentBinary);
        System.out.println("Tid: " + (stop - start) + " ms");
    }

    private static void testSort() {
        List<Student> original = new ArrayList<>();
        Factory.fillWithStudents(original, 100000);

        // Bubble Sort (langsom)
        List<Student> bubbleList = new ArrayList<>(original);
        long start = System.currentTimeMillis();
        //   SortExamples.bubbleSort(bubbleList);
        long stop = System.currentTimeMillis();
        System.out.println("Bubble Sort - tid: " + (stop - start) + " ms");

        // Heap Sort
        List<Student> heapList = new ArrayList<>(original);
        start = System.currentTimeMillis();
        SortExamples.heapSort(heapList);
        stop = System.currentTimeMillis();
        System.out.println("Heap Sort - tid: " + (stop - start) + " ms");

        // Quick Sort
        List<Student> quickList = new ArrayList<>(original);
        start = System.currentTimeMillis();
        SortExamples.quickSort(quickList, 0, quickList.size() - 1);
        stop = System.currentTimeMillis();
        System.out.println("Quick Sort - tid: " + (stop - start) + " ms");

        // Merge Sort
        List<Student> mergeList = new ArrayList<>(original);
        start = System.currentTimeMillis();
        SortExamples.mergeSort(mergeList);
        stop = System.currentTimeMillis();
        System.out.println("Merge Sort - tid: " + (stop - start) + " ms");
    }

    //// OPGAVE 2

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

        System.out.println("---- ArrayList ----");

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

        System.out.println("---- HashSet (Student) ----");

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

//// -------------------- NOTER --------------------
//ArrayList vs LinkedList:
// ArrayList er baseret på et array i hukommelsen.
// Det betyder at man kan tilgå elementer direkte via index → O(1).
// Når man indsætter eller sletter i midten, skal alle efterfølgende elementer rykkes → O(n).

// LinkedList består af noder, hvor hver node peger på den næste.
// For at finde et element skal man traversere listen → O(n).
// Indsættelse og sletning er hurtig, når man først er ved positionen,
// fordi man kun ændrer links mellem noder.

//Derfor:
// ArrayList → hurtig til get(), langsom til add/remove i midten
// LinkedList → langsom til get(), men fleksibel til indsættelse/sletning

//ArrayList vs HashSet (contains):
// ArrayList bruger lineær søgning → O(n).
// Det betyder at den skal gennemgå elementerne én efter én.

// HashSet bruger hashing → O(1).
// Elementets hash bruges til at finde det direkte, uden at gennemgå hele datastrukturen.

//Derfor:
// HashSet er meget hurtigere til contains() end ArrayList.

//Vigtig pointe:
// Selvom LinkedList er god til indsættelse og sletning, er den stadig langsom i praksis, fordi man først skal finde positionen (O(n)).

// Derfor ser man ofte at ArrayList bruges mest i praksis,
// medmindre man har mange indsættelser/sletninger i starten af listen.

// Konklusion:
// Valg af datastruktur har stor betydning for performance.
// Den samme operation kan have forskellig kompleksitet afhængigt af datastrukturen.