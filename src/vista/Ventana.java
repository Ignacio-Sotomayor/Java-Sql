package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;

import modelo.DB;
import modelo.Persona;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JList<Persona> list;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNewLabel_5;
	private JTextField textFieldNombre;
	private JLabel label;
	private JPanel panel_8;
	private JLabel lblNewLabel_6;
	private JTextField textFieldTelefono;
	private JLabel lblNewLabel_7;
	private JPanel panel_9;
	private JCalendar calendar;
	private JButton btnNewButton;
	private DefaultListModel listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {

		try {
			DB.getDB().conectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 535);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(149, 149, 255));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 2, 10, 0));

		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane);

		this.panel = new JPanel();
		this.panel.setPreferredSize(new Dimension(10, 40));
		this.panel.setBackground(new Color(149, 149, 255));
		this.scrollPane.setColumnHeaderView(this.panel);

		this.lblNewLabel = new JLabel("Contactos");
		this.lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		this.panel.add(this.lblNewLabel);

		this.list = new JList<Persona>();
		listModel = new DefaultListModel<Persona>();
		this.list.setModel(listModel);
		actualizar();
		this.scrollPane.setViewportView(this.list);

		this.panel_1 = new JPanel();
		this.panel_1.setBackground(new Color(255, 255, 255));
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(new BorderLayout(0, 0));

		this.panel_2 = new JPanel();
		this.panel_2.setBackground(new Color(149, 149, 255));
		this.panel_2.setPreferredSize(new Dimension(10, 40));
		this.panel_1.add(this.panel_2, BorderLayout.NORTH);

		this.lblNewLabel_1 = new JLabel("Agregar contacto");
		this.lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		this.panel_2.add(this.lblNewLabel_1);

		this.panel_3 = new JPanel();
		this.panel_3.setBackground(new Color(255, 255, 255));
		this.panel_3.setPreferredSize(new Dimension(175, 10));
		this.panel_1.add(this.panel_3, BorderLayout.WEST);
		this.panel_3.setLayout(new GridLayout(3, 1, 0, 10));

		this.lblNewLabel_2 = new JLabel("Nombre:");
		this.lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		this.lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_3.add(this.lblNewLabel_2);

		this.lblNewLabel_3 = new JLabel("Telefono:");
		this.lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		this.lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_3.add(this.lblNewLabel_3);

		this.lblNewLabel_4 = new JLabel("Fecha de nacimiento:");
		this.lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		this.lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_3.add(this.lblNewLabel_4);

		this.panel_4 = new JPanel();
		this.panel_4.setBackground(Color.WHITE);
		this.panel_4.setPreferredSize(new Dimension(175, 10));
		this.panel_1.add(this.panel_4, BorderLayout.EAST);
		this.panel_4.setLayout(new GridLayout(3, 1, 0, 10));

		this.panel_6 = new JPanel();
		this.panel_6.setBackground(Color.WHITE);
		this.panel_4.add(this.panel_6);
		this.panel_6.setLayout(new GridLayout(0, 1, 0, 10));

		this.lblNewLabel_5 = new JLabel("");
		this.lblNewLabel_5.setPreferredSize(new Dimension(10, 30));
		this.lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel_6.add(this.lblNewLabel_5);

		this.panel_8 = new JPanel();
		this.panel_8.setBackground(Color.WHITE);
		this.panel_6.add(this.panel_8);

		this.textFieldNombre = new JTextField();
		this.textFieldNombre.setBorder(new LineBorder(new Color(171, 173, 179)));
		this.panel_8.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(15);

		this.label = new JLabel("");
		this.panel_6.add(this.label);

		this.panel_7 = new JPanel();
		this.panel_7.setBackground(Color.WHITE);
		this.panel_4.add(this.panel_7);
		this.panel_7.setLayout(new GridLayout(0, 1, 0, 10));

		this.lblNewLabel_6 = new JLabel("");
		this.panel_7.add(this.lblNewLabel_6);

		this.panel_9 = new JPanel();
		this.panel_9.setBackground(Color.WHITE);
		this.panel_7.add(this.panel_9);

		this.textFieldTelefono = new JTextField();
		this.textFieldTelefono.setBorder(new LineBorder(new Color(171, 173, 179)));
		this.panel_9.add(this.textFieldTelefono);
		this.textFieldTelefono.setColumns(15);

		this.lblNewLabel_7 = new JLabel("");
		this.panel_7.add(this.lblNewLabel_7);

		this.calendar = new JCalendar();
		this.calendar.setBackground(Color.WHITE);
		this.panel_4.add(this.calendar);

		this.panel_5 = new JPanel();
		this.panel_5.setBackground(Color.WHITE);
		this.panel_5.setPreferredSize(new Dimension(10, 75));
		this.panel_1.add(this.panel_5, BorderLayout.SOUTH);
		this.panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.btnNewButton = new JButton("Agregar");
		this.btnNewButton.addActionListener(this);
		this.btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		this.btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.panel_5.add(this.btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		agregar();
		actualizar();
		
	}

	@SuppressWarnings("deprecation")
	private void agregar() {
		String nombre = this.textFieldNombre.getText();
		String telefono = this.textFieldTelefono.getText();
		Date fecha = new Date(this.calendar.getDate().getYear(), this.calendar.getDate().getMonth(),
				this.calendar.getDate().getDate());

		Persona p = new Persona(nombre, telefono, fecha);

		try {
			DB.getDB().agregarPersona(p);
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

	}
	
	private void actualizar(){
		this.listModel.clear();
		
		try {
			Iterator it = DB.getDB().listarPersonas();
			while(it.hasNext()){
				this.listModel.addElement(it.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
