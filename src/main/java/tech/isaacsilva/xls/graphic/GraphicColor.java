package tech.isaacsilva.xls.graphic;

import java.awt.Color;

public enum GraphicColor {

	BLACK1(0, new Color(0, 0, 0)), WHITE1(1, new Color(255, 255, 255)), RED1(2, new Color(255, 0, 0)),
	BRIGHT_GREEN1(3, new Color(0, 255, 0)), BLUE1(4, new Color(0, 0, 255)), YELLOW1(5, new Color(255, 255, 0)),
	PINK1(6, new Color(255, 182, 193)), TURQUOISE1(7, new Color(0, 255, 255)), BLACK(8, new Color(0, 0, 0)),
	WHITE(9, new Color(255, 255, 255)), RED(10, new Color(255, 0, 0)), BRIGHT_GREEN(11, new Color(0, 255, 0)),
	BLUE(12, new Color(0, 0, 255)), YELLOW(13, new Color(255, 255, 0)), PINK(14, new Color(255, 182, 193)),
	TURQUOISE(15, new Color(0, 255, 255)), DARK_RED(16, new Color(139, 0, 0)), GREEN(17, new Color(0, 128, 0)),
	DARK_BLUE(18, new Color(0, 0, 139)), DARK_YELLOW(19, new Color(139, 139, 0)), VIOLET(20, new Color(238, 130, 238)),
	TEAL(21, new Color(0, 128, 128)), GREY_25_PERCENT(22, new Color(192, 192, 192)),
	GREY_50_PERCENT(23, new Color(128, 128, 128)), CORNFLOWER_BLUE(24, new Color(100, 149, 237)),
	MAROON(25, new Color(128, 0, 0)), LEMON_CHIFFON(26, new Color(255, 250, 205)),
	LIGHT_TURQUOISE1(27, new Color(173, 216, 230)), ORCHID(28, new Color(218, 112, 214)),
	CORAL(29, new Color(255, 127, 80)), ROYAL_BLUE(30, new Color(65, 105, 225)),
	LIGHT_CORNFLOWER_BLUE(31, new Color(173, 216, 230)), SKY_BLUE(40, new Color(135, 206, 250)),
	LIGHT_TURQUOISE(41, new Color(173, 216, 230)), LIGHT_GREEN(42, new Color(144, 238, 144)),
	LIGHT_YELLOW(43, new Color(255, 255, 224)), PALE_BLUE(44, new Color(173, 216, 230)),
	ROSE(45, new Color(255, 192, 203)), LAVENDER(46, new Color(230, 230, 250)), TAN(47, new Color(210, 180, 140)),
	LIGHT_BLUE(48, new Color(173, 216, 230)), AQUA(49, new Color(0, 255, 255)), LIME(50, new Color(50, 205, 50)),
	GOLD(51, new Color(255, 215, 0)), LIGHT_ORANGE(52, new Color(255, 165, 0)), ORANGE(53, new Color(255, 165, 0)),
	BLUE_GREY(54, new Color(105, 105, 105)), GREY_40_PERCENT(55, new Color(128, 128, 128)),
	DARK_TEAL(56, new Color(0, 128, 128)), SEA_GREEN(57, new Color(46, 139, 87)), DARK_GREEN(58, new Color(0, 100, 0)),
	OLIVE_GREEN(59, new Color(85, 107, 47)), BROWN(60, new Color(139, 69, 19)), PLUM(61, new Color(221, 160, 221)),
	INDIGO(62, new Color(75, 0, 130)), GREY_80_PERCENT(63, new Color(77, 77, 77)), AUTOMATIC(64, new Color(0, 0, 0));
	
	private final static GraphicColor[] _values = new GraphicColor[65];

	static {
		for (GraphicColor color : values()) {
			_values[color.index] = color;
		}
	}

	private short index;
	private Color color;

	GraphicColor(int index, Color color) {
		this.index = (short) index;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public static GraphicColor getColor(int index) {
		if (index < 0 || index >= _values.length) {
			throw new IllegalArgumentException("Illegal IndexedColor index: " + index);
		}
		GraphicColor color = _values[index];
		if (color == null) {
			throw new IllegalArgumentException("Illegal IndexedColor index: " + index);
		}
		return color;
	}
}
