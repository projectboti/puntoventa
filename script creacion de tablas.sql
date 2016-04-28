Create table usuario_tipo(id int identity(1,1) primary key, tipo varchar(20))

Create table usuario(usuario varchar(20) primary key, nombre varchar(20), ap_paterno varchar(20), 
ap_materno varchar(20), fono int, contraseña varchar(20), vigente bit, TIPO INT FOREIGN KEY REFERENCES USUARIO_TIPO(ID))

Create table categoria(id int identity(1,1) primary key, nombre varchar(20))

Create table producto(cod_prod varchar(20) primary key, nombre varchar(50), descripcion varchar(50), stock int, categoria_id int foreign key references categoria(id), precio int)

Create table venta(cod_venta varchar(20) primary key, monto int, fecha datetime, usuario varchar(20) foreign key references usuario(usuario), medio_pago int foreign key references medio_pago(id))

Create table venta_detalle(id int identity(1,1) primary key, cantidad int, cod_venta varchar(20) foreign key references venta(cod_venta), cod_prod varchar(20) foreign key references producto(cod_prod))

Create table medio_pago(id int identity(1,1) primary key, nombre varchar(20))