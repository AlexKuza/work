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
 * This class is a wrapper for {@link ElectroEmployee}.
 * </p>
 *
 * @author liferay
 * @see ElectroEmployee
 * @generated
 */
public class ElectroEmployeeWrapper
	extends BaseModelWrapper<ElectroEmployee>
	implements ElectroEmployee, ModelWrapper<ElectroEmployee> {

	public ElectroEmployeeWrapper(ElectroEmployee electroEmployee) {
		super(electroEmployee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emplId", getEmplId());
		attributes.put("etypeId", getEtypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long emplId = (Long)attributes.get("emplId");

		if (emplId != null) {
			setEmplId(emplId);
		}

		Long etypeId = (Long)attributes.get("etypeId");

		if (etypeId != null) {
			setEtypeId(etypeId);
		}
	}

	/**
	 * Returns the empl ID of this electro employee.
	 *
	 * @return the empl ID of this electro employee
	 */
	@Override
	public long getEmplId() {
		return model.getEmplId();
	}

	/**
	 * Returns the etype ID of this electro employee.
	 *
	 * @return the etype ID of this electro employee
	 */
	@Override
	public long getEtypeId() {
		return model.getEtypeId();
	}

	/**
	 * Returns the primary key of this electro employee.
	 *
	 * @return the primary key of this electro employee
	 */
	@Override
	public sbild.service.persistence.ElectroEmployeePK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the empl ID of this electro employee.
	 *
	 * @param emplId the empl ID of this electro employee
	 */
	@Override
	public void setEmplId(long emplId) {
		model.setEmplId(emplId);
	}

	/**
	 * Sets the etype ID of this electro employee.
	 *
	 * @param etypeId the etype ID of this electro employee
	 */
	@Override
	public void setEtypeId(long etypeId) {
		model.setEtypeId(etypeId);
	}

	/**
	 * Sets the primary key of this electro employee.
	 *
	 * @param primaryKey the primary key of this electro employee
	 */
	@Override
	public void setPrimaryKey(
		sbild.service.persistence.ElectroEmployeePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ElectroEmployeeWrapper wrap(ElectroEmployee electroEmployee) {
		return new ElectroEmployeeWrapper(electroEmployee);
	}

}