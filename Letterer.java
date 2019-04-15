
public abstract class Letterer {
	protected static String convertToLetter(int x) {
		if(x / 26 == 0) {
			char c = (char)(65+x);
			return c+"";
		}
		
		return convertToLetter(x/26)+(char)(65+(x%26));
	}
}
