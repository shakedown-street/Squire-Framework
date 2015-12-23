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

class PlayState < State
	attr_accessor :player, :playerManager, :switch_anim

	def init
		switch_anim_sprites = [
			getGame().getSprites().getByName('ship1_blue'),
			getGame().getSprites().getByName('ship1_green'),
			getGame().getSprites().getByName('ship1_orange'),
			getGame().getSprites().getByName('ship1_red')
		].to_java(Sprite)

		@switch_anim = getGame().getAnimations().create(Animation.new(switch_anim_sprites, 250))

		@playerManager = PlayerManager.new
		@player = @playerManager.create(Player.new(@switch_anim))
	end

	def process
		@player.increment()

		if @player::x > 800 || @player::y > 500
			stop()
		end
	end

	def render(g)
		@player.renderDamaged(g, 1)
	end

	def endHook
		puts 'play_state over'
	end
end
