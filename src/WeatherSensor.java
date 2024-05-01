import java.util.Scanner;
public class WeatherSensor implements Sensor{
    String weather;

    WeatherSensor(){
        String[] weathers = {"Cloudy", "Sunny", "Rainy", "Foggy", "Stormy", "Windy", "Snowy"};
        System.out.println("Please enter a value for the weather from the below list or 'random' for a random weather: ");
        for(int i = 0; i < weathers.length; i++){
            System.out.print(weathers[i] + " ");
        }
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if(input.toLowerCase().equals("random")){
            weather = weathers[(int) (Math.random() * weathers.length)];
        }
        else{
            weather = input;
        }
    }
    //Returns -1 because it cannot read moisture level
    @Override
    public int readMoisturelevel(){
        return -1;
    }
    //Returns a random weather type
    @Override
    public String readWeatherCondition(){
        return weather;
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
        String[] weathers = {"Cloudy", "Sunny", "Rainy", "Foggy", "Stormy", "Windy", "Snowy"};
        System.out.println("Please enter a value to change weather from the below list");
        for(int i = 0; i < weathers.length; i++){
            System.out.print(weathers[i] + " ");
        }
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        weather = value;
    }


}
