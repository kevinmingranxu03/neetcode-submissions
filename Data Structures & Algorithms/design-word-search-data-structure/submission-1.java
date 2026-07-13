class WordDictionary {
    private Map<Integer, List<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int len = word.length();
        map.putIfAbsent(len, new ArrayList<>());
        map.get(len).add(word);
    }

    public boolean search(String word) {
        int len = word.length();

        if (!map.containsKey(len)) {
            return false;
        }

        for (String w : map.get(len)) {
            if (isMatch(w, word)) {
                return true;
            }
        }

        return false;
    }

    private boolean isMatch(String w, String pattern) {
        for (int i = 0; i < w.length(); i++) {
            if (pattern.charAt(i) == '.') {
                continue;
            }

            if (w.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}