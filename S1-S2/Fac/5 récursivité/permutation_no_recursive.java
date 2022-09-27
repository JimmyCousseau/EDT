public class permutation_no_recursive {
    public static void main(String[] args) {
        /* permutation("ABC","ABC"); */
        permutatio("ABCD");
    }
    
    static void permutatio(String text) {
        int n = factorielle(text.length()) / text.length();
        if (text.length() > 3) {
            String per = text.substring(text.length() - 3, text.length());
            String begin = text.substring(0, text.length() - 3);
            n = factorielle(text.length());
            for (int i = 0; i < n; i++) {
                if (i % (n / text.length()) == 0) {
                    text = swtch(text);
                    per = text.substring(text.length() - 3, text.length());
                    begin = text.substring(0, text.length() - 3);
                    System.out.println(begin + per);
                } else {
                    if (i % 2 == 0) {
                        per = permu(per);
                        System.out.println(begin + per);
                        per = permu(per);
                    } else {
                        per = swtch(per);
                        System.out.println(begin + per);
                    }
                }
            }
        }
        else if (text.length() == 3) {
            pertrois(text);
        }
        else {
            text = permu(text);
            System.out.println(text);
            text = permu(text);
            System.out.println(text);
        }
    }



    static void pertrois(String text) {
        int n = factorielle(text.length());
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                text = permu(text);
                System.out.println(text);
                text = permu(text);
            }
            else {
                text = swtch(text);
                System.out.println(text);
            }
        }
    }

    static String swtch (String text) {
        char[] txt = text.toCharArray();
        char p = txt[0];
        char e = txt[1];
            for (int i = 0; i < txt.length - 1; i++) {
                e = txt[i + 1];
                txt[i + 1] = p;
                p = e;
                if (i == txt.length - 2) {
                    txt[0] = p;
                }
            }
            return String.valueOf(txt);
        
    }

    static String permu(String phrase) {
        char[] txt = phrase.toCharArray();
        char p = txt[txt.length - 1];
        txt[txt.length - 1] = txt[txt.length - 2];
        txt[txt.length - 2] = p;
        return String.valueOf(txt);
    }
    
    static int factorielle(int x) {
        if (x < 1) {
            return 1;
        } else {
            return x * factorielle(x - 1);
        }
    }
}
