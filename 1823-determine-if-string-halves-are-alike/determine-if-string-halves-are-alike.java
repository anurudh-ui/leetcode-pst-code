class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int vowelBalance = 0;
        
        for (int i = 0, j = n / 2; i < n / 2; i++, j++) {
            if (isVowel(s.charAt(i))) vowelBalance++;
            if (isVowel(s.charAt(j))) vowelBalance--;
        }
        
        return vowelBalance == 0;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}