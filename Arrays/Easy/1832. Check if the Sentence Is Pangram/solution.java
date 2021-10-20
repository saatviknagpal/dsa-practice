class Solution {
    public boolean checkIfPangram(String sentence) {
		if (sentence.length() < 26) {
			return false;
		}
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < alphabets.length(); i++) {
			if (sentence.indexOf(alphabets.charAt(i)) == -1) {
				return false;
			}
		}
		return true;
	}
}
