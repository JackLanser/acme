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
import com.liferay.amf.registration.validator.RegistrationValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
			String zip, String securityQuestion, String securityAnswer, boolean acceptedTou, String regionId) throws PortalException {
		
			Region region = RegionServiceUtil.fetchRegion(19, regionId);
			
			_registrationValidator.validate(firstName, lastName, email, userName, male, bMonth, bDay, bYear, password1,
					password2, homePhone, mobilePhone, address1, address2, city, zip, securityQuestion, securityAnswer, 
					acceptedTou);
			User user = userLocalService.addUser(0, 20101, false, password1, password2, false, userName, email, 01, "", 
					new Locale.Builder().setLanguage("en").setRegion("US").build(), firstName, "", lastName, 01, 01, male, bMonth, bDay, 
					bYear, "", new long[0], new long[0], new long[0], new long[0], false, new ServiceContext());
				
			userLocalService.updateAgreedToTermsOfUse(user.getUserId(), acceptedTou);
		
			userLocalService.updateReminderQuery(user.getUserId(), securityQuestion, securityAnswer);
			
			if(!homePhone.equals("")) {
				phoneLocalService.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(), homePhone, "", 11011, false, new ServiceContext());
			}
			
			if(!mobilePhone.equals("")) {
			phoneLocalService.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(), mobilePhone, "", 11008, true, new ServiceContext());
			}
			
			addressLocalService.addAddress(user.getUserId(), "", 0, address1, address2, "", city, zip, 
					region.getRegionId(), 19, 11001, false, false, new ServiceContext());
			
	}
	
	@Reference
	RegistrationValidator _registrationValidator;
	
	
}