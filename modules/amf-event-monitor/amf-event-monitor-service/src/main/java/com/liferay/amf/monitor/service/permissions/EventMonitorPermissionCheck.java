package com.liferay.amf.monitor.service.permissions;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
    service= EventMonitorPermissionCheck.class
)
public class EventMonitorPermissionCheck{

	public boolean contains(PermissionChecker permissionChecker, String modelclassname, String actionId){
		return permissionChecker.hasPermission(0, modelclassname, 0, actionId);
	}

}
