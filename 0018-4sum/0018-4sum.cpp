class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        unordered_set<long long> seen;
        set<multiset<long long>> ans_set;
        int n = nums.size();
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    long long lastNum = (long long)target - nums[i] - nums[j] - nums[k];
                    if(seen.count(lastNum)) 
                        ans_set.emplace(multiset<long long>{nums[i], nums[j], nums[k], lastNum});
                }
            }
            seen.insert(nums[i]);
        }

        vector<vector<int>> ans(size(ans_set));
        for_each(begin(ans_set), end(ans_set), [&, i(0)](auto &el) mutable {ans[i++] = vector<int>(begin(el), end(el)); });
        
        return ans;
    }
};