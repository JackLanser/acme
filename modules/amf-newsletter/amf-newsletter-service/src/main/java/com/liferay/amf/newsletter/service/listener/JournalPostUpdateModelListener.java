package com.liferay.amf.newsletter.service.listener;

import com.liferay.amf.newsletter.service.IssueLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, property = {}, service = ModelListener.class)
public class JournalPostUpdateModelListener extends BaseModelListener<JournalArticle>{
	
	@Override
	public void onAfterCreate(JournalArticle model) {
		try {
			Document content = loadXMLFromTitle(model.getContent());
			
			Node author = content.selectSingleNode("/root/dynamic-element[@name='Author']/dynamic-content");
			
			if(author != null) {
				Node issueNumber = content.selectSingleNode("/root/dynamic-element[@name='IssueNumber']/dynamic-content");
				Node issueTitle = content.selectSingleNode("/root/dynamic-element[@name='Title']/dynamic-content");
				Node order = content.selectSingleNode("/root/dynamic-element[@name='Order']/dynamic-content");
				Node textContent = content.selectSingleNode("/root/dynamic-element[@name='Content']/dynamic-content");
				System.out.println(issueNumber.getText() + " " + issueTitle.getText() + " "+ order.getText() + " "+ author.getText() + " " + textContent.getText());
			}
			else {		
				Node issueNumber = content.selectSingleNode("/root/dynamic-element[@name='IssueNumber']/dynamic-content");
				Node issueTitle = content.selectSingleNode("/root/dynamic-element[@name='IssueTitle']/dynamic-content");
				Node description = content.selectSingleNode("/root/dynamic-element[@name='Description']/dynamic-content");
				Node issueDate = content.selectSingleNode("/root/dynamic-element[@name='IssueDate']/dynamic-content");
				_issueLocalService.addIssue(Integer.valueOf(issueNumber.getText()), issueTitle.getText(), 
						description.getText(), issueDate.getText());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Document loadXMLFromTitle(String title) throws DocumentException
	{
	    Document doc = SAXReaderUtil.read(title);
		return doc;
	}
	
	@Reference
	protected IssueLocalService _issueLocalService;

}
