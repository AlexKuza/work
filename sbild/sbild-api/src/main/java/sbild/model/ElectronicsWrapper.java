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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Electronics}.
 * </p>
 *
 * @author liferay
 * @see Electronics
 * @generated
 */
public class ElectronicsWrapper
	extends BaseModelWrapper<Electronics>
	implements Electronics, ModelWrapper<Electronics> {

	public ElectronicsWrapper(Electronics electronics) {
		super(electronics);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("electrId", getElectrId());
		attributes.put("name", getName());
		attributes.put("etypeId", getEtypeId());
		attributes.put("price", getPrice());
		attributes.put("count", getCount());
		attributes.put("inStock", isInStock());
		attributes.put("archive", isArchive());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long electrId = (Long)attributes.get("electrId");

		if (electrId != null) {
			setElectrId(electrId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long etypeId = (Long)attributes.get("etypeId");

		if (etypeId != null) {
			setEtypeId(etypeId);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Boolean inStock = (Boolean)attributes.get("inStock");

		if (inStock != null) {
			setInStock(inStock);
		}

		Boolean archive = (Boolean)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the archive of this electronics.
	 *
	 * @return the archive of this electronics
	 */
	@Override
	public boolean getArchive() {
		return model.getArchive();
	}

	/**
	 * Returns the count of this electronics.
	 *
	 * @return the count of this electronics
	 */
	@Override
	public int getCount() {
		return model.getCount();
	}

	/**
	 * Returns the description of this electronics.
	 *
	 * @return the description of this electronics
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the electr ID of this electronics.
	 *
	 * @return the electr ID of this electronics
	 */
	@Override
	public long getElectrId() {
		return model.getElectrId();
	}

	/**
	 * Returns the etype ID of this electronics.
	 *
	 * @return the etype ID of this electronics
	 */
	@Override
	public long getEtypeId() {
		return model.getEtypeId();
	}

	/**
	 * Returns the in stock of this electronics.
	 *
	 * @return the in stock of this electronics
	 */
	@Override
	public boolean getInStock() {
		return model.getInStock();
	}

	/**
	 * Returns the name of this electronics.
	 *
	 * @return the name of this electronics
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the price of this electronics.
	 *
	 * @return the price of this electronics
	 */
	@Override
	public long getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this electronics.
	 *
	 * @return the primary key of this electronics
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this electronics is archive.
	 *
	 * @return <code>true</code> if this electronics is archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isArchive() {
		return model.isArchive();
	}

	/**
	 * Returns <code>true</code> if this electronics is in stock.
	 *
	 * @return <code>true</code> if this electronics is in stock; <code>false</code> otherwise
	 */
	@Override
	public boolean isInStock() {
		return model.isInStock();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this electronics is archive.
	 *
	 * @param archive the archive of this electronics
	 */
	@Override
	public void setArchive(boolean archive) {
		model.setArchive(archive);
	}

	/**
	 * Sets the count of this electronics.
	 *
	 * @param count the count of this electronics
	 */
	@Override
	public void setCount(int count) {
		model.setCount(count);
	}

	/**
	 * Sets the description of this electronics.
	 *
	 * @param description the description of this electronics
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the electr ID of this electronics.
	 *
	 * @param electrId the electr ID of this electronics
	 */
	@Override
	public void setElectrId(long electrId) {
		model.setElectrId(electrId);
	}

	/**
	 * Sets the etype ID of this electronics.
	 *
	 * @param etypeId the etype ID of this electronics
	 */
	@Override
	public void setEtypeId(long etypeId) {
		model.setEtypeId(etypeId);
	}

	/**
	 * Sets whether this electronics is in stock.
	 *
	 * @param inStock the in stock of this electronics
	 */
	@Override
	public void setInStock(boolean inStock) {
		model.setInStock(inStock);
	}

	/**
	 * Sets the name of this electronics.
	 *
	 * @param name the name of this electronics
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the price of this electronics.
	 *
	 * @param price the price of this electronics
	 */
	@Override
	public void setPrice(long price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this electronics.
	 *
	 * @param primaryKey the primary key of this electronics
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ElectronicsWrapper wrap(Electronics electronics) {
		return new ElectronicsWrapper(electronics);
	}

}