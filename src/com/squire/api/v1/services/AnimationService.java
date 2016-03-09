package com.squire.api.v1.services;

import com.squire.api.v1.models.Animation;
import com.squire.api.v2.SquireService;

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
