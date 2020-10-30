# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Vi har brukt git til å dokumentere arbeidet vårt. Jeg har 16 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 1: i denne oppgaven så ble vi bedt om å kopiere koden fra 5.2.3a. jeg kopierte den og lagt den inni metoden leggInn. da vi skule gjøre
endringer for at det referansen forelder q skal få den riktig verdien i hver ny node vi har. da merka jeg at vi får feil ved p = new Node<>(verdi);
og da ser vi at for å oprette en ny node så må vi ha i tilligg til verdien så må vi ha med q. fordi q er forelder til p som vi fikk oppgitt.
  og nedresrt så må vi øke endringer.
  
* Oppgave 2: i denne oppagven så skulle vi lage kode til metoden antall (T verdi) og jeg starta koden ved å si hvis verdien er lik null så skal det returneres 0.
etter det så antok jeg at int forekomsteren =0; for å telle antall forekmoster i vårt treet. deretter så sa jeg at den Noden<T> p er lik rota. 
etterhvert så tok jeg en while-løkke hvor jeg sa at p ikke er lik null, deretter så sier jeg at når cmp er midre enn 0 så sett den på venstre
og når den den er lik 0 så øk forekomsteren og sett den på høyre.

*oppgave 3: det første jeg gjør er at jeg sjekker om roten er lik null. og når vi leser på 5.1.7 så finner vi at eksempel 5.1.7 h kan vi låne og
sette while-løkken og da har vi to tilfeller hvor p.venstre ikke er null så vil p node være lik p.venstre. og det andre tilfellet er hvis p.høyre er
ikke lik null så vil p node være lik p.høyre. og på slutten så else return p. 
på den andre metode  private static <T> Node<T> nestePostorden(Node<T> p).  først så sjekker vi at p er lik null. og etterhvert så sjekker vi om p ikke har forelder
sånn at den skal være den siste noden i postorden. deretter sjekker jeg om p er høyre barn til sin forlder.så forelderen er den neste noden. 
 så sjekker om p er venstre barn til sin forlder, og da får vi to tilfeller:
 når p er lik forelder.venstre så vil p er enebarn, eller hvis den er sim forelder.høyre, da får vi at p ikke er enebarn.
 hvis den er enebarn så får vi vite at metoden nestpostorden er den første post orden.
 
 *Oppgave 4: først så sjekker jeg om treet er tomt. og som ble bedt i oppgave så har jeg ikke brukt noen hjelpe variabler stack eller kø.
 og på samme måete som eksemplet 5.1.7c så setter jeg en while-løkke hvor vi sier når p ikke er null så utførOppgave. og på slutten så vil denne 
 (p = nestePostorden(p);) gi den neste i postOrden. iden andre metoden så kopirte jeg koden fra oppgave 7 i avsnitt 5.1.7. i denne pirvate
  hjelpe metoden som implimenterte rekurasjonen, da la vi til at den er enten til venstre barn eller til høyre barn
  
  *Oppgave 5: den ArrayList<T> serialize() hjelpe metoden den skulle enkelt lagre til fil siden er vanskelig å lagre ett binaærttre, og skal isteden
  for lagre i form av array. da startet jeg med å lage mitt array. deretter så lager vi vår kø. deretter så legger vi til rot-noden ved addLast.
  og så en while-løkke hvor jeg sier  så lenge ikke kø is.Empty. og da legger vi current sine to barn til køen. og siden vi ikke skal skrive ut noe
  så må vi legge til vårt array current og verdien. og da return array. (kildekoden er vidioen i uke09 level order). 
  i  den deserialize så skulle den ta inn arrayet og skal de legges inn alle verdiene. og da starter vi med å lage treet som skal ta inn arrayet
  og da kaller vi leggInn metoden som skal sette inn alle verdiene. og da returne treet.
 