/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    barsukov.dmytro@gmail.com    - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.grid.wrapper.editors;

import org.eclipse.swt.widgets.Control;

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;

/**
 * Editor which place in cell. Children editor classes have to implement
 * addListeners() function. That function determines the behavior of Editor.
 * @author barsukov.dmytro@gmail.com
 * 
 */
public abstract class Editor {

    protected Control control;
    protected Node node;
    protected GridTable parentGrid;

    public Editor(Control control) {
        setControl(control);
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
        addListeners();
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public GridTable getParentGrid() {
        return parentGrid;
    }

    public void setParentGrid(GridTable grid) {
        this.parentGrid = grid;
    }

    protected abstract void addListeners();

}
