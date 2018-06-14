
  INSERT INTO User (id, username, password, salary, age) VALUES 
  (1, 'Alex123', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 3456, 33);
  
	create table if not exists oauth_access_token ( token_id VARCHAR(255), token VARBINARY(8000),
 	authentication_id VARCHAR(255) PRIMARY KEY, user_name VARCHAR(255), client_id VARCHAR(255),
  	authentication VARBINARY(8000), refresh_token VARCHAR(255) );
    
	create table if not exists oauth_refresh_token (
  	token_id VARCHAR(255),
  	token VARBINARY(8000),
 	authentication VARBINARY(8000));
