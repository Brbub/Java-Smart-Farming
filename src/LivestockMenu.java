import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivestockMenu implements MenuInterface {

    private List<Livestock> livestockList;

    public LivestockMenu() {
        this.livestockList = new ArrayList<>();
    }

    public List<Livestock> getLivestockList() {
        return livestockList;
    }

    @Override
    public void displayMenu() {
        System.out.println("===== Livestock Menu =====");
        System.out.println("1. Add Livestock");
        System.out.println("2. Remove Livestock");
        System.out.println("3. Display Livestock");
        System.out.println("4. Administer Medicine to Livestock");
        System.out.println("5. Feed Livestock");
        System.out.println("6. Return to Main Menu");
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addLivestock();
                    break;
                case 2:
                    removeLivestock();
                    break;
                case 3:
                    displayLivestock();
                    break;
                case 4:
                    administerMedicine();
                    break;
                case 5:
                    feedLivestock();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addLivestock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter livestock details:");
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Is Sick (true/false): ");
        boolean isSick = scanner.nextBoolean();

        Livestock livestock = new Livestock(type, name, breed, age, isSick);
        livestockList.add(livestock);
        System.out.println("Livestock added successfully.");
    }

    private void removeLivestock() {
        if (livestockList.isEmpty()) {
            System.out.println("No livestock to remove.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the livestock to remove:");
        for (int i = 0; i < livestockList.size(); i++) {
            System.out.println((i + 1) + ". " + livestockList.get(i).getName());
        }
        int index = scanner.nextInt();
        if (index >= 1 && index <= livestockList.size()) {
            livestockList.remove(index - 1);
            System.out.println("Livestock removed successfully.");
        } else {
            System.out.println("Invalid index. No livestock removed.");
        }
    }

    private void displayLivestock() {
        if (livestockList.isEmpty()) {
            System.out.println("No livestock to display.");
            return;
        }
        for (int i = 0; i < livestockList.size(); i++) {
            System.out.println("Livestock " + (i + 1) + ":");
            livestockList.get(i).info();
            System.out.println();
        }
    }

    private void administerMedicine() {
        if (livestockList.isEmpty()) {
            System.out.println("No livestock to administer medicine to.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the livestock to administer medicine:");
        for (int i = 0; i < livestockList.size(); i++) {
            System.out.println((i + 1) + ". " + livestockList.get(i).getName());
        }
        int index = scanner.nextInt();
        if (index >= 1 && index <= livestockList.size()) {
            Livestock selectedLivestock = livestockList.get(index - 1); // Adjust index to get the correct livestock
            if (selectedLivestock.getIsSick()) {
                System.out.println("Administering Medicine to " + selectedLivestock.getName() + ".");
                selectedLivestock.setIsSick(false);
            } else {
                System.out.println(selectedLivestock.getName() + " is already healthy.");
            }
        } else {
            System.out.println("Invalid index. No livestock selected.");
        }
    }

    private void feedLivestock() {
        if (livestockList.isEmpty()) {
            System.out.println("No livestock to feed.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the livestock to feed:");
        for (int i = 0; i < livestockList.size(); i++) {
            System.out.println((i + 1) + ". " + livestockList.get(i).getName());
        }
        int index = scanner.nextInt();
        if (index >= 1 && index <= livestockList.size()) {
            Livestock selectedLivestock = livestockList.get(index - 1); // Adjust index to get the correct livestock
            if (selectedLivestock.getNeedsFood()) {
                System.out.println("Feeding " + selectedLivestock.getName() +" 1 " + selectedLivestock.getDiet() + ".");
                selectedLivestock.setNeedsFood(false);
            } else {
                System.out.println(selectedLivestock.getName() + " does not need food right now.");
            }
        } else {
            System.out.println("Invalid index. No livestock selected.");
        }
    }
}