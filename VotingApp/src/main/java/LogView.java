import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

public class LogView extends JPanel {

	private static final int PESEL_LENGTH = 11;
	private static final int LABEL_LENGHT = 10;
	private AppFrame appFrame;

	public LogView(AppFrame aFrame) {
		appFrame = aFrame;
		initLogView(appFrame);
	}

	// initializing Logging view
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
		JFormattedTextField textPesel = new JFormattedTextField(
				createFormatter("###########"));
		textPesel.setColumns(PESEL_LENGTH);

		panelPesel.add(labelPesel);
		panelPesel.add(textPesel);
	}

	// adding Login panel
	private void addPanelLogin() {
		JPanel panelLogin = new JPanel();
		this.add(panelLogin);
		panelLogin.setLayout(new FlowLayout());
		JButton buttonLogin = new JButton("Login");
		panelLogin.add(buttonLogin);

	}

	// creating Formatter to Pesel text field
	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("Nieprawidlowy PESEL");
		}
		return formatter;
	}

}
