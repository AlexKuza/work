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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Employee service. Represents a row in the &quot;GB_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>sbild.model.impl.EmployeeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>sbild.model.impl.EmployeeImpl</code>.
 * </p>
 *
 * @author liferay
 * @see Employee
 * @generated
 */
@ProviderType
public interface EmployeeModel extends BaseModel<Employee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee model instance should use the {@link Employee} interface instead.
	 */

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the empl ID of this employee.
	 *
	 * @return the empl ID of this employee
	 */
	public long getEmplId();

	/**
	 * Sets the empl ID of this employee.
	 *
	 * @param emplId the empl ID of this employee
	 */
	public void setEmplId(long emplId);

	/**
	 * Returns the lastname of this employee.
	 *
	 * @return the lastname of this employee
	 */
	@AutoEscape
	public String getLastname();

	/**
	 * Sets the lastname of this employee.
	 *
	 * @param lastname the lastname of this employee
	 */
	public void setLastname(String lastname);

	/**
	 * Returns the firstname of this employee.
	 *
	 * @return the firstname of this employee
	 */
	@AutoEscape
	public String getFirstname();

	/**
	 * Sets the firstname of this employee.
	 *
	 * @param firstname the firstname of this employee
	 */
	public void setFirstname(String firstname);

	/**
	 * Returns the patronymic of this employee.
	 *
	 * @return the patronymic of this employee
	 */
	@AutoEscape
	public String getPatronymic();

	/**
	 * Sets the patronymic of this employee.
	 *
	 * @param patronymic the patronymic of this employee
	 */
	public void setPatronymic(String patronymic);

	/**
	 * Returns the birthdate of this employee.
	 *
	 * @return the birthdate of this employee
	 */
	public Date getBirthdate();

	/**
	 * Sets the birthdate of this employee.
	 *
	 * @param birthdate the birthdate of this employee
	 */
	public void setBirthdate(Date birthdate);

	/**
	 * Returns the pos ID of this employee.
	 *
	 * @return the pos ID of this employee
	 */
	public long getPosId();

	/**
	 * Sets the pos ID of this employee.
	 *
	 * @param posId the pos ID of this employee
	 */
	public void setPosId(long posId);

	/**
	 * Returns the gender of this employee.
	 *
	 * @return the gender of this employee
	 */
	public boolean getGender();

	/**
	 * Returns <code>true</code> if this employee is gender.
	 *
	 * @return <code>true</code> if this employee is gender; <code>false</code> otherwise
	 */
	public boolean isGender();

	/**
	 * Sets whether this employee is gender.
	 *
	 * @param gender the gender of this employee
	 */
	public void setGender(boolean gender);

}