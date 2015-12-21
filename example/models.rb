class Player
	attr_accessor :anim, :x, :y

	def initialize(anim)
		@anim = anim
		@x = 20
		@y = 20
	end

	def increment
		@x = @x + 1
		@y = @y + 1
	end

	def render(g)
		@anim.render(g, @x, @y)
	end

	def renderDamaged(g, damage)
		@anim.render(g, @x, @y)
		if (damage == 1)
			Sprites.ship1_damage1.render(g, @x, @y)
		elsif (damage == 2)
			Sprites.ship1_damage2.render(g, @x, @y)
		elsif (damage == 3)
			Sprites.ship1_damage3.render(g, @x, @y)
		end
	end
end
