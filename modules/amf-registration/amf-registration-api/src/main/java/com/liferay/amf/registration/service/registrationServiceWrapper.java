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

package com.liferay.amf.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link registrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see registrationService
 * @generated
 */
public class registrationServiceWrapper
	implements registrationService, ServiceWrapper<registrationService> {

	public registrationServiceWrapper(registrationService registrationService) {
		_registrationService = registrationService;
	}

	@Override
	public void addUser(
			String firstName, String lastName, String email, String userName,
			boolean male, int bMonth, int bDay, int bYear, String password1,
			String password2, String homePhone, String mobilePhone,
			String address1, String address2, String city, String zip,
			String securityQuestion, String securityAnswer, boolean acceptedTou,
			String regionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_registrationService.addUser(
			firstName, lastName, email, userName, male, bMonth, bDay, bYear,
			password1, password2, homePhone, mobilePhone, address1, address2,
			city, zip, securityQuestion, securityAnswer, acceptedTou, regionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationService.getOSGiServiceIdentifier();
	}

	@Override
	public registrationService getWrappedService() {
		return _registrationService;
	}

	@Override
	public void setWrappedService(registrationService registrationService) {
		_registrationService = registrationService;
	}

	private registrationService _registrationService;

}