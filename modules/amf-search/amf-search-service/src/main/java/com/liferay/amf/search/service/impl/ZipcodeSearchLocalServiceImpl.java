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

package com.liferay.amf.search.service.impl;

import com.liferay.amf.search.service.base.ZipcodeSearchLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the zipcode search local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.search.service.ZipcodeSearchLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZipcodeSearchLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.search.model.ZipcodeSearch",
	service = AopService.class
)
public class ZipcodeSearchLocalServiceImpl
	extends ZipcodeSearchLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.amf.search.service.ZipcodeSearchLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.amf.search.service.ZipcodeSearchLocalServiceUtil</code>.
	 */
	
	public List<User> findUserByZip(String zip) {
	    try {

	        DynamicQuery addressQuery = DynamicQueryFactoryUtil.forClass(Address.class)
	            .add(RestrictionsFactoryUtil.eq("zip", zip))
	       		.setProjection(ProjectionFactoryUtil.property("userId"));
	            
	        DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(User.class)
	            .add(PropertyFactoryUtil.forName("userId").in(addressQuery));

	        List<User> users = userLocalService.dynamicQuery(userQuery);

	        return users;
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
		
		return null;
	}

}