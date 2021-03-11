INSERT INTO roles VALUES ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36','ADMIN'),
                         ('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84','USER');


INSERT INTO modules (id, name) VALUES ('ed625f3e-1baf-4cfc-9055-f47b0e69593e', 'actions'),
                                      ('f842900a-5925-4e51-8ef8-80c13b61f454', 'authorizations'),
                                      ('c31529a8-4b15-4246-a8a8-1187564f4172', 'modules'),
                                      ('e200d806-7e34-4180-9795-62eea555d36a', 'roles'),
                                      ('5adcdc47-7cdd-4585-8b7d-8c756b13f015', 'sessions'),
                                      ('d482bf58-214a-4747-aade-0861cbedc541', 'users');

INSERT INTO actions (id, method, module_id) VALUES ('2e432be7-f2cc-4c4b-860d-b6fe334e5a10', 'GET', 'ed625f3e-1baf-4cfc-9055-f47b0e69593e'),
                                                   ('00778265-9a33-4c33-8bea-fc5e54a087b1', 'GET', 'f842900a-5925-4e51-8ef8-80c13b61f454'),
                                                   ('e4dc6e3e-b0bd-47de-8752-6d8788c615b2', 'GET', 'c31529a8-4b15-4246-a8a8-1187564f4172'),
                                                   ('feccf392-1cb8-46b8-a818-2a1cf07d7fae', 'GET', 'e200d806-7e34-4180-9795-62eea555d36a'),
                                                   ('a1b5b396-5208-41f1-a871-c80f81e3a86c', 'GET', '5adcdc47-7cdd-4585-8b7d-8c756b13f015'),
                                                   ('9e5ccfb6-1944-45eb-baf5-c9c6a47f8d77', 'GET', 'd482bf58-214a-4747-aade-0861cbedc541');

INSERT INTO actions (id, method, module_id) VALUES ('b0e97651-8a69-405c-806e-3dcf0b98dc63', 'POST', 'ed625f3e-1baf-4cfc-9055-f47b0e69593e'),
                                                   ('c19debbb-d5e2-4366-8981-ee4f936711c0', 'POST', 'f842900a-5925-4e51-8ef8-80c13b61f454'),
                                                   ('60ed85ad-c66e-40a6-acf3-f0354f23fd3e', 'POST', 'c31529a8-4b15-4246-a8a8-1187564f4172'),
                                                   ('979afe29-425d-44ee-9d84-5795cf7e0617', 'POST', 'e200d806-7e34-4180-9795-62eea555d36a'),
                                                   ('5fb41e17-50fe-45af-b668-4ca1dfeaf017', 'POST', '5adcdc47-7cdd-4585-8b7d-8c756b13f015'),
                                                   ('28a131d3-2825-475f-ad09-16d94031b789', 'POST', 'd482bf58-214a-4747-aade-0861cbedc541');

INSERT INTO actions (id, method, module_id) VALUES ('157c07b5-7e5e-4e84-af49-f78d286f2c4b', 'PUT', 'ed625f3e-1baf-4cfc-9055-f47b0e69593e'),
                                                   ('632de22c-b05c-457d-98a1-24220333a982', 'PUT', 'f842900a-5925-4e51-8ef8-80c13b61f454'),
                                                   ('14489109-6698-47e9-a594-1935f60d8bad', 'PUT', 'c31529a8-4b15-4246-a8a8-1187564f4172'),
                                                   ('da4cb254-c204-4d43-8127-0116b910d6fa', 'PUT', 'e200d806-7e34-4180-9795-62eea555d36a'),
                                                   ('e5d802cc-5123-4154-90d7-94e02111352f', 'PUT', '5adcdc47-7cdd-4585-8b7d-8c756b13f015'),
                                                   ('d582f6a1-1a02-4bf9-b81b-b2d433211f10', 'PUT', 'd482bf58-214a-4747-aade-0861cbedc541');


INSERT INTO authorizations (role_id, action_id) VALUES ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '2e432be7-f2cc-4c4b-860d-b6fe334e5a10'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '00778265-9a33-4c33-8bea-fc5e54a087b1'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'e4dc6e3e-b0bd-47de-8752-6d8788c615b2'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'feccf392-1cb8-46b8-a818-2a1cf07d7fae'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'a1b5b396-5208-41f1-a871-c80f81e3a86c'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '9e5ccfb6-1944-45eb-baf5-c9c6a47f8d77'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'b0e97651-8a69-405c-806e-3dcf0b98dc63'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'c19debbb-d5e2-4366-8981-ee4f936711c0'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '60ed85ad-c66e-40a6-acf3-f0354f23fd3e'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '979afe29-425d-44ee-9d84-5795cf7e0617'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '5fb41e17-50fe-45af-b668-4ca1dfeaf017'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '28a131d3-2825-475f-ad09-16d94031b789'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '157c07b5-7e5e-4e84-af49-f78d286f2c4b'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '632de22c-b05c-457d-98a1-24220333a982'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', '14489109-6698-47e9-a594-1935f60d8bad'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'da4cb254-c204-4d43-8127-0116b910d6fa'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'e5d802cc-5123-4154-90d7-94e02111352f'),
                                                       ('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'd582f6a1-1a02-4bf9-b81b-b2d433211f10');

INSERT INTO authorizations (role_id, action_id) VALUES ('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84', '2e432be7-f2cc-4c4b-860d-b6fe334e5a10'),
                                                       ('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84', '00778265-9a33-4c33-8bea-fc5e54a087b1'),
                                                       ('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84', 'e4dc6e3e-b0bd-47de-8752-6d8788c615b2'),
                                                       ('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84', 'feccf392-1cb8-46b8-a818-2a1cf07d7fae'),
                                                       ('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84', 'a1b5b396-5208-41f1-a871-c80f81e3a86c'),
                                                       ('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84', '9e5ccfb6-1944-45eb-baf5-c9c6a47f8d77');
