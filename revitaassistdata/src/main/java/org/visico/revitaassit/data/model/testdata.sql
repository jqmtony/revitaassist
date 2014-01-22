insert into USER (name, email, password, language, organization, function) VALUES ('Timo', 'timoconsult@gmail.com', 'revitaplan', 'en', 'University of Twente', 'Associate Prof');

insert into PROJECT (name, stage, description) VALUES ('Turfkade', 'initiation', 'The Turfkade project');

insert into USERPROJECTREL (userid, projectid) VALUES (1,1);
