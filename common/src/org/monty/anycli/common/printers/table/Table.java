package org.monty.anycli.common.printers.table;

import java.util.HashMap;

import org.monty.anycli.common.printers.CLI;

public class Table<Bean> implements CLI {
	
	
	private TableModel<Bean> model;
	
	
	
	public Table(TableModel<Bean> model) {
		this.model = model;
	}

	public void print() {
		if(model == null) return;
		int rowCount = model.getRowCount();
		
		for (int i = 0; i <= rowCount; i++) {
			printLine();
			if(i == 0) {
				printRow(null);
			} else {
				printRow(model.getData(i));
				if(i == rowCount) printLine();
			}
		}
	}
	
	
	
	private void printLine() {
		int colCount = model.getColumnCount();
		for (int colIndex = 1; colIndex <= colCount; colIndex++) {
			System.out.print("|");
			int width = model.getColumnWidth(colIndex);
			for (int i = 0; i < width; i++) {
				System.out.print("-");
			}
			if(colIndex == colCount) System.out.println("|");
		}
	}



	private void printRow(Bean data) {
		int colCount = model.getColumnCount();
		HashMap<Integer, String> dataRemaining = new HashMap<Integer, String>();
		do {
			for (int i = 1; i <= colCount; i++) {
				String val = null;
				if(dataRemaining.isEmpty()) {
					val = data == null ? model.getColumnName(i) : model.getValue(i, data);
				} else {
					val = dataRemaining.get(i);
				}
				String remains = printColumn(val, model.getColumnWidth(i), (i == colCount));
				if(remains == null) {
					dataRemaining.remove(i);
				} else {
					dataRemaining.put(i, remains);
				}
				
			}
		} while(!dataRemaining.isEmpty());
	}
	
	private String printColumn(String data, int width, boolean last) {
		
		data = data == null ? "" : data.trim();
		
		String printVal = null;
		String returnVal = null;
		if(data.length() > width) {
			printVal = data.substring(0, width);
			returnVal = data.substring(width);
		} else if(data.length() < width) {
			String buffer = getBuffer(width - data.length());
			printVal = data + buffer;
		} else {
			printVal = data;
		}
		System.out.print("|");
		System.out.print(printVal);
		if(last) System.out.println("|");
		return returnVal;
	}
	
	private String getBuffer(int size) {
		StringBuilder buffer = new StringBuilder();
		
		for (int i = 0; i < size; i++) {
			buffer.append(" ");
		}
		
		return buffer.toString();
	}
	
	
	public Table<Bean> withTableModel(TableModel<Bean> model) {
		this.model = model;
		return this;
	}

}
