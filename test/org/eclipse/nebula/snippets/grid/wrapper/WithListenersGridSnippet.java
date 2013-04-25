package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.ColumnsFactory;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.listeners.EventData;
import org.eclipse.nebula.widgets.grid.wrapper.listeners.GridAdapter;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Grid with listeners
 */
public class WithListenersGridSnippet {

    private static Display display = new Display();

    public static class SimpleNodeFactory extends NodeFactory {

        @Override
        public void setNodeData(Node node, final Object object) {
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();
            values.put("name", new CellProperty(((PeopleDTO) object).getName()));
            values.put("age", new CellProperty(((PeopleDTO) object).getAge()));
            node.setCellPropertiesMap(values);
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        List<IColumn> columnsList = ColumnsFactory.createColumns(new String[] {"name", "age"});
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new SimpleNodeFactory(), columnsList);

        GridData gridData = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gridData.heightHint = 150;
        grid.setLayoutData(gridData);
        grid.setListener(new GridAdapter() {

            @Override
            public void leftClick(GridTable grid, EventData eventData) {
                if (eventData.getNode() != null) {
                    PeopleDTO people = (PeopleDTO) eventData.getNode().getRepresentedObject();
                    people.setMarried(!people.getMarried());
                    people.setAge(people.getAge() + 1);
                    try {
                        grid.changeNode(eventData.getNode(), people);
                    } catch (Exception e) {
                        display.dispose();
                    }
                }
            }
        });

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Grid with listeners");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}