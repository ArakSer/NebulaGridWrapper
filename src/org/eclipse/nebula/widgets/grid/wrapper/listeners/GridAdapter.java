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

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;

/**
 * Abstract class which contains empty functions of GridListener.
 * Use it if you don't want to implement all functions of GridListener.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public abstract class GridAdapter implements GridListener {

    public void leftClick(GridTable grid, EventData eventData) {
    }

    public void rightClick(GridTable grid, EventData eventData) {
    }

    public void doubleClick(GridTable grid, EventData eventData) {
    }

    public void selection(GridTable grid, EventData eventData) {
    }

    public void check(GridTable grid, EventData eventData) {
    }
}
