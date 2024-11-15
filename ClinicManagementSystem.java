import java.util.ArrayList;
import java.util.Scanner;

// Base class: Person
class Person {
    private String name;
    private int age;
    private String contactNumber;

    public Person(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact: " + contactNumber);
    }
}

// Derived class: Patient
class Patient extends Person {
    private String patientID;
    private String disease;

    public Patient(String name, int age, String contactNumber, String patientID, String disease) {
        super(name, age, contactNumber);
        this.patientID = patientID;
        this.disease = disease;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Patient ID: " + patientID);
        System.out.println("Disease: " + disease);
    }
}

public class ClinicManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List to store patients
        ArrayList<Patient> patients = new ArrayList<>();

        // Adding 10 patients to the dataset
        patients.add(new Patient("Deekshu", 13, "123-456-7890", "P001", "Cold"));
        patients.add(new Patient("Deepika", 15, "234-567-8901", "P002", "Heart Disease"));
        patients.add(new Patient("Dhanu", 15, "345-678-9012", "P003", "Diabetes"));
        patients.add(new Patient("Birundha", 13, "456-789-0123", "P004", "Asthma"));
        patients.add(new Patient("Harini", 12, "567-890-1234", "P005", "Flu"));
        patients.add(new Patient("Hema", 16, "678-901-2345", "P006", "Hypertension"));
        patients.add(new Patient("Aswathy", 14, "789-012-3456", "P007", "Arthritis"));
        patients.add(new Patient("Brindha", 15, "890-123-4567", "P008", "Migraine"));
        patients.add(new Patient("Divya", 15, "901-234-5678", "P009", "Back Pain"));
        patients.add(new Patient("Varshini", 13, "012-345-6789", "P010", "Cold"));

        // User interaction
        System.out.println("Welcome to the Clinic Management System");
        System.out.println("Enter a patient name to search for details:");
        String name = scanner.nextLine();

        boolean found = false;

        // Search for the patient by name
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                patient.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No patient found with the name: " + name);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}