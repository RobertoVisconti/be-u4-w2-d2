package entities.esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Rubrica {

    // interfaccia
    private HashMap<String, Integer> contatti;

    //costruttore
    public Rubrica() {
        this.contatti = new HashMap<>();
    }

    // METODI

    // 1 Inserimento coppia <Nome, telefono>
    public void inserisciContatto(String nome, int telefono) {
        contatti.put(nome, Integer.valueOf(telefono));
        System.out.println("Contatto aggiunto: " + nome + " " + "Numero telefono: " + telefono);
    }

    // 2 Cancellazione coppia <Nome, telefono>
    public void cancellaContatto(String nome) {
        if (contatti.containsKey(nome)) {
            contatti.remove(nome);
            System.out.println("Contatto cancellato: " + nome);
        } else {
            System.out.println("Impossibile cancellare: " + nome + " non è in rubrica.");
        }
    }

    // 3 Ricerca persona tramite numero
    public void cercaPersona(int telefono) {
        for (Map.Entry<String, Integer> contatto : contatti.entrySet()) {
            if (contatto.getValue().equals(telefono)) {
                System.out.println("Contatto trovato, il nome della persona è: " + contatto.getKey());
                return;
            }
        }
        System.out.println("Impossibbile trovare la persona tramite: " + telefono + " perchè non è in rubrica");
    }

    // 4 Ricerca numero tramite nome
    public void cercaNumero(String nome) {
        if (contatti.containsKey(nome)) {
            System.out.println("Numero della persona trovato: " + contatti.get(nome));
        } else {
            System.out.println("Impossibile trovare il numero della persona: " + nome + " percjè la persona non è in rubrica");
        }
    }

    // 5 Stampa tutta la rubrica
    public void stampaRubrica() {
        System.out.println("***** Elenco Rubrica *****");
        if (contatti.isEmpty()) {
            System.out.println("L'elenco della rubrica è vuoto.");
        } else {
            for (Map.Entry<String, Integer> contatto : contatti.entrySet()) {
                System.out.println("Nome: " + contatto.getKey() + " | Numero di telefono: " + contatto.getValue());
            }
        }
    }
}
