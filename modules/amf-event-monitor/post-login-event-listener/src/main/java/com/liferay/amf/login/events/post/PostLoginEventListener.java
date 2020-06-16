package com.liferay.amf.login.events.post;

import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.amf.monitor.service.eventMonitorLocalService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.service.UserService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {"key=login.events.post"
		// TODO enter required service properties
	},
	service = LifecycleAction.class
)
public class PostLoginEventListener implements LifecycleAction {
	// TODO enter required service methods
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) 
			throws ActionException {
		//eventMonitor event = _eventMonitorLocalService.addeventMonitor(0, "Login");
		System.out.println(_eventMonitorLocalService);
	}	
	
	
	@Reference
	protected UserService _userService;
	
	@Reference
	protected eventMonitorLocalService _eventMonitorLocalService;
}
