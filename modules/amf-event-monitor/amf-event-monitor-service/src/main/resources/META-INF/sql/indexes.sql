create index IX_61314DF3 on AmfEventMonitor_EventMonitor (eventType[$COLUMN_LENGTH:75$], userId);
create index IX_82AE4D45 on AmfEventMonitor_EventMonitor (userId);

create index IX_1C28CE13 on AmfEventMonitor_eventMonitor (eventType[$COLUMN_LENGTH:75$], userId);
create index IX_E552795F on AmfEventMonitor_eventMonitor (userId, eventType[$COLUMN_LENGTH:75$]);