DELETE exercise;
DELETE permission;
DELETE role;
DELETE role_permission;
DELETE r_user;
DELETE workout;
DELETE workout_exercise;
 
INSERT INTO exercise VALUES(1, 'chest', 'pushup', 12);
INSERT INTO exercise VALUES(2, 'legs', 'squat', 12);
INSERT INTO exercise VALUES(3, 'abs', 'situp', 12);
INSERT INTO EXERCISE VALUES(4,'n/a','rest',0);
INSERT INTO EXERCISE VALUES(5,'back','chin up',13);

INSERT INTO permission VALUES(1, 'standard', 'Standard user');
INSERT INTO permission VALUES(2, 'admin', 'Administrative permissions');
INSERT INTO permission VALUES(3, 'premium', 'Premium user');

INSERT INTO role VALUES(1, 'standard', 'Standard user');
INSERT INTO role VALUES(2, 'admin', 'Administrative permissions');
INSERT INTO role VALUES(3, 'premium', 'Premium user');

INSERT INTO role_permission VALUES(1, 1);
INSERT INTO role_permission VALUES(2, 1);
INSERT INTO role_permission VALUES(2, 2);
INSERT INTO role_permission VALUES(2, 3);
INSERT INTO role_permission VALUES(3, 1);
INSERT INTO role_permission VALUES(3, 3);

INSERT INTO r_user VALUES(1, 1, 'user1', 'password', 'Chuck', 'Norris', 'chuck@revitup.com', 154, 70);
INSERT INTO r_user VALUES(2, 2, 'ryan', 'pa$$word', 'Ryan', 'Schlientz', 'ryan@revitup.com', 150, 72);
INSERT INTO r_user VALUES(3, 3, 'thedragon', 'password', 'Bruce', 'Lee', 'bruce@revitup.com', 128, 68);
INSERT INTO r_user VALUES(4, 2, 'nacho', 'libre', 'Jack', 'Black', 'jack@revitup.com', 235,66);

INSERT INTO workout VALUES(1, 2, 'dailies', 'moderate', 'strength');
INSERT INTO workout VALUES(2, 1, 'weekdays', 'intense', 'cardio');
INSERT INTO workout VALUES(3, 3, 'The Warrior', 'intense', 'kung fu');

--
--INSERT INTO workout VALUES(4, 1, 'test', 'test', 'test');
--INSERT INTO workout_exercise VALUES(4, 1, 3, 3);
--COMMIT;

INSERT INTO workout_exercise VALUES(1, 1, 30, 3);
INSERT INTO workout_exercise VALUES(1, 2, 30, 3);
INSERT INTO workout_exercise VALUES(1, 3, 30, 3);

INSERT INTO workout_exercise VALUES(2, 1, 60, 3);
INSERT INTO workout_exercise VALUES(2, 2, 60, 3);
INSERT INTO workout_exercise VALUES(2, 3, 60, 3);

INSERT INTO workout_exercise VALUES(3, 1, 90, 3);
INSERT INTO workout_exercise VALUES(3, 2, 90, 3);
INSERT INTO workout_exercise VALUES(3, 3, 90, 3);

COMMIT;
