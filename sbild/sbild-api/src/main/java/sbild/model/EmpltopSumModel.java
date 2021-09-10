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
 * The base model interface for the EmpltopSum service. Represents a row in the &quot;GB_EmpltopSum&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>sbild.model.impl.EmpltopSumModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>sbild.model.impl.EmpltopSumImpl</code>.
 * </p>
 *
 * @author liferay
 * @see EmpltopSum
 * @generated
 */
@ProviderType
public interface EmpltopSumModel extends BaseModel<EmpltopSum> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a empltop sum model instance should use the {@link EmpltopSum} interface instead.
	 */

	/**
	 * Returns the primary key of this empltop sum.
	 *
	 * @return the primary key of this empltop sum
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this empltop sum.
	 *
	 * @param primaryKey the primary key of this empltop sum
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the position of this empltop sum.
	 *
	 * @return the position of this empltop sum
	 */
	@AutoEscape
	public String getPosition();

	/**
	 * Sets the position of this empltop sum.
	 *
	 * @param position the position of this empltop sum
	 */
	public void setPosition(String position);

	/**
	 * Returns the lastname of this empltop sum.
	 *
	 * @return the lastname of this empltop sum
	 */
	@AutoEscape
	public String getLastname();

	/**
	 * Sets the lastname of this empltop sum.
	 *
	 * @param lastname the lastname of this empltop sum
	 */
	public void setLastname(String lastname);

	/**
	 * Returns the sum of this empltop sum.
	 *
	 * @return the sum of this empltop sum
	 */
	public long getSum();

	/**
	 * Sets the sum of this empltop sum.
	 *
	 * @param sum the sum of this empltop sum
	 */
	public void setSum(long sum);

}