package com.squire.api.managers;

import com.squire.api.SquireManager;
import com.squire.api.models.Animation;

/**
 * @author Jordan/shakedown-street
 */
public class AnimationManager extends SquireManager<Animation> {

	public void process() {
		for (Animation anim : objectSet()) {
			if (anim.isRunning()) {
				if (anim.shouldIncrement()) {
					anim.incrementFrame();
					
					if (anim.getFrame() > anim.getFrameSet().size() - 1) {
						if (anim.isLooping()) {
							anim.restart();
						} else {
							anim.stop();
						}
					}
				}
			}
		}
	}

}
