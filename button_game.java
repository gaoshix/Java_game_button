import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Hello extends JFrame implements ActionListener{

	ImageIcon background_icon1, background_icon2, background_icon3;	
	JLabel lb;	
	JButton[] bn;	
	static boolean[] flag1 = new boolean[16];	
	static boolean[] flag2 = new boolean[16];	
	static boolean click;	
	static int click_i;	
	static boolean move;	
	public Hello(){
	
		this.setTitle("MidProject");	
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		this.setVisible(true); 
		this.setSize(400,700);	
		
		
		JPanel main_jp = new JPanel();	// 產生一個主要的JPanel,並且拿來做BorderLayout切割呈上,中,下三個JPanel
		main_jp.setLayout(new BorderLayout());	
		
		JPanel sub_jp1 = new JPanel(); 	// 最上面的JPanel
		String bgPath1 = "C:/Users/NTUE/Desktop/images/OR1.png";	// 取得背景圖的相對位置
		background_icon1 = new ImageIcon(bgPath1); // 產生一個imageicon
		lb = new JLabel("",background_icon1, SwingConstants.CENTER);	// 產生一個JLabel,用來放背景圖,並且至於JLabel的中間
		sub_jp1.add(lb);	// 將JLabel放到第一個JPanel的裡面
		main_jp.add(sub_jp1, BorderLayout.NORTH);	// 將第一個JPanel放在主要的JPanel,並且放在北邊
		
		JPanel sub_jp2 = new JPanel();	// 中間的JPanel
		sub_jp2.setBackground(Color.black);	// 設定背景為black
		GridLayout g1 = new GridLayout(4,4);	// 設定排版方式
		sub_jp2.setLayout(g1);
			
		String bgPath2 = "C:/Users/NTUE/Desktop/images/orange1.png";	// 取得圖片的相對位置
		background_icon2 = new ImageIcon(bgPath2);	// 產生一個imageicon
		background_icon2.setImage(background_icon2.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));	// 設定imageicon的大小,讓他能符合button的大小
		bn = new JButton[16];	// 產生16個button
		JButton temp;
		for(int i=0;i<bn.length;i++)
		{
			// button的設定
			temp = new JButton();	
			temp.setIcon(background_icon2);
			temp.setBackground(Color.black);
			temp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));	// 設定邊線是透明,以及left, top, right, bottom的間距
			temp.setHorizontalTextPosition(JButton.CENTER);	// 設定為字的顯示位置
			
			bn[i]=temp;	// 將產生出來的button給bn[i]
			
			// 透過html的語法讓文字產生變化
			if(i == 0)
				bn[i].setText("<html><h3><center>Enemy. 1</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			else if(i == 1)
				bn[i].setText("<html><h3><center>Enemy. 2</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			else if(i == 4)
				bn[i].setText("<html><h3><center>Enemy. 3</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			else if(i == 8)
				bn[i].setText("<html><h3><center>Enemy. 4</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			else if(i == 7)
				bn[i].setText("<html><h3><center>NO. 1</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			else if( i == 11)
				bn[i].setText("<html><h3><center>NO. 2</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			else if(i == 14)
				bn[i].setText("<html><h3><center>NO. 3</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			else if(i == 15)
				bn[i].setText("<html><h3><center>NO. 4</center><br><font color = 'red'><br><center>HP 100</br></center></font></html>");
			
			bn[i].setActionCommand(Integer.toString(i));	// 監控button,當被點擊時,傳回是哪一個button被點擊
			bn[i].addActionListener(this); 
			sub_jp2.add(bn[i]);	// 將button加入第二個JPanel裡面
		}
			
		main_jp.add(sub_jp2, BorderLayout.CENTER);	// 將第二個JPanel加入主要的JPanel,並且放在中間位置
		
		JPanel sub_jp3 = new JPanel();	// // 底部的JPanel
		sub_jp3.setBackground(Color.white);
		GridLayout g2 = new GridLayout(1,4);	// 設定排版方式
		sub_jp3.setLayout(g2);
		String bgPath3 = "C:/Users/NTUE/Desktop/images/six1.png";	// 取得圖片的相對位置
		background_icon3 = new ImageIcon(bgPath3);	// 產生一個imageicon
		
		//設定button的文字以及大小
		JButton no1 = new JButton("No.1"){
			 public Dimension getPreferredSize() {
			      return new Dimension(10, 57);
			   };
		};
		JButton no2 = new JButton("No.2"){
			 public Dimension getPreferredSize() {
			      return new Dimension(10, 57);
			   };
		};
		JButton no3 = new JButton("No.3"){
			 public Dimension getPreferredSize() {
			      return new Dimension(10, 57);
			   };
		};
		JButton no4 = new JButton("No.4"){
			 public Dimension getPreferredSize() {
			      return new Dimension(10, 57);
			   };
		};
		
		// 設定button的背景圖,不要顯示邊線,文字位置
		no1.setIcon(background_icon3);
		no1.setBackground(Color.white);
		no1.setBorderPainted(false);
		no1.setHorizontalTextPosition(JButton.CENTER);		
		no2.setIcon(background_icon3);
		no2.setBackground(Color.white);
		no2.setBorderPainted(false);
		no2.setHorizontalTextPosition(JButton.CENTER);
		no3.setIcon(background_icon3);
		no3.setBackground(Color.white);
		no3.setBorderPainted(false);
		no3.setHorizontalTextPosition(JButton.CENTER);
		no4.setIcon(background_icon3);
		no4.setBackground(Color.white);
		no4.setBorderPainted(false);
		no4.setHorizontalTextPosition(JButton.CENTER);
		sub_jp3.add(no1);	// 將button加入第三個JPanel
		sub_jp3.add(no2);
		sub_jp3.add(no3);
		sub_jp3.add(no4);
		main_jp.add(sub_jp3, BorderLayout.SOUTH);	// 將第三個JPanel加入主要的JPanel,並且放在南邊
		

		this.add(main_jp);	// 將主要的JPanel加入JFrame
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 設定初始的敵方位置和我方位置
		for(int i=0;i<16;i++)
		{
			if(i == 7 || i == 11 || i == 14 || i == 15)
				flag1[i] = true;
			else if(i == 0 || i == 1 || i == 4 || i == 8)
				flag2[i] = true;
		}
		click = false;	
		click_i = -1;	
		move = true;	
		Hello midproject = new Hello();
		midproject.setVisible(true);
		
		
	}
	
	// 清除button的邊線
	public void clear()
	{
		bn[click_i].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));	
		if((click_i+1)%4 != 0)	
			bn[click_i+1].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		if((click_i-4)>=0)	
			bn[click_i-4].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		if((click_i+4)<16)	
			bn[click_i+4].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		if((click_i-1)%4+1 == click_i%4)	
			bn[click_i-1].setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {	
		// TODO Auto-generated method stub
		String index = e.getActionCommand();	
		int value = Integer.valueOf(index);	
		
		
		if(flag1[value] == true)	// 如果是我方的button被點擊
		{
			if(click == true)	// 如果之前已經有我方的button被點擊,則先消除它附近的邊線
				clear();
		
			if(click_i == value && move == false) 
			{
				clear();
				click = false;	
				click_i = -1;	
				move = true;	
			}
			
			else 
			{
				bn[value].setBorder(BorderFactory.createLineBorder(Color.red, 5));	// 顯示我方的button邊線為紅色
				if((value+1)%4 != 0)	
				{
					if(flag2[value+1] == true)
						bn[value+1].setBorder(BorderFactory.createLineBorder(Color.yellow, 5));	// 如果是敵方的button,則顯示他的邊線是黃色
					else if(flag1[value+1] == false)
						bn[value+1].setBorder(BorderFactory.createLineBorder(Color.blue, 5));	// 如果是空白的button,則顯示他的邊線是藍色
				}
					
				if((value-4)>=0)	
				{
					if(flag2[value-4] == true)
						bn[value-4].setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
					else if(flag1[value-4] == false)
						bn[value-4].setBorder(BorderFactory.createLineBorder(Color.blue, 5));
				}
					
				if((value+4)<16)	
				{
					if(flag2[value+4] == true)
						bn[value+4].setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
					else if(flag1[value+4] == false)
						bn[value+4].setBorder(BorderFactory.createLineBorder(Color.blue, 5));
				}
					
				if((value-1)%4+1 == value%4)	
				{
					if(flag2[value-1] == true)
						bn[value-1].setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
					else if(flag1[value-1] == false)
						bn[value-1].setBorder(BorderFactory.createLineBorder(Color.blue, 5));
				}
					
				click = true;	
				click_i = value;	
				move = false;	
			}
			
		}
		
		else  if(flag2[value] == true && click == true)	// 如果是敵方的button被點擊,就清除之前的 邊線顏色
		{
			clear();
			click = false;
			click_i = -1;
			move = true;
		}
		
		else	// 如果是空白的button被點擊
		{
			if(click == true) 	// 之前已經有我方的button被點擊過一次
			{
				if(value == click_i-1 && click_i%4 != 0)	// 如果這個空白的button是位在上次被點擊過的我方button的左邊
				{
					clear();
					String str = bn[click_i].getText();
					bn[value].setText(str);		
					bn[click_i].setText("");	
					flag1[click_i] = false;
					flag1[value] = true; 	
					click_i = value;	
					click = false;	
					move = true;	
				}
				
				if((click_i-4) == value)	// 如果這個空白的button是位在上次被點擊過的我方button的上面
				{
					clear();
					String str = bn[click_i].getText();
					bn[value].setText(str);
					bn[click_i].setText("");		
					flag1[click_i] = false;
					flag1[value] = true;
					click_i = value;
					click = false;
					move = true;
				}
				
				if((click_i+4) == value)	// 如果這個空白的button是位在上次被點擊過的我方button的下面
				{
					clear();
					String str = bn[click_i].getText();
					bn[value].setText(str);
					bn[click_i].setText("");		
					flag1[click_i] = false;
					flag1[value] = true;
					click_i = value;
					click = false;
					move = true;
				}
				
				if(click_i+1 == value && value%4 != 0)	// 如果這個空白的button是位在上次被點擊過的我方button的右邊
				{
					clear();
					String str = bn[click_i].getText();
					bn[value].setText(str);
					bn[click_i].setText("");		
					flag1[click_i] = false;
					flag1[value] = true;
					click_i = value;
					click = false;
					move = true;
				}
				
			
				if(!(value == click_i-1 && click_i%4 != 0) && !((click_i-4) == value) && !((click_i+4) == value) && !(click_i+1 == value && value%4 != 0))
				{
					clear();
					click_i = value;
					click = false;
					move = true;
				}
			}	
		}	
	}
}
