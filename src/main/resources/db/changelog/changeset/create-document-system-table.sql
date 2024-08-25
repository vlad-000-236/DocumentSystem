CREATE TABLE worker
(
	id SERIAL PRIMARY KEY,
	name CHARACTER VARYING (30),
	surname CHARACTER VARYING (30),
	patronymic CHARACTER VARYING (30),
	creationdate CHARACTER VARYING (12),
	creatorname CHARACTER (30) DEFAULT 'ADMIN'
);

CREATE TABLE contract
(
	id SERIAL PRIMARY KEY,
	description CHARACTER VARYING (200),
	memberlist CHARACTER VARYING (150),
	beginning CHARACTER VARYING (12),
	ending CHARACTER VARYING (12),
	creationdate CHARACTER VARYING (12),
	creatorname INTEGER,
	FOREIGN KEY (creatorname) REFERENCES worker (id)
);

INSERT INTO worker (name, surname, patronymic, creationdate) VALUES ('Анна', 'Царёва', 'Михайловна', '26.08.2024');

INSERT INTO worker (name, surname, patronymic, creationdate) VALUES ('Антон', 'Коровин', 'Андреевич', '26.08.2024');

INSERT INTO worker (name, surname, patronymic, creationdate) VALUES ('Евгений', 'Глушко', 'Сергеевич', '26.08.2024');

INSERT INTO contract (description, memberlist, beginning, ending, creationdate, creatorname)
VALUES('Какой-то договор.', 'Станция №8, Барьер', '15.08.2024', '20.08.2024', '20.08.2024', 1);

INSERT INTO contract (description, memberlist, beginning, ending, creationdate, creatorname)
VALUES ('Другой какой-то договор.', 'Лесопильня Смерт энта, Светлая поляна', '20.08.2020', '15.08.2020', '20.08.2024', 2);
