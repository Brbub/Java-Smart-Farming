import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CropMenu implements MenuInterface{

    private List<Crop> crops;

    public CropMenu() {
        this.crops = new ArrayList<>();
    }
    public List<Crop> getCropList(){
        return crops;
    }

    @Override
    public void displayMenu() {
        System.out.println("===== Crop Menu =====");
        System.out.println("1. Add a new crop");
        System.out.println("2. Remove a crop");
        System.out.println("3. Display information for a crop");
        System.out.println("4. Water crops");
        System.out.println("5. Fertilize crops");
        System.out.println("6. Back to Main Menu");
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
                    addCrop();
                    break;
                case 2:
                    removeCrop();
                    break;
                case 3:
                    displayCropInfo();
                    break;
                case 4:
                    waterCrops();
                    break;
                case 5:
                    fertilizeCrops();
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
    public List<Crop> getCrops(){
        return crops;
    }
    private void addCrop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter crop details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Growth Stage: ");
        int growthStage = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nutrient Requirements: ");
        String nutrientRequirements = scanner.nextLine();
        System.out.print("Susceptibility to Diseases: ");
        String susceptibilityToDiseases = scanner.nextLine();
        System.out.print("Crop Water Requirement: ");
        double cropWaterRequirement = scanner.nextDouble();

        Crop crop = new Crop(name, growthStage, nutrientRequirements, susceptibilityToDiseases, cropWaterRequirement);
        crops.add(crop);
        System.out.println("Crop added successfully.");
    }

    private void removeCrop() {
        if (crops.isEmpty()) {
            System.out.println("No crops to remove.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the crop to remove:");
        for (int i = 0; i < crops.size(); i++) {
            System.out.println((i + 1) + ". " + crops.get(i).getName());
        }
        int index = scanner.nextInt();
        if (index >= 1 && index <= crops.size()) {
            crops.remove(index - 1);
            System.out.println("Crop removed successfully.");
        } else {
            System.out.println("Invalid index. No crop removed.");
        }
    }

    private void displayCropInfo() {
        if (crops.isEmpty()) {
            System.out.println("No crops to display information for.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the crop to display information for:");
        for (int i = 0; i < crops.size(); i++) {
            System.out.println((i + 1) + ". " );
            crops.get(i).printInfo();
        }
        int index = scanner.nextInt();
        if (index >= 1 && index <= crops.size()) {
            Crop crop = crops.get(index - 1);
            crop.printInfo();
        } else {
            System.out.println("Invalid index. No crop information displayed.");
        }
    }
    private void waterCrops() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a crop to water:");
        for (int i = 0; i < crops.size(); i++) {
            System.out.println((i + 1) + ". " + crops.get(i).getName());
        }
        int index = scanner.nextInt();
        if (index >= 1 && index <= crops.size()) {
            Crop crop = crops.get(index - 1);
            crop.setNeedsWater(false);
            System.out.println("Watering crop: " + crop.getName());
        } else {
            System.out.println("Invalid index. No crop watered.");
        }
    }

    private void fertilizeCrops() {
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a crop to fertilize:");
            for (int i = 0; i < crops.size(); i++) {
                System.out.println((i + 1) + ". " + crops.get(i).getName());
            }
            int index = scanner.nextInt();
            if (index >= 1 && index <= crops.size()) {
                Crop crop = crops.get(index - 1);
                crop.setNeedsFertiliser(false);
                System.out.println("Fertilizing crop: " + crop.getName());
            } else {
                System.out.println("Invalid index. No crop fertilized.");
            }
        }
    }


}
