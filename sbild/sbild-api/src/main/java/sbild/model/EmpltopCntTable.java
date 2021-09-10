/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package sbild.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;GB_EmpltopCnt&quot; database table.
 *
 * @author liferay
 * @see EmpltopCnt
 * @generated
 */
public class EmpltopCntTable extends BaseTable<EmpltopCntTable> {

	public static final EmpltopCntTable INSTANCE = new EmpltopCntTable();

	public final Column<EmpltopCntTable, String> position = createColumn(
		"position", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmpltopCntTable, String> lastname = createColumn(
		"lastname", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<EmpltopCntTable, Integer> count = createColumn(
		"count", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private EmpltopCntTable() {
		super("GB_EmpltopCnt", EmpltopCntTable::new);
	}

}