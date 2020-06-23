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

package com.liferay.amf.monitor.service.impl;

import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.amf.monitor.service.base.eventMonitorServiceBaseImpl;
import com.liferay.amf.monitor.service.permissions.EventMonitorPermissionCheck;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.security.auth.PrincipalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the event monitor remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.monitor.service.eventMonitorService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eventMonitorServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=amfeventmonitor",
		"json.web.service.context.path=eventMonitor"
	},
	service = AopService.class
)
public class eventMonitorServiceImpl extends eventMonitorServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.amf.monitor.service.eventMonitorServiceUtil</code> to access the event monitor remote service.
	 */
	private String actionId = "VIEW_ALL";

	public eventMonitor addeventMonitor(long userId, String eventType) {
		return eventMonitorLocalService.addeventMonitor(userId, eventType);
	}

	public List<eventMonitor> findByEventType(String eventType) {
		return eventMonitorLocalService.findByEventType(eventType);
	}

	public List<eventMonitor> findByEventType(
			String eventType, int start, int end)
		throws PrincipalException {

		if (_eventMonitorPermissionCheck.contains(
				getPermissionChecker(), actionId)) {

			return eventMonitorLocalService.findByEventType(
				eventType, start, end);
		}

		else

		return eventMonitorLocalService.findByUserId(getUserId(), eventType);
	}

	public List<eventMonitor> findAll(int start, int end)
		throws PrincipalException {

		if (_eventMonitorPermissionCheck.contains(
				getPermissionChecker(), actionId)) {

			return eventMonitorLocalService.findAll(start, end);
		}
		else

		return eventMonitorLocalService.findByAllUserId(getUserId());
	}

	public long getEventMonitorsCountByEventType(String eventType)
		throws PrincipalException {

		if (_eventMonitorPermissionCheck.contains(
				getPermissionChecker(), actionId)) {

			return eventMonitorLocalService.countByEventType(eventType);
		}
		else

		return eventMonitorLocalService.countByUserId(getUserId(), eventType);
	}

	@Reference
	private EventMonitorPermissionCheck _eventMonitorPermissionCheck;

}