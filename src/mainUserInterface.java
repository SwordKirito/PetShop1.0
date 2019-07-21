import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;


import com.sun.org.apache.bcel.internal.generic.NEW;



import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;


public class mainUserInterface extends JFrame {
	
	private static DBoperator dBoperator=new DBoperator();
	
	public static boolean linked =false;
	public static Socket socket=null;
	public static String portClient="8888";
	public static String ipString="127.0.0.1";

	private JPanel contentPane;
	private JTextField add_petNameTxt;
	private JTextField add_petColor;
	private JTextField add_petAgeTxt;
	
	private JTextField s_petName;
	private JTextField s_petAgeTxt;
	private JTable s_table;
	private JTextField s_petColorTxt;
	
	private JTextField m_petName;
	private JTextField m_petColor;
	private JTable m_table;
	private JTextField m_petAgeTxt;
	
	private JTable d_table;
	private JTextField d_petAgeTxt;
	private JTextField d_petNameTxt;
	private JTextField d_petColorTxt;
	

	private JButton AddButton=null;
	private JButton ModifyButton=null;
	private JButton SearchButton=null;
	private JButton DeleteButton=null;


	DefaultTableModel dtm=null;
	DefaultTableModel dtm2=null;
	DefaultTableModel dtm3=null;
	
	JComboBox m_petTypeJcb =null;
	JComboBox s_petType=null;
	JComboBox d_petTypeJcb=null;
	JComboBox add_petTypeJcb=null;
	
