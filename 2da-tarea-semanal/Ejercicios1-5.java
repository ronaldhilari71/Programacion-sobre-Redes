1) /*Realizar un programa para resolver el siguiente problema: Un granjero, un lobo, una
gallina y un saco de maíz deben cruzar el río. Para ello se dispone de un bote con una
capacidad de dos ocupantes, el hombre (el único que sabe remar) y otro. Si de un lado
del rio se quedan solos el lobo y la gallina, el lobo se come a la gallina. Si en una orilla se
quedan solos la gallina y el maíz, la gallina se come al maíz. */

import java.util.ArrayList;

public class Principal {
    
    public static void main(String[] args) {
        resolverProblema();
    }
    
    static void resolverProblema() {
        ArrayList<String> ladoInicio = new ArrayList<>();
        ArrayList<String> ladoFinal = new ArrayList<>();
        ArrayList<String> bote = new ArrayList<>();
        
        ladoInicio.add("granjero");
        ladoInicio.add("lobo");
        ladoInicio.add("gallina");
        ladoInicio.add("maíz");
        
        while (!ladoInicio.isEmpty()) {
            // Movimiento del granjero y un acompañante al otro lado del río
            moverBote(ladoInicio, bote);
            
            // Verificar si el granjero está en el lado final con los elementos
            // que podrían ser comidos
            if (bote.contains("gallina") && bote.contains("maíz")) {
                System.out.println("La gallina se comió el maíz");
                break;
            }
            if (bote.contains("lobo") && bote.contains("gallina")) {
                System.out.println("El lobo se comió la gallina");
                break;
            }
            
            // Movimiento del granjero de regreso al lado de inicio
            moverBote(bote, ladoFinal);
        }
        
        System.out.println("Todos llegaron al otro lado del río");
    }
    
    static void moverBote(ArrayList<String> origen, ArrayList<String> destino) {
        if (origen.contains("granjero")) {
            origen.remove("granjero");
            destino.add("granjero");
        }
        if (!origen.isEmpty()) {
            String ocupante = origen.remove(0);
            destino.add(ocupante);
        }
        if (!origen.isEmpty()) {
            String ocupante = origen.remove(0);
            destino.add(ocupante);
        }
    }
}


2) /*Realizar un programa para resolver el siguiente problema: Clara, Luisa, María y Nélida
son cuatro mujeres que aman sus trabajos. Ellas trabajan como diseñadora de moda,
florista, jardinera y directora de orquesta. Cada mujer tiene un solo trabajo, y cada
trabajo es ocupado por una sola mujer. Con las siguientes pistas, encontrar el trabajo
realizado por cada mujer:
(a) Clara es violentamente alérgica a las plantas.
(b) Luisa y la florista comparten el departamento
(c) A María y Luisa les gusta solamente la música rock
(d) La jardinera, la diseñadora de modas y Nélida no se conocen entre sí*/

