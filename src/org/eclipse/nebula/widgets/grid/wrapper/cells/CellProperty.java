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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

/**
 * Java bean which contains all information about cell.
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class CellProperty {

    private Object value;
    private String text;
    private String toolTip;
    private Image image;
    private Color textColor;
    private Color backgroundColor;
    private Font font;

    private Boolean checked;
    private Boolean checkable;
    private Boolean grayed;

    public CellProperty() {
        this(null);
    }

    /**
     * Create property and initialize it's value.
     * 
     * @param value
     *            value of cell
     */
    public CellProperty(Object value) {
        this.value = value;
    }

    /**
     * Create property and initialize it's value. Used for cells with checkbox.
     * 
     * @param value
     *            value of cell text
     * @param checked
     *            value of checkbox
     */
    public CellProperty(Object value, Boolean checked) {
        this.value = value;
        this.checked = checked;
    }

    public Object getValue() {
        return value;
    }

    public CellProperty setValue(Object value) {
        this.value = value;
        return this;
    }

    public String getText() {
        return text;
    }

    public CellProperty setText(String text) {
        this.text = text;
        return this;
    }

    public String getToolTip() {
        return toolTip;
    }

    public CellProperty setToolTip(String toolTip) {
        this.toolTip = toolTip;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public CellProperty setImage(Image image) {
        this.image = image;
        return this;
    }

    public Color getTextColor() {
        return textColor;
    }

    public CellProperty setTextColor(Color textColor) {
        this.textColor = textColor;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public CellProperty setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Font getFont() {
        return font;
    }

    public CellProperty setFont(Font font) {
        this.font = font;
        return this;
    }

    public Boolean isChecked() {
        return checked;
    }

    public CellProperty setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }

    public Boolean isCheckable() {
        return checkable;
    }

    public CellProperty setCheckable(Boolean checkable) {
        this.checkable = checkable;
        return this;
    }

    public Boolean isGrayed() {
        return grayed;
    }

    public CellProperty setGrayed(Boolean grayed) {
        this.grayed = grayed;
        return this;
    }

}
