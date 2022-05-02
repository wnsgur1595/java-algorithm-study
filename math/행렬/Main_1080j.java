import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] source = new int[n][m];
        int[][] target = new int[n][m];

        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<m;j++) {
                source[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<m;j++) {
                target[i][j] = str.charAt(j) - '0';
            }
        }

        if(n < 3 || m < 3) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(source[i][j] != target[i][j]){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int count = 0;

        for(int i=0;i<n-2;i++) {
            for(int j=0;j<m-2;j++) {
                if(source[i][j] != target[i][j]) {
                    count++;
                    for(int k=0;k<3;k++) {
                        for(int l=0;l<3;l++) {
                            source[i+k][j+l] = 1 - source[i+k][j+l];
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(source[i][j] != target[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
        return;

    }
}

