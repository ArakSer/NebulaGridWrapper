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

import org.eclipse.swt.graphics.Image;

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;

/**
 * Wrapper column which shows image in the cell. It should be used as an
 * alternative of button, because the picture is the same for all cells.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class StaticImageColumn extends ColumnDecorator {

    private Image image;

    public StaticImageColumn(IColumn column, Image image) {
        super(column);
        this.image = image;
    }

    @Override
    public CellProperty processAdditional(CellProperty property) {
        property.setImage(image);
        return property;
    }

}
