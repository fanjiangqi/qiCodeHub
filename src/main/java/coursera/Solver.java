package coursera;

import edu.princeton.cs.algorithms.MinPQ;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.util.*;

/**
 * Created by fanjiangqi on 2017/5/17.
 *
 * 用来解决8 puzzle问题的类，使用A* algorithm，利用了Board数据结构
 * public class Solver {
 public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
 public boolean isSolvable()            // is the initial board solvable?
 public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
 public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
 public static void main(String[] args) // solve a slider puzzle (given below)
 }
 */
public class Solver {
    //private MinPQ<SearchNode> pQueue;
    private boolean isSolve = false;
    private int moves;
    private SearchNode goalNode;
    class SearchNode implements Comparable{
        //priority = moves + hamming
        public int compareTo(Object o) {
            if (priority== ((SearchNode)o).priority)
                return 0;
            return priority < ((SearchNode)o).priority ? -1 : 1;
        }
        private int priority;
        Board board;
        int moves;
        SearchNode previous;

        public SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
            priority = board.hamming() + moves;
        }
    }
    public Solver(Board initial){
        MinPQ<SearchNode> pQueue = new MinPQ<SearchNode>();
       // MinPQ<SearchNode> tQueue = new MinPQ<>();
       // Board twinBorad = initial.twin();
        SearchNode initialNode = new SearchNode(initial,0, null);
       // SearchNode twinNode = new SearchNode(twinBorad,0, null);
       // int k = 1; // 表示每次moves增加

        pQueue.insert(initialNode);
       // tQueue.insert(twinNode);
        while (!pQueue.isEmpty() ){
            SearchNode iNode = pQueue.delMin();
           // SearchNode tNode = tQueue.delMin();
            if (iNode.board.isGoal()){
                isSolve = true;
                moves = iNode.moves;
                goalNode = iNode;
                break;
            }
          /*  if (tNode.board.isGoal()){
                isSolve = false;
                moves = -1;
                goalNode = null;
                break;
            }*/
           /* while (!pQueue.isEmpty())
                pQueue.delMin();*/
           /* while (!tQueue.isEmpty())
                pQueue.delMin();*/
            for (Board b : iNode.board.neighbors()){
                pQueue.insert(new SearchNode(b,iNode.moves + 1,iNode));
            }
           /* for (Board b : tNode.board.neighbors()){
                pQueue.insert(new SearchNode(b,tNode.moves + 1,tNode));
            }*/
            //k++;
        }


    }
    public boolean isSolvable(){
        return isSolve;
    }
    public int moves(){
        return moves;
    }
    public Iterable<Board> solution(){
        if (!isSolve)
            return null;
        LinkedList<Board> stack = new LinkedList<Board>();
        ArrayList<Board> list = new ArrayList<>();
        SearchNode pNode = goalNode;
        while (pNode.previous != null){ //类似于链表，把broad放到stack中
            stack.push(pNode.board);
            pNode = pNode.previous;
        }
        stack.push(pNode.board);
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    public static void main(String[] args){
        // create initial board from file
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.nextInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
