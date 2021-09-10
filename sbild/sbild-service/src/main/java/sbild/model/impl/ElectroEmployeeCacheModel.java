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

package sbild.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import sbild.model.ElectroEmployee;

import sbild.service.persistence.ElectroEmployeePK;

/**
 * The cache model class for representing ElectroEmployee in entity cache.
 *
 * @author liferay
 * @generated
 */
public class ElectroEmployeeCacheModel
	implements CacheModel<ElectroEmployee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectroEmployeeCacheModel)) {
			return false;
		}

		ElectroEmployeeCacheModel electroEmployeeCacheModel =
			(ElectroEmployeeCacheModel)object;

		if (electroEmployeePK.equals(
				electroEmployeeCacheModel.electroEmployeePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, electroEmployeePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{emplId=");
		sb.append(emplId);
		sb.append(", etypeId=");
		sb.append(etypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElectroEmployee toEntityModel() {
		ElectroEmployeeImpl electroEmployeeImpl = new ElectroEmployeeImpl();

		electroEmployeeImpl.setEmplId(emplId);
		electroEmployeeImpl.setEtypeId(etypeId);

		electroEmployeeImpl.resetOriginalValues();

		return electroEmployeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		emplId = objectInput.readLong();

		etypeId = objectInput.readLong();

		electroEmployeePK = new ElectroEmployeePK(emplId, etypeId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(emplId);

		objectOutput.writeLong(etypeId);
	}

	public long emplId;
	public long etypeId;
	public transient ElectroEmployeePK electroEmployeePK;

}