# Forberedelse: Design Patterns

## Opgave 1: Læs om patterns (før dag 1)

Læs følgende dokumenter i mappen `docs/designpatterns/`:

- `Oversigt.md`
- `AdapterPattern.md`
- `BuilderPattern.md`
- `CommandPattern.md`
- `CompositePattern.md`
- `DecoratorPattern.md`
- `FactoryPattern.md`
- `ObserverPattern.md`
- `ProxyPattern.md`
- `SingletonPattern.md`
- `StrategyPattern.md`
- `TemplateMethodPattern.md`
- `Guide.md`
- `Kategorisering.md`

Du behøver ikke læse `Cases.md`, `Cheat_sheet_til_cases.md` eller `designpatterns_exercises.md` endnu.

Kig også på kodeeksemplerne i pakken `designpatterns`. Der ligger et eksempel for hvert pattern.

Kom forberedt med svar på:
- Hvilke patterns kendte du i forvejen?
- Hvilke var lette at forstå?
- Hvilke var svære at se meningen med? 
- Er der et pattern du ikke forstår, så tag dit spørgsmål med til undervisningen.

---

## Opgave 2: Spot patterns i kursets kode (før dag 2)

> ⚠️ Lav en `git pull` før du går i gang, så du har den seneste version af koden.

Kig koden i pakkerne `algorithms`, `graphs`, `reflection` og `searchandsort` igennem.

Find **mindst tre** steder hvor der enten

- **er** et design pattern: Beskriv hvilket pattern det er og hvorfor du mener det
- **mangler** et design pattern: Beskriv hvilket pattern der kunne bruges og hvad det ville løse

Prøv at finde tre **forskellige** patterns.

Skriv dine observationer ned. Du skal præsentere dem i næste undervisningsgang.

---

## NOTER
### Observation 1 – Strategy Pattern mangler i Dijkstra og A*
- I både Dijkstra og AStar er der meget ens kode. Begge algoritmer finder den korteste vej i en graf og bruger næsten samme struktur.

**Forskellen er primært:**
- Dijkstra bruger kun distance
- A* bruger distance + heuristik

Det kunne løses med et Strategy Pattern.

**Hvorfor Strategy?**
- Strategy bruges når man vil kunne udskifte en algoritme dynamisk.

Her kunne man lave et interface som fx:

```java
interface PathFindingStrategy {
int calculateCost(...);
}
```

Så kunne man have:
- DijkstraStrategy
- AStarStrategy

**Hvad ville det løse?**
- Mindre duplicate kode
- Nemmere at tilføje nye algoritmer senere
- Mere fleksibel kode
- Bedre separation af ansvar

---

### Observation 2 – Template Method i backtracking-eksemplerne

I både NQueens og TryBacktrack følger algoritmerne næsten samme struktur:

1. vælg en mulighed 
2. udforsk rekursivt 
3. gå tilbage (backtrack)

**Eksempel fra NQueens:**
```java
board[row][col] = 'Q';
placeQueen(row + 1);
board[row][col] = '.';
```

**Hvilket pattern?**
- Template Method Pattern

**Hvorfor?**
- Template Method handler om at have en fast algoritmestruktur, hvor enkelte trin kan ændres.

**Her er strukturen altid:**
- prøv mulighed
- rekursion
- backtrack

**Men ting som:**
- isSafe()
- stopbetingelse
- output

kan variere.

**Hvad ville det løse?**
- Man kunne lave en generel backtracking-superklasse og genbruge strukturen til flere problemer.

---

### Observation 3 –adapter
Klasser som WeightedNode og CityNode består af noder, der indeholder andre noder som naboer.

`private Map<WeightedNode, Integer> neighbors;`

**Hvilket pattern?**
- Adapter

**Hvorfor?**
- prope det ene objekt i det andet (tilpasse)

---

### Eventuel ekstra observation
Factory Method kunne bruges til oprettelse af noder

I både Dijkstra og A* bliver mange noder oprettet direkte med new.

**Eksempel:**
`WeightedNode A = new WeightedNode("A");`

**Hvilket pattern?**
- Factory Method

**Hvorfor?**
- I stedet for selv at bruge new, kunne en factory stå for at oprette noder.

**Hvad ville det løse?**
- Centraliseret oprettelse af objekter
- Nemmere at ændre node-typer senere
- Mere clean kode