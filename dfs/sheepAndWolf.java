package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sheepAndWolf {
    private static int r, c, wolves, sheep, wolf, oneSheep;
    private static int[] Y = {-1, 1, 0, 0}, X = {0, 0, -1, 1}; //상하로 움직임
    private static char[][] map = new char[251][251]; //영역
    private static boolean[][] visit = new boolean[251][251]; //방문여부


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= r; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 1; j <= c; j++) {
                map[i][j] = ch[j - 1];

                //양,늑대 찾기
                if (map[i][j] == 'k') {
                    sheep++;
                } else if(map[i][j] == 'v') {
                    wolves++;
                }
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j] != '#' && !visit[i][j]) { //울타리가 아니고, 방문하지 않았으면
                    wolf = 0;
                    oneSheep = 0;

                    dfs(i, j);

                    if (wolf >= oneSheep) sheep -= oneSheep;
                    else wolves -= wolf;
                }
            }
        }
        System.out.print(sheep + " " + wolves);
    }

    public static void dfs(int y, int x) {

        visit[y][x] = true;

        if(map[y][x] == 'k') oneSheep++;
        else if(map[y][x] == 'v') wolf++;

        for (int i = 0; i < 4; i++) {
            int ny = y + Y[i];
            int nx = x + X[i];

            if(ny < 1 || nx < 1 || ny > r || nx > c || visit[ny][nx] || map[ny][nx] == '#') continue;

            dfs(ny, nx);
        }
    }
}
