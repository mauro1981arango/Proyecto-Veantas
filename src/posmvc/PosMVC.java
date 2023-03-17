package posmvc;

import Views.FrmLogin;

public class PosMVC {

    public static void main(String[] args) {
        // Se llama la vista login
        FrmLogin frm = new FrmLogin();
        // Hacemos visible la vista
        frm.setVisible(true);
        // Hacemos que el formulario se vea en el centro de la pantalla
        frm.setLocationRelativeTo(null);
    }
    
}
