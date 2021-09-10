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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author liferay
 * @see Purchase
 * @generated
 */
public class PurchaseWrapper
	extends BaseModelWrapper<Purchase>
	implements ModelWrapper<Purchase>, Purchase {

	public PurchaseWrapper(Purchase purchase) {
		super(purchase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("purchId", getPurchId());
		attributes.put("electrId", getElectrId());
		attributes.put("emplId", getEmplId());
		attributes.put("purchDate", getPurchDate());
		attributes.put("purchtypeId", getPurchtypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long purchId = (Long)attributes.get("purchId");

		if (purchId != null) {
			setPurchId(purchId);
		}

		Long electrId = (Long)attributes.get("electrId");

		if (electrId != null) {
			setElectrId(electrId);
		}

		Long emplId = (Long)attributes.get("emplId");

		if (emplId != null) {
			setEmplId(emplId);
		}

		Date purchDate = (Date)attributes.get("purchDate");

		if (purchDate != null) {
			setPurchDate(purchDate);
		}

		Long purchtypeId = (Long)attributes.get("purchtypeId");

		if (purchtypeId != null) {
			setPurchtypeId(purchtypeId);
		}
	}

	/**
	 * Returns the electr ID of this purchase.
	 *
	 * @return the electr ID of this purchase
	 */
	@Override
	public long getElectrId() {
		return model.getElectrId();
	}

	/**
	 * Returns the empl ID of this purchase.
	 *
	 * @return the empl ID of this purchase
	 */
	@Override
	public long getEmplId() {
		return model.getEmplId();
	}

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purch date of this purchase.
	 *
	 * @return the purch date of this purchase
	 */
	@Override
	public Date getPurchDate() {
		return model.getPurchDate();
	}

	/**
	 * Returns the purch ID of this purchase.
	 *
	 * @return the purch ID of this purchase
	 */
	@Override
	public long getPurchId() {
		return model.getPurchId();
	}

	/**
	 * Returns the purchtype ID of this purchase.
	 *
	 * @return the purchtype ID of this purchase
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
	 * Sets the electr ID of this purchase.
	 *
	 * @param electrId the electr ID of this purchase
	 */
	@Override
	public void setElectrId(long electrId) {
		model.setElectrId(electrId);
	}

	/**
	 * Sets the empl ID of this purchase.
	 *
	 * @param emplId the empl ID of this purchase
	 */
	@Override
	public void setEmplId(long emplId) {
		model.setEmplId(emplId);
	}

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purch date of this purchase.
	 *
	 * @param purchDate the purch date of this purchase
	 */
	@Override
	public void setPurchDate(Date purchDate) {
		model.setPurchDate(purchDate);
	}

	/**
	 * Sets the purch ID of this purchase.
	 *
	 * @param purchId the purch ID of this purchase
	 */
	@Override
	public void setPurchId(long purchId) {
		model.setPurchId(purchId);
	}

	/**
	 * Sets the purchtype ID of this purchase.
	 *
	 * @param purchtypeId the purchtype ID of this purchase
	 */
	@Override
	public void setPurchtypeId(long purchtypeId) {
		model.setPurchtypeId(purchtypeId);
	}

	@Override
	protected PurchaseWrapper wrap(Purchase purchase) {
		return new PurchaseWrapper(purchase);
	}

}