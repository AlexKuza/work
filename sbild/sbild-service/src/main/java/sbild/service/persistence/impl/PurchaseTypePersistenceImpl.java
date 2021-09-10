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

package sbild.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import sbild.exception.NoSuchPurchaseTypeException;

import sbild.model.PurchaseType;
import sbild.model.PurchaseTypeTable;
import sbild.model.impl.PurchaseTypeImpl;
import sbild.model.impl.PurchaseTypeModelImpl;

import sbild.service.persistence.PurchaseTypePersistence;
import sbild.service.persistence.impl.constants.GBPersistenceConstants;

/**
 * The persistence implementation for the purchase type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @generated
 */
@Component(service = {PurchaseTypePersistence.class, BasePersistence.class})
public class PurchaseTypePersistenceImpl
	extends BasePersistenceImpl<PurchaseType>
	implements PurchaseTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PurchaseTypeUtil</code> to access the purchase type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PurchaseTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PurchaseTypePersistenceImpl() {
		setModelClass(PurchaseType.class);

		setModelImplClass(PurchaseTypeImpl.class);
		setModelPKClass(long.class);

		setTable(PurchaseTypeTable.INSTANCE);
	}

	/**
	 * Caches the purchase type in the entity cache if it is enabled.
	 *
	 * @param purchaseType the purchase type
	 */
	@Override
	public void cacheResult(PurchaseType purchaseType) {
		entityCache.putResult(
			PurchaseTypeImpl.class, purchaseType.getPrimaryKey(), purchaseType);
	}

	/**
	 * Caches the purchase types in the entity cache if it is enabled.
	 *
	 * @param purchaseTypes the purchase types
	 */
	@Override
	public void cacheResult(List<PurchaseType> purchaseTypes) {
		for (PurchaseType purchaseType : purchaseTypes) {
			if (entityCache.getResult(
					PurchaseTypeImpl.class, purchaseType.getPrimaryKey()) ==
						null) {

				cacheResult(purchaseType);
			}
		}
	}

	/**
	 * Clears the cache for all purchase types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PurchaseTypeImpl.class);

		finderCache.clearCache(PurchaseTypeImpl.class);
	}

	/**
	 * Clears the cache for the purchase type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PurchaseType purchaseType) {
		entityCache.removeResult(PurchaseTypeImpl.class, purchaseType);
	}

	@Override
	public void clearCache(List<PurchaseType> purchaseTypes) {
		for (PurchaseType purchaseType : purchaseTypes) {
			entityCache.removeResult(PurchaseTypeImpl.class, purchaseType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PurchaseTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PurchaseTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new purchase type with the primary key. Does not add the purchase type to the database.
	 *
	 * @param purchtypeId the primary key for the new purchase type
	 * @return the new purchase type
	 */
	@Override
	public PurchaseType create(long purchtypeId) {
		PurchaseType purchaseType = new PurchaseTypeImpl();

		purchaseType.setNew(true);
		purchaseType.setPrimaryKey(purchtypeId);

		return purchaseType;
	}

	/**
	 * Removes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchtypeId the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType remove(long purchtypeId)
		throws NoSuchPurchaseTypeException {

		return remove((Serializable)purchtypeId);
	}

	/**
	 * Removes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType remove(Serializable primaryKey)
		throws NoSuchPurchaseTypeException {

		Session session = null;

		try {
			session = openSession();

			PurchaseType purchaseType = (PurchaseType)session.get(
				PurchaseTypeImpl.class, primaryKey);

			if (purchaseType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(purchaseType);
		}
		catch (NoSuchPurchaseTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PurchaseType removeImpl(PurchaseType purchaseType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(purchaseType)) {
				purchaseType = (PurchaseType)session.get(
					PurchaseTypeImpl.class, purchaseType.getPrimaryKeyObj());
			}

			if (purchaseType != null) {
				session.delete(purchaseType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (purchaseType != null) {
			clearCache(purchaseType);
		}

		return purchaseType;
	}

	@Override
	public PurchaseType updateImpl(PurchaseType purchaseType) {
		boolean isNew = purchaseType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(purchaseType);
			}
			else {
				purchaseType = (PurchaseType)session.merge(purchaseType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PurchaseTypeImpl.class, purchaseType, false, true);

		if (isNew) {
			purchaseType.setNew(false);
		}

		purchaseType.resetOriginalValues();

		return purchaseType;
	}

	/**
	 * Returns the purchase type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase type
	 * @return the purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPurchaseTypeException {

		PurchaseType purchaseType = fetchByPrimaryKey(primaryKey);

		if (purchaseType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPurchaseTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return purchaseType;
	}

	/**
	 * Returns the purchase type with the primary key or throws a <code>NoSuchPurchaseTypeException</code> if it could not be found.
	 *
	 * @param purchtypeId the primary key of the purchase type
	 * @return the purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType findByPrimaryKey(long purchtypeId)
		throws NoSuchPurchaseTypeException {

		return findByPrimaryKey((Serializable)purchtypeId);
	}

	/**
	 * Returns the purchase type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchtypeId the primary key of the purchase type
	 * @return the purchase type, or <code>null</code> if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType fetchByPrimaryKey(long purchtypeId) {
		return fetchByPrimaryKey((Serializable)purchtypeId);
	}

	/**
	 * Returns all the purchase types.
	 *
	 * @return the purchase types
	 */
	@Override
	public List<PurchaseType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of purchase types
	 */
	@Override
	public List<PurchaseType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchase types
	 */
	@Override
	public List<PurchaseType> findAll(
		int start, int end, OrderByComparator<PurchaseType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of purchase types
	 */
	@Override
	public List<PurchaseType> findAll(
		int start, int end, OrderByComparator<PurchaseType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PurchaseType> list = null;

		if (useFinderCache) {
			list = (List<PurchaseType>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PURCHASETYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASETYPE;

				sql = sql.concat(PurchaseTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PurchaseType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the purchase types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PurchaseType purchaseType : findAll()) {
			remove(purchaseType);
		}
	}

	/**
	 * Returns the number of purchase types.
	 *
	 * @return the number of purchase types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PURCHASETYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "purchtypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PURCHASETYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PurchaseTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the purchase type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PurchaseTypeModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PurchaseTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PURCHASETYPE =
		"SELECT purchaseType FROM PurchaseType purchaseType";

	private static final String _SQL_COUNT_PURCHASETYPE =
		"SELECT COUNT(purchaseType) FROM PurchaseType purchaseType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "purchaseType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PurchaseType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PurchaseTypePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class PurchaseTypeModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			PurchaseTypeModelImpl purchaseTypeModelImpl =
				(PurchaseTypeModelImpl)baseModel;

			long columnBitmask = purchaseTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(purchaseTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						purchaseTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(purchaseTypeModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return PurchaseTypeImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return PurchaseTypeTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			PurchaseTypeModelImpl purchaseTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = purchaseTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = purchaseTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}