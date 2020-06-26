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

package com.liferay.amf.search.util.validator;

import com.liferay.amf.search.exception.ZipcodeValidationException;
import com.liferay.amf.search.validator.ZipcodeValidator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(immediate = true, service = ZipcodeValidator.class)
public class ZipcodeValidatorImpl implements ZipcodeValidator {

	@Override
	public void validate(String zipCode) throws ZipcodeValidationException {
		List<String> errors = new ArrayList<>();

		if (!zipCodeValid(zipCode, errors)) {
			throw new ZipcodeValidationException(errors);
		}
	}

	public boolean zipCodeValid(String zipCode, List<String> errors) {
		if (!Validator.isNumber(zipCode)) {
			errors.add("zipCodeNaN");
		}

		if (zipCode.length() != _zipLength) {
			errors.add("zipCodeLength");
		}

		if (!errors.isEmpty())

			return false;
			else

			return true;
	}

	private int _zipLength = 5;

}