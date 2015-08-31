CREATE DATABASE propertyportal;
-- SET FOREIGN_KEY_CHECKS=0;
use propertyportal;
-- DROP DATABASE propertyportal;

-- drop table StatusMast
create table StatusMast (
  id bigint,
  name varchar(50),
  target varchar(50),
  constraint pk7 primary key(id)
);

-- insert into StatusMast values('1','Active','USER');
-- insert into StatusMast values('2','InActive','USER');

-- drop table UserType
create table UserType (
  id bigint,
  name varchar(50),
  shortName varchar(50),
  constraint pk8 primary key(id)
);
-- -- ALTER TABLE UserType ADD shortName VARCHAR(60) AFTER name;

-- insert into UserType values('1','Individuals Property Owners', 'Owner ');
-- insert into UserType values('2','Brokers, Agents and Consultants', 'Agent ');
-- insert into UserType values('3','Builders', 'Builder');

-- drop table Country;
create table Country (
  id bigint auto_increment,
  name varchar(25),
  constraint pk1 primary key(id)
);
-- insert into Country (name) values('India');

-- drop table State;
create table State (
  id bigint auto_increment,
  name varchar(25),
  countryId bigint,
  constraint pk2 primary key(id),
  constraint fk1 foreign key (countryId) references Country(id)
);
insert into State (name, countryId) values ('Andhra Pradesh', 1);
insert into State (name, countryId) values ('Arunachal Pradesh', 1);
insert into State (name, countryId) values ('Assam', 1);
insert into State (name, countryId) values ('Bihar', 1);
insert into State (name, countryId) values ('Chhattisgarh', 1);
insert into State (name, countryId) values ('Goa', 1);
insert into State (name, countryId) values ('Gujarat', 1);
insert into State (name, countryId) values ('Haryana', 1);
insert into State (name, countryId) values ('Himachal Pradesh', 1);
insert into State (name, countryId) values ('Jammu and Kashmir', 1);
insert into State (name, countryId) values ('Jharkhand', 1);
insert into State (name, countryId) values ('Karnataka', 1);
insert into State (name, countryId) values ('Kerala', 1);
insert into State (name, countryId) values ('Madhya Pradesh', 1);
insert into State (name, countryId) values ('Maharashtra', 1);
insert into State (name, countryId) values ('Manipur', 1);
insert into State (name, countryId) values ('Meghalaya', 1);
insert into State (name, countryId) values ('Mizoram', 1);
insert into State (name, countryId) values ('Nagaland', 1);
insert into State (name, countryId) values ('Orissa', 1);
insert into State (name, countryId) values ('Punjab', 1);
insert into State (name, countryId) values ('Rajasthan', 1);
insert into State (name, countryId) values ('Sikkim', 1);
insert into State (name, countryId) values ('Tamil Nadu', 1);
insert into State (name, countryId) values ('Telangana', 1);
insert into State (name, countryId) values ('Tripura', 1);
insert into State (name, countryId) values ('Uttar Pradesh', 1);
insert into State (name, countryId) values ('Uttarakhand', 1);
insert into State (name, countryId) values ('West Bengal', 1);


-- drop table City;
create table City (
  id bigint auto_increment,
  name varchar(25),
  stateId bigint,
  isPopular boolean,
  constraint pk3 primary key(id),
  constraint fk2 foreign key (stateId) references State(id)
);
-- -- ALTER TABLE City ADD isPopular boolean;

-- drop table Locations;
create table Locations (
  id bigint auto_increment,
  name varchar(25),
  cityId bigint,
  constraint pk4 primary key(id),
  constraint fk3 foreign key (cityId) references City(id)
);

-- drop table AdminLogin
create table AdminLogin (
  id bigint auto_increment,
  firstName varchar(25),
  designation varchar(25),
  mailId varchar(25),
  phoneNumber varchar(20),
  DOJ datetime,
  DOR datetime,
  statusId bigint,
  userName varchar(25),
  password varchar(25),
  constraint pk5 primary key(id),
  constraint fk4 foreign key (statusId) references StatusMast(id)
);

