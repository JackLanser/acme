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

package com.liferay.amf.monitor.service.persistence.impl;

import com.liferay.amf.monitor.exception.NoSucheventMonitorException;
import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.amf.monitor.model.impl.eventMonitorImpl;
import com.liferay.amf.monitor.model.impl.eventMonitorModelImpl;
import com.liferay.amf.monitor.service.persistence.eventMonitorPersistence;
import com.liferay.amf.monitor.service.persistence.impl.constants.AmfEventMonitorPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the event monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = eventMonitorPersistence.class)
public class eventMonitorPersistenceImpl
	extends BasePersistenceImpl<eventMonitor>
	implements eventMonitorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>eventMonitorUtil</code> to access the event monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		eventMonitorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEventType;
	private FinderPath _finderPathWithoutPaginationFindByEventType;
	private FinderPath _finderPathCountByEventType;

	/**
	 * Returns all the event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching event monitors
	 */
	@Override
	public List<eventMonitor> findByEventType(String eventType) {
		return findByEventType(
			eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of matching event monitors
	 */
	@Override
	public List<eventMonitor> findByEventType(
		String eventType, int start, int end) {

		return findByEventType(eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event monitors
	 */
	@Override
	public List<eventMonitor> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator) {

		return findByEventType(eventType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event monitors
	 */
	@Override
	public List<eventMonitor> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator,
		boolean useFinderCache) {

		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEventType;
				finderArgs = new Object[] {eventType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEventType;
			finderArgs = new Object[] {
				eventType, start, end, orderByComparator
			};
		}

		List<eventMonitor> list = null;

		if (useFinderCache) {
			list = (List<eventMonitor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (eventMonitor eventMonitor : list) {
					if (!eventType.equals(eventMonitor.getEventType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EVENTMONITOR_WHERE);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(eventMonitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				list = (List<eventMonitor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	@Override
	public eventMonitor findByEventType_First(
			String eventType, OrderByComparator<eventMonitor> orderByComparator)
		throws NoSucheventMonitorException {

		eventMonitor eventMonitor = fetchByEventType_First(
			eventType, orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSucheventMonitorException(sb.toString());
	}

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	@Override
	public eventMonitor fetchByEventType_First(
		String eventType, OrderByComparator<eventMonitor> orderByComparator) {

		List<eventMonitor> list = findByEventType(
			eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	@Override
	public eventMonitor findByEventType_Last(
			String eventType, OrderByComparator<eventMonitor> orderByComparator)
		throws NoSucheventMonitorException {

		eventMonitor eventMonitor = fetchByEventType_Last(
			eventType, orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSucheventMonitorException(sb.toString());
	}

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	@Override
	public eventMonitor fetchByEventType_Last(
		String eventType, OrderByComparator<eventMonitor> orderByComparator) {

		int count = countByEventType(eventType);

		if (count == 0) {
			return null;
		}

		List<eventMonitor> list = findByEventType(
			eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event monitors before and after the current event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventMonitorId the primary key of the current event monitor
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event monitor
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	@Override
	public eventMonitor[] findByEventType_PrevAndNext(
			long eventMonitorId, String eventType,
			OrderByComparator<eventMonitor> orderByComparator)
		throws NoSucheventMonitorException {

		eventType = Objects.toString(eventType, "");

		eventMonitor eventMonitor = findByPrimaryKey(eventMonitorId);

		Session session = null;

		try {
			session = openSession();

			eventMonitor[] array = new eventMonitorImpl[3];

			array[0] = getByEventType_PrevAndNext(
				session, eventMonitor, eventType, orderByComparator, true);

			array[1] = eventMonitor;

			array[2] = getByEventType_PrevAndNext(
				session, eventMonitor, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected eventMonitor getByEventType_PrevAndNext(
		Session session, eventMonitor eventMonitor, String eventType,
		OrderByComparator<eventMonitor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTMONITOR_WHERE);

		boolean bindEventType = false;

		if (eventType.isEmpty()) {
			sb.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			sb.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(eventMonitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEventType) {
			queryPos.add(eventType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(eventMonitor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<eventMonitor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event monitors where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	@Override
	public void removeByEventType(String eventType) {
		for (eventMonitor eventMonitor :
				findByEventType(
					eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eventMonitor);
		}
	}

	/**
	 * Returns the number of event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching event monitors
	 */
	@Override
	public int countByEventType(String eventType) {
		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = _finderPathCountByEventType;

		Object[] finderArgs = new Object[] {eventType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTMONITOR_WHERE);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 =
		"eventMonitor.eventType = ?";

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 =
		"(eventMonitor.eventType IS NULL OR eventMonitor.eventType = '')";

	public eventMonitorPersistenceImpl() {
		setModelClass(eventMonitor.class);

		setModelImplClass(eventMonitorImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the event monitor in the entity cache if it is enabled.
	 *
	 * @param eventMonitor the event monitor
	 */
	@Override
	public void cacheResult(eventMonitor eventMonitor) {
		entityCache.putResult(
			entityCacheEnabled, eventMonitorImpl.class,
			eventMonitor.getPrimaryKey(), eventMonitor);

		eventMonitor.resetOriginalValues();
	}

	/**
	 * Caches the event monitors in the entity cache if it is enabled.
	 *
	 * @param eventMonitors the event monitors
	 */
	@Override
	public void cacheResult(List<eventMonitor> eventMonitors) {
		for (eventMonitor eventMonitor : eventMonitors) {
			if (entityCache.getResult(
					entityCacheEnabled, eventMonitorImpl.class,
					eventMonitor.getPrimaryKey()) == null) {

				cacheResult(eventMonitor);
			}
			else {
				eventMonitor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event monitors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(eventMonitorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event monitor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(eventMonitor eventMonitor) {
		entityCache.removeResult(
			entityCacheEnabled, eventMonitorImpl.class,
			eventMonitor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<eventMonitor> eventMonitors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (eventMonitor eventMonitor : eventMonitors) {
			entityCache.removeResult(
				entityCacheEnabled, eventMonitorImpl.class,
				eventMonitor.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, eventMonitorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	 *
	 * @param eventMonitorId the primary key for the new event monitor
	 * @return the new event monitor
	 */
	@Override
	public eventMonitor create(long eventMonitorId) {
		eventMonitor eventMonitor = new eventMonitorImpl();

		eventMonitor.setNew(true);
		eventMonitor.setPrimaryKey(eventMonitorId);

		return eventMonitor;
	}

	/**
	 * Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	@Override
	public eventMonitor remove(long eventMonitorId)
		throws NoSucheventMonitorException {

		return remove((Serializable)eventMonitorId);
	}

	/**
	 * Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	@Override
	public eventMonitor remove(Serializable primaryKey)
		throws NoSucheventMonitorException {

		Session session = null;

		try {
			session = openSession();

			eventMonitor eventMonitor = (eventMonitor)session.get(
				eventMonitorImpl.class, primaryKey);

			if (eventMonitor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSucheventMonitorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eventMonitor);
		}
		catch (NoSucheventMonitorException noSuchEntityException) {
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
	protected eventMonitor removeImpl(eventMonitor eventMonitor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventMonitor)) {
				eventMonitor = (eventMonitor)session.get(
					eventMonitorImpl.class, eventMonitor.getPrimaryKeyObj());
			}

			if (eventMonitor != null) {
				session.delete(eventMonitor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (eventMonitor != null) {
			clearCache(eventMonitor);
		}

		return eventMonitor;
	}

	@Override
	public eventMonitor updateImpl(eventMonitor eventMonitor) {
		boolean isNew = eventMonitor.isNew();

		if (!(eventMonitor instanceof eventMonitorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(eventMonitor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					eventMonitor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in eventMonitor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom eventMonitor implementation " +
					eventMonitor.getClass());
		}

		eventMonitorModelImpl eventMonitorModelImpl =
			(eventMonitorModelImpl)eventMonitor;

		Session session = null;

		try {
			session = openSession();

			if (eventMonitor.isNew()) {
				session.save(eventMonitor);

				eventMonitor.setNew(false);
			}
			else {
				eventMonitor = (eventMonitor)session.merge(eventMonitor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {eventMonitorModelImpl.getEventType()};

			finderCache.removeResult(_finderPathCountByEventType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByEventType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((eventMonitorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByEventType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					eventMonitorModelImpl.getOriginalEventType()
				};

				finderCache.removeResult(_finderPathCountByEventType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEventType, args);

				args = new Object[] {eventMonitorModelImpl.getEventType()};

				finderCache.removeResult(_finderPathCountByEventType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEventType, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, eventMonitorImpl.class,
			eventMonitor.getPrimaryKey(), eventMonitor, false);

		eventMonitor.resetOriginalValues();

		return eventMonitor;
	}

	/**
	 * Returns the event monitor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event monitor
	 * @return the event monitor
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	@Override
	public eventMonitor findByPrimaryKey(Serializable primaryKey)
		throws NoSucheventMonitorException {

		eventMonitor eventMonitor = fetchByPrimaryKey(primaryKey);

		if (eventMonitor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSucheventMonitorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eventMonitor;
	}

	/**
	 * Returns the event monitor with the primary key or throws a <code>NoSucheventMonitorException</code> if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	@Override
	public eventMonitor findByPrimaryKey(long eventMonitorId)
		throws NoSucheventMonitorException {

		return findByPrimaryKey((Serializable)eventMonitorId);
	}

	/**
	 * Returns the event monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor, or <code>null</code> if a event monitor with the primary key could not be found
	 */
	@Override
	public eventMonitor fetchByPrimaryKey(long eventMonitorId) {
		return fetchByPrimaryKey((Serializable)eventMonitorId);
	}

	/**
	 * Returns all the event monitors.
	 *
	 * @return the event monitors
	 */
	@Override
	public List<eventMonitor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of event monitors
	 */
	@Override
	public List<eventMonitor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event monitors
	 */
	@Override
	public List<eventMonitor> findAll(
		int start, int end, OrderByComparator<eventMonitor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event monitors
	 */
	@Override
	public List<eventMonitor> findAll(
		int start, int end, OrderByComparator<eventMonitor> orderByComparator,
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

		List<eventMonitor> list = null;

		if (useFinderCache) {
			list = (List<eventMonitor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EVENTMONITOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTMONITOR;

				sql = sql.concat(eventMonitorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<eventMonitor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the event monitors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (eventMonitor eventMonitor : findAll()) {
			remove(eventMonitor);
		}
	}

	/**
	 * Returns the number of event monitors.
	 *
	 * @return the number of event monitors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EVENTMONITOR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

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
		return "eventMonitorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EVENTMONITOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return eventMonitorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the event monitor persistence.
	 */
	@Activate
	public void activate() {
		eventMonitorModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		eventMonitorModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, eventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, eventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, eventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, eventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] {String.class.getName()},
			eventMonitorModelImpl.EVENTTYPE_COLUMN_BITMASK |
			eventMonitorModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByEventType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(eventMonitorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = AmfEventMonitorPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.amf.monitor.model.eventMonitor"),
			true);
	}

	@Override
	@Reference(
		target = AmfEventMonitorPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfEventMonitorPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EVENTMONITOR =
		"SELECT eventMonitor FROM eventMonitor eventMonitor";

	private static final String _SQL_SELECT_EVENTMONITOR_WHERE =
		"SELECT eventMonitor FROM eventMonitor eventMonitor WHERE ";

	private static final String _SQL_COUNT_EVENTMONITOR =
		"SELECT COUNT(eventMonitor) FROM eventMonitor eventMonitor";

	private static final String _SQL_COUNT_EVENTMONITOR_WHERE =
		"SELECT COUNT(eventMonitor) FROM eventMonitor eventMonitor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "eventMonitor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No eventMonitor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No eventMonitor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		eventMonitorPersistenceImpl.class);

	static {
		try {
			Class.forName(AmfEventMonitorPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}