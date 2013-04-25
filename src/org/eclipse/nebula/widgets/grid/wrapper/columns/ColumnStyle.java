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
 * Wrap SWT alignment constants.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public enum ColumnStyle {
    NONE(SWT.NONE), LEFT(SWT.LEFT), RIGHT(SWT.RIGHT), CENTER(SWT.CENTER);

    private final int style;

    ColumnStyle(int style) {
        this.style = style;
    }

    public int getSWTStyle() {
        return style;
    }
}
