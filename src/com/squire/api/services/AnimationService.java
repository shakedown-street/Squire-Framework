package com.squire.api.services;

import com.squire.api.SquireService;
import com.squire.api.models.Animation;

/**
 * @author Jordan/shakedown-street
 */
public class AnimationService extends SquireService<Animation> {
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
