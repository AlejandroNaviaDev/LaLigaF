package AppLaLigaF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AppLaLigaF {
    public static void main(String[] args) {
        //Crear una instancia para el JFrame
        JFrame Frame = new JFrame("INGRESO | LaLiga F App");

        //Establecer características del JFrame (Tamaño, color de fondo, ubicación, entre otros)
        Frame.setSize(400, 500);
        Frame.getContentPane().setBackground(new Color(41,160,200));
        Frame.setLocationRelativeTo(null);
        Frame.setLayout(new FlowLayout());
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crear el panel para la sección de ingreso
        JPanel Panel = new JPanel();
        
        //Establecer las características del panel
        Panel.setBackground(Color.WHITE);
        Panel.setBorder(new EmptyBorder(20, 40, 30, 40));
        Panel.setLayout(new GridLayout(7, 1, 10, 10));

        //Crear etiquetas
        JLabel Text1 = new JLabel("BIENVENIDO A LALIGA F APP");
        JLabel Text2 = new JLabel ("Ingresa tus datos");

        //Establecer alineación de las etiquetas al centro
        Text1.setHorizontalAlignment(SwingConstants.CENTER);
        Text2.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Estilo de las etiquetas
        Text1.setFont(new Font("Typo Round Bold Demo", Font.BOLD, 18));
        Text2.setFont(new Font("Typo Round Bold Demo", Font.BOLD, 16));
        
        //Agregar las etiquetas al panel
        Panel.add(Text1);
        Panel.add(Text2);
        
        //Crear los campos para el ingreso del usuario y contraseña
        JTextField UserName = new JTextField();
        JPasswordField Password = new JPasswordField();
        
        //Agregar los campos de usuario y contraseña al panel
        Panel.add(new JLabel("Usuario", SwingConstants.CENTER));
        Panel.add(UserName);
        Panel.add(new JLabel("Contraseña", SwingConstants.CENTER));
        Panel.add(Password);

        //Crear el botón de ingreso
        JButton Button = new JButton("INGRESAR");
        JButton Credits = new JButton("Créditos");
        
        //Estilo para los botones
        Button.setFont(new Font("Typo Round Bold Demo", Font.BOLD, 14));
        Credits.setFont(new Font("Typo Round Bold Demo", Font.BOLD, 10));
        Button.setBackground(new Color(243,146,0));
        Credits.setBackground(new Color(243,146,0));
        
        //Agregar el botón al panel
        Panel.add(Button);

        //Acción para comprobar que los datos de usuario y contraseña sean correctos y permita continuar al menú
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String User = UserName.getText();
                char[] Pass = Password.getPassword();
                //Establecer el usuario y contraseña
                if (User.equals("alejandro") && new String(Pass).equals("12345")) {
                    MainMenu MenuPrincipal = new MainMenu();
                    MenuPrincipal.setVisible(true);
                    Frame.dispose();
                    String[] Options = { "Continuar"};
                    JOptionPane.showOptionDialog(null, "MENÚ PRINCIPAL\nSeleciona lo que deseas consultar", "¡BIENVENIDO!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
                } else {
                    JOptionPane.showMessageDialog(Frame, "Usuario o contraseña incorrecto");
                }
            }
        });
        //Crear el botón para los créditos
        Credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Frame,"Aplicación creada por:\n Alejandro Navia Vargas\n yoergi.navia@pi.edu.co\n Politécnico Internacional\n 2023");
            }
        });

        //Agregar el panel al JFrame
        Frame.add(Panel, BorderLayout.NORTH);
        Frame.add(Credits, BorderLayout.LINE_END);

        //Establecer el JFrame como visible
        Frame.setVisible(true);
    }
}