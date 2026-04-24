# Portfolio: Algoritmer

## 1. Tegn en cyklisk liste
Kig på klassen `algorithms.circularlinkedList.ListFactory`. 

- Tegn den liste, der returneres fra et kald til `buildListWithCycle()`
    - Tegn de forskellige `Node` objekter med attributter
    - Tegn pile fra attributter til de objekter, der refereres til

**min:**
head
↓
[ value:1 | next ] → [ value:2 | next ] → [ value:3 | next ] → [ value:4 | next ] → [ value:5 | next ]
                           ↑                                                            ↓
                           └────────────────────────────────────────────────────────────┘

## 2. Lav en cycle detector
Du skal nu lave en metode, som kan detektere om en liste er cyklisk. Det vil sige, at hvis vi giver en `Node` (ikke nødvendigvis head) til 
metoden, skal den returnere `true` eller `false` alt efter om listen er cyklisk eller ej. 

Fx vil et kald med listen 

```java 
1 ⟶ 2 ⟶ 3 ⟶ 4 ⟶ 5 ⟶ null 
```

returnere `false` mens et kald med listen

```java 
1 ⟶ 2 ⟶ 3 ⟶ 4 ⟶ 5 ⟶ 1 ⟶ ..osv 
```
vil returnere `true`.

Opgaven er nu

- Lav en metode `public boolean hasCycle (Node head)` (fx i klassen `circularlinkedlist.Main`) som tager en `Node` som parameter og returnerer
en boolean, der angiver om listen er cycklisk. 
  - Du skal bruge to pointere `slow` og `fast`
  - `slow` skal bevæge sig gennem listen ét skridt ad gangen
  - `fast` skal bevæge sig gennem listen to skridt ad gangen
  - Hver gang de to pointere har flyttet sig skal du undersøge om de har ramt hinanden
  - Hvis rammer hinanden returneres `true`.
  - Hvis `fast` når enden af listen returneres `false`
  - Test din kode ved at køre `main` i klassen `circularlinkedlist.Main`

Bonusopgave: Kan du forudse hvad `floydexample.TraversingArrays.hasCycle(..)` vil returnere med inputtet ` int[] test = {2, 0, 1}` og hvorfor?

## 3. Grådig algoritme

Du skal lave en algoritme, som kan beregne hvor meget træ af forskellige længder vi skal bruge til at opnå en target-længde.

Vi har træ liggende i længderne 7, 5 og 2 meter. Så hvis vi skal bruge 12 meter, stykker vi det sammen af 7 og 5 meter.

Opgaven er nu

- Lav en klasse `WoodHandler` med metoden `List<Integer> calculateWood(int target)` som tager en target-længde som parameter
  og returnerer en liste af de længder, vi skal bruge. Fx vil `calculateWood(11)` returnere en liste med tallene 7, 2, 2.
- Hvis metoden ikke kan ramme target præcist, kan du lade den returnere det, der kommer tættest på. Fx skal `calculateWood(13)` returnere
  7, 5, 2.
- Du kan også vælge at returnere `null` hvis metoden ikke kan ramme target præcist.

I hvilke tilfælde giver den grådige algoritme den bedst mulige løsning –
og i hvilke tilfælde kunne færre stykker være muligt med en anden strategi?

Bonus:
- Lav en lazy-version af calculateWood(int target), hvor vi husker tidligere beregninger
    - Brug fx Map<Integer, List<Integer>> til at cache løsninger
    - Så hvis vi igen skal bruge 11 meter, slår vi det bare op

- Find den løsning med færrest antal stykker ved hjælp af backtracking
    - Brug rekursion og prøv alle kombinationer
    - Gem den bedste (mindste) løsning

## 4. Backtracking

Du har en labyrint, du skal gå igennem. Labyrinten er repræsenteret af et to-dimensionelt array hvor
- `1` betyder "du kan gå her"
- `0` betyder "mur - her kan du ikke gå"

Labyrinten kan fx se sådan ud: 

```java
int[][] maze = {
{1, 0, 1, 1},
{1, 1, 1, 0},
{0, 0, 1, 1},
{1, 1, 0, 1}
};
```

Du starter i øverste venstre hjørne (0,0) og skal finde vej til nederste højre hjørne (3,3). 

Kig på koden i `maze.MazeExercise`. Der mangler at blive implementeret en metode, der kan gå gennem labyrinten.
I kan med fordel arbejde sammen i par og skrive pseudokode for metoden inden I implementerer. 

Brug `int[][] path = new int[N][N];` til at holde styr på vejen gennem labyrinten. Den skal både bruges, når du 
printer løsningen og når du tjekker for om du allerede har besøgt et felt. 

Opgaven er nu

- Implementer metoden `solveMaze(..)`. For hvert skridt skal du
  - Tjekke om du går udenfor labyrintens grænser
  - Tjekke om feltet er gyldigt ([row][col] == 1)
  - Tjekke om feltet er en del af en sti du har prøvet før (`path`)
  - Tjekke om du har nået målet ([row][col] == 3)
  - Markere feltet som en del af stien (`path`)
  - Prøv de fire retninger én af gangen
    - ned
    - højre
    - op
    - venstre
  - Hvis ingen muligheder virker, så backtrack (og fjern feltet fra `path`)

