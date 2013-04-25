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

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;

/**
 * Wrapper column which specify foreground and background colors of column.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class ColorColumn extends ColumnDecorator {

    private Color textColor;
    private Color backgroundColor;

    public ColorColumn(IColumn column, Color color) {
        this(column, color, null);
    }

    public ColorColumn(IColumn column, Color textColor, Color backgroundColor) {
        super(column);
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public CellProperty processAdditional(CellProperty property) {
        property.setTextColor(textColor);
        property.setBackgroundColor(backgroundColor);
        return property;
    }
}
