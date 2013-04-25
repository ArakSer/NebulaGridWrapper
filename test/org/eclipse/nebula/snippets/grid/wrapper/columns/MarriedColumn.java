package org.eclipse.nebula.snippets.grid.wrapper.columns;

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.columns.ColumnDecorator;
import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;

public class MarriedColumn extends ColumnDecorator {

    protected static final Image IMAGE_YES = ResourceManager.getImage("test/res/yes.png");
    protected static final Image IMAGE_NO = ResourceManager.getImage("test/res/no.png");

    public MarriedColumn(IColumn column) {
        super(column);
    }
    @Override
    public CellProperty processAdditional(CellProperty property) {
        property.setText("");
        if (((Boolean)property.getValue())) {
            property.setImage(IMAGE_YES);
        } else {
            property.setImage(IMAGE_NO);
        }
        return property;
    }
}
