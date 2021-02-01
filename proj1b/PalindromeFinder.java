<<<<<<< HEAD
/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
=======

/** This class outputs all palindromes in the words file in the current directory. */
/*public class PalindromeFinder {
>>>>>>> b8c17f3cb73c22f86e84eaf9554e4a5fc0ff4e72
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-fa20/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
    }
<<<<<<< HEAD
}
=======
} Uncomment this class once you've written isPalindrome. */
>>>>>>> b8c17f3cb73c22f86e84eaf9554e4a5fc0ff4e72
