CREATE TYPE status AS ENUM ('online', 'offline');

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
  	username VARCHAR(14) UNIQUE NOT NULL,
  	email VARCHAR(30) UNIQUE NOT NULL,
  	password_hash CHAR(255) NOT NULL,
  	user_status status DEFAULT 'offline'
);

CREATE TABLE chats (
	chat_id SERIAL PRIMARY KEY,
 	user1_id INTEGER NOT NULL REFERENCES chats(user_id) ON DELETE CASCADE,
    user2_id INTEGER NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    UNIQUE (user1_id, user2_id)
);

CREATE TABLE messages (
	message_id SERIAL PRIMARY KEY,
    chat_id INTEGER NOT NULL REFERENCES chats(chat_id) ON DELETE CASCADE,
    sender_id INTEGER NOT NULL REFERENCES users(user_id),
    text VARCHAR(4096) NOT NULL
);