create database BDTPFINAL;
use BDTPFINAL;
	
-- drop database BDTPFINAL;

create table cliente(
	cuit varchar(30), -- La pk de cliente.
	nombre varchar(30),
	telefono	varchar(30),
	domicilio	varchar(30),
	constraint pk_cliente primary key (cuit)
);

create table pedido(
	clave_pedido int AUTO_INCREMENT,
	estado varchar(20),
	maquinaDeCorte varchar(30),
	detalleTrabajo varchar(100),
	fecha_entrega varchar(12),
    cuit2 varchar(30),
	comentario varchar(100),
 -- Es la PK de cliente, aca es FK
    -- Tengo que relacionarlo con el cliente que realiza el pedido -->private Cliente c;
constraint pk_pedido primary key (clave_pedido),
constraint fk_pedido foreign key (cuit2) references cliente (cuit)
   -- Arriba defino a clave_pedido como FK, y la referencio con la clave_cliente que sacamos de  la tabla cliente.
);

-- Eliminar BD --> drop database BDTPFINAL;

-- Si quiero insertar un cliente -->insert into cliente values ("38498594","Imanol S.A.", "42345345", "Jorge 3098");

-- Si quiero insertar un pedido al cliente Imanol -->insert into pedido values (1,"En_Produccion", "1 Kaliburn", "Corte super loco", "12/06/2017","38498594", “comentario”);

-- Muesto todos los datos de cada pedido --> SELECT clave_pedido, estado, maquinaDeCorte, detalleTrabajo, fecha_entrega, cuit2, comentario FROM pedido;

-- Actualizo la maquinaDeCorte del 2do pedido --> UPDATE pedido SET maquinaDeCorte= "1 Kalubrn" WHERE clave_pedido = 2;

-- Muestro el comentario del 1er pedido (like es igual a poner =) --> SELECT comentario FROM pedido WHERE clave_pedido LIKE 1;
