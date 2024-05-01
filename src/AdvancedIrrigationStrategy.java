import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AdvancedIrrigationStrategy extends IrrigationStrategy{
    private String [] schedule = adjustIrrigationSchedule();
    @Override
    int determineIrrigationAmount(double moistureLevel, String weatherCondition, double cropWaterRequirement) {
        //"Cloudy", "Sunny", "Rainy", "Foggy", "Stormy", "Windy", "Snowy"
        //According to a website, The ideal humidity range for mature plants is 50-60%

        int irrigationAmountNeeded = 0;

        switch (weatherCondition) {
            case "Sunny":
            case "Windy":
                if (moistureLevel < 55) {
                    irrigationAmountNeeded = (int) (cropWaterRequirement - moistureLevel);
                }
                break;
            case "Cloudy":
            case "Foggy":
                if (moistureLevel < 45) {
                    irrigationAmountNeeded = (int) (cropWaterRequirement - moistureLevel);
                }
                break;
            case "Rainy":
            case "Snowy":
            case "Stormy":
                if (moistureLevel < 5) {
                    irrigationAmountNeeded = (int) (cropWaterRequirement - moistureLevel);
                }
                break;
            default:
                System.out.println("Unknown Weather Condition: " + weatherCondition);
                break;
        }
        return irrigationAmountNeeded;
    }


    String [] adjustIrrigationSchedule(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of times you want to water each day:");
        int numberOfWateringTimes = scanner.nextInt();

        List<String> wateringSchedule = new ArrayList<>();
        for (int i = 0; i < numberOfWateringTimes; i++) {
            System.out.println("Enter the time for watering " + (i + 1) + " (in 24-hour format, e.g., 8:00):");
            String wateringTime = scanner.next();
            wateringSchedule.add(wateringTime);
        }

        System.out.println("Watering schedule adjusted successfully:");
        String[] scheduleArray = new String[wateringSchedule.size()];
        scheduleArray = wateringSchedule.toArray(scheduleArray);
        return scheduleArray;

    }

    @Override
    void scheduleIrrigation(){
        System.out.println("Scheduling irrigation " + schedule.length + " times a day at");
        for(String time : schedule){
            System.out.print(time + " ");
        }
        System.out.println();
    }

    //Moved this function to smartirrigationsystem to determine which irrigation type we use
    /*
    public String considerSoilTypeAndTopography() {
        // Simulated inputs for soil type and topography
        String soilType = "Loam"; // Example soil type
        String topography = "Flat"; // Example topography

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
*/

}
