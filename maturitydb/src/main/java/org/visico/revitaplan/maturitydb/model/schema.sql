create database if not exists REVITAMATURITY;

use REVITAMATURITY;

grant all on REVITAMATURITY.* to 'superuser'@localhost identified by 'RESU#2010_2014';

drop table QUESTION;
create table QUESTION
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	english VARCHAR(500),
	german VARCHAR(500),
	dutch VARCHAR(500),
	format VARCHAR(250)
);

drop table SURVEY;
create table SURVEY
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	position INT UNIQUE,
	question INT REFERENCES QUESTION.id
);

drop table GROUPINGS;
create table GROUPINGS
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	firstquestion INT REFERENCES SURVEY.position,
	lastquestion INT REFERENCES SURVEY.position
);

create table if not exists ANSWER
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	project INT,
	completed DATETIME
);

create table if not exists ANSWERQUESTION
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	answer INT REFERENCES ANSWER.id,
	question INT REFERENCES QUESTION.id,
	valueInt INT,
	valueSring VARCHAR(500)
);



#and here add the questions ... 
#replace question1, frage1, vraag1 with the survey questions
#add position within survey (number of question)
INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'Briefly describe your revitalization project and its main objectives:', 
	'Beschreiben Sie kurz Ihr Revitalisierungidee oder Bemühungen und die damit verbundenen Ziele:', 
	'vraag1', 'open');
