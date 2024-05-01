import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SystemAlertsMenu implements MenuInterface {
    private List<Crop> crops;
    private List<Livestock> livestock;

    public SystemAlertsMenu(List<Crop> crops, List<Livestock> livestock) {
        this.crops = crops;
        this.livestock = livestock;
    }

    @Override
    public void displayMenu() {
        System.out.println("===== System Alerts Menu =====");
        System.out.println("1. Check Crop Alerts");
        System.out.println("2. Check Livestock Alerts");
        System.out.println("3. Back to Main Menu");
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkCropAlerts();
                    break;
                case 2:
                    checkLivestockAlerts();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void checkCropAlerts() {
        System.out.println("===== Crop Alerts =====");
        for (Crop crop : crops) {
            if (crop.getNeedsWater()) {
                System.out.println("Crop '" + crop.getName() + "' needs watering.");
            }
            if (crop.getNeedsFertilizer()) {
                System.out.println("Crop '" + crop.getName() + "' needs fertilizing.");
            }
        }
    }

    private void checkLivestockAlerts() {
        System.out.println("===== Livestock Alerts =====");
        for (Livestock animal : livestock) {
            if (animal.getIsSick()) {
                System.out.println("Animal '" + animal.getName() + "' needs medicine.");
            }
            if (animal.getNeedsFood()) {
                System.out.println("Animal '" + animal.getName() + "' needs food.");
            }
        }
    }

    public boolean checkForAnyAlerts() {
        boolean anyAlerts = false;
        for (Crop crop : crops) {
            if (crop.getNeedsWater() || crop.getNeedsFertilizer()) {
                anyAlerts = true;
                break;
            }
        }
        for (Livestock animal : livestock) {
            if (animal.getIsSick() || animal.getNeedsFood()) {
                anyAlerts = true;
                break;
            }
        }
        return anyAlerts;
    }

}