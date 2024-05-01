public interface Sensor {
    int readMoisturelevel();
    String readWeatherCondition();

    boolean readPest();

    String readGroundQuality();

    void editSensorData();
}
