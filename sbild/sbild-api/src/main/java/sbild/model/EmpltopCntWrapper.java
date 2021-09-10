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
 * This class is a wrapper for {@link EmpltopCnt}.
 * </p>
 *
 * @author liferay
 * @see EmpltopCnt
 * @generated
 */
public class EmpltopCntWrapper
	extends BaseModelWrapper<EmpltopCnt>
	implements EmpltopCnt, ModelWrapper<EmpltopCnt> {

	public EmpltopCntWrapper(EmpltopCnt empltopCnt) {
		super(empltopCnt);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("position", getPosition());
		attributes.put("lastname", getLastname());
		attributes.put("count", getCount());

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

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}
	}

	/**
	 * Returns the count of this empltop cnt.
	 *
	 * @return the count of this empltop cnt
	 */
	@Override
	public int getCount() {
		return model.getCount();
	}

	/**
	 * Returns the lastname of this empltop cnt.
	 *
	 * @return the lastname of this empltop cnt
	 */
	@Override
	public String getLastname() {
		return model.getLastname();
	}

	/**
	 * Returns the position of this empltop cnt.
	 *
	 * @return the position of this empltop cnt
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this empltop cnt.
	 *
	 * @return the primary key of this empltop cnt
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the count of this empltop cnt.
	 *
	 * @param count the count of this empltop cnt
	 */
	@Override
	public void setCount(int count) {
		model.setCount(count);
	}

	/**
	 * Sets the lastname of this empltop cnt.
	 *
	 * @param lastname the lastname of this empltop cnt
	 */
	@Override
	public void setLastname(String lastname) {
		model.setLastname(lastname);
	}

	/**
	 * Sets the position of this empltop cnt.
	 *
	 * @param position the position of this empltop cnt
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this empltop cnt.
	 *
	 * @param primaryKey the primary key of this empltop cnt
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected EmpltopCntWrapper wrap(EmpltopCnt empltopCnt) {
		return new EmpltopCntWrapper(empltopCnt);
	}

}