package tech.isaacsilva.xls.graphic;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Objects;

public class GraphicSheet implements Iterable<GraphicRow> {

	protected GraphicRow first;
	protected GraphicRow last;
	protected int numberOfRows = 0;

	protected GraphicStyle style = new GraphicStyle();

	public BufferedImage getImage() {

		if (Objects.isNull(first)) {
			throw new GraphicException("Num rows: 0. Vai querer desenhar o vento é, fdp?");
		}

		GraphicStyle.setRect(this);

		BufferedImage image = new BufferedImage(style.width, style.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		draw(g2d);

		return image;
	}

	private void draw(Graphics2D g2d) {
		drawBackground(g2d);
		first.draw(g2d);
	}

	private void drawBackground(Graphics2D g2d) {
		g2d.setColor(style.backgroundColor.getColor());
		g2d.fillRect(0, 0, style.width, style.height);
	}

	public GraphicRow createRow(int index) {

		GraphicRow newRow = new GraphicRow(this, index);

		if (Objects.isNull(first)) {
			first = newRow;
		} else {
			last.next = newRow;
			newRow.prev = last;
		}

		numberOfRows++;
		last = newRow;
		return last;
	}

	@Override
	public Iterator<GraphicRow> iterator() {
		return new GraphicRowIterator(first);
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

}