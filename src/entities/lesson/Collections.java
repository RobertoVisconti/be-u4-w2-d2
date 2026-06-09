package entities.lesson;

// una sotto interfaccia di List

import java.util.*;

public class Collections {
    static void main(String[] args) {
        User aldo = new User("Giovanni", "Baglio");
        User giovanni = new User("Giovanni", "Storti");
        User giacomo = new User("Giacomo", "Poretti");

        // I generici funzionano come TS, ovvero che sono riutilizzabili e flessibili
        ArrayList<User> usersList = new ArrayList<>();

        // .size() grandezza dell'array dinamica, più si riempie ovvero aumenta la lunghezza, più perde prestazioni
        System.out.println("La lista ha:" + usersList.size() + "elementi");
        // .add() aggiunge elementi all'array, quando aggiunge un nuovo elemento, elimina il vecchio array e ne crea uno nuovo
        usersList.add(aldo);
        usersList.add(1, giovanni); // .add() con l index, puoi specificare la posizione in cui metterlo
        // addFirst lo inserisce come prima posizione
        usersList.addFirst(giacomo);

        System.out.println("La lista ha:" + usersList.size() + "elementi");
        System.out.println(usersList);

        // ciclo for per stampa
        for (User user : usersList) {
            System.out.println(user);
        }


        // *************************** METODO GET ******************************

        try {
            User fromList = usersList.get(2); // dobbiamo solo stare attenti alla posizione che inseriamo dentro
            System.out.println(fromList);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }


        // *************************** METODO INDEX OF ******************************

        // stampo il numero della posizione dell'oggetto
        int index = usersList.indexOf(aldo);
        System.out.println("L'indice dell' oggetto è :" + " " + index);

        // *************************** METODO CONTAINS ******************************

        // contains() torna un booleano

        // dietro le quinte utilizza il metodo equals, quindi se non facciamo l override di questo metodo ritornerà true,
        // altrimenti false.


        // ci dice se l oggetto è nell array o meno
        if (usersList.contains(giovanni)) {
            System.out.println("Giovanni è nella lista");
        } else {
            System.out.println("Giovanni non è all'interno della lista");
        }


        // *************************** METODO REMOVE ******************************

        // rimuove l'oggetto dalla lista tramite index, ma non elimina l oggetto
        usersList.remove(1);
        // rimuove l'oggetto dalla lista tramite il nome dell oggetto, ma non elimina l oggetto
        usersList.remove(giacomo);
        usersList.removeLast();
        System.out.println(usersList);


        // *************************** INIZIALIZZAZIONE CON ELEMENTI ******************************

        // Inizializziamo la lista con tre elementi ( passiamo una lista come parametro)
        ArrayList<User> userList2 = new ArrayList<>(List.of(aldo, giovanni, giacomo));
        // Inizializziamo la lista con tre elementi ( passiamo un array convertito in lista come parametro)
        ArrayList<User> userList3 = new ArrayList<>(Arrays.asList(aldo, giovanni, giacomo));


        // *************************** METODO ADD ALL ******************************

        //mi aggiunge tutta la lista all'array
        usersList.addAll(userList2);
        usersList.addAll(userList3);

        // *************************** METODO REMOVE ALL ******************************

        // non svuota l intera lista, ma la specifica lista che gli ho passato
        usersList.removeAll(userList2);

        System.out.println(usersList);


        // *************************** METODO SET ******************************

        usersList.add(aldo);
        System.out.println(usersList);

        // il SET và a sovrascrivere un elemento, in quella posizione specifica con il secondo parametro
        // bisogna stare attenti sempre all index che s inserisce
        usersList.set(0, new User("Roberto", "Franki"));
        System.out.println(usersList);


        // *************************** METODO CLEAR o ISEMPTY ******************************

        System.out.println("La lista è vuota?" + usersList.isEmpty());
        usersList.clear();
        System.out.println("La lista è vuota ?" + usersList.isEmpty());
        System.out.println("la lista ha" + usersList.size() + "elementi");

        //prova rottura codice ( scoprire se si da l indice che indice ti dà la lista
        User[] listaUtenti = new User[5];

        User alessia = new User("Alessia", "Alice");
        User rob = new User("Rob", "Bob");
        User emanuela = new User("Emanuela", "Frappi");
        User anto = new User("Anto", "Charlie");
        User riccardo = new User("Riccardo", "Di giovanni");

        listaUtenti[1] = alessia;
        listaUtenti[2] = rob;
        listaUtenti[0] = anto;
        listaUtenti[4] = emanuela;
        listaUtenti[3] = riccardo;

        ArrayList<User> userList4 = new ArrayList<>(Arrays.asList(listaUtenti));
        System.out.println(userList4);

        int indice = userList4.indexOf(emanuela);
        System.out.println(indice);

        // ********************** LINKED LIST *************************

        List<User> userList5 = new LinkedList<>();
        // questa tecnica di dichiarare List a sx dell uguale ( invece di Array o Linked List)
        // mi consente in un futuro di poter agilmente sostituire una Linked con un Array o viceversa in maniera semplice.
        // utilizzo questa tecnica che mi basteranno i metodi in comune tra le due sotto interfacce.
        // se invece so per certo che avrò bisogno di metodi specifici di una delle due interfacce non potrò usare questa pro tips(tecnica).


        // ********************** COLLECTIONS & TIPI PRIMITIVI *************************

        ArrayList<Integer> interi = new ArrayList<>();
        // Ogni tipo primitivo ha una sua classe corrispondente chiamata WRAPPER CLASSES
        // int -> Integer
        // double -> Double
        // long -> Long
        // boolean -> Boolean

        // ********************** INTERFACCIA SET *************************

        // i SET sono degli insieme di dati in cui NON SONO AMMESSI DUPLICATI
        // Questa caratteristica nasconde un costo computazionale importante. Ogniqualvolta useremo il metodo per aggiungere elementi
        // esso dietro le quinte dovrà andare a controllare ELEMENTO PER ELEMENTO se il nuovo elemento è già presente.
        // Se abbiamo tanti elementi il costo è estremamente alto.

        HashSet<User> userSet = new HashSet<>();
        // HashSet è il SET più comune ma non garantisce di mantenere l'ordinamento dei dati in base all'inserimento ma è rapido
        // LinkedHasSet è un pò più lento di sopra ma mantiene l'ordinamento dei dati in base all'inserimento
        // TreeSet è molto più lento degli altri perchè oltre a non ammettere duplicati, ad ogni aggiunta ri-ordina tutti gli elementi in base a un criterio di tipo numerico o meno


        // Non è che sia vietato aggiungere 2 volte lo stesso elemento, il metodo mi torna un booleano che mi dità se è riuscito ad aggiungere o meno l elemento
        System.out.println(userSet.add(aldo)); // TRUE
        System.out.println(userSet.add(giovanni)); // TRUE
        System.out.println(userSet.add(giacomo)); // TRUE
        System.out.println(userSet.add(aldo)); // FALSE

        System.out.println(userSet);


        // ********************** INTERFACCIA MAP *************************

        // noi andremo ad utilizzare le HashMap che sono le più utilizzate e veloci
        // devo dichiarare sempre prima il tipo di chiave e poi il tipo di valore

        HashMap<String, String> dictionary = new HashMap<>();

        HashMap<Integer, User> userMap = new HashMap<>();

        //******************************** aggiunta elementi **********************

        dictionary.put("Albero", "Definizione di albero");
        dictionary.put("Casa", "Definizione di casa");
        dictionary.put("Pranzo", "Definizione di pranzo");

        System.out.println(dictionary);


        userMap.put(123212, giovanni);
        userMap.put(23234, giovanni);

        // se specifico una chiave già esistente mi rimpiazza il precedente valore
        userMap.put(123212, aldo);

        System.out.println(userMap);

        //******************************** lettura elementi **********************

        String treeDefinition = dictionary.get("Albero");
        System.out.println(treeDefinition);

        String treeDefinition1 = dictionary.get("Alberoooo"); // un controllo se torna Null con un if
        System.out.println(treeDefinition1);

        //******************************** rimozione elementi **********************

        dictionary.remove("Casa");
        System.out.println(dictionary);

        //******************************** ITERARE IL MAPS **********************

        // 1 ottenere l'elenco delle chiavi
        // 2 itero quell'elenco per accedere ad ogni elemento

        Set<String> setChiavi = dictionary.keySet();

        for (String chiave : setChiavi) {
            System.out.println("Chiave:" + chiave);
            System.out.println("Valore:" + dictionary.get(chiave));
        }

        // ****************** VALUES **********

        // per ottenere solo i valori delle chiavi
        Collection<String> values = dictionary.values();
        System.out.println(values);

    }


}
