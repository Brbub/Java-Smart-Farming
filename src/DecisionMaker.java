public interface DecisionMaker {
    void makeIrrigationDecision(Crop crop);
    void makeFertilizationDecision(Crop crop);
    void makePestControlDecision(Crop crop);

    void makeAnimalFoodDecision(Livestock animal);

    void makeAnimalMedicationDecision(Livestock animal);
}
