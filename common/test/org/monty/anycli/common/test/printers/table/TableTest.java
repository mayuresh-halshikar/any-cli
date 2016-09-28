package org.monty.anycli.common.test.printers.table;

import org.junit.Test;
import org.monty.anycli.common.printers.table.Table;
import org.monty.anycli.common.printers.table.TableModel;

public class TableTest {

	@Test
	public void testExecute() {
		
		
		TableModel<Object> model = new TableModel<Object>() {
			
			public String getValue(int colIndex, Object data) {
				return "ABCDEFGHIJ";
			}
			
			public int getRowCount() {
				return 5;
			}
			
			public Object getData(int rowIndex) {
				return new Object();
			}
			
			public int getColumnWidth(int colIndex) {
				switch(colIndex) {
				case 1: return 12;
				case 2: return 8;
				default: return 7;
				}
			}
			
			public String getColumnName(int colIndex) {
				return "Column-" + colIndex;
			}
			
			public int getColumnCount() {
				return 2;
			}
		};
		
		Table<Object> t = new Table<Object>(model);
		t.print();
	}
}
