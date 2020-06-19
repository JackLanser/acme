create index IX_BAA75ED9 on AmfEventMonitor_eventMonitor (eventType[$COLUMN_LENGTH:75$]);
create index IX_E552795F on AmfEventMonitor_eventMonitor (userId, eventType[$COLUMN_LENGTH:75$]);