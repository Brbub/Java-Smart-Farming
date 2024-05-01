import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemInformationMenu implements MenuInterface {

    private SystemAlertsMenu systemAlertsMenu;

    public SystemInformationMenu(SystemAlertsMenu systemAlertsMenu) {
        this.systemAlertsMenu = systemAlertsMenu;
    }

    @Override
    public void displayMenu() {
        System.out.println("===== System Information Menu =====");
        System.out.println("1. View System Version");
        System.out.println("2. Check System Health");
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
                    viewSystemVersion();
                    break;
                case 2:
                    checkSystemHealth();
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

    private void viewSystemVersion() {
        System.out.println("System Version: " + "1.0.0");
    }

    private void checkSystemHealth() {
        if (systemAlertsMenu.checkForAnyAlerts()) {
            System.out.println("Attention needed. See System Alerts.");
        } else {
            System.out.println("System health is good.");
        }
    }
}