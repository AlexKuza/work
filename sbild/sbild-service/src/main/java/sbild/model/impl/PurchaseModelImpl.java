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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

import sbild.model.Purchase;
import sbild.model.PurchaseModel;
import sbild.model.PurchaseSoap;

/**
 * The base model implementation for the Purchase service. Represents a row in the &quot;GB_Purchase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PurchaseModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PurchaseImpl}.
 * </p>
 *
 * @author liferay
 * @see PurchaseImpl
 * @generated
 */
@JSON(strict = true)
public class PurchaseModelImpl
	extends BaseModelImpl<Purchase> implements PurchaseModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a purchase model instance should use the <code>Purchase</code> interface instead.
	 */
	public static final String TABLE_NAME = "GB_Purchase";

	public static final Object[][] TABLE_COLUMNS = {
		{"purchId", Types.BIGINT}, {"electrId", Types.BIGINT},
		{"emplId", Types.BIGINT}, {"purchDate", Types.TIMESTAMP},
		{"purchtypeId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("purchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("electrId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("emplId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("purchDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("purchtypeId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table GB_Purchase (purchId LONG not null primary key,electrId LONG,emplId LONG,purchDate DATE null,purchtypeId LONG)";

	public static final String TABLE_SQL_DROP = "drop table GB_Purchase";

	public static final String ORDER_BY_JPQL = " ORDER BY purchase.purchId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY GB_Purchase.purchId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PURCHID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Purchase toModel(PurchaseSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Purchase model = new PurchaseImpl();

		model.setPurchId(soapModel.getPurchId());
		model.setElectrId(soapModel.getElectrId());
		model.setEmplId(soapModel.getEmplId());
		model.setPurchDate(soapModel.getPurchDate());
		model.setPurchtypeId(soapModel.getPurchtypeId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Purchase> toModels(PurchaseSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Purchase> models = new ArrayList<Purchase>(soapModels.length);

		for (PurchaseSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PurchaseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _purchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPurchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _purchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Purchase.class;
	}

	@Override
	public String getModelClassName() {
		return Purchase.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Purchase, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Purchase, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Purchase, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Purchase)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Purchase, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Purchase, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Purchase)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Purchase, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Purchase, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Purchase>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Purchase.class.getClassLoader(), Purchase.class,
			ModelWrapper.class);

		try {
			Constructor<Purchase> constructor =
				(Constructor<Purchase>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Purchase, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Purchase, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Purchase, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Purchase, Object>>();
		Map<String, BiConsumer<Purchase, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Purchase, ?>>();

		attributeGetterFunctions.put("purchId", Purchase::getPurchId);
		attributeSetterBiConsumers.put(
			"purchId", (BiConsumer<Purchase, Long>)Purchase::setPurchId);
		attributeGetterFunctions.put("electrId", Purchase::getElectrId);
		attributeSetterBiConsumers.put(
			"electrId", (BiConsumer<Purchase, Long>)Purchase::setElectrId);
		attributeGetterFunctions.put("emplId", Purchase::getEmplId);
		attributeSetterBiConsumers.put(
			"emplId", (BiConsumer<Purchase, Long>)Purchase::setEmplId);
		attributeGetterFunctions.put("purchDate", Purchase::getPurchDate);
		attributeSetterBiConsumers.put(
			"purchDate", (BiConsumer<Purchase, Date>)Purchase::setPurchDate);
		attributeGetterFunctions.put("purchtypeId", Purchase::getPurchtypeId);
		attributeSetterBiConsumers.put(
			"purchtypeId",
			(BiConsumer<Purchase, Long>)Purchase::setPurchtypeId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getPurchId() {
		return _purchId;
	}

	@Override
	public void setPurchId(long purchId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_purchId = purchId;
	}

	@JSON
	@Override
	public long getElectrId() {
		return _electrId;
	}

	@Override
	public void setElectrId(long electrId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_electrId = electrId;
	}

	@JSON
	@Override
	public long getEmplId() {
		return _emplId;
	}

	@Override
	public void setEmplId(long emplId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emplId = emplId;
	}

	@JSON
	@Override
	public Date getPurchDate() {
		return _purchDate;
	}

	@Override
	public void setPurchDate(Date purchDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_purchDate = purchDate;
	}

	@JSON
	@Override
	public long getPurchtypeId() {
		return _purchtypeId;
	}

	@Override
	public void setPurchtypeId(long purchtypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_purchtypeId = purchtypeId;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Purchase.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Purchase toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Purchase>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		purchaseImpl.setPurchId(getPurchId());
		purchaseImpl.setElectrId(getElectrId());
		purchaseImpl.setEmplId(getEmplId());
		purchaseImpl.setPurchDate(getPurchDate());
		purchaseImpl.setPurchtypeId(getPurchtypeId());

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public int compareTo(Purchase purchase) {
		long primaryKey = purchase.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Purchase)) {
			return false;
		}

		Purchase purchase = (Purchase)object;

		long primaryKey = purchase.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Purchase> toCacheModel() {
		PurchaseCacheModel purchaseCacheModel = new PurchaseCacheModel();

		purchaseCacheModel.purchId = getPurchId();

		purchaseCacheModel.electrId = getElectrId();

		purchaseCacheModel.emplId = getEmplId();

		Date purchDate = getPurchDate();

		if (purchDate != null) {
			purchaseCacheModel.purchDate = purchDate.getTime();
		}
		else {
			purchaseCacheModel.purchDate = Long.MIN_VALUE;
		}

		purchaseCacheModel.purchtypeId = getPurchtypeId();

		return purchaseCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Purchase, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Purchase, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Purchase, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Purchase)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Purchase, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Purchase, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Purchase, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Purchase)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Purchase>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _purchId;
	private long _electrId;
	private long _emplId;
	private Date _purchDate;
	private long _purchtypeId;

	public <T> T getColumnValue(String columnName) {
		Function<Purchase, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Purchase)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("purchId", _purchId);
		_columnOriginalValues.put("electrId", _electrId);
		_columnOriginalValues.put("emplId", _emplId);
		_columnOriginalValues.put("purchDate", _purchDate);
		_columnOriginalValues.put("purchtypeId", _purchtypeId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("purchId", 1L);

		columnBitmasks.put("electrId", 2L);

		columnBitmasks.put("emplId", 4L);

		columnBitmasks.put("purchDate", 8L);

		columnBitmasks.put("purchtypeId", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Purchase _escapedModel;

}