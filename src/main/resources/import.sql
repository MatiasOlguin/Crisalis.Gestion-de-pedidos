/* poblar usuarios y roles */
INSERT INTO usuarios (id, username, password) VALUES(1, 'Crisalis', '$2a$10$kLtNhyZCW4QAye1jqTQFleTNcqScAcQI7pCuFe4ediVakaePUfxuG')
INSERT INTO roles (id, role_name) VALUES(1, 'ROLE_ADMIN')
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1)

/* poblar personas */
INSERT INTO personas (id, nombre, apellido, dni, create_at) VALUES(1, 'Matias', 'Olguin', '12.345.678', '2022-12-11')
INSERT INTO personas (id, nombre, apellido, dni, create_at) VALUES(2, 'Nahuel', 'Perez', '12.345.679', '2022-12-11')

/* poblar productos */
INSERT INTO ofertas (oferta_tipo, id, monto_base, descripcion, anios_garantia, marca, modelo, cantidad) VALUES ('producto',1, '50000','Celular','2','Samsung','A13',2)
INSERT INTO ofertas (oferta_tipo, id, monto_base, descripcion, anios_garantia, marca, modelo, cantidad) VALUES ('producto',2, '45000','Celular','2','Motorola','G22',3)

/* poblar servicios */
INSERT INTO ofertas (oferta_tipo, id, monto_base, descripcion, tipo_servicio, cargo_soporte) VALUES ('servicio',3, '2000','Internet', 'Móvil',500)
INSERT INTO ofertas (oferta_tipo, id, monto_base, descripcion, tipo_servicio) VALUES ('servicio',4, '1000','Internet', 'Hogar')

/*poblar pedidos*/
INSERT INTO pedidos (id,create_at, estado, monto_total, persona_id) VALUES (1, NOW(), 0, 15000, 1)