package org.eclipse.nebula.snippets.grid.wrapper.columns;

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.ColumnDecorator;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class ColorAgeColumn extends ColumnDecorator {
    
    public ColorAgeColumn(IColumn column) {
        super(column);
    }
    @Override
    public CellProperty processAdditional(CellProperty property) {
        if (((Integer)property.getValue()) < 18) {
            property.setTextColor(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
        } else if (((Integer)property.getValue()) < 21) {
            property.setTextColor(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
        }
        return property;
    }
}
