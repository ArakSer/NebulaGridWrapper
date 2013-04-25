/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    barsukov.dmytro@gmail.com    - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.grid.wrapper.nodes;

import java.util.Map;

import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;

/**
 * Java bean which contains information about grid item.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class Node {

    private String tooltip;
    private Color textColor;
    private Color backgroundColor;
    private Font font;
    private int height;
    private Map<String, CellProperty> cellPropertiesMap;
    private NodeProperty nodeProperty;
    private Object representedObject;
    private GridItem gridItem;

    public Color getTextColor() {
        return textColor;
    }

    public Node setTextColor(Color textColor) {
        this.textColor = textColor;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Node setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Font getFont() {
        return font;
    }

    public Node setFont(Font font) {
        this.font = font;
        return this;
    }

    public Map<String, CellProperty> getCellPropertiesMap() {
        return cellPropertiesMap;
    }

    public Node setCellPropertiesMap(Map<String, CellProperty> cellPropertiesMap) {
        this.cellPropertiesMap = cellPropertiesMap;
        return this;
    }

    public NodeProperty getNodeProperty() {
        return nodeProperty;
    }

    public Node setNodeProperty(NodeProperty nodeProperty) {
        this.nodeProperty = nodeProperty;
        return this;
    }

    public String getTooltip() {
        return tooltip;
    }

    public Node setTooltip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Node setHeight(int height) {
        this.height = height;
        return this;
    }

    public Object getRepresentedObject() {
        return representedObject;
    }

    public Node setRepresentedObject(Object representedObject) {
        this.representedObject = representedObject;
        return this;
    }

    public GridItem getGridItem() {
        return gridItem;
    }

    public void setGridItem(GridItem gridItem) {
        this.gridItem = gridItem;
    }

}
