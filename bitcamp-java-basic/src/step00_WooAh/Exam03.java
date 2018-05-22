
package step00_WooAh;

public class Exam03 {
    public static void main(String[] args) {

        System.out.println(readyToDuel("A586QK", "JJ653K"));
        System.out.println(playGameAndCountingAlecWin("A586QK", "JJ653K"));
        
//        System.out.println(readyToDuel("a", "K2Q25J"));
//        System.out.println(playGameAndCountingAlecWin("a", "K2Q25J"));

    }


    public static int playGameAndCountingAlecWin (String Alec, String Bob) {
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
    
    public static int playGame(char card_Alec, char card_Bob) {
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

    
    public static boolean readyToDuel (String A, String B) {
        //checkRangeOfN
        if (checkRangeOfN(A,B) && isEqualLength(A,B)) {
            char[] deck_A = A.toCharArray();
            char[] deck_B = B.toCharArray();
            if (isConsistOfValidChars(deck_A) && 
                    isConsistOfValidChars(deck_B)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkRangeOfN (String A, String B) {
        // N is an ingeter within the range [1..1,000];

        if ((A.length() >= 1 && A.length() <= 1000) &&
                (B.length() >= 1 && B.length() <= 1000)) {
            return true;
        }
        System.out.println("Your cards is out of range! \n"
                + "The cards need to be within 1 ~ 1000 cards, sir");
        return false;
    }

    public static char[] setCards (String deck) {
        return deck.toCharArray();
    }

    public static boolean isConsistOfValidChars (char[] cards_set) {
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

    public static boolean isEqualLength (String A, String B) {
        // strings A and B are of equal length
        if (A.length() == B.length())
            return true;
        return false;
    }

}

