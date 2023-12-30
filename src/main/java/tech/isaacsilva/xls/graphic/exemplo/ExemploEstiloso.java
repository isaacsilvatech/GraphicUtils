package tech.isaacsilva.xls.graphic.exemplo;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tech.isaacsilva.xls.graphic.GraphicCell;
import tech.isaacsilva.xls.graphic.GraphicColor;
import tech.isaacsilva.xls.graphic.GraphicRow;
import tech.isaacsilva.xls.graphic.GraphicSheet;
import tech.isaacsilva.xls.graphic.GraphicStyle;

public class ExemploEstiloso {

	public static void main(String[] args) throws IOException {

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

		GraphicSheet sheet = new GraphicSheet();

		GraphicRow row;
		GraphicCell cell;

		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setValue("Nome");
		cell.setStyle(titleStyle);
		cell = row.createCell(1);
		cell.setValue("Idade");
		cell.setStyle(titleStyle);
		cell = row.createCell(2);
		cell.setValue("Saldo");
		cell.setStyle(titleStyle);

		row = sheet.createRow(1);

		cell = row.createCell(0);
		cell.setValue("Isaac");
		cell.setStyle(rowStyle);
		cell = row.createCell(1);
		cell.setValue("17");
		cell.setStyle(rowStyle);
		cell = row.createCell(2);
		cell.setValue("R$ 369.99");
		cell.setStyle(rowStyle);

		row = sheet.createRow(2);

		cell = row.createCell(0);
		cell.setValue("Rebeca");
		cell.setStyle(rowStyle);
		cell = row.createCell(1);
		cell.setValue("17");
		cell.setStyle(rowStyle);
		cell = row.createCell(2);
		cell.setValue("R$ 369.99");
		cell.setStyle(rowStyle);

		row = sheet.createRow(3);

		cell = row.createCell(0);
		cell.setValue("Gabriel");
		cell.setStyle(rowStyle);
		cell = row.createCell(1);
		cell.setValue("17");
		cell.setStyle(rowStyle);
		cell = row.createCell(2);
		cell.setValue("R$ 369.99");
		cell.setStyle(rowStyle);
		
		row = sheet.createRow(4);

		cell = row.createCell(0);
		cell.setValue("Total");
		cell.setStyle(footerStyle);
		cell = row.createCell(1);
		cell.setStyle(footerStyle);
		cell = row.createCell(2);
		cell.setValue("R$ 1.109,97");
		cell.setStyle(footerStyle);

		ImageIO.write(sheet.getImage(), "PNG", new File("C:\\Users\\DEV\\Downloads\\Imagem3.PNG"));
	}
}