INSERT INTO SURVEY (position, question) VALUES (1, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES ('
	Is the revitalization project recognized as a formal project by your organization or is it an informal endeavor?', 
	'Hat Ihr Projekt einen formellen Status innerhalb der Organisation oder handelt es sich um die ersten Bemühungen?', 
	'vraag1', 'open');
INSERT INTO SURVEY (position, question) VALUES (2, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'At the beginning of the project, the need for revitalizaiton was triggered by:', 
	'Durch wen wurde das Revitalisierungsprojekt ausgelöst:', 
	'vraag1', 'open');
INSERT INTO SURVEY (position, question) VALUES (3, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'What project tasks have you conducted?', 
	'Welche Projektaufgaben haben Sie bis jetzt durchgeführt?', 
	'vraag1', 'open');
INSERT INTO SURVEY (position, question) VALUES (4, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'The project is progressing:', 
	'Das Projekt entwickelt sich:', 
	'vraag1', 'open');
INSERT INTO SURVEY (position, question) VALUES (5, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'According to your answer to question 5, at the current state of the project, 
		what is the main driver of planning activities?', 
	'In Abhängigkeit der Beantwortung von Frage 5, was beeinflusst oder treibt die Planungsaktivitäten?', 
	'vraag1', 'open');
INSERT INTO SURVEY (position, question) VALUES (6, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'According to your answer to question 5, at the current state of the project, 
		what is the main barrier of planning activities?', 
	'In Abhängigkeit der Beantwortung von Frage 5, was hemmt die Planungsaktivitäten?', 
	'vraag1', 'open');
INSERT INTO SURVEY (position, question) VALUES (7, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We have a clear idea of the objectives for this revitalization  project.', 
	'Wir haben eine klare Vorstellung der Ziele des Revitalisierungsprojektes.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (8, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We have developed and assessed several alternatives for revitalization.', 
	'Wir haben verschiedene Alternativen entwickelt und abgeschätzt.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (9, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We have developed a realistic long-term forecast of project needs.', 
	'Wir haben eine realistische Prognose der Projektaufwendungen durchgeführt.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (10, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We feel our stakeholders have sufficient access to information to make an informed decision.', 
	'Unsere Anspruchsgrupppen sind ausreichend informiert um Entscheidungen zu treffen.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (11, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are well-organized in our communication with stakeholders and we update them regularly on the status 
		of the project.', 
	'Wir haben die Kommunikation im Projekt mit unseren Anspruchsgruppen gut organisiert und wir benachrichtigen 
		sie regelmässig über den Status des Projektes.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (12, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'The regulations and procedures relevant to this project give us a good understanding of where, when 
		and how we must involve stakeholders.', 
	'Die für dieses Projekt relevanten gesetzlichen Bestimmungen und Verfahren geben uns Aufschluss darüber wo,
		 wann und wie wir unsere Anspruchsgruppen mit integrieren müssen.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (13, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We have guided the involvement of stakeholders in the planning process based on our understandings of 
		where, when and how to involve them.', 
	'Wir haben die Beteiligung der Anspruchsgruppen in den Planungsprozess auf Basis unseres Verständnisses 
		wo, wann und wie sie einzubeziehen sind, mit einbezogen.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (14, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are sufficiently aware of the degree of influence stakeholders have at different phases in the project.', 
	'Wir sind uns ausreichend dar?ber bewusst, welches Mass an Einfluss die Anspruchsgruppen in den verschiedenen 
		Projektphasen haben.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (15, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'All stakeholders are sufficiently aware of the procedural steps where they have influence on the project.', 
	'Alle Anspruchsgruppen sind sich dar?ber bewusst, in welchen Verfahrensschritten sie Einfluss auf das Projekt haben.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (16, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are sufficiently aware of the regulations and procedures that each of our stakeholders brings into the project.', 
	'Wir sind uns ausreichend über die Beschränkungen und Verfahren bewusst, die jede Anspruchsgruppe in das Projekt 
		einbringt.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (17, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'Our management of stakeholders has positively impacted project planning.', 
	'Unser Management der Anspruchsgruppen hat unser Projekt positiv beeinflusst.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (18, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'Stakeholder interests strongly influenced our revitalization ideas for the area', 
	'Die Interessen der Anspruchsgruppen haben unsere Revitalisierungsidee für das Areal stark beeinflusst.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (19, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are satisfied with the way we were able to integrate stakeholder interests in our revitalization ideas 
		for the area.', 
	'Wir sind zufrieden mit der Art und Weise, wie wir die Interessen unserer Anspruchsgruppen in die 
		Revitalisierungsidee des Areals integrieren konnten.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (20, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We sufficiently discussed our revitalization ideas for the area with all relevant stakeholders.', 
	'Wir haben die Revitalisierungsidee ausreichend mit allen relevanten Anspruchsgruppen diskutiert.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (21, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are  satisified with the way that we can communicate our revitalization ideas for the area with stakeholders.', 
	'Wir sind zufrieden mit der Art und Weise, wie wir unsere Revitalisierungsidee an die Anspruchsgruppen 
		kommunizieren können.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (22, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We still know whose (stakeholders) objectives influenced  our current ideas for the possible revitalization 
		of the area.', 
	'Wir wissen, wessen Ziele unsere derzeitigen Ideen für die mögliche Revitalisierung des Areals beeinflussen.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (23, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We still know the feedback that stakeholders contributed in earlier phases that have led to the current 
		revitalization ideas for the area.', 
	'Wir kennen das Feedback, welches Anspruchsgruppen in früheren Phasen abgegebenen haben, das zur derzeitigen 
		Revitalisierungsidee führte.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (24, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We have comprehensively identified the regulations and procedures that apply to our revitalization ideas 
		for the area.', 
	'Wir haben umfassend die gesetzlichen Bestimmungen und Verfahren, die unser Revitalisierungsprojekt betreffen, 
		identifiziert.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (25, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are sufficiently aware of the limitations that regulations and procedures place on our revitalization 
		ideas for the area.', 
	'Wir sind uns ausreichend über die Einschr?nkungen, die durch gesetzliche Bestimmungen und Verfahren auf 
		unser Revitalisierungsprojekt Auswirkung haben, bewusst.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (26, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We have sufficiently explored all possible regulations and procedures that support the generation of our 
		revitalization ideas for the area.', 
	'Wir haben ausgiebig alle möglichen gesetzlichen Bestimmungen und Verfahren untersucht, die die 
		Projektidee für den Standort unterst?tzen.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (27, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We have sufficiently identified regulations and procedures that require modification based on our 
		revitalization ideas for the area.', 
	'Wir haben ausreichend die gesetzlichen Bestimmungen und Verfahren identifiziert, die für die Umsetzung 
		der Revitalisierungsidee angepasst werden müssen.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (28, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are sufficiently aware of where modifications can be made in the regulations and procedures based on 
		our revitalization ideas for the area', 
	'Wir sind uns ausreichend bewusst darüber, wo Anpassungen gesetzlicher Bestimmungen und Verfahren für 
		unsere Revitalisierungsidee vorgenommen werden können.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (29, LAST_INSERT_ID());

INSERT INTO QUESTION (english, german, dutch, format) VALUES (
	'We are in a position to modify the regulations and procedures according to our revitalization ideas for the area', 
	'Wir sind in der Lage gesetzliche Bestimmungen und Verfahren in Bezug auf die Revitalisierungsidee für 
		das Areal anzupassen.', 
	'vraag1', 'likert');
INSERT INTO SURVEY (position, question) VALUES (30, LAST_INSERT_ID());

#.. add al questions in this format then add groupings
# questions within one grouping will be displayed on one page while the survey is administered
INSERT INTO GROUPINGS (firstquestion, lastquestion) VALUES (1, 7);
INSERT INTO GROUPINGS (firstquestion, lastquestion) VALUES (8, 12);
INSERT INTO GROUPINGS (firstquestion, lastquestion) VALUES (13, 18);
INSERT INTO GROUPINGS (firstquestion, lastquestion) VALUES (19, 24);
INSERT INTO GROUPINGS (firstquestion, lastquestion) VALUES (25, 30);