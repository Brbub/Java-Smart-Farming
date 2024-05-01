import java.util.Scanner;

public class PestSensor implements Sensor{
    private boolean hasPest;

    @Override
    public String readWeatherCondition(){
        return ("Cannot Read Weather Condition From Soil Moisture Sensor.");
    }

    @Override
    public int readMoisturelevel(){
        return -1;
    }

    @Override
    public boolean readPest(){
        return (int) (Math.random() * 10) == 2;

    }
    @Override
    public String readGroundQuality(){
        return(null);
    }

    @Override
    public void editSensorData(){
        String[] values = {"true", "false"};
        System.out.println("Please enter a value to change pestSensor from the below list");
        for(int i = 0; i < values.length; i++){
            System.out.print(values[i] + " ");
        }
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        if(value.toLowerCase().equals("true")){
            hasPest = true;
        }else if(value.toLowerCase().equals("false")){
            hasPest = false;
        }
    }
}
