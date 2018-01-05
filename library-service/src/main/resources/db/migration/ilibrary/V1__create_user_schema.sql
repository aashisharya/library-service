--  ************** to maintain library details **************

CREATE TABLE weekdays (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  day varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO weekdays(day)
	VALUES('SUNDAY'),
		('MONDAY'),
		('TUESEDAY'),
		('WEDNESDAY'),
		('THURSEDAY'),
		('FRIDAY'),
		('SATERDAY');
							    
CREATE TABLE library_location (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  area varchar(255) DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  country varchar(255) DEFAULT NULL,
  landmark varchar(255) DEFAULT NULL,
  latitude varchar(255) DEFAULT NULL,
  longitude varchar(255) DEFAULT NULL,
  loacation_name varchar(255) NOT NULL,
  state varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE library (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  est_date datetime DEFAULT NULL,
  latitude varchar(255) DEFAULT NULL,
  longitude varchar(255) DEFAULT NULL,
  library_name varchar(255) NOT NULL,
  no_of_books varchar(255) DEFAULT NULL,
  address_id bigint(20) DEFAULT NULL,
  location_id bigint(20) DEFAULT NULL,
  superAdmin_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_dp9h9u02p4e1luu9bnf7kpc29 (library_name),
  KEY FK_qud8iq6fin9ykn2bqgq4k6cin (address_id),
  KEY FK_3y388rg1s6e4p5aea2dj0myfx (location_id),
  KEY FK_3vjn2u0oiccwjadqe88acecfe (superAdmin_id),
  CONSTRAINT FK_3vjn2u0oiccwjadqe88acecfe FOREIGN KEY (superAdmin_id) REFERENCES users_info (id),
  CONSTRAINT FK_3y388rg1s6e4p5aea2dj0myfx FOREIGN KEY (location_id) REFERENCES library_location (id),
  CONSTRAINT FK_qud8iq6fin9ykn2bqgq4k6cin FOREIGN KEY (address_id) REFERENCES address (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE book_status (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

insert into book_status(id,status,description) 
	values(1,'AVAILABLE','available in library or releasing from customer'),
		(2,'NOTAVAILABLE','that book is not in library'),
		(3,'RENTED','in use'),
		(4,'DELIVERED','delivered to booked customer'),
		(5,'PENDINGTRANSACTION','not delivered to booked customer'),
		(6,'PENDINGRETURN','not return back by customer'),
		(7,'RECIEVED','back to library');
					  
CREATE TABLE books_info (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  author varchar(255) DEFAULT NULL,
  book_cover_page varchar(255) DEFAULT NULL,
  book_price double DEFAULT NULL,
  book_rent_value double DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  edition varchar(255) DEFAULT NULL,
  genres varchar(255) DEFAULT NULL,
  image_url varchar(255) DEFAULT NULL,
  isbn_code varchar(255) DEFAULT NULL,
  no_of_pages int(11) DEFAULT NULL,
  publish_date varchar(255) DEFAULT NULL,
  publisher varchar(255) DEFAULT NULL,
  sample_page_url varchar(255) DEFAULT NULL,
  title varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE book_flag (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  flag varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO book_flag(flag) values('OWNER'),('USER'),('AGENT');

CREATE TABLE book_inventory (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  no_of_books_available bigint(20) DEFAULT NULL,
  available_date datetime DEFAULT NULL,
  book_rent_price double NOT NULL,
  book_sale_price double DEFAULT NULL,
  isAvailable char(1) NOT NULL,
  isBuyable char(1) NOT NULL,
  isRental char(1) NOT NULL,
  total_no_of_books bigint(20) DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL,
  library_id bigint(20) DEFAULT NULL,
  owner_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_bv6wwjhn6f4kti1376wkggehl (book_id),
  KEY FK_r0mf6vecqypmr83a6rndjdf6v (library_id),
  KEY FK_5bp66bq1pxk1rmf89ccxyamjf (owner_id),
  CONSTRAINT FK_5bp66bq1pxk1rmf89ccxyamjf FOREIGN KEY (owner_id) REFERENCES users_info (id),
  CONSTRAINT FK_bv6wwjhn6f4kti1376wkggehl FOREIGN KEY (book_id) REFERENCES books_info (id),
  CONSTRAINT FK_r0mf6vecqypmr83a6rndjdf6v FOREIGN KEY (library_id) REFERENCES library (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE book_order (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  delivery_time datetime DEFAULT NULL,
  delivery_type varchar(255) DEFAULT NULL,
  due double NOT NULL,
  order_date datetime DEFAULT NULL,
  paid double NOT NULL,
  total_amount double DEFAULT NULL,
  status_id bigint(20) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_slj0d4qpa2fw94p5e17u0krvl (status_id),
  KEY FK_rr7e6k5prbnaml3rcg7fnfp8x (user_id),
  CONSTRAINT FK_rr7e6k5prbnaml3rcg7fnfp8x FOREIGN KEY (user_id) REFERENCES users_info (id),
  CONSTRAINT FK_slj0d4qpa2fw94p5e17u0krvl FOREIGN KEY (status_id) REFERENCES book_status (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE book_order_line_items (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  book_price double DEFAULT NULL,
  desire_date datetime DEFAULT NULL,
  order_date datetime DEFAULT NULL,
  release_date datetime DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL,
  bookStatus_id bigint(20) DEFAULT NULL,
  customer_id bigint(20) DEFAULT NULL,
  destination_id bigint(20) DEFAULT NULL,
  library_id bigint(20) DEFAULT NULL,
  order_id bigint(20) DEFAULT NULL,
  owner_id bigint(20) DEFAULT NULL,
  source_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_d8syje4lqu07h3cls0138nlde (book_id),
  KEY FK_c2ojpia0owi524lg1g8ghpvc2 (bookStatus_id),
  KEY FK_hckdsohdroc6tclbrdhggpcm8 (customer_id),
  KEY FK_qufrbwdhts703c6qkavsc1pqo (destination_id),
  KEY FK_s7dkqxaei9rjhobfmxw0v2f1g (library_id),
  KEY FK_rxrsvu3ahaon5osx92dp4607f (order_id),
  KEY FK_he3iq19x5ecwwtewj8027fjnc (owner_id),
  KEY FK_b60bpd4h4s3r1x6k9odho2xg2 (source_id),
  CONSTRAINT FK_b60bpd4h4s3r1x6k9odho2xg2 FOREIGN KEY (source_id) REFERENCES address (id),
  CONSTRAINT FK_c2ojpia0owi524lg1g8ghpvc2 FOREIGN KEY (bookStatus_id) REFERENCES book_status (id),
  CONSTRAINT FK_d8syje4lqu07h3cls0138nlde FOREIGN KEY (book_id) REFERENCES books_info (id),
  CONSTRAINT FK_hckdsohdroc6tclbrdhggpcm8 FOREIGN KEY (customer_id) REFERENCES users_info (id),
  CONSTRAINT FK_he3iq19x5ecwwtewj8027fjnc FOREIGN KEY (owner_id) REFERENCES users_info (id),
  CONSTRAINT FK_qufrbwdhts703c6qkavsc1pqo FOREIGN KEY (destination_id) REFERENCES address (id),
  CONSTRAINT FK_rxrsvu3ahaon5osx92dp4607f FOREIGN KEY (order_id) REFERENCES book_order (id),
  CONSTRAINT FK_s7dkqxaei9rjhobfmxw0v2f1g FOREIGN KEY (library_id) REFERENCES library (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE book_recomendation (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  recomend_criteria varchar(255) DEFAULT NULL,
  display_on_web char(1) DEFAULT NULL,
  display_text varchar(255) DEFAULT NULL,
  order_no bit(1) NOT NULL,
  recomend_type varchar(255) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_72fshwaw4wxp3rw87shs1pqd8 (user_id),
  CONSTRAINT FK_72fshwaw4wxp3rw87shs1pqd8 FOREIGN KEY (user_id) REFERENCES users_info (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE book_review (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  bookLike int(11) NOT NULL,
  dislike int(11) NOT NULL,
  review_date datetime DEFAULT NULL,
  review_text varchar(255) DEFAULT NULL,
  shares int(11) NOT NULL,
  book_id bigint(20) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_susukl313oqaqfcj7blc5krme (book_id),
  KEY FK_qvl1tjh0x9a0by2yl7ol8gouu (user_id),
  CONSTRAINT FK_qvl1tjh0x9a0by2yl7ol8gouu FOREIGN KEY (user_id) REFERENCES users_info (id),
  CONSTRAINT FK_susukl313oqaqfcj7blc5krme FOREIGN KEY (book_id) REFERENCES books_info (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE category (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  category varchar(255) DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_p7f369ctnjtelspme7ve4tsfn (book_id),
  CONSTRAINT FK_p7f369ctnjtelspme7ve4tsfn FOREIGN KEY (book_id) REFERENCES books_info (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE delivery_type (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  delivery_type varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO delivery_type(delivery_type) values('DELIVER'),('PICKUP');

CREATE TABLE book_transaction_queue (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  transaction_date datetime DEFAULT NULL,
  agent_id bigint(20) DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL,
  bookFlag_id bigint(20) DEFAULT NULL,
  bookStatus_id bigint(20) DEFAULT NULL,
  deliveryType_id bigint(20) DEFAULT NULL,
  library_id bigint(20) DEFAULT NULL,
  location_id bigint(20) DEFAULT NULL,
  orederLineItem_id bigint(20) DEFAULT NULL,
  owner_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_2g7ikucmngoid25umk1fs2i2h (agent_id),
  KEY FK_s36n7ktrtwaqshc9xrkccpnwc (book_id),
  KEY FK_bhyeersgewbussd4o1o82lnkj (bookFlag_id),
  KEY FK_puqhjwexgw0w4kc0xjsq0i1et (bookStatus_id),
  KEY FK_22rxcjferyfc6flxkfsdh799d (deliveryType_id),
  KEY FK_tis9o2fbohaqha32ckfy93er6 (library_id),
  KEY FK_qowd5eq2xw0su0a6qs8b86u74 (location_id),
  KEY FK_cwf6d588wjffgl8tshmeikn93 (orederLineItem_id),
  KEY FK_4bl67t53tgp8sowobd78opgph (owner_id),
  CONSTRAINT FK_22rxcjferyfc6flxkfsdh799d FOREIGN KEY (deliveryType_id) REFERENCES delivery_type (id),
  CONSTRAINT FK_2g7ikucmngoid25umk1fs2i2h FOREIGN KEY (agent_id) REFERENCES users_info (id),
  CONSTRAINT FK_4bl67t53tgp8sowobd78opgph FOREIGN KEY (owner_id) REFERENCES users_info (id),
  CONSTRAINT FK_bhyeersgewbussd4o1o82lnkj FOREIGN KEY (bookFlag_id) REFERENCES book_flag (id),
  CONSTRAINT FK_cwf6d588wjffgl8tshmeikn93 FOREIGN KEY (orederLineItem_id) REFERENCES book_order_line_items (id),
  CONSTRAINT FK_puqhjwexgw0w4kc0xjsq0i1et FOREIGN KEY (bookStatus_id) REFERENCES book_status (id),
  CONSTRAINT FK_qowd5eq2xw0su0a6qs8b86u74 FOREIGN KEY (location_id) REFERENCES library_location (id),
  CONSTRAINT FK_s36n7ktrtwaqshc9xrkccpnwc FOREIGN KEY (book_id) REFERENCES books_info (id),
  CONSTRAINT FK_tis9o2fbohaqha32ckfy93er6 FOREIGN KEY (library_id) REFERENCES library (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE library_admin_agent (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  admin_id bigint(20) DEFAULT NULL,
  agent_id bigint(20) DEFAULT NULL,
  library_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_4ttpfkgk0ubu9kfg0y9eolnr4 (admin_id),
  KEY FK_5i3fakb26sghs9p0vlxxg1oo0 (agent_id),
  KEY FK_lia1r9t66rleriw6tictj87nl (library_id),
  CONSTRAINT FK_4ttpfkgk0ubu9kfg0y9eolnr4 FOREIGN KEY (admin_id) REFERENCES users_info (id),
  CONSTRAINT FK_5i3fakb26sghs9p0vlxxg1oo0 FOREIGN KEY (agent_id) REFERENCES users_info (id),
  CONSTRAINT FK_lia1r9t66rleriw6tictj87nl FOREIGN KEY (library_id) REFERENCES library (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE pickup_timing (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  pickup_time datetime DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  weekday_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_s20xsxhr93slkge4xe6i6jwia (user_id),
  KEY FK_kgh39rwmisxrkck7labx6c84o (weekday_id),
  CONSTRAINT FK_kgh39rwmisxrkck7labx6c84o FOREIGN KEY (weekday_id) REFERENCES weekdays (id),
  CONSTRAINT FK_s20xsxhr93slkge4xe6i6jwia FOREIGN KEY (user_id) REFERENCES users_info (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE profile_type (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  profile_type varchar(255) DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_oomartj9huprwev3yg1bgwaxb (book_id),
  CONSTRAINT FK_oomartj9huprwev3yg1bgwaxb FOREIGN KEY (book_id) REFERENCES books_info (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;