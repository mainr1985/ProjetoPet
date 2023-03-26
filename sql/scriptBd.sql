/*Criação do BD*/
create database petfree1;

/*Conectando com o BD*/
\c petfree1;

/*********  CRIAÇÃO DOS ENUMS  *******/

/*Enum Especie pra tabela paciente*/
CREATE TYPE TIPOESPECIE AS ENUM ( 'CANINO','FELINO' );

/*Enum TipoFuncionario*/
CREATE TYPE TIPOFUNCIONARIO AS ENUM ('VETERINARIO','ASSISTENTE', 'ADMINISTRADOR');

/* CONSULTA AOS ENUMS 
SELECT enum_range(NULL::nomeenum)*/

/*********  CRIAÇÃO DAS TABELAS  *******/

/*Tabela Funcionario*/
CREATE TABLE IF NOT EXISTS funcionario ( id_funcionario serial NOT NULL, cpf varchar(14) NOT NULL, rg varchar(14) NOT NULL,
                                         nome character varying(50), endereco character varying(50), complemento character varying(40),
                                         cidade character varying(40), cargo character varying(30), nomeusuario character varying(20),
                                         senha character varying(10), permissao character varying(30), email character varying(30),
                                         dtnascimento date, dtadmissao date, dtdemissao date, tipo_funcionario tipofuncionario not null,
                                         CONSTRAINT funcionario_pkey PRIMARY KEY (id_funcionario),
                                         CONSTRAINT funcionario_cpf_key UNIQUE (cpf) );

/*Tabela Veterinário*/
create table if not exists veterinario ( crmv numeric not null primary key, id_funcionario integer not null,
                                         especialidade varchar(100) not null,
                                         constraint fk_idfuncionario foreign key (id_funcionario) references funcionario(id_funcionario) );

/*Tabela Tutor*/
create table IF NOT EXISTS tutor ( codtutor serial not null primary key, cpf numeric not null, rg numeric not null,
                                   nome varchar(50) not null, endereco varchar(50) not null, numero numeric not null,
                                   complemento varchar(30), bairro varchar(50) not null, cidade varchar(50) not null,
                                   cargo varchar(30) not null, dtcadastro Date not null, telefone numeric,
                                   celular numeric, email varchar(50) not null );

/*Tabela Paciente*/
create table IF NOT EXISTS paciente ( codpaciente serial not null primary key, nome varchar(40) not null, apelido varchar(30) not null,
                                     sexo char not null, dtnasc date, idade varchar(30) not null, raca varchar(40) not null,
                                     especie tipoespecie not null, cor varchar(30) not null, esterelizado char not null,
                                     porte varchar(30) not null, codtutor integer not null );

/*Adicionando a Fk de tutor em paciente*/   
alter table paciente add constraint fk_codtutor foreign key (codtutor) references tutor(codtutor);

/*Tabela Paciente_Tutor*/
CREATE TABLE IF NOT EXISTS paciente_tutor ( codpaciente integer NOT NULL, codtutor integer NOT NULL, 
                                            CONSTRAINT pk_paciente_tutor PRIMARY KEY (codpaciente, codtutor),
                                            CONSTRAINT fk_codpaciente FOREIGN KEY (codpaciente) REFERENCES paciente (codpaciente),
                                            CONSTRAINT fk_codtutor FOREIGN KEY (codtutor) REFERENCES tutor (codtutor) );

/*Tabela Aferição*/
create table if not exists afericao (codafericao serial not null primary key,
				     responsavel varchar(40) not null,
				     crmv_responsavel integer not null,
				     dhafericao timestamp without time zone not null,
				     temp_min integer not null,
                                     temp_max integer not null,
				     equipamento varchar(30) not null,
				     observacoes varchar(300) not null,
				     constraint fk_crmv_responsavel foreign key (crmv_responsavel) references veterinario(crmv));