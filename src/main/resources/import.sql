INSERT INTO PROVEEDOR (IDPROVEEDOR, CIUDAD, DIRECCION, NOMBRE, TELEFONO) VALUES (1, 'QUITO', 'EL INCA', 'EDISON', '32842787');
INSERT INTO PROVEEDOR (IDPROVEEDOR, CIUDAD, DIRECCION, NOMBRE, TELEFONO) VALUES (2, 'LATACUNGA', 'SALTO', 'RICHARD', '22842787');

INSERT INTO USUARIO(IDPERSONA,APELLIDOS,CEDULA,NOMBRES,CREADOEN,NOMBRE,CONTRASENIA,HABILITADO)VALUES(1,'Admin','0123456796','Admin','2019-12-23 15:00:00','admin','$2a$10$HUhC7ModOD5ZwQ1KiHqdUO7pHvqkXi8f9gaWWSGKO5eH6goA83L0C',true);
INSERT INTO ROL(IDROL, NOMBRE,IDUSUARIO) VALUES(1,'ROLE_ADMIN',1);