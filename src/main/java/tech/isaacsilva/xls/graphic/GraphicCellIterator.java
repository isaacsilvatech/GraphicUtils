package tech.isaacsilva.xls.graphic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class GraphicCellIterator implements Iterator<GraphicCell> {

	private GraphicCell next;

	public GraphicCellIterator(GraphicCell next) {
		this.next = next;
	}

	@Override
	public boolean hasNext() {
		return Objects.nonNull(next);
	}

	@Override
	public GraphicCell next() {

		if (Objects.isNull(next)) {
	        throw new NoSuchElementException();
	    }

	    GraphicCell current = next;

	    if (Objects.nonNull(next.next)) {
	        next = next.next;
	    } else {
	        next = null;
	    }

		return current;
	}

}
