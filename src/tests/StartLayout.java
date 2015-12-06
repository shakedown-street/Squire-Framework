package tests;

import java.io.File;

import com.squire.api.graphics.Sprite;
import com.squire.api.graphics.SpriteSheet;
import com.squire.api.ui.UIButton;
import com.squire.api.ui.UILayout;

public class StartLayout extends UILayout {
	
	private SpriteSheet sheet = new SpriteSheet(new File(
			"./assets/kenney/ui/ui-2/Spritesheet/greySheet.png"));
	private Sprite greyButton00 = sheet.getSprite(0, 143, 190, 45);
	
	public StartLayout() {
		addComponent(new UIButton(greyButton00, 0, 0, 190, 45));
	}

}
