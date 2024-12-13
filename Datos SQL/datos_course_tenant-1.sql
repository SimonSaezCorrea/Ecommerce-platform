create table "Schema-1".course (
	id INT,
	name VARCHAR(50),
	description TEXT,
	id_professor INT
);

create table "Schema-2".course (
	id INT,
	name VARCHAR(255),
	description TEXT,
	id_professor INT
);


insert into "Schema-1".course (id, name, description, id_professor) values (1, 'equaline lansoprazole', 'cursus urna ut tellus nulla ut erat id mauris vulputate elementum', 3);
insert into "Schema-1".course (id, name, description, id_professor) values (2, 'Childrens Ibuprofen', 'nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris', 10);
insert into "Schema-1".course (id, name, description, id_professor) values (3, 'Pain Relief PM', 'est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat', 8);
insert into "Schema-1".course (id, name, description, id_professor) values (4, 'CYZONE', 'sed accumsan felis ut at dolor quis odio consequat varius integer', 9);
insert into "Schema-1".course (id, name, description, id_professor) values (5, 'GFA First Aid', 'non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie', 8);
insert into "Schema-1".course (id, name, description, id_professor) values (6, 'CUT CLEANER', 'adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc', 5);
insert into "Schema-1".course (id, name, description, id_professor) values (7, 'Nex Iodio P2', 'quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus', 2);
insert into "Schema-1".course (id, name, description, id_professor) values (8, 'Fenofibric Acid', 'duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget', 6);
insert into "Schema-1".course (id, name, description, id_professor) values (9, 'LIDOCAINE HYDROCHLORIDE', 'purus aliquet at feugiat non pretium quis lectus suspendisse potenti in', 4);
insert into "Schema-1".course (id, name, description, id_professor) values (10, '7 Select Acid Controller', 'ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat', 3);


insert into "Schema-2".course (id, name, description, id_professor) values (1, 'donepezil hydrochloride', 'ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id', 6);
insert into "Schema-2".course (id, name, description, id_professor) values (2, 'Haloperidol', 'nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum', 8);
insert into "Schema-2".course (id, name, description, id_professor) values (3, 'Waterless Anti-Bacterial Hand Cleanser', 'eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat', 5);
insert into "Schema-2".course (id, name, description, id_professor) values (4, 'Vitamin A and D', 'gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio', 9);
insert into "Schema-2".course (id, name, description, id_professor) values (5, 'Plan B One-Step', 'mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum', 10);
insert into "Schema-2".course (id, name, description, id_professor) values (6, 'Diclofenac Sodium', 'nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt', 1);
insert into "Schema-2".course (id, name, description, id_professor) values (7, 'CHANTECAILLE Ultra Sun Protection Sunscreen Broad Spectrum SPF 30', 'dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus', 7);
insert into "Schema-2".course (id, name, description, id_professor) values (8, 'Hydrochlorothiazide', 'dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at', 2);
insert into "Schema-2".course (id, name, description, id_professor) values (9, 'MEDICLEAR DUAL SPOT DAY and NIGHT', 'nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer', 8);
insert into "Schema-2".course (id, name, description, id_professor) values (10, 'Etomidate', 'sapien placerat ante nulla justo aliquam quis turpis eget elit', 9);
