## Hvordan holdes styr på dist og hvornår opdateres den?
Afstanden til hver node gemmes i et Map kaldet dist.

I starten sættes startnoden til 0, og alle andre noder betragtes som uendeligt langt væk (implicit via Integer.MAX_VALUE).

Når algoritmen undersøger en nabo, beregner den en ny afstand (newDist). Hvis denne afstand er mindre end den tidligere kendte afstand, bliver dist opdateret.

Det betyder, at dist altid indeholder den billigste kendte vej til hver node.


## Hvordan fungerer prioritetskøen?
Prioritetskøen indeholder noder sammen med deres afstand fra startnoden.

Køen er sorteret, så den node med den laveste afstand altid ligger først. Det sker fordi NodeWithDist implementerer Comparable.

Når vi kalder queue.poll(), får vi altid den node, som lige nu har den korteste afstand.

På den måde sikrer algoritmen, at vi altid arbejder videre fra den billigste mulighed.


## Hvordan holdes styr på prev?
Prev er et Map, som gemmer hvilken node vi kom fra.

Når vi finder en bedre vej til en node, gemmer vi den forrige node i prev.

Det bruges til sidst til at rekonstruere den korteste vej ved at gå baglæns fra målnoden til startnoden.


## Hvordan holdes styr på visited?
Visited er et Set, som indeholder de noder vi allerede har undersøgt.

Når en node er besøgt, bliver den tilføjet til visited, så vi ikke behandler den igen.

Det sikrer, at algoritmen ikke bruger tid på de samme noder flere gange.


## Hvad sker der når vi når målet?
Når algoritmen tager målnoden ud af prioritetskøen, stopper den med at lede videre.

Derefter rekonstrueres stien ved hjælp af prev, hvor man går baglæns fra målnoden til startnoden.

Til sidst printes både den korteste vej og den samlede afstand.


## Ekstra: hvad sker der samlet?
Algoritmen bruger en prioritetskø til altid at vælge den node med kortest afstand,

opdaterer afstande til naboer hvis en billigere vej findes,

og gemmer tidligere noder i prev for at kunne rekonstruere den korteste vej til sidst.