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
 * Specify all column properties
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public interface IColumn {

    public ColumnStyle getStyle();

    public Color getTextColor();

    public Color getBackgroundColor();

    public String getText();

    public String getTooltip();

    public String getHeaderTooltip();

    public Image getImage();

    public Font getHeaderFont();

    public Font getFont();

    public int getWidth();

    public boolean isWordWrap();

    public boolean isMoveable();

    public boolean isSortable();

    public boolean isResizeable();

    public boolean isVisible();

    public boolean isAutoResizeable();

    public CellProperty processProperty(CellProperty property);
}
