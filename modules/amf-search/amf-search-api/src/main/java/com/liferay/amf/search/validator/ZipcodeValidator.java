package com.liferay.amf.search.validator;

 import com.liferay.amf.search.exception.ZipcodeValidationException;

 import java.util.Date;
 import java.util.Locale;
 import java.util.Map;

 public interface ZipcodeValidator {

     /**
      * Validates an Assignment
      * 
      * @param titleMap
      * @param descriptionMap
      * @param dueDate
      * @throws AssignmentValidationException
      */
     public void validate(String zipCode) throws ZipcodeValidationException;
 }