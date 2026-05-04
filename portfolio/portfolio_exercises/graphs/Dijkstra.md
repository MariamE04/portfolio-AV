## Portfolioopgave: Dijkstra

Lav en implementering af Dijkstras algoritme, der finder den korteste vej mellem byer i et vejnet.

- Design selv dit vejnet med mindst 8 byer og vægtede rettede veje
- Find den korteste vej fra én by til en anden
- Lav en visualisering der giver mening. Hvad er nyttigt at se når man skal forstå algoritmen?

Du kan finde inspiration til koden i `graphs.dijkstra`.

### Visualisering

Tænk over hvad der er meningsfuldt at vise for at forklare nogen hvordan Dijkstra virker. Nogle muligheder:

- Print i konsollen hvad der sker i hvert trin, fx "Afstanden fra Skovby til Lilleby er nu 13 km" eller "Lilleby er nu visited". 
Lav evt. tabeller over hvad der er i kø og/eller i visited. 
- Lav et interaktivt step-by-step mode hvor brugeren trykker y for at gå videre og kan følge med i hvad der er afsøgt indtil videre.
- Lav en grafisk visualisering i JavaScript eller Processing hvor noder skifter farve efterhånden som de bliver visited eller afsøgt.

Hvis du bruger JavaScript eller Processing må du gerne få hjælp af AI til selve koden, men du skal selv beslutte hvad du vil visualisere og hvorfor. 
Det er designbeslutningen der er vigtig, ikke om du skriver koden selv.



## NOTER
Algoritmen starter i node A med afstand 0. Alle andre noder har i starten ingen kendt afstand.

Først besøges A, og dens naboer B og C bliver opdateret:

* B får afstand 4
* C får afstand 2

Derefter vælges den node med lavest afstand, som er C.

Fra C opdateres D til afstand 3 (2 + 1).

Herefter besøges D, og E opdateres til 6 (3 + 3).

Selvom B stadig er i køen, vælges den først senere, fordi dens afstand er højere.

Algoritmen fortsætter med at vælge den billigste node:

* E → opdaterer F til 8
* F → opdaterer G til 9
* G → opdaterer H til 11

Til sidst når algoritmen målnoden H og stopper.

Den korteste vej rekonstrueres ved at følge previous-mappet baglæns fra H til A.
