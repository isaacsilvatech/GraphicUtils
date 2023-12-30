# GraphicUtils - Gere Imagens Semelhantes ao Excel

## Visão geral
Uma biblioteca Java para gerar facilmente imagens semelhantes ao Excel com estilos personalizáveis. Esta biblioteca fornece uma maneira simples de criar representações visuais de dados tabulares na forma de imagens. Se você deseja um instantâneo rápido de seus dados ou precisa incorporar imagens semelhantes às do Excel em seu aplicativo, esta biblioteca tem o que você precisa.

## Características
- **API simples:** API minimalista e fácil de entender para gerar imagens semelhantes a Excel.
- **Estilos personalizáveis:** defina estilos para títulos, linhas e rodapés para melhorar a aparência visual da sua imagem.
- **Entrada de dados flexível:** use uma lista de dados ou crie uma planilha linha por linha com valores de células explícitos.

## Exemlos

### Exemplo Simples 1:
```
    		List<Object[]> lista = getList();
		
		List<GraphicColumn> colunas = new ArrayList<>();

		colunas.add(new GraphicColumn("Nome", 0, GraphicType.STRING));
		colunas.add(new GraphicColumn("Idade", 1, GraphicType.INT));
		colunas.add(new GraphicColumn("Saldo", 2, GraphicType.CURRENCY));
		
		GraphicSheet sheet = GraphicUtils.getGraphic(colunas, lista);
		
		ImageIO.write(sheet.getImage(), "PNG", new File("C:\\Users\\DEV\\Downloads\\Imagem.PNG"));
```
### Exemplo Simples 2:
```
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
```

### Exemplo Estiloso 1:
```
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
```

### Exemplo Estiloso 2:
```
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
```
