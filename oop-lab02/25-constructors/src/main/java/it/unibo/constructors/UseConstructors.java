package it.unibo.constructors;

class UseConstructors {

    public static void main(final String[] args) {
        // NB: Per verificare la correttezza dei costruttori implementati
        // stampare a video le informazioni relative agli studenti (metodo
        // printStudentInfo) e ai treni (a tal fine implementare un metodo
        // printTrainInfo nella classe Train).
        
        // 1) Creare lo studente Mario Rossi, matricola 1014, anno
        // immatricolazione 2013
        final Student studente1 = new Student("Mario", "Rossi", 1014, 2013);
        studente1.printStudentInfo();
        // 2) Creare lo studente Luca Bianchi, matricola 1018, anno
        // immatricolazione 2010
        final Student studente2 = new Student("Luca", "Bianchi", 1018, 2019);
        studente2.printStudentInfo();
        // 3) Creare lo studente Peppino Vitiello, matricola 1019, anno
        // immatricolazione 2012
        final Student studente3 = new Student("Peppino", "Vitiello", 1019, 2012);
        studente3.printStudentInfo();
        // 4) Creare lo studente Luca Verdi, matricola 1020, anno
        // immatricolazione 2013
        final Student studente4 = new Student("Luca", "Verdi", 1020, 2013);
        studente4.printStudentInfo();
        // 5) Creare un treno con 300 posti di cui 100 in prima classe 200 in
        // seconda classe
        final Train train1 = new Train(300, 100, 200);
        train1.printTrainInfo();
        // 6) Creare un treno con 1200 posti di cui 50 in prima classe 1050 in
        // seconda classe
        final Train train2 = new Train(1200, 50, 1050);
        train2.printTrainInfo();

        // 7) Creare un treno con 500 posti, tutti di seconda classe
        final Train train3 = new Train(500, 0, 500);
        train3.printTrainInfo();
        // 8) Creare un treno con numero di posti di default
        final Train train4 = new Train();
        train4.printTrainInfo();
        // 9) Verificare che il numero di posti
        // di default sia consistente (ossia che ci sia un numero positivo di
        // posti totali, e che la somma dei posti in prima e seconda classe dia
        // il totale dei posti sul treno).
        System.out.println(train4.getTotalSeats() > 0 ? "OK!" : "There is a bug.");
        System.out.println(train4.getTotalSeats() == train4.getFirstClassSeats() + train4.getSecondClassSeats() ? "OK!" : "There is a bug.");
    }
}
