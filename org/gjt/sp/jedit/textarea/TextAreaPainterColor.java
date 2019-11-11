package org.gjt.sp.jedit.textarea;


import java.awt.Color;
import java.io.Serializable;

public class TextAreaPainterColor implements Serializable {
	private Color selectionColor;
	private Color multipleSelectionColor;
	private boolean lineHighlight;

	public Color getSelectionColor() {
		return selectionColor;
	}

	public Color getMultipleSelectionColor() {
		return multipleSelectionColor;
	}

	public boolean getLineHighlight() {
		return lineHighlight;
	}

	/**
	* Sets the selection color.
	* @param selectionColor  The selection color
	*/
	public final void setSelectionColor(Color selectionColor, TextArea thisTextArea) {
		this.selectionColor = selectionColor;
		thisTextArea.repaint();
	}

	/**
	* Sets the multiple selection color.
	* @param multipleSelectionColor  The multiple selection color
	* @since  jEdit 4.2pre1
	*/
	public final void setMultipleSelectionColor(Color multipleSelectionColor, TextArea thisTextArea) {
		this.multipleSelectionColor = multipleSelectionColor;
		thisTextArea.repaint();
	}

	/**
	* Enables or disables current line highlighting.
	* @param lineHighlight  True if current line highlight should be enabled, false otherwise
	*/
	public final void setLineHighlightEnabled(boolean lineHighlight, TextArea thisTextArea) {
		this.lineHighlight = lineHighlight;
		thisTextArea.repaint();
	}
}