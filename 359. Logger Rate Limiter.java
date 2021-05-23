class Logger {

    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map=new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message,timestamp+10);
            return true;
        }else{
            if(map.get(message)>timestamp){
                return false;
            }else{
                map.put(message,timestamp+10);
                return true;
            }
        }
    }
}