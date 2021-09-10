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
import java.util.List;

import sbild.service.persistence.ElectroEmployeePK;

/**
 * This class is used by SOAP remote services, specifically {@link sbild.service.http.ElectroEmployeeServiceSoap}.
 *
 * @author liferay
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ElectroEmployeeSoap implements Serializable {

	public static ElectroEmployeeSoap toSoapModel(ElectroEmployee model) {
		ElectroEmployeeSoap soapModel = new ElectroEmployeeSoap();

		soapModel.setEmplId(model.getEmplId());
		soapModel.setEtypeId(model.getEtypeId());

		return soapModel;
	}

	public static ElectroEmployeeSoap[] toSoapModels(ElectroEmployee[] models) {
		ElectroEmployeeSoap[] soapModels =
			new ElectroEmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ElectroEmployeeSoap[][] toSoapModels(
		ElectroEmployee[][] models) {

		ElectroEmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ElectroEmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ElectroEmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ElectroEmployeeSoap[] toSoapModels(
		List<ElectroEmployee> models) {

		List<ElectroEmployeeSoap> soapModels =
			new ArrayList<ElectroEmployeeSoap>(models.size());

		for (ElectroEmployee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ElectroEmployeeSoap[soapModels.size()]);
	}

	public ElectroEmployeeSoap() {
	}

	public ElectroEmployeePK getPrimaryKey() {
		return new ElectroEmployeePK(_emplId, _etypeId);
	}

	public void setPrimaryKey(ElectroEmployeePK pk) {
		setEmplId(pk.emplId);
		setEtypeId(pk.etypeId);
	}

	public long getEmplId() {
		return _emplId;
	}

	public void setEmplId(long emplId) {
		_emplId = emplId;
	}

	public long getEtypeId() {
		return _etypeId;
	}

	public void setEtypeId(long etypeId) {
		_etypeId = etypeId;
	}

	private long _emplId;
	private long _etypeId;

}