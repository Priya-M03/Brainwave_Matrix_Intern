import java.util.*;

public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<MedicalRecord> records = new ArrayList<>();
    static Map<String, Integer> inventory = new HashMap<>();
    static List<Staff> staffList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Patient Registration");
            System.out.println("2. Appointment Scheduling");
            System.out.println("3. Electronic Health Records");
            System.out.println("4. Billing and Invoicing");
            System.out.println("5. Inventory Management");
            System.out.println("6. Staff Management");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> scheduleAppointment();
                case 3 -> manageHealthRecords();
                case 4 -> generateBill();
                case 5 -> manageInventory();
                case 6 -> manageStaff();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    // ---------------------- MODULES ----------------------

    static void registerPatient() {
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        patients.add(new Patient(name, age, gender));
        System.out.println("Patient registered successfully!");
    }

    static void scheduleAppointment() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Appointment Date (dd-mm-yyyy): ");
        String date = sc.nextLine();
        appointments.add(new Appointment(name, doctor, date));
        System.out.println("Appointment scheduled successfully!");
    }

    static void manageHealthRecords() {
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();
        records.add(new MedicalRecord(name, diagnosis, treatment));
        System.out.println("Record added.");

        System.out.println("\n--- Medical Records ---");
        for (MedicalRecord r : records) {
            System.out.println(r);
        }
    }

    static void generateBill() {
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Services Used: ");
        String services = sc.nextLine();
        System.out.print("Enter Amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("\n--- BILL RECEIPT ---");
        System.out.println("Patient: " + name);
        System.out.println("Services: " + services);
        System.out.println("Total Amount: ₹" + amount);
        System.out.println("----------------------");
    }

    static void manageInventory() {
        System.out.println("1. Add Item\n2. View Inventory");
        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            System.out.print("Enter Item Name: ");
            String item = sc.nextLine();
            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            inventory.put(item, inventory.getOrDefault(item, 0) + qty);
            System.out.println("Item added.");
        } else {
            System.out.println("\n--- Inventory List ---");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    static void manageStaff() {
        System.out.print("Enter Staff Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Role: ");
        String role = sc.nextLine();
        staffList.add(new Staff(name, role));
        System.out.println("Staff member added.");

        System.out.println("\n--- Staff List ---");
        for (Staff s : staffList) {
            System.out.println(s);
        }
    }

    // ---------------------- CLASSES ----------------------

    static class Patient {
        String name;
        int age;
        String gender;

        Patient(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String toString() {
            return name + " (" + gender + ", " + age + " years)";
        }
    }

    static class Appointment {
        String patientName;
        String doctor;
        String date;

        Appointment(String patientName, String doctor, String date) {
            this.patientName = patientName;
            this.doctor = doctor;
            this.date = date;
        }

        public String toString() {
            return "Appointment: " + patientName + " with Dr. " + doctor + " on " + date;
        }
    }

    static class MedicalRecord {
        String patientName;
        String diagnosis;
        String treatment;

        MedicalRecord(String patientName, String diagnosis, String treatment) {
            this.patientName = patientName;
            this.diagnosis = diagnosis;
            this.treatment = treatment;
        }

        public String toString() {
            return patientName + " | Diagnosis: " + diagnosis + " | Treatment: " + treatment;
        }
    }

    static class Staff {
        String name;
        String role;

        Staff(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String toString() {
            return name + " - " + role;
        }
    }
}
