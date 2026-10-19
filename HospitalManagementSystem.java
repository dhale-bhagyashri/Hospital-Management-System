
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("-------------------------");
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Patient ID already exists!");
                return;
            }
        }

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));

        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        for (Patient p : patients) {
            p.display();
        }
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Patient found!");
                p.display();
                return;
            }
        }

        System.out.println("Patient not found.");
    }
}
