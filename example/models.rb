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
	end
end

class PlayerManager < ObjectManager

end
