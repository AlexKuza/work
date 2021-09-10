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

import sbild.model.Electronics;

/**
 * The cache model class for representing Electronics in entity cache.
 *
 * @author liferay
 * @generated
 */
public class ElectronicsCacheModel
	implements CacheModel<Electronics>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectronicsCacheModel)) {
			return false;
		}

		ElectronicsCacheModel electronicsCacheModel =
			(ElectronicsCacheModel)object;

		if (electrId == electronicsCacheModel.electrId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, electrId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{electrId=");
		sb.append(electrId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", etypeId=");
		sb.append(etypeId);
		sb.append(", price=");
		sb.append(price);
		sb.append(", count=");
		sb.append(count);
		sb.append(", inStock=");
		sb.append(inStock);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Electronics toEntityModel() {
		ElectronicsImpl electronicsImpl = new ElectronicsImpl();

		electronicsImpl.setElectrId(electrId);

		if (name == null) {
			electronicsImpl.setName("");
		}
		else {
			electronicsImpl.setName(name);
		}

		electronicsImpl.setEtypeId(etypeId);
		electronicsImpl.setPrice(price);
		electronicsImpl.setCount(count);
		electronicsImpl.setInStock(inStock);
		electronicsImpl.setArchive(archive);

		if (description == null) {
			electronicsImpl.setDescription("");
		}
		else {
			electronicsImpl.setDescription(description);
		}

		electronicsImpl.resetOriginalValues();

		return electronicsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		electrId = objectInput.readLong();
		name = objectInput.readUTF();

		etypeId = objectInput.readLong();

		price = objectInput.readLong();

		count = objectInput.readInt();

		inStock = objectInput.readBoolean();

		archive = objectInput.readBoolean();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(electrId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(etypeId);

		objectOutput.writeLong(price);

		objectOutput.writeInt(count);

		objectOutput.writeBoolean(inStock);

		objectOutput.writeBoolean(archive);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long electrId;
	public String name;
	public long etypeId;
	public long price;
	public int count;
	public boolean inStock;
	public boolean archive;
	public String description;

}