import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        int []arr1 = new int[5000];
        int []arr2 = new int[5000];
        int []arr3 = new int[5000];
        int []arr4 = new int[5000];
        LinkedList<Integer> linked1 = new LinkedList<>();
        LinkedList<Integer> linked2 = new LinkedList<>();
        LinkedList<Integer> linked3 = new LinkedList<>();
        LinkedList<Integer> linked4 = new LinkedList<>();

        for (int i = 0; i < 5000; i++){
            int random = (int) (Math.random() * 100001);
            arr1[i] = random;
            arr2[i] = random;
            arr3[i] = random;
            arr4[i] = random;
            linked1.add(random);
            linked2.add(random);
            linked3.add(random);
            linked4.add(random);
        }
    }
}
