package org.eclipse.nebula.snippets.grid.wrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.snippets.grid.wrapper.data.PeopleDTO;
import org.eclipse.nebula.snippets.grid.wrapper.data.TestDataProvider;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.nebula.widgets.formattedtext.NumberFormatter;
import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.ColumnsFactory;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.editors.Editor;
import org.eclipse.nebula.widgets.grid.wrapper.editors.FormattedTextEditor;
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
 * Grid where editor is added after click
 */
public class WithAddingEditorGridSnippet {
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
        final GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new SimpleNodeFactory(), columnsList);

        GridData gridData = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        grid.setLayoutData(gridData);
        grid.setListener(new GridAdapter() {

            @Override
            public void leftClick(GridTable grid, EventData eventData) {
                if ((eventData.getNode() != null) && (eventData.getColumn() != null) && ("age".equals(eventData.getColumn().getText()))) {
                    grid.removeAllAddedEditors();
                    PeopleDTO people = (PeopleDTO) eventData.getNode().getRepresentedObject();
                    FormattedText textAge = new FormattedText(grid.getComposite(), SWT.BORDER);
                    textAge.setFormatter(new NumberFormatter("###"));
                    textAge.setValue(people.getAge());// Please set formatter
                                                      // first
                    Editor editor = new FormattedTextEditor(textAge) {
                        protected void modifyCell(GridTable grid, Node node, FormattedText text) {
                            System.out.println("New cell value: " + text.getValue());
                            Number value = (Number)text.getValue();
                            if (value == null) {
                                value = 0;
                            }
                            ((PeopleDTO) node.getRepresentedObject()).setAge((value).intValue());
                            try {
                                grid.refreshNode(node);
                            } catch (Exception e) {
                                display.dispose();
                            }
                        }
                    };
                    try {
                        grid.addEditor(eventData.getNode(), eventData.getColumn(), editor);
                    } catch (Exception e) {
                        display.dispose();
                    }
                }
            }
        });

        grid.setData(TestDataProvider.getPeople());

        shell.setText("Grid where editor is added after click");
        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();
    }
}