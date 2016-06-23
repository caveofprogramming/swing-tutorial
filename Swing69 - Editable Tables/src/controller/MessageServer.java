package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Message;

/*
 * This is a sort of simulated message server.
 */

public class MessageServer implements Iterable<Message> {
	private Map<Integer, List<Message>> messages;

	private List<Message> selected;

	public MessageServer() {
		selected = new ArrayList<Message>();
		messages = new TreeMap<Integer, List<Message>>();

		List<Message> list = new ArrayList<Message>();
		list.add(new Message("The cat is missing",
				"Have you seen Felix anywhere?"));
		list.add(new Message("See you later?",
				"Are we still meeting in the pub?"));
		messages.put(0, list);

		list = new ArrayList<Message>();
		list.add(new Message("All personnel to deck 5",
				"An emergency has arisen"));
		list.add(new Message("Database restart",
				"The database will be restarted at 6pm"));
		messages.put(1, list);

		list = new ArrayList<Message>();
		list.add(new Message("How about dinner later?",
				"Are you doing anything later on?"));
		messages.put(2, list);

		list = new ArrayList<Message>();
		list.add(new Message("How many times can a man look up",
				"Before he can see the sky? More on that story later."));
		list.add(new Message("Company policy",
				"Please do not talk to the journalists outside."));
		list
				.add(new Message("New update schedule",
						"From now on we will be updating the codebase every night at 1 a.m."));
		messages.put(3, list);

		list = new ArrayList<Message>();
		list.add(new Message("Haggis available", "Free haggis at reception."));
		list
				.add(new Message(
						"Team building event",
						"There will be a team building event at the weekend. All employees must attend. Please ensure your life insurance is up to date before attending."));
		list
				.add(new Message("Desk policy",
						"Please do not take your desks home with you. They are company property."));
		list
		.add(new Message("Vending machine",
				"The coffee in the vending machine has been found to be contaminated with faeces. Please moderate your intake."));
		messages.put(4, list);
	}

	public void setSelectedServers(Set<Integer> servers) {

		selected.clear();

		for (Integer id : servers) {
			if (messages.containsKey(id)) {
				selected.addAll(messages.get(id));
			}
		}
	}

	public int getMessageCount() {
		return selected.size();
	}

	@Override
	public Iterator<Message> iterator() {
		return new MessageIterator(selected);
	}
}

class MessageIterator implements Iterator {

	private Iterator<Message> iterator;

	public MessageIterator(List<Message> messages) {
		iterator = messages.iterator();
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Object next() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {

		}

		return iterator.next();
	}

	@Override
	public void remove() {
		iterator.remove();
	}

}