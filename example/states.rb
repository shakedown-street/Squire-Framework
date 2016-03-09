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

class StartState < State

	attr_accessor :player

	def init
		@player = Player.new(getSpriteService().create(Sprite.new(
			'./assets/spaceshooter/PNG/playerShip1_blue.png')), 30, 30)
		getKeys().addAction(
			FlyUp.new(KeyEvent::VK_W, KeyAction::Type::PRESSED, self))
	end

	def process

	end

	def render(g)
		@player.render(g)
	end

	def endHook

	end

	def getPlayer
		return @player
	end
end