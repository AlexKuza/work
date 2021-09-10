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

package sbild.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import sbild.model.Purchase;

/**
 * The cache model class for representing Purchase in entity cache.
 *
 * @author liferay
 * @generated
 */
public class PurchaseCacheModel
	implements CacheModel<Purchase>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseCacheModel)) {
			return false;
		}

		PurchaseCacheModel purchaseCacheModel = (PurchaseCacheModel)object;

		if (purchId == purchaseCacheModel.purchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, purchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{purchId=");
		sb.append(purchId);
		sb.append(", electrId=");
		sb.append(electrId);
		sb.append(", emplId=");
		sb.append(emplId);
		sb.append(", purchDate=");
		sb.append(purchDate);
		sb.append(", purchtypeId=");
		sb.append(purchtypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Purchase toEntityModel() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		purchaseImpl.setPurchId(purchId);
		purchaseImpl.setElectrId(electrId);
		purchaseImpl.setEmplId(emplId);

		if (purchDate == Long.MIN_VALUE) {
			purchaseImpl.setPurchDate(null);
		}
		else {
			purchaseImpl.setPurchDate(new Date(purchDate));
		}

		purchaseImpl.setPurchtypeId(purchtypeId);

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		purchId = objectInput.readLong();

		electrId = objectInput.readLong();

		emplId = objectInput.readLong();
		purchDate = objectInput.readLong();

		purchtypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(purchId);

		objectOutput.writeLong(electrId);

		objectOutput.writeLong(emplId);
		objectOutput.writeLong(purchDate);

		objectOutput.writeLong(purchtypeId);
	}

	public long purchId;
	public long electrId;
	public long emplId;
	public long purchDate;
	public long purchtypeId;

}