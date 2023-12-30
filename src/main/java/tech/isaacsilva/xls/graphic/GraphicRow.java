package tech.isaacsilva.xls.graphic;

import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.Objects;

public class GraphicRow implements Iterable<GraphicCell> {

	protected int index;
	protected GraphicSheet sheet;

	protected GraphicRow prev;
	protected GraphicRow next;

	protected GraphicCell first;
	protected GraphicCell last;

	private int numberOfCells;

	protected GraphicStyle style = new GraphicStyle();

	public GraphicRow(GraphicSheet sheet, int index) {
		this.sheet = sheet;
		this.index = index;
	}

	public void draw(Graphics2D g2d) {
		if (Objects.nonNull(first)) {
			first.draw(g2d);
		}
		if (Objects.nonNull(next)) {
			next.draw(g2d);
		}
	}

	public GraphicCell createCell(int column) {

		GraphicCell newCell = new GraphicCell(sheet, this, column);

		if (Objects.isNull(first)) {
			first = newCell;
		} else {
			last.next = newCell;
			newCell.prev = last;
		}

		numberOfCells++;
		last = newCell;
		return last;
	}

	@Override
	public Iterator<GraphicCell> iterator() {
		return new GraphicCellIterator(first);
	}

	public int getIndex() {
		return index;
	}

	public int getNumberOfCells() {
		return numberOfCells;
	}

}