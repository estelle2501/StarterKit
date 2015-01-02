import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.hibernate.Query;
import org.hibernate.Session;

public class VoteView extends JPanel {

	private AppFrame appFrame;
	private String enteredZipCode;
	private static final int AMOUNT_OF_CANDIDATES = 3;
	private Session session;

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

		JRadioButton rBCandidate;
		ButtonGroup bGroupCandidates = new ButtonGroup();
		// create radioButtons with Candidates from chosen ZipCode
		for (int i = 0; i < AMOUNT_OF_CANDIDATES; i++) {
			rBCandidate = new JRadioButton(candidatesList.get(i).getFirstName()
					+ " " + candidatesList.get(i).getSurname());
			bGroupCandidates.add(rBCandidate);
			candidatePanel.add(rBCandidate);
		}

	}

}
