CREATE TABLE PRODUCTS (
	ID BIGINT PRIMARY KEY,
	name varchar(256),
	PRICE DECIMAL(15,2),
	FREQUENT_RELEASE_POINTS VARCHAR(256), -- NEW_RELEASE, REGULAR_FREQUENCY, INFREQUENT_RENTAL, SCARSE_RELEASE
	AGE_AUDIENCE VARCHAR(256), -- GENERAL_AUDIENCE, ADULT_CONTENT, CHILDREN
	PRODUCT_TYPE VARCHAR(256), -- MOVIE_STREAMINIG, BOOK_RENTAL_DRM, SONG_RENTAL_DRM
	PRIMARY KEY (id)
);

CREATE TABLE CLIENTS (
	ID BIGINT PRIMARY KEY,
	NAME varchar(256),
	CUSTOMER_CATEGORY  VARCHAR(256), -- NEW, REGULAR, GOLD, PLATINUM
	CUSTOMER_BILLING_TYPE VARCHAR(256), -- PREPAY, BILLING_AT_MATURITY, BAD_PLAYER
	ACCUMULATED_FREQUENCY_POINTS BIGINT
);

create table RENTALS (
	ID BIGINT PRIMARY KEY,
	PURCHISE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRODUCT_ID BIGINT NOT NULL,
	quantity DECIMAL(15,2),
	DAYS DECIMAL(15, 2),
	FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCTS(ID)
);


CREATE TABLE CLIENT_RENTAL (
	ID BIGINT PRIMARY KEY,
	CLIENT_ID BIGINT NOT NULL,
	RENTAL_ID BIGINT NOT NULL,
	FOREIGN KEY(CLIENT_ID) REFERENCES CLIENTS(ID),
	FOREIGN KEY(RENTAL_ID) REFERENCES RENTALS(ID)
);


insert into products values(1, 'Strumph' , 10,  'INFREQUENT_RENTAL', 'CHILDREN', 'MOVIE_STREAMINIG');
insert into products values(2, 'Toy Story' , 10,  'REGULAR_FREQUENCY', 'CHILDREN', 'MOVIE_STREAMINIG');
insert into products values(3, 'Descpicable Me 3' , 10,  'NEW_RELEASE', 'CHILDREN', 'MOVIE_STREAMINIG');

insert into products values(4, 'Robin hood' , 7,  'REGULAR_FREQUENCY', 'GENERAL_AUDIENCE', 'MOVIE_STREAMINIG');
insert into products values(5, 'Logan 2017' , 3,  'NEW_RELEASE', 'GENERAL_AUDIENCE', 'MOVIE_STREAMINIG');

insert into products values(6, 'Alice in Wonderland' , 2,  'REGULAR_FREQUENCEY', 'SCARCE_RELEASES', 'BOOK_RENTAL_DRM');
insert into products values(7, 'Little Red Riding Hood ' , 2,  'REGULAR_FREQUENCEY', 'ADULT_CONTENT', 'BOOK_RENTAL_DRM');

insert into products values(8, 'The One - Metalica' , 7,  'REGULAR_FREQUENCY', 'GENERAL_AUDIENCE', 'SONG_RENTAL_DRM');
insert into products values(9, 'Logan 2017' , 3,  'NEW_RELEASE', 'ADULT_CONTENT', 'MOVIE_STREAMINIG');

insert into products values(10, 'Walking Dead' , 3,  'INFREQUENT_RENTAL', 'ADULT_CONTECT', 'MOVIE_STREAMINIG');
insert into products values(11, 'Game of Thromes' , 3,  'NEW_RELEASE', 'ADULT_CONTECT', 'MOVIE_STREAMINIG');

insert into clients values(1, 'Silviu Ionel', 'REGULAR', 'PREPAID', 0);

insert into rentals values(1, PARSEDATETIME ('31-05-13 11:34:24','dd-MM-yy hh:mm:ss'), 1, 2, 1);
insert into rentals values(2, PARSEDATETIME ('31-05-13 12:34:24','dd-MM-yy hh:mm:ss'), 2, 2, 1);
insert into rentals values(3, PARSEDATETIME ('31-05-13 11:34:24','dd-MM-yy hh:mm:ss'), 4, 2, 1);
insert into rentals values(4, PARSEDATETIME ('31-05-13 14:34:24','dd-MM-yy hh:mm:ss'), 8, 2, 1);

insert into client_rental values (1, 1, 1);
insert into client_rental values (3, 1, 2);
insert into client_rental values (2, 1, 3);

