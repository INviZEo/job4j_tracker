package ru.job4j.tracker;

import java.util.List;

public class FindActionById implements UserAction {

    private final Output out;

    public FindActionById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        List<Item> item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " -" + " не найдена.");
        }
        return true;
    }
}
