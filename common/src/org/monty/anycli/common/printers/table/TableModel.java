package org.monty.anycli.common.printers.table;

import org.monty.anycli.common.models.Model;

public interface TableModel<Bean> extends Model<Bean> {
	int getColumnCount();
	int getRowCount();
	Bean getData(int rowIndex);
	String getValue(int colIndex, Bean data);
	String getColumnName(int colIndex);
	int getColumnWidth(int colIndex);
}
