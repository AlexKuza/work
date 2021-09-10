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

/**
 * This class is used by SOAP remote services, specifically {@link sbild.service.http.EmpltopCntServiceSoap}.
 *
 * @author liferay
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmpltopCntSoap implements Serializable {

	public static EmpltopCntSoap toSoapModel(EmpltopCnt model) {
		EmpltopCntSoap soapModel = new EmpltopCntSoap();

		soapModel.setPosition(model.getPosition());
		soapModel.setLastname(model.getLastname());
		soapModel.setCount(model.getCount());

		return soapModel;
	}

	public static EmpltopCntSoap[] toSoapModels(EmpltopCnt[] models) {
		EmpltopCntSoap[] soapModels = new EmpltopCntSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpltopCntSoap[][] toSoapModels(EmpltopCnt[][] models) {
		EmpltopCntSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpltopCntSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpltopCntSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpltopCntSoap[] toSoapModels(List<EmpltopCnt> models) {
		List<EmpltopCntSoap> soapModels = new ArrayList<EmpltopCntSoap>(
			models.size());

		for (EmpltopCnt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpltopCntSoap[soapModels.size()]);
	}

	public EmpltopCntSoap() {
	}

	public String getPrimaryKey() {
		return _lastname;
	}

	public void setPrimaryKey(String pk) {
		setLastname(pk);
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	private String _position;
	private String _lastname;
	private int _count;

}