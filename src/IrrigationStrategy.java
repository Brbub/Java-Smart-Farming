abstract class IrrigationStrategy {
    abstract int determineIrrigationAmount(double moistureLevel, String weatherCondition, double cropWaterRequirement);
    abstract void scheduleIrrigation();

}
