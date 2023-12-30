package tech.isaacsilva.xls.graphic.exemplo;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import tech.isaacsilva.xls.graphic.GraphicAlignment;
import tech.isaacsilva.xls.graphic.GraphicColor;
import tech.isaacsilva.xls.graphic.GraphicColumn;
import tech.isaacsilva.xls.graphic.GraphicSheet;
import tech.isaacsilva.xls.graphic.GraphicStyle;
import tech.isaacsilva.xls.graphic.GraphicType;
import tech.isaacsilva.xls.graphic.GraphicUtils;

public class ExemploEstiloso2 {

	public static void main(String[] args) throws IOException {

		List<Object[]> lista = getList();

		Font font = new Font("Arial", Font.BOLD, 24);

		// ESTILO - TITULO
		GraphicStyle titleStyle = new GraphicStyle();
		titleStyle.setBackgroundColor(GraphicColor.BLACK);
		titleStyle.setColor(GraphicColor.WHITE);
		titleStyle.setBorderWidth(2);
		titleStyle.setBorderColor(GraphicColor.BLACK);
		titleStyle.setFont(font);

		// ESTILO - FOOTER
		GraphicStyle footerStyle = titleStyle.clone();

		// ESTILO - ROW
		GraphicStyle rowStyle = titleStyle.clone();
		rowStyle.setBackgroundColor(GraphicColor.WHITE);
		rowStyle.setColor(GraphicColor.BLACK);

		int index = 0;

		List<GraphicColumn> colunas = new ArrayList<>();

		GraphicColumn column;

		column = new GraphicColumn("Nome", index++, GraphicType.STRING);
		column.setTitleStyle(titleStyle);
		column.setRowStyle(rowStyle);
		column.setFooterEnabled(true);
		column.setFooterStyle(footerStyle);
		column.setFooterValueFn(valuesOfColumn -> "Total");
		colunas.add(column);

		column = new GraphicColumn("Idade", index++, GraphicType.INT);
		column.setTitleStyle(titleStyle);
		column.setRowStyle(rowStyle);
		column.setFooterEnabled(true);
		column.setFooterStyle(footerStyle);
		colunas.add(column);

		column = new GraphicColumn("Saldo", index, GraphicType.CURRENCY);
		column.setTitleStyle(titleStyle);
		column.setRowStyle(rowStyle);
		column.getRowStyle().setAlignment(GraphicAlignment.END);
		column.setFooterEnabled(true);
		column.setFooterStyle(footerStyle);
		column.getFooterStyle().setAlignment(GraphicAlignment.END);
		column.setFooterValueFn(valuesOfColumn -> {

			BigDecimal total = BigDecimal.ZERO;

			for (Object value : valuesOfColumn) {
				total = total.add((BigDecimal) value);
			}

			return GraphicType.CURRENCY.format(total.toString());
		});
		colunas.add(column);

		GraphicSheet sheet = GraphicUtils.getGraphic(colunas, lista);

		ImageIO.write(sheet.getImage(), "PNG", new File("C:\\Users\\DEV\\Downloads\\Imagem2.PNG"));
	}

	private static List<Object[]> getList() {

		List<Object[]> lista = new ArrayList<>();

		Object[] o1 = new Object[3];

		o1[0] = "Isaac";
		o1[1] = 17;
		o1[2] = new BigDecimal("325.52");

		Object[] o2 = new Object[3];

		o2[0] = "Gabriel";
		o2[1] = 19;
		o2[2] = new BigDecimal("325.52");

		Object[] o3 = new Object[3];

		o3[0] = "Rebeca";
		o3[1] = 18;
		o3[2] = new BigDecimal("325.52");

		lista.add(o1);
		lista.add(o2);
		lista.add(o3);

		return lista;
	}

}
