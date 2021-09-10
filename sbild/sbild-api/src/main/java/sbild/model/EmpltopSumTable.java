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
 * The table class for the &quot;GB_EmpltopSum&quot; database table.
 *
 * @author liferay
 * @see EmpltopSum
 * @generated
 */
public class EmpltopSumTable extends BaseTable<EmpltopSumTable> {

	public static final EmpltopSumTable INSTANCE = new EmpltopSumTable();

	public final Column<EmpltopSumTable, String> position = createColumn(
		"position", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmpltopSumTable, String> lastname = createColumn(
		"lastname", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<EmpltopSumTable, Long> sum = createColumn(
		"sum", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmpltopSumTable() {
		super("GB_EmpltopSum", EmpltopSumTable::new);
	}

}