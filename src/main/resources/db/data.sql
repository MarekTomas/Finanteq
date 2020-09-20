
INSERT INTO ROOM (ID, ROOM_NUMBER, NUMBER_OF_BEDS) VALUES (1, 1, 1);
INSERT INTO ROOM (ID, ROOM_NUMBER, NUMBER_OF_BEDS) VALUES (2, 2, 2);
INSERT INTO ROOM (ID, ROOM_NUMBER, NUMBER_OF_BEDS) VALUES (3, 3, 3);
INSERT INTO ROOM (ID, ROOM_NUMBER, NUMBER_OF_BEDS) VALUES (4, 4, 3);
INSERT INTO ROOM (ID, ROOM_NUMBER, NUMBER_OF_BEDS) VALUES (5, 5, 4);

INSERT INTO RESERVATION(ID, ROOM_NUMBER, START_RESREVATION_DATE, END_RESREVATION_DATE, IS_RESERVED) values (1, 1, PARSEDATETIME('01/10/2020', 'DD/MM/YYYY'), PARSEDATETIME('12/10/2020','DD/MM/YYYY'),true);
INSERT INTO RESERVATION(ID, ROOM_NUMBER, START_RESREVATION_DATE, END_RESREVATION_DATE, IS_RESERVED) values (2, 1, PARSEDATETIME('15/10/2020', 'DD/MM/YYYY'), PARSEDATETIME('24/10/2020','DD/MM/YYYY'),true);

INSERT INTO PERSON (ID, NAME, SURNAME, EMAIL,PASSWORD,ROOM_NUMBER) VALUES (1, 'John', 'Rambo', 'jr@gmail.com','password',1);
INSERT INTO PERSON (ID, NAME, SURNAME, EMAIL,PASSWORD,ROOM_NUMBER) VALUES (2, 'Zbigniew', 'Json', 'zj@gmail.com','password',2);
INSERT INTO PERSON (ID, NAME, SURNAME, EMAIL,PASSWORD,ROOM_NUMBER) VALUES (3, 'Beata', 'Byk', 'bb@gmail.com','password',null);
INSERT INTO PERSON (ID, NAME, SURNAME, EMAIL,PASSWORD,ROOM_NUMBER) VALUES (4, 'Maciej', 'Niechciał', 'mn@gmail.com','password',null);
INSERT INTO PERSON (ID, NAME, SURNAME, EMAIL,PASSWORD,ROOM_NUMBER) VALUES (5, 'Grzegorz', 'Kaczka', 'gk@gmail.com','password',null);
