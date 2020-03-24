import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    private Palindrome palindrome = new Palindrome();
    @Test
    public void testOffByN() {
        CharacterComparator offBy0 = new OffByN(0);
        CharacterComparator offBy1 = new OffByN(1);
        CharacterComparator offBy2 = new OffByN(2);
        String p0 = "dogod";
        String p1 = "flake";
        String p2 = "abcdedc";

        assertTrue(palindrome.isPalindrome(p0, offBy0));
        assertTrue(palindrome.isPalindrome(p1, offBy1));
        assertTrue(palindrome.isPalindrome(p2, offBy2));

        assertFalse(palindrome.isPalindrome(p1, offBy0));
        assertFalse(palindrome.isPalindrome(p2, offBy0));
        assertFalse(palindrome.isPalindrome(p0, offBy1));
        assertFalse(palindrome.isPalindrome(p2, offBy1));
        assertFalse(palindrome.isPalindrome(p0, offBy2));
        assertFalse(palindrome.isPalindrome(p1, offBy2));
    }
}
