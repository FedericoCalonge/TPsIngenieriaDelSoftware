create database BDDenuncias;
use BDDenuncias;
	
-- drop database BDDenuncias;

-- Solo cambie de nombre los id y saco lo del tipo de denuncia. 

create table DenunciaAnimal(
		id_Animal int AUTO_INCREMENT,
		descripcion_denuncia varchar(100),
		observaciones_denuncia varchar(100),
		estado_denuncia varchar(20),
		fecha_denuncia TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- En inserciones toma valor automático, actualizaciones no.
        -- Datos y ubicacion del denunciante:
		nombre_den varchar(30),
		calle_den varchar(30),
		numero_den varchar(30),
		distrito_den varchar(30),
		ciudad_den varchar(30),
		provincia_den varchar(30),
		codigoPostal_den varchar(30),
		telefono_den varchar(30),
        -- Queja de tipo animal:
		tipo_an varchar(30),
		cantidad_an varchar(30),
		fecha_an varchar(30), 
		-- Ubicacion Animal:
		calle_an varchar(30),
		numero_an varchar(30),
		distrito_an varchar(30),
		ciudad_an varchar(30),
		provincia_an varchar(30),
		codigoPostal_an varchar(30),
		telefono_an varchar(30),
        constraint pk_DenunciaA primary key (id_Animal)
);

create table DenunciaComida(
		id_Comida int AUTO_INCREMENT,
		descripcion_denuncia varchar(100),
		observaciones_denuncia varchar(100),
		estado_denuncia varchar(20),
		fecha_denuncia TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- En inserciones toma valor automático, actualizaciones no.
        -- Datos y ubicacion del denunciante:
		nombre_den varchar(30),
		calle_den varchar(30),
		numero_den varchar(30),
		distrito_den varchar(30),
		ciudad_den varchar(30),
		provincia_den varchar(30),
		codigoPostal_den varchar(30),
		telefono_den varchar(30),
         -- Queja de tipo comida:
		nombreVictima varchar(30),
		cantVictimas varchar(30),
		cantEnfermos varchar(30),
		cantInternados varchar(30),
		cantMuertos varchar(30),
		comida varchar(30),
		-- Ubicacion comida (Hospital):
		calle_hospi varchar(30),
		numero_hospi varchar(30),
		distrito_hospi varchar(30),
		ciudad_hospi varchar(30),
		provincia_hospi varchar(30),
		codigoPostal_hospi varchar(30),
		telefono_hospi varchar(30),
		-- Ubicacion comida (Victima):
		calle_vic varchar(30),
		numero_vic varchar(30),
		distrito_vic varchar(30),
		ciudad_vic varchar(30),
		provincia_vic varchar(30),
		codigoPostal_vic varchar(30),
		telefono_vic varchar(30),
        constraint pk_DenunciaC primary key (id_Comida)
);
        
create table DenunciaEspecial(
	-- Datos de cualquier queja sin importar el tipo:
	id_Especial int AUTO_INCREMENT,
    descripcion_denuncia varchar(100), -- La pk de cliente.
	observaciones_denuncia varchar(100),
    estado_denuncia varchar(20),
    fecha_denuncia TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- En inserciones toma valor automático, actualizaciones no.
	-- Datos y ubicacion del denunciante:
	nombre_den varchar(30),
    calle_den varchar(30),
	numero_den varchar(30),
	distrito_den varchar(30),
	ciudad_den varchar(30),
	provincia_den varchar(30),
	codigoPostal_den varchar(30),
	telefono_den varchar(30),
   -- Queja especial:
    edad_esp varchar(30),
	nivelAcademico_esp varchar(30),
	ocupacion_esp varchar(30),
	-- Ubicacion especial:
	calle_esp varchar(30),
	numero_esp varchar(30),
	distrito_esp varchar(30),
	ciudad_esp varchar(30),
	provincia_esp varchar(30),
	codigoPostal_esp varchar(30),
	telefono_esp varchar(30),
    constraint pk_DenunciaE primary key (id_Especial)
);

create table Empleado(
 id_Empleado int,
 nombre varchar(50), 
 contraseña varchar(20),
 constraint pk_Empleado primary key (id_Empleado)
);

insert into Empleado values (1,"Fernando","1234");

create table Enfermedad(
	idEnfermedad int,
    descripcion varchar(100),
	sintomas varchar(100),
    duracion varchar(20),

    constraint pk_Enfermedad primary key (idEnfermedad)
);

insert into Enfermedad (idEnfermedad, descripcion, sintomas, duracion)
values (1, "enfermedad1", "sintomas1", "duracion1");

insert into Enfermedad (idEnfermedad, descripcion, sintomas, duracion)
values (2, "enfermedad2", "sintomas2", "duracion2");


-- Especialidad

create table Especialidad(
	idEspecialidad int,
    nombre varchar(100),

    primary key (idEspecialidad)
);

insert into Especialidad values (1, "especialidad1");
insert into Especialidad values (2, "especialidad2");
insert into Especialidad values (3, "especialidad3");
insert into Especialidad values (4, "especialidad4");


-- Hospital

create table Hospital (
    idHospital int,
    nombre varchar(100),
    direccion varchar(100),

    primary key (idHospital)
);

insert into Hospital values (1, "hospital1", "direccion1");
insert into Hospital values (2, "hospital2", "direccion2");
insert into Hospital values (3, "hospital3", "direccion3");


-- EspecialidadesHospital

create table EspecialidadesHospital(
	idHospital int,
    idEspecialidad int,
    
    foreign key (idHospital) references Hospital (idHospital),
    foreign key (idEspecialidad) references Especialidad (idEspecialidad)
);

insert into EspecialidadesHospital values (1,1); -- Hospital 1 tiene especialidad 1.
insert into EspecialidadesHospital values (1,2);
insert into EspecialidadesHospital values (1,3);
insert into EspecialidadesHospital values (1,4);
insert into EspecialidadesHospital values (2,3);
insert into EspecialidadesHospital values (3,2);
insert into EspecialidadesHospital values (3,3);
insert into EspecialidadesHospital values (3,4);