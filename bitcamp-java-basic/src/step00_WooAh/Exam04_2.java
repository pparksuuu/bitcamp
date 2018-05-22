// 주석



                
//            
//            switch (card_toString) {
//            case "A":
//                isValid = true;
//                break;
//            case "K":
//                isValid = true;
//                break;  
//            case "Q":
//                isValid = true;
//                break;   
//            case "J":
//                isValid = true;
//                break;   
//            case "T":
//                isValid = true;
//                break;   
//            default:
//                for (int i = 2; i < 9; i ++) {
//                    if (Integer.parseInt(card_toString) == i) {
//                        isValid = true;
//                    }
//                }
//                isValid = false;
//            }
//
/*
  여러 줄 주석
*/

/**
 변수 선언 앞에 설명 붙여 좋으면 HTML 문서 만들 때 추출 할 수 있다.
 */

/**
 javadoc 주석 
 => 소스 파일에서 추출하여 HTML 문서를 만들 때 사용.
 =>클래스, 메서드, 변수 선언 앞에 붙인다.
 */

package step00_WooAh;
//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
 public int solution(String Alec, String Bob) {
     // write your code in Java SE 8
     return playGameAndCountingAlecWin("AAA","QQQ");
 }
 
  public int playGameAndCountingAlecWin (String Alec, String Bob) {
     if (readyToDuel(Alec, Bob)) { 
     char[] deck_Alec = Alec.toCharArray();
     char[] deck_Bob = Bob.toCharArray();
     
     int count = 0;
     
     for (int i = 0; i < deck_Alec.length; i ++) {
         count += playGame(deck_Alec[i], deck_Bob[i]);
     }
     
     return count;
     } else {
         System.out.println("You're not ready to play yet.");
         return 0;
     }
 }
 
 public int playGame(char card_Alec, char card_Bob) {
     char[] cardValueArr = {'A', 'K', 'Q', 'J', 'T', 
             '9', '8', '7','6', '5', '4', '3', '2'};
     int card_Alec_index = 0;
     int card_Bob_index = 0;
     
     
     for (int i = 0; i < cardValueArr.length; i++) {
         if (card_Alec == cardValueArr[i]) {
             //System.out.println(card_Alec);
             card_Alec_index = i;
             break;
         }
     }
     
     for (int i = 0; i < cardValueArr.length; i++) {
         if (card_Bob == cardValueArr[i]) {
            // System.out.println(card_Bob);

             card_Bob_index = i;
             break;
         }
     }
     
     if (card_Alec_index < card_Bob_index) {
         return 1;
     } else {
         return 0;
     }
 }

 
 public boolean readyToDuel (String A, String B) {
     //checkRangeOfN
     if (checkRangeOfN(A,B) && isEqualLength(A,B)) {
         char[] deck_A = A.toCharArray();
         char[] deck_B = B.toCharArray();
         if (isConsistOfValidChars(deck_A) && 
                 isConsistOfValidChars(deck_B)) {
             System.out.println("Let's play the game");
             return true;
         }
     }

     return false;
 }

 public boolean checkRangeOfN (String A, String B) {
     // N is an ingeter within the range [1..1,000];

     if ((A.length() >= 1 && A.length() <= 1000) &&
             (B.length() >= 1 && B.length() <= 1000)) {
         return true;
     }
     System.out.println("Your cards is out of range! \n"
             + "The cards need to be within 1 ~ 1000 cards, sir");
     return false;
 }

 public char[] setCards (String deck) {
     return deck.toCharArray();
 }

 public boolean isConsistOfValidChars (char[] cards_set) {
     // strings A and B consist only of the following characters: 2-9, T, J, Q, K and/or A;
     boolean isValid = false;
     try {
         for (char card : cards_set) {
             String card_toString = Character.toString(card);
             switch (card_toString) {
             case "A":
                 isValid = true;
                 break;
             case "K":
                 isValid = true;
                 break;  
             case "Q":
                 isValid = true;
                 break;   
             case "J":
                 isValid = true;
                 break;   
             case "T":
                 isValid = true;
                 break;   
             default:
                 for (int i = 2; i < 9; i ++) {
                     if (Integer.parseInt(card_toString) == i) {
                         isValid = true;
                     }
                 }
                 isValid = false;
             }
         } 
     } catch (Exception e) {
         System.out.println("You're holding wrong cards");
     }
     return isValid;
 }

 public boolean isEqualLength (String A, String B) {
     // strings A and B are of equal length
     if (A.length() == B.length())
         return true;
     return false;
 }
}
