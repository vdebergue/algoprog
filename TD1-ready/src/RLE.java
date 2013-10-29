class RLE {

	public static int longueurRLE(int[] t) {
		int length = 0;
		int previous = 3;
		for(int s: t) {
			if (s != previous) {
				length += 2;
			}
			previous = s;
		}
		return length;
	}

	public static int[] RLE(int[] t) {
		int[] dest = new int[longueurRLE(t)];
		int destIndex = 0;
		if (t.length == 0) return dest;
		int previous = t[0];
		int counter = 0;
		for(int s: t) {
			counter ++;
			if (previous != s) {
				dest[destIndex] = previous;
				dest[destIndex + 1] = counter;
				destIndex += 2;
				counter = 0;
			}
			previous = s;
		}
		return dest;
	}

	public static int longueurRLEInverse(int[] t) {
		int length = 0;
		for(int i=1; i < t.length; i +=2) {
			length += t[i];
		}
		return length;
	}

	public static int[] RLEInverse(int[] t) {
		int[] dest = new int[longueurRLEInverse(t)];
		int destIndex = 0;
		if (t.length < 2) return dest;
		for(int i = 0;  i < t.length; i +=2) {
			int word = t[i];
			int occurrences = t[i+1];
			for(int j=0; j < occurrences; j++) {
				dest[destIndex] = word;
				destIndex ++;
			}
		}
		return dest;
	}
}