class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Boolean> map = new HashMap<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                    char num = board[i][j];
                    if (num == '.') continue;

                    String rowKey = "row" + i + num;
                    String colKey = "col" + j + num;
                    String boxKey = "box" + (i / 3) + (j / 3) + num;

                    if (map.containsKey(rowKey) || map.containsKey(colKey) || map.containsKey(boxKey)) {
                    return false;
                }

                    map.put(rowKey, true);
                    map.put(colKey, true);
                    map.put(boxKey, true);
                }
            }
            return true;
        }
    }
