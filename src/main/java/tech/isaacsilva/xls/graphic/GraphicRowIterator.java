package tech.isaacsilva.xls.graphic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class GraphicRowIterator implements Iterator<GraphicRow> {

	private GraphicRow next;

	public GraphicRowIterator(GraphicRow next) {
		this.next = next;
	}

	@Override
	public boolean hasNext() {
		return Objects.nonNull(next);
	}

	@Override
	public GraphicRow next() {

		if (Objects.isNull(next)) {
	        throw new NoSuchElementException();
	    }

		GraphicRow current = next;

	    if (Objects.nonNull(next.next)) {
	        next = next.next;
	    } else {
	        next = null;
	    }

		return current;
	}
}
