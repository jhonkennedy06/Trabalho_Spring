insert into categoria (nome) values ('Vestuário');
insert into categoria (nome) values ('Locomoção');
insert into categoria (nome) values ('Lazer');
insert into categoria (nome) values ('Alimentação');
insert into categoria (nome) values ('Saúde');
insert into categoria (nome) values ('Educação');
insert into categoria (nome) values ('Moradia');

insert into meta_categoria (limite, controle, categoria_id) values (500.00, false, 4);
insert into meta_categoria (limite, controle, categoria_id) values (600.00, false, 7);
insert into meta_categoria (limite, controle, categoria_id) values (100.00, false, 1);
insert into meta_categoria (limite, controle, categoria_id) values (200.00, false, 2);


insert into fatura (valor_total, parcelas, categoria_id, faturado) values (300.00, 2, 4, true);
insert into fatura (valor_total, parcelas, categoria_id, faturado) values (200.00, 1, 7, true);
insert into fatura (valor_total, parcelas, categoria_id, faturado) values (100.00, 2, 2, true);


insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) values (150.0, utc_timestamp, 1, '2023-09-01 00:00:00', '2023-10-01 00:00:00',1);
insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) values (150.0, utc_timestamp, 2, '2023-09-02 00:00:00', '2023-10-02 00:00:00',1);
insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) values (200.0, utc_timestamp, 1, '2023-09-03 00:00:00', '2023-10-03 00:00:00',2);
insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) values (50.0, utc_timestamp, 1, '2023-09-04 00:00:00', '2023-10-04 00:00:00',3);
insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) values (50.0, utc_timestamp, 2, '2023-09-05 00:00:00', '2023-10-05 00:00:00',3);









