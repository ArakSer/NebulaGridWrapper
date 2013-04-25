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

import java.util.List;

import org.eclipse.nebula.widgets.grid.wrapper.GridTable;

/**
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public interface INodeFactory {

    public List<Node> createNodes(List<Object> itemsList);

    public Node createNode(Object value);

    public GridTable getGrid();

    public void setGrid(GridTable grid);
}
