import java.util.Random;
public class Livestock {
    private boolean needsFood;
    private boolean isSick;
    private String name;
    private int age;
    private String breed;
    private String type;
    private String diet;

    public Livestock(String type, String name, String breed, int age, boolean isSick){
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.isSick = isSick;
        this.needsFood = true;
        this.diet = generateRandomDiet();
    }

    private String generateRandomDiet() {
        String[] diets = {"Grass", "Hay", "Grains", "Pellets", "Vegetables", "Fruits"};
        Random rand = new Random();
        return diets[rand.nextInt(diets.length)];
    }

    public void checkHealthStatus(){
        if(isSick){
            System.out.println(this.name + "is currently ill.");
        }else if(isSick){
            System.out.println(this.name + "is currently healthy.");
        }
    }

    public void productionMetrics(){
        int x = (int) (Math.random() * 10);
        if(this.type.toLowerCase().equals("cow")){
            System.out.println(this.name + "is currently producing " + x + " bottle(s) of milk each day.");
        }else if(this.type.toLowerCase().equals("chicken")){
            System.out.println(this.name + "is currently producing " + x + " egg(s) each day.");
        }else if(this.type.toLowerCase().equals("sheep")){
            System.out.println(this.name + "is currently producing " + x + " wool each day.");
        }
    }

    public String getName() {
        return name;
    }
    public boolean getNeedsFood(){
        return needsFood;
    }
    public boolean getIsSick(){
        return isSick;
    }

    public void setNeedsFood(boolean a){
        this.needsFood = a;
    }
    public String getDiet(){
        return diet;
    }

    public void setIsSick(boolean a){
        this.isSick = a;
    }

    public void info(){
        System.out.println("===== Livestock Info =====");
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age);
        System.out.println("Is Sick: " + (isSick ? "Yes" : "No"));
        System.out.println("Needs Food: " + (needsFood ? "Yes" : "No"));
        System.out.println("Diet: " + diet);

    }



}
