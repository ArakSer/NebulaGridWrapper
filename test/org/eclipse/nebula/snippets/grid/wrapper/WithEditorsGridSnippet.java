package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.nebula.widgets.formattedtext.NumberFormatter;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.cells.EditedCellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.Column;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.editors.Editor;
import org.eclipse.nebula.widgets.grid.wrapper.editors.FormattedTextEditor;
import org.eclipse.nebula.widgets.grid.wrapper.editors.TextEditor;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.NodeFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Grid with editors
 */
public class WithEditorsGridSnippet {

    private static Display display = new Display();

    private static class EditorsNodeFactory extends NodeFactory {

        @Override
        public void setNodeData(Node node, final Object object) {
            PeopleDTO people = (PeopleDTO) object;
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();

            Text txtName = new Text(getComposite(), SWT.BORDER);
            txtName.setText(people.getName());
            Editor dtrName = new TextEditor(txtName) {
                protected void modifyCell(GridTable grid, Node node, Text text) {
                    ((PeopleDTO) node.getRepresentedObject()).setName(text.getText());
                }
            };
            values.put("name", new EditedCellProperty(people.getName(), dtrName).setMinimumWidth(100));

            FormattedText textAge = new FormattedText(getComposite(), SWT.BORDER);
            textAge.setFormatter(new NumberFormatter("###"));
            textAge.setValue(people.getAge());// Please set formatter first
            values.put("age", new EditedCellProperty(people.getAge(), new FormattedTextEditor(textAge) {
                protected void modifyCell(GridTable grid, Node node, FormattedText text) {
                    ((PeopleDTO) node.getRepresentedObject()).setAge(((Number) text.getValue()).intValue());
                }
            }));

            node.setCellPropertiesMap(values);
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        final List<PeopleDTO> people = TestDataProvider.getPeople();

        List<IColumn> columnsList = new ArrayList<IColumn>();
        columnsList.add(Column.createColumn("name").setWidth(100));
        columnsList.add(Column.createColumn("age"));
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new EditorsNodeFactory(), columnsList);

        GridData gridData = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gridData.heightHint = 150;
        gridData.minimumWidth = 300;
        grid.setLayoutData(gridData);

        Button btnSaveYears = new Button(shell, SWT.NONE);
        btnSaveYears.setText("Write table to console");
        btnSaveYears.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                for (PeopleDTO man : people) {
                    System.out.println(man.getName() + " " + man.getAge());
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        grid.setData(people);

        shell.setText("Grid with editors");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}