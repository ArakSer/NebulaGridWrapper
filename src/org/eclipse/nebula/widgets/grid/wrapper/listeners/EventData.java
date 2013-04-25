/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    barsukov.dmytro@gmail.com    - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.grid.wrapper.listeners;

import org.eclipse.nebula.widgets.grid.wrapper.columns.IColumn;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;

/**
 * Contains information about grid event. Used when user click to grid or select item.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class EventData {

    private IColumn column;
    private Node node;
    private boolean headerClicked;

    public EventData() {
    }

    public EventData(IColumn column, Node node) {
        this.column = column;
        this.node = node;
    }

    public EventData(IColumn column, Node node, boolean headerClick) {
        this(column, node);
        this.headerClicked = headerClick;
    }

    public IColumn getColumn() {
        return column;
    }

    public void setColumn(IColumn column) {
        this.column = column;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Object getObject() {
        if (node != null) {
            return node.getRepresentedObject();
        } else {
            return null;
        }
    }

    /**
     * 
     * @return true when user click on column header.
     */
    public boolean isHeaderClicked() {
        return headerClicked;
    }

    public void setHeaderClick(boolean headerClick) {
        this.headerClicked = headerClick;
    }

    /**
     * 
     * @return true when user click on empty item/column of grid.
     */
    public boolean isEmptyRowClick() {
        return ((node == null) && (!headerClicked));
    }
}
