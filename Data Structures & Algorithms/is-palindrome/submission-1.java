class Solution {
    public boolean isPalindrome(String s) {
        // //remove unwanted characters from given string
        // String inputWithOnlyLetters = "";
        // for(int i=0; i<s.length(); i++){
        //     if(Character.isLetterOrDigit(s.charAt(i))){
        //         inputWithOnlyLetters += s.charAt(i);
        //     }   
        // }

        // inputWithOnlyLetters = inputWithOnlyLetters.toLowerCase();
        // int low = 0;
        // int high = inputWithOnlyLetters.length()-1;
        // while(low < high){
        //     if(inputWithOnlyLetters.charAt(low) != inputWithOnlyLetters.charAt(high)){
        //         return false;
        //     }
        //     ++low;
        //     --high;
        // }

        // return true;

        //Single pass
        String lowerCaseInput = s.toLowerCase();
        int l = 0;
        int r= lowerCaseInput.length()-1;
        while(l<r){
            char lChar = lowerCaseInput.charAt(l);
            char rChar = lowerCaseInput.charAt(r);
            
            if(!Character.isLetterOrDigit(lChar)){
                ++l;
                continue;
            }

            if(!Character.isLetterOrDigit(rChar)){
                --r;
                continue;
            }
            if(lChar!=rChar){
                return false;
            }
            ++l;
            --r;
        }

        return true;
        
    }
}
