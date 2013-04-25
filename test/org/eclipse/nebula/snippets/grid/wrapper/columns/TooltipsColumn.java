package org.eclipse.nebula.snippets.grid.wrapper.columns;

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.ColumnDecorator;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;

public class TooltipsColumn extends ColumnDecorator {
    
    public TooltipsColumn(IColumn column) {
        super(column);
    }
    @Override
    public CellProperty processAdditional(CellProperty property) {
        property.setToolTip(getColumn().getText() + " = " + property.getText());
        return property;
    }
}
