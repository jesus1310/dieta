/**
 * Write a description of class Alimento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alimento
{
    // Atributo que guarda el nombre
    private String nombre;
    // Atributo que guarda las proteinas por cada 100 gramos
    private float proteinas;
    // Atributo que guarda los carbohidratos por cada 100 gramos
    private float carbohidratos;
    // Atributo que guarda las grasas por cada 100 gramos
    private float grasas;
    // Atributo que guarda las calorias
    private float calorias;
    // Atributo que guarda los componentes mayoritarios
    private String mayoritarios;

    /**
     * Constructor de objetos de la clase alimento
     * Se pasan por parámetro el nombre y los 3 macronutrientes principales
     * Se calculan las calorias basandose en que:
     * Por cada gramo de proteinas o de carbohidratos se suman 4 calorias
     * Por cada gramo de grasa se suman 9 calorias
     */
    public Alimento(String nombre,float proteinas,float carbohidratos,float grasas){
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        calorias = (proteinas*4) + (carbohidratos*4) + (grasas*9);
        if (proteinas >=0 && proteinas <= 100 && carbohidratos >=0 && carbohidratos <=100 && grasas >=0 && grasas <= 100){
            if (proteinas > carbohidratos && proteinas > grasas){
                mayoritarios = "Proteinas";
            }
            else if (carbohidratos > proteinas && carbohidratos > grasas){
                mayoritarios = "Carbohidratos";
            }
            else if (grasas > proteinas && grasas > carbohidratos){
                mayoritarios = "Grasas";
            }
            else if (proteinas == carbohidratos && proteinas != grasas && carbohidratos != grasas && proteinas > grasas){
                mayoritarios = "Proteinas y Carbohidratos";
            }
            else if (proteinas != carbohidratos && proteinas == grasas && carbohidratos != grasas && proteinas > carbohidratos){
                mayoritarios = "Proteinas y Grasas";     
            }
            else if (proteinas != carbohidratos && proteinas != grasas && carbohidratos == grasas && grasas > proteinas){
                mayoritarios = "Carbohidratos y Grasas";
            }
            else if (proteinas == carbohidratos && proteinas == grasas && carbohidratos == grasas){
                mayoritarios = "Proteinas, Carbohidratos y Grasas";
            }
        }
        else{
            System.out.println("Alguno de los datos introducidos no es válido");
        }
    }

    /**
     * Método que muestra las estadisticas del alimento creado
     */
    public void muestraDatos(){
        System.out.println("Nombre del alimento: " + nombre);
        System.out.println("Proteínas por cada 100 gramos: " + proteinas);
        System.out.println("Carbohidratos por cada 100 gramos: " + carbohidratos);
        System.out.println("Grasas por cada 100 gramos: " + grasas);
        System.out.println("Calorias: " + calorias);
        System.out.println("Componente/s mayoritario/s: " + mayoritarios);
    }
}
