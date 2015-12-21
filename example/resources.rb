class Sprites
	attr_reader :backgrounds, :playerShip1, :playerShip1Damage, :ui

	@backgrounds = './assets/spaceshooter/Backgrounds/'
	@playerShip1 = './assets/spaceshooter/PNG/playerShip2_'
	@playerShip1Damage = './assets/spaceshooter/PNG/Damage/playerShip2_damage'
	@ui = './assets/spaceshooter/PNG/UI/'

	def self.purple_background
		Sprite.new(java.io.File.new(@backgrounds + 'purple.png'))
	end

	def self.ship1_blue
		Sprite.new(java.io.File.new(@playerShip1 + 'blue.png'))
	end

	def self.ship1_red
		Sprite.new(java.io.File.new(@playerShip1 + 'red.png'))
	end

	def self.ship1_green
		Sprite.new(java.io.File.new(@playerShip1 + 'green.png'))
	end

	def self.ship1_orange
		Sprite.new(java.io.File.new(@playerShip1 + 'orange.png'))
	end

	def self.ship1_damage1
		Sprite.new(java.io.File.new(@playerShip1Damage + '1.png'))
	end

	def self.ship1_damage2
		Sprite.new(java.io.File.new(@playerShip1Damage + '2.png'))
	end

	def self.ship1_damage3
		Sprite.new(java.io.File.new(@playerShip1Damage + '3.png'))
	end

	def self.button_blue
		Sprite.new(java.io.File.new(@ui + 'buttonBlue.png'))
	end
end
