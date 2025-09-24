public class BurritoOrder extends Burrito {
    public static void main(String[] args) throws Exception {
        Burrito burrito1 = new Burrito();
        Burrito burrito2 = new Burrito("Large", "Softritas");
        Burrito burrito3 = new Burrito("Large", "Steak", "White", "Black", "Corn", true);

        System.out.println("Burrito i: "+ burrito1);
        System.out.println("Burrito ii: " + burrito2);
        System.out.println("Burrito iii: " + burrito3);
    }
}
