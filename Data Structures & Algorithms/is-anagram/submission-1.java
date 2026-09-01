class Solution {
    public boolean isAnagram(String s, String t) {
       /* method :1 

       int char1[] = new int[26];
       for(int i=0;i<s.length(); i++){
        char1[s.charAt(i) - 'a']++;
       }

       int char2[] = new int[26];
       for(int i=0;i<t.length(); i++){
        char2[t.charAt(i) - 'a']++;
       }

       for(int i=0;i<26; i++){
        if(char1[i] != char2[i]){
            return false;
        }
       }
       return true;
    }
    */


    //method 2:

       int char1[] = new int[26];
       for(int i=0;i<s.length(); i++){
        char1[s.charAt(i) - 'a']++;
       }

       for(int i=0;i<t.length(); i++){
        char1[t.charAt(i) - 'a']--;
       }

       for(int i=0;i<26; i++){
        if(char1[i] !=0){
            return false;
        }
       }
       return true;
    }

    
}
