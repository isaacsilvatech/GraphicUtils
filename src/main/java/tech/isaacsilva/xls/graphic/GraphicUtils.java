package tech.isaacsilva.xls.graphic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.imageio.ImageIO;

public class GraphicUtils {

	public static byte[] toByteArray(BufferedImage bi) throws IOException {
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		ImageIO.write(bi, "PNG", outByteStream);
		return outByteStream.toByteArray();
	}

	public static byte[] toByteArray(GraphicSheet sheet) throws IOException {
		return toByteArray(sheet.getImage());
	}

	public static GraphicSheet getGraphic(List<GraphicColumn> columns, List<Object[]> list,
			GraphicCustomCellFn customCellFn) {

		GraphicSheet sheet = new GraphicSheet();

		createTitle(sheet, columns);
		createData(sheet, columns, list, customCellFn);
		createFooter(sheet, columns, list);

		return sheet;
	}

	private static void createTitle(GraphicSheet sheet, List<GraphicColumn> columns) {

		GraphicRow row = sheet.createRow(0);

		for (int numberOfColumn = 0; numberOfColumn < columns.size(); numberOfColumn++) {

			GraphicColumn column = columns.get(numberOfColumn);
			GraphicCell cell = row.createCell(numberOfColumn);

			cell.setStyle(column.getTitleStyle());
			cell.setValue(column.getTitle());
		}
	}

	private static void createFooter(GraphicSheet sheet, List<GraphicColumn> columns, List<Object[]> list) {

		int lastIndex = sheet.getNumberOfRows();
		GraphicRow row = sheet.createRow(lastIndex);

		for (int numberOfColumn = 0; numberOfColumn < columns.size(); numberOfColumn++) {

			GraphicColumn column = columns.get(numberOfColumn);

			if (column.isFooterEnabled()) {
				GraphicCell cell = row.createCell(numberOfColumn);

				cell.setStyle(column.getFooterStyle());
				GraphicValueFn footerValueFn = column.getFooterValueFn();
				if(Objects.nonNull(footerValueFn)) {
					cell.setValue(footerValueFn.getValue(getValuesOfColumn(column, list)));
				}
			}
		}
	}

	private static List<Object> getValuesOfColumn(GraphicColumn column, List<Object[]> list) {

		List<Object> valuesOfColumn = new ArrayList<>();

		for (Object[] objectRow : list) {
			valuesOfColumn.add(objectRow[column.getIndex()]);
		}

		return valuesOfColumn;
	}

	private static void createData(GraphicSheet sheet, List<GraphicColumn> columns, List<Object[]> list,
			GraphicCustomCellFn customCellFn) {

		for (int numberOfRow = 0; numberOfRow < list.size(); numberOfRow++) {

			GraphicRow row = sheet.createRow(numberOfRow + 1);
			Object[] objectRow = list.get(numberOfRow);

			for (int numberOfColumn = 0; numberOfColumn < columns.size(); numberOfColumn++) {

				GraphicColumn column = columns.get(numberOfColumn);
				GraphicCell cell = row.createCell(numberOfColumn);

				Object cellValue = objectRow[column.getIndex()];

				GraphicCustomCell customCell = null;
				if (Objects.nonNull(customCellFn)) {
					customCell = new GraphicCustomCell();
					customCell.setObjectRow(objectRow);
					customCell.setStyle(column.getRowStyle());
					customCellFn.apply(customCell);
				}

				GraphicStyle style = Objects.isNull(customCell) ? column.getRowStyle() : customCell.getStyle();
				cell.setStyle(style);
				cell.setValue(column.getType().format(cellValue.toString()));
			}
		}
	}

	public static byte[] getBytes(List<GraphicColumn> colunas, List<Object[]> lista) throws IOException {
		return getBytes(colunas, lista, null);
	}

	public static byte[] getBytes(List<GraphicColumn> colunas, List<Object[]> lista, GraphicCustomCellFn customCellFn)
			throws IOException {

		GraphicSheet sheet = getGraphic(colunas, lista, customCellFn);

		return toByteArray(sheet);
	}

	public static GraphicSheet getGraphic(List<GraphicColumn> colunas, List<Object[]> lista) throws IOException {
		
		GraphicSheet sheet = getGraphic(colunas, lista, null);
		
		return sheet;
	}

}
