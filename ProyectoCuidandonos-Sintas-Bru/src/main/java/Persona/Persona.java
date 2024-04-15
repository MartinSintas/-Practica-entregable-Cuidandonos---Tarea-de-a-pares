package Persona;

import lombok.Getter;
import lombok.Setter;
import Enums.Sexo;

public class Persona {
    @Setter @Getter private String nombre;
    @Setter @Getter private String apellido;
    @Setter @Getter private String direccion;
    @Setter @Getter private String edad;
    @Setter @Getter private Sexo sexo;
    @Getter public Boolean instalada = true;
}
