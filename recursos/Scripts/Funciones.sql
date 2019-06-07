create or replace FUNCTION       "FUN_ADD_ALUMNO" 
(
pNombres in ALUMNOS.NOMBRES%TYPE,
pApellidoPaterno in ALUMNOS.APELLIDOPATERNO%TYPE,
pApellidoMaterno in ALUMNOS.APELLIDOMATERNO%TYPE,
pCreadoPor in ALUMNOS.CREADOPOR%TYPE
)
RETURN NUMBER
  IS
  vMatricula NUMBER;
  
--FUN_ADD_ALUMNO
--Agrega un registro en la tabla ALUMNOS.   
--Regresa la matricula insertada.
BEGIN

  vMatricula:=FUN_GET_NEXT_MATRICULA;
  
  INSERT INTO CSA.ALUMNOS(MATRICULA,NOMBRES,APELLIDOPATERNO,APELLIDOMATERNO,ACTIVO,CREADOPOR,FECHAHORACAPTURA,FECHAHORAMODIFICACION) 
	VALUES(vMatricula,pNombres,pApellidoPaterno,pApellidoMaterno,'Si',pCreadoPor,SYSDATE,SYSDATE);
	       
   RETURN vMatricula;
END;