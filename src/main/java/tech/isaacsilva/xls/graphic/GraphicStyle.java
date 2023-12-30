package tech.isaacsilva.xls.graphic;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.util.Objects;

public class GraphicStyle implements Cloneable {

	protected int x;
	protected int y;
	protected int width = 110;
	protected int height = 25;

	protected int paddingX = 10;
	protected int paddingY = 5;

	protected GraphicColor color = GraphicColor.BLACK;
	protected GraphicColor backgroundColor = GraphicColor.WHITE;
	protected GraphicColor borderColor = GraphicColor.GREY_25_PERCENT;
	protected float borderWidth = 1f;

	protected Font font = new Font("Arial", Font.PLAIN, 16);
	protected GraphicAlignment alignment = GraphicAlignment.START;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public GraphicColor getColor() {
		return color;
	}

	public void setColor(GraphicColor color) {
		this.color = color;
	}

	public GraphicColor getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(GraphicColor backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public GraphicColor getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(GraphicColor borderColor) {
		this.borderColor = borderColor;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public float getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(float borderWidth) {
		this.borderWidth = borderWidth;
	}

	public GraphicAlignment getAlignment() {
		return alignment;
	}

	public void setAlignment(GraphicAlignment alignment) {
		this.alignment = alignment;
	}

	@Override
	public GraphicStyle clone() {
		try {
			return (GraphicStyle) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	protected static void setRect(GraphicSheet sheet) {

		for (GraphicRow row : sheet) {
			for (GraphicCell cell : row) {
				cell.style.width = getWidth(cell);
				cell.style.height = getHeight(cell);
				cell.style.x = getX(cell);
				cell.style.y = getY(cell);
			}

			row.style.width = getWidth(row);
			row.style.height = getHeight(row);
			row.style.y = getY(row);
			row.style.x = 0;
		}

		sheet.style.width = getWidth(sheet);
		sheet.style.height = getHeight(sheet);
	}

	private static int getHeight(GraphicSheet sheet) {
		int height = 0;

		for (GraphicRow row : sheet) {
			height += row.style.height;
		}

		return height;
	}

	private static int getWidth(GraphicSheet sheet) {
		return sheet.first.style.width;
	}

	private static int getY(GraphicRow row) {
		return Objects.nonNull(row.prev) ? row.prev.style.y + row.prev.style.height : 0;
	}

	private static int getHeight(GraphicRow row) {
		int height = 0;

		for (GraphicCell cell : row) {
			if (cell.style.height > height) {
				height = cell.style.height;
			}
		}

		return height;
	}

	private static int getWidth(GraphicRow row) {
		int width = 0;

		for (GraphicCell cell : row) {
			width += cell.style.width;
		}

		return width;
	}

	private static int getY(GraphicCell cell) {
		return Objects.nonNull(cell.row.prev) ? cell.row.prev.style.y + cell.row.prev.style.height : 0;
	}

	private static int getX(GraphicCell cell) {
		return Objects.nonNull(cell.prev) ? cell.prev.style.x + cell.prev.style.width : 0;
	}

	private static int getWidth(GraphicCell graphicCell) {
		int width = 0;

		for (GraphicRow row : graphicCell.sheet) {
			for (GraphicCell cell : row) {
				if (cell.column == graphicCell.column) {
					updateCellWidhtHeight(cell);
					if (cell.style.width > width) {
						width = cell.style.width;
					}
				}
			}
		}

		return width;
	}

	@SuppressWarnings("deprecation")
	private static void updateCellWidhtHeight(GraphicCell cell) {
		if (Objects.nonNull(cell.value)) {
			FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(cell.style.font);
			int fontWidth = fontMetrics.stringWidth(cell.value) + cell.style.paddingX * 2;
			int fontHeight = fontMetrics.getHeight() + cell.style.paddingY * 2;

			if (fontWidth >= cell.style.width) {
				cell.style.width = fontWidth;
			}

			if (fontHeight >= cell.style.height) {
				cell.style.height = fontHeight;
			}
		}
	}

	private static int getHeight(GraphicCell graphicCell) {
		int height = 0;

		for (GraphicCell cell : graphicCell.row) {
			if (cell.style.height > height) {
				height = cell.style.height;
			}
		}

		return height;
	}
}
