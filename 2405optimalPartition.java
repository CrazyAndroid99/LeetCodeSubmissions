/*2405. Optimal Partition of String

Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.

Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.

 

Example 1:

Input: s = "abacaba"
Output: 4
Explanation:
Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
It can be shown that 4 is the minimum number of substrings needed.
Example 2:

Input: s = "ssssss"
Output: 6
Explanation:
The only valid partition is ("s","s","s","s","s","s").
 

Constraints:

1 <= s.length <= 105
s consists of only English lowercase letters.*/

class OptimalPartition{
    public int partitionString(String s) {
        boolean[] vis = new boolean[26];
        Arrays.fill(vis,false);
        int part = (s.isEmpty())? 0 : 1;
        boolean occ = false;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(vis[c- 'a'] == true){
                vis = new boolean[26];
                part++;
                
            }
            vis[c- 'a'] = true;

        }
        return part;
    }
}