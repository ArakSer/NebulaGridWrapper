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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;

/**
 * Abstract class which provide nodes to grid. Children classes have to override
 * setNodeData() function, which set data from DTO object to node.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public abstract class NodeFactory implements INodeFactory {

    GridTable grid;

    @SuppressWarnings("rawtypes")
    public List<Node> createNodes(List itemsList) {
        List<Node> values = new ArrayList<Node>();
        if (itemsList == null) {
            return values;
        }
        for (Object value : itemsList) {
            values.add(createNode(value).setRepresentedObject(value));
        }
        return values;
    }

    public Node createNode(Object value) {
        Node node = new Node();
        setNodeData(node, value);
        return node;
    }

    public abstract void setNodeData(Node node, Object object);

    public GridTable getGrid() {
        return grid;
    }

    public void setGrid(GridTable grid) {
        this.grid = grid;
    }

    protected Composite getComposite() {
        return (Composite) getGrid().getControl();
    }
}
