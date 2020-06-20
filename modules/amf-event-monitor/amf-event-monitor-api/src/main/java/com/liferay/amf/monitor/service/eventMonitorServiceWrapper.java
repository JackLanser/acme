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
 * Provides a wrapper for {@link eventMonitorService}.
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorService
 * @generated
 */
public class eventMonitorServiceWrapper
	implements eventMonitorService, ServiceWrapper<eventMonitorService> {

	public eventMonitorServiceWrapper(eventMonitorService eventMonitorService) {
		_eventMonitorService = eventMonitorService;
	}

	@Override
	public com.liferay.amf.monitor.model.eventMonitor addeventMonitor(
		long userId, String eventType) {

		return _eventMonitorService.addeventMonitor(userId, eventType);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor> findAll(
			int start, int end)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _eventMonitorService.findAll(start, end);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
		findByEventType(String eventType) {

		return _eventMonitorService.findByEventType(eventType);
	}

	@Override
	public java.util.List<com.liferay.amf.monitor.model.eventMonitor>
			findByEventType(String eventType, int start, int end)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _eventMonitorService.findByEventType(eventType, start, end);
	}

	@Override
	public long getEventMonitorsCountByEventType(String eventType)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _eventMonitorService.getEventMonitorsCountByEventType(eventType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventMonitorService.getOSGiServiceIdentifier();
	}

	@Override
	public eventMonitorService getWrappedService() {
		return _eventMonitorService;
	}

	@Override
	public void setWrappedService(eventMonitorService eventMonitorService) {
		_eventMonitorService = eventMonitorService;
	}

	private eventMonitorService _eventMonitorService;

}