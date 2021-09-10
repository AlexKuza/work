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
 * This class is used by SOAP remote services, specifically {@link sbild.service.http.ElectronicsServiceSoap}.
 *
 * @author liferay
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ElectronicsSoap implements Serializable {

	public static ElectronicsSoap toSoapModel(Electronics model) {
		ElectronicsSoap soapModel = new ElectronicsSoap();

		soapModel.setElectrId(model.getElectrId());
		soapModel.setName(model.getName());
		soapModel.setEtypeId(model.getEtypeId());
		soapModel.setPrice(model.getPrice());
		soapModel.setCount(model.getCount());
		soapModel.setInStock(model.isInStock());
		soapModel.setArchive(model.isArchive());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ElectronicsSoap[] toSoapModels(Electronics[] models) {
		ElectronicsSoap[] soapModels = new ElectronicsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ElectronicsSoap[][] toSoapModels(Electronics[][] models) {
		ElectronicsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ElectronicsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ElectronicsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ElectronicsSoap[] toSoapModels(List<Electronics> models) {
		List<ElectronicsSoap> soapModels = new ArrayList<ElectronicsSoap>(
			models.size());

		for (Electronics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ElectronicsSoap[soapModels.size()]);
	}

	public ElectronicsSoap() {
	}

	public long getPrimaryKey() {
		return _electrId;
	}

	public void setPrimaryKey(long pk) {
		setElectrId(pk);
	}

	public long getElectrId() {
		return _electrId;
	}

	public void setElectrId(long electrId) {
		_electrId = electrId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getEtypeId() {
		return _etypeId;
	}

	public void setEtypeId(long etypeId) {
		_etypeId = etypeId;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public boolean getInStock() {
		return _inStock;
	}

	public boolean isInStock() {
		return _inStock;
	}

	public void setInStock(boolean inStock) {
		_inStock = inStock;
	}

	public boolean getArchive() {
		return _archive;
	}

	public boolean isArchive() {
		return _archive;
	}

	public void setArchive(boolean archive) {
		_archive = archive;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _electrId;
	private String _name;
	private long _etypeId;
	private long _price;
	private int _count;
	private boolean _inStock;
	private boolean _archive;
	private String _description;

}