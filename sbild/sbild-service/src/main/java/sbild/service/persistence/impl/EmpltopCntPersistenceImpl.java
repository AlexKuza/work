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

import sbild.exception.NoSuchEmpltopCntException;

import sbild.model.EmpltopCnt;
import sbild.model.EmpltopCntTable;
import sbild.model.impl.EmpltopCntImpl;
import sbild.model.impl.EmpltopCntModelImpl;

import sbild.service.persistence.EmpltopCntPersistence;
import sbild.service.persistence.impl.constants.GBPersistenceConstants;

/**
 * The persistence implementation for the empltop cnt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @generated
 */
@Component(service = {EmpltopCntPersistence.class, BasePersistence.class})
public class EmpltopCntPersistenceImpl
	extends BasePersistenceImpl<EmpltopCnt> implements EmpltopCntPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmpltopCntUtil</code> to access the empltop cnt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmpltopCntImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EmpltopCntPersistenceImpl() {
		setModelClass(EmpltopCnt.class);

		setModelImplClass(EmpltopCntImpl.class);
		setModelPKClass(String.class);

		setTable(EmpltopCntTable.INSTANCE);
	}

	/**
	 * Caches the empltop cnt in the entity cache if it is enabled.
	 *
	 * @param empltopCnt the empltop cnt
	 */
	@Override
	public void cacheResult(EmpltopCnt empltopCnt) {
		entityCache.putResult(
			EmpltopCntImpl.class, empltopCnt.getPrimaryKey(), empltopCnt);
	}

	/**
	 * Caches the empltop cnts in the entity cache if it is enabled.
	 *
	 * @param empltopCnts the empltop cnts
	 */
	@Override
	public void cacheResult(List<EmpltopCnt> empltopCnts) {
		for (EmpltopCnt empltopCnt : empltopCnts) {
			if (entityCache.getResult(
					EmpltopCntImpl.class, empltopCnt.getPrimaryKey()) == null) {

				cacheResult(empltopCnt);
			}
		}
	}

	/**
	 * Clears the cache for all empltop cnts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmpltopCntImpl.class);

		finderCache.clearCache(EmpltopCntImpl.class);
	}

	/**
	 * Clears the cache for the empltop cnt.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpltopCnt empltopCnt) {
		entityCache.removeResult(EmpltopCntImpl.class, empltopCnt);
	}

	@Override
	public void clearCache(List<EmpltopCnt> empltopCnts) {
		for (EmpltopCnt empltopCnt : empltopCnts) {
			entityCache.removeResult(EmpltopCntImpl.class, empltopCnt);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmpltopCntImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmpltopCntImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new empltop cnt with the primary key. Does not add the empltop cnt to the database.
	 *
	 * @param lastname the primary key for the new empltop cnt
	 * @return the new empltop cnt
	 */
	@Override
	public EmpltopCnt create(String lastname) {
		EmpltopCnt empltopCnt = new EmpltopCntImpl();

		empltopCnt.setNew(true);
		empltopCnt.setPrimaryKey(lastname);

		return empltopCnt;
	}

	/**
	 * Removes the empltop cnt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt that was removed
	 * @throws NoSuchEmpltopCntException if a empltop cnt with the primary key could not be found
	 */
	@Override
	public EmpltopCnt remove(String lastname) throws NoSuchEmpltopCntException {
		return remove((Serializable)lastname);
	}

	/**
	 * Removes the empltop cnt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the empltop cnt
	 * @return the empltop cnt that was removed
	 * @throws NoSuchEmpltopCntException if a empltop cnt with the primary key could not be found
	 */
	@Override
	public EmpltopCnt remove(Serializable primaryKey)
		throws NoSuchEmpltopCntException {

		Session session = null;

		try {
			session = openSession();

			EmpltopCnt empltopCnt = (EmpltopCnt)session.get(
				EmpltopCntImpl.class, primaryKey);

			if (empltopCnt == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpltopCntException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(empltopCnt);
		}
		catch (NoSuchEmpltopCntException noSuchEntityException) {
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
	protected EmpltopCnt removeImpl(EmpltopCnt empltopCnt) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empltopCnt)) {
				empltopCnt = (EmpltopCnt)session.get(
					EmpltopCntImpl.class, empltopCnt.getPrimaryKeyObj());
			}

			if (empltopCnt != null) {
				session.delete(empltopCnt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (empltopCnt != null) {
			clearCache(empltopCnt);
		}

		return empltopCnt;
	}

	@Override
	public EmpltopCnt updateImpl(EmpltopCnt empltopCnt) {
		boolean isNew = empltopCnt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(empltopCnt);
			}
			else {
				empltopCnt = (EmpltopCnt)session.merge(empltopCnt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EmpltopCntImpl.class, empltopCnt, false, true);

		if (isNew) {
			empltopCnt.setNew(false);
		}

		empltopCnt.resetOriginalValues();

		return empltopCnt;
	}

	/**
	 * Returns the empltop cnt with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the empltop cnt
	 * @return the empltop cnt
	 * @throws NoSuchEmpltopCntException if a empltop cnt with the primary key could not be found
	 */
	@Override
	public EmpltopCnt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpltopCntException {

		EmpltopCnt empltopCnt = fetchByPrimaryKey(primaryKey);

		if (empltopCnt == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpltopCntException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return empltopCnt;
	}

	/**
	 * Returns the empltop cnt with the primary key or throws a <code>NoSuchEmpltopCntException</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt
	 * @throws NoSuchEmpltopCntException if a empltop cnt with the primary key could not be found
	 */
	@Override
	public EmpltopCnt findByPrimaryKey(String lastname)
		throws NoSuchEmpltopCntException {

		return findByPrimaryKey((Serializable)lastname);
	}

	/**
	 * Returns the empltop cnt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastname the primary key of the empltop cnt
	 * @return the empltop cnt, or <code>null</code> if a empltop cnt with the primary key could not be found
	 */
	@Override
	public EmpltopCnt fetchByPrimaryKey(String lastname) {
		return fetchByPrimaryKey((Serializable)lastname);
	}

	/**
	 * Returns all the empltop cnts.
	 *
	 * @return the empltop cnts
	 */
	@Override
	public List<EmpltopCnt> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the empltop cnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop cnts
	 * @param end the upper bound of the range of empltop cnts (not inclusive)
	 * @return the range of empltop cnts
	 */
	@Override
	public List<EmpltopCnt> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the empltop cnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop cnts
	 * @param end the upper bound of the range of empltop cnts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of empltop cnts
	 */
	@Override
	public List<EmpltopCnt> findAll(
		int start, int end, OrderByComparator<EmpltopCnt> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the empltop cnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmpltopCntModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of empltop cnts
	 * @param end the upper bound of the range of empltop cnts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of empltop cnts
	 */
	@Override
	public List<EmpltopCnt> findAll(
		int start, int end, OrderByComparator<EmpltopCnt> orderByComparator,
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

		List<EmpltopCnt> list = null;

		if (useFinderCache) {
			list = (List<EmpltopCnt>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLTOPCNT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLTOPCNT;

				sql = sql.concat(EmpltopCntModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmpltopCnt>)QueryUtil.list(
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
	 * Removes all the empltop cnts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmpltopCnt empltopCnt : findAll()) {
			remove(empltopCnt);
		}
	}

	/**
	 * Returns the number of empltop cnts.
	 *
	 * @return the number of empltop cnts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLTOPCNT);

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
		return _SQL_SELECT_EMPLTOPCNT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmpltopCntModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the empltop cnt persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmpltopCntModelArgumentsResolver(),
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
		entityCache.removeCache(EmpltopCntImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLTOPCNT =
		"SELECT empltopCnt FROM EmpltopCnt empltopCnt";

	private static final String _SQL_COUNT_EMPLTOPCNT =
		"SELECT COUNT(empltopCnt) FROM EmpltopCnt empltopCnt";

	private static final String _ORDER_BY_ENTITY_ALIAS = "empltopCnt.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmpltopCnt exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EmpltopCntPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class EmpltopCntModelArgumentsResolver
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

			EmpltopCntModelImpl empltopCntModelImpl =
				(EmpltopCntModelImpl)baseModel;

			long columnBitmask = empltopCntModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(empltopCntModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						empltopCntModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(empltopCntModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return EmpltopCntImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return EmpltopCntTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			EmpltopCntModelImpl empltopCntModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = empltopCntModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = empltopCntModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}