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
 * This class is a wrapper for {@link EmpltopSum}.
 * </p>
 *
 * @author liferay
 * @see EmpltopSum
 * @generated
 */
public class EmpltopSumWrapper
	extends BaseModelWrapper<EmpltopSum>
	implements EmpltopSum, ModelWrapper<EmpltopSum> {

	public EmpltopSumWrapper(EmpltopSum empltopSum) {
		super(empltopSum);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("position", getPosition());
		attributes.put("lastname", getLastname());
		attributes.put("sum", getSum());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		Long sum = (Long)attributes.get("sum");

		if (sum != null) {
			setSum(sum);
		}
	}

	/**
	 * Returns the lastname of this empltop sum.
	 *
	 * @return the lastname of this empltop sum
	 */
	@Override
	public String getLastname() {
		return model.getLastname();
	}

	/**
	 * Returns the position of this empltop sum.
	 *
	 * @return the position of this empltop sum
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this empltop sum.
	 *
	 * @return the primary key of this empltop sum
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sum of this empltop sum.
	 *
	 * @return the sum of this empltop sum
	 */
	@Override
	public long getSum() {
		return model.getSum();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the lastname of this empltop sum.
	 *
	 * @param lastname the lastname of this empltop sum
	 */
	@Override
	public void setLastname(String lastname) {
		model.setLastname(lastname);
	}

	/**
	 * Sets the position of this empltop sum.
	 *
	 * @param position the position of this empltop sum
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this empltop sum.
	 *
	 * @param primaryKey the primary key of this empltop sum
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sum of this empltop sum.
	 *
	 * @param sum the sum of this empltop sum
	 */
	@Override
	public void setSum(long sum) {
		model.setSum(sum);
	}

	@Override
	protected EmpltopSumWrapper wrap(EmpltopSum empltopSum) {
		return new EmpltopSumWrapper(empltopSum);
	}

}