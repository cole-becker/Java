public class Burrito {
    String size;
    String protein;
    String rice;
    String beans;
    String toppings;
    boolean guac;

    Burrito(){
        this.size = "Small";
        this.protein = "None";
        this.rice = "No";
        this.beans = "No";
        this.toppings = "none";
        this.guac = false;
    }

    Burrito(String size, String protein) {
        this.size = size;
        this.protein = protein;
        this.rice = "No";
        this.beans = "No";
        this.toppings = "None";
        this.guac = false;
    }

    Burrito(String size, String protein, String rice, String beans, String toppings, boolean guac){
        this.size = size;
        this.protein = protein;
        this.rice = rice;
        this.beans = beans;
        this.toppings = toppings;
        this.guac = guac;
    }

    public String toString(){
        return this.size + " " + this.protein + " Burrrito with " + this.rice + " rice, " + this.beans + "  beans, " + this.toppings + 
        " and " + (this.guac ? "guacamole" : "no guacamole") + " (cost: $" + this.getCost() + ")" ;
    }

    public double getCost(){
        double total = 0;
        if (this.size == "Small"){
            total += 5.0;
        }
        else {
            total = 7.5;
        }
        if (this.protein == "Steak" || this.protein == "Chicken"){
            total += 2.0;
        }
        else if (this.protein == "Softritas" || this.protein == "Carnitas") {
            total += 3.0;
        }
        if (this.rice != "No") {
            total += 1.0;
        }
        if (this.beans != "No") {
            total += 1.0;
        }
        if (this.guac) {
            total += 2.0;
        }
        return total;
    }
    public static void main(String[] args) throws Exception {
    }
}
