import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String word1 = "hello";
        assertFalse(palindrome.isPalindrome(word1));

        String word2 = "dogod";
        assertTrue(palindrome.isPalindrome(word2));

        String word3 = "a";
        assertTrue(palindrome.isPalindrome(word3));

        String word4 = "";
        assertTrue(palindrome.isPalindrome(word4));

        String wordNull = null;
        assertFalse(palindrome.isPalindrome(wordNull));

        CharacterComparator cc = new OffByOne();
        String word5 = "flake";
        assertTrue(palindrome.isPalindrome(word5, cc));

        String word6 = "dogod";
        assertFalse(palindrome.isPalindrome(word6, cc));
    }

}
