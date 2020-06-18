package com.liferay.amf.eventmonitor.web.portlet.action;

import com.liferay.amf.eventmonitor.web.constants.EventMonitorPortletKeys;
import com.liferay.amf.eventmonitor.web.constants.MVCCommandNames;
import com.liferay.amf.monitor.model.eventMonitor;
import com.liferay.amf.monitor.service.eventMonitorService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for showing the assignments list.
 * 
 * @author liferay
 */


@Component(
    immediate = true, 
    property = {
        "javax.portlet.name=" + EventMonitorPortletKeys.EVENTMONITOR, 
        "mvc.command.name=/",
        "mvc.command.name=" + MVCCommandNames.LOGIN_VIEW
    }, 
    service = MVCRenderCommand.class
)
public class LoginViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {

		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		String curTab = ParamUtil.getString(renderRequest, "tab");
		
		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("mvcRenderCommandName", MVCCommandNames.LOGIN_VIEW);
		iteratorURL.setParameter("tab", curTab);
		renderRequest.setAttribute("iteratorURL", iteratorURL);
		
		List<eventMonitor> events;
		if(curTab.equals("All")) {
			events =_eventMonitorService.findAll(start, end);
			renderRequest.setAttribute("eventList", events);
			long count = _eventMonitorService.getEventMonitorsCountByEventType("Login") + 
					_eventMonitorService.getEventMonitorsCountByEventType("registration");
			renderRequest.setAttribute("eventCount", count);
		}
		else{
			events =_eventMonitorService.findByEventType(curTab, start, end);
			renderRequest.setAttribute("eventList", events);
			long count = _eventMonitorService.getEventMonitorsCountByEventType(curTab);
			renderRequest.setAttribute("eventCount", count);
		}
		
		
    	return "/view.jsp";
    }
   


    @Reference
    private Portal _portal;
    
    @Reference
    private eventMonitorService _eventMonitorService;
}