-- drop table PlanMast
create table PlanMast (
  id bigint auto_increment,
  name varchar(50),
  cost float,
  numberOfImages int,
  userTypeId bigint,
  description varchar(500),
  validDays numeric(4),
  createdDate datetime,
  constraint pk6 primary key(id),
  constraint fk5 foreign key (userTypeId) references UserType(id)
);

-- drop table PropertyUser
create table PropertyUser (
  id bigint auto_increment,
  userTypeId bigint,
  firstName varchar(50),
  emailId varchar(25),
  cityId bigint,
  phone varchar(25),
  mobileNo varchar(25),
  isMailVerified varchar(2),
  passwrd varchar(25),
  status varchar(1),
  constraint pk7 primary key(id),
  constraint fk6 foreign key (userTypeId) references UserType(id),
  constraint fk7 foreign key (cityId) references City(id)
);

create table PropertyMainType (
  id bigint auto_increment,
  name varchar(25),
  constraint pk8 primary key(id)
);

-- insert into PropertyMainType (name) values('RESIDENTIAL');
-- insert into PropertyMainType (name) values('COMMERCIAL');
-- insert into PropertyMainType (name) values('OTHERS');

create table PropertyType (
  id bigint auto_increment,
  name varchar(25),
  propertyMainTypeId bigint,
  constraint pk9 primary key(id),
  constraint fk8 foreign key (propertyMainTypeId) references PropertyMainType(id)
);

-- insert into PropertyType (name, propertyMainTypeId) values('Flat', 1);
-- insert into PropertyType (name, propertyMainTypeId) values('House/Villa', 1);
-- insert into PropertyType (name, propertyMainTypeId) values('Plot', 1);

-- insert into PropertyType (name, propertyMainTypeId) values('Office Space', 2);
-- insert into PropertyType (name, propertyMainTypeId) values('Shop/Showroom', 2);
-- insert into PropertyType (name, propertyMainTypeId) values('Commercial Land', 2);
-- insert into PropertyType (name, propertyMainTypeId) values('Warehouse/ Godown', 2);
-- insert into PropertyType (name, propertyMainTypeId) values('Industrial Building', 2);
-- insert into PropertyType (name, propertyMainTypeId) values('Industrial Shed', 2);

-- insert into PropertyType (name, propertyMainTypeId) values('Agricultural Land', 3);
-- insert into PropertyType (name, propertyMainTypeId) values('Farm House', 3);


create table Budget (
  id bigint auto_increment,
  name varchar(25),
  fromlevel bigint,
  tolevel bigint,
  currencyVal varchar(25),
  constraint pk10 primary key(id)
);

