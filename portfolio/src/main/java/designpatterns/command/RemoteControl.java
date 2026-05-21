package designpatterns.command;

import java.util.ArrayList;

public class RemoteControl {
    private Command[] slots;
    private ArrayList<Command> history;

    public RemoteControl(int size) {
        slots = new Command[size];
        history = new ArrayList<>();
    }

    public void setCommand(int slot, Command command) {
        slots[slot] = command;
    }

    public void pressButton(int slot) {
        if (slots[slot] != null) {
            slots[slot].execute();
            history.add(slots[slot]);
        } else {
            System.out.println("No command in slot " + slot);
        }
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command lastCommand = history.remove(history.size() - 1);
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo");
        }
    }
}

