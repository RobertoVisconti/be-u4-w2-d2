package entities.esercizio3;

public class Main {
    static void main(String[] args) {

        Rubrica nuovaRubrica = new Rubrica();

        // Inserisco i contatti
        nuovaRubrica.inserisciContatto("Antonio", 329876545);
        nuovaRubrica.inserisciContatto("Roberto", 345567898);
        nuovaRubrica.inserisciContatto("Alessia", 388756098);


        nuovaRubrica.cercaPersona(329876545);// si trova in rubrica
        nuovaRubrica.cercaPersona(329876542);// non si trova in rubrica

        nuovaRubrica.cercaNumero("Alessia");

        nuovaRubrica.stampaRubrica();

        nuovaRubrica.cancellaContatto("Roberto");
        nuovaRubrica.stampaRubrica();
    }
}
