package it.unibo.constructors;

class Train {

    static final int DEFAULT_N_FC_SEATS = 50;
    static final int DEFAULT_N_SC_SEATS = 100;
    static final int DEFAULT_TOT_SEATS = 150;

    int seats;
    int firstClassSeats;
    int secondClassSeats;
    int firstClassReserved;
    int secondClassReserved;

    public Train() {
        this.seats = DEFAULT_TOT_SEATS;
        this.firstClassReserved = 10;
        this.secondClassReserved = 20;
        this.firstClassSeats = DEFAULT_N_FC_SEATS;
        this.secondClassSeats = DEFAULT_N_SC_SEATS;
    }

    public Train(final int firstClassReserved, final int secondClassReserved) {
        this(DEFAULT_TOT_SEATS, firstClassReserved, secondClassReserved);
    }

    public Train(final int seats, final int firstClassReserved, final int secondClassReserved) {
        this.seats = seats;
        this.firstClassReserved = firstClassReserved;
        this.secondClassReserved = secondClassReserved;
        this.firstClassSeats = DEFAULT_N_FC_SEATS;
        this.secondClassSeats = DEFAULT_N_SC_SEATS;
    }

    void deleteAllReservations() {
        this.firstClassReserved = 0;
        this.secondClassReserved = 0;
    }

    double getFirstClassOccupancyRatio() {
        return this.firstClassReserved * 100d / this.firstClassSeats;
    }

    int getFirstClassSeats() {
        return this.firstClassSeats;
    }

    int getSecondClassSeats() {
        return this.secondClassSeats;
    }

    double getOccupancyRatio() {
        return (this.firstClassReserved + this.secondClassReserved) * 100d / this.seats;
    }

    double getSecondClassOccupancyRatio() {
        return this.secondClassReserved * 100 / this.secondClassSeats;
    }

    int getTotalSeats() {
        return this.seats;
    }

    void printTrainInfo() {
        System.out.println("Train info:");
        System.out.println("-nTotSeats: " + this.seats);
        System.out.println("-nFCSeats: " + this.firstClassSeats);
        System.out.println("-nSCSeats: " + this.secondClassSeats);
        System.out.println("-nFCReservedSeats: " + this.firstClassReserved);
        System.out.println("-nSCReservedSeats: " + this.secondClassReserved + "\n");
    }

    void reserveFirstClassSeats(final int nSeats) {
        this.firstClassReserved += nSeats;
    }

    void reserveSecondClassSeats(final int nSeats) {
        this.secondClassReserved += nSeats;
    }
}
