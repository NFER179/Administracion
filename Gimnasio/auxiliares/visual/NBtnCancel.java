package visual;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class NBtnCancel extends JButton {

	public NBtnCancel() {
		this.setBounds(5, 100, 100, 30);
		Font f = new Font(null, Font.BOLD, 20);
		this.setFont(f);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.RED);
	}
	
	public NBtnCancel(String name) {
		this.setText(name);
		this.setBounds(5, 100, name.length() * 15, 30);
		Font f = new Font(null, Font.BOLD, 20);
		this.setFont(f);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.RED);
	}
	
	@Override
	public void setText(String text) {
		super.setText(text);
		this.setSize(text.length() * 12, 30);
	}
}