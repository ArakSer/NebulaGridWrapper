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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * Java bean which contains information about item header.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class NodeProperty {

    private String text;
    private Image image;
    private Color textColor;
    private Color backgroundColor;

    public NodeProperty() {

    }

    public NodeProperty(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public NodeProperty setText(String text) {
        this.text = text;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public NodeProperty setImage(Image image) {
        this.image = image;
        return this;
    }

    public Color getTextColor() {
        return textColor;
    }

    public NodeProperty setTextColor(Color textColor) {
        this.textColor = textColor;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public NodeProperty setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

}
