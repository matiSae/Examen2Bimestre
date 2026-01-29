#EPN
##Requerimientos

##Req 1

El sistema inicia por consola solicitando a Usted que se autentique (cédula y clave) / (agregar acceso a: “patmic”,”123”) con máximo 3 intentos.
Si la autenticación es válida se presenta la interfaz gráfica (sección Alumno(s)) y en consola/ExoTracer.txt debe mostrar según corresponda:
GOOD : Acceso concedido  
ERROR: Acceso denegado.  

##Req 2

El  exobot  se  deriva  de  un  sistema  matriz  con  inteligencia  artificial  llamado  IAEXO  que
implementa IIAEXO para garantizar la realización de la AcciónArma según su tipo de exobot.
Su exobot debe ser entrenado según AcciónArma únicamente por soldados expertos en el
uso de cada tipo de arma (TipoArma) bajo la asistencia del IABOT.
Al seleccionar un su tipoExabot y hacer clic en un botón “EntrenarArma” se entrena el su
exobot  y  se  alterna  el  entrenamiento  con  los  soldados  expertos.  Actualizar  la  grilla
(Entreno=”SI”) y en consola/ExoTracer.txt debe mostrar:
GOOD : <SoldadoExpertoArma> <TipoArma> <AcciónArma>
ERROR: <SoldadoExpertoArma> <TipoArma> <AcciónArma>

##Req 3

Definir una extremidad para usar las armas; El arma debe ejecutar su AcciónArma y según
el tipo de munición se debe usar el TipoArma.
Al seleccionar un su tipoExabot y hacer clic en un botón “AcciónArma” debe leer un archivo
“storage/DataFiles/ExoMunision.txt” buscar la munición/Energía que le corresponde a su
armas. Actualizar la grilla (“No. Accion” incrementa en 1 por cada clic) y en
consola/ExoTracer.txt debe mostrar:
GOOD : <TipoArma> <AcciónArma>  <munición/Energía>
ERROR: <TipoArma> <AcciónArma>  <munición/Energía>

##Req4

Mostrar un formulario “ExoTrooper” con los componentes detallados en el prototipo y la opción de agregar TipoExobot. 