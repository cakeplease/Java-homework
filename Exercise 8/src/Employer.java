import java.util.Calendar;
import java.util.Scanner;

public class Employer {

    private static Scanner in = new Scanner(System.in);

    private final Person Personalia;

    private int employerNr;

    private int yearOfEmployment;

    private double monthlySalary;

    private double taxRate;


    public Person getPersonalia() {
        return Personalia;
    }

    public int getEmployerNr() {
        return employerNr;
    }

    public int getYearOfEmployment() {
        return this.yearOfEmployment;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getMonthlyTaxDeduction() {
        return this.monthlySalary * (this.taxRate / 100);
    }

    public double getYearlyGrossSalary() {
        return this.monthlySalary * 12;
    }

    public double getYearlyTaxDeduction() {
        return (this.getMonthlyTaxDeduction() * 10) + (this.getMonthlyTaxDeduction() / 2);
    }

    public String getFullName() {
        return this.getPersonalia().getName()+", " + this.getPersonalia().getSurname();
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.getPersonalia().getBirthYear();
    }

    public int getYearsEmployed() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.yearOfEmployment;
    }

    public boolean checkIfEmployedMoreThan(int yearCount) {
        return this.getYearsEmployed() > yearCount;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "Personalia=" + Personalia +
                ", employerNr=" + employerNr +
                ", yearOfEmployment=" + yearOfEmployment +
                ", monthlySalary=" + monthlySalary +
                ", taxRate=" + taxRate +
                '}';
    }

    //ikke bruk system out print i annet enn main!
    public void getAll() {
        System.out.println("Navn: " + this.getFullName());
        System.out.println("Alder: " + this.getAge());
        System.out.println("Skatt per måned: " + this.getMonthlyTaxDeduction());
        System.out.println("Skatt per år: " + this.getYearlyTaxDeduction());
        System.out.println("Bruttolønn per måned: " + this.getMonthlySalary());
        System.out.println("Bruttolønn per år: " + this.getYearlyGrossSalary());
        System.out.println("År ansatt: " + this.getYearsEmployed());
        System.out.println("Ansatt mer enn 10 år: " + this.checkIfEmployedMoreThan(10));
    }

    public Employer(Person Personalia, int employerNr, int yearOfEmployment, double monthlySalary, double taxRate) {
        this.Personalia = Personalia;
        this.employerNr = employerNr;
        this.yearOfEmployment = yearOfEmployment;
        this.monthlySalary = monthlySalary;
        this.taxRate = taxRate;
    }

    public static void main(String[] args) {

        System.out.print("Skriv inn fornavn: ");
        String name = in.nextLine();
        System.out.print("Skriv inn etternavn: ");
        String surname = in.nextLine();
        System.out.print("Skriv inn fødselsår: ");
        int birthYear = in.nextInt();

        Person Person1 = new Person(name, surname, birthYear);

        System.out.print("Skriv inn arbeidstakernr: ");
        int employerNr = in.nextInt();
        System.out.print("Skriv inn ansettelsesaar: ");
        int yearOfEmployment = in.nextInt();
        System.out.print("Skriv inn månedslønn: ");
        double monthlySalary = in.nextDouble();
        System.out.print("Skriv inn skatteprosent: ");
        double taxRate = in.nextDouble();

        Employer Employer1 = new Employer(Person1, employerNr, yearOfEmployment, monthlySalary, taxRate);

        Employer1.getAll();

        while (true) {
            System.out.println("Tast 1 for å endre månedslønnen");
            System.out.println("Tast 2 for å endre skatteprosenten");
            System.out.println("Tast 3 for å skrive ut all data");

            int menuInput = in.nextInt();

            switch (menuInput) {
                case 1:
                    System.out.print("Skriv inn ny månedslønn: ");
                    double newSalary = in.nextDouble();
                    Employer1.setMonthlySalary(newSalary);
                    System.out.println("Ny registrert månedslønn er: " + Employer1.getMonthlySalary());
                    break;

                case 2:
                    System.out.print("Skriv inn ny skatteprosent: ");
                    double newTaxRate = in.nextDouble();
                    Employer1.setTaxRate(newTaxRate);
                    System.out.println("Ny registrert skatteprosent er: " + Employer1.getTaxRate());
                    break;

                case 3:
                    Employer1.getAll();
            }
        }
    }

}
