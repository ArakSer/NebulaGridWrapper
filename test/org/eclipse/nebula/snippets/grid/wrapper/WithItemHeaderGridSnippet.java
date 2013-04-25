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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Grid with item headers
 */
public class WithItemHeaderGridSnippet {

    private static Display display = new Display();

    private static class WithItemHeaderNodeFactory extends NodeFactory {
        @Override
        public void setNodeData(Node node, final Object object) {
            node.setNodeProperty(new NodeProperty(((PeopleDTO)object).getName()));
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();
            values.put("age", new CellProperty(((PeopleDTO)object).getAge()));
            node.setCellPropertiesMap(values);
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        List<IColumn> columnsList = new ArrayList<IColumn>();
        columnsList.add(Column.createColumn("age"));
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new WithItemHeaderNodeFactory(), columnsList);
        grid.setRowHeaderVisible(true);

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Grid with item headers");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}