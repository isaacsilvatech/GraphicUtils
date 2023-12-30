package tech.isaacsilva.xls.graphic.exemplo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tech.isaacsilva.xls.graphic.GraphicRow;
import tech.isaacsilva.xls.graphic.GraphicSheet;

public class ExemploSimples2 {
	
	public static void main(String[] args) throws IOException {
		
		GraphicSheet sheet = new GraphicSheet();
		
		GraphicRow row;
		
		row =  sheet.createRow(0);
		row.createCell(0).setValue("Nome");
		row.createCell(1).setValue("Idade");
		row.createCell(2).setValue("Saldo");
		
		row =  sheet.createRow(1);
		row.createCell(0).setValue("Isaac");
		row.createCell(1).setValue("17");
		row.createCell(2).setValue("R$ 555.25");
		
		row =  sheet.createRow(2);
		row.createCell(0).setValue("Rebeca");
		row.createCell(1).setValue("17");
		row.createCell(2).setValue("R$ 555.25");
		
		row =  sheet.createRow(3);
		row.createCell(0).setValue("Gabriel");
		row.createCell(1).setValue("17");
		row.createCell(2).setValue("R$ 555.25");
		
		ImageIO.write(sheet.getImage(), "PNG", new File("C:\\Users\\DEV\\Downloads\\Imagem.PNG"));
	}
}
