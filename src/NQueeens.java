import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueeens {
    static boolean validPosition(List<List<String>> arr, int row, int col) {
        // Check the row if its valid by keeping row fixed and cols variable
        int tmp = col;
        while (tmp >= 0) {
            if (arr.get(row).get(tmp).equals("Q")) {
                return false;
            }
            tmp--;
        }

        // No need to Check the col if its valid coz its always valid

        // Check the Diagonals - Only Upper left and lower left diagonals have to be checked

        // Upper Left Diagonal
        int tmpRow = row;
        int tmpCol = col;
        while (tmpRow >= 0 && tmpCol >= 0) {
            if (arr.get(tmpRow).get(tmpCol).equals("Q")) {
                return false;
            }
            tmpCol--;
            tmpRow--;
        }

        // Lower Left Diagonal
        while (row < arr.size() && col >= 0) {
            if (arr.get(row).get(col).equals("Q")) {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    static void solve(List<String> arr, List<List<String>> res, int col) {
        if (col == arr.size()) {
            List<String> result = new ArrayList<>();
            res.add(result);
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            boolean isSafe = validPosition(arr, i, col);
            if (isSafe) {
                arr.get(i).char
                arr.get(i).set(col, "Q");
                solve(arr, res, col + 1);
                arr.get(i).set(col, ".");
            }
        }
    }

    static void printBoard(List<String> arr) {
        for (String strings : arr) {
            System.out.println(strings);
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        List<String> board = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            board.add("....");
        }
        printBoard(board);
        solve(board, res, 0);

//        printBoard(res);
//        printBoard(board);
    }
}
