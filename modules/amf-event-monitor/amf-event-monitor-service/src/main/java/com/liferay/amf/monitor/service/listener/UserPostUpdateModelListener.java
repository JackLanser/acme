package com.liferay.amf.monitor.service.listener;



import com.liferay.amf.monitor.service.eventMonitorService;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = ModelListener.class
)
public class UserPostUpdateModelListener extends BaseModelListener<User> {

		@Override
		public void onAfterCreate(User model) {
			_eventMonitorService.addeventMonitor(model.getUserId(),"Registration");
		}
		@Reference
		protected eventMonitorService _eventMonitorService;
}

