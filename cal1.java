package calculator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cal1 extends JFrame{
	private JTextField txt;
	private JPanel panel;
	private int result=0,input=0;
	private char c=' ';
	
	void addnumButton(String s){
		JButton btn = new JButton(s);
		btn.addActionListener(new numListener());
		btn.setPreferredSize(new Dimension(100,100));
		panel.add(btn);
	}
	
	void input2result(){
		result=input;
		input=0;
	}
	
	public cal1(){
		txt = new JTextField(20);
		add(txt,BorderLayout.NORTH);
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,5));
		add(panel,BorderLayout.CENTER);
		addnumButton("1");
		addnumButton("2");
		addnumButton("3");
		
		JButton btn = new JButton("=");
		btn.addActionListener(e->{
			switch (c){
			case '+':result += input; input = 0; txt.setText(""+result); c=' '; break;
			case '-':result -= input; input = 0; txt.setText(""+result); c=' '; break;
			case '*':result *= input; input = 0; txt.setText(""+result); c=' '; break;
			case '/':result /= input; input = 0; txt.setText(""+result); c=' '; break;
			}
		});
		btn.setPreferredSize(new Dimension(100,100));
		panel.add(btn);
		
		JButton btn2 = new JButton("C");
		btn2.addActionListener(e->{
			result=0;
			input=0;
			txt.setText(""+input);
		});
		btn2.setPreferredSize(new Dimension(100,100));
		panel.add(btn2);
		
		addnumButton("4");
		addnumButton("5");
		addnumButton("6");
		
		JButton btn3 = new JButton("+");
		btn3.addActionListener(e->{
			if(input==0){}
			else if(c==' '&&result==0)input2result();
			else{
				result+=input;
				input=0;}
			c='+';
		});
		btn3.setPreferredSize(new Dimension(100,100));
		panel.add(btn3);
		
		JButton btn4 = new JButton("-");
		btn4.addActionListener(e->{
			if(input==0){}
			else if(c==' '&&result==0)input2result();
			else{
				result-=input;
				input=0;}
			c='-';
		});
		btn4.setPreferredSize(new Dimension(100,100));
		panel.add(btn4);
				
		addnumButton("7");
		addnumButton("8");
		addnumButton("9");
		
		JButton btn5 = new JButton("X");
		btn5.addActionListener(e->{
			if(input==0){}
			else if(c==' '&&result==0)input2result();
			else{
				result*=input;
				input=0;}
			c='*';
		});
		btn5.setPreferredSize(new Dimension(100,100));
		panel.add(btn5);
		
		JButton btn6 = new JButton("/");
		btn6.addActionListener(e->{
			if(input==0){}
			else if(c==' '&&result==0)input2result();
			else{
				result/=input;
				input=0;}
			c='/';
		});
		btn6.setPreferredSize(new Dimension(100,100));
		panel.add(btn6);
		
		addnumButton("0");
		
		JButton btn7 = new JButton("");
		btn7.setPreferredSize(new Dimension(100,100));
		panel.add(btn7);
		JButton btn8 = new JButton("");
		btn7.setPreferredSize(new Dimension(100,100));
		panel.add(btn8);
		
		JButton btn9 = new JButton("ก็");
		btn9.addActionListener(e->{
			input/=10;
			txt.setText(""+input);
		});
		btn9.setPreferredSize(new Dimension(100,100));
		panel.add(btn9);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("calculator");
		setVisible(true);
	}
	private class numListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String actionCommand = e.getActionCommand();
			if(c==' ')result=0;
			input = input*10 + Integer.parseInt(actionCommand);
			txt.setText(""+input);
		}
	}
	
	public static void main(String args[]){
		new cal1();
	}
}

