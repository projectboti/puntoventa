--Insertar datos en categoria
Insert into categoria(nombre) values('CERVEZA'),('VINO (TINTO)'),('RON'),('PISCO'),('VODKA')

--Insertar datos en Producto
Insert into producto(cod_prod, nombre, descripcion, stock, categoria_id, precio)
values('CVKL1829', 'CERVEZA KUNSTMAN LAGER', 'CERVEZA LAGER', 20, 1,1990),
('RNBB8722', 'RON BAKARDI', 'RON BLANCO', 20, 3, 6990),
('VCDT5654', 'VINO CASILLERO DEL DIABLO', 'VINO TINTO', 20, 2, 2990),
('PAC57987', 'ALTO DEL CARMEN 40°', 'PISCO NACIONAL', 20, 4, 5990)

--Insertar Usuario
Insert into usuario(usuario, nombre, ap_paterno, ap_materno, fono, contraseña, vigente, tipo)
values('s.bustos', 'Sebastian', 'Bustos', 'Pizarro', 91924875, '1234',1,1)

--Insertar Tipo Usuario
Insert usuario_tipo(tipo) values('ADMINISTRADOR')

--Insertar Venta
Insert into Venta(cod_venta, monto, fecha, usuario, medio_pago)
values('v1', 8980,GETDATE(),'s.bustos',2)

--Insertar detalle venta
Insert into venta_detalle(cantidad, cod_venta, cod_prod)
values (1,'v1','PAC57987'),(1,'v1','VCDT5654')

--Insertar medio de pago
Insert into medio_pago(nombre) values('EFECTIVO'),('CREDITO'),('CHEQUE')
