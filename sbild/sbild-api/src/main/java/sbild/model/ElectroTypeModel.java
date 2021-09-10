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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ElectroType service. Represents a row in the &quot;GB_ElectroType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>sbild.model.impl.ElectroTypeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>sbild.model.impl.ElectroTypeImpl</code>.
 * </p>
 *
 * @author liferay
 * @see ElectroType
 * @generated
 */
@ProviderType
public interface ElectroTypeModel extends BaseModel<ElectroType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a electro type model instance should use the {@link ElectroType} interface instead.
	 */

	/**
	 * Returns the primary key of this electro type.
	 *
	 * @return the primary key of this electro type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this electro type.
	 *
	 * @param primaryKey the primary key of this electro type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the etype ID of this electro type.
	 *
	 * @return the etype ID of this electro type
	 */
	public long getEtypeId();

	/**
	 * Sets the etype ID of this electro type.
	 *
	 * @param etypeId the etype ID of this electro type
	 */
	public void setEtypeId(long etypeId);

	/**
	 * Returns the name of this electro type.
	 *
	 * @return the name of this electro type
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this electro type.
	 *
	 * @param name the name of this electro type
	 */
	public void setName(String name);

}