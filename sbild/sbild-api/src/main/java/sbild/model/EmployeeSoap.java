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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link sbild.service.http.EmployeeServiceSoap}.
 *
 * @author liferay
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeSoap implements Serializable {

	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setEmplId(model.getEmplId());
		soapModel.setLastname(model.getLastname());
		soapModel.setFirstname(model.getFirstname());
		soapModel.setPatronymic(model.getPatronymic());
		soapModel.setBirthdate(model.getBirthdate());
		soapModel.setPosId(model.getPosId());
		soapModel.setGender(model.isGender());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(
			models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _emplId;
	}

	public void setPrimaryKey(long pk) {
		setEmplId(pk);
	}

	public long getEmplId() {
		return _emplId;
	}

	public void setEmplId(long emplId) {
		_emplId = emplId;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getFirstname() {
		return _firstname;
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	public String getPatronymic() {
		return _patronymic;
	}

	public void setPatronymic(String patronymic) {
		_patronymic = patronymic;
	}

	public Date getBirthdate() {
		return _birthdate;
	}

	public void setBirthdate(Date birthdate) {
		_birthdate = birthdate;
	}

	public long getPosId() {
		return _posId;
	}

	public void setPosId(long posId) {
		_posId = posId;
	}

	public boolean getGender() {
		return _gender;
	}

	public boolean isGender() {
		return _gender;
	}

	public void setGender(boolean gender) {
		_gender = gender;
	}

	private long _emplId;
	private String _lastname;
	private String _firstname;
	private String _patronymic;
	private Date _birthdate;
	private long _posId;
	private boolean _gender;

}