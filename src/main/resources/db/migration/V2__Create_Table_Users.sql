CREATE TABLE IF NOT EXISTS users(
	id int NOT NULL AUTO_INCREMENT,
	role_id INT NOT NULL,
	email varchar(150) NOT NULL UNIQUE,
	password  varchar(255) NOT NULL,
	confirmation_token varchar(255),
	confirmation_token_sent_at TIMESTAMP,
	confirmed_at TIMESTAMP,
	reset_password_token varchar(255),
	reset_password_token_sent_at TIMESTAMP,
	unconfirmed boolean DEFAULT TRUE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	PRIMARY KEY(id),
	CONSTRAINT FK_role FOREIGN KEY (role_id) REFERENCES roles (id),
	INDEX(email, confirmation_token)
);