class Solution {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root, visited, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, boolean[][] visited, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }

        char c = board[row][col];
        int index = c - 'a';
        if (node.children[index] == null) {
            return;
        }
        
        TrieNode next = node.children[index];
        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(board, newRow, newCol, next, visited, res);
        }
        visited[row][col] = false;
    }

    private void insert(TrieNode node, String word) {
        TrieNode cur = node;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.word = word;
    }
}
