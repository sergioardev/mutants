# mutants
MeLi Challenge

# Detector de Mutantes (Hasta nivel 2)

API Rest que detecta si un humano es mutante en base a la secuencia de su ADN. 

_________________________________________________

## Instrucciones

### Descarga y ejecución (de forma local): 
Se asume que tiene git instalado y maven instalados.

Clone el repositorio ejecutando desde su terminal:
git clone https://github.com/sergioardev/mutants.git

Dirijase a la carpeta "mutants":
cd mutants

Para correr compilar la aplicación y correr los tets, ejecute:
mvn clean install

Una vez que finalice la descarga de las dependencias del proyecto y se compile en un jar, ejecute:
cd target
java -jar mutants-0.0.1-SNAPSHOT

Iniciará el servicio en el puerto 8090.


### Servicio Mutant: 

Consume un JSON compuesto por un único campo "dna" que incluye un array de strings con la secuencia de ADN.
En función de los datos de ADN el servicio responde OK:200 (si es un mutante), 403:Forbiden (si no es mutante) o 400:Bad request si la secuenquecia de ADN no se puede representar como una matriz cuadrada de N x N. 

- URL: http://ec2-54-163-91-157.compute-1.amazonaws.com:8090/mutant
- Method: POST
- Body Params: {"dna": [[string], [string], [string], ...]}

  Ejemplo:
  {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}
