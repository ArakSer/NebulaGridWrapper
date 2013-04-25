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

import java.text.DecimalFormat;
import java.util.Date;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.utils.DateTimeUtils;

/**
 * Java bean which contains information about column.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class Column implements IColumn {

    private static final int DEFAULT_WIDTH = 100;

    private String text;
    private String tooltip;
    private String headerTooltip;
    private Image image;
    private Font headerFont;
    private Font font;
    private Color textColor;
    private Color backgroundColor;
    private int width = DEFAULT_WIDTH;
    private ColumnStyle style = ColumnStyle.NONE;
    private boolean moveable = true;
    private boolean sortable = true;
    private boolean resizeable = true;
    private boolean visible = true;
    private boolean wordWrap = false;
    private boolean autoResizeable = true;

    protected Column(String text) {
        this.text = text;
    }

    public static Column createColumn(String columnName) {
        return new Column(columnName);
    }

    public String getTooltip() {
        return tooltip;
    }

    public Column setTooltip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public String getHeaderTooltip() {
        return headerTooltip;
    }

    public Column setHeaderTooltip(String tooltip) {
        this.headerTooltip = tooltip;
        return this;
    }

    public String getText() {
        return text;
    }

    public Column setText(String text) {
        this.text = text;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public Column setImage(Image image) {
        this.image = image;
        return this;
    }

    public Font getHeaderFont() {
        return headerFont;
    }

    public Column setHeaderFont(Font headerFont) {
        this.headerFont = headerFont;
        return this;
    }

    public Font getFont() {
        return font;
    }

    public Column setFont(Font font) {
        this.font = font;
        return this;
    }

    public Color getTextColor() {
        return textColor;
    }

    public Column setTextColor(Color textColor) {
        this.textColor = textColor;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Column setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Column setWidth(int width) {
        this.width = width;
        setAutoResizeable(false);
        return this;
    }

    public ColumnStyle getStyle() {
        return style;
    }

    public Column setStyle(ColumnStyle style) {
        this.style = style;
        return this;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public Column setMoveable(boolean moveable) {
        this.moveable = moveable;
        return this;
    }

    public boolean isSortable() {
        return sortable;
    }

    public Column setSortable(boolean sortable) {
        this.sortable = sortable;
        return this;
    }

    public boolean isResizeable() {
        return resizeable;
    }

    public Column setResizeable(boolean resizeable) {
        this.resizeable = resizeable;
        return this;
    }

    public boolean isVisible() {
        return visible;
    }

    public Column setVisible(boolean visible) {
        this.visible = visible;
        return this;
    }

    public boolean isWordWrap() {
        return wordWrap;
    }

    public Column setWordWrap(boolean wordWrap) {
        this.wordWrap = wordWrap;
        return this;
    }

    public boolean isAutoResizeable() {
        return autoResizeable;
    }

    public Column setAutoResizeable(boolean autoResizeable) {
        this.autoResizeable = autoResizeable;
        return this;
    }

    public CellProperty processProperty(CellProperty property) {
        if (property == null) {
            property = new CellProperty(GridTable.EMPTY_FIELD);
        }
        if (property.getValue() != null) {
            Object value = property.getValue();
            fillCellValue(property, value);
        } else {
            property.setText(GridTable.EMPTY_FIELD);
        }
        return property;
    }

    static void fillCellValue(CellProperty property, Object value) {
        String text = "";
        Image image = null;
        if (value instanceof Date) {
            text = DateTimeUtils.formatDateTimeFull((Date) value);
        } else if ((value instanceof Float) || (value instanceof Double)) {
            text = new DecimalFormat("#.##").format(value);
        } else if (value instanceof Image) {
            image = (Image) value;
        } else {
            if (value != null) {
                text = value.toString();
            } else {
                text = GridTable.EMPTY_FIELD;
            }
        }
        property.setText(text);
        property.setImage(image);
    }
}
