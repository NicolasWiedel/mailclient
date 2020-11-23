package de.javadevblog.mailclient.view;

public enum FontSize {
	SMALL,
	MEDIUM,
	BIG;
	
	public static String getCSSPath(FontSize theme) {
		switch (theme) {
		case SMALL:
			return "stylesheets/fontSmall.css";
		case MEDIUM:
			return "stylesheets/fontMedium.css";
		case BIG:
			return "stylesheets/fontBig.css";
		default:
			return null;
		}
	}
}
