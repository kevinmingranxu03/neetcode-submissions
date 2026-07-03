class TimeMap {
    private Map<String, List<String>> map;
    private Map<String, List<Integer>> timestampMap;
    

    public TimeMap() {
        this.map = new HashMap<>();
        this.timestampMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
            timestampMap.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
        timestampMap.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        int timestamp_prev = 0;
        int i = 0;
        boolean find = false;
        for (int preTimestamp : timestampMap.get(key)) {
            if (preTimestamp <= timestamp) {
                timestamp_prev = Math.max(timestamp_prev, preTimestamp);
                find = true;
            }
        }
        i = timestampMap.get(key).indexOf(timestamp_prev);
        if (find) {
            return map.get(key).get(i);  
        }
        return "";
    }
}
