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

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;

/**
 * Cell combo editor. After any change in Combo call modifyCell(), which can be
 * override.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public abstract class ComboEditor extends Editor {

    public ComboEditor(Combo combo) {
        super(combo);
    }

    @Override
    protected void addListeners() {
        ((Combo) control).addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                modifyCell(parentGrid, node, (Combo) control);
            }
        });
    }

    protected abstract void modifyCell(GridTable grid, Node node, Combo text);

}
