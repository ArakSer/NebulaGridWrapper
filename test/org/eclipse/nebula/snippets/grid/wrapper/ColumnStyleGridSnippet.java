package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.columns.MarriedColumn;
import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.Column;
import org.eclipse.nebula.widgets.grid.wrapper.columns.ColumnStyle;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeFactory;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Grid with column styles
 */
public class ColumnStyleGridSnippet {

    private static Display display = new Display();

    private static class MarriedNodeFactory extends NodeFactory {

        @Override
        public void setNodeData(Node node, final Object object) {
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();
            values.put("name", new CellProperty(((PeopleDTO)object).getName()));
            values.put("age", new CellProperty(((PeopleDTO)object).getAge()));
            values.put("married", new CellProperty(((PeopleDTO)object).getMarried()));
            node.setCellPropertiesMap(values);
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        List<IColumn> columnsList = new ArrayList<IColumn>();
        columnsList.add(Column.createColumn("name").setStyle(ColumnStyle.CENTER));
        columnsList.add(Column.createColumn("age").setStyle(ColumnStyle.RIGHT));
        columnsList.add(new MarriedColumn(Column.createColumn("married").setStyle(ColumnStyle.LEFT)));
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new MarriedNodeFactory(), columnsList);

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Grid with column styles");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}