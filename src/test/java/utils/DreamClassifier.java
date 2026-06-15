package utils;

public class DreamClassifier {
	public static String classifyDream(String dreamName) {
		dreamName = dreamName.toLowerCase();
		if (dreamName.contains("monster") || dreamName.contains("maze") || dreamName.contains("chase")
				|| dreamName.contains("fall")) {
			return "Bad";
		}
		return "Good";
	}
}
