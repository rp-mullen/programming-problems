class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int sum[nums.size()];
        sum[0] = nums[0];
        
        for (int i = 1; i < nums.size(); i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        double res = sum[k-1] * 1.0 / k;
        for (int i = k; i < nums.size(); i++) {
            res = get_max(res, (sum[i]-sum[i-k]) * 1.0 / k);
        }
        return res;
        
    }
    
    double get_max(double a, double b) {
        if (a >= b) {
            return a;
        }
        else {
            return b;
        }
    }
};
