public class torneo_dragon_ball {
    private static String Nombre;
    private static int ataque;
    private static int defensa;
    private static int velocidad;

    //getters//
    public static String getNombre() {
        return Nombre;
    }
    public static int getAtaque() {
        return ataque;
    }
    public static int getDefensa() {
        return defensa;
    }
    public static int getVelocidad() {
        return velocidad;
    }

    //Setters
    public static void setNombre(String Nombre) {
        torneo_dragon_ball.Nombre = Nombre;
    }
    public static void setAtaque(int ataque) {
        torneo_dragon_ball.ataque = ataque;
    }
    public static void setDefensa(int defensa) {
        torneo_dragon_ball.defensa = defensa;
    }
    public static void setVelocidad(int velocidad) {
        torneo_dragon_ball.velocidad = velocidad;
    }

    //Constructor//
    public torneo_dragon_ball(String Nombre, int ataque, int defensa, int velocidad) {
        torneo_dragon_ball.Nombre = Nombre;
        torneo_dragon_ball.ataque = ataque;
        torneo_dragon_ball.defensa = defensa;
        torneo_dragon_ball.velocidad = velocidad;
    }

}
