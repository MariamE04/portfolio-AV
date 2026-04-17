# Portfolio: Sortering

## 1. Leg med sortering
- Kig på klassen `SortExamples`, som viser eksempler på fire sorteringsalgoritmer.
- Se om du kan forstå hvordan de forskellige algoritmer fungerer.
- Kør metoden `testSort()` fra `main` i klassen `searchandsort.Main`og se tidsstempler for de fire algoritmer.
- Prøv at udkommentere ` Collections.shuffle(original)` og se hvad der sker med `quickSort()`.
  Hvorfor sker dette? (Hint: worst case scenario).
- Prøv at implementere metoderne `bubbleSort()`, `quickSort()` og `mergeSort` så de tager et `int[] array` som parameter.
  Du kan få brug for denne kodestump

```java 
private static void swap(int[] arr, int i, int j) {
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
```

## 2. Merge sort
   - Kig på klassen `searchandsort.SortExamples` og metoderne `mergeSort()` og `merge()`. 
   - Prøv at køre metoden `testMerge` fra `Main.main` og se om du forstår hvad der sker. Hvad er basecase i den rekursive metode `mergeSort()` og hvorfor? Hvorfor returnerer ingen af metoderne noget?
   - Implementer en ny mergesort-metode, som tager et `int[]` som parameter. Lad være med at copy-paste koden fra `SortExamples`. Kommenter din kode, så du ved hvad der sker i hvert step.
   
Bonus: kig på metoderne `mergeSortList` og `mergeList()`. Hvordan adskiller de sig fra de metoder, der tager arrays som paramter? Hvad betyder fx `new ArrayList<>(students.subList(0, mid))?` Hvorfor bruges metoden `set()` og ikke `add()` i `mergeList()`?

## 3. Quick sort
   Kig på klassen `searchandsort.SortExamples` og metoden `quickSort()`.
   Prøv at køre metoden `testQuick()` fra `Main.main` og se om du forstår hvad der sker.
   Udkommenter  `Collections.shuffle(original)` og se hvad der sker med `quickSort()`. Hvorfor sker dette? (Hint: worst case scenario)
   Implementer en ny quicksort-metode, som tager et `int[]` som parameter. Lad være med at copy-paste koden fra SortExamples. Kommenter din kode, så du ved hvad der sker i hvert step.