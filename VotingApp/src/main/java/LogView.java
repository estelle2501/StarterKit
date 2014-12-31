import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LogView extends JPanel implements ActionListener {

	private static final int LABEL_LENGHT = 10;
	private AppFrame appFrame;
	JButton buttonLogin;
	PeselField peselField;

	public LogView(AppFrame aFrame) {
		appFrame = aFrame;
		initLogView(appFrame);
	}

	// initializing Logging view with ZipCode, Pesel and Login Panels
	private void initLogView(AppFrame appFrame) {
		appFrame.add(this);
		this.setLayout(new GridLayout(3, 1));
		this.addPanelZipCode();
		this.addPanelPesel();
		this.addPanelLogin();
		appFrame.getContentPane().revalidate();

	}

	// adding ZipCode panel
	private void addPanelZipCode() {
		JPanel panelZipCode = new JPanel();
		JLabel labelZipCode = new JLabel("Kod Pocztowy", LABEL_LENGHT);
		panelZipCode.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 10));
		panelZipCode.add(labelZipCode);

		// creating ScrollPane ZipCode
		DefaultComboBoxModel<String> modelZipCode = new DefaultComboBoxModel<String>();
		modelZipCode.addElement("");
		modelZipCode.addElement("50-555");
		modelZipCode.addElement("50-554");
		JComboBox<String> comboZipCode = new JComboBox<String>(modelZipCode);
		JScrollPane scrollZipCode = new JScrollPane(comboZipCode);
		panelZipCode.add(scrollZipCode);

		this.add(panelZipCode);
	}

	// adding Pesel panel
	private void addPanelPesel() {
		JPanel panelPesel = new JPanel();
		this.add(panelPesel);
		panelPesel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 10));

		JLabel labelPesel = new JLabel("PESEL", LABEL_LENGHT);
		peselField = new PeselField();
		peselField.addListener();

		panelPesel.add(labelPesel);
		panelPesel.add(peselField);
	}

	// adding Login panel
	private void addPanelLogin() {
		JPanel panelLogin = new JPanel();
		this.add(panelLogin);
		panelLogin.setLayout(new FlowLayout());
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(this);
		panelLogin.add(buttonLogin);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonLogin) {
			if (peselField.PeselValidate()) {
				VoteView voteView = new VoteView(appFrame);
			}
		}

	}

}
