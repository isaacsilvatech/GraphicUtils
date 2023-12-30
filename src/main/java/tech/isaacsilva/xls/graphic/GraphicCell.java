package tech.isaacsilva.xls.graphic;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Objects;

public class GraphicCell {

	protected int column;

	protected GraphicSheet sheet;
	protected GraphicRow row;

	protected GraphicCell next;
	protected GraphicCell prev;

	protected GraphicStyle style = new GraphicStyle();

	protected String value;

	public GraphicCell(GraphicSheet sheet, GraphicRow row, int column) {
		this.sheet = sheet;
		this.row = row;
		this.column = column;
	}

	public GraphicStyle getStyle() {
		return style;
	}

	public void setStyle(GraphicStyle style) {
		this.style = style.clone();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	protected void draw(Graphics2D g2d) {
		drawCell(g2d);
		drawValue(g2d);
		if (Objects.nonNull(next)) {
			next.draw(g2d);
		}
	}

	protected void drawValue(Graphics2D g2d) {
		if (Objects.nonNull(value)) {

			g2d.setColor(style.color.getColor());
			g2d.setFont(style.font);

			int y = style.y + style.height / 2 + g2d.getFontMetrics().getAscent() / 2;
			int x = 0;

			if (GraphicAlignment.START == style.alignment) {
				x = style.x + style.paddingX;
			} else if (GraphicAlignment.END == style.alignment) {
				x = style.x + style.width - g2d.getFontMetrics().stringWidth(value) - style.paddingX;
			} else if (GraphicAlignment.CENTER == style.alignment) {
				x = style.x + (style.width - g2d.getFontMetrics().stringWidth(value)) / 2;
			}

			g2d.drawString(value, x, y);
		}
	}

	protected void drawCell(Graphics2D g2d) {
		g2d.setColor(style.backgroundColor.getColor());
		g2d.fillRect(style.x, style.y, style.width, style.height);

		g2d.setColor(style.borderColor.getColor());
		g2d.setStroke(new BasicStroke(style.borderWidth));
		g2d.drawRect(style.x, style.y, style.width, style.height);
	}
	
	
}
