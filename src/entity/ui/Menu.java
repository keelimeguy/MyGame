package entity.ui;

import game.Game;
import graphics.Screen;
import graphics.Sprite;

public class Menu extends Frame {
	protected MenuElement[] elements;
	protected int size;

	public Menu(int x, int y, Sprite sprite, Border border, String[] options) {
		super(x, y, sprite, border);
		size = options.length;
		int yOff = (height - borderTopWidth - borderBottomWidth) - size * (int) ((height - borderTopWidth - borderBottomWidth) / size);
		elements = new MenuElement[size];
		for (int i = 0; i < size; i++) {
			elements[i] = new MenuElement(x + borderLeftWidth, y + yOff / 2 + borderTopWidth + i * (int) ((height - borderTopWidth - borderBottomWidth) / size), new Sprite(1, 1, 0x22ff33ff), new Border(width - borderLeftWidth - borderRightWidth, (height - borderTopWidth - borderBottomWidth) / size + 1, 0xdd000000, 1), new Sprite(1, 1, 0x22117777), options[i], this);
		}
	}

	public void click(Game game, String option) {
		//game.getDialogueController().sendDialogue("Congrats!!|You sent:\n" + option + "|I AM\nVERY\nPROUD!", null);
	}

	public void update(Game game) {
		if (hidden) return;
		for (MenuElement element : elements)
			element.update(game);
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		super.render(screen);
		for (MenuElement element : elements)
			element.render(screen);
	}
}
