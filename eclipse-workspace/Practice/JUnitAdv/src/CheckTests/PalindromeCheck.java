package CheckTests;

public class PalindromeCheck {

	public boolean checkPalindrome(String s1) {
		String s2 = "";
		for(int i = s1.length() - 1; i>=0;--i) {
			char ch = s1.charAt(i);
			s2+=ch;
		}
		if(s2.equals(s1)) return true;
		else return false;
	}
}
