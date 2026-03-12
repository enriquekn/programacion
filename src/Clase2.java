import java.util.Scanner;

public class Clase2 {

/* Clases: Archivo mínimo necesario para albergar código, todo el código esta dentro de clases. Representan parte del problema que queremos solucionar con un software.
Lo que hay en la BBDD tiene que verse representado en el código mediante clases. En cada clase creas objetos, la clase es el "molde"
a través del cuál creas distintos objetos.
    - Principales -> Vive y ejecuta código directamente
    -
En este caso el objetivo no es crear objetos, sino crear un código y ejecutarlo. Es una clase principal.

[] Atributos de una clase: Variables para guardar datos y memoria, nos permiten realizar las funciones que queremos que realice la clase.
[] Constante: variables que no pueden ser modificadas una vez que han sido asignadas. SIEMPRE EN MAYÚSCULA
    - final -> Le damos un valor y lo que declaramos a continuación es una constante, no pueden cambiar en ejecución y hay que inicializaralas obligatoriamente.
    Para poder hacer referencia por ejemplo a NOTA_APROBADO, tendría que crear un objeto de la clase: "Clase2.NOTA_APROBADO"
    - static -> Me permite utilizar variables, constantes y funciones sin necesidad de crear objetos, pertenecen a la clase, no hace falta crear un objeto.
    Es superior a cualquier objeto creado. Imagina que tenemos.
    1 Clase Coche
    1.1 String marca        Para poder definir estos strings tengo que crear una objeto pero con static, la variable creada es superior
    1.2 String modelo       a estos objetos. Por ejemplo -> static int num_coches es superior a los objetos, no depende de ellos, depende de la clase "coches".
                            Esta superioridad se la da la palabra static, hace que sea independiente de creación de objetos, pertenece a la clase.
                            Para poner un ejemplo, sería como la propiedad "nº alumno" que es genérica, y el propio número de cada alumno.


----------
(double) siempre para décimales para no forzar la f de float
Compiladores lineales/secuenciales: leen el código de arriba a abajo, si la función no la declaras encima de donde la utilizas no funcionaría, como en C, C++, Javascript.
Babeling? -> La función sube de abajo a arriba. En Java no, hace una lectura global y reconoce todas las funciones.
Sobrecarga de funciones -> Permite definir múltiples funciones con el mismo nombre dentro de una clase siempre que tengan distintos parámetros
Las funciones nos permiten que si cambia el nombre/lógica de este código sólo la cambiamos una vez y no en cada una de las veces que se utiliza. Por ej: el sout en sí es una función.
Las variables y parámetros de entrada solo existen dentro de la función, no se pueden referenciar fuera.
clic derecho -> Go To -> Implementations [Para ver de donde viene o donde está referenciada la función]
Debug -> Ir paso a paso en el código viendo lo que pasa.
 */

    static final double NOTA_APROBADO = 5.0; // double por que puede ser decimal, siempre se pone en decimal. Static por que sino no se podría hacer referencia a esta variable en "Clase2" sin previamente crear un objeto dentro de "Clase2".
    static final double IVA = 0.10;
    static final double PRECIO_BASE = 500.0;
    static final double DESC_FAM_NUM = 0.10;

    static String nombre;                     // String -> Vector de caracteres, sirve para meter texto (letras y números) pero no opera matemáticamente con los números, es un identificador. Al no ser constante, puedo pedirlo después al usuario.
    static int edad;                          // int -> Números enteros
    static double nota1;                      // Double -> Decimales
    static double nota2;

    static boolean familiaNumerosa;           // Boolean -> True (1) or False(0). Se utilizan para hacer evaluaciones.

    static Scanner sc = new Scanner(System.in); // Objeto -> Es parte generada por una clase nativa de Java. Scanner es una clase nativa/función de Java, new -> Para crear objetos, System.in -> Entra información. Lo declaro para poder meter contenido a través del teclado.

    static void main() {                      // Abreviatura "psvm"
        saludar();                            // Llama a la función "saludar".
        saludar("Pepe");              // Sabe que se refiere a la segunda función de saludar ya que tiene el parámetro de entrada con String. Tiene que coincidir en tipo y número que haya definido.
        System.out.println(saludar("Pepe", "Rodríguez"));   // El sout tiene que rodear el saludar para que aparezca, ya que de por sí es sólamente un string.
        leerDatos();
        System.out.println(nombre);           // Ponemos la variable nombre que es la que hemos declarado en leerDatos, la que detecta lo que se ha introducido por teclado.
        saludar(nombre);                      // Se utiliza el primer saludar ya que no tiene parámetros de entrada que coincidan con los otros.
        saludar(nombre, "Korner");
        System.out.println(saludar(nombre, "Korner"));  // La función sin el sout no devuelve el apellido ya que dentro de la función "saludar(string, string)" no pone sout, sino return.
    }



    /*
    Función -> Acción ya definida, Código que se va a repetir. FUERA del main ya que main es otra función.
    Con void = La función no devuelve nada
    */

    static void saludar(){
            System.out.println("Hola");
        }


    static void saludar(String nombre){              // Función con parámetros de entrada -> Ponemos tipo de dato "String", y la variable "nombre" sólo se mantiene dentro de esta función, es un parámetro de esta función y es totalmente independiente de todo lo que hay en el exterior.
        System.out.println("Hola " + nombre);        // Operación de concatenación de Strings
    }

    static String saludar(String nombre, String apellido){              // Cambio "void" -> "String": Nos devuelve un String. No es suficiente para que lo distinga del "saludar" anterior. La sobrecarga sólo afecta en los parámetros de entrada, no de salida. Añadimos un segundo parámetro para que puedan convivir las 3.
        String mensaje = "Hola " + nombre + " " + apellido + "!" ;      // Me debe devolver un String, por lo que le quito el sout, y declaramos String mensaje.
        return mensaje;                                                 // return -> Como nos tiene que devolver un string, nos lo manda. Lo que pongo en el return tiene que coincidir con el tipo de dato que le digo que me tiene que devolver.
    }

    static void leerDatos(){
        System.out.println("Nombre: ");
        nombre = sc.nextLine(); // Lo que declare en una función solo vive en la función, pero dentro de esta función puedo hacer referencia a variables que están declaradas fuera. nextLine -> lo que escribes por consola directamente lo introduce.
    }
}
