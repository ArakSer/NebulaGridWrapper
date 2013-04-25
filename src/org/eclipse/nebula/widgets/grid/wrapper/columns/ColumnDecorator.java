/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    barsukov.dmytro@gmail.com    - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.grid.wrapper.columns;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;

/**
 * Base class for column wrappers which specify specific properties of concrete column.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public abstract class ColumnDecorator implements IColumn {

    private IColumn column;

    public ColumnDecorator(IColumn column) {
        this.column = column;
    }

    protected IColumn getColumn() {
        return column;
    }

    public ColumnStyle getStyle() {
        return column.getStyle();
    }

    public String getText() {
        return column.getText();
    }

    public String getTooltip() {
        return column.getTooltip();
    }

    public String getHeaderTooltip() {
        return column.getHeaderTooltip();
    }

    public int getWidth() {
        return column.getWidth();
    }

    public Image getImage() {
        return column.getImage();
    }

    public Font getHeaderFont() {
        return column.getHeaderFont();
    }

    public Font getFont() {
        return column.getFont();
    }

    public boolean isWordWrap() {
        return column.isWordWrap();
    }

    public boolean isMoveable() {
        return column.isMoveable();
    }

    public Color getTextColor() {
        return column.getTextColor();
    }

    public Color getBackgroundColor() {
        return column.getBackgroundColor();
    }

    public boolean isSortable() {
        return column.isSortable();
    }

    public boolean isResizeable() {
        return column.isResizeable();
    }

    public boolean isVisible() {
        return column.isVisible();
    }

    public boolean isAutoResizeable() {
        return column.isAutoResizeable();
    }

    public CellProperty processProperty(CellProperty property) {
        property = getColumn().processProperty(property);
        if (property != null) {
            if (property.getValue() != null) {
                processAdditional(property);
            }
        }
        return property;
    }

    /**
     * Children classes have to implement their specific behavior.
     */
    protected abstract CellProperty processAdditional(CellProperty property);

}
