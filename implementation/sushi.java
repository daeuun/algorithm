package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sushi {
    public static int T, S, result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        boolean time = (0 <= T && T <= 23);
        boolean drink = (0 <= S && S <= 1);

        if (drink && time) {
            result = 280;

            if((12 <= T && T <= 16) && S == 0) {
                result = 320;
            }
        }
        System.out.print(result);
    }

}
