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

import sbild.model.EmpltopCnt;

/**
 * The cache model class for representing EmpltopCnt in entity cache.
 *
 * @author liferay
 * @generated
 */
public class EmpltopCntCacheModel
	implements CacheModel<EmpltopCnt>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmpltopCntCacheModel)) {
			return false;
		}

		EmpltopCntCacheModel empltopCntCacheModel =
			(EmpltopCntCacheModel)object;

		if (lastname.equals(empltopCntCacheModel.lastname)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lastname);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{position=");
		sb.append(position);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", count=");
		sb.append(count);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpltopCnt toEntityModel() {
		EmpltopCntImpl empltopCntImpl = new EmpltopCntImpl();

		if (position == null) {
			empltopCntImpl.setPosition("");
		}
		else {
			empltopCntImpl.setPosition(position);
		}

		if (lastname == null) {
			empltopCntImpl.setLastname("");
		}
		else {
			empltopCntImpl.setLastname(lastname);
		}

		empltopCntImpl.setCount(count);

		empltopCntImpl.resetOriginalValues();

		return empltopCntImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		position = objectInput.readUTF();
		lastname = objectInput.readUTF();

		count = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (position == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(position);
		}

		if (lastname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		objectOutput.writeInt(count);
	}

	public String position;
	public String lastname;
	public int count;

}