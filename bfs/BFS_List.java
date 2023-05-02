package bfs;

import java.util.*;

public class BFS_List {
    public static void main(String[] args) {
        //그래프 관련 변수
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //정점의 개수
        int m = sc.nextInt(); //간선의 개수
        int v = sc.nextInt(); //탐색 시작할 정점의 번호

        boolean visited[] = new boolean[n+1]; //방문여부 검사할 배열

        //인접리스트
        LinkedList<Integer>[] list = new LinkedList[n+1];

        for (int i=0; i <= n; i++) {
            list[i] = new LinkedList<Integer>();
        }

        // 두 정점 사이에는 여러개의 간선이 있을 수 있다.
        for (int i=0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            list[v1].add(v2);
            list[v2].add(v1);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(list[i]); // 방문 순서를 위해 오름차순 정렬
        }

        bfs_list(v, list, visited);
    }

    public static void bfs_list(int v, LinkedList<Integer>[] list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);
        System.out.println(v + " "); // 정점 출력

        while(queue.size() != 0) {
            v = queue.poll(); //remove:queue front에 있는 정점을 꺼낸다.

            // v를 기준으로 간선이 연결되어 있고(인접), 방문되지 않은 정점을 찾는다.
            Iterator<Integer> iter = list[v].listIterator();
            // listIterator() - hasNext(); 순방향으로 순회할 때 다음 요소를 가지고 있으면 true
            while (iter.hasNext()) {
                int w = iter.next(); //리스트의 다음 요소를 반환하고, cursor 위치를 순방향으로 이동시킨다.
                if(!visited[w]) { // 방문하지 않은 정점
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}