package com.hieudev.techtalk.graph.DFS._547_NumberOfProvinces;

import java.lang.*;

/**
 * Tìm số thành phần liên thông?
 * Cho n thành phố, thành phố A gọi là được ket nối đên thành pho C nếu A có kết nối
 * trực tiếp hoac gian tiếp qua C. có 1 ma trận biểu diễn 1 - có kết nối, 0 - ko có ket noi.
 * Cụm các thành phố có kết nối là 1 tỉnh -> đếm số tỉnh?
 * (Một tỉnh là một nhóm các thành phố được kết nối trực tiếp
 * hoặc gián tiếp và không có thành phố nào khác bên ngoài nhóm.)
 *
 * Vd: có 2 tỉnh
 * [1, 1, 0]
 * [1, 1, 0]
 * [0, 0, 1
 */
public class _547_NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    /**
     * - Bắt đầu với thành phố đầu tiên và thực hiện DFS để đánh dấu
     * tất cả các thành phố được kết nối trực tiếp hoặc gián tiếp
     * với thành phố đó. Các thành phố này tạo thành một tỉnh.
     * - Sau khi hoàn tất DFS, sẽ tìm thành phố tiếp theo chưa được
     * ghé thăm và thực hiện DFS từ thành phố đó để tìm một tỉnh khác
     * - Lặp lại quá trình này cho đến khi thăm hết tất cả các thành phố
     * - Mỗi lần khởi tạo DFS từ một thành phố mới chưa được ghé thăm,
     * thì sẽ tìm thấy một tỉnh mới, vì vậy sẽ tăng số lượng tỉnh của mình
     */
    private static void dfs(int[][] isConnected, int u, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < isConnected.length; v++) {
            if (isConnected[u][v] == 1 && !visited[v]) {
                dfs(isConnected, v, visited);
            }
        }
    }
}