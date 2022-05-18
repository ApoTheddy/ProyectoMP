package utilClass;

import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import screens.frmTiendaScreen;
import utils.Api;

public class LoginController {

    private Api api = new Api();
    private frmTiendaScreen tienda = frmTiendaScreen.getInstance();
    boolean isAllComplete = false;

    public boolean singIn(String email, String password) {
        String condicion = validarCampos(email.trim(), password.trim());

        if (condicion.equals("")) {
            try {
                List<SignInModel> response = api.signIn(email, password);
                
                response.stream().forEach(user -> {
                    if (!user.isExistEmail() || !user.isExistPassword()) {
                        JOptionPane.showMessageDialog(null, user.getMessage(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                        isAllComplete = false;
                    }
                    if (user.isExistEmail() && user.isExistPassword()) {
                        isAllComplete = true;
                        tienda.setUserInfo(user.getUserId());

//                        tienda.setVisible(true);
//                        tienda.setResizable(false);
//                        tienda.setLocationRelativeTo(null);
                    }
                });
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al obtener datos de la api", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                isAllComplete = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor verifique el campo " + condicion, "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            isAllComplete = false;
        }
        return isAllComplete;
    }

    private String validarCampos(String email, String password) {
        if (email.equals("")) {
            return "Email";
        }
        if (password.equals("")) {
            return "Password";
        }
        if (!email.contains("@") || !email.contains(".com")) {
            return "Email - Correo no valido";
        }
        if (email.length() < 7) {
            return "Email - Correo no valido";
        }
        if (password.length() < 6) {
            return "Password - Contrasenia no valida";
        }

        return "";
    }
}
