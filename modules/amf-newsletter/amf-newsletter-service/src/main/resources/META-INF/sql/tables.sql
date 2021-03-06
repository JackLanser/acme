create table NewsLetter_Article (
	articleId LONG not null primary key,
	issueNumber INTEGER,
	title VARCHAR(75) null,
	author VARCHAR(75) null,
	order_ INTEGER,
	content VARCHAR(75) null
);

create table NewsLetter_Issue (
	issueNumber INTEGER,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	issueDate DATE null,
	byline VARCHAR(75) null,
	issueId LONG not null primary key
);