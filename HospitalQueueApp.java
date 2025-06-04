import java.util.Scanner;

// Node representing a patient
class PatientNode {
    String name;
    int age;
    String issue;
    PatientNode next;

    public PatientNode(String name, int age, String issue) {
        this.name = name;
        this.age = age;
        this.issue = issue;
        this.next = null;
    }
}

// Queue implementation using linked list
class PatientQueue {
    private PatientNode front, rear;

    public PatientQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue
    public void registerPatient(String name, int age, String issue) {
        PatientNode newPatient = new PatientNode(name, age, issue);
        if (rear == null) {
            front = rear = newPatient;
        } else {
            rear.next = newPatient;
            rear = newPatient;
        }
        System.out.println("Patient " + name + " registered.");
    }

    // Dequeue
    public void servePatient() {
        if (isEmpty()) {
            System.out.println("No patients to serve.");
            return;
        }
        System.out.println("Serving patient: " + front.name + " (Issue: " + front.issue + ")");
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    // Peek front
    public void nextPatient() {
        if (isEmpty()) {
            System.out.println("No patients in queue.");
        } else {
            System.out.println("Next patient: " + front.name + " (Issue: " + front.issue + ")");
        }
    }

    // Display all patients
    public void showAllPatients() {
        if (isEmpty()) {
            System.out.println("No patients in the queue.");
            return;
        }

        PatientNode temp = front;
        System.out.println("\n-- Patient Queue --");
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Age: " + temp.age + ", Issue: " + temp.issue);
            temp = temp.next;
        }
    }
}

public class HospitalQueueApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientQueue queue = new PatientQueue();
        int choice;

        do {
            System.out.println("\n=== Hospital Patient Queue System ===");
            System.out.println("1. Register New Patient");
            System.out.println("2. Serve Next Patient");
            System.out.println("3. View Next Patient");
            System.out.println("4. Show All Patients");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient's name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter issue: ");
                    String issue = sc.nextLine();
                    queue.registerPatient(name, age, issue);
                    break;

                case 2:
                    queue.servePatient();
                    break;

                case 3:
                    queue.nextPatient();
                    break;

                case 4:
                    queue.showAllPatients();
                    break;

                case 5:
                    System.out.println("Exiting... Stay healthy!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 5);

        sc.close();
    }
}