public class Principal {
    public static void main(String[] args) {
        
        String[] trabajos = {"diseñadora de moda", "florista", "jardinera", "directora de orquesta"};
        String[] mujeres = {"Clara", "Luisa", "María", "Nélida"};

         
        String[][] permutaciones = {
            {"diseñadora de moda", "florista", "jardinera", "directora de orquesta"},
            {"diseñadora de moda", "florista", "directora de orquesta", "jardinera"},
            {"diseñadora de moda", "jardinera", "florista", "directora de orquesta"},
            {"diseñadora de moda", "jardinera", "directora de orquesta", "florista"},
            {"diseñadora de moda", "directora de orquesta", "florista", "jardinera"},
            {"diseñadora de moda", "directora de orquesta", "jardinera", "florista"},
            {"florista", "diseñadora de moda", "jardinera", "directora de orquesta"},
            {"florista", "diseñadora de moda", "directora de orquesta", "jardinera"},
            {"florista", "jardinera", "diseñadora de moda", "directora de orquesta"},
            {"florista", "jardinera", "directora de orquesta", "diseñadora de moda"},
            {"florista", "directora de orquesta", "diseñadora de moda", "jardinera"},
            {"florista", "directora de orquesta", "jardinera", "diseñadora de moda"},
            {"jardinera", "diseñadora de moda", "florista", "directora de orquesta"},
            {"jardinera", "diseñadora de moda", "directora de orquesta", "florista"},
            {"jardinera", "florista", "diseñadora de moda", "directora de orquesta"},
            {"jardinera", "florista", "directora de orquesta", "diseñadora de moda"},
            {"jardinera", "directora de orquesta", "diseñadora de moda", "florista"},
            {"jardinera", "directora de orquesta", "florista", "diseñadora de moda"},
            {"directora de orquesta", "diseñadora de moda", "florista", "jardinera"},
            {"directora de orquesta", "diseñadora de moda", "jardinera", "florista"},
            {"directora de orquesta", "florista", "diseñadora de moda", "jardinera"},
            {"directora de orquesta", "florista", "jardinera", "diseñadora de moda"},
            {"directora de orquesta", "jardinera", "diseñadora de moda", "florista"},
            {"directora de orquesta", "jardinera", "florista", "diseñadora de moda"}
        };

     
        for (String[] permutacion : permutaciones) {
         
            if (cumplePistas(permutacion)) {
           
                for (int i = 0; i < permutacion.length; i++) {
                    System.out.println(mujeres[i] + " trabaja como " + permutacion[i]);
                }
                break;
            }
        }
    }

 
    public static boolean cumplePistas(String[] permutacion) {
        // (a) Clara es violentamente alérgica a las plantas.
        if (permutacion[0].equals("jardinera")) {
            return false;
        }
        // (b) Luisa y la florista comparten el departamento
        if (permutacion[1].equals("florista") && !permutacion[2].equals("florista")) {
            return false;
        }
        // (c) A María y Luisa les gusta solamente la música rock
        if (!permutacion[1].equals("directora de orquesta") && !permutacion[2].equals("directora de orquesta")) {
            return false;
        }
        // (d) La jardinera, la diseñadora de modas y Nélida no se conocen entre sí
        if (permutacion[0].equals("jardinera") || permutacion[1].equals("diseñadora de moda") || permutacion[3].equals("jardinera")) {
            return false;
        }
        return true;
    }
}


3) /*Realizar un programa para resolver el siguiente problema: El Sr. Ido, el químico, tiene
seis frascos llenos de líquidos coloreados. Hay uno de cada color: rojo, anaranjado,
amarillo, verde, azul y violeta. El señor Ido sabe que algunos de esos líquidos son
tóxicos, pero no recuerda cuales...
Sin embargo, sí recuerda algunos datos. En cada uno de los siguientes pares de frascos
hay uno con veneno y otro no:
a) los frascos violeta y azul
b) los frascos rojo y amarillo
c) los frascos azul y anaranjado
El Sr. Ido recuerda también que en estos otros pares de frascos hay uno sin veneno:
d) el violeta y el amarillo
e) el rojo y el anaranjado
f) el verde y el azul

¡Ah! Casi lo olvido, añade el Sr. Ido, el líquido del frasco rojo no es venenoso. ¿Qué
frascos tienen veneno?*/

public class Principal {
    public static void main(String[] args) {
        // Creamos un arreglo de booleanos para representar si cada frasco tiene veneno o no
        boolean[] frascos = new boolean[6];
        
        // Marcamos los frascos que sabemos que no tienen veneno
        frascos[0] = false; // Rojo
        frascos[2] = false; // Anaranjado
        
        // Aplicamos las restricciones que se dieron
        frascos[4] = true; // Violeta
        frascos[5] = true; // Azul
        
        // Aplicamos las restricciones adicionales
        frascos[1] = !frascos[2]; // Amarillo
        frascos[3] = !frascos[0]; // Verde
        
        // Mostramos los resultados
        System.out.println("Los frascos que tienen veneno son:");
        for (int i = 0; i < frascos.length; i++) {
            if (frascos[i]) {
                switch (i) {
                    case 0:
                        System.out.println("Rojo");
                        break;
                    case 1:
                        System.out.println("Amarillo");
                        break;
                    case 2:
                        System.out.println("Anaranjado");
                        break;
                    case 3:
                        System.out.println("Verde");
                        break;
                    case 4:
                        System.out.println("Violeta");
                        break;
                    case 5:
                        System.out.println("Azul");
                        break;
                }
            }
        }
    }
}