insert into Budget (name, fromlevel, tolevel, currencyVal) values ('Below 5 Lac', 0, 500000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('5 - 10 Lac',500001,1000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('10 - 20 Lac',1000001,2000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('20 - 30 Lac',2000001,3000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('30 - 40 Lac',3000001,4000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('40 - 50 Lac',4000001,5000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('50 - 60 Lac',5000001,6000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('60 - 70 Lac',6000001,7000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('70 - 80 Lac',7000001,8000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('80 - 90 Lac',8000001,9000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('90 - 1 Cr',9000001,10000000,'INR');

insert into Budget (name, fromlevel, tolevel, currencyVal) values ('1 - 1.2 Cr',10000001,12000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('1.2 - 1.4 Cr',12000001,14000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('1.4 - 1.6 Cr',14000001,16000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('1.6 - 1.8 Cr',16000001,18000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('1.8 - 2 Cr',18000001,20000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('2 - 2.2 Cr',20000001,22000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('2.2 - 2.4 Cr',22000001,24000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('2.4 - 2.6 Cr',24000001,26000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('2.6 - 2.8 Cr',26000001,28000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('2.8 - 3 Cr',28000001,30000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('3 - 3.2 Cr',30000001,32000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('3.2 - 3.4 Cr',32000001,34000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('3.4 - 3.6 Cr',34000001,36000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('3.6 - 3.8 Cr',36000001,38000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('3.8 - 4 Cr',38000001,40000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('4 - 4.2 Cr',40000001,42000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('4.2 - 4.4 Cr',42000001,44000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('4.4 - 4.6 Cr',44000001,46000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('4.6 - 4.8 Cr',46000001,48000000,'INR');
insert into Budget (name, fromlevel, tolevel, currencyVal) values ('4.8 - 5 Cr',48000001,50000000,'INR');
insert into Budget  (name, fromlevel, tolevel, currencyVal) values ('> 5 Cr',50000000,-1,'INR');


create table Bedroom (
  id bigint auto_increment,
  name varchar(25),
  bedrooms bigint,
  constraint pk11 primary key(id)
);

insert into Bedroom (name, bedrooms) values ('1 BHK', 1);
insert into Bedroom (name, bedrooms) values ('2 BHK', 2);
insert into Bedroom (name, bedrooms) values ('3 BHK', 3);
insert into Bedroom (name, bedrooms) values ('4 BHK', 4);
insert into Bedroom (name, bedrooms) values ('5 BHK', 5);
insert into Bedroom (name, bedrooms) values ('6 BHK', 6);
insert into Bedroom (name, bedrooms) values ('7 BHK', 7);
insert into Bedroom (name, bedrooms) values ('>7 BHK', 8);


create table FurnishedStatus (
  id bigint auto_increment,
  name varchar(25),
  constraint pk12 primary key(id)
);

insert into FurnishedStatus (name) values ('Furnished' );
insert into FurnishedStatus (name) values ('Unfurnished' );
insert into FurnishedStatus (name) values ('Semi-Furnished' );



create table PropertyForType (
  id bigint auto_increment,
  nameForPoster varchar(25),
  nameForFinder varchar(25),
  constraint pk13 primary key(id)
);

insert into PropertyForType (nameForPoster, nameForFinder) values('Sell', 'Buy');
insert into PropertyForType (nameForPoster, nameForFinder) values('Rent', 'Rent');
insert into PropertyForType (nameForPoster, nameForFinder) values('PG Accommodation', 'PG Accommodation');
--update PropertyForType set nameForPoster = 'PG Accommodation' , nameForFinder='PG Accommodation'  where id = 3;

create table Bathroom (
  id bigint auto_increment,
  name varchar(25),
  bathrooms bigint,
  constraint pk14 primary key(id)
);

insert into Bathroom (name, bathrooms) values ('1', 1);
insert into Bathroom (name, bathrooms) values ('2', 2);
insert into Bathroom (name, bathrooms) values ('3', 3);
insert into Bathroom (name, bathrooms) values ('4', 4);
insert into Bathroom (name, bathrooms) values ('5', 5);
insert into Bathroom (name, bathrooms) values ('6', 6);
insert into Bathroom (name, bathrooms) values ('7', 7);
insert into Bathroom (name, bathrooms) values ('>7', 8);


create table Balconies (
  id bigint auto_increment,
  name varchar(25),
  balconies bigint,
  constraint pk15 primary key(id)
);
insert into Balconies (name, balconies) values ('1', 1);
insert into Balconies (name, balconies) values ('2', 2);
insert into Balconies (name, balconies) values ('3', 3);
insert into Balconies (name, balconies) values ('4', 4);
insert into Balconies (name, balconies) values ('5', 5);
insert into Balconies (name, balconies) values ('6', 6);
insert into Balconies (name, balconies) values ('7', 7);
insert into Balconies (name, balconies) values ('>7', 8);

create table TotalFloors(
  id bigint auto_increment,
  name varchar(25),
  floors bigint,
  constraint pk16 primary key(id)
);

insert into TotalFloors (name, floors) values ('Lower Basement', -2);
insert into TotalFloors (name, floors) values ('Upper Basement', -1);
insert into TotalFloors (name, floors) values ('Ground', 1);
insert into TotalFloors (name, floors) values ('1', 1);
insert into TotalFloors (name, floors) values ('2', 2);
insert into TotalFloors (name, floors) values ('3', 3);
insert into TotalFloors (name, floors) values ('4', 4);
insert into TotalFloors (name, floors) values ('5', 5);
insert into TotalFloors (name, floors) values ('6', 6);
insert into TotalFloors (name, floors) values ('7', 7);
insert into TotalFloors (name, floors) values ('9', 9);
insert into TotalFloors (name, floors) values ('10', 10);
insert into TotalFloors (name, floors) values ('>10', 11);


create table UnitMaster (
  id bigint auto_increment,
  name varchar(25),
  constraint pk17 primary key(id)
);

insert into UnitMaster (name) values('Sq-ft');
insert into UnitMaster (name) values('Sq-m');
insert into UnitMaster (name) values('Ground');
insert into UnitMaster (name) values('Acre');

create table TransactionType (
  id bigint auto_increment,
  name varchar(25),
  constraint pk18 primary key(id)
);

insert into TransactionType (name) values('New Property');
insert into TransactionType (name) values('Resale');


create table PossessionStatus (
  id bigint auto_increment,
  name varchar(25),
  constraint pk19 primary key(id)
);
insert into PossessionStatus (name) values('Under Construction');
insert into PossessionStatus (name) values('Ready to Move');

create table Terms (
  id bigint auto_increment,
  name varchar(25),
  constraint pk20 primary key(id)
);
insert into Terms (name) values('Monthly');
insert into Terms (name) values('Quartely');
insert into Terms (name) values('Yearly');
insert into Terms (name) values('One-Time');
insert into Terms (name) values('Per sq. Unit Monthly');

---------------------------------------------created on 29 AUG 2015-----------------------------------------------------


create table PropertyOwnershipType (
	id bigint auto_increment,
	name varchar(50),
	constraint pk21 primary key(id)
);

insert into PropertyOwnershipType (name) values('Freehold');
insert into PropertyOwnershipType (name) values('Leasehold');
insert into PropertyOwnershipType (name) values('Co-operative Society');
insert into PropertyOwnershipType (name) values('Power of Attorney');


create table PossessionOrAge (
	id bigint auto_increment,
	name varchar(50),
	type varchar(20),
  constraint pk22 primary key(id)
);
insert into PossessionOrAge (name, type) values('Within 3 Months','POSSESSION');
insert into PossessionOrAge (name, type) values('Within 6 Months','POSSESSION');
insert into PossessionOrAge (name, type) values('By 2016','POSSESSION');
insert into PossessionOrAge (name, type) values('By 2017','POSSESSION');
insert into PossessionOrAge (name, type) values('By 2018','POSSESSION');
insert into PossessionOrAge (name, type) values('By 2019','POSSESSION');
insert into PossessionOrAge (name, type) values('By 2020','POSSESSION');

insert into PossessionOrAge (name, type) values('0-1 Year Old Property','AGE');
insert into PossessionOrAge (name, type) values('1-5 Year Old Property','AGE');
insert into PossessionOrAge (name, type) values('5-10 Year Old Property','AGE');
insert into PossessionOrAge (name, type) values('10+ Year Old Property','AGE');

 create table ImageType (
	id bigint auto_increment,
  name varchar(25),
  constraint pk23 primary key(id)
);

insert into ImageType (name) values('EXTERIOR_VIEW');
insert into ImageType (name) values('BEDROOMS');
insert into ImageType (name) values('BATHROOMS');
insert into ImageType (name) values('KITCHEN');
insert into ImageType (name) values('FLOOR_PLAN');
insert into ImageType (name) values('MASTER_PLAN');
insert into ImageType (name) values('LOCATION_MAP');
insert into ImageType (name) values('OTHERS');

create table FacingMast (
	id bigint auto_increment,
	name varchar(25),
	constraint pk24 primary key(id)
);

insert into FacingMast (name)  values ('East');
insert into FacingMast (name)  values ('West');
insert into FacingMast (name)  values ('North');
insert into FacingMast (name)  values ('South');

create table Advertisement (
	id bigint auto_increment,
 	propertyForTypeId bigint,
	propertyTypeId bigint,
	locationId bigint,
	address varchar(100),
	projectName varchar(100),
	transactionTypeId bigint,
	propertyOwnershipId bigint,
	possessionStatusId bigint,
	possessionOrAgeId bigint,
	description varchar(1000),
	propertyFeatures varchar(1000),
	isTermsAgreed varchar(1),
	constraint pk25 primary key(id),
	constraint fk9 foreign key (propertyForTypeId) references PropertyForType(id),
	constraint fk10 foreign key (propertyTypeId) references PropertyType(id),
	constraint fk11 foreign key (locationId) references Locations(id),
	constraint fk12 foreign key (transactionTypeId) references TransactionType(id),
	constraint fk13 foreign key (propertyOwnershipId) references PropertyOwnershipType(id),
	constraint fk14 foreign key (possessionStatusId) references PossessionStatus(id),
	constraint fk15 foreign key (possessionOrAgeId) references PossessionOrAge(id)
);


 create table AdvertisementDetails (
 	id bigint auto_increment,
 	advertisementId bigint,
 	buildupArea bigint,
	buildupAreaUnitId bigint,
	carpetArea bigint,
	carpetAreaUnitId bigint,
	plotArea bigint,
	plotAreaUnitId bigint,
	balconyId bigint,
	propertyOnFloorId bigint,
	totalFloor bigint,
	facingId bigint,
	rooms bigint,
	washroom bigint,
	expectedPrice bigint,
	constraint pk26 primary key(id),
	constraint fk16 foreign key (advertisementId) references Advertisement(id),
	constraint fk17 foreign key (buildupAreaUnitId) references UnitMaster(id),
  constraint fk18 foreign key (carpetAreaUnitId) references UnitMaster(id),
  constraint fk19 foreign key (plotAreaUnitId) references UnitMaster(id),
  constraint fk20 foreign key (propertyOnFloorId) references TotalFloors(id),
  constraint fk21 foreign key (totalFloor) references TotalFloors(id),
  constraint fk22 foreign key (facingId) references FacingMast(id),
  constraint fk23 foreign key (balconyId) references Balconies(id)
 );

create table Residential (
 	id bigint auto_increment,
 	advertisementId bigint,
	furnishedStatusId bigint,
	maintenanceCharges bigint,
	maintenancePeriodId bigint,
	securityDeposit bigint,
	availableFrom date,
	isFromBrokers varchar(1),
	poojaRoom varchar(1),
	studyRoom varchar(1),
	servantRoom varchar(1),
	bedRoomId bigint,
	bathRoomId bigint,
	constraint pk27 primary key(id),
  constraint fk24 foreign key (advertisementId) references Advertisement(id),
  constraint fk25 foreign key (furnishedStatusId) references FurnishedStatus(id),
  constraint fk26 foreign key (maintenancePeriodId) references Terms(id),
  constraint fk27 foreign key (bedRoomId) references Bedroom(id),
  constraint fk28 foreign key (bathRoomId) references Bathroom(id)
);

create table MorePropertyDetails (
 	id bigint auto_increment,
 	advertisementId bigint,
	bedRoomId bigint,
	area bigint,
	areaAreaUnitId bigint,
	pricePerUnitArea bigint,
	totalCost bigint,
 	floorPlanFileName varchar(200),
	constraint pk28 primary key(id),
  constraint fk29 foreign key (advertisementId) references Advertisement(id),
  constraint fk30 foreign key (bedRoomId) references Bedroom(id),
  constraint fk31 foreign key (areaAreaUnitId) references UnitMaster(id)
);

create table GalleryImages (
	id bigint auto_increment,
	advertisementId bigint,
	imageTypeId bigint,
	imageName varchar(50),
	constraint pk29 primary key(id),
	constraint fk32 foreign key (advertisementId) references Advertisement(id),
	constraint fk33 foreign key (imageTypeId) references ImageType(id)
);

-- ---------------------------------------------------------------------------------------------------------------------
