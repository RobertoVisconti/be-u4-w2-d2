package entities.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esercizio1 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Inserisci il numero di parole che vuoi inserire *****");
        int numeroParole = Integer.parseInt(scanner.nextLine());

        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();

        System.out.println(" Inserisci le" + " " + numeroParole + " " + "parole:");
        for (int i = 0; i < numeroParole; i++) {
            System.out.println("Parola" + " " + (i + 1) + ":");
            String parola = scanner.nextLine();

            if (!paroleDistinte.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }

        System.out.println("Parole duplicate:" + " " + paroleDuplicate);
        System.out.println("Il numero di parole distinte é :" + " " + paroleDistinte.size());
        System.out.println("Elenco delle parole distinte:" + " " + paroleDistinte);

    }
}
