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

import sbild.model.ElectroType;

/**
 * The cache model class for representing ElectroType in entity cache.
 *
 * @author liferay
 * @generated
 */
public class ElectroTypeCacheModel
	implements CacheModel<ElectroType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectroTypeCacheModel)) {
			return false;
		}

		ElectroTypeCacheModel electroTypeCacheModel =
			(ElectroTypeCacheModel)object;

		if (etypeId == electroTypeCacheModel.etypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, etypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{etypeId=");
		sb.append(etypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElectroType toEntityModel() {
		ElectroTypeImpl electroTypeImpl = new ElectroTypeImpl();

		electroTypeImpl.setEtypeId(etypeId);

		if (name == null) {
			electroTypeImpl.setName("");
		}
		else {
			electroTypeImpl.setName(name);
		}

		electroTypeImpl.resetOriginalValues();

		return electroTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		etypeId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(etypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long etypeId;
	public String name;

}