INSERT INTO ROL(rol_nombre, rol_descripcion, status) VALUES ('ADMINISTRADOR', 'ADMIN', 1);

INSERT INTO USUARIO(usuario_nombre, usuario_contrasena, rol_id, status) VALUES ('user', '$2a$10$jf2X7t0le91Xx1Oq7Wg4G.6AliZNuvv1.zAkZnWo4iiDmhlsi6LFW', 1, 1);

INSERT INTO SUCURSAL (nombre) values ('CDMX');
INSERT INTO SUCURSAL (nombre) values ('TOLUCA');
INSERT INTO SUCURSAL (nombre) values ('PACHUCA');

INSERT INTO PRODUCTOS (codigo, descripcion, precio) VALUES ('18156', 'Esmeriladora angular', 625);
INSERT INTO PRODUCTOS (codigo, descripcion, precio) VALUES ('17193', 'Pala redonda', 100.50);
