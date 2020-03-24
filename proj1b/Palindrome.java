public class Palindrome {

    /**
     * Return a Deque where the characters appear in the
     * same order as in the string
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /**
     * To determine whether a string is a palindrome
     */
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        return isPalindrome(wordToDeque(word));
    }


    private boolean isPalindrome(Deque<Character> word) {
        if (word.size() <= 1) {
            return true;
        } else {
            return (word.removeFirst().equals(word.removeLast())
                    && isPalindrome(word));
        }

    }

    /**
     * To determine whether a string is a off-by-n palindrome
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        return isPalindrome(wordToDeque(word), cc);
    }

    private boolean isPalindrome(Deque<Character> word, CharacterComparator cc) {
        if (word.size() <= 1) {
            return true;
        } else {
            return (cc.equalChars(word.removeFirst(), word.removeLast())
                    && isPalindrome(word, cc));
        }

    }

}
