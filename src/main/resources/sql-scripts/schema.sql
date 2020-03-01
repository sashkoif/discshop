CREATE TABLE user (
  id bigint NOT NULL IDENTITY,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE disk (
  id bigint NOT NULL IDENTITY,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE taken_item (
  id bigint NOT NULL IDENTITY,
  user_id bigint NOT NULL,
  disk_id bigint NOT NULL,
  PRIMARY KEY (id)
);