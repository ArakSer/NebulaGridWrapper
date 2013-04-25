/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    barsukov.dmytro@gmail.com    - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.grid.wrapper.cells;

import org.eclipse.swt.SWT;

import org.eclipse.nebula.widgets.grid.wrapper.editors.Editor;

/**
 * Java bean which contains all information about edited cell.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class EditedCellProperty extends CellProperty {

    private Editor editor;
    private boolean grabHorizontal = true;
    private boolean grabVertical = true;
    private int horizontalAlignment = SWT.LEFT;
    private int verticalAlignment = SWT.TOP;
    private int minimumWidth = 0;
    private int minimumHeight = 0;

    public EditedCellProperty(Object value) {
        super(value);
    }

    public EditedCellProperty(Object value, Editor editor) {
        this(value);// Value is used by sorting
        setEditor(editor);
    }

    public Editor getEditor() {
        return editor;
    }

    public EditedCellProperty setEditor(Editor editor) {
        this.editor = editor;
        return this;
    }

    public boolean isGrabHorizontal() {
        return grabHorizontal;
    }

    public EditedCellProperty setGrabHorizontal(boolean grabHorizontal) {
        this.grabHorizontal = grabHorizontal;
        return this;
    }

    public boolean isGrabVertical() {
        return grabVertical;
    }

    public EditedCellProperty setGrabVertical(boolean grabVertical) {
        this.grabVertical = grabVertical;
        return this;
    }

    public int getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public EditedCellProperty setHorizontalAlignment(int horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
        return this;
    }

    public int getVerticalAlignment() {
        return verticalAlignment;
    }

    public EditedCellProperty setVerticalAlignment(int verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
        return this;
    }

    public int getMinimumWidth() {
        return minimumWidth;
    }

    public EditedCellProperty setMinimumWidth(int minimumWidth) {
        this.minimumWidth = minimumWidth;
        return this;
    }

    public int getMinimumHeight() {
        return minimumHeight;
    }

    public EditedCellProperty setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
        return this;
    }

}
