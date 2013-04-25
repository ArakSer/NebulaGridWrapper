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

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;

/**
 * Column, which displays one of two objects ​​depending on the value of the cell
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class BooleanColumn extends ColumnDecorator {

    private Object trueObject;
    private Object falseObject;

    public BooleanColumn(IColumn column, Object trueObject, Object falseObject) {
        super(column);
        this.trueObject = trueObject;
        this.falseObject = falseObject;
    }

    @Override
    public CellProperty processAdditional(CellProperty property) {
        if (property.getValue() instanceof Boolean) {
            if ((Boolean) property.getValue()) {
                Column.fillCellValue(property, trueObject);
            } else {
                Column.fillCellValue(property, falseObject);
            }
        }
        return property;
    }

}
