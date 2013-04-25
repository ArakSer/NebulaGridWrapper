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

import org.eclipse.swt.SWT;

/**
 * Specify column sorting labels. Wrap standard SWT constants.
 * 
 * @author barsukov.dmytro@gmail.com
 */
public enum ColumnSortOrder {
    NONE(SWT.NONE), DOWN(SWT.DOWN), UP(SWT.UP);

    private final int order;

    ColumnSortOrder(int order) {
        this.order = order;
    }

    public int getSWTOrder() {
        return order;
    }

}
