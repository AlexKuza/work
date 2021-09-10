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
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author liferay
 * @see Employee
 * @generated
 */
public class EmployeeWrapper
	extends BaseModelWrapper<Employee>
	implements Employee, ModelWrapper<Employee> {

	public EmployeeWrapper(Employee employee) {
		super(employee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emplId", getEmplId());
		attributes.put("lastname", getLastname());
		attributes.put("firstname", getFirstname());
		attributes.put("patronymic", getPatronymic());
		attributes.put("birthdate", getBirthdate());
		attributes.put("posId", getPosId());
		attributes.put("gender", isGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long emplId = (Long)attributes.get("emplId");

		if (emplId != null) {
			setEmplId(emplId);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String patronymic = (String)attributes.get("patronymic");

		if (patronymic != null) {
			setPatronymic(patronymic);
		}

		Date birthdate = (Date)attributes.get("birthdate");

		if (birthdate != null) {
			setBirthdate(birthdate);
		}

		Long posId = (Long)attributes.get("posId");

		if (posId != null) {
			setPosId(posId);
		}

		Boolean gender = (Boolean)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}
	}

	/**
	 * Returns the birthdate of this employee.
	 *
	 * @return the birthdate of this employee
	 */
	@Override
	public Date getBirthdate() {
		return model.getBirthdate();
	}

	/**
	 * Returns the empl ID of this employee.
	 *
	 * @return the empl ID of this employee
	 */
	@Override
	public long getEmplId() {
		return model.getEmplId();
	}

	/**
	 * Returns the firstname of this employee.
	 *
	 * @return the firstname of this employee
	 */
	@Override
	public String getFirstname() {
		return model.getFirstname();
	}

	/**
	 * Returns the gender of this employee.
	 *
	 * @return the gender of this employee
	 */
	@Override
	public boolean getGender() {
		return model.getGender();
	}

	/**
	 * Returns the lastname of this employee.
	 *
	 * @return the lastname of this employee
	 */
	@Override
	public String getLastname() {
		return model.getLastname();
	}

	/**
	 * Returns the patronymic of this employee.
	 *
	 * @return the patronymic of this employee
	 */
	@Override
	public String getPatronymic() {
		return model.getPatronymic();
	}

	/**
	 * Returns the pos ID of this employee.
	 *
	 * @return the pos ID of this employee
	 */
	@Override
	public long getPosId() {
		return model.getPosId();
	}

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this employee is gender.
	 *
	 * @return <code>true</code> if this employee is gender; <code>false</code> otherwise
	 */
	@Override
	public boolean isGender() {
		return model.isGender();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birthdate of this employee.
	 *
	 * @param birthdate the birthdate of this employee
	 */
	@Override
	public void setBirthdate(Date birthdate) {
		model.setBirthdate(birthdate);
	}

	/**
	 * Sets the empl ID of this employee.
	 *
	 * @param emplId the empl ID of this employee
	 */
	@Override
	public void setEmplId(long emplId) {
		model.setEmplId(emplId);
	}

	/**
	 * Sets the firstname of this employee.
	 *
	 * @param firstname the firstname of this employee
	 */
	@Override
	public void setFirstname(String firstname) {
		model.setFirstname(firstname);
	}

	/**
	 * Sets whether this employee is gender.
	 *
	 * @param gender the gender of this employee
	 */
	@Override
	public void setGender(boolean gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the lastname of this employee.
	 *
	 * @param lastname the lastname of this employee
	 */
	@Override
	public void setLastname(String lastname) {
		model.setLastname(lastname);
	}

	/**
	 * Sets the patronymic of this employee.
	 *
	 * @param patronymic the patronymic of this employee
	 */
	@Override
	public void setPatronymic(String patronymic) {
		model.setPatronymic(patronymic);
	}

	/**
	 * Sets the pos ID of this employee.
	 *
	 * @param posId the pos ID of this employee
	 */
	@Override
	public void setPosId(long posId) {
		model.setPosId(posId);
	}

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected EmployeeWrapper wrap(Employee employee) {
		return new EmployeeWrapper(employee);
	}

}