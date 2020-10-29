package no.oslomet.cs.algdat.Eksamen;


import java.util.*;

public class EksamenSBinTre<T> implements EksamenSBinTr {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }


    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        // skal ligge i class SBinTre
        //etter at jeg kopirte koden fra5.2.4a og fikk forklart at p starter i roten og q er forelder til p

        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte
        // her når vi oppretter en ny node med verdi så får vi feil melding
        //men grunnen til at q skal være er att q er den forelder til p
        p = new Node<>(verdi, q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q
        //og her så må vi øke endringen

        endringer++;
        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }


    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");

    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        //her så starter vi med å si at hvis verdien er null så returner 0
        if (verdi.equals(null))
            return 0;
        //her så starter forekomsteren fra 0 og skal øke etterhvert
        int forekomsteren = 0;
        //her sier vi at Node p er lik rota;
        Node<T> p = rot;
        //her så sier jeg at p er ikke null
        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            //her så sier jeg når cmp er mindre enn 0 så skal den gå til venstre
            if (cmp < 0)
                p = p.venstre;
            else {
                if (cmp == 0)
                    forekomsteren++;
                p = p.høyre;
            }
        }
        return forekomsteren;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        //her så mener vi at p er null
        if (p == null)
            p = null;
        //på nesten samme måten i eksemplet 5.1.7 h bruker vi whil-løkke for å sjekke
        while (true) {
            if (p.venstre != null)
                p = p.venstre;

            else if (p.høyre != null)
                p = p.høyre;

            else return p;
        }

    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        //her så sier vi at p er lik null
        if (p == null)
            throw new NoSuchElementException("treet er tom");

            //her så sjekker jeg om at p ikke har en forelder
        else if (p.forelder == null)
            p = null;
            //her er alle tilfellene

        else if (p == p.forelder.høyre)
            p = p.forelder;

        else if (p == p.forelder.venstre){
            if (p.forelder.høyre==null)

            p = p.forelder;

        else p = førstePostorden(p.forelder.høyre);

    }
        return p;
}

    public void postorden(Oppgave<? super T> oppgave) {
      //  throw new UnsupportedOperationException("Ikke kodet ennå!");
        if (tom()) return;    // sjekker om Treet er tomt

        //den første i postorden
        Node<T> p = førstePostorden(rot);

            //på samme måte som eksemplet 5.1.7c
        while (p != null) {

            oppgave.utførOppgave(p.verdi);

            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        // jeg kopirte koden fra ukesoppgave avsnitt 5.1.7 oppgave 7
        if (p.venstre != null) postordenRecursive(p.venstre, oppgave); //til venstre barn
        if (p.høyre != null) postordenRecursive(p.høyre, oppgave); //til høyre barn
        oppgave.utførOppgave(p.verdi); // denne her skal utføre oppgaven
    }

    public ArrayList<T> serialize() {
        // throw new UnsupportedOperationException("Ikke kodet ennå!");
        //kildenkoden er vidioen uke 09 level order:)
        //her så lager vi arrayet vårt
         ArrayList<T> array = new ArrayList<>();
        ArrayDeque<Node<T>> queue = new ArrayDeque<Node<T>>();

        //legg til rot-noden
        queue.addLast(rot);

        while (!queue.isEmpty()) {
            //1- ta ut først fra køen
            Node<T> current = queue.removeFirst();

            //2- legg til current sine  to barn til køen
            if (current.venstre != null) {
                queue.addLast(current.venstre);
            }
            if (current.høyre != null) {
                queue.addLast(current.høyre);
            }
            //3- her så skal vi adde til array current og verdien. og return array
            array.add(current.verdi);

        }
        return array;
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");

    }


} // ObligSBinTre
