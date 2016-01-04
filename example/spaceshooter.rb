require 'java'
require './lib/Squire.jar'

java_import 'com.squire.api.SquireGame'
java_import 'com.squire.api.SquireFrame'
java_import 'com.squire.api.managers.ObjectManager'
java_import 'com.squire.api.models.Event'
java_import 'com.squire.api.models.State'
java_import 'com.squire.api.models.Sprite'
java_import 'com.squire.api.models.Animation'
java_import 'com.squire.api.models.SpriteSheet'
java_import 'com.squire.api.ui.UIComponent'
java_import 'com.squire.api.ui.UIButton'

require './components'
require './models'
require './states'


class SpaceShooter < SquireGame

	attr_accessor :backgrounds, :playerShip1, :playerShip1Damage, :ui,
				:purple_background, :ship1_blue, :ship1_red, :ship1_green,
				:ship1_orange, :ship1_damage1, :ship1_damage2, :ship1_damage3,
				:button_blue

	def init
		getStateManager().create(PlayState.new(self, 'play_state'))
		getStateManager().setState(getStateManager().getObject(0))

		@backgrounds = './assets/spaceshooter/Backgrounds/'
		@playerShip1 = './assets/spaceshooter/PNG/playerShip2_'
		@playerShip1Damage = './assets/spaceshooter/PNG/Damage/playerShip2_damage'
		@ui = './assets/spaceshooter/PNG/UI/'

		getSprites().create(Sprite.new('purple_bg',
			java.io.File.new(@backgrounds + 'purple.png')))
		getSprites().create(Sprite.new('ship1_blue',
			java.io.File.new(@playerShip1 + 'blue.png')))
		getSprites().create(Sprite.new('ship1_red',
			java.io.File.new(@playerShip1 + 'red.png')))
		getSprites().create(Sprite.new('ship1_green',
			java.io.File.new(@playerShip1 + 'green')))
		getSprites().create(Sprite.new('ship1_orange',
			java.io.File.new(@playerShip1 + 'orange.png')))
		getSprites().create(Sprite.new('ship1_damage1',
			java.io.File.new(@playerShip1Damage + '1.png')))
		getSprites().create(Sprite.new('ship1_damage2',
			java.io.File.new(@playerShip1Damage + '2.png')))
		getSprites().create(Sprite.new('ship1_damage3',
			java.io.File.new(@playerShip1Damage + '3.png')))
		getSprites().create(Sprite.new('button_blue',
			java.io.File.new(@ui + 'buttonBlue.png')))
	end
end

game = SpaceShooter.new(800, 500)
