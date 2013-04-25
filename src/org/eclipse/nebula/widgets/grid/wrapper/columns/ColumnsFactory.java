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

import java.util.ArrayList;
import java.util.List;

/**
 * Class helps create list of simple columns
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class ColumnsFactory {

    public static List<IColumn> createColumns(List<String> columnNameList) {
        return createColumns(columnNameList.toArray(new String[0]));
    }

    public static List<IColumn> createColumns(String[] columnNameArray) {
        List<IColumn> columnsList = new ArrayList<IColumn>();
        for (String columnName : columnNameArray) {
            columnsList.add(Column.createColumn(columnName));
        }
        return columnsList;
    }
}