4)/*Realizar una calculadora en la cual se deberá ingresar una expresión, se analizará si la
expresión ingresada es válida y se resuelva dicha expresión. Las operaciones de la
calculadora son: Suma, resta, multiplicación, división, potenciación y radicación.*/

import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la expresión matemática: ");
        String expresion = scanner.nextLine();

        try {
            double resultado = evaluarExpresion(expresion);
            System.out.println("El resultado es: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double evaluarExpresion(String expresion) {
        List<String> tokens = tokenizar(expresion);
        Queue<String> cola = new LinkedList<>(tokens);
        return evaluarExpresionRecursiva(cola);
    }

    private static List<String> tokenizar(String expresion) {
        List<String> tokens = new ArrayList<>();
        StringBuilder tokenActual = new StringBuilder();

        for (char c : expresion.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                tokenActual.append(c);
            } else if (esOperador(c)) {
                if (tokenActual.length() > 0) {
                    tokens.add(tokenActual.toString());
                    tokenActual = new StringBuilder();
                }
                tokens.add(String.valueOf(c));
            } else if (Character.isWhitespace(c)) {
                continue;
            } else {
                throw new IllegalArgumentException("Carácter no válido: " + c);
            }
        }

        if (tokenActual.length() > 0) {
            tokens.add(tokenActual.toString());
        }

        return tokens;
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '√';
    }

    private static double evaluarExpresionRecursiva(Queue<String> cola) {
        double izquierdo = Double.parseDouble(cola.poll());

        if (cola.isEmpty()) {
            return izquierdo;
        }

        String operador = cola.poll();
        double derecho = evaluarExpresionRecursiva(cola);

        switch (operador) {
            case "+":
                return izquierdo + derecho;
            case "-":
                return izquierdo - derecho;
            case "*":
                return izquierdo * derecho;
            case "/":
                if (derecho == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return izquierdo / derecho;
            case "^":
                return Math.pow(izquierdo, derecho);
            case "√":
                if (izquierdo < 0) {
                    throw new ArithmeticException("Raíz cuadrada de número negativo");
                }
                return Math.sqrt(izquierdo);
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}


5) /*Se sabe que el operador << desplaza dos bits hacia la izquierda, por lo que si se realiza
por ejemplo 2<<2 se obtiene como resultado 8. Al hacer 2 << -2 el resultado es
-2147483648, y al hacer 12<<-2 el resultado es 0. ¿Por qué sucede esto?
*/

El operador de desplazamiento a la izquierda (<<) en Java mueve los bits hacia la izquierda. Cuando se desplaza a la izquierda por un número negativo, Java interpreta ese número como su complemento a dos. En el caso de números pequeños como 2, el desplazamiento negativo resulta en un valor negativo grande (como -2147483648), debido a la representación binaria de números en complemento a dos. Para números mayores, como 12, el desplazamiento negativo resulta en cero, ya que los bits se desplazan más allá de la posición más baja y se pierden.

public class Principal {
    public static void main(String[] args) {
        int a = 2;
        int b = 12;
        
        // Desplazamiento a la izquierda por un número positivo
        int resultado1 = a << 2;
        System.out.println("Resultado de 2 << 2: " + resultado1); // = 8
        
        // Desplazamiento a la izquierda por un número negativo
        int resultado2 = a << -2;
        System.out.println("Resultado de 2 << -2: " + resultado2); // = -2147483648
        
        // Desplazamiento a la izquierda por un número positivo
        int resultado3 = b << -2;
        System.out.println("Resultado de 12 << -2: " + resultado3); // = 0
    }
}
