CREATE TABLE users (
	user_id int  not null GENERATED ALWAYS AS IDENTITY  (START WITH 1, INCREMENT BY 1), 
	name varchar(50) not null,
	password varchar(50) not null,
	enabled BOOLEAN not null,
	CONSTRAINT users_primary_key PRIMARY KEY (user_id)
);

CREATE TABLE user_roles (
	user_role_id int not null GENERATED ALWAYS AS IDENTITY  (START WITH 1, INCREMENT BY 1), 
	role varchar(50) not null,
	user_id int not null
);

CREATE TABLE purchase_list (
	purchase_list_id int not null GENERATED ALWAYS AS IDENTITY  (START WITH 1, INCREMENT BY 1), 
	owner_id int not null,
	status varchar(50) not null,
	CONSTRAINT purchase_list_primary_key PRIMARY KEY (purchase_list_id),
	CONSTRAINT fk_purchase_list_owner_id FOREIGN KEY (owner_id) REFERENCES users (user_id)	
)

CREATE TABLE pencils (
	pencil_id int  not null GENERATED ALWAYS AS IDENTITY  (START WITH 1, INCREMENT BY 1), 
	color varchar(50) not null,
	CONSTRAINT pencils_primary_key PRIMARY KEY (pencil_id)
);