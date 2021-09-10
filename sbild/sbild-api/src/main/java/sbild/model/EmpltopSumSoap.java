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
 * This class is used by SOAP remote services, specifically {@link sbild.service.http.EmpltopSumServiceSoap}.
 *
 * @author liferay
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmpltopSumSoap implements Serializable {

	public static EmpltopSumSoap toSoapModel(EmpltopSum model) {
		EmpltopSumSoap soapModel = new EmpltopSumSoap();

		soapModel.setPosition(model.getPosition());
		soapModel.setLastname(model.getLastname());
		soapModel.setSum(model.getSum());

		return soapModel;
	}

	public static EmpltopSumSoap[] toSoapModels(EmpltopSum[] models) {
		EmpltopSumSoap[] soapModels = new EmpltopSumSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpltopSumSoap[][] toSoapModels(EmpltopSum[][] models) {
		EmpltopSumSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpltopSumSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpltopSumSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpltopSumSoap[] toSoapModels(List<EmpltopSum> models) {
		List<EmpltopSumSoap> soapModels = new ArrayList<EmpltopSumSoap>(
			models.size());

		for (EmpltopSum model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpltopSumSoap[soapModels.size()]);
	}

	public EmpltopSumSoap() {
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

	public long getSum() {
		return _sum;
	}

	public void setSum(long sum) {
		_sum = sum;
	}

	private String _position;
	private String _lastname;
	private long _sum;

}