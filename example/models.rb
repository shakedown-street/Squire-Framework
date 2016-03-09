class Player
	attr_accessor :sprite, :x, :y

	def initialize(_sprite, _x, _y)
		@sprite = _sprite
		@x = x
		@y = y
	end

	def render(g)
		@sprite.render(g, @x, @y)
	end

	def move(_x, _y)
		@x += _x
		@y += _y
	end

	def set_sprite(_sprite)
		@sprite = _sprite
	end
end
