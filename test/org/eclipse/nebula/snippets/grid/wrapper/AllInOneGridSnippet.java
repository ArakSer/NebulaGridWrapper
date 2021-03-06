package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.columns.TooltipsColumn;
import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.BooleanColumn;
import org.eclipse.nebula.widgets.grid.wrapper.columns.Column;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeFactory;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;

/**
 * Multiselect grid with specified row height
 * 
 */
public class AllInOneGridSnippet {

    private static Display display = new Display();

    protected static final Image IMAGE_YES = ResourceManager.getImage("test/res/yes.png");
    protected static final Image IMAGE_NO = ResourceManager.getImage("test/res/no.png");

    private static class AllInOneNodeFactory extends NodeFactory {

        @Override
        public void setNodeData(Node node, final Object object) {
            NodeProperty nodeProperty = new NodeProperty(((PeopleDTO) object).getName());
            node.setNodeProperty(nodeProperty);
            node.setHeight(50);
            if (((PeopleDTO) object).getAge() < 18) {
                node.setTooltip("<18");
            }
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();
            values.put("age", new CellProperty(((PeopleDTO) object).getAge()));
            values.put("married", new CellProperty(((PeopleDTO) object).getMarried()));
            node.setCellPropertiesMap(values);
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        List<IColumn> columnsList = new ArrayList<IColumn>();
        columnsList
                .add(new TooltipsColumn(Column.createColumn("age")
                        .setFont(new Font(Display.getCurrent(), new FontData("Arial", 15, SWT.ITALIC)))
                        .setHeaderTooltip("age")));
        columnsList.add(new BooleanColumn(Column.createColumn("married").setHeaderTooltip("married"), IMAGE_YES,
                IMAGE_NO));
        GridTable grid = new GridTable(shell, GridTable.MULTISELECT_STYLE, new AllInOneNodeFactory(), columnsList);
        grid.setRowHeaderVisible(true);
        grid.setRowsResizeable(true);
        grid.setItemHeight(50);

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Multiselect grid with specified row height");
        shell.setSize(200, 300);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}