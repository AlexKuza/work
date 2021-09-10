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

import sbild.exception.NoSuchEmpltopSumException;

import sbild.model.EmpltopSum;
import sbild.model.EmpltopSumTable;
import sbild.model.impl.EmpltopSumImpl;
import sbild.model.impl.EmpltopSumModelImpl;

import sbild.service.persistence.EmpltopSumPersistence;
import sbild.service.persistence.impl.constants.GBPersistenceConstants;

/**
 * The persistence implementation for the empltop sum service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @generated
 */
@Component(service = {EmpltopSumPersistence.class, BasePersistence.class})
public class EmpltopSumPersistenceImpl
	extends BasePersistenceImpl<EmpltopSum> implements EmpltopSumPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmpltopSumUtil</code> to access the empltop sum persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmpltopSumImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EmpltopSumPersistenceImpl() {
		setModelClass(EmpltopSum.class);

		setModelImplClass(EmpltopSumImpl.class);
		setModelPKClass(String.class);

		setTable(EmpltopSumTable.INSTANCE);
	}

	/**
	 * Caches the empltop sum in the entity cache if it is enabled.
	 *
	 * @param empltopSum the empltop sum
	 */
	@Override
	public void cacheResult(EmpltopSum empltopSum) {
		entityCache.putResult(
			EmpltopSumImpl.class, empltopSum.getPrimaryKey(), empltopSum);
	}

	/**
	 * Caches the empltop sums in the entity cache if it is enabled.
	 *
	 * @param empltopSums the empltop sums
	 */
	@Override
	public void cacheResult(List<EmpltopSum> empltopSums) {
		for (EmpltopSum empltopSum : empltopSums) {
			if (entityCache.getResult(
					EmpltopSumImpl.class, empltopSum.getPrimaryKey()) == null) {

				cacheResult(empltopSum);
			}
		}
	}

	/**
	 * Clears the cache for all empltop sums.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmpltopSumImpl.class);

		finderCache.clearCache(EmpltopSumImpl.class);
	}

	/**
	 * Clears the cache for the empltop sum.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpltopSum empltopSum) {
		entityCache.removeResult(EmpltopSumImpl.class, empltopSum);
	}

	@Override
	public void clearCache(List<EmpltopSum> empltopSums) {
		for (EmpltopSum empltopSum : empltopSums) {
			entityCache.removeResult(EmpltopSumImpl.class, empltopSum);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmpltopSumImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmpltopSumImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new empltop sum with the primary key. Does not add the empltop sum to the database.
	 *
	 * @param lastname the primary key for the new empltop sum
	 * @return the new empltop sum
	 */
	@Override
	public EmpltopSum create(String lastname) {
		EmpltopSum empltopSum = new EmpltopSumImpl();

		empltopSum.setNew(true);
		empltopSum.setPrimaryKey(lastname);

		return empltopSum;
	}

	/**
	 * Removes the empltop sum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum that was removed
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	@Override
	public EmpltopSum remove(String lastname) throws NoSuchEmpltopSumException {
		return remove((Serializable)lastname);
	}

	/**
	 * Removes the empltop sum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the empltop sum
	 * @return the empltop sum that was removed
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	@Override
	public EmpltopSum remove(Serializable primaryKey)
		throws NoSuchEmpltopSumException {

		Session session = null;

		try {
			session = openSession();

			EmpltopSum empltopSum = (EmpltopSum)session.get(
				EmpltopSumImpl.class, primaryKey);

			if (empltopSum == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpltopSumException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(empltopSum);
		}
		catch (NoSuchEmpltopSumException noSuchEntityException) {
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
	protected EmpltopSum removeImpl(EmpltopSum empltopSum) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empltopSum)) {
				empltopSum = (EmpltopSum)session.get(
					EmpltopSumImpl.class, empltopSum.getPrimaryKeyObj());
			}

			if (empltopSum != null) {
				session.delete(empltopSum);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (empltopSum != null) {
			clearCache(empltopSum);
		}

		return empltopSum;
	}

	@Override
	public EmpltopSum updateImpl(EmpltopSum empltopSum) {
		boolean isNew = empltopSum.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(empltopSum);
			}
			else {
				empltopSum = (EmpltopSum)session.merge(empltopSum);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EmpltopSumImpl.class, empltopSum, false, true);

		if (isNew) {
			empltopSum.setNew(false);
		}

		empltopSum.resetOriginalValues();

		return empltopSum;
	}

	/**
	 * Returns the empltop sum with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the empltop sum
	 * @return the empltop sum
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	@Override
	public EmpltopSum findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpltopSumException {

		EmpltopSum empltopSum = fetchByPrimaryKey(primaryKey);

		if (empltopSum == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpltopSumException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return empltopSum;
	}

	/**
	 * Returns the empltop sum with the primary key or throws a <code>NoSuchEmpltopSumException</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum
	 * @throws NoSuchEmpltopSumException if a empltop sum with the primary key could not be found
	 */
	@Override
	public EmpltopSum findByPrimaryKey(String lastname)
		throws NoSuchEmpltopSumException {

		return findByPrimaryKey((Serializable)lastname);
	}

	/**
	 * Returns the empltop sum with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop sum
	 * @return the empltop sum, or <code>null</code> if a empltop sum with the primary key could not be found
	 */
	@Override
	public EmpltopSum fetchByPrimaryKey(String lastname) {
		return fetchByPrimaryKey((Serializable)lastname);
	}

	/**
	 * Returns all the empltop sums.
	 *
	 * @return the empltop sums
	 */
	@Override
	public List<EmpltopSum> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the empltop sums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop sums
	 * @param end the upper bound of the range of empltop sums (not inclusive)
	 * @return the range of empltop sums
	 */
	@Override
	public List<EmpltopSum> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the empltop sums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop sums
	 * @param end the upper bound of the range of empltop sums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of empltop sums
	 */
	@Override
	public List<EmpltopSum> findAll(
		int start, int end, OrderByComparator<EmpltopSum> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the empltop sums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopSumModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop sums
	 * @param end the upper bound of the range of empltop sums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of empltop sums
	 */
	@Override
	public List<EmpltopSum> findAll(
		int start, int end, OrderByComparator<EmpltopSum> orderByComparator,
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

		List<EmpltopSum> list = null;

		if (useFinderCache) {
			list = (List<EmpltopSum>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLTOPSUM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLTOPSUM;

				sql = sql.concat(EmpltopSumModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmpltopSum>)QueryUtil.list(
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
	 * Removes all the empltop sums from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmpltopSum empltopSum : findAll()) {
			remove(empltopSum);
		}
	}

	/**
	 * Returns the number of empltop sums.
	 *
	 * @return the number of empltop sums
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLTOPSUM);

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
		return "lastname";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLTOPSUM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmpltopSumModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the empltop sum persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmpltopSumModelArgumentsResolver(),
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
		entityCache.removeCache(EmpltopSumImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLTOPSUM =
		"SELECT empltopSum FROM EmpltopSum empltopSum";

	private static final String _SQL_COUNT_EMPLTOPSUM =
		"SELECT COUNT(empltopSum) FROM EmpltopSum empltopSum";

	private static final String _ORDER_BY_ENTITY_ALIAS = "empltopSum.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmpltopSum exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EmpltopSumPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class EmpltopSumModelArgumentsResolver
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

			EmpltopSumModelImpl empltopSumModelImpl =
				(EmpltopSumModelImpl)baseModel;

			long columnBitmask = empltopSumModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(empltopSumModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						empltopSumModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(empltopSumModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return EmpltopSumImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return EmpltopSumTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			EmpltopSumModelImpl empltopSumModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = empltopSumModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = empltopSumModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}