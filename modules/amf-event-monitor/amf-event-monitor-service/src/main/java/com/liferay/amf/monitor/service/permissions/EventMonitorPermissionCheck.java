package com.liferay.amf.monitor.service.permissions;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = EventMonitorPermissionCheck.class)
public class EventMonitorPermissionCheck {

	public boolean contains(
		PermissionChecker permissionChecker, String actionId) {

		return permissionChecker.hasPermission(
			groupId, modelClassName, groupId, actionId);
	}

	private long groupId = 0;
	private String modelClassName = "com.liferay.amf.monitor.model";

}