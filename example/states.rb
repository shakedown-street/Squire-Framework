# class NameOfState < AbstractState
# 	def init
# 	end
# 	def process
# 	end
# 	def render(g)
# 	end
# 	def endHook
# 	end
# end

class PlayState < AbstractState
	attr_accessor :player, :switch_anim, :fpsL

	def init
		@fpsL = FPSLabel.new()

		switch_anim_sprites = [
			Sprites.ship1_blue,
			Sprites.ship1_green,
			Sprites.ship1_orange,
			Sprites.ship1_red
		].to_java(Sprite)

		@switch_anim = Animation.new(switch_anim_sprites, 250)

		@player = Player.new(@switch_anim)
	end

	def process
		@player.increment()

		@fpsL.fps = getGame()::lastFPS

		if @player::x > 800 || @player::y > 500
			stop()
		end
	end

	def render(g)
		@player.renderDamaged(g, 1)
		@fpsL.renderComponent(g)
	end

	def endHook
		puts 'play_state over'
	end
end


class StartState < AbstractState

	attr_reader :bg, :playBtn

	def init
		@bg = StartBackground.new()
		@playBtn = StartPlayButton.new()
	end

	def process

	end

	def render(g)
		@bg.renderComponent(g)
		@playBtn.renderComponent(g)
	end

	def endHook
		play_state = PlayState.new(getGame(), 'play_state')
		getGame().getStateManager().setState(play_state)
	end
end
