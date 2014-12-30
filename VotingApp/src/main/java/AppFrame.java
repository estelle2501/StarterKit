import javax.swing.JFrame;

public class AppFrame extends JFrame {

	public AppFrame(){
		super("Login");
		initAppFrame();
	}

	private void initAppFrame() {
		//creating Application's Frame
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(getSize());
		this.setResizable(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
