class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board, i, j, 0, visited, word)) {
                        set.add(word);
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }

    private boolean exist(char[][] board, int i, int j, int index, boolean[][] visited, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        boolean found = exist(board, i + 1, j, index + 1, visited, word) ||
        exist(board, i - 1, j, index + 1, visited, word) ||
        exist(board, i, j + 1, index + 1, visited, word) ||
        exist(board, i, j - 1, index + 1, visited, word);
        visited[i][j] = false;
        return found;
    }
}
