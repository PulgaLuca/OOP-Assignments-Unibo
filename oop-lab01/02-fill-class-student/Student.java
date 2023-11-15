class Student {

    // È buona pratica mettere i campi in testa alla classe
    private String name;
    private String surname;
    private int id;
    private int matriculationYear;

    void build(String name, String surname, int id, int matriculationYear) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        System.out.println("Name: " + name + ", surname: " + surname + ", id: " + id + ", anno matricola: " + matriculationYear);
    }
}
