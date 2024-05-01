import java.util.Scanner;

public class IrrigationMenu implements MenuInterface {

    private SmartIrrigationSystem smartSystem;
    private boolean addedIrrigationSystem = false;
    private WeatherSensor weatherSensor;
    private SoilMoistureSensor soilMoistureSensor;
    private CropMenu cropMenu;

    public IrrigationMenu(WeatherSensor weatherSensor, SoilMoistureSensor soilMoistureSensor, CropMenu cropMenu) {
        this.weatherSensor = weatherSensor;
        this.soilMoistureSensor = soilMoistureSensor;
        this.cropMenu = cropMenu;
    }

    @Override
    public void displayMenu() {
        System.out.println("===== Irrigation Menu =====");
        System.out.println("1. Add an irrigation method");
        System.out.println("2. Change irrigation method");
        System.out.println("3. Display irrigation information");
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
                    addIrrigationMethod();
                    break;
                case 2:
                    changeIrrigationMethod();
                    break;
                case 3:
                    displayIrrigationInfo();
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

    private void addIrrigationMethod() {
        // Implement logic to add an irrigation method to the smart system
        // For example:
        // smartSystem.addIrrigationMethod();
        if(addedIrrigationSystem){
            System.out.println("Already Added An Irrigation System, please use change irrigation system");
        }else{
            this.smartSystem = new SmartIrrigationSystem(this.soilMoistureSensor, this.weatherSensor, this.cropMenu);
            System.out.println("Irrigation method added successfully.");
        }

    }

    private void changeIrrigationMethod() {
        this.smartSystem = new SmartIrrigationSystem(this.soilMoistureSensor, this.weatherSensor, this.cropMenu);
        System.out.println("Irrigation method changed successfully.");
    }

    private void displayIrrigationInfo() {
        // Implement logic to display irrigation information from the smart system
        // For example:
        // smartSystem.displayIrrigationInfo();
        System.out.println("Irrigation information:");
        if (cropMenu.getCrops().isEmpty()) {
            System.out.println("No crops added.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the crop to remove:");
        for (int i = 0; i < cropMenu.getCrops().size(); i++) {
            smartSystem.irrigate(cropMenu.getCrops().get(i));
        }





        // Display irrigation information here
    }
    public double calculateWaterNeeded(){
        return smartSystem.calculateTotalWaterNeeded();
    }
}
