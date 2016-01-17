CREATE TABLE users (
	user_id int  not null GENERATED ALWAYS AS IDENTITY  (START WITH 1, INCREMENT BY 1), 
	name varchar(50) not null,
	CONSTRAINT users_primary_key PRIMARY KEY (user_id)
);

CREATE TABLE pencils (
	pencil_id int  not null GENERATED ALWAYS AS IDENTITY  (START WITH 1, INCREMENT BY 1), 
	color varchar(50) not null,
	CONSTRAINT pencils_primary_key PRIMARY KEY (pencil_id)
);