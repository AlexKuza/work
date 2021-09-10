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

import sbild.model.EmpltopSum;

/**
 * The cache model class for representing EmpltopSum in entity cache.
 *
 * @author liferay
 * @generated
 */
public class EmpltopSumCacheModel
	implements CacheModel<EmpltopSum>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmpltopSumCacheModel)) {
			return false;
		}

		EmpltopSumCacheModel empltopSumCacheModel =
			(EmpltopSumCacheModel)object;

		if (lastname.equals(empltopSumCacheModel.lastname)) {
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
		sb.append(", sum=");
		sb.append(sum);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpltopSum toEntityModel() {
		EmpltopSumImpl empltopSumImpl = new EmpltopSumImpl();

		if (position == null) {
			empltopSumImpl.setPosition("");
		}
		else {
			empltopSumImpl.setPosition(position);
		}

		if (lastname == null) {
			empltopSumImpl.setLastname("");
		}
		else {
			empltopSumImpl.setLastname(lastname);
		}

		empltopSumImpl.setSum(sum);

		empltopSumImpl.resetOriginalValues();

		return empltopSumImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		position = objectInput.readUTF();
		lastname = objectInput.readUTF();

		sum = objectInput.readLong();
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

		objectOutput.writeLong(sum);
	}

	public String position;
	public String lastname;
	public long sum;

}