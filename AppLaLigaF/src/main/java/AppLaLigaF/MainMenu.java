package AppLaLigaF;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class MainMenu extends JFrame {
    private JTabbedPane TabbedPane;
    
    public MainMenu() {
        setTitle("MENÚ PRINCIPAL | LaLiga F APP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,500);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        
        TabbedPane = new JTabbedPane();
        add(TabbedPane);
        TabbedPane.setBackground(new Color(243,146,0));
        TabbedPane.setFont(new Font("Typo Round Bold Demo", Font.BOLD, 14));

        TablaPosiciones();
        EstadisticasEquipos();
        HistorialCampeonas();
        EquipoIdeal();
    }
    
    private void TablaPosiciones() {
        JPanel Panel = new JPanel(new BorderLayout());
        
        // Crear un modelo de datos de tabla
        DefaultTableModel Dates = new DefaultTableModel();

        // Agregar columnas al modelo de datos
        Dates.addColumn("POS");
        Dates.addColumn("EQUIPO");
        Dates.addColumn("PJ");
        Dates.addColumn("PG");
        Dates.addColumn("PE");
        Dates.addColumn("PP");
        Dates.addColumn("GF");
        Dates.addColumn("GC");
        Dates.addColumn("DG");
        Dates.addColumn("PTS");

        // Agregar filas al modelo de datos
        Dates.addRow(new Object[]{1, "América de Cali", 16, 13, 1, 2, 43, 8, 35, 40});
        Dates.addRow(new Object[]{2, "Independiente Santa fe", 16, 10, 5, 1, 33, 12, 21, 35});
        Dates.addRow(new Object[]{3, "Atlético Nacional", 16, 8, 6, 2, 28, 9, 19, 30});
        Dates.addRow(new Object[]{4, "Deportivo Pereira", 16, 8, 5, 3, 28, 20, 8, 29});
        Dates.addRow(new Object[]{5, "Deportivo Cali", 16, 7, 6, 3, 24, 18, 6, 27});
        Dates.addRow(new Object[]{6, "Independiente Medellin", 16, 8, 3, 5, 25, 20, 5, 27});
        Dates.addRow(new Object[]{7, "Cortulua", 16, 7, 4, 5, 20, 13, 7, 25});
        Dates.addRow(new Object[]{8, "La Equidad", 16, 7, 2, 7, 28, 20, 8, 23});
        Dates.addRow(new Object[]{9, "Millonarios", 16, 6, 4, 6, 23, 21, 2, 22});
        Dates.addRow(new Object[]{10, "Llaneros", 16, 7, 1, 8, 21, 23, -2, 22});
        Dates.addRow(new Object[]{11, "Junior", 16, 5, 6, 5, 17, 12, 5, 21});
        Dates.addRow(new Object[]{12, "Boyacá Chicó", 16, 4, 8, 4, 13, 15, -2, 20});
        Dates.addRow(new Object[]{13, "Atlético Huila", 16, 5, 5, 6, 15, 21, -6, 20});
        Dates.addRow(new Object[]{14, "Real Santander", 16, 3, 4, 9, 13, 29, -16, 13});
        Dates.addRow(new Object[]{15, "Deportivo Pasto", 16, 3, 3, 10, 11, 34, -23, 12});
        Dates.addRow(new Object[]{16, "Bucaramanga", 16, 1, 3, 12, 9, 41, -32, 6});
        Dates.addRow(new Object[]{17, "Deportes Tolima", 16, 0, 2, 14, 11, 46, -35, 2});
        
        // Crear una instancia de JTable con el modelo de datos
        JTable table = new JTable(Dates);
        
        // Cambiar el tamaño de la primer columna(Posición)
        TableColumn columnPosicion = table.getColumnModel().getColumn(0);
        columnPosicion.setPreferredWidth(40); // Establecer el ancho deseado

        // Cambiar el tamaño de la segunda columna (Equipo)
        TableColumn columnEquipo = table.getColumnModel().getColumn(1);
        columnEquipo.setPreferredWidth(200); // Establecer el ancho deseado

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane al JFrame
        Panel.add(scrollPane);
        
        TabbedPane.add("TABLA DE POSICIONES", Panel);
    }
    
    private void EstadisticasEquipos() {
        JPanel Panel = new JPanel();

        String[] Equipos = {"", "América de Cali", "Independiente Santa Fe", "Atlético Nacional", "Deportivo Pereira", "Deportivo Cali", "Independiente Medellin", "Cortulua", "La Equidad", "Millonarios", "Llaneros", "Junior", "Boyaca Chico", "Atlético Huila", "Real Santander", "Deportivo Pasto", "Bucaramanga", "Deportes Tolima"};
        JComboBox<String> EquiposComboBox = new JComboBox<>(Equipos);
        JLabel SelectLabel = new JLabel("Selecciona un equipo: ");
        SelectLabel.setFont(new Font("Typo Round Bold Demo", Font.BOLD, 18));
        SelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel DatosLabel = new JLabel();

        EquiposComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DatosEquipos = (String) EquiposComboBox.getSelectedItem();
                Object Datos = obtenerEstadisticas(DatosEquipos);
                DatosLabel.setText("Datos relevantes: \n" + Datos);
            }
        });

        Panel.setLayout(new GridLayout(3, 1, 20, 20));
        Panel.add(SelectLabel);
        Panel.add(EquiposComboBox);
        Panel.add(DatosLabel);

        TabbedPane.addTab("ESTADÍSTICAS", Panel);
    }
    
    private Object obtenerEstadisticas (Object Datos) {
        return "Se fundó el 15 de Septiembre de 2016.\n Juegan en el estadio Pascual Guerrero.";
    }

    private void HistorialCampeonas() {
        JPanel Panel = new JPanel();
        
        JLabel LabelEquipos = new JLabel("Los equipos de fútbol que participan en la Liga Femenina en Colombia son:");
        LabelEquipos.setHorizontalAlignment(SwingConstants.CENTER);
        LabelEquipos.setFont(new Font("Typo Round Bold Demo", Font.BOLD, 16));
        // Crear un modelo de datos de tabla
        DefaultTableModel Teams = new DefaultTableModel();

        // Agregar columnas al modelo de datos
        Teams.addColumn("");
        Teams.addColumn("");
        Teams.addColumn("");

        // Agregar filas al modelo de datos
        Teams.addRow(new String[]{"America", "Santa Fe", "Nacional"});
        Teams.addRow(new String[]{"Pereira", "Cali", "Medellin"});
        Teams.addRow(new String[]{"Cortulua", "Equidad", "Millonarios"});
        Teams.addRow(new String[]{"Llaneros", "Junior", "Boyaca Chico"});
        Teams.addRow(new String[]{"Huila", "Real Santander", "Pasto"});
        Teams.addRow(new String[]{"Bucaramanga", "Tolima"});
        // Crear una instancia de JTable con el modelo de datos
        JTable table = new JTable(Teams);
        
        JTextField SearchField = new JTextField(10);
        JButton SearchButton = new JButton("Consultar");
        JTextArea ResultTextArea = new JTextArea(10, 30);
        ResultTextArea.setEditable(false);

        Map<String, String> EquipoCampeon = new HashMap<>();
        EquipoCampeon.put("America", "ha sido campeón 2 veces.\n 2019: America de Cali 3 vs Independiente Medellin 2\n 2022: America de Cali 3 vs Deportivo Cali 3");
        EquipoCampeon.put("Santa Fe", "es el primero y más veces campeón del fútbol fememnino en Colombia, con un total de 3 títulos.\n 2017: Santa Fe 3 vs Atlético Hulia 1\n 2020: Santa Fe 4 vs America de Cali 1\n Santa Fe 2 vs America de Cali 0");
        EquipoCampeon.put("Huila", "cuenta con un título de liga.\n 2018: Atlético Huila 2 vs Atlético Nacional 2. Esta final se decidió desde el punto penalti y lo ganó Atlético Huila 3 x 0");
        EquipoCampeon.put("Cali", "cuenta con un título de liga.\n 2021: Deportivo Cali 6 vs Santa Fe 3");
        
        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DatosEquipo = String.valueOf(SearchField.getText());
                String Equipo = EquipoCampeon.get(DatosEquipo);
                if (Equipo != null) {
                    ResultTextArea.setText("El equipo " + DatosEquipo + ": " + Equipo);
                } else {
                    ResultTextArea.setText("El equipo seleccionado no ha sido campeón de la Liga.");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Selecciona tu equipo: "));
        inputPanel.add(SearchField);
        inputPanel.add(SearchButton);

        Panel.setLayout(new GridLayout(4, 1, 10, 10));
        Panel.add(LabelEquipos);
        Panel.add(table);
        Panel.add(inputPanel);
        Panel.add(ResultTextArea);

        TabbedPane.addTab("HISTORIAL DE CAMPEONAS", Panel);
    }
    
    private void EquipoIdeal() {
        JPanel Panel = new JPanel(new BorderLayout());

        DefaultTableModel EquipoIdealTableModel = new DefaultTableModel(
                new String[]{"POSICIÓN", "NOMBRE DE LA JUGADORA"}, 0);

        JTable JugadorasTable = new JTable(EquipoIdealTableModel);
        JScrollPane ScrollPane = new JScrollPane(JugadorasTable);

        JTextField PosicionField = new JTextField();
        JTextField NombreField = new JTextField();
        
        JButton AddButton = new JButton("Agregar");

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Posicion = PosicionField.getText();
                String Nombre = NombreField.getText();
                EquipoIdealTableModel.addRow(new String[]{Posicion, Nombre});
                PosicionField.setText("");
                NombreField.setText("");
            }
        });

        Panel.add(ScrollPane);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("POSICIÓN:"));
        inputPanel.add(PosicionField);
        inputPanel.add(new JLabel("NOMBRE DE LA JUGADORA:"));
        inputPanel.add(NombreField);
        inputPanel.add(new JLabel());
        inputPanel.add(AddButton);
        
        JProgressBar VotacionProgressBar = new JProgressBar(0, 100);
        JButton EnviarButton = new JButton("ENVIAR MI EQUIPO IDEAL");
        EnviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= 100; i++) {
                            VotacionProgressBar.setValue(i);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    JOptionPane.showMessageDialog(Panel, "¡Tu equipo ideal se ha enviado!");} 
                }).start();
            }
        });

        Panel.add(inputPanel);
        Panel.setLayout(new GridLayout(4, 1, 10, 10));
        Panel.add(VotacionProgressBar);
        Panel.add(EnviarButton);

        TabbedPane.addTab("EQUIPO IDEAL", Panel);
    }
}