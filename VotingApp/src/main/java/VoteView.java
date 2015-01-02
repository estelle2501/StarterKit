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
		enteredZipCode=eZipCode;
		session=s;
		initVoteView(appFrame);
	}

	// initializing VoteView with Candidate and Vote Panels
	private void initVoteView(AppFrame appFrame) {
		appFrame.getContentPane().removeAll();
		appFrame.setTitle("Okreg wyborczy " + enteredZipCode );
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
		
//		Query query = session
//				.createQuery("from Candidates C where C.zipCode =:zipCode ");
//		query.setParameter("zipCode", enteredZipCode);
//
//		List<Candidates> candidatesList = query.list();
//		Candidates c1 = candidatesList.get(0);
//		JRadioButton rBCandidate1 = new JRadioButton(c1.getFirstName() + " " + c1.getSurname());
		JRadioButton rBCandidate1 = new JRadioButton("Kandydat 1");
		JRadioButton rBCandidate2 = new JRadioButton("Kandydat 2");
		JRadioButton rBCandidate3 = new JRadioButton("Kandydat 3");
		

		ButtonGroup bGroupCandidates = new ButtonGroup();
		bGroupCandidates.add(rBCandidate1);
		bGroupCandidates.add(rBCandidate2);
		bGroupCandidates.add(rBCandidate3);
		candidatePanel.add(rBCandidate1);
		candidatePanel.add(rBCandidate2);
		candidatePanel.add(rBCandidate3);
	}

}
