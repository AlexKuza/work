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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

import sbild.model.EmpltopCnt;
import sbild.model.EmpltopCntModel;
import sbild.model.EmpltopCntSoap;

/**
 * The base model implementation for the EmpltopCnt service. Represents a row in the &quot;GB_EmpltopCnt&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmpltopCntModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmpltopCntImpl}.
 * </p>
 *
 * @author liferay
 * @see EmpltopCntImpl
 * @generated
 */
@JSON(strict = true)
public class EmpltopCntModelImpl
	extends BaseModelImpl<EmpltopCnt> implements EmpltopCntModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a empltop cnt model instance should use the <code>EmpltopCnt</code> interface instead.
	 */
	public static final String TABLE_NAME = "GB_EmpltopCnt";

	public static final Object[][] TABLE_COLUMNS = {
		{"position", Types.VARCHAR}, {"lastname", Types.VARCHAR},
		{"count", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("position", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("count", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table GB_EmpltopCnt (position VARCHAR(75) null,lastname VARCHAR(75) not null primary key,count INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table GB_EmpltopCnt";

	public static final String ORDER_BY_JPQL =
		" ORDER BY empltopCnt.lastname ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY GB_EmpltopCnt.lastname ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LASTNAME_COLUMN_BITMASK = 1L;

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
	public static EmpltopCnt toModel(EmpltopCntSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmpltopCnt model = new EmpltopCntImpl();

		model.setPosition(soapModel.getPosition());
		model.setLastname(soapModel.getLastname());
		model.setCount(soapModel.getCount());

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
	public static List<EmpltopCnt> toModels(EmpltopCntSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EmpltopCnt> models = new ArrayList<EmpltopCnt>(soapModels.length);

		for (EmpltopCntSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmpltopCntModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _lastname;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setLastname(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lastname;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return EmpltopCnt.class;
	}

	@Override
	public String getModelClassName() {
		return EmpltopCnt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmpltopCnt, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmpltopCnt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmpltopCnt, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((EmpltopCnt)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmpltopCnt, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmpltopCnt, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmpltopCnt)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmpltopCnt, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmpltopCnt, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EmpltopCnt>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EmpltopCnt.class.getClassLoader(), EmpltopCnt.class,
			ModelWrapper.class);

		try {
			Constructor<EmpltopCnt> constructor =
				(Constructor<EmpltopCnt>)proxyClass.getConstructor(
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

	private static final Map<String, Function<EmpltopCnt, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmpltopCnt, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmpltopCnt, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<EmpltopCnt, Object>>();
		Map<String, BiConsumer<EmpltopCnt, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EmpltopCnt, ?>>();

		attributeGetterFunctions.put("position", EmpltopCnt::getPosition);
		attributeSetterBiConsumers.put(
			"position",
			(BiConsumer<EmpltopCnt, String>)EmpltopCnt::setPosition);
		attributeGetterFunctions.put("lastname", EmpltopCnt::getLastname);
		attributeSetterBiConsumers.put(
			"lastname",
			(BiConsumer<EmpltopCnt, String>)EmpltopCnt::setLastname);
		attributeGetterFunctions.put("count", EmpltopCnt::getCount);
		attributeSetterBiConsumers.put(
			"count", (BiConsumer<EmpltopCnt, Integer>)EmpltopCnt::setCount);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getPosition() {
		if (_position == null) {
			return "";
		}
		else {
			return _position;
		}
	}

	@Override
	public void setPosition(String position) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_position = position;
	}

	@JSON
	@Override
	public String getLastname() {
		if (_lastname == null) {
			return "";
		}
		else {
			return _lastname;
		}
	}

	@Override
	public void setLastname(String lastname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastname = lastname;
	}

	@JSON
	@Override
	public int getCount() {
		return _count;
	}

	@Override
	public void setCount(int count) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_count = count;
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
	public EmpltopCnt toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmpltopCnt>
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
		EmpltopCntImpl empltopCntImpl = new EmpltopCntImpl();

		empltopCntImpl.setPosition(getPosition());
		empltopCntImpl.setLastname(getLastname());
		empltopCntImpl.setCount(getCount());

		empltopCntImpl.resetOriginalValues();

		return empltopCntImpl;
	}

	@Override
	public int compareTo(EmpltopCnt empltopCnt) {
		String primaryKey = empltopCnt.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmpltopCnt)) {
			return false;
		}

		EmpltopCnt empltopCnt = (EmpltopCnt)object;

		String primaryKey = empltopCnt.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
	public CacheModel<EmpltopCnt> toCacheModel() {
		EmpltopCntCacheModel empltopCntCacheModel = new EmpltopCntCacheModel();

		empltopCntCacheModel.position = getPosition();

		String position = empltopCntCacheModel.position;

		if ((position != null) && (position.length() == 0)) {
			empltopCntCacheModel.position = null;
		}

		empltopCntCacheModel.lastname = getLastname();

		String lastname = empltopCntCacheModel.lastname;

		if ((lastname != null) && (lastname.length() == 0)) {
			empltopCntCacheModel.lastname = null;
		}

		empltopCntCacheModel.count = getCount();

		return empltopCntCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmpltopCnt, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmpltopCnt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmpltopCnt, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EmpltopCnt)this));
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
		Map<String, Function<EmpltopCnt, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmpltopCnt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmpltopCnt, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmpltopCnt)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmpltopCnt>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _position;
	private String _lastname;
	private int _count;

	public <T> T getColumnValue(String columnName) {
		Function<EmpltopCnt, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmpltopCnt)this);
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

		_columnOriginalValues.put("position", _position);
		_columnOriginalValues.put("lastname", _lastname);
		_columnOriginalValues.put("count", _count);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("position", 1L);

		columnBitmasks.put("lastname", 2L);

		columnBitmasks.put("count", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmpltopCnt _escapedModel;

}