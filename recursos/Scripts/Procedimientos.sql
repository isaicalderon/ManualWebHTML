create or replace PROCEDURE       "PRO_GET_ALUMNO" 
(vAlum OUT SYS_REFCURSOR,
  pMatricula IN ALUMNOS.MATRICULA%TYPE)
  IS
BEGIN

  OPEN vAlum FOR
    SELECT ALU.*
    FROM ALUMNOS ALU
    where ALU.MATRICULA = pMatricula;
    
END;

create or replace PROCEDURE       "PRO_GET_ALL_ALUMNOS" 
(vAlum OUT SYS_REFCURSOR)
  IS
BEGIN

  OPEN vAlum FOR
    SELECT ALU.*
    FROM ALUMNOS ALU;
    
END;

create or replace PROCEDURE       "PRO_EDIT_ALUMNO" 
(pMatricula in ALUMNOS.MATRICULA%TYPE,
pNombres IN ALUMNOS.NOMBRES%TYPE,
 pApellidoPaterno IN ALUMNOS.APELLIDOPATERNO%TYPE,
 pApellidoMaterno IN ALUMNOS.APELLIDOMATERNO%TYPE,
 pModificadoPor IN ALUMNOS.MODIFICADOPOR%TYPE
)
  IS
  
  --PRO_EDIT_ALUMNO
--Actualiza un registro en la tabla ALUMNOS.  
BEGIN
    UPDATE ALUMNOS 
	SET NOMBRES=pNombres, APELLIDOPATERNO=pApellidoPaterno, APELLIDOMATERNO=pApellidoMaterno, MODIFICADOPOR=pModificadoPor, FECHAHORAMODIFICACION = sysdate
	WHERE MATRICULA = pMatricula;
END;

create or replace PROCEDURE       "PRO_DEL_ALUMNO" 
(pMatricula IN ALUMNOS.MATRICULA%TYPE)
  IS
  
--PRO_DEL_ALUMNO
--Elimina un registro en la tabla ALUMNOS.   
BEGIN

    DELETE
    FROM ALUMNOS
    WHERE MATRICULA = pMatricula;
	
END;