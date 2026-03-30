class Solution {
    public boolean isPalindrome(String s) {
        //remove unwanted characters from given string
        String inputWithOnlyLetters = "";
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                inputWithOnlyLetters += s.charAt(i);
            }   
        }

        inputWithOnlyLetters = inputWithOnlyLetters.toLowerCase();
        int low = 0;
        int high = inputWithOnlyLetters.length()-1;
        while(low < high){
            if(inputWithOnlyLetters.charAt(low) != inputWithOnlyLetters.charAt(high)){
                return false;
            }
            ++low;
            --high;
        }

        return true;
        
    }
}
