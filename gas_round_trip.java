class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] idxs = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            idxs[i] = calculateRoundTrip(gas,cost,i);
            
        }
        for (int j = 0; j < idxs.length; j++) {
            if (idxs[j] != -1) {
                return j;
            }
        }
        return -1;
    }
    
    public int calculateRoundTrip(int[] gas, int[] cost, int i) {
        int L = gas.length;
        int idx = i;
        int g = gas[i];
        for (int j = 0; j < L; j++) {
            if (i + 1 == L) {
                i = 0;
            }
            g = gas[i+1] - cost[i];
            if (g < 0) {
                return -1;
            }
        }
        return idx;
    }
}
