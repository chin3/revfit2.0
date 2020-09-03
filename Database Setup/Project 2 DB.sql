DROP TABLE r_user CASCADE CONSTRAINTS;
CREATE TABLE r_user (
    user_id NUMBER(10) PRIMARY KEY,
    role_id NUMBER(10) NOT NULL,
    username VARCHAR2(50) UNIQUE NOT NULL,
    password VARCHAR2(50) NOT NULL,
    first_name VARCHAR2(100) NOT NULL,
    last_name VARCHAR2(100) NOT NULL,
    email VARCHAR2(75) NOT NULL,
    weight NUMBER(10,3) NOT NULL, 
    height NUMBER(10,3) NOT NULL
);

DROP TABLE role CASCADE CONSTRAINTS;
CREATE TABLE role(
    role_id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    description VARCHAR2(100) NOT NULL
);

DROP TABLE role_permission CASCADE CONSTRAINTS;
CREATE TABLE role_permission (
    role_id NUMBER(10),
    permission_id NUMBER(10)
);

DROP TABLE permission CASCADE CONSTRAINTS;
CREATE TABLE permission (
    permission_id NUMBER(10) PRIMARY KEY, 
    name VARCHAR2(50) NOT NULL, 
    description VARCHAR2(100) NOT NULL
);

DROP TABLE workout CASCADE CONSTRAINTS;
CREATE TABLE workout (
    workout_id NUMBER(10) PRIMARY KEY,
    user_id NUMBER(10) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    intensity VARCHAR2(50),
    type VARCHAR2(50)
);

DROP TABLE workout_exercise CASCADE CONSTRAINTS;
CREATE TABLE workout_exercise (
    workout_id NUMBER(10),
    exercise_id NUMBER(10),
    time NUMBER(10,3),
    sets NUMBER(10)
);

DROP TABLE exercise CASCADE CONSTRAINTS;
CREATE TABLE exercise (
    exercise_id NUMBER(10) PRIMARY KEY,
    muscle_group VARCHAR2(75),
    name VARCHAR2(75) NOT NULL,
    calories NUMBER(10)
    
);

DROP TABLE weight_archive;
CREATE TABLE weight_archive(
    archive_id NUMBER(10) PRIMARY KEY,
    user_id NUMBER(10),
    weight NUMBER(10, 3) NOT NULL,
    date_updated DATE NOT NULL
);

ALTER TABLE r_user DROP CONSTRAINT user_role_fk;
ALTER TABLE role_permission DROP CONSTRAINT role_permission_role_fk;
ALTER TABLE role_permission DROP CONSTRAINT role_permission_permission_fk;
ALTER TABLE workout DROP CONSTRAINT workout_user_fk;
ALTER TABLE workout_exercise DROP CONSTRAINT workout_exercise_exercise_fk;
ALTER TABLE workout_exercise DROP CONSTRAINT workout_exercise_workout_fk;
ALTER TABLE weight_archive DROP CONSTRAINT weight_archive_user_fk;

ALTER TABLE r_user ADD CONSTRAINT user_role_fk FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE;
ALTER TABLE role_permission ADD CONSTRAINT role_permission_role_fk FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE;
ALTER TABLE role_permission ADD CONSTRAINT role_permission_permission_fk FOREIGN KEY (permission_id) REFERENCES permission(permission_id) ON DELETE CASCADE;
ALTER TABLE workout ADD CONSTRAINT workout_user_fk FOREIGN KEY (user_id) REFERENCES r_user(user_id) ON DELETE CASCADE;
ALTER TABLE workout_exercise ADD CONSTRAINT workout_exercise_exercise_fk FOREIGN KEY (exercise_id) REFERENCES exercise(exercise_id) ON DELETE CASCADE;
ALTER TABLE workout_exercise ADD CONSTRAINT workout_exercise_workout_fk FOREIGN KEY (workout_id) REFERENCES workout(workout_id) ON DELETE CASCADE;
ALTER TABLE workout_exercise ADD CONSTRAINT we_pk PRIMARY KEY (workout_id, exercise_id);
ALTER TABLE weight_archive ADD CONSTRAINT weight_archive_user_fk FOREIGN KEY (user_id) REFERENCES r_user(user_id) ON DELETE CASCADE;


DROP SEQUENCE id_maker;
CREATE SEQUENCE id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER weight_archiver
BEFORE UPDATE ON r_user
FOR EACH ROW 
BEGIN
    INSERT INTO weight_archive VALUES(id_maker.nextval, :new.user_id, :old.weight, (SELECT CURRENT_DATE FROM DUAL));
    COMMIT;
END;


