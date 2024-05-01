import java.util.Scanner;
public class SoilMoistureSensor implements Sensor{
    int moistureLevel;
    SoilMoistureSensor(){
        System.out.println("Please enter an int for the moisture level. Enter -1 for random value.");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        if(value == -1){
            int x = (int) (Math.random() * 100);
            moistureLevel = x;
        }
        else{
            moistureLevel = value;
        }
    }

    //Returns a random value from 0-100%
    @Override
    public int readMoisturelevel(){
       return moistureLevel;

    }
    //Cannot read weather from moisture sensor, so returns a string stating such
    @Override
    public String readWeatherCondition(){
        return ("Cannot Read Weather Condition From Soil Moisture Sensor.");
    }

    @Override
    public boolean readPest(){
        return false;
    }
    @Override
    public String readGroundQuality(){
        return(null);
    }

    @Override
    public void editSensorData(){
        System.out.println("Please Enter A Moisture Level To Change: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        moistureLevel = value;
    }
}
