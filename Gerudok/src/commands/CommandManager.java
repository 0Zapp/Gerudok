package commands;

import java.util.ArrayList;

import gui.MainFrame;

public class CommandManager {

	// lista koja predstavlja stek na kome se nalaze konkretne izvr�ene komande
	private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
	// pokaziva� steka, sadr�i redni broj komande za undo / redo operaciju
	private int currentCommand = 0;

	/*
	 * Dodaje novu komandu na stek i poziva izvr�avanje komande
	 */
	public void addCommand(AbstractCommand command) {
		while (currentCommand < commands.size())
			commands.remove(currentCommand);
		commands.add(command);
		doCommand();
	}

	/*
	 * Metoda koja poziva izvr�avanje konkretne komande
	 */
	public void doCommand() {
		if (currentCommand < commands.size()) {
			commands.get(currentCommand++).doCommand();
			MainFrame.getInstance().getActionManager().getUndoAction(false).setEnabled(true);
		}
		if (currentCommand == commands.size()) {
			MainFrame.getInstance().getActionManager().getRedoAction(false).setEnabled(false);
		}
	}

	/*
	 * Metoda koja poziva redo konkretne komande
	 */
	public void undoCommand() {
		if (currentCommand > 0) {
			MainFrame.getInstance().getActionManager().getRedoAction(false).setEnabled(true);
			commands.get(--currentCommand).undoCommand();
		}
		if (currentCommand == 0) {
			MainFrame.getInstance().getActionManager().getUndoAction(false).setEnabled(false);
		}
	}

}
