# Søgning i grafer

## 1. BFS

Kig på klassen `graphs.graphsearch.SearchStrategies`. I klassen er metoden `searchBFS(..)`.

Din opgave er

- Tegn den graf, der laves i `main`
- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn indholdet af køen for hver iteration.
- Overvej hvad det betyder, at vi bruger `Queue` som referencetype (hint: det er en FIFO struktur).
- Er grafen rettet eller urettet? Sammenlign med `undirectedgraphs.Node`.
- Er kanterne vægtede eller uvægtede?
- I `Node` er `neighbors` en `List`. Kunne det give problemer? Hvilken datastruktur ville være mere korrekt, og hvorfor?

## 2. DFS

Kig på klassen `graphs.graphsearch.SearchStrategies`. I klassen er metoden `searchDFS(..)`.

Din opgave er

- Gå metodens kode igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn indholdet af stakken for hver iteration.
- Overvej hvad det betyder, at vi bruger `Deque` som referencetype (hint: det er en LIFO struktur).

Bonusspørgsmål: Hvorfor kan vi bruge `ArrayDeque` som både stak og kø?

## 3. Implementer din egen BFS og DFS

Kig på klasserne `graphs.treesearch.Node` og `graphs.treesearch.SearchStrategies`. Her arbejder vi med et træ. I stedet for `getNeighbors()` bruger vi `getChildren()` — men traversal-logikken er den samme.

Din opgave er nu

- Implementer metoderne `searchBFS(..)` og `searchDFS(..)`.
- Hent inspiration i `graphs.graphsearch.SearchStrategies`. Du skal ikke kopiere koden, men forstå hvordan der traverseres og gøre det samme for træer.

## Bonus: Cycle detection

I grafer kan der opstå cyklusser. Det kan der ikke i træer, som per definition er acykliske.

**Refleksionsspørgsmål:** Da vi arbejdede med hægtede lister brugte vi Floyd's Cycle Detection ("tortoise and hare") til at finde cyklusser. Hvorfor kan vi ikke bruge samme trick på grafer?

Du har prøvet noget lignende i maze solveren. Hvad holdt du styr på der for at undgå at gå i ring?

Kig på klassen `graphs.graphsearchcycles.CycleDetector` og se hvordan vi i stedet bruger DFS med et sæt (`inPath`) til at detektere cyklusser i rettede grafer.

- Gå koden igennem linje for linje og forklar hvad `inPath` holder styr på.
- Hvad sker der når vi backtracker? Hvorfor fjernes noden fra `inPath`?
- Kør `main`-metoden og tegn hvad der sker.
- Tilføj eventuelt nogle udprint af `inPath` for at følge hvad der sker. 


## NOTER
OPG 1 BFS
- Queue (FIFO)

**Overvej hvad det betyder, at vi bruger Queue som referencetype (hint: det er en FIFO struktur).**

**Når vi bruger `Queue<Node>:`**
- Det er en FIFO struktur (First In, First Out)
- Den node, der bliver lagt i først, bliver behandlet først

Det betyder:
- BFS besøger noder niveau for niveau

Forklaring:
Q- ueue sikrer, at vi udforsker grafen bredt først, fordi vi altid tager den ældste node først.


**Rettet eller urettet graf?**

Min Node (graphsearch):

```java
public void addNeighbor(Node neighbor) {
neighbors.add(neighbor);
}
```

Tilføjer kun nabo i én retning
➡ Det er en Directed Graph

Undirected Node (undirectedgraphs):

```java
public void addNeighbor(Node other) {
this.neighbors.add(other);
other.neighbors.add(this);
}
```

Tilføjer begge veje
➡ Det er en Undirected Graph


**Vægtede eller uvægtede kanter?**

I Node-klassen:

```java
private List<Node> neighbors;
Der er ingen vægte (tal)
```

➡ Grafen er en Unweighted Graph

Forklaring:
- Alle forbindelser behandles ens (ingen distance/cost)

**Problem med List som neighbors**

`private List<Node> neighbors;`

Problemer:
- Kan indeholde dubletter
- Samme node kan blive tilføjet flere gange
- BFS kan besøge samme node flere gange

Eksempel:
- `a.addNeighbor(b);`
- `a.addNeighbor(b);`
- Bedre datastruktur

➡ Set (Java)

`private Set<Node> neighbors = new HashSet<>();`

Fordele:
- Ingen dubletter
- Mere korrekt ift. graf-teori
- Undgår unødvendige gentagelser

Selv med Set:
- BFS mangler stadig en visited struktur Ellers kan den gå i ring i grafer med cycles.

Eksempel:
- A → B → A

➡ Uden visited → uendeligt loop

### Kort eksamenssvar
- Queue gør BFS FIFO → vi traverserer niveau for niveau
- Grafen er rettet, fordi forbindelser kun går én vej
- Grafen er uvægtet, fordi der ikke er weights
- List kan give dubletter → Set er bedre
- Man bør bruge visited for at undgå cycles