-- lato client
create table utente(
nome varchar2(30) not null,
cognome varchar2(30) not null,
indirizzo varchar2(50) not null,
cap char(5) not null,
nascita date not null,
username varchar2(10),
password varchar2(100) not null,
email varchar2(50) not null,
constraint p_user primary key(username));

create table articolo(
id_articolo int,
marca varchar2(30) not null,
modello varchar2(30) not null,
prezzo number(7,2) not null,
constraint p_idarticolo primary key(id_articolo));

create table immagine(
id_img int primary key references articolo(id_articolo),
url varchar(30) not null,
descrizione varchar2(100));

create table ordine(
id_ordine int,
totale number(8,2) not null,
data date not null,
username varchar2(10),
constraint p_idordine primary key(id_ordine),
constraint f_username foreign key(username) references utente(username) on delete cascade);

create table ordine_articolo(
id_ordine int,
id_articolo int,
quantita number(3) default 1,
constraint f_idordine foreign key(id_ordine) references ordine(id_ordine) on delete cascade,
constraint f_idarticolo foreign key(id_articolo) references articolo(id_articolo) on delete cascade,
constraints p_oa primary key(id_ordine, id_articolo));

-- lato admin
create table amministratore(
username varchar2(10) not null,
password varchar2(100) not null,
email varchar2(50) not null,
constraint p_admin primary key(username));

create view report as
select utente.username, email, ordine.id_ordine, totale, sum(quantita) as quantita
from ordine, articolo, utente, ordine_articolo
where
ordine.id_ordine = ordine_articolo.id_ordine
and
articolo.id_articolo = ordine_articolo.id_articolo
and
utente.username = ordine.username
group by utente.username, email, ordine.id_ordine, totale
order by utente.username, ordine.id_ordine;

-- sequenze
create sequence ordine_seq;
create sequence articolo_seq;
create sequence immagine_seq;
