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

import sbild.model.Employee;
import sbild.model.EmployeeModel;
import sbild.model.EmployeeSoap;

/**
 * The base model implementation for the Employee service. Represents a row in the &quot;GB_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author liferay
 * @see EmployeeImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeModelImpl
	extends BaseModelImpl<Employee> implements EmployeeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee model instance should use the <code>Employee</code> interface instead.
	 */
	public static final String TABLE_NAME = "GB_Employee";

	public static final Object[][] TABLE_COLUMNS = {
		{"emplId", Types.BIGINT}, {"lastname", Types.VARCHAR},
		{"firstname", Types.VARCHAR}, {"patronymic", Types.VARCHAR},
		{"birthdate", Types.TIMESTAMP}, {"posId", Types.BIGINT},
		{"gender", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("emplId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("patronymic", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthdate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("posId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("gender", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table GB_Employee (emplId LONG not null primary key,lastname VARCHAR(75) null,firstname VARCHAR(75) null,patronymic VARCHAR(75) null,birthdate DATE null,posId LONG,gender BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table GB_Employee";

	public static final String ORDER_BY_JPQL = " ORDER BY employee.emplId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY GB_Employee.emplId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLID_COLUMN_BITMASK = 1L;

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
	public static Employee toModel(EmployeeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Employee model = new EmployeeImpl();

		model.setEmplId(soapModel.getEmplId());
		model.setLastname(soapModel.getLastname());
		model.setFirstname(soapModel.getFirstname());
		model.setPatronymic(soapModel.getPatronymic());
		model.setBirthdate(soapModel.getBirthdate());
		model.setPosId(soapModel.getPosId());
		model.setGender(soapModel.isGender());

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
	public static List<Employee> toModels(EmployeeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Employee> models = new ArrayList<Employee>(soapModels.length);

		for (EmployeeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _emplId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmplId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _emplId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Employee)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Employee, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Employee, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Employee)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Employee, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Employee, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Employee>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Employee.class.getClassLoader(), Employee.class,
			ModelWrapper.class);

		try {
			Constructor<Employee> constructor =
				(Constructor<Employee>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Employee, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Employee, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Employee, Object>>();
		Map<String, BiConsumer<Employee, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Employee, ?>>();

		attributeGetterFunctions.put("emplId", Employee::getEmplId);
		attributeSetterBiConsumers.put(
			"emplId", (BiConsumer<Employee, Long>)Employee::setEmplId);
		attributeGetterFunctions.put("lastname", Employee::getLastname);
		attributeSetterBiConsumers.put(
			"lastname", (BiConsumer<Employee, String>)Employee::setLastname);
		attributeGetterFunctions.put("firstname", Employee::getFirstname);
		attributeSetterBiConsumers.put(
			"firstname", (BiConsumer<Employee, String>)Employee::setFirstname);
		attributeGetterFunctions.put("patronymic", Employee::getPatronymic);
		attributeSetterBiConsumers.put(
			"patronymic",
			(BiConsumer<Employee, String>)Employee::setPatronymic);
		attributeGetterFunctions.put("birthdate", Employee::getBirthdate);
		attributeSetterBiConsumers.put(
			"birthdate", (BiConsumer<Employee, Date>)Employee::setBirthdate);
		attributeGetterFunctions.put("posId", Employee::getPosId);
		attributeSetterBiConsumers.put(
			"posId", (BiConsumer<Employee, Long>)Employee::setPosId);
		attributeGetterFunctions.put("gender", Employee::getGender);
		attributeSetterBiConsumers.put(
			"gender", (BiConsumer<Employee, Boolean>)Employee::setGender);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public String getFirstname() {
		if (_firstname == null) {
			return "";
		}
		else {
			return _firstname;
		}
	}

	@Override
	public void setFirstname(String firstname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_firstname = firstname;
	}

	@JSON
	@Override
	public String getPatronymic() {
		if (_patronymic == null) {
			return "";
		}
		else {
			return _patronymic;
		}
	}

	@Override
	public void setPatronymic(String patronymic) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_patronymic = patronymic;
	}

	@JSON
	@Override
	public Date getBirthdate() {
		return _birthdate;
	}

	@Override
	public void setBirthdate(Date birthdate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_birthdate = birthdate;
	}

	@JSON
	@Override
	public long getPosId() {
		return _posId;
	}

	@Override
	public void setPosId(long posId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_posId = posId;
	}

	@JSON
	@Override
	public boolean getGender() {
		return _gender;
	}

	@JSON
	@Override
	public boolean isGender() {
		return _gender;
	}

	@Override
	public void setGender(boolean gender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gender = gender;
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
			0, Employee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employee toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Employee>
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
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmplId(getEmplId());
		employeeImpl.setLastname(getLastname());
		employeeImpl.setFirstname(getFirstname());
		employeeImpl.setPatronymic(getPatronymic());
		employeeImpl.setBirthdate(getBirthdate());
		employeeImpl.setPosId(getPosId());
		employeeImpl.setGender(isGender());

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public int compareTo(Employee employee) {
		long primaryKey = employee.getPrimaryKey();

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

		if (!(object instanceof Employee)) {
			return false;
		}

		Employee employee = (Employee)object;

		long primaryKey = employee.getPrimaryKey();

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
	public CacheModel<Employee> toCacheModel() {
		EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

		employeeCacheModel.emplId = getEmplId();

		employeeCacheModel.lastname = getLastname();

		String lastname = employeeCacheModel.lastname;

		if ((lastname != null) && (lastname.length() == 0)) {
			employeeCacheModel.lastname = null;
		}

		employeeCacheModel.firstname = getFirstname();

		String firstname = employeeCacheModel.firstname;

		if ((firstname != null) && (firstname.length() == 0)) {
			employeeCacheModel.firstname = null;
		}

		employeeCacheModel.patronymic = getPatronymic();

		String patronymic = employeeCacheModel.patronymic;

		if ((patronymic != null) && (patronymic.length() == 0)) {
			employeeCacheModel.patronymic = null;
		}

		Date birthdate = getBirthdate();

		if (birthdate != null) {
			employeeCacheModel.birthdate = birthdate.getTime();
		}
		else {
			employeeCacheModel.birthdate = Long.MIN_VALUE;
		}

		employeeCacheModel.posId = getPosId();

		employeeCacheModel.gender = isGender();

		return employeeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Employee)this));
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
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Employee)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Employee>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _emplId;
	private String _lastname;
	private String _firstname;
	private String _patronymic;
	private Date _birthdate;
	private long _posId;
	private boolean _gender;

	public <T> T getColumnValue(String columnName) {
		Function<Employee, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Employee)this);
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

		_columnOriginalValues.put("emplId", _emplId);
		_columnOriginalValues.put("lastname", _lastname);
		_columnOriginalValues.put("firstname", _firstname);
		_columnOriginalValues.put("patronymic", _patronymic);
		_columnOriginalValues.put("birthdate", _birthdate);
		_columnOriginalValues.put("posId", _posId);
		_columnOriginalValues.put("gender", _gender);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("emplId", 1L);

		columnBitmasks.put("lastname", 2L);

		columnBitmasks.put("firstname", 4L);

		columnBitmasks.put("patronymic", 8L);

		columnBitmasks.put("birthdate", 16L);

		columnBitmasks.put("posId", 32L);

		columnBitmasks.put("gender", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Employee _escapedModel;

}