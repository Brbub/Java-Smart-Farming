import java.util.Scanner;
public class MainMenu implements MenuInterface{
    //private SmartIrrigationSystem smartSystem;
    private CropMenu cropMenu;
    private IrrigationMenu irrigationMenu;
    private SensorDataMenu sensorDataMenu;
    private WeatherSensor weatherSensor;
    private SoilMoistureSensor soilMoistureSensor;
    private LivestockMenu livestockMenu;
    private SystemAlertsMenu systemAlertsMenu;
    private GenerateReportsMenu generateReportsMenu;
    private SystemInformationMenu systemInformationMenu;


    public MainMenu() {
        weatherSensor = new WeatherSensor();
        soilMoistureSensor = new SoilMoistureSensor();
        this.cropMenu = new CropMenu();
        this.irrigationMenu = new IrrigationMenu(weatherSensor, soilMoistureSensor, cropMenu);
        this.sensorDataMenu = new SensorDataMenu(weatherSensor,soilMoistureSensor);
        this.livestockMenu = new LivestockMenu();
        this.systemAlertsMenu = new SystemAlertsMenu(cropMenu.getCropList(), livestockMenu.getLivestockList());
        this.systemInformationMenu = new SystemInformationMenu(systemAlertsMenu);
        this.generateReportsMenu = new GenerateReportsMenu(irrigationMenu,cropMenu,livestockMenu);

    }

    @Override
    public void displayMenu() {
        System.out.println("===== Smart Farming Menu =====");
        System.out.println("1. View/Edit Sensor Data");
        System.out.println("2. Configure Crop Settings");
        System.out.println("3. Configure Irrigation Settings");
        System.out.println("4. Manage Livestock");
        System.out.println("5. System Alerts");
        System.out.println("6. Generate Reports");
        System.out.println("7. System Health/Information");
        System.out.println("8. Exit");


    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 8) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sensorDataMenu.startMenu();
                    break;
                case 2:
                    cropMenu.startMenu();
                    break;

                    case 3:
                    irrigationMenu.startMenu();
                    break;

                case 4:
                    livestockMenu.startMenu();
                    break;

                case 5:
                    systemAlertsMenu.startMenu();
                    break;

                case 6:
                    generateReportsMenu.startMenu();
                    break;
                case 7:
                    systemInformationMenu.startMenu();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;


            }
        }
        scanner.close();
    }
}




