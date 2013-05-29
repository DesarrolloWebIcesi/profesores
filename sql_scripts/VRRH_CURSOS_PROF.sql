DROP MATERIALIZED VIEW PSISRHP.VRRH_CURSOS_PROF;
CREATE MATERIALIZED VIEW PSISRHP.VRRH_CURSOS_PROF (PROFESOR_CEDULA,PERIODO_PERIODO_ACAD,PERIODO_CONSECUTIVO,MATERIA_CODIGO,MATERIA_CONSECUTIVO,MATERIA_NOMBRE,GRUPO,ACTIVIDAD,DEPTO_ACAD,SE_PAGA,MES_PAGO,HORAS_MES,HORAS_X_SEMANA,SEMANAS,FECHA_INI_CONTRATO,FECHA_FIN_CONTRATO,ACTIVO,STD_ID_PERSON,MAT_N_ENG)
TABLESPACE TABLAS_DELFI
PCTUSED    0
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          6M
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOCACHE
LOGGING
NOCOMPRESS
NOPARALLEL
BUILD IMMEDIATE
REFRESH COMPLETE ON DEMAND
WITH PRIMARY KEY
AS 
/* Formatted on 23/05/2013 09:44:29 a.m. (QP5 v5.240.12305.39476) */
select cur.profesor_cedula, cur.periodo_periodo_acad, cur.periodo_consecutivo, cur.materia_codigo, cur.materia_consecutivo,
       cur.materia_nombre, cur.grupo, cur.actividad, cur.depto_acad, cur.se_paga, cur.mes_pago, cur.horas_mes, cur.horas_x_semana,
       cur.semanas, cur.fecha_ini_contrato, cur.fecha_fin_contrato, cur.activo, per.std_id_person,
       fprebus_descrip_mat (cur.materia_consecutivo, cur.materia_codigo, '09', '') mat_n_eng
  from trrh_cursos_prof cur, std_person per
where per.std_ssn(+) = cur.profesor_cedula
union
select nov.profesor_cedula, nov.periodo_periodo_acad, nov.periodo_consecutivo, nov.materia_codigo, nov.materia_consecutivo,
       nov.materia_nombre, nov.grupo, null, null, null, nov.mes_pago, nov.horas_mes, null, null, nov.fecha_ini_contrato,
       nov.fecha_fin_contrato, nov.activo, per.std_id_person,
       fprebus_descrip_mat (nov.materia_consecutivo, nov.materia_codigo, '09', '') mat_n_eng
  from trrh_novedades_pro nov, std_person per
where nov.concepto_codigo = '303'
   and per.std_ssn(+) = nov.profesor_cedula;

COMMENT ON MATERIALIZED VIEW PSISRHP.VRRH_CURSOS_PROF IS 'snapshot table for snapshot SISRHP.VRRH_CURSOS_PROF';
 
CREATE OR REPLACE SYNONYM PDELFI.VRRH_CURSOS_PROF FOR PSISRHP.VRRH_CURSOS_PROF;
 
CREATE OR REPLACE SYNONYM CONSULTAHVPROF.VRRH_CURSOS_PROF FOR PSISRHP.VRRH_CURSOS_PROF;

GRANT SELECT ON PSISRHP.VRRH_CURSOS_PROF TO CONSULTAHVPROF;
