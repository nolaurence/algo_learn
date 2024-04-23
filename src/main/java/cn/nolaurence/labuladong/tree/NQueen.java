package cn.nolaurence.labuladong.tree;

import java.util.List;

public class NQueen {
    List<List<String>> res;


    void backtrack(List<String> board, int row) {
        // 触发结束条件
        if(row == board.size()) {
            res.add(board);
        }
    }
}
