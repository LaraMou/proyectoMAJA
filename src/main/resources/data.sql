INSERT INTO `expertos` (`id`, `contacto_linkedin`, `autonomo`, `created_date`, `contacto_ciudad`, `disponibilidad`, `contacto_email`, `estado`, `last_modified_date`, `modalidad`, `motivo`, `nif`, `nombre`, `observaciones`, `origen`, `condiciones_porcentaje`, `condiciones_precio_hora`, `puntuacion`, `contacto_telefono`) VALUES (NULL, NULL, 'Y', '2021-04-18 16:05:09.391887', NULL, 'mañanas', 'test@gmail.com', NULL, '2021-04-18 16:05:09.391887', NULL, NULL, '12345678V', 'ruben alavarez', NULL, NULL, NULL, NULL, NULL, '65217777');
INSERT INTO `etiquetas` (`nombre`) values ('java');
INSERT INTO `etiquetas` (`nombre`) values ('sql');
INSERT into `expert_tag`  (`expert_id`, `tag_id`) VALUES (1,1);
INSERT into `expert_tag`  (`expert_id`, `tag_id`) VALUES (1,2);


-- password: imagina


insert into user (username, email, password) values ('alan', 'alan@alan', '$2a$10$qINz45KQzkLHtzOovvgjn.y1SKh8zfR5Meyh61FHz3bvSlO4uez.O');
