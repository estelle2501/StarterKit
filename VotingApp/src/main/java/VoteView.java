import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VoteView extends JPanel {

	private AppFrame appFrame;

	public VoteView(AppFrame aFrame) {
		appFrame = aFrame;
		initVoteView(appFrame);
	}

	private void initVoteView(AppFrame appFrame) {
		appFrame.getContentPane().removeAll();
		appFrame.setTitle("Okreg wyborczy");
		appFrame.add(this);
		this.setLayout(new GridLayout(2, 1));
		this.addCandidatePanel();
		this.addVotePanel();
		appFrame.getContentPane().revalidate();

	}

	private void addVotePanel() {
		JPanel votePanel = new JPanel();
		this.add(votePanel);		
		votePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton buttonVote = new JButton("Glosuj");
		votePanel.add(buttonVote);
	}

	private void addCandidatePanel() {
		JPanel candidatePanel = new JPanel();
		this.add(candidatePanel);
		addCandidatesButtons(candidatePanel);
	}

	private void addCandidatesButtons(JPanel candidatePanel) {
		
		candidatePanel.setLayout(new GridLayout(3, 1));

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
