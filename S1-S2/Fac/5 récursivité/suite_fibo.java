public class suite_fibo {
    public static void main(String[] args) {
        System.out.println(fibo(50));
    }

    static float fibo(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fibo(n - 2) + fibo(n - 1);
        }
    }
}
