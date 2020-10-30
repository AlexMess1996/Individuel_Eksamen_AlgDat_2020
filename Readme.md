Student Nr: s326156

Oppgave 1: 

leggInn() metoden lager vi en node og en compare hjelpevariabel og tar de values og setter dem i treet.
Den sammenligner node- verdi med parent- verdi og så settes det på riktig plass.


Oppgave 2: 

Her har vi 3 metoder som er ferdig kodet (inneholder(),antall() og tom()). I den oppgaven måtte jeg kode public int antall() metoden som skal returnere antall forekomster av verdi i treet. Vi setter opp en variabel antallVerdi som skal være den som skal bli returnert med det antallet fra treet. Deretter tar vi det verdien som vi setter i metoden og sammenligner vi det med node-verdien. Hvis cmp < 0 da skal node verdien flyttes til venstre og hvis cmp == 0 da skal den flyttes til høyre. Når det flyttes til høyre så øker vi antallVerdi med 1.


Oppgave 3:

FørstePostorden returnerer første node i post orden og nestePostorden den neste node etter p. I førstePostorden vi tar p Node og legger vi den på venstre hvis allerede p.venstre er ikke null. Om den er null så legger vi den til høyre. Alt det blir gjentatt i en while-lopp. Til slutt returnerer jeg p-Node verdien. I nestePostOrden så hvis foreldre node er null, returnerer jeg bare noden. Videre skal metoden sjekke om p noden er lik sin foreldrer høyre verdi eller om den er null. Hvis det er sant så skal p node være lik sin foreldrer verdien.



Opppgave 6:

På den oppgaven måtte jeg lage fjern, fjernAlle og nullstill() metodene. Fjern metoden skal fjerne en node og flytte resten av nodene på riktig plass. På fjernAlle så lager vi en while-loop der det blir kjørt fjern() metoden med node- verdi som parameter. Med nullstillSubtre så bruker vi rekursjon til å "nullstille" de nodene som finnes. I nullstill() metoden så bruker vi nullstillSubtre() med parameter rot- verdien og deretter setter rot er lik null;   