	private JTextField m_petNewName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainUserInterface frame = new mainUserInterface();
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
	public mainUserInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\程序试做\\java课\\PetShop1.0\\src\\image\\cat_dog_pet_64px_1143917_easyicon.net.png"));
		setTitle("宠物管理系统1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("宠物管理系统1.0");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		lblNewLabel.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop1.0\\src\\image\\1143917.png"));
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addComponent(lblNewLabel)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 361, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		  JPanel panel2 = new JPanel ();
		  JPanel panel3 = new JPanel ();
		  JPanel panel4 = new JPanel ();
		  JPanel panel1 = new JPanel ();
		  JPanel panel5 = new JPanel ();
		  panel5.setBackground(SystemColor.control);
		  
		  
		  tabbedPane.addTab ("panel5", panel5);
		  
		  JLabel label_12 = new JLabel("宠物管理系统1.0客户端");
		  label_12.setFont(new Font("华文彩云", Font.BOLD, 20));
		  
		  JTextPane textPane = new JTextPane();
		  textPane.setBackground(SystemColor.control);
		  textPane.setFont(new Font("宋体", Font.PLAIN, 14));
		  textPane.setText("第一阶段作业\r\n\r\n客户端程序：将宠物店的程序改造成图形界面系统，可以在界面中添加宠物，查询宠物，修改宠物，删除宠物。宠物信息保存到服务器。\r\n\r\n服务器端程序：开发一个多线程服务器程序，接收客户端请求，将宠物信息放到文件中保存或者从文件中取出。\r\n\r\n服务器端文件：\r\nPet文件夹存储宠物类别文件夹（包括狗、猫）；\r\n宠物类别文件夹（包括狗、猫）存储宠物各自的信息\r\n");
		  GroupLayout gl_panel5 = new GroupLayout(panel5);
		  gl_panel5.setHorizontalGroup(
		  	gl_panel5.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel5.createSequentialGroup()
		  			.addGroup(gl_panel5.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel5.createSequentialGroup()
		  					.addGap(79)
		  					.addComponent(label_12))
		  				.addGroup(gl_panel5.createSequentialGroup()
		  					.addGap(43)
		  					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
		  			.addContainerGap(46, Short.MAX_VALUE))
		  );
		  gl_panel5.setVerticalGroup(
		  	gl_panel5.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel5.createSequentialGroup()
		  			.addGap(29)
		  			.addComponent(label_12)
		  			.addGap(18)
		  			.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
		  			.addGap(32))
		  );
		  panel5.setLayout(gl_panel5);
		  tabbedPane.setEnabledAt(0,true);
		  tabbedPane.setTitleAt(0,"关于程序");
		
		  
		  
		  tabbedPane.addTab("panel1", panel1); //添加选项卡容器，并且设置其中每个选项卡的标签以及其是否可启用
		  tabbedPane.setEnabledAt(1,true);
		  tabbedPane.setTitleAt(1,"添加宠物");
		  
		  JLabel label = new JLabel("宠物名称：");
		  label.setFont(new Font("华文彩云", Font.BOLD, 25));
		  
		  add_petNameTxt = new JTextField();
		  add_petNameTxt.setFont(new Font("宋体", Font.PLAIN, 25));
		  add_petNameTxt.setColumns(10);
		  
		  JLabel label_1 = new JLabel("宠物颜色：");
		  label_1.setFont(new Font("华文彩云", Font.BOLD, 25));
		  
		  JLabel label_2 = new JLabel("宠物类别：");
		  label_2.setFont(new Font("华文彩云", Font.BOLD, 25));
		  
		  add_petColor = new JTextField();
		  add_petColor.setFont(new Font("宋体", Font.PLAIN, 25));
		  add_petColor.setColumns(10);
		  
		  AddButton = new JButton("添加");
		  AddButton.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop1.0\\src\\image\\sign_add_22.834951456311px_1185683_easyicon.net.png"));
		  AddButton.setFont(new Font("宋体", Font.PLAIN, 20));
		  
		  JLabel label_13 = new JLabel("宠物年龄：");
		  label_13.setFont(new Font("华文彩云", Font.BOLD, 25));
		  
		  add_petAgeTxt = new JTextField();
		  add_petAgeTxt.setFont(new Font("宋体", Font.PLAIN, 25));
		  add_petAgeTxt.setColumns(10);
		  
		  add_petTypeJcb = new JComboBox();
		  add_petTypeJcb.setEditable(true);
		  GroupLayout gl_panel1 = new GroupLayout(panel1);
		  gl_panel1.setHorizontalGroup(
		  	gl_panel1.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel1.createSequentialGroup()
		  			.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel1.createSequentialGroup()
		  					.addGap(57)
		  					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
		  						.addGroup(gl_panel1.createSequentialGroup()
		  							.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		  							.addGap(18)
		  							.addComponent(add_petAgeTxt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
		  						.addGroup(gl_panel1.createSequentialGroup()
		  							.addComponent(label)
		  							.addGap(18)
		  							.addComponent(add_petNameTxt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
		  						.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING, false)
		  							.addGroup(gl_panel1.createSequentialGroup()
		  								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		  								.addGap(18)
		  								.addComponent(add_petTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		  							.addGroup(gl_panel1.createSequentialGroup()
		  								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
		  								.addGap(18)
		  								.addComponent(add_petColor, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))))
		  				.addGroup(gl_panel1.createSequentialGroup()
		  					.addGap(149)
		  					.addComponent(AddButton)))
		  			.addGap(181))
		  );
		  gl_panel1.setVerticalGroup(
		  	gl_panel1.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel1.createSequentialGroup()
		  			.addGap(42)
		  			.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(label)
		  				.addComponent(add_petNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		  			.addGap(18)
		  			.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel1.createSequentialGroup()
		  					.addGap(6)
		  					.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
		  				.addComponent(add_petAgeTxt, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
		  			.addGap(18)
		  			.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
		  				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(add_petColor, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
		  			.addGap(25)
		  			.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
		  				.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(add_petTypeJcb, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		  			.addGap(18)
		  			.addComponent(AddButton)
		  			.addContainerGap(32, Short.MAX_VALUE))
		  );
		  panel1.setLayout(gl_panel1);
		   
		  tabbedPane.addTab ("panel2", panel2);
		  
		  JLabel label_3 = new JLabel("宠物名称：");
		  label_3.setFont(new Font("华文彩云", Font.PLAIN, 15));
		  
		  s_petName = new JTextField();
		  s_petName.setColumns(10);
		  
		  JLabel label_4 = new JLabel("宠物年龄：");
		  label_4.setFont(new Font("华文彩云", Font.PLAIN, 15));
		  
		  s_petAgeTxt = new JTextField();
		  s_petAgeTxt.setEditable(false);
		  s_petAgeTxt.setColumns(10);
		  
		  JLabel label_5 = new JLabel("宠物类别：");
		  label_5.setFont(new Font("华文彩云", Font.PLAIN, 15));
		  
		  s_petType = new JComboBox();
		  
		  JScrollPane scrollPane = new JScrollPane();
		  
		  SearchButton = new JButton("查询");
		  SearchButton.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop1.0\\src\\image\\search.png"));
		  SearchButton.setFont(new Font("华文彩云", Font.PLAIN, 17));
		  
		  s_petColorTxt = new JTextField();
		  s_petColorTxt.setEditable(false);
		  s_petColorTxt.setColumns(10);
		  
		  JLabel label_14 = new JLabel("宠物颜色：");
		  label_14.setFont(new Font("华文彩云", Font.PLAIN, 15));
		  GroupLayout gl_panel2 = new GroupLayout(panel2);
		  gl_panel2.setHorizontalGroup(
		  	gl_panel2.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel2.createSequentialGroup()
		  			.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel2.createSequentialGroup()
		  					.addGap(31)
		  					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
		  						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
		  						.addGroup(gl_panel2.createSequentialGroup()
		  							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
		  								.addGroup(gl_panel2.createSequentialGroup()
		  									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
		  									.addPreferredGap(ComponentPlacement.RELATED)
		  									.addComponent(s_petAgeTxt, 0, 0, Short.MAX_VALUE))
		  								.addGroup(gl_panel2.createSequentialGroup()
		  									.addPreferredGap(ComponentPlacement.RELATED)
		  									.addComponent(label_3)
		  									.addPreferredGap(ComponentPlacement.RELATED)
		  									.addComponent(s_petName, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
		  							.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
		  							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
		  								.addComponent(label_5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
		  								.addComponent(label_14, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		  							.addPreferredGap(ComponentPlacement.RELATED)
		  							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING, false)
		  								.addComponent(s_petColorTxt, 0, 0, Short.MAX_VALUE)
		  								.addComponent(s_petType, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
		  							.addGap(29))))
		  				.addGroup(gl_panel2.createSequentialGroup()
		  					.addGap(149)
		  					.addComponent(SearchButton)))
		  			.addGap(99))
		  );
		  gl_panel2.setVerticalGroup(
		  	gl_panel2.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel2.createSequentialGroup()
		  			.addGap(21)
		  			.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel2.createSequentialGroup()
		  					.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(s_petName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		  						.addComponent(label_3))
		  					.addGap(18)
		  					.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		  						.addComponent(s_petAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		  				.addGroup(gl_panel2.createSequentialGroup()
		  					.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		  						.addComponent(s_petType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		  					.addGap(18)
		  					.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(s_petColorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		  						.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
		  			.addGap(18)
		  			.addComponent(SearchButton)
		  			.addGap(10)
		  			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
		  			.addContainerGap(22, Short.MAX_VALUE))
		  );
		  
		  s_table = new JTable();
		  s_table.setModel(new DefaultTableModel(
		  	new Object[][] {
		  	},
		  	new String[] {
		  		"\u7F16\u7A0B", "\u5BA0\u7269\u540D\u79F0", "\u5BA0\u7269\u5E74\u9F84", "\u5BA0\u7269\u989C\u8272", "\u5BA0\u7269\u7C7B\u522B"
		  	}
		  ) {
		  	boolean[] columnEditables = new boolean[] {
		  		false, false, false, false, false
		  	};
		  	public boolean isCellEditable(int row, int column) {
		  		return columnEditables[column];
		  	}
		  });
		  scrollPane.setViewportView(s_table);
		  panel2.setLayout(gl_panel2);
		  tabbedPane.setEnabledAt (2, true);
		  tabbedPane.setTitleAt (2,"查询宠物");
		   
		  tabbedPane.addTab ("panel3", panel3);
		  
		  JPanel panel_1 = new JPanel();
		  panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  
		  JLabel label_6 = new JLabel("宠物名称：");
		  
		  m_petName = new JTextField();
		  m_petName.setColumns(10);
		  m_petName.setEditable(false);
		  JLabel label_7 = new JLabel("宠物类别：");
		  
		  m_petTypeJcb = new JComboBox();
		  m_petTypeJcb.setEnabled(false);
		  
		  JLabel label_8 = new JLabel("宠物颜色：");
		  
		  m_petColor = new JTextField();
		  m_petColor.setColumns(10);
		  
		  ModifyButton = new JButton("修改");
		  ModifyButton.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop1.0\\src\\image\\modify.png"));
		  
		  m_petAgeTxt = new JTextField();
		  m_petAgeTxt.setColumns(10);
		  
		  JLabel label_15 = new JLabel("宠物年龄：");
		  
		  JLabel label_17 = new JLabel("宠物新名：");
		  
		  m_petNewName = new JTextField();
		  m_petNewName.setColumns(10);
		  GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		  gl_panel_1.setHorizontalGroup(
		  	gl_panel_1.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel_1.createSequentialGroup()
		  			.addGap(20)
		  			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel_1.createSequentialGroup()
		  					.addComponent(label_17)
		  					.addPreferredGap(ComponentPlacement.RELATED)
		  					.addComponent(m_petNewName, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
		  				.addGroup(Alignment.TRAILING, gl_panel_1.createParallelGroup(Alignment.LEADING)
		  					.addGroup(gl_panel_1.createSequentialGroup()
		  						.addComponent(label_6)
		  						.addPreferredGap(ComponentPlacement.RELATED)
		  						.addComponent(m_petName, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
		  					.addGroup(gl_panel_1.createSequentialGroup()
		  						.addComponent(label_8)
		  						.addPreferredGap(ComponentPlacement.RELATED)
		  						.addComponent(m_petColor, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))))
		  			.addGap(27)
		  			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		  				.addComponent(ModifyButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		  				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
		  					.addGroup(gl_panel_1.createSequentialGroup()
		  						.addComponent(label_7)
		  						.addPreferredGap(ComponentPlacement.RELATED)
		  						.addComponent(m_petTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		  					.addGroup(gl_panel_1.createSequentialGroup()
		  						.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
		  						.addPreferredGap(ComponentPlacement.RELATED)
		  						.addComponent(m_petAgeTxt, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
		  			.addGap(59))
		  );
		  gl_panel_1.setVerticalGroup(
		  	gl_panel_1.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel_1.createSequentialGroup()
		  			.addContainerGap()
		  			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel_1.createSequentialGroup()
		  					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(label_7)
		  						.addComponent(m_petTypeJcb, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		  					.addPreferredGap(ComponentPlacement.UNRELATED)
		  					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		  						.addGroup(gl_panel_1.createSequentialGroup()
		  							.addGap(3)
		  							.addComponent(label_15))
		  						.addComponent(m_petAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		  					.addPreferredGap(ComponentPlacement.UNRELATED)
		  					.addComponent(ModifyButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		  				.addGroup(gl_panel_1.createSequentialGroup()
		  					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(label_6)
		  						.addComponent(m_petName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		  					.addGap(13)
		  					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(label_17)
		  						.addComponent(m_petNewName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		  					.addPreferredGap(ComponentPlacement.UNRELATED)
		  					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
		  						.addComponent(label_8)
		  						.addComponent(m_petColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		  			.addContainerGap())
		  );
		  panel_1.setLayout(gl_panel_1);
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  GroupLayout gl_panel3 = new GroupLayout(panel3);
		  gl_panel3.setHorizontalGroup(
		  	gl_panel3.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel3.createSequentialGroup()
		  			.addGap(33)
		  			.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
		  				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))
		  			.addContainerGap(34, Short.MAX_VALUE))
		  );
		  gl_panel3.setVerticalGroup(
		  	gl_panel3.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel3.createSequentialGroup()
		  			.addContainerGap()
		  			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
		  			.addGap(18)
		  			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
		  			.addGap(7))
		  );
		  
		  m_table = new JTable();
		  m_table.setModel(new DefaultTableModel(
		  	new Object[][] {
		  	},
		  	new String[] {
		  		"\u7F16\u53F7", "\u5BA0\u7269\u540D\u79F0", "\u5BA0\u7269\u5E74\u9F84", "\u5BA0\u7269\u989C\u8272", "\u5BA0\u7269\u7C7B\u522B"
		  	}
		  ) {
		  	boolean[] columnEditables = new boolean[] {
		  		false, false, false, false, false
		  	};
		  	public boolean isCellEditable(int row, int column) {
		  		return columnEditables[column];
		  	}
		  });
		  scrollPane_1.setViewportView(m_table);
		  panel3.setLayout(gl_panel3);
		  tabbedPane.setEnabledAt (3, true);
		  tabbedPane.setTitleAt (3,"修改宠物");
		   
		  tabbedPane.addTab ("panel4", panel4);
		  
		  JScrollPane scrollPane_2 = new JScrollPane();
		  
		  JPanel panel_2 = new JPanel();
		  panel_2.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  
		  d_petAgeTxt = new JTextField();
		  d_petAgeTxt.setEditable(false);
		  d_petAgeTxt.setColumns(10);
		  
		  JLabel label_9 = new JLabel("宠物年龄：");
		  
		  JLabel label_10 = new JLabel("宠物名称：");
		  
		  d_petNameTxt = new JTextField();
		  d_petNameTxt.setColumns(10);
		  d_petNameTxt.setEditable(false);
		  
		  JLabel label_11 = new JLabel("宠物类别：");
		  
		  d_petTypeJcb = new JComboBox();
		  d_petTypeJcb.setEnabled(false);
		  
		  JLabel label_16 = new JLabel("宠物颜色：");
		  
		  d_petColorTxt = new JTextField();
		  d_petColorTxt.setEditable(false);
		  d_petColorTxt.setColumns(10);
		  
		  DeleteButton = new JButton("删除");
		  DeleteButton.setIcon(new ImageIcon("E:\\程序试做\\java课\\PetShop1.0\\src\\image\\delete.png"));
		  GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		  gl_panel_2.setHorizontalGroup(
		  	gl_panel_2.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel_2.createSequentialGroup()
		  			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel_2.createSequentialGroup()
		  					.addGap(20)
		  					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
		  						.addGroup(gl_panel_2.createSequentialGroup()
		  							.addComponent(label_10)
		  							.addPreferredGap(ComponentPlacement.RELATED)
		  							.addComponent(d_petNameTxt, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
		  							.addPreferredGap(ComponentPlacement.RELATED))
		  						.addGroup(gl_panel_2.createSequentialGroup()
		  							.addComponent(label_16)
		  							.addPreferredGap(ComponentPlacement.RELATED)
		  							.addComponent(d_petColorTxt, 0, 0, Short.MAX_VALUE)))
		  					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
		  						.addGroup(gl_panel_2.createSequentialGroup()
		  							.addGap(44)
		  							.addComponent(label_11)
		  							.addPreferredGap(ComponentPlacement.RELATED)
		  							.addComponent(d_petTypeJcb, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
		  						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
		  							.addGap(44)
		  							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
		  							.addPreferredGap(ComponentPlacement.RELATED)
		  							.addComponent(d_petAgeTxt, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
		  				.addGroup(gl_panel_2.createSequentialGroup()
		  					.addGap(109)
		  					.addComponent(DeleteButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
		  			.addContainerGap(22, Short.MAX_VALUE))
		  );
		  gl_panel_2.setVerticalGroup(
		  	gl_panel_2.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel_2.createSequentialGroup()
		  			.addContainerGap()
		  			.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(label_10)
		  				.addComponent(d_petNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(label_11)
		  				.addComponent(d_petTypeJcb, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		  			.addPreferredGap(ComponentPlacement.UNRELATED)
		  			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
		  				.addGroup(gl_panel_2.createSequentialGroup()
		  					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
		  						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
		  							.addComponent(label_16)
		  							.addComponent(d_petColorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		  						.addGroup(gl_panel_2.createSequentialGroup()
		  							.addGap(3)
		  							.addComponent(label_9)))
		  					.addPreferredGap(ComponentPlacement.UNRELATED)
		  					.addComponent(DeleteButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		  				.addComponent(d_petAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		  			.addGap(8))
		  );
		  panel_2.setLayout(gl_panel_2);
		  GroupLayout gl_panel4 = new GroupLayout(panel4);
		  gl_panel4.setHorizontalGroup(
		  	gl_panel4.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel4.createSequentialGroup()
		  			.addGap(33)
		  			.addGroup(gl_panel4.createParallelGroup(Alignment.LEADING)
		  				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))
		  			.addContainerGap(34, Short.MAX_VALUE))
		  );
		  gl_panel4.setVerticalGroup(
		  	gl_panel4.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_panel4.createSequentialGroup()
		  			.addContainerGap()
		  			.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
		  			.addGap(18)
		  			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
		  			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		  );
		  
		  d_table = new JTable();
		  d_table.setModel(new DefaultTableModel(
		  	new Object[][] {
		  	},
		  	new String[] {
		  		"\u7F16\u53F7", "\u5BA0\u7269\u540D\u79F0", "\u5BA0\u7269\u5E74\u9F84", "\u5BA0\u7269\u989C\u8272", "\u5BA0\u7269\u7C7B\u522B"
		  	}
		  ) {
		  	boolean[] columnEditables = new boolean[] {
		  		false, false, false, false, false
		  	};
		  	public boolean isCellEditable(int row, int column) {
		  		return columnEditables[column];
		  	}
		  });
		  scrollPane_2.setViewportView(d_table);
		  panel4.setLayout(gl_panel4);
		  tabbedPane.setEnabledAt(4,true);
		  tabbedPane.setTitleAt(4,"删除宠物");
		  

		   
		///设置其大小以及其选项卡的位置方向
		  tabbedPane.setPreferredSize (new Dimension (500,200));
		 tabbedPane.setTabPlacement (JTabbedPane.TOP);
		///设置选项卡在容器内的显示形式
		  tabbedPane.setTabLayoutPolicy (JTabbedPane.SCROLL_TAB_LAYOUT);
		 // Jframe.pack();
		
		
		tabbedPane.setToolTipText("");
		panel.add(tabbedPane, "name_433879155138316");
		contentPane.setLayout(gl_contentPane);
		
		MyEvent();
		
		
	}
	

	
	/**
	 * 添加事件
	 */
	private void MyEvent(){
		//Link();
		String type=null;
		fillTable(type);
		fillPetType("search");
		fillPetType("delete");
		fillPetType("modify");
		fillPetType("add");
		
		DeleteButton.addActionListener(new ActionListener() {             
            public void actionPerformed(ActionEvent e) {  
            	DeleteActionPerformed(e);  
            	String type=null;
        		fillTable(type);
        		fillPetType("search");
        		fillPetType("delete");
        		fillPetType("modify");
        		fillPetType("add");
            }  
        });  
		
		ModifyButton.addActionListener(new ActionListener() {             
            public void actionPerformed(ActionEvent e) {  
            	ModifyActionPerformed(e);  
            	String type=null;
        		fillTable(type);
        		fillPetType("search");
        		fillPetType("delete");
        		fillPetType("modify");
        		fillPetType("add");
            }  
        }); 
        
		
		AddButton.addActionListener(new ActionListener() {             
            public void actionPerformed(ActionEvent e) {  
            	AddActionPerformed(e);  
            	String type=null;
        		fillTable(type);
        		fillPetType("search");
        		fillPetType("delete");
        		fillPetType("modify");
        		fillPetType("add");
            }  
        });   
		
		SearchButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SearchActionPerformed(e);
            	String type=null;
        		fillPetType("search");
        		fillPetType("delete");
        		fillPetType("modify");
        		fillPetType("add");
				
			}
		});
		m_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				modify_petTableMousePressed(met);
			}
		});
		d_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				delete_petTableMousePressed(met);
			}
		});
		
		
		
		
	}
	
	
	private void AddActionPerformed(ActionEvent evt){
	//	private JTextField add_petNameTxt;
	//	private JTextField add_petColor;
	//	private JTextField add_petTypeTxt;
	//	private JTextField add_petAgeTxt;

		
		String type =  (String)add_petTypeJcb.getSelectedItem();
		//String type =  add_petTypeTxt.getText();
		String name =  add_petNameTxt.getText();
		String age =   add_petAgeTxt.getText();
		String color = add_petColor.getText();
		
		if(name.equals("")){
			JOptionPane.showMessageDialog(null, "宠物名称不能为空！");
			return;
		}
		if(age.equals("")){
			JOptionPane.showMessageDialog(null, "宠物年龄不能为空！");
			return;
		}
		if(color.equals("")){
			JOptionPane.showMessageDialog(null, "宠物颜色不能为空！");
			return;
		}
		if(type.equals("")){
			JOptionPane.showMessageDialog(null, "宠物类别不能为空！");
			return;
		}
		
		if(!dBoperator.ExistPetType(type)){
			try {
				dBoperator.AddPetType(type);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		Pet newPet = new Pet(name, age, color);
		
		try {
			dBoperator.AddPet(type, name, age, color);
			JOptionPane.showMessageDialog(null, "宠物添加成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	/**
	 * 获取连接服务器
	 * 
	 */
	private void Link(){
		
		if(socket != null && socket.isConnected()){   
            JOptionPane.showMessageDialog(contentPane, "已经连接成功！");  
        }else {  
    
              
            if("".equals(ipString) || "".equals(portClient)){//判断获取内容是否为空  
                JOptionPane.showMessageDialog(contentPane, "ip或端口号为空！");  
            }else {  
                try {  
                    int ports = Integer.parseInt(portClient);//将端口号转为整形  
                    socket = new Socket(ipString,ports);//建立连接  
                    System.out.println("连接服务器成功");
                    linked=true;
                    
                  //  new SendClient(oos, getName(), 2 + "");//发送该客户端名称至服务器  
                    new Thread(new ReceiveClient(socket)).start();//启动接收线程  
                } catch (Exception e2) {  
                    JOptionPane.showMessageDialog(contentPane, "连接未成功！可能是ip或端口号格式不对，或服务器未开启。");  
                }  
            }  
        }  
	}
	
	/**
	 * 鼠标点击修改表格一行
	 */

	private void modify_petTableMousePressed(MouseEvent met) {
		int row=this.m_table.getSelectedRow();
		
		this.m_petName.setText((String)m_table.getValueAt(row, 1));
		this.m_petAgeTxt.setText((String)m_table.getValueAt(row, 2));
		this.m_petColor.setText((String)m_table.getValueAt(row, 3));
		
		
		int n=this.m_petTypeJcb.getItemCount();
		
		/*
		for(int i=0;i<n;i++){
			PetType item=(PetType)this.petTypeJcb.getItemAt(i);
			if(item.getPetTypeName().equals(petTypeName)){
				this.m_petTypeJcb.setSelectedIndex(i);
			}
		}*/
	}
	/**
	 * 鼠标点击删除表格一行
	 */

	private void delete_petTableMousePressed(MouseEvent met) {
		int row=this.d_table.getSelectedRow();
		
		this.d_petNameTxt.setText((String)d_table.getValueAt(row, 1));
		this.d_petAgeTxt.setText((String)d_table.getValueAt(row, 2));
		this.d_petColorTxt.setText((String)d_table.getValueAt(row, 3));
		
		
		//int n=this.d_petTypeJcb.getItemCount();
		
		/*
		for(int i=0;i<n;i++){
			PetType item=(PetType)this.petTypeJcb.getItemAt(i);
			if(item.getPetTypeName().equals(petTypeName)){
				this.m_petTypeJcb.setSelectedIndex(i);
			}
		}*/
	}
	
	/**
	 * 初始化table
	 */
	private void fillTable(String type){
		//dtm.setRowCount(0);
		try {
			List<Pet> pets=dBoperator.listPet(type);
			for(int i=0;i<pets.size();i++){
				System.out.println("初始化table");
				innerFillTable(i,pets.get(i));
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void innerFillTable(int i,Pet pet){
		
		dtm=(DefaultTableModel) s_table.getModel();
		dtm2=(DefaultTableModel) m_table.getModel();
		dtm3=(DefaultTableModel) d_table.getModel();
		if(i==0){
			dtm.setRowCount(0);
			dtm2.setRowCount(0);
			dtm3.setRowCount(0);
		}
		Vector<String> v=new Vector<String>();
		v.add(i+1+"");
		v.add(pet.getName());
		v.add(pet.getAge());
		v.add(pet.getColor());
		v.add(pet.getType());
		dtm.addRow(v);
		dtm2.addRow(v);
		dtm3.addRow(v);

	}
	/**
	 * 查询宠物
	 */
	private void SearchActionPerformed(ActionEvent evt){
		//	private JTextField add_petNameTxt;
		//	private JTextField add_petColor;
		//	private JTextField add_petTypeTxt;
		//	private JTextField add_petAgeTxt;

			String type =  (String)s_petType.getSelectedItem();
			String name =  s_petName.getText();
			String age =   s_petAgeTxt.getText();
			String color = s_petColorTxt.getText();
			
			if(!type.equals("请选择...")&&name.equals("")){
				try {
					List<Pet> petList=dBoperator.listPet(type);
					for(int i=0;i<petList.size();i++){
						innerFillTable(i, petList.get(i));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
				
			}
			
			if(type.equals("请选择...")&&name.equals("")){
				System.out.println(type);
				String string = null;
				fillTable(string);
				return;
				
			}
			/*
			if(name.equals("")){
				System.out.println(type);
				String string = null;
				fillTable(string);
				return;
			}*/
			
			try {
				try {
					Pet oldPet=dBoperator.SearchPet(name);
					if(oldPet==null){
						JOptionPane.showMessageDialog(null, "宠物不存在！");
					}
					s_petAgeTxt.setText(oldPet.getAge());
					s_petColorTxt.setText(oldPet.getColor());
					s_petName.setText(oldPet.getName());
					innerFillTable(0, oldPet);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	private void fillPetType(String choosetype){
		String petType;
		try{
			if("add".equals(choosetype)){
				petType=new String("请添加...");
				this.add_petTypeJcb.addItem(petType);
			}
			
			if("search".equals(choosetype)){
				petType=new String("请选择...");
				this.s_petType.addItem(petType);
			}
			
			String petTypes[] = new File(dBoperator.path).list();
			
			for(int i=0;i<petTypes.length;i++){
				petType=petTypes[i];
				
				if("search".equals(choosetype)){
					this.s_petType.addItem(petType);
				}else if("modify".equals(choosetype)){
					this.m_petTypeJcb.addItem(petType);
				}else if("delete".equals(choosetype)){
					this.d_petTypeJcb.addItem(petType);
				}else if("add".equals(choosetype)){
					this.add_petTypeJcb.addItem(petType);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	
	/**
	 * 删除宠物
	 */
	private void DeleteActionPerformed(ActionEvent evt){
		//	private JTextField add_petNameTxt;
		//	private JTextField add_petColor;
		//	private JTextField add_petTypeTxt;
		//	private JTextField add_petAgeTxt;
			
			
			String name =  d_petNameTxt.getText();
			
			String type =  new Pet(name).getType();
			
			String age =   d_petAgeTxt.getText();
			String color = d_petColorTxt.getText();
			
			if(name.equals("")){
				JOptionPane.showMessageDialog(null, "宠物姓名不能为空！");
				return;
			}
			int n=JOptionPane.showConfirmDialog(null, "确定删除吗？");
			if(n==0){
				
				try{
					
					int deleteNum=dBoperator.DeletePet(type, name);
					if(deleteNum==1){
						JOptionPane.showMessageDialog(null, "删除成功！");
						String typeString = null;
						fillTable(typeString);
						
					}else{
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "删除失败！");
				}finally{
					
				}
			}
			
		}
	/**
	 * 修改宠物
	 */
	private void ModifyActionPerformed(ActionEvent evt){
		//	private JTextField add_petNameTxt;
		//	private JTextField add_petColor;
		//	private JTextField add_petTypeTxt;
		//	private JTextField add_petAgeTxt;
			
			
			String name =  m_petName.getText();
			
			String newname = m_petNewName.getText();
			
			String type =  new Pet(name).getType();
			
			String age =   m_petAgeTxt.getText();
			String color = m_petColor.getText();
			
			if(newname.equals("")){
				JOptionPane.showMessageDialog(null, "宠物新名不能为空！");
				return;
			}
			int n=JOptionPane.showConfirmDialog(null, "确定修改吗？");
			if(n==0){
				
				try{
					
					int deleteNum=dBoperator.UpdatePet(type, name, newname, age, color);
					if(deleteNum==1){
						JOptionPane.showMessageDialog(null, "修改成功！");
						String typeString = null;
						fillTable(typeString);
					}else{
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
				}catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "修改失败！");
				}finally{
					
				}
			}
			
		}
}
