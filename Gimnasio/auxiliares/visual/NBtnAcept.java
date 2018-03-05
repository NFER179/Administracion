package visual;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class NBtnAcept extends JButton{

	private int alto = 30;
	private int ancho;
	
	public NBtnAcept() {
		this.setBounds(5, 100, 100, 30);
		Font f = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
		this.setFont(f);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.GREEN);
	}
	
	public NBtnAcept(String name) {
		this.setText(name);
		this.ancho = name.length() * 15;
		this.setBounds(5, 100, this.ancho, this.alto);
		Font f = new Font(null, Font.BOLD, 20);
		this.setFont(f);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.GREEN);
	}
	
	public void setPosition(int x, int y) {
		this.setBounds(x, y, this.ancho, this.alto);
	}
	
	@Override
	public void setText(String text) {
		super.setText(text);
		this.setSize(text.length() * 12, 30);
	}
}