package recursion;

public class labyrinth {
    public static void main(String[] args) {
        //创建迷宫并进行初始化
        int[][] map = new int[8][7];//[6][5]为终点
        for (int i = 0; i < map[0].length; i++) {//第一行和最后一行
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {//第一列和最后一列
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }
        //给迷宫设置墙壁进行阻隔
        map[2][1] = 1;
        map[2][2] = 1;
        map[1][4] = 1;
        map[6][4] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
        setWay(map, 1, 1);
        System.out.println("走出迷宫了");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * @param map 迷宫地图
     * @param x   开始坐标
     * @param y
     * @return 迷宫中还未走过设置成0，障碍物为1，通路为2，死路为3。
     * 制定走路的策略：下>右>左>上
     */
    public static boolean setWay(int[][] map, int x, int y) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                if (setWay(map, x + 1, y)) {
                    return true;
                } else if (setWay(map, x, y + 1)) {
                    return true;
                } else if (setWay(map, x - 1, y)) {
                    return true;
                } else if (setWay(map, x, y - 1)) {
                    return true;
                } else {//死路走不通，标记一下,前面的条件判断都行不通了
                    map[x][y] = 3;
                    return false;
                }
            } else { //为1，为2，为3
                return false;
            }
        }
    }
}
