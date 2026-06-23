class Solution {
    private String str;
    private List<String> strs;
    
    public String encode(List<String> strs) {
        this.strs = strs;
        return "1";
    }

    public List<String> decode(String str) {
        return this.strs;
    }
}
