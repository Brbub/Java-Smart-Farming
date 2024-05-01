public class Crop {
    String name;
    int growthStage;
    String nutrientRequirements;
    String susceptibilityToDiseases;
    double cropWaterRequirement;
    boolean needsFertiliser;
    boolean needsWater;

    public Crop(String name, int growthStage, String nutrientRequirements, String susceptibilityToDiseases, double cropWaterRequirements) {
        this.name = name;
        this.growthStage = growthStage;
        this.nutrientRequirements = nutrientRequirements;
        this.susceptibilityToDiseases = susceptibilityToDiseases;
        this.cropWaterRequirement = cropWaterRequirements;
        this.needsWater = false;
        this.needsFertiliser = true;
    }

    public double getCropWaterRequirement(){
        return cropWaterRequirement;
    }

    public void setCropWaterRequirement(double cropWaterRequirement) {
        this.cropWaterRequirement = cropWaterRequirement;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(int growthStage) {
        this.growthStage = growthStage;
    }

    public String getNutrientRequirements() {
        return nutrientRequirements;
    }

    public boolean getNeedsFertilizer(){
        return needsFertiliser;
    }
    public boolean getNeedsWater(){
        return needsWater;
    }

    public void setNeedsFertiliser(boolean a){
        needsFertiliser = a;
    }

    public void setNeedsWater(boolean a){
        needsWater = a;
    }

    public void printGrowthStage(){
        if(growthStage == 0){
            System.out.print("Seed");
        }else if(growthStage == 1){
            System.out.print("Sprout");
        }else if(growthStage == 2){
            System.out.print("Seedling");
        }else if(growthStage == 3){
            System.out.print("Premature Plant");
        }else if(growthStage == 4){
            System.out.print("Mature Plant");
        }else if(growthStage == 5){
            System.out.print("Decaying Plant");
        }else{
            System.out.print("Unknown");
        }
    }

    public void setNutrientRequirements(String nutrientRequirements) {
        this.nutrientRequirements = nutrientRequirements;
    }

    public String getSusceptibilityToDiseases() {
        return susceptibilityToDiseases;
    }

    public void setSusceptibilityToDiseases(String susceptibilityToDiseases) {
        this.susceptibilityToDiseases = susceptibilityToDiseases;
    }

    public void printInfo(){
        System.out.println("Crop: " + name);
        System.out.print("Growth Stage: ");
        printGrowthStage();
        System.out.println();
        System.out.println("Nutrient Requirements: " + nutrientRequirements);
        System.out.println("Susceptibility to Diseases: " + susceptibilityToDiseases);
        System.out.println("Crop Water Requirement: " + cropWaterRequirement);
        System.out.println("Crop Needs Water:  " + needsWater);
        System.out.println("Crop Needs Fertilizer: " + needsFertiliser);
    }

    public void applyFertilizer(){
        if(nutrientRequirements.equals("low")){
            growthStage += 3;
        }
        else if(nutrientRequirements.equals("medium")){
            growthStage += 2;
        }
        else if(nutrientRequirements.equals("high")){
            growthStage += 1;
        }else{
            System.out.println("An Error occured with applying fertilizer.");
        }

    }

}
