package recursion;

public class factorial {
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }
    public static int factorial (int n){
        if (n==1){
            return 1;
        }else {
            System.out.println(n+"*"+(n-1));
            return factorial(n-1)*n;
        }
    }
}
