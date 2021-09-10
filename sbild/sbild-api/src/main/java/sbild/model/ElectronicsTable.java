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
 * The table class for the &quot;GB_Electronics&quot; database table.
 *
 * @author liferay
 * @see Electronics
 * @generated
 */
public class ElectronicsTable extends BaseTable<ElectronicsTable> {

	public static final ElectronicsTable INSTANCE = new ElectronicsTable();

	public final Column<ElectronicsTable, Long> electrId = createColumn(
		"electrId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ElectronicsTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ElectronicsTable, Long> etypeId = createColumn(
		"etypeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ElectronicsTable, Long> price = createColumn(
		"price", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ElectronicsTable, Integer> count = createColumn(
		"count", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ElectronicsTable, Boolean> inStock = createColumn(
		"inStock", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ElectronicsTable, Boolean> archive = createColumn(
		"archive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ElectronicsTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ElectronicsTable() {
		super("GB_Electronics", ElectronicsTable::new);
	}

}