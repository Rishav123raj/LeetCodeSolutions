class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        for(String dir : folder){
            String dirParts[] = dir.split("/");
            String parentDir = "";
            boolean isSubFolder = false;
            for(int i = 1; i < dirParts.length; i++){
                parentDir += "/" + dirParts[i];
                if(set.contains(parentDir)){
                    isSubFolder = true;
                    break;
                }
            }
            if(!isSubFolder){
                set.add(parentDir);
            }
        }
        return new ArrayList<>(set);
    }
}