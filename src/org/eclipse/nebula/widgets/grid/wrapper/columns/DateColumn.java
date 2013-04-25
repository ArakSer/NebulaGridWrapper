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

import java.util.Date;

import org.eclipse.nebula.widgets.grid.wrapper.cells.CellProperty;
import org.eclipse.nebula.widgets.grid.wrapper.utils.DateTimeUtils;

/**
 * Wrapper column class which specify format of displaying date.
 * 
 * @author barsukov.dmytro@gmail.com
 * 
 */
public class DateColumn extends ColumnDecorator {

    private DateFormat dateFormat;

    public enum DateFormat {
        DATE, DATE_TIME_SHORT, DATE_TIME_FULL, MONTH;
    }

    public DateColumn(IColumn column) {
        this(column, DateFormat.DATE_TIME_FULL);
    }

    public DateColumn(IColumn column, DateFormat dateFormat) {
        super(column);
        this.dateFormat = dateFormat;
    }

    @Override
    public CellProperty processAdditional(CellProperty property) {
        if (property.getValue() instanceof Date) {
            Date date = (Date) property.getValue();
            String text;
            if (dateFormat == DateFormat.DATE) {
                text = DateTimeUtils.formatDate(date);
            } else if (dateFormat == DateFormat.DATE_TIME_SHORT) {
                text = DateTimeUtils.formatDateTimeShort(date);
            } else if (dateFormat == DateFormat.DATE_TIME_FULL) {
                text = DateTimeUtils.formatDateTimeFull(date);
            } else if (dateFormat == DateFormat.MONTH) {
                text = DateTimeUtils.formatMonth(date);
            } else {
                // Set default format
                text = DateTimeUtils.formatDateTimeFull(date);
            }
            property.setText(text);
        }
        return property;
    }

}
