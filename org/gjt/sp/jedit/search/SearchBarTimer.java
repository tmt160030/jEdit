package org.gjt.sp.jedit.search;


import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.gjt.sp.jedit.jEdit;
import org.gjt.sp.jedit.View;
import java.io.Serializable;

public class SearchBarTimer implements Serializable {
	private final Timer timer;
	private int searchStart;
	private boolean searchReverse;
	private SearchBar searchBar;

	public SearchBarTimer(final View view) {
		timer = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (!searchBar.incrementalSearch(searchStart,searchReverse)) {
					if (!searchBar.incrementalSearch((searchReverse ? view.getBuffer().getLength() : 0), searchReverse)) {view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.search-not-found"));
					}
				}
			}

			
		});
	}

	public Timer getTimer() {
		return timer;
	}

	public int getSearchStart() {
		return searchStart;
	}

	public boolean getSearchReverse() {
		return searchReverse;
	}
	
	public void timerIncrementalSearch(int start, boolean reverse) {
		searchStart = start;
		searchReverse = reverse;
		timer.stop();
		timer.setRepeats(false);
		timer.setInitialDelay(150);
		timer.start();
	}
}