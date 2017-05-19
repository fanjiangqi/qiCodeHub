import edu.princeton.cs.algorithms.MinPQ;
import edu.princeton.cs.algorithms.Stack;
import edu.princeton.cs.introcs.StdOut;

import java.util.Scanner;

public class Solver {
    private class Move implements Comparable<Move> {
        private Move previous;
        private Board board;
        private int numMoves = 0;

        public Move(Board board) {
            this.board = board;
        }

        public Move(Board board, Move previous) {
            this.board = board;
            this.previous = previous;
            this.numMoves = previous.numMoves + 1;
        }

        public int compareTo(Move move) {
            return (this.board.manhattan() - move.board.manhattan()) + (this.numMoves - move.numMoves);
        }
    }

    private Move lastMove;

    public Solver(Board initial) {
        MinPQ<Move> moves = new MinPQ<Move>();
        moves.insert(new Move(initial));

        MinPQ<Move> twinMoves = new MinPQ<Move>();
        twinMoves.insert(new Move(initial.twin()));

        while(true) {
            lastMove = expand(moves);
            if (lastMove != null || expand(twinMoves) != null) return;
        }
    }

    private Move expand(MinPQ<Move> moves) {
        if(moves.isEmpty()) return null;
        Move bestMove = moves.delMin();
        if (bestMove.board.isGoal()) return bestMove;
        for (Board neighbor : bestMove.board.neighbors()) {
            if (bestMove.previous == null || !neighbor.equals(bestMove.previous.board)) {
                moves.insert(new Move(neighbor, bestMove));
            }
        }
        return null;
    }

    public boolean isSolvable() {
        return (lastMove != null);
    }

    public int moves() {
        return isSolvable() ? lastMove.numMoves : -1;
    }

    public Iterable<Board> solution() {
        if (!isSolvable()) return null;

        Stack<Board> moves = new Stack<Board>();
        while(lastMove != null) {
            moves.push(lastMove.board);
            lastMove = lastMove.previous;
        }

        return moves;
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