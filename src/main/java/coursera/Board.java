package coursera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fanjiangqi on 2017/5/17.
 * 8 Puzzle问题  http://coursera.cs.princeton.edu/algs4/assignments/8puzzle.html
 * 思路：
 *  1. 怎么求每个元素的Manhattan distance?（考虑第一元素是(0,0),(i,j)表示当前元素实际在的位置）
 *      那个元素值x，x应在的位置是(xl =(x%n == 0 ? x/n-1: x/n), yl=(x%n == 0 ? n-1: x%n-1)),
 *      则水平距离 abs(x1 - i) 垂直距离 abs(y1 -j)
 *  2. 二维数组的clone问题
 *
 *
 *
 *
 */
public class Board {
    private int[][] items;
    private int N; // 拼图的维数
    private int hamming;
    private int manhattan;
    private boolean isGoal;
    /**
     *  construct a board from an n-by-n array of blocks
     *   (where blocks[i][j] = block in row i, column j)
     * @param blocks
     */
    public Board(int[][] blocks) {
        //items = blocks.clone();  //必须用，不然内部blocks依赖与外部blocks

        this.N = blocks.length;
        items = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                items[i][j] = blocks[i][j];
            }
        }
        int ha = 0;
        int ma = 0;
        int curNum; //goal board 中当前元素
        int x = 0; //blocks[i][j]实际应该在的x坐标
        int y = 0; //blocks[i][j]实际应该在的y坐标
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blocks[i][j] == 0)
                    continue;
                if (i == N - 1 && j == N - 1){ //最后一个curNum应该为0
                    curNum = 0;
                }else {
                    curNum =  i * N + (j + 1);
                }
                x =(blocks[i][j] % N == 0 ? (blocks[i][j] / N - 1) : (blocks[i][j] / N) );
                y =(blocks[i][j] % N == 0 ? (N-1): (blocks[i][j] % N - 1) );
                if (blocks[i][j] != curNum){
                    ha++; //计算hamming distance
                }
                ma += Math.abs(x - i) + Math.abs(y - j); //计算manhattan distance
            }
        }
        this.hamming = ha;
        this.manhattan = ma;
        if (ha == 0 && ma == 0 )
            this.isGoal = true;
        else
            this.isGoal = false;
    }

    /**
     * board dimension n
     * @return
     */
    public int dimension(){
        return this.N;
    }

    /**
     * number of blocks out of place
     * @return
     */
    public int hamming(){
        return hamming;
    }

    /**
     * sum of Manhattan distances between blocks and goal
     * @return
     */
    public int manhattan(){
        return manhattan;
    }

    /**
     * is this board the goal board?
     * @return
     */
    public boolean isGoal(){
        return isGoal;
    }

    /**
     * a board that is obtained by exchanging any pair of blocks
     * @return
     */
    public Board twin(){
        int[][] arr1 = new int[N][];
        for (int i = 0; i < N ; i++) {
            arr1[i] = items[i].clone();
        }
        Board twinBoard = new Board(arr1);
        if (arr1[0][0] * arr1[0][1] != 0 )
            swap(arr1, 0, 0 ,0 ,1);
        else
            swap(arr1,1, 0 ,0 ,1 );
        return twinBoard;
    }

    /**
     * does this board equal y?
      * @param y
     * @return
     */
    public boolean equals(Object y){
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (items[i][j] != ((Board) y).items[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        return true;
    }

    /**
     * all neighboring boards
     * @return
     */
    public Iterable<Board> neighbors()  {
        int x0 = 0; //0元素x的坐标
        int y0 = 0; //0元素的y坐标
        List<Board> list = new ArrayList<Board>();
        for (int i = 0; i < N; i++) { //find blank square
            for (int j = 0; j < N; j++) {
                    if (items[i][j] == 0){
                        x0 = i;
                        y0 = j;
                        break;
                    }

            }
        }
        int[][] arr1 = new int[N][];
        int[][] arr2 = new int[N][];
        int[][] arr3 = new int[N][];
        int[][] arr4 = new int[N][];

        for (int i = 0; i < N; i++) {
            arr1[i] = items[i].clone();
            arr2[i] = items[i].clone();
            arr3[i] = items[i].clone();
            arr4[i] = items[i].clone();
        }

        if ( inBorad(x0 - 1, y0)){
            swap(arr1,x0 - 1, y0, x0, y0);
            Board b1 = new Board(arr1);
            list.add(b1);
        }
        if ( inBorad(x0 + 1, y0)){

            swap(arr2,x0 + 1, y0, x0, y0);
            Board b2 = new Board(arr2);
            list.add(b2);
        }
        if ( inBorad(x0, y0 - 1)){
            swap(arr3,x0, y0 - 1, x0, y0);
            Board b3 = new Board(arr3);
            list.add(b3);
        }
        if ( inBorad(x0, y0 + 1)){
            swap(arr4,x0, y0 + 1, x0, y0);
            Board b4 = new Board(arr4);
            list.add(b4);
        }

        return list;
    }


    private void swap(int[][] a, int x1, int y1, int x2, int y2){
        int temp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = temp;
    }

    /**
     *  whether(x, y) in board ?
     * @param x
     * @param y
     * @return
     */
    private boolean inBorad(int x, int y){
        if (x > N - 1 || y > N - 1 || x < 0 || y < 0)
            return false;
        else
            return true;
    }

    /**
     *string representation of this board (in the output format specified below)
     * @return
     */
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(N);
        sb.append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(items[i][j]);
                if (j == N - 1)
                    sb.append("\n");
                else sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.nextInt();
        Board initial = new Board(blocks);
        System.out.println(initial.hamming() + " " + initial.manhattan());
        System.out.println(initial.isGoal());
        System.out.println(initial);
        for(Board board : initial.neighbors()){
            System.out.println(board.toString());
            System.out.println(board.hamming() +" " + board.manhattan());
        }

    }
}
