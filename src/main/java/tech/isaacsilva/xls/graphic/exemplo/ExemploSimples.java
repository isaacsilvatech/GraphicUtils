package tech.isaacsilva.xls.graphic.exemplo;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import tech.isaacsilva.xls.graphic.GraphicColumn;
import tech.isaacsilva.xls.graphic.GraphicSheet;
import tech.isaacsilva.xls.graphic.GraphicType;
import tech.isaacsilva.xls.graphic.GraphicUtils;

public class ExemploSimples {
	
	public static void main(String[] args) throws IOException {
		
		List<Object[]> lista = getList();
		
		List<GraphicColumn> colunas = new ArrayList<>();

		colunas.add(new GraphicColumn("Nome", 0, GraphicType.STRING));
		colunas.add(new GraphicColumn("Idade", 1, GraphicType.INT));
		colunas.add(new GraphicColumn("Saldo", 2, GraphicType.CURRENCY));
		
		GraphicSheet sheet = GraphicUtils.getGraphic(colunas, lista);
		
		ImageIO.write(sheet.getImage(), "PNG", new File("C:\\Users\\DEV\\Downloads\\Imagem.PNG"));
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
