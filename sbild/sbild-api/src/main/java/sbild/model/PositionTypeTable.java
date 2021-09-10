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
 * The table class for the &quot;GB_PositionType&quot; database table.
 *
 * @author liferay
 * @see PositionType
 * @generated
 */
public class PositionTypeTable extends BaseTable<PositionTypeTable> {

	public static final PositionTypeTable INSTANCE = new PositionTypeTable();

	public final Column<PositionTypeTable, Long> posId = createColumn(
		"posId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PositionTypeTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PositionTypeTable() {
		super("GB_PositionType", PositionTypeTable::new);
	}

}