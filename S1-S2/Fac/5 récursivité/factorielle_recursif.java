
public class factorielle_recursif {
    public static void main(String[] args) {
        System.out.println(x_puissances(2, 8));
    }

    static float factorielle(float x) {
        if (x < 1) {
            return 1;
        } else {
            return x * factorielle(x - 1);
        }
    }

    static float x_puissances_naif(float x, int n) {
        if (n < 1) {
            return 1;
        } else {
            return x * x_puissances(x, n - 1);
        }
    }

    static float x_puissances(float x, int n) {
        if (n == 1) {
                return x;
        }
        else if (n % 2 == 0) {
            return x_puissances(x * x, n / 2);
        } else {
            return x * x_puissances(x * x, (n - 1) / 2);
        }
    }
}
