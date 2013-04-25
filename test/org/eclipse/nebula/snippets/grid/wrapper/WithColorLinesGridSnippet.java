package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.ColorColumn;
import org.eclipse.nebula.widgets.grid.wrapper.columns.Column;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Grid with color lines
 */
public class WithColorLinesGridSnippet {

    private static Display display = new Display();

    private static class ColorLinesNodeFactory extends NodeFactory {

        @Override
        public void setNodeData(Node node, final Object object) {
            if (((PeopleDTO)object).getAge() < 20) {
                node.setTextColor(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
                node.setFont(new Font(Display.getCurrent(), new FontData("Arial", 20, SWT.ITALIC)));
                node.setBackgroundColor(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE));
            }
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();
            values.put("name", new CellProperty(((PeopleDTO)object).getName()));
            values.put("age", new CellProperty(((PeopleDTO)object).getAge()));
            node.setCellPropertiesMap(values);
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        List<IColumn> columnsList = new ArrayList<IColumn>();
        columnsList.add(new ColorColumn(Column.createColumn("name").setHeaderTooltip("name"), Display.getCurrent().getSystemColor(SWT.COLOR_GREEN)));
        columnsList.add(Column.createColumn("age").setHeaderTooltip("age"));
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new ColorLinesNodeFactory(), columnsList);

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Grid with color lines");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}