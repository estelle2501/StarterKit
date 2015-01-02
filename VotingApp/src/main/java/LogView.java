import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.hibernate.Query;
import org.hibernate.Session;

public class LogView extends JPanel implements ActionListener {

	private static final int LABEL_LENGHT = 10;
	private AppFrame appFrame;
	JButton buttonLogin;
	PeselField peselField;
	Session session;

	public LogView(AppFrame aFrame, Session s) {
		appFrame = aFrame;
		session = s;
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
		// getting ZipCodes from ElectionsDB
		Query query = session.createQuery("from ZipCodes");
		List<ZipCodes> zipCodesList = query.list();
		for (ZipCodes z : zipCodesList) {
			modelZipCode.addElement(z.getZipCode());
		}
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
