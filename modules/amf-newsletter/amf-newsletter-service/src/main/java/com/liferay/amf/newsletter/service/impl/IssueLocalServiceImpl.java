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

package com.liferay.amf.newsletter.service.impl;

import com.liferay.amf.newsletter.model.Issue;
import com.liferay.amf.newsletter.service.base.IssueLocalServiceBaseImpl;
import com.liferay.amf.newsletter.service.persistence.IssuePersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.sql.Date;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the issue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.newsletter.service.IssueLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssueLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.newsletter.model.Issue",
	service = AopService.class
)
public class IssueLocalServiceImpl extends IssueLocalServiceBaseImpl {

	public void addIssue(String xmlString, long primaryKey) {
		try {
			Issue issue = generateIssue(xmlString, primaryKey);

			super.addIssue(issue);
		}
		catch (DocumentException e) {
			System.out.println("Error adding issue");
			e.printStackTrace();
		}
	}

	public Issue deleteIssue(long primaryKey) throws PortalException {
		Issue issue = fetchByIssueId(primaryKey);

		if (issue == null)

			return null;

		return super.deleteIssue(issue);
	}

	public Issue fetchByIssueId(long primaryKey) {
		return _issuePersistence.fetchByPrimaryKey(primaryKey);
	}

	public List<Issue> findAllIssues() {
		return _issuePersistence.findAll();
	}

	public Issue generateIssue(String xmlString, long primaryKey)
		throws DocumentException {

		Document content = loadXMLFromTitle(xmlString);

		Node issueNumber = content.selectSingleNode(
			"/root/dynamic-element[@name='IssueNumber']/dynamic-content");
		Node issueTitle = content.selectSingleNode(
			"/root/dynamic-element[@name='IssueTitle']/dynamic-content");
		Node description = content.selectSingleNode(
			"/root/dynamic-element[@name='Description']/dynamic-content");
		Node issueDate = content.selectSingleNode(
			"/root/dynamic-element[@name='IssueDate']/dynamic-content");

		Issue issue = createIssue(primaryKey);

		issue.setIssueNumber(Integer.valueOf(issueNumber.getText()));
		issue.setTitle(issueTitle.getText());
		issue.setDescription(description.getText());
		issue.setIssueDate(Date.valueOf(issueDate.getText()));

		return issue;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.amf.newsletter.service.IssueLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.amf.newsletter.service.IssueLocalServiceUtil</code>.
	 */
	public void handleIssueEvents(String xmlString, long primaryKey) {
		Issue issue = fetchByIssueId(primaryKey);

		if (issue == null) {
			addIssue(xmlString, primaryKey);
		}
		else {
			updateIssue(xmlString, primaryKey);
		}
	}

	public Document loadXMLFromTitle(String title) throws DocumentException {
		return SAXReaderUtil.read(title);
	}

	public void updateIssue(String xmlString, long primaryKey) {
		try {
			Issue issue = fetchByIssueId(primaryKey);

			updateIssueValues(issue, xmlString);

			super.updateIssue(issue);
		}
		catch (DocumentException e) {
			System.out.println("Error updating issue");
			e.printStackTrace();
		}
	}

	public void updateIssueValues(Issue issue, String xmlString)
		throws DocumentException {

		Document content = loadXMLFromTitle(xmlString);

		Node issueNumber = content.selectSingleNode(
			"/root/dynamic-element[@name='IssueNumber']/dynamic-content");
		Node issueTitle = content.selectSingleNode(
			"/root/dynamic-element[@name='IssueTitle']/dynamic-content");
		Node description = content.selectSingleNode(
			"/root/dynamic-element[@name='Description']/dynamic-content");
		Node issueDate = content.selectSingleNode(
			"/root/dynamic-element[@name='IssueDate']/dynamic-content");

		issue.setIssueNumber(Integer.valueOf(issueNumber.getText()));
		issue.setTitle(issueTitle.getText());
		issue.setDescription(description.getText());
		issue.setIssueDate(Date.valueOf(issueDate.getText()));
	}

	@Reference
	private IssuePersistence _issuePersistence;

}