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

package com.liferay.amf.registration.service.impl;

import com.liferay.amf.registration.service.base.registrationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.registration.service.registrationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see registrationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.registration.model.registration",
	service = AopService.class
)
public class registrationLocalServiceImpl
	extends registrationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.amf.registration.service.registrationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.amf.registration.service.registrationLocalServiceUtil</code>.
	 */
	
	public void addUser(String firstName, String lastName, String email, String userName, boolean male, int bMonth, int bDay, int bYear, 
			String password1, String password2, String homePhone, String mobilePhone, String address1, String address2, String city,
			String zip, String securityQuestion, String securityAnswer, boolean acceptedTou, long regionId) throws PortalException {
		
			User user = userLocalService.addUser(0, 0, false, password1, password2, false, userName, email, 0, null, 
					null, firstName, null, lastName, 0, 0, male, bMonth, bDay, 
					bYear, null, null, null, null, null, false, null);
			
			userLocalService.updateAgreedToTermsOfUse(user.getUserId(), acceptedTou);
			
			userLocalService.updateReminderQuery(user.getUserId(), securityQuestion, securityAnswer);
			
			phoneLocalService.addPhone(user.getUserId(), null, 0, homePhone, null, 0, false, null);
			phoneLocalService.addPhone(user.getUserId(), null, 0, mobilePhone, null, 1, false, null);
			
			addressLocalService.addAddress(user.getUserId(), null, 0, address1, address2, null, city, zip, 
					regionId, 19, 0, false, false, null);
			
	}
	
	
}