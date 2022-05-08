import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        char[] chars = new char[C];
        char[] chars2 = new char[L];

        for(int i=0;i<C;i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        combination(chars, chars2, 0, 0);

    }

    public static void combination(char[] chars, char[] chars2, int cnt, int cur) {
        if(cnt == chars2.length) {
            if(a>=1 && b >= 2) {
                for(int i=0;i<chars2.length;i++) {
                    System.out.print(chars2[i]);
                }
                System.out.println();
            }
        } else {
            for(int i=cur;i<chars.length;i++) {
                chars2[cnt] = chars[i];
                if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                    a++;
                } else {
                    b++;
                }
                combination(chars, chars2,cnt+1, i+1);
                if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                    a--;
                } else {
                    b--;
                }
            }
        }
    }
}
