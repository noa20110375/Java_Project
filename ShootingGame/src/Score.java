import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Score  extends JFrame{

	private JPanel score = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("아이디 ");
	private JTextField idText = new JTextField();

	public Score() {
	
		super("스코어!");


		this.setContentPane(score);
		score.add(idLabel);
		idLabel.setHorizontalAlignment(NORMAL);
		 setTitle("Score");
		 
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			
			
			setSize(600,450);

			this.setLocationRelativeTo(null);


			this.setVisible(true);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
}