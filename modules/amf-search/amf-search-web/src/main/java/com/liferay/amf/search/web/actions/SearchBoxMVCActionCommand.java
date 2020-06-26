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

package com.liferay.amf.search.web.actions;

import com.liferay.amf.search.exception.ZipcodeValidationException;
import com.liferay.amf.search.validator.ZipcodeValidator;
import com.liferay.amf.search.web.constants.MVCCommandNames;
import com.liferay.amf.search.web.constants.SearchBoxPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SearchBoxPortletKeys.SEARCHBOX,
		"mvc.command.name=" + MVCCommandNames.SUBMIT_ZIP
	},
	service = MVCActionCommand.class
)
public class SearchBoxMVCActionCommand extends BaseMVCActionCommand {

	@ProcessAction(name = "producer")
	public void producer(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws ZipcodeValidationException {

		String zip = ParamUtil.getString(actionRequest, "zipCode");

		_zipCodeValidator.validate(zip);

		QName qName = new QName("http://zipcode.com", "producemessage");

		actionResponse.setEvent(qName, zip);
	}

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			producer(actionRequest, actionResponse);
		}
		catch (ZipcodeValidationException zve) {
			List<String> errors = zve.getErrors();

			errors.forEach(key -> SessionErrors.add(actionRequest, key));
		}
	}

	@Reference
	private ZipcodeValidator _zipCodeValidator;

}