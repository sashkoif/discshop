INSERT INTO user (id, password, username) VALUES (1, 'user1', 'user1');
INSERT INTO user (id, password, username) VALUES (2, 'user2', 'user2');


INSERT INTO disk (id, name) VALUES (1, 'AC/DC - Back in Black');
INSERT INTO disk (id, name) VALUES (2, 'Alice Cooper - Flush the Fashion');
INSERT INTO disk (id, name) VALUES (3, 'Blue Öyster Cult - Cultösaurus Erectus');
INSERT INTO disk (id, name) VALUES (4, 'Iron Maiden - Iron Maiden');
INSERT INTO disk (id, name) VALUES (5, 'Judas Priest - British Steel');
INSERT INTO disk (id, name) VALUES (6, 'KISS - Unmasked');
INSERT INTO disk (id, name) VALUES (7, 'Motörhead - Ace of Spades');
INSERT INTO disk (id, name) VALUES (8, 'Ozzy Osbourne - Blizzard of Ozz');
INSERT INTO disk (id, name) VALUES (9, 'Scorpions - Animal Magnetism');
INSERT INTO disk (id, name) VALUES (10, 'Van Halen - Women and Children First');

INSERT INTO taken_item (id, user_id,disk_id) VALUES (1, 1, 3);
INSERT INTO taken_item (id, user_id,disk_id) VALUES (2, 1, 4);
INSERT INTO taken_item (id, user_id,disk_id) VALUES (3, 2, 5);
INSERT INTO taken_item (id, user_id,disk_id) VALUES (4, 2, 10);