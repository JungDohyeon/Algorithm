import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> phoneBook = new HashSet<>();
        
        for (String phoneNum: phone_book) {
            phoneBook.add(phoneNum);
        }
        
        for (String phoneNum: phone_book) {
            int phoneNumLen = phoneNum.length();
            
            for (int i = 1; i < phoneNumLen; i++) {
                if (phoneBook.contains(phoneNum.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}