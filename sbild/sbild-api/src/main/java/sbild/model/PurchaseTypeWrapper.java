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
 * This class is a wrapper for {@link PurchaseType}.
 * </p>
 *
 * @author liferay
 * @see PurchaseType
 * @generated
 */
public class PurchaseTypeWrapper
	extends BaseModelWrapper<PurchaseType>
	implements ModelWrapper<PurchaseType>, PurchaseType {

	public PurchaseTypeWrapper(PurchaseType purchaseType) {
		super(purchaseType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("purchtypeId", getPurchtypeId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long purchtypeId = (Long)attributes.get("purchtypeId");

		if (purchtypeId != null) {
			setPurchtypeId(purchtypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the name of this purchase type.
	 *
	 * @return the name of this purchase type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this purchase type.
	 *
	 * @return the primary key of this purchase type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purchtype ID of this purchase type.
	 *
	 * @return the purchtype ID of this purchase type
	 */
	@Override
	public long getPurchtypeId() {
		return model.getPurchtypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the name of this purchase type.
	 *
	 * @param name the name of this purchase type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this purchase type.
	 *
	 * @param primaryKey the primary key of this purchase type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purchtype ID of this purchase type.
	 *
	 * @param purchtypeId the purchtype ID of this purchase type
	 */
	@Override
	public void setPurchtypeId(long purchtypeId) {
		model.setPurchtypeId(purchtypeId);
	}

	@Override
	protected PurchaseTypeWrapper wrap(PurchaseType purchaseType) {
		return new PurchaseTypeWrapper(purchaseType);
	}

}