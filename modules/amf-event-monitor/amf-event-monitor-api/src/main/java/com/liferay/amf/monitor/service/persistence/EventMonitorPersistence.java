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

import com.liferay.amf.monitor.exception.NoSuchEventMonitorException;
import com.liferay.amf.monitor.model.EventMonitor;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventMonitorUtil
 * @generated
 */
@ProviderType
public interface EventMonitorPersistence extends BasePersistence<EventMonitor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventMonitorUtil} to access the event monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching event monitors
	 */
	public java.util.List<EventMonitor> findByEventType(String eventType);

	/**
	 * Returns a range of all the event monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByEventType(
		String eventType, int start, int end);

	/**
	 * Returns an ordered range of all the event monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByEventType(
		String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByEventType(
		String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws NoSuchEventMonitorException if a matching event monitor could not be found
	 */
	public EventMonitor findByEventType_First(
			String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public EventMonitor fetchByEventType_First(
		String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws NoSuchEventMonitorException if a matching event monitor could not be found
	 */
	public EventMonitor findByEventType_Last(
			String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public EventMonitor fetchByEventType_Last(
		String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns the event monitors before and after the current event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventMonitorId the primary key of the current event monitor
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event monitor
	 * @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 */
	public EventMonitor[] findByEventType_PrevAndNext(
			long eventMonitorId, String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Removes all the event monitors where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public void removeByEventType(String eventType);

	/**
	 * Returns the number of event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching event monitors
	 */
	public int countByEventType(String eventType);

	/**
	 * Returns all the event monitors where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @return the matching event monitors
	 */
	public java.util.List<EventMonitor> findByUserId(
		String eventType, long userId);

	/**
	 * Returns a range of all the event monitors where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByUserId(
		String eventType, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the event monitors where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByUserId(
		String eventType, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event monitors where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByUserId(
		String eventType, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws NoSuchEventMonitorException if a matching event monitor could not be found
	 */
	public EventMonitor findByUserId_First(
			String eventType, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public EventMonitor fetchByUserId_First(
		String eventType, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws NoSuchEventMonitorException if a matching event monitor could not be found
	 */
	public EventMonitor findByUserId_Last(
			String eventType, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public EventMonitor fetchByUserId_Last(
		String eventType, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns the event monitors before and after the current event monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventMonitorId the primary key of the current event monitor
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event monitor
	 * @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 */
	public EventMonitor[] findByUserId_PrevAndNext(
			long eventMonitorId, String eventType, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Removes all the event monitors where eventType = &#63; and userId = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 */
	public void removeByUserId(String eventType, long userId);

	/**
	 * Returns the number of event monitors where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @return the number of matching event monitors
	 */
	public int countByUserId(String eventType, long userId);

	/**
	 * Returns all the event monitors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching event monitors
	 */
	public java.util.List<EventMonitor> findByAllUserId(long userId);

	/**
	 * Returns a range of all the event monitors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByAllUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the event monitors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByAllUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event monitors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event monitors
	 */
	public java.util.List<EventMonitor> findByAllUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws NoSuchEventMonitorException if a matching event monitor could not be found
	 */
	public EventMonitor findByAllUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public EventMonitor fetchByAllUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws NoSuchEventMonitorException if a matching event monitor could not be found
	 */
	public EventMonitor findByAllUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 */
	public EventMonitor fetchByAllUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns the event monitors before and after the current event monitor in the ordered set where userId = &#63;.
	 *
	 * @param eventMonitorId the primary key of the current event monitor
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event monitor
	 * @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 */
	public EventMonitor[] findByAllUserId_PrevAndNext(
			long eventMonitorId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
				orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	 * Removes all the event monitors where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByAllUserId(long userId);

	/**
	 * Returns the number of event monitors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching event monitors
	 */
	public int countByAllUserId(long userId);

	/**
	 * Caches the event monitor in the entity cache if it is enabled.
	 *
	 * @param eventMonitor the event monitor
	 */
	public void cacheResult(EventMonitor eventMonitor);

	/**
	 * Caches the event monitors in the entity cache if it is enabled.
	 *
	 * @param eventMonitors the event monitors
	 */
	public void cacheResult(java.util.List<EventMonitor> eventMonitors);

	/**
	 * Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	 *
	 * @param eventMonitorId the primary key for the new event monitor
	 * @return the new event monitor
	 */
	public EventMonitor create(long eventMonitorId);

	/**
	 * Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 */
	public EventMonitor remove(long eventMonitorId)
		throws NoSuchEventMonitorException;

	public EventMonitor updateImpl(EventMonitor eventMonitor);

	/**
	 * Returns the event monitor with the primary key or throws a <code>NoSuchEventMonitorException</code> if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor
	 * @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 */
	public EventMonitor findByPrimaryKey(long eventMonitorId)
		throws NoSuchEventMonitorException;

	/**
	 * Returns the event monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor, or <code>null</code> if a event monitor with the primary key could not be found
	 */
	public EventMonitor fetchByPrimaryKey(long eventMonitorId);

	/**
	 * Returns all the event monitors.
	 *
	 * @return the event monitors
	 */
	public java.util.List<EventMonitor> findAll();

	/**
	 * Returns a range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of event monitors
	 */
	public java.util.List<EventMonitor> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event monitors
	 */
	public java.util.List<EventMonitor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event monitors
	 */
	public java.util.List<EventMonitor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the event monitors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event monitors.
	 *
	 * @return the number of event monitors
	 */
	public int countAll();

}