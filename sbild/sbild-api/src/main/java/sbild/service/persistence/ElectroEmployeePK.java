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

package sbild.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author liferay
 * @generated
 */
public class ElectroEmployeePK
	implements Comparable<ElectroEmployeePK>, Serializable {

	public long emplId;
	public long etypeId;

	public ElectroEmployeePK() {
	}

	public ElectroEmployeePK(long emplId, long etypeId) {
		this.emplId = emplId;
		this.etypeId = etypeId;
	}

	public long getEmplId() {
		return emplId;
	}

	public void setEmplId(long emplId) {
		this.emplId = emplId;
	}

	public long getEtypeId() {
		return etypeId;
	}

	public void setEtypeId(long etypeId) {
		this.etypeId = etypeId;
	}

	@Override
	public int compareTo(ElectroEmployeePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (emplId < pk.emplId) {
			value = -1;
		}
		else if (emplId > pk.emplId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (etypeId < pk.etypeId) {
			value = -1;
		}
		else if (etypeId > pk.etypeId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectroEmployeePK)) {
			return false;
		}

		ElectroEmployeePK pk = (ElectroEmployeePK)object;

		if ((emplId == pk.emplId) && (etypeId == pk.etypeId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, emplId);
		hashCode = HashUtil.hash(hashCode, etypeId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("emplId=");

		sb.append(emplId);
		sb.append(", etypeId=");

		sb.append(etypeId);

		sb.append("}");

		return sb.toString();
	}

}