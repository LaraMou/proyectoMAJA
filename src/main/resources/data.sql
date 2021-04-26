
/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('monica','$2a$10$F4hSYLSgVLzUAmkal9q.DOMrgnSIrRaY1UaspNAlO1kEbJU5PWaP6',1, 'Monica', 'Lara Ocaña','mlara33.mnl@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$NfBFeiAzk7GZdkve6533SenZGDr9nsHt//O7iCOzinBW8Qtg6icQS',1, 'John', 'Dee','testaut@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);
