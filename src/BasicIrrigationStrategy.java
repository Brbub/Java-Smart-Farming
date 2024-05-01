public class BasicIrrigationStrategy extends IrrigationStrategy{
    @Override
    int determineIrrigationAmount(double moistureLevel, String weatherCondition, double cropWaterRequirement){
        //"Cloudy", "Sunny", "Rainy", "Foggy", "Stormy", "Windy", "Snowy"
        //According to a website, The ideal humidity range for mature plants is 50-60%

        int irrigationAmountNeeded = 0;

        switch (weatherCondition){
            case "Sunny":
            case "Windy":
                if(moistureLevel < 55){
                    irrigationAmountNeeded = (int) (55 - moistureLevel);
                }
                break;
            case "Cloudy":
            case "Foggy":
                if(moistureLevel < 45){
                    irrigationAmountNeeded = (int) (55 - moistureLevel);
                }
                break;
            case "Rainy":
            case "Snowy":
            case "Stormy":
                if(moistureLevel < 5){
                    irrigationAmountNeeded = (int) (55 - moistureLevel);
                }
                break;
            default:
                System.out.println("Unknown Weather Condition: "+ weatherCondition);
                break;
        }
        return irrigationAmountNeeded;
    }
    @Override
    void scheduleIrrigation(){
        System.out.println("Scheduling irrigation twice a day at 6am and 6pm.");
    }


}
