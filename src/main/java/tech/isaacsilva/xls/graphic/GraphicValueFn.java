package tech.isaacsilva.xls.graphic;

import java.util.List;

@FunctionalInterface
public interface GraphicValueFn {

	String getValue(List<Object> valuesOfColumn);
}
