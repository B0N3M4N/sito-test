insert into articolo values(articolo_seq.nextval, 'Microsoft', 'Windows 10 Pro', 200.00);
insert into articolo values(articolo_seq.nextval, 'Microsoft', 'Windows 10 Home', 150.00);
insert into articolo values(articolo_seq.nextval, 'Apple', 'iPod 5', 300.00);
insert into articolo values(articolo_seq.nextval, 'Asus', 'GL-553VD', 1200.00);
insert into articolo values(articolo_seq.nextval, 'Toshiba', 'Satellite L-655', 800.00);

drop table amministratore cascade constraints
insert into amministratore values('admin', 'b0002Dad002dkadwa029120', 'admin@site.com')