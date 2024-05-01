import java.util.Scanner;

public class SmartIrrigationSystem {

    private SoilMoistureSensor soilMoistureSensor;
    private WeatherSensor weatherSensor;
    private IrrigationStrategy irrigationStrategy;
    private CropMenu cropMenu;



    public SmartIrrigationSystem(SoilMoistureSensor soilMoistureSensor, WeatherSensor weatherSensor, CropMenu cropMenu) {
        // Initialize sensors and default irrigation strategy
        this.soilMoistureSensor = soilMoistureSensor;
        this.weatherSensor = weatherSensor;
        this.cropMenu = cropMenu;
        double moisture;
        String weather;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter A Soil Type: ");
        String soil = scanner.nextLine();
        System.out.println("Please Enter A Topography Type: ");
        String topo = scanner.nextLine();

        if(considerSoilTypeAndTopography(soil, topo).equals("basic")){
            irrigationStrategy = new BasicIrrigationStrategy();
        }
        else{
            irrigationStrategy = new AdvancedIrrigationStrategy();
        }
    }

    public String considerSoilTypeAndTopography(String soilType, String topography) {
        // Simulated inputs for soil type and topography
        /*
        String soilType = "Loam"; // Example soil type
        String topography = "Flat"; // Example topography
        */
        // Adjust irrigation strategy based on soil type and topography
        if (soilType.equals("Loam") && topography.equals("Flat")) {
            System.out.println("Using standard irrigation strategy for loamy soil on flat terrain.");
            return("basic");
        } else if (soilType.equals("Clay") && topography.equals("Sloped")) {
            System.out.println("Applying special irrigation strategy for clayey soil on sloped terrain.");
            return("advanced");
        } else {
            System.out.println("Using default irrigation strategy.");
            return("basic");
        }
    }


    // Method to invoke irrigation strategy
    public void irrigate(Crop crop) {
        // Determine irrigation amount based on sensor data
        double moistureLevel = soilMoistureSensor.readMoisturelevel();
        String weatherCondition = weatherSensor.readWeatherCondition();
        int irrigationAmount = irrigationStrategy.determineIrrigationAmount(moistureLevel, weatherCondition, crop.getCropWaterRequirement());

        if(irrigationAmount > 0){
            crop.setNeedsWater(true);
        }
        // Output the irrigation amount
        System.out.println("Irrigation amount determined: " + irrigationAmount + " gals");

        // Schedule irrigation
        //Prompts user for specific times if advanced otherwise it states standard times
        irrigationStrategy.scheduleIrrigation();
    }

    public static void monitorCropHealth(Crop crop){
        crop.printInfo();
    }

    public void viewSensorData(){
        System.out.println();
        System.out.println("Moisture Level: " + soilMoistureSensor.readMoisturelevel() + "%");
        System.out.println("Weather Type: " + weatherSensor.readWeatherCondition());
        System.out.println();
    }

    public double calculateTotalWaterNeeded() {
        double totalWaterNeeded = 0.0;
        double moistureLevel = soilMoistureSensor.readMoisturelevel();
        String weatherCondition = weatherSensor.readWeatherCondition();
        for (Crop crop : this.cropMenu.getCrops()) {
            double x = irrigationStrategy.determineIrrigationAmount(moistureLevel, weatherCondition, crop.getCropWaterRequirement());
            totalWaterNeeded += x;
        }
        return totalWaterNeeded;
    }


    // Main method for testing
    public static void main(String[] args) {
        /*SmartIrrigationSystem smartSystem = new SmartIrrigationSystem();

        // Collect sensor data

        // Set the irrigation strategy (optional)
        // smartSystem.setIrrigationStrategy(new AdvancedIrrigationStrategy());

        // Perform irrigation
        Crop corn = new Corn(0, "low", "low", 100);
        Crop potatoes = new Potatoes(0, "high", "low", 60);
        monitorCropHealth(corn);
        corn.applyFertilizer();
        monitorCropHealth(corn);

        monitorCropHealth(potatoes);
        potatoes.applyFertilizer();
        monitorCropHealth(potatoes);

        smartSystem.irrigate(corn);
        */
    }
}