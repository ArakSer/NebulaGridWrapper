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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Grid with selection
 */
public class WithSelectionGridSnippet {
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
        shell.setLayout(new GridLayout(1, false));

        List<IColumn> columnsList = new ArrayList<IColumn>();
        columnsList.add(Column.createColumn("name").setWidth(100));
        columnsList.add(Column.createColumn("age"));
        Composite cmpGrid = new Composite(shell, SWT.NONE);
        cmpGrid.setLayout(new GridLayout(1, false));
        final GridTable grid = new GridTable(cmpGrid, GridTable.MULTISELECT_STYLE, new SimpleNodeFactory(), columnsList);

        GridData gridData = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        grid.setLayoutData(gridData);
        Button btnSaveYears = new Button(shell, SWT.NONE);
        btnSaveYears.setText("Select people yonger 21");
        btnSaveYears.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                grid.deselectAll();
                List<Node> selectedNodes = new ArrayList<Node>();
                for (Node node : grid.getNodes()) {
                    if (((PeopleDTO) node.getRepresentedObject()).getAge() < 21) {
                        selectedNodes.add(node);
                    }
                }
                grid.select(selectedNodes);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Grid with selection");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}