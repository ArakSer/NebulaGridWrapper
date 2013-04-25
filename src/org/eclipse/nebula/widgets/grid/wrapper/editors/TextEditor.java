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
import org.eclipse.swt.widgets.Text;

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;
import org.eclipse.nebula.widgets.grid.wrapper.nodes.Node;

/**
 * Cell text editor. After any change in Text call modifyCell(), which can be override.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public abstract class TextEditor extends Editor {

    public TextEditor(Text text) {
        super(text);
    }

    @Override
    protected void addListeners() {
        ((Text) control).addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                modifyCell(parentGrid, node, (Text) control);
            }
        });
    }

    protected abstract void modifyCell(GridTable grid, Node node, Text text);

}
