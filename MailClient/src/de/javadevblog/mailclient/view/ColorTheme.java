package de.javadevblog.mailclient.view;

public enum ColorTheme {
	LIGHT, DEFAULT, DARK;

	public static String getCSSPath(ColorTheme theme) {
		switch (theme) {
		case LIGHT:
			return "stylesheets/themeLight.css";
		case DEFAULT:
			return "stylesheets/themeDefault.css";
		case DARK:
			return "stylesheets/themeDark.css";
		default:
			return null;
		}
	}
}
