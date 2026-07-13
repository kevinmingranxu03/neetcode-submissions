class PrefixTree {
    private PrefixTree[] children;
    boolean isEnd;

    public PrefixTree() {
        this.children = new PrefixTree[26];
        this.isEnd = false;         
    }

    public void insert(String word) {
        PrefixTree node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new PrefixTree();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private PrefixTree searchPrefix(String prefix) {
        PrefixTree node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
