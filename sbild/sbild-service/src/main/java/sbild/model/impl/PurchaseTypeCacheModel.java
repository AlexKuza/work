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

import sbild.model.PurchaseType;

/**
 * The cache model class for representing PurchaseType in entity cache.
 *
 * @author liferay
 * @generated
 */
public class PurchaseTypeCacheModel
	implements CacheModel<PurchaseType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseTypeCacheModel)) {
			return false;
		}

		PurchaseTypeCacheModel purchaseTypeCacheModel =
			(PurchaseTypeCacheModel)object;

		if (purchtypeId == purchaseTypeCacheModel.purchtypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, purchtypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{purchtypeId=");
		sb.append(purchtypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PurchaseType toEntityModel() {
		PurchaseTypeImpl purchaseTypeImpl = new PurchaseTypeImpl();

		purchaseTypeImpl.setPurchtypeId(purchtypeId);

		if (name == null) {
			purchaseTypeImpl.setName("");
		}
		else {
			purchaseTypeImpl.setName(name);
		}

		purchaseTypeImpl.resetOriginalValues();

		return purchaseTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		purchtypeId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(purchtypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long purchtypeId;
	public String name;

}