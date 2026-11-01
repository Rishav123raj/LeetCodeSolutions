class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        deque<int> dq;
        
        for(int point : cardPoints) 
            dq.push_back(point);
        
        int sum = 0;

        for(int i = 0; i < k; i++) {
            sum += dq.front();
            dq.pop_front();
        }
        
        int maximum = sum;

        for(int i = 0; i < k; i++) {
            sum -= cardPoints[k - 1 - i];
            sum += cardPoints[cardPoints.size() - 1 -i];
            
            maximum = max(maximum, sum);
        }

        return maximum;
    }
};