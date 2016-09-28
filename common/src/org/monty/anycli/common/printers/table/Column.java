package org.monty.anycli.common.printers.table;

public class Column {
	
	
	private final String name;
	
	public int width;
	
	public boolean rightAligned;

	public Column(String name) {
		this.name = name;
	}
	
	public Column withWidth(int width) {
		this.width = width;
		return this;
	}
	
	public Column withRightAligned(boolean rightAligned) {
		this.rightAligned = rightAligned;
		return this;
	}

	public int getWidth() {
		return width;
	}

	public boolean isRightAligned() {
		return rightAligned;
	}

	public String getName() {
		return name;
	}
}
