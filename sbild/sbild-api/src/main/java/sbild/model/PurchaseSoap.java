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
 * This class is used by SOAP remote services, specifically {@link sbild.service.http.PurchaseServiceSoap}.
 *
 * @author liferay
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PurchaseSoap implements Serializable {

	public static PurchaseSoap toSoapModel(Purchase model) {
		PurchaseSoap soapModel = new PurchaseSoap();

		soapModel.setPurchId(model.getPurchId());
		soapModel.setElectrId(model.getElectrId());
		soapModel.setEmplId(model.getEmplId());
		soapModel.setPurchDate(model.getPurchDate());
		soapModel.setPurchtypeId(model.getPurchtypeId());

		return soapModel;
	}

	public static PurchaseSoap[] toSoapModels(Purchase[] models) {
		PurchaseSoap[] soapModels = new PurchaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[][] toSoapModels(Purchase[][] models) {
		PurchaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[] toSoapModels(List<Purchase> models) {
		List<PurchaseSoap> soapModels = new ArrayList<PurchaseSoap>(
			models.size());

		for (Purchase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseSoap[soapModels.size()]);
	}

	public PurchaseSoap() {
	}

	public long getPrimaryKey() {
		return _purchId;
	}

	public void setPrimaryKey(long pk) {
		setPurchId(pk);
	}

	public long getPurchId() {
		return _purchId;
	}

	public void setPurchId(long purchId) {
		_purchId = purchId;
	}

	public long getElectrId() {
		return _electrId;
	}

	public void setElectrId(long electrId) {
		_electrId = electrId;
	}

	public long getEmplId() {
		return _emplId;
	}

	public void setEmplId(long emplId) {
		_emplId = emplId;
	}

	public Date getPurchDate() {
		return _purchDate;
	}

	public void setPurchDate(Date purchDate) {
		_purchDate = purchDate;
	}

	public long getPurchtypeId() {
		return _purchtypeId;
	}

	public void setPurchtypeId(long purchtypeId) {
		_purchtypeId = purchtypeId;
	}

	private long _purchId;
	private long _electrId;
	private long _emplId;
	private Date _purchDate;
	private long _purchtypeId;

}