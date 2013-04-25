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

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;

import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;

/**
 * Compare grid's nodes by column. This class is used by sorting.
 * 
 * @param <T>
 *            Node. Can compare GridItems too but now they aren't used.
 * @author barsukov.dmytro@gmail.com
 */
public class NodeComparator<T> implements Comparator<T> {

    private int direction;
    private String column;

    public NodeComparator(int direction, String column) {
        this.direction = direction;
        this.column = column;
    }

    public NodeComparator() {
        this.direction = SWT.UP;
        this.column = null;
    }

    public int compare(T e1, T e2) {
        if (column == null) {
            return 0;
        }
        Object p1 = getObjectEntity(e1);
        Object p2 = getObjectEntity(e2);
        int rc = 0;
        if (p1 == null) {
            if (p2 == null) {
                rc = 0;
            } else {
                rc = 1;
            }
        } else if (p2 == null) {
            rc = -1;
        } else if (p1 instanceof String) {
            rc = String.valueOf(p2).compareTo(String.valueOf(p1));
        } else if (p1 instanceof Boolean) {
            if ((Boolean) p1 && !(Boolean) p2) {
                rc = 1;
            } else if (!(Boolean) p1 && (Boolean) p2) {
                rc = -1;
            }
        } else if (p1 instanceof Integer) {
            rc = ((Integer) p1 < (Integer) p2) ? 1 : (p1.equals(p2) ? 0 : -1);
        } else if (p1 instanceof Date) {
            rc = (((Date) p1).compareTo((Date) p2) < 0) ? 1 : (p1.equals(p2) ? 0 : -1);
        } else if (p1 instanceof Float) {
            rc = ((Float) p1 < (Float) p2) ? 1 : (p1.equals(p2) ? 0 : -1);
        } else if (p1 instanceof BigDecimal) {
            rc = (((BigDecimal) p2).compareTo((BigDecimal) p1));
        }

        // If descending order, flip the direction
        if (direction == SWT.DOWN)
            rc = -rc;
        return rc;
    }

    private Object getObjectEntity(Object object) {
        if (object instanceof GridItem) {
            object = ((GridItem) object).getData();
        }
        if (object instanceof Node) {
            CellProperty property = ((Node) object).getCellPropertiesMap().get(column);
            if (property != null) {
                return property.getValue();
            } else {
                return GridTable.EMPTY_FIELD;
            }
        } else {
            return object;
        }
    }

}
