//Question:
//Given a string A consisting of lowercase characters.
//Check if characters of the given string can be rearranged to form a palindrome.
//Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

public class MapsQuestion1 {
    public int solve(String A) {
        int[] ans = new int[26];

        // store the frequency of letter in input string
        for(int i=0;i<A.length();i++){
            ans[(A.charAt(i)-97)%26]++;
        }

        // If any the frequency of character in even string is odd then you cannot form a palindrome
        if(A.length()%2==0){
            for(int i=0;i<ans.length;i++){
                if (ans[i]==0){
                    continue;
                }
                if(ans[i]%2!=0){
                    return 0;
                }
            }
        }else{
            boolean flag=true;
            int cnt=0;
            // If any the frequency of character in even string is odd and it occurs more than once
            // then you cannot form a palindrome
            for(int i=0;i<ans.length;i++){
                if(ans[i]==0){
                    continue;
                }
                if(ans[i]%2!=0){
                    cnt++;
                }

                if(cnt>1){
                    return 0;
                }
            }
        }

        return 1;
    }
}