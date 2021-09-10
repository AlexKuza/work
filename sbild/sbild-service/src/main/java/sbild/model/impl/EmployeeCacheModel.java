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

import java.util.Date;

import sbild.model.Employee;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author liferay
 * @generated
 */
public class EmployeeCacheModel
	implements CacheModel<Employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)object;

		if (emplId == employeeCacheModel.emplId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, emplId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{emplId=");
		sb.append(emplId);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", firstname=");
		sb.append(firstname);
		sb.append(", patronymic=");
		sb.append(patronymic);
		sb.append(", birthdate=");
		sb.append(birthdate);
		sb.append(", posId=");
		sb.append(posId);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmplId(emplId);

		if (lastname == null) {
			employeeImpl.setLastname("");
		}
		else {
			employeeImpl.setLastname(lastname);
		}

		if (firstname == null) {
			employeeImpl.setFirstname("");
		}
		else {
			employeeImpl.setFirstname(firstname);
		}

		if (patronymic == null) {
			employeeImpl.setPatronymic("");
		}
		else {
			employeeImpl.setPatronymic(patronymic);
		}

		if (birthdate == Long.MIN_VALUE) {
			employeeImpl.setBirthdate(null);
		}
		else {
			employeeImpl.setBirthdate(new Date(birthdate));
		}

		employeeImpl.setPosId(posId);
		employeeImpl.setGender(gender);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		emplId = objectInput.readLong();
		lastname = objectInput.readUTF();
		firstname = objectInput.readUTF();
		patronymic = objectInput.readUTF();
		birthdate = objectInput.readLong();

		posId = objectInput.readLong();

		gender = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(emplId);

		if (lastname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (firstname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstname);
		}

		if (patronymic == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patronymic);
		}

		objectOutput.writeLong(birthdate);

		objectOutput.writeLong(posId);

		objectOutput.writeBoolean(gender);
	}

	public long emplId;
	public String lastname;
	public String firstname;
	public String patronymic;
	public long birthdate;
	public long posId;
	public boolean gender;

}