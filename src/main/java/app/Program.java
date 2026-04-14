package app;

import data.Persistencia;
import java.util.InvalidPropertiesFormatException;
import views.*;

public class Program {
    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        MenuPrincipalView view = new MenuPrincipalView();
        view.setVisible(true);
    }
}
