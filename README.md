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