class WordDictionary {
    private Set<String> set;
    public WordDictionary() {
        this.set = new HashSet<>();
    }

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        for (String w : set) {
            if (w.length() == word.length()) {
                int i = 0;
                while (i < w.length()) {
                    if (word.charAt(i) == '.') {
                        i++;
                    } else if (w.charAt(i) != word.charAt(i)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i == word.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
