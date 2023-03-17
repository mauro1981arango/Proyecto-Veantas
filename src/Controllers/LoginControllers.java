package Controllers;

import Models.Usuarios;
import Models.UsuariosDAO;
import Views.FrmLogin;
import Views.PanelAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginControllers implements ActionListener {

    private Usuarios usu;
    private final UsuariosDAO usuDao;
    private final FrmLogin vistaLogin;
    
    
    public LoginControllers(Usuarios usu, UsuariosDAO usuDao, FrmLogin vistaLogin) {
        this.usu = usu;
        this.usuDao = usuDao;
        this.vistaLogin = vistaLogin;
        this.vistaLogin.setLocationRelativeTo(null);
        this.vistaLogin.btnLogin.addActionListener(this);
        this.vistaLogin.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaLogin.btnLogin) {
            // Validamos que los campos de texto no estén vacíos.
            if (vistaLogin.txtUsuario.getText().equals("")
                    || String.valueOf(vistaLogin.txtContrasena.getPassword()).equals("")) {
                // Si los campor están vacíos mostraos mensaje.
                JOptionPane.showMessageDialog(null, "Tdos los campos son obligatorios");
            } else {
                // Si los campos no están vacíos se capturan los datos de los campos de texto
                String usuario = vistaLogin.txtUsuario.getText();
                String clave = String.valueOf(vistaLogin.txtContrasena.getPassword());
                usu = usuDao.login(usuario, clave);
                // Veficamos si el usuario es diferente de null
                if(usu.getUsuario() != null){
                    // Se llama el Panel de Admiministraciòn
                    PanelAdmin admin = new PanelAdmin(usu.getId_usuario(), usu.getNombre());
                    admin.setVisible(true);
                    // Cerramos la ventana del login
                    this.vistaLogin.dispose();
                }else{
                    // Si los datos de inicio de sesión no son correcto mostramos mensaje
                    JOptionPane.showMessageDialog(null, "Los datos no coinciden");
                }
            }
        } else {
            int  pregunta = JOptionPane.showInternalConfirmDialog(null, "Está seguro de abandonar el login?",
                    "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            // Verificamos que ha seleconado el usuario si 0 si o 1 no
            if(pregunta == 0){
                System.exit(0);
            }
        }
    }

}
