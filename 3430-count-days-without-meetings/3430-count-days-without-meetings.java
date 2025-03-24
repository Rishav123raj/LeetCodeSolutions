class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedMeets = new ArrayList<>();
        
        for(int meet[] : meetings){
            if(mergedMeets.isEmpty() || meet[0] > mergedMeets.get(mergedMeets.size() - 1)[1]){
                mergedMeets.add(meet);
            }
            else{
                mergedMeets.get(mergedMeets.size() - 1)[1] = Math.max(mergedMeets.get(mergedMeets.size() - 1)[1], meet[1]);
            }
        }

            int meetingDays = 0;

            for(int meet[] : mergedMeets){
                meetingDays += meet[1] - meet[0] + 1;
            }

        return days - meetingDays;
    }
}