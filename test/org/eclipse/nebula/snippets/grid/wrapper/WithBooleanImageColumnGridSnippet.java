package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.BooleanColumn;
import org.eclipse.nebula.widgets.grid.wrapper.columns.Column;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;

/**
 * Grid with boolean image column
 */
public class WithBooleanImageColumnGridSnippet {

    private static Display display = new Display();

    protected static final Image IMAGE_YES = ResourceManager.getImage("test/res/yes.png");
    protected static final Image IMAGE_NO = ResourceManager.getImage("test/res/no.png");

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
        columnsList.add(Column.createColumn("name"));
        columnsList.add(Column.createColumn("age"));
        columnsList.add(new BooleanColumn(Column.createColumn("married"), IMAGE_YES, IMAGE_NO));
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new MarriedNodeFactory(), columnsList);

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Grid with boolean image column");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}