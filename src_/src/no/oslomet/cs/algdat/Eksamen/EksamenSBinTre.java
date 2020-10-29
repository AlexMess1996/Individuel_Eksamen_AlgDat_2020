package no.oslomet.cs.algdat.Eksamen;


import java.util.*;


public class EksamenSBinTre<T> {


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

//Oppgave 1
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Går ikke med nullverdier");

        Node<T> p = rot, q = null;
        int cmp = 0;

        while(p != null){
            q = p;
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }

        p = new Node<>(verdi, q);

        if (q == null) {
            rot = p;
        }else if (cmp < 0){
            q.venstre = p;
        } else {
            q.høyre = p;
        }

        antall++;

        return true;

    }

    //End av Oppgave 1


    //Oppgave 2
    public int antall(T verdi) {
        Node<T> p = rot;

        int antallVerdi = 0;

        while (p != null){
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0){
                p = p.venstre;
            }else {
                if (cmp == 0){
                    antallVerdi++;
                }
                p = p.høyre;
            }
        }
        return antallVerdi;
    }
    //End av Oppgave 2

    //Oppgave 3
    private static <T> Node<T> førstePostorden(Node<T> p) {
        while (p.venstre != null || p.høyre != null){
            if (p.venstre != null){
                p = p.venstre;
            } else{
                p = p.høyre;
            }

        }

        return p;
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
       if (p.forelder == null) {
           return p;
       }

       if (p == p.forelder.høyre || p.forelder.høyre == null){
           p = p.forelder;
       }else{
           p = førstePostorden(p.forelder.høyre);
       }
       return p;
    }

    //End av Oppgave 3

    //Oppgave 6
    public boolean fjern(T verdi) {
        if(verdi == null) {
            return false;
        }

        Node<T> p = rot, q = null;

        while (p != null){
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) {
                q = p; p = p.venstre;
            }else if(cmp > 0){
                q = p;
                p = p.høyre;
            }

        }
        if (p == null) {
            return false;
        }

        if(p.venstre == null || p.høyre == null){
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;

            if (b != null) {
                b.forelder = q;
            }

            if(p == rot) {
                rot = b;
            } else if(p == q.venstre) {
                q.venstre = b;
            } else {
                q.høyre = b;
            }

        } else {
            Node<T> s = p, r = p.høyre;
            while (r.venstre != null){
                s = r;
                r = r.venstre;
            }

            p.verdi = r.verdi;

            if (r.høyre != null){
                r.høyre.forelder = s;
            }

            if(s != p) {
                s.venstre = r.høyre;
            } else {s.høyre = r.høyre;}

        }

        antall--;
        endringer++;
        return true;
    }

    public int fjernAlle(T verdi) {
        int antallFjernet = 0;

        while (fjern(verdi)) {
            antallFjernet++;
        }

        return antallFjernet;
    }



    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }
    //End av oppgave6




    public void postorden(Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


public static void main(String []args){


    /* //Oppgave1
    Integer[] a = {4,7,2,9,5,10,8,1,3,6};
    EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());
    for (int verdi : a) tre.leggInn(verdi);
    System.out.println(tre.antall());
    */

    /* //Oppgave2
    Integer[] a = {4,7,2,9,4,10,8,7,4,6};
EksamenSBinTre<Integer> tre = new EksamenSBinTre<>(Comparator.naturalOrder());
for (int verdi : a) tre.leggInn(verdi);
System.out.println(tre.antall());
System.out.println(tre.antall(5));
System.out.println(tre.antall(4));
System.out.println(tre.antall(7));
System.out.println(tre.antall(10));
    */


}

} // ObligSBinTre
