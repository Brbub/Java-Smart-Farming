public class FarmDecisionMaker implements DecisionMaker {
    @Override
    public void makeIrrigationDecision(Crop crop) {
        if(crop.getCropWaterRequirement() < 10){
            System.out.println("Recommend that this crop is water every two days.");
        }else if(crop.getCropWaterRequirement() < 30){
            System.out.println("Recommend that this crop is water every day.");
        }else if(crop.getCropWaterRequirement() < 60){
            System.out.println("Recommend that this crop is watered twice every day.");
        }else if(crop.getCropWaterRequirement() < 100){
            System.out.println("Recommend that this crop is watered three times every day.");
        }else{
            System.out.println("Unknown Recommendation, please see that sensor data is correct.");
        }

    }

    @Override
    public void makeFertilizationDecision(Crop crop) {
        if(crop.nutrientRequirements.equals("low")){
            System.out.println("Recommend that this crop is fertilized every week.");
        }else if(crop.nutrientRequirements.equals("medium")){
            System.out.println("Recommend that this crop is fertilized twice a week.");
        }else if(crop.nutrientRequirements.equals("high")){
            System.out.println("Recommend that this crop is fertilized three times a week.");
        }else{
            System.out.println("Unknown Recommendation, please see that sensor data is correct.");
        }
    }

    @Override
    public void makePestControlDecision(Crop crop) {
        if(crop.susceptibilityToDiseases.equals("low")){
            System.out.println("Recommend that pesticide is applied every month.");
        }else if(crop.susceptibilityToDiseases.equals("medium")){
            System.out.println("Recommend that this crop is fertilized twice a month.");
        }else if(crop.susceptibilityToDiseases.equals("high")){
            System.out.println("Recommend that this crop is fertilized once a week.");
        }else{
            System.out.println("Unknown Recommendation, please see that sensor data is correct.");
        }
    }
    @Override
    public void makeAnimalFoodDecision(Livestock animal){
        System.out.println("WORKINGING ON IT!");
    }
    @Override
    public void makeAnimalMedicationDecision(Livestock animal){
        System.out.println("WORKINGING ON IT!");
    }




}