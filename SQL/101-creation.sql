/*******************************************************************************
   101 Database - Version 1.0
   Script: 101-creation.sql
   Description: Creates and populates the 101 database.
   DB Server: Oracle
   Author: Bobby McGetrick
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER "101" CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER "101"
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to "101";
GRANT resource to "101";
GRANT create session TO "101";
GRANT create table TO "101";
GRANT create view TO "101";
GRANT create job TO "101";



conn "101"/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE users
(
    user_id NUMBER PRIMARY KEY,
    username VARCHAR2(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    role_id NUMBER
);

CREATE TABLE role
(
    role_id NUMBER PRIMARY KEY,
    role VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE post
(
    post_id NUMBER PRIMARY KEY,
    title VARCHAR2(50) NOT NULL,
    author_id NUMBER NOT NULL,
    body VARCHAR2(2000),
--    content BLOB,
    likes NUMBER,
    status_id NUMBER NOT NULL,
    subject_id NUMBER NOT NULL
--    first_comment NUMBER
);

CREATE TABLE subject
(
    subject_id NUMBER PRIMARY KEY,
    subject_name VARCHAR2(50) NOT NULL
);

CREATE TABLE status
(
    status_id NUMBER PRIMARY KEY,
    status_name VARCHAR2(50) NOT NULL
);

CREATE TABLE quiz
(
    quiz_id NUMBER PRIMARY KEY,
    subject_id NUMBER NOT NULL,
--    avg_score/diffculty NUMBER
    likes NUMBER,
    title VARCHAR2(30) NOT NULL,
    author_id NUMBER NOT NULL
);

CREATE TABLE question
(
    question_id NuMBER PRIMARY KEY,
    quiz_id NUMBER NOT NULL,
    question VARCHAR2(200) NOT NULL,
    correct_answer VARCHAR(200) NOT NULL,
    wrong_answer_0 VARCHAR2(200) NOT NULL,
    wrong_answer_1 VARCHAR2(200),
    wrong_answer_2 VARCHAR2(200)
);

CREATE TABLE fc_set
(
    fc_set_id NUMBER PRIMARY KEY,
    title VARCHAR2(30) NOT NULL,
    subject_id NUMBER NOT NULL,
    author_id NUMBER NOT NULL,
    likes NUMBER,
    status_id NUMBER
);

CREATE TABLE flashcard
(
    flashcard_id NUMBER PRIMARY KEY,
    fc_set_id NUMBER NOT NULL,
    question VARCHAR2(200) NOT NULL,
    answer VARCHAR2(200) NOT NULL,
    author_id NUMBER NOT NULL
);

/*******************************************************************************
   Create Junction Tables
********************************************************************************/

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
/**
* users
**/
ALTER TABLE users ADD CONSTRAINT role_id_fk_auth
    FOREIGN KEY (role_id) REFERENCES role (role_id) ON DELETE CASCADE;
    
/**
* post
**/
ALTER TABLE post ADD CONSTRAINT post_author_id_fk_auth
    FOREIGN KEY (author_id) REFERENCES users (user_id) ON DELETE CASCADE;

ALTER TABLE post ADD CONSTRAINT post_subject_id_fk_auth
    FOREIGN KEY (subject_id) REFERENCES subject (subject_id) ON DELETE CASCADE;
    
/**
* quiz
**/
ALTER TABLE quiz ADD CONSTRAINT quiz_author_id_fk_auth
    FOREIGN KEY (author_id) REFERENCES users (user_id) ON DELETE CASCADE;
    
/**
* question
**/
ALTER TABLE question ADD CONSTRAINT quiz_id_fk_auth
    FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id) ON DELETE CASCADE;
    
/**
* fc_set
**/
ALTER TABLE fc_set ADD CONSTRAINT subject_id_fk_auth
    FOREIGN KEY (subject_id) REFERENCES subject (subject_id) ON DELETE CASCADE;
    
ALTER TABLE fc_set ADD CONSTRAINT set_author_id_fk_auth
    FOREIGN KEY (author_id) REFERENCES users (user_id) ON DELETE CASCADE;
    
ALTER TABLE fc_set ADD CONSTRAINT set_status_id_fk_auth
    FOREIGN KEY (status_id) REFERENCES status (status_id) ON DELETE CASCADE;

/**
* flashcard
**/
ALTER TABLE flashcard ADD CONSTRAINT fc_set_id_fk_auth
    FOREIGN KEY (fc_set_id) REFERENCES fc_set (fc_set_id) ON DELETE CASCADE;

ALTER TABLE flashcard ADD CONSTRAINT fc_author_id_fk_auth
    FOREIGN KEY (author_id) REFERENCES users (user_id) ON DELETE CASCADE;

/*******************************************************************************
   Create Sequences
********************************************************************************/
CREATE SEQUENCE user_id_seq;

CREATE SEQUENCE role_id_seq;

CREATE SEQUENCE post_id_seq;

CREATE SEQUENCE subject_id_seq;

CREATE SEQUENCE status_id_seq;

CREATE SEQUENCE quiz_id_seq;

CREATE SEQUENCE question_id_seq;

CREATE SEQUENCE fc_set_id_seq;

CREATE SEQUENCE flashcard_id_seq;

/*******************************************************************************
   Create Triggers
********************************************************************************/

/*******************************************************************************
   Create Stored Procedures
********************************************************************************/


/*******************************************************************************
   Create Functions
********************************************************************************/

/*******************************************************************************
   Create Jobs
********************************************************************************/

/*******************************************************************************
   Initialize Tables
********************************************************************************/

/*******************************************************************************
   Commit changes and exit
*******************************************************************************/
COMMIT;
EXIT;