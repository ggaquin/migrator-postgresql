/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     18/07/2010 11:20:54 p.m.                     */
/*==============================================================*/


drop table aportes;

drop table creditos;

drop table cuotas;

drop table cuo_pagadas;

drop table det_pagos;

drop table pagos;

drop table socios;

drop table solicitudes;

drop table tip_creditos;

drop table tip_documento;

drop table tip_pagos;

drop domain apellido;

drop domain cuota;

drop domain descripcion;

drop domain fecha;

drop domain monto;

drop domain nombres;

drop domain nro_documento;

drop domain pk_id;

/*==============================================================*/
/* Domain: apellido                                             */
/*==============================================================*/
create domain apellido as varchar(30);

comment on domain apellido is
'Apellidos';

/*==============================================================*/
/* Domain: cuota                                                */
/*==============================================================*/
create domain cuota as numeric(3);

comment on domain cuota is
'Campos de cuotas';

/*==============================================================*/
/* Domain: descripcion                                          */
/*==============================================================*/
create domain descripcion as varchar(25);

comment on domain descripcion is
'Campo de descripcion ';

/*==============================================================*/
/* Domain: fecha                                                */
/*==============================================================*/
create domain fecha as date;

comment on domain fecha is
'Fechas';

/*==============================================================*/
/* Domain: monto                                                */
/*==============================================================*/
create domain monto as numeric(20,2);

comment on domain monto is
'Campos de montos';

/*==============================================================*/
/* Domain: nombres                                              */
/*==============================================================*/
create domain nombres as varchar(30);

comment on domain nombres is
'Nombres';

/*==============================================================*/
/* Domain: nro_documento                                        */
/*==============================================================*/
create domain nro_documento as varchar(15);

comment on domain nro_documento is
'Numero de documentos';

/*==============================================================*/
/* Domain: pk_id                                                */
/*==============================================================*/
create domain pk_id as varchar(10);

comment on domain pk_id is
'Dominio para todos los campos que son ID de tablas';

/*==============================================================*/
/* Table: aportes                                               */
/*==============================================================*/
create table aportes (
   nro_socio            pk_id                null,
   monto                monto                null
);

comment on table aportes is
'Tabla con los montos de aportes de los socios';

/*==============================================================*/
/* Table: creditos                                              */
/*==============================================================*/
create table creditos (
   nro_credito          pk_id                not null,
   nro_solicitud        pk_id                not null,
   cod_tip_credito      pk_id                null,
   fec_desmbolso        fecha                null,
   mon_total            monto                null,
   constraint pk_creditos primary key (nro_credito)
);

comment on table creditos is
'Detalle de los creditos desembolsados
';

/*==============================================================*/
/* Table: cuotas                                                */
/*==============================================================*/
create table cuotas (
   nro_cuota            pk_id                not null,
   nro_credito          pk_id                null,
   can_cuota            cuota                null,
   mon_cuota            monto                null,
   fec_ult_cuo_pagada   fecha                null,
   sal_cuota            monto                null,
   constraint pk_cuotas primary key (nro_cuota)
);

comment on table cuotas is
'Tabla con las cuotas generadas por los creditos desembolsados a los socios';

/*==============================================================*/
/* Table: cuo_pagadas                                           */
/*==============================================================*/
create table cuo_pagadas (
   cod_pago             pk_id                null,
   nro_cuota            pk_id                null,
   mon_pagado           monto                null,
   nro_cuo_desde        cuota                null,
   nro_cuo_hasta        cuota                null
);

comment on table cuo_pagadas is
'Detalle de los pagos por cuotas 
';

/*==============================================================*/
/* Table: det_pagos                                             */
/*==============================================================*/
create table det_pagos (
   cod_tip_pago         pk_id                null,
   cod_pago             pk_id                null,
   cod_pag_detalle      pk_id                not null
);

comment on table det_pagos is
'Detalle de los pagos realizados por los socion';

/*==============================================================*/
/* Table: pagos                                                 */
/*==============================================================*/
create table pagos (
   cod_pago             pk_id                not null,
   nro_socio            pk_id                null,
   nro_credito          pk_id                null,
   fec_pago             fecha                null,
   monto                monto                null,
   constraint pk_pagos primary key (cod_pago)
);