Du kan søge inspiration i `backtracking/NQueeens`  

## 5. Dovne beregninger

Kig på koden i `lazy.LazyCalculations`. Hvad sker der hvis vi kalder metoden `lazyFactorial(..)` med 5 som argument?
Og hvad sker der, hvis vi efterfølgende kalder metoden med 3 som argument? 

Lav din egen metode `lazySum(int i)` som summerer tallene fra 1 - n. 

Prøv at sætte counter på dine metoder og se hvor mange beregninger der udføres, når du kalder dem. 

Prøv at lave metoden `init()` som laver alle beregninger på forhånd. Lav derefter metoderne `eagerFactorial(..)` 
og `eagerSum(..)` som blot slår op i det map, der er lavet i `init()`. Sæt counter på dine metoder og se hvor mange beregninger, 
der udføres. Test i `main` hvor lang tid en beregning i de dovne metoder tager i forhold til de eager? Og hvor lang tid opstart
tager (kald til `init()`). Måske skal du lægge kunstig tid ind i beregningsdelene for at se en effekt på små datasæt. 


# NOTER

## Cyklisk liste (opgave 1)
En cyklisk linked list er en liste, hvor den sidste node ikke peger på null,
men i stedet peger tilbage på en tidligere node i listen.

I vores eksempel:
n5.next = n2

Det betyder at listen bliver:
1 → 2 → 3 → 4 → 5 → 2 → 3 → ... (uendelig)

Derfor stopper listen aldrig.

Forskellen på normal og cyklisk liste:
- Normal liste: sidste node → null
- Cyklisk liste: sidste node → en tidligere node

Head er den første node i listen (her n1 / circularList).

## Cycle detection (Floyd’s algoritme) (opgave 2)
Vi bruger to pointers:
- slow (går 1 skridt ad gangen)
- fast (går 2 skridt ad gangen)

**Idé:**
Hvis der er en cyklus, vil fast "indhente" slow på et tidspunkt.

Hvis de mødes → der er en cyklus → return true
Hvis fast rammer null → der er ingen cyklus → return false

**Hvorfor virker det?**
- Fordi fast bevæger sig hurtigere og vil til sidst lande på samme node som slow, hvis listen er cirkulær.

- Tidskompleksitet: O(n)
- Pladskompleksitet: O(1)


**BONUS – hvorfor printer vi ikke den cykliske liste?**

**I main:**
- if(!hasCircle(circularList))
- System.out.println(circularList);

Vi undgår at printe cykliske lister,
fordi toString() ellers vil køre uendeligt (recursion loop).

**Generelt:**
- Linked lists består af objekter (nodes), som peger på hinanden via referencer.
- Man arbejder ikke med indeks som i arrays, men bevæger sig via next.

- Cykliske strukturer kræver ekstra håndtering, da de ellers kan give uendelige loops.


## Grådig algoritme (Greedy) (opgave 3)

En grådig algoritme vælger altid den bedste løsning lokalt (her: den største længde),
uden at tænke på den samlede optimale løsning.

**I denne opgave:**
- Vi vælger altid den største træ-længde først (7 → 5 → 2).

**Eksempel:**
- target = 11
- → vælger 7 (resterer 4)
- → vælger 2 (resterer 2)
- → vælger 2 (resterer 0)
- Resultat: [7, 2, 2]

**Fordel:**
- Hurtig og simpel
- Tidskompleksitet: O(n)

**Ulempe:**
- Giver ikke altid den optimale løsning (færrest stykker)

### Hvornår virker greedy optimalt?
Greedy virker bedst når:
- Problemet har en "optimal substructure"
- De største valg altid leder til den bedste løsning

I dette tilfælde virker greedy ofte, fordi længderne (7, 5, 2) passer godt sammen.

### Hvornår virker greedy IKKE?
Greedy kan fejle hvis en anden kombination giver færre stykker.

**Eksempel (tænkt tilfælde):**
- Hvis vi havde længder: 10, 6, 1
- target = 12

**Greedy:**
- → 10 + 1 + 1 = 3 stykker

**Bedre løsning:**
- → 6 + 6 = 2 stykker

- → greedy er ikke optimal her

## Bonus – Lazy (cache)
Ide:
- Vi gemmer tidligere beregninger i et Map.

Hvis vi allerede har beregnet fx 11, så returnerer vi bare resultatet i stedet for at regne igen.

Fordel:
- Hurtigere ved gentagne kald

## BONUS – Backtracking (optimal løsning)
I stedet for greedy prøver vi ALLE kombinationer.

Vi bruger rekursion til at:
- prøve alle længder
- holde styr på nuværende løsning
- gemme den bedste (færrest stykker)

Fordel:
- Finder den bedste løsning

Ulempe:
- Langsom (eksponentiel tid)