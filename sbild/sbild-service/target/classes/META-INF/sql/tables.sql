create table GB_ElectroEmployee (
	emplId LONG not null,
	etypeId LONG not null,
	primary key (emplId, etypeId)
);

create table GB_ElectroType (
	etypeId LONG not null primary key,
	name VARCHAR(75) null
);

create table GB_Electronics (
	electrId LONG not null primary key,
	name VARCHAR(150) null,
	etypeId LONG,
	price LONG,
	count INTEGER,
	inStock BOOLEAN,
	archive BOOLEAN,
	description TEXT null
);

create table GB_Employee (
	emplId LONG not null primary key,
	lastname VARCHAR(75) null,
	firstname VARCHAR(75) null,
	patronymic VARCHAR(75) null,
	birthdate DATE null,
	posId LONG,
	gender BOOLEAN
);

create table GB_EmpltopCnt (
	position VARCHAR(75) null,
	lastname VARCHAR(75) not null primary key,
	count INTEGER
);

create table GB_EmpltopSum (
	position VARCHAR(75) null,
	lastname VARCHAR(75) not null primary key,
	sum LONG
);

create table GB_PositionType (
	posId LONG not null primary key,
	name VARCHAR(75) null
);

create table GB_Purchase (
	purchId LONG not null primary key,
	electrId LONG,
	emplId LONG,
	purchDate DATE null,
	purchtypeId LONG
);

create table GB_PurchaseType (
	purchtypeId LONG not null primary key,
	name VARCHAR(75) null
);