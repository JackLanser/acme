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

package com.liferay.amf.monitor.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link eventMonitorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorLocalService
 * @generated
 */
public class eventMonitorLocalServiceWrapper
	implements eventMonitorLocalService,
			   ServiceWrapper<eventMonitorLocalService> {

	public eventMonitorLocalServiceWrapper(
		eventMonitorLocalService eventMonitorLocalService) {

		_eventMonitorLocalService = eventMonitorLocalService;
	}

	/**
	 * Adds the event monitor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitor the event monitor
	 * @return the event monitor that was added
	 */
	@Override
	public com.liferay.amf.monitor.model.eventMonitor addeventMonitor(
		com.liferay.amf.monitor.model.eventMonitor eventMonitor) {

		return _eventMonitorLocalService.addeventMonitor(eventMonitor);
	}

	@Override
	public com.liferay.amf.monitor.model.eventMonitor addeventMonitor(
		long userId, String eventType) {

		return _eventMonitorLocalService.addeventMonitor(userId, eventType);
	}

	@Override
	public int countByEventType(String eventType) {
		return _eventMonitorLocalService.countByEventType(eventType);
	}

	@Override
	public int countByUserId(long userId, String eventType) {
		return _eventMonitorLocalService.countByUserId(userId, eventType);
	}

	/**
	 * Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	 *
	 * @param eventMonitorId the primary key for the new event monitor
	 * @return the new event monitor
	 */
	@Override
	public com.liferay.amf.monitor.model.eventMonitor createeventMonitor(
		long eventMonitorId) {

		return _eventMonitorLocalService.createeventMonitor(eventMonitorId);
	}

	/**
	 * Deletes the event monitor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitor the event monitor
	 * @return the event monitor that was removed
	 */
	@Override
	public com.liferay.amf.monitor.model.eventMonitor deleteeventMonitor(
		com.liferay.amf.monitor.model.eventMonitor eventMonitor) {

		return _eventMonitorLocalService.deleteeventMonitor(eventMonitor);
	}

	/**
	 * Deletes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws PortalException if a event monitor with the primary key could not be found
	 */
	@Override
	public com.liferay.amf.monitor.model.eventMonitor deleteeventMonitor(
			long eventMonitorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventMonitorLocalService.deleteeventMonitor(eventMonitorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventMonitorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventMonitorLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _eventMonitorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.monitor.model.impl.eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _eventMonitorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.monitor.model.impl.eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _eventMonitorLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _eventMonitorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _eventMonitorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.amf.monitor.model.eventMonitor fetcheventMonitor(
		long eventMonitorId) {

		return _eventMonitorLocalService.fetcheventMonitor(eventMonitorId);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor> findAll(
		int start, int end) {

		return _eventMonitorLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByAllUserId(long userId) {

		return _eventMonitorLocalService.findByAllUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(String eventType) {

		return _eventMonitorLocalService.findByEventType(eventType);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(String eventType, int start, int end) {

		return _eventMonitorLocalService.findByEventType(eventType, start, end);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(
			String eventType, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.amf.monitor.model.eventMonitor>
					orderByComparator) {

		return _eventMonitorLocalService.findByEventType(
			eventType, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByUserId(long userId, String eventType) {

		return _eventMonitorLocalService.findByUserId(userId, eventType);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByUserId(long userId, String eventType, int start, int end) {

		return _eventMonitorLocalService.findByUserId(
			userId, eventType, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventMonitorLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the event monitor with the primary key.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor
	 * @throws PortalException if a event monitor with the primary key could not be found
	 */
	@Override
	public com.liferay.amf.monitor.model.eventMonitor geteventMonitor(
			long eventMonitorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventMonitorLocalService.geteventMonitor(eventMonitorId);
	}

	/**
	 * Returns a range of all the event monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.monitor.model.impl.eventMonitorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event monitors
	 * @param end the upper bound of the range of event monitors (not inclusive)
	 * @return the range of event monitors
	 */
	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		geteventMonitors(int start, int end) {

		return _eventMonitorLocalService.geteventMonitors(start, end);
	}

	/**
	 * Returns the number of event monitors.
	 *
	 * @return the number of event monitors
	 */
	@Override
	public int geteventMonitorsCount() {
		return _eventMonitorLocalService.geteventMonitorsCount();
	}

	@Override
	public long getEventMonitorsCountByEventType(String eventType) {
		return _eventMonitorLocalService.getEventMonitorsCountByEventType(
			eventType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventMonitorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventMonitorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventMonitorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the event monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitor the event monitor
	 * @return the event monitor that was updated
	 */
	@Override
	public com.liferay.amf.monitor.model.eventMonitor updateeventMonitor(
		com.liferay.amf.monitor.model.eventMonitor eventMonitor) {

		return _eventMonitorLocalService.updateeventMonitor(eventMonitor);
	}

	@Override
	public eventMonitorLocalService getWrappedService() {
		return _eventMonitorLocalService;
	}

	@Override
	public void setWrappedService(
		eventMonitorLocalService eventMonitorLocalService) {

		_eventMonitorLocalService = eventMonitorLocalService;
	}

	private eventMonitorLocalService _eventMonitorLocalService;

}