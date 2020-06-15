create table AmfEventMonitor_eventMonitor (
	eventMonitorId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	userIP VARCHAR(75) null,
	eventType VARCHAR(75) null
);