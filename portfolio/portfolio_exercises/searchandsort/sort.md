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
   

## Spg og svar:

### Opg 1
**Hvad sorteres de studerende efter?**
- De sorteres efter deres id, fordi der sammenlignes med getId().

**Hvad gør Collections.swap()?**
- Den bytter to elementer i listen, så de kommer i korrekt rækkefølge.

**Hvad styrer den ydre løkke?**
- Den ydre løkke styrer hvor mange gange listen gennemløbes.


**Hvad styrer den indre løkke?**
- Den indre løkke styrer hvilke elementer der sammenlignes i hvert gennemløb.

### Opg 2
**Hvad er basecase i den rekursive metode mergeSort()**

```java
if (students.length < 2)
    return;
```
- Base case er når arrayet har mindre end 2 elementer, fordi et array med 0 eller 1 element allerede er sorteret.

**Hvorfor returnerer metoderne ikke noget?**
- Metoderne returnerer ikke noget, fordi de ændrer arrayet direkte (in-place). Derfor bliver det originale array sorteret uden at returnere en ny værdi.

### Bonus
**Hvad gør dette?**

````java
new ArrayList<>(students.subList(0, mid))
````

Det laver en ny liste ud fra en del af en eksisterende liste.

**Hvorfor set() og ikke add()?**
- set() bruges til at overskrive eksisterende elementer, mens add() ville indsætte og flytte elementer, hvilket ikke er ønsket.

Merge sort bruger divide and conquer, hvor arrayet deles op rekursivt indtil base case, og derefter merges sorteret igen.


### Opg 3
**Hvad sker der når man udkommenterer Collections.shuffle(original)?**

Når shuffle fjernes, bliver listen ofte allerede sorteret eller næsten sorteret.
QuickSort vælger i denne implementering det sidste element som pivot.
Hvis data allerede er sorteret, vil pivot altid være det største element.

**Hvorfor er det et problem? (worst case scenario)**

Når pivot altid er det største (eller mindste), bliver opdelingen meget skæv:
Venstre side får næsten alle elementer
Højre side får næsten ingen
Det betyder, at algoritmen ikke deler problemet effektivt.

**Konsekvens:**

I stedet for optimal tid: O(n log n)
Får vi worst case: O(n²)
Derfor bliver quicksort meget langsommere uden shuffle.

### Forklaring af min egen quicksort (int array):

Jeg bruger rekursion til at dele arrayet op i mindre dele.
Først finder jeg en pivot, som er det sidste element i arrayet.
Derefter flytter jeg alle tal, der er mindre end pivot, til venstre side.
Til sidst placeres pivot det rigtige sted i arrayet.

**Step-by-step:**

1. **Base case**
- Stop hvis low >= high (arrayet er allerede sorteret nok)

2. **Partition**
- Gennemløb arrayet
- Sammenlign hvert tal med pivot
- Byt elementer så små tal kommer til venstre

3. **Rekursion**
- Kør quicksort på venstre side
- Kør quicksort på højre side

### Hvorfor virker det?
- QuickSort bruger divide and conquer:
- Deler problemet op i mindre dele
- Løser dem rekursivt
- Når alle delarrays er sorteret, er hele arrayet sorteret.

### Kort opsummering:
- QuickSort er hurtig i gennemsnit (O(n log n))
- Men kan blive langsom (O(n²)) hvis pivot vælges dårligt
- Derfor bruges shuffle for at undgå worst case