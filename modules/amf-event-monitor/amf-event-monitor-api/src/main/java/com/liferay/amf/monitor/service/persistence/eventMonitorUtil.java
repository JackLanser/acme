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

package com.liferay.amf.monitor.service.persistence;

import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the event monitor service. This utility wraps <code>com.liferay.amf.monitor.service.persistence.impl.eventMonitorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorPersistence
 * @generated
 */
public class eventMonitorUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(eventMonitor eventMonitor) {
		getPersistence().clearCache(eventMonitor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, eventMonitor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<eventMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<eventMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<eventMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static eventMonitor update(eventMonitor eventMonitor) {
		return getPersistence().update(eventMonitor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static eventMonitor update(
		eventMonitor eventMonitor, ServiceContext serviceContext) {

		return getPersistence().update(eventMonitor, serviceContext);
	}

	/**
	 * Returns all the event monitors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching event monitors
	 */
	public static List<eventMonitor> findByAllUserId(long userId) {
		return getPersistence().findByAllUserId(userId);
	}

	/**
	 * Returns a range of all the event monitors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of matching event monitors
	 */
	public static List<eventMonitor> findByAllUserId(
		long userId, int start, int end) {

		return getPersistence().findByAllUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the event monitors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event monitors
	 */
	public static List<eventMonitor> findByAllUserId(
		long userId, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().findByAllUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the event monitors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event monitors
	 */
	public static List<eventMonitor> findByAllUserId(
		long userId, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAllUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	public static eventMonitor findByAllUserId_First(
			long userId, OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByAllUserId_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public static eventMonitor fetchByAllUserId_First(
		long userId, OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().fetchByAllUserId_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	public static eventMonitor findByAllUserId_Last(
			long userId, OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByAllUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public static eventMonitor fetchByAllUserId_Last(
		long userId, OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().fetchByAllUserId_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the event monitors before and after the current event monitor in the ordered set where userId = &#63;.
	 *
	 * @param eventMonitorId the primary key of the current event monitor
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event monitor
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	public static eventMonitor[] findByAllUserId_PrevAndNext(
			long eventMonitorId, long userId,
			OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByAllUserId_PrevAndNext(
			eventMonitorId, userId, orderByComparator);
	}

	/**
	 * Removes all the event monitors where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByAllUserId(long userId) {
		getPersistence().removeByAllUserId(userId);
	}

	/**
	 * Returns the number of event monitors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching event monitors
	 */
	public static int countByAllUserId(long userId) {
		return getPersistence().countByAllUserId(userId);
	}

	/**
	 * Returns all the event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching event monitors
	 */
	public static List<eventMonitor> findByEventType(String eventType) {
		return getPersistence().findByEventType(eventType);
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
	public static List<eventMonitor> findByEventType(
		String eventType, int start, int end) {

		return getPersistence().findByEventType(eventType, start, end);
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
	public static List<eventMonitor> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().findByEventType(
			eventType, start, end, orderByComparator);
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
	public static List<eventMonitor> findByEventType(
		String eventType, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEventType(
			eventType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	public static eventMonitor findByEventType_First(
			String eventType, OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByEventType_First(
			eventType, orderByComparator);
	}

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public static eventMonitor fetchByEventType_First(
		String eventType, OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().fetchByEventType_First(
			eventType, orderByComparator);
	}

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	public static eventMonitor findByEventType_Last(
			String eventType, OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByEventType_Last(
			eventType, orderByComparator);
	}

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public static eventMonitor fetchByEventType_Last(
		String eventType, OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().fetchByEventType_Last(
			eventType, orderByComparator);
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
	public static eventMonitor[] findByEventType_PrevAndNext(
			long eventMonitorId, String eventType,
			OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByEventType_PrevAndNext(
			eventMonitorId, eventType, orderByComparator);
	}

	/**
	 * Removes all the event monitors where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public static void removeByEventType(String eventType) {
		getPersistence().removeByEventType(eventType);
	}

	/**
	 * Returns the number of event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching event monitors
	 */
	public static int countByEventType(String eventType) {
		return getPersistence().countByEventType(eventType);
	}

	/**
	 * Returns all the event monitors where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching event monitors
	 */
	public static List<eventMonitor> findByUserId(
		long userId, String eventType) {

		return getPersistence().findByUserId(userId, eventType);
	}

	/**
	 * Returns a range of all the event monitors where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of matching event monitors
	 */
	public static List<eventMonitor> findByUserId(
		long userId, String eventType, int start, int end) {

		return getPersistence().findByUserId(userId, eventType, start, end);
	}

	/**
	 * Returns an ordered range of all the event monitors where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event monitors
	 */
	public static List<eventMonitor> findByUserId(
		long userId, String eventType, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().findByUserId(
			userId, eventType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the event monitors where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event monitors
	 */
	public static List<eventMonitor> findByUserId(
		long userId, String eventType, int start, int end,
		OrderByComparator<eventMonitor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, eventType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	public static eventMonitor findByUserId_First(
			long userId, String eventType,
			OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByUserId_First(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public static eventMonitor fetchByUserId_First(
		long userId, String eventType,
		OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().fetchByUserId_First(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws NoSucheventMonitorException if a matching event monitor could not be found
	 */
	public static eventMonitor findByUserId_Last(
			long userId, String eventType,
			OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByUserId_Last(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public static eventMonitor fetchByUserId_Last(
		long userId, String eventType,
		OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().fetchByUserId_Last(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the event monitors before and after the current event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param eventMonitorId the primary key of the current event monitor
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event monitor
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	public static eventMonitor[] findByUserId_PrevAndNext(
			long eventMonitorId, long userId, String eventType,
			OrderByComparator<eventMonitor> orderByComparator)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByUserId_PrevAndNext(
			eventMonitorId, userId, eventType, orderByComparator);
	}

	/**
	 * Removes all the event monitors where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	public static void removeByUserId(long userId, String eventType) {
		getPersistence().removeByUserId(userId, eventType);
	}

	/**
	 * Returns the number of event monitors where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching event monitors
	 */
	public static int countByUserId(long userId, String eventType) {
		return getPersistence().countByUserId(userId, eventType);
	}

	/**
	 * Caches the event monitor in the entity cache if it is enabled.
	 *
	 * @param eventMonitor the event monitor
	 */
	public static void cacheResult(eventMonitor eventMonitor) {
		getPersistence().cacheResult(eventMonitor);
	}

	/**
	 * Caches the event monitors in the entity cache if it is enabled.
	 *
	 * @param eventMonitors the event monitors
	 */
	public static void cacheResult(List<eventMonitor> eventMonitors) {
		getPersistence().cacheResult(eventMonitors);
	}

	/**
	 * Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	 *
	 * @param eventMonitorId the primary key for the new event monitor
	 * @return the new event monitor
	 */
	public static eventMonitor create(long eventMonitorId) {
		return getPersistence().create(eventMonitorId);
	}

	/**
	 * Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	public static eventMonitor remove(long eventMonitorId)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().remove(eventMonitorId);
	}

	public static eventMonitor updateImpl(eventMonitor eventMonitor) {
		return getPersistence().updateImpl(eventMonitor);
	}

	/**
	 * Returns the event monitor with the primary key or throws a <code>NoSucheventMonitorException</code> if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor
	 * @throws NoSucheventMonitorException if a event monitor with the primary key could not be found
	 */
	public static eventMonitor findByPrimaryKey(long eventMonitorId)
		throws com.liferay.amf.monitor.exception.NoSucheventMonitorException {

		return getPersistence().findByPrimaryKey(eventMonitorId);
	}

	/**
	 * Returns the event monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor, or <code>null</code> if a event monitor with the primary key could not be found
	 */
	public static eventMonitor fetchByPrimaryKey(long eventMonitorId) {
		return getPersistence().fetchByPrimaryKey(eventMonitorId);
	}

	/**
	 * Returns all the event monitors.
	 *
	 * @return the event monitors
	 */
	public static List<eventMonitor> findAll() {
		return getPersistence().findAll();
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
	public static List<eventMonitor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<eventMonitor> findAll(
		int start, int end, OrderByComparator<eventMonitor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<eventMonitor> findAll(
		int start, int end, OrderByComparator<eventMonitor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the event monitors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event monitors.
	 *
	 * @return the number of event monitors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static eventMonitorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<eventMonitorPersistence, eventMonitorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(eventMonitorPersistence.class);

		ServiceTracker<eventMonitorPersistence, eventMonitorPersistence>
			serviceTracker =
				new ServiceTracker
					<eventMonitorPersistence, eventMonitorPersistence>(
						bundle.getBundleContext(),
						eventMonitorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}