comment on table pagos is
'Pagos realizados';

/*==============================================================*/
/* Table: socios                                                */
/*==============================================================*/
create table socios (
   nro_socio            pk_id                not null,
   cod_tip_documento    pk_id                null,
   abreviacion          varchar(5)           null,
   nombres              nombres              null,
   apellidos            apellido             null,
   nro_documento        nro_documento        not null,
   fec_ingreso          fecha                null,
   constraint pk_socios primary key (nro_socio)
);

comment on table socios is
'Tabla de socios de la cooperativa
';

/*==============================================================*/
/* Table: solicitudes                                           */
/*==============================================================*/
create table solicitudes (
   nro_socio            pk_id                null,
   nro_solicitud        pk_id                not null,
   fec_solicitud        fecha                null,
   constraint pk_solicitudes primary key (nro_solicitud)
);

comment on table solicitudes is
'Detalle de las solicitudes de creditos';

/*==============================================================*/
/* Table: tip_creditos                                          */
/*==============================================================*/
create table tip_creditos (
   cod_tip_credito      pk_id                not null,
   descripcion          descripcion          null,
   rel_aporte           numeric(2)           not null,
   max_monto            monto                null,
   constraint pk_tip_creditos primary key (cod_tip_credito)
);

comment on table tip_creditos is
'Tabla con los tipos de creditos disponibles para los socios';

/*==============================================================*/
/* Table: tip_documento                                         */
/*==============================================================*/
create table tip_documento (
   cod_tip_documento    pk_id                not null,
   descripcion          descripcion          null,
   abreviacion          varchar(5)           not null,
   constraint pk_tip_documento primary key (cod_tip_documento, abreviacion)
);

comment on table tip_documento is
'Tabla con los tipos de documentos para las personas';

/*==============================================================*/
/* Table: tip_pagos                                             */
/*==============================================================*/
create table tip_pagos (
   cod_tip_pago         pk_id                not null,
   descripcion          descripcion          null,
   constraint pk_tip_pagos primary key (cod_tip_pago)
);

alter table aportes
   add constraint fk_aportes_reference_socios foreign key (nro_socio)
      references socios (nro_socio)
      on delete restrict on update restrict;

alter table creditos
   add constraint fk_creditos_reference_solicitu foreign key (nro_solicitud)
      references solicitudes (nro_solicitud)
      on delete restrict on update restrict;

alter table creditos
   add constraint fk_creditos_reference_tip_cred foreign key (cod_tip_credito)
      references tip_creditos (cod_tip_credito)
      on delete restrict on update restrict;

alter table cuotas
   add constraint fk_cuotas_reference_creditos foreign key (nro_credito)
      references creditos (nro_credito)
      on delete restrict on update restrict;

alter table cuo_pagadas
   add constraint fk_cuo_paga_reference_pagos foreign key (cod_pago)
      references pagos (cod_pago)
      on delete restrict on update restrict;

alter table cuo_pagadas
   add constraint fk_cuo_paga_reference_cuotas foreign key (nro_cuota)
      references cuotas (nro_cuota)
      on delete restrict on update restrict;

alter table det_pagos
   add constraint fk_det_pago_reference_tip_pago foreign key (cod_tip_pago)
      references tip_pagos (cod_tip_pago)
      on delete restrict on update restrict;

alter table det_pagos
   add constraint fk_det_pago_reference_pagos foreign key (cod_pago)
      references pagos (cod_pago)
      on delete restrict on update restrict;

alter table pagos
   add constraint fk_pagos_reference_creditos foreign key (nro_credito)
      references creditos (nro_credito)
      on delete restrict on update restrict;

alter table pagos
   add constraint fk_pagos_reference_socios foreign key (nro_socio)
      references socios (nro_socio)
      on delete restrict on update restrict;

alter table socios
   add constraint fk_socios_reference_tip_docu foreign key (cod_tip_documento, abreviacion)
      references tip_documento (cod_tip_documento, abreviacion)
      on delete restrict on update restrict;

alter table solicitudes
   add constraint fk_solicitu_reference_socios foreign key (nro_socio)
      references socios (nro_socio)
      on delete restrict on update restrict;

