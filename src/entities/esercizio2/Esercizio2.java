package entities.esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Esercizio2 {
    static void main(String[] args) {

        System.out.println("***** Genero lista *****");
        List<Integer> lista1 = generaListaOrdinata(10);
        System.out.println("Lista Ordinata :" + " " + lista1);

        System.out.println("***** Lista Inversa *****");
        List<Integer> listaInvertita = generaListaInversa(lista1);
        System.out.println("Lista Ordinata e Invertita:" + " " + listaInvertita);

        System.out.println("***** Posizioni Pari e Dispari *****");
        System.out.println("***Posizioni Pari***");
        stampaPosizioni(listaInvertita, true);
        System.out.println("***Posizioni Dispari***");
        stampaPosizioni(listaInvertita, false);
    }


    //METODI

    // Metodo genera lista ordinata
    public static List<Integer> generaListaOrdinata(int n) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            lista.add(random.nextInt(101));
        }

        Collections.sort(lista);

        return lista;
    }

    // Metodo inverti ordine lista ordinata
    public static List<Integer> generaListaInversa(List<Integer> listaOrdinata) {

        // copio la lista generata in precedenza
        List<Integer> nuovaLista = new ArrayList<>(listaOrdinata);

        // inverto la lista copiata
        List<Integer> listaInversa = new ArrayList<>(listaOrdinata);
        Collections.reverse(listaInversa);

        // alla lista copiata gli aggiungo la lista inversa
        nuovaLista.addAll(listaInversa);

        return nuovaLista;

    }

    // Metodo Posizioni Pari e Dispari
    public static void stampaPosizioni(List<Integer> lista, boolean stampa) {

        int indice = stampa ? 0 : 1; // 0 (true) per i pari, 1 (false) per i dispari

        System.out.print("[ ");
        for (int i = indice; i < lista.size(); i += 2) {
            System.out.print("L'indice " + i + ": " + lista.get(i) + ", ");
        }
        System.out.println("]");
    }

}
