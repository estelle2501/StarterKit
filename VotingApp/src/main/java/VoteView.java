import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.hibernate.Query;
import org.hibernate.Session;

public class VoteView extends JPanel implements ActionListener {

	private AppFrame appFrame;
	private String enteredZipCode;
	private static final int AMOUNT_OF_CANDIDATES = 3;
	private Session session;
	JRadioButton rBCandidate1, rBCandidate2, rBCandidate3;
	ButtonGroup bGroupCandidates = new ButtonGroup();

	public VoteView(AppFrame aFrame, String eZipCode, Session s) {
		appFrame = aFrame;
		enteredZipCode = eZipCode;
		session = s;
		initVoteView(appFrame);
	}

	// initializing VoteView with Candidate and Vote Panels
	private void initVoteView(AppFrame appFrame) {
		appFrame.getContentPane().removeAll();
		appFrame.setTitle("Okreg wyborczy " + enteredZipCode);
		appFrame.add(this);
		this.setLayout(new GridLayout(2, 1));
		this.addCandidatePanel();
		this.addVotePanel();
		appFrame.getContentPane().revalidate();

	}

	// adding Vote Panel with Button Vote
	private void addVotePanel() {
		JPanel votePanel = new JPanel();
		this.add(votePanel);
		votePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton buttonVote = new JButton("Glosuj");
		votePanel.add(buttonVote);
		buttonVote.addActionListener(this);
	}

	// adding candidate panel
	private void addCandidatePanel() {
		JPanel candidatePanel = new JPanel();
		this.add(candidatePanel);
		addCandidatesButtons(candidatePanel);
	}

	// adding RadioButtons to candidate panel
	private void addCandidatesButtons(JPanel candidatePanel) {

		candidatePanel.setLayout(new GridLayout(AMOUNT_OF_CANDIDATES, 1));

		Query query1 = session
				.createQuery("from ZipCodes Z where Z.zipCode =:zipCode");
		query1.setParameter("zipCode", enteredZipCode);
		List<ZipCodes> zipCodeList = query1.list();
		ZipCodes z = zipCodeList.get(0);
		long zipCodeId = z.getId();

		Query query = session
				.createQuery("select C from Candidates as C where zip_codes_id =:zip_codes_id");
		query.setParameter("zip_codes_id", zipCodeId);

		List<Candidates> candidatesList = query.list();

		// create radioButtons with Candidates from chosen ZipCode
		// for (int i = 0; i < AMOUNT_OF_CANDIDATES; i++) {
		rBCandidate1 = new JRadioButton(candidatesList.get(0).getFirstName()
				+ " " + candidatesList.get(0).getSurname());
		bGroupCandidates.add(rBCandidate1);
		candidatePanel.add(rBCandidate1);

		rBCandidate2 = new JRadioButton(candidatesList.get(1).getFirstName()
				+ " " + candidatesList.get(1).getSurname());
		bGroupCandidates.add(rBCandidate2);
		candidatePanel.add(rBCandidate2);

		rBCandidate3 = new JRadioButton(candidatesList.get(2).getFirstName()
				+ " " + candidatesList.get(2).getSurname());
		bGroupCandidates.add(rBCandidate3);
		candidatePanel.add(rBCandidate3);
		// }

	}

	public void actionPerformed(ActionEvent e) {
		if (rBCandidate1.isSelected()) {		
			saveChosenCandidate(rBCandidate1.getText());
			
		}
		if (rBCandidate2.isSelected()) {
			saveChosenCandidate(rBCandidate2.getText());
		}
		if (rBCandidate3.isSelected()) {
			saveChosenCandidate(rBCandidate3.getText());
		}
	
	
	}

	private void saveChosenCandidate(String chosenCandidate) {
		JOptionPane.showMessageDialog(null, "Wybrano kandydata: " + chosenCandidate);
		HibernateConnection.shutdown();
		System.exit(0);		
	}

}
