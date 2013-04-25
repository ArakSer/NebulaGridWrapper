package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.Column;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeFactory;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Create a grid with an item that spans rows.
 * 
 * For a list of all Nebula Grid example snippets see
 * http://www.eclipse.org/nebula/widgets/grid/snippets.php
 */
public class WithColorHeadersGridSnippet {

    private static Display display = new Display();

    private static class ColorHeadersNodeFactory extends NodeFactory {

        @Override
        public void setNodeData(Node node, final Object object) {
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();
            values.put("name", new CellProperty(((PeopleDTO)object).getName()));
            values.put("age", new CellProperty(((PeopleDTO)object).getAge()));
            node.setCellPropertiesMap(values);
            NodeProperty nodeProperty = new NodeProperty();
            nodeProperty.setTextColor(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
            node.setNodeProperty(nodeProperty );
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        List<IColumn> columnsList = new ArrayList<IColumn>();
        columnsList.add(Column.createColumn("name").setHeaderFont(new Font(Display.getCurrent(), new FontData("Arial", 15, SWT.ITALIC))).setBackgroundColor(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN)));
        columnsList.add(Column.createColumn("age").setTextColor(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN)));
        columnsList.add(Column.createColumn("married"));
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new ColorHeadersNodeFactory(), columnsList);
        grid.setData(TestDataProvider.getPeople());
        grid.setRowHeaderVisible(true);

        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}