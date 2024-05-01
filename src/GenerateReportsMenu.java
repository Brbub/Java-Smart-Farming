import java.util.Scanner;
public class GenerateReportsMenu implements MenuInterface {
    private IrrigationMenu irrigationMenu;
    private CropMenu cropMenu;
    private LivestockMenu livestockMenu;
    GenerateReportsMenu(IrrigationMenu irrigationMenu, CropMenu cropMenu, LivestockMenu livestockMenu){
        this.irrigationMenu = irrigationMenu;
        this.cropMenu = cropMenu;
        this.livestockMenu = livestockMenu;
    }

    @Override
    public void displayMenu() {
        System.out.println("===== Generate Reports Menu =====");
        System.out.println("1. Water and Energy Usage Optimization");
        System.out.println("2. Waste Management");
        System.out.println("3. Carbon Footprint Reduction");
        System.out.println("4. Back to Main Menu");
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    waterAndEnergyUsageOptimization();
                    break;
                case 2:
                    wasteManagement();
                    break;
                case 3:
                    carbonFootprintReduction();
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void waterAndEnergyUsageOptimization() {
        // Implementation for water and energy usage optimization
        System.out.println("Water and Energy Usage Optimization Report");
        System.out.println("Water Used Today: " + irrigationMenu.calculateWaterNeeded() + "gal");
        System.out.println("Electricity Used Today: " + irrigationMenu.calculateWaterNeeded()/20 + "kWh");

    }

    private void wasteManagement() {
        System.out.println("Waste Management Report");
        boolean anyCropsToRecycle = false;
        for (Crop crop : cropMenu.getCrops()) {
            if (crop.getGrowthStage() > 5) {
                anyCropsToRecycle = true;
                break;
            }
        }
        if (anyCropsToRecycle) {
            System.out.println("Some crops need to be recycled.");
        } else {
            System.out.println("No crops need to be recycled.");
        }
    }

    private void carbonFootprintReduction() {
        System.out.println("Carbon Footprint Reduction Report");
        int totalCrops = cropMenu.getCrops().size();
        int totalLivestock = livestockMenu.getLivestockList().size();
        if (totalLivestock > totalCrops) {
            System.out.println("You have too many livestock. Consider reducing to maintain an eco-friendly balance.");
        } else {
            System.out.println("Everything seems environmentally friendly.");
        }
    }
}