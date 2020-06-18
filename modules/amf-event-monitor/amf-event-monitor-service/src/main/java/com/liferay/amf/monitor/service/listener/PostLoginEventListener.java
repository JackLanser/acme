package com.liferay.amf.monitor.service.listener;

import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.amf.monitor.service.eventMonitorService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
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
		try {
			User user = _userService.getCurrentUser();
			eventMonitor event = _eventMonitorService.addeventMonitor(user.getUserId(), "Login");
		} catch (PortalException e) {
			e.printStackTrace();
		}
		}	
	
	
	@Reference
	protected UserService _userService;
	
	@Reference
	protected eventMonitorService _eventMonitorService;
}
