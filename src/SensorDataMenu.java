import java.util.Scanner;
public class SensorDataMenu implements MenuInterface{

    private WeatherSensor weatherSensor;
    private SoilMoistureSensor soilMoistureSensor;

    public SensorDataMenu(WeatherSensor weatherSensor, SoilMoistureSensor soilMoistureSensor) {
        this.weatherSensor = weatherSensor;
        this.soilMoistureSensor = soilMoistureSensor;
    }

    @Override
    public void displayMenu() {
        System.out.println("===== Sensor Data Menu =====");
        System.out.println("1. Display sensor data");
        System.out.println("2. Edit sensor data");
        System.out.println("3. Return to Main Menu");
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
                    System.out.println("Weather: " + weatherSensor.readWeatherCondition());
                    System.out.println("Moisture Level: " + soilMoistureSensor.readMoisturelevel() + "%");
                    //System.out.println("Pest Threat: " + pestSensor.readPest());
                    break;
                case 2:
                    weatherSensor.editSensorData();
                    soilMoistureSensor.editSensorData();
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}