package visual;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class NBtnCommon extends JButton {

	public NBtnCommon() {
		this.setBounds(5, 100, 100, 30);
		Font f = new Font(null, Font.BOLD, 20);
		this.setFont(f);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.GRAY);
	}
	
	public NBtnCommon(String name) {
		this.setText(name);
		this.setBounds(5, 100, name.length() * 15, 30);
		Font f = new Font(null, Font.BOLD, 20);
		this.setFont(f);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.GRAY);
	}
	
	@Override
	public void setText(String text) {
		super.setText(text);
		this.setSize(text.length() * 12, 30);
	}
}
