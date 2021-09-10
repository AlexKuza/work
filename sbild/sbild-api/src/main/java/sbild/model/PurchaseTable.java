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

import java.util.Date;

/**
 * The table class for the &quot;GB_Purchase&quot; database table.
 *
 * @author liferay
 * @see Purchase
 * @generated
 */
public class PurchaseTable extends BaseTable<PurchaseTable> {

	public static final PurchaseTable INSTANCE = new PurchaseTable();

	public final Column<PurchaseTable, Long> purchId = createColumn(
		"purchId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PurchaseTable, Long> electrId = createColumn(
		"electrId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PurchaseTable, Long> emplId = createColumn(
		"emplId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PurchaseTable, Date> purchDate = createColumn(
		"purchDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PurchaseTable, Long> purchtypeId = createColumn(
		"purchtypeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PurchaseTable() {
		super("GB_Purchase", PurchaseTable::new);
	}

}