package be.bstorm;

public class Main {
    public static void main(String[] args) {

        int a = Integer.MIN_VALUE;
        int b = -5;

        SimpleMath math = new SimpleMath();
        int result = math.add(a,b);
        System.out.println(result);
    }
}