package tech.isaacsilva.xls.graphic;

public class GraphicColumn {

	private String title;
	private int index;
	private GraphicType type;

	private GraphicStyle rowStyle = new GraphicStyle();
	private GraphicStyle titleStyle = new GraphicStyle();;
	private GraphicStyle footerStyle = new GraphicStyle();;
	private boolean footerEnabled;
	private GraphicValueFn footerValueFn;

	public GraphicColumn(String title, int index, GraphicType type) {
		this.title = title;
		this.index = index;
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public GraphicType getType() {
		return type;
	}

	public void setType(GraphicType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GraphicStyle getTitleStyle() {
		return titleStyle;
	}

	public void setTitleStyle(GraphicStyle titleStyle) {
		this.titleStyle = titleStyle.clone();
	}

	public GraphicStyle getFooterStyle() {
		return footerStyle;
	}

	public void setFooterStyle(GraphicStyle footerStyle) {
		this.footerStyle = footerStyle.clone();
	}

	public boolean isFooterEnabled() {
		return footerEnabled;
	}

	public void setFooterEnabled(boolean footerEnabled) {
		this.footerEnabled = footerEnabled;
	}

	public void setFooterValueFn(GraphicValueFn footerValueFn) {
		this.footerValueFn = footerValueFn;
	}

	public GraphicValueFn getFooterValueFn() {
		return footerValueFn;
	}

	public GraphicStyle getRowStyle() {
		return rowStyle;
	}

	public void setRowStyle(GraphicStyle rowStyle) {
		this.rowStyle = rowStyle.clone();
	}
}
