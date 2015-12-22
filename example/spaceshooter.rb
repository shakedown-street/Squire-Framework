require 'java'
require './lib/Squire.jar'

java_import 'com.squire.api.ObjectManager'
java_import 'com.squire.api.SquireGame'
java_import 'com.squire.api.SquireFrame'
java_import 'com.squire.api.event.Event'
java_import 'com.squire.api.state.State'
java_import 'com.squire.api.graphics.Animation'
java_import 'com.squire.api.graphics.Sprite'
java_import 'com.squire.api.graphics.SpriteSheet'
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


		@purple_background = getSprites().create(Sprite.new(
			java.io.File.new(@backgrounds + 'purple.png')))

		@ship1_blue = getSprites().create(Sprite.new(
			java.io.File.new(@playerShip1 + 'blue.png')))
		
		@ship1_red = getSprites().create(Sprite.new(
			java.io.File.new(@playerShip1 + 'red.png')))
		
		@ship1_green = getSprites().create(Sprite.new(
			java.io.File.new(@playerShip1 + 'green.png')))
		
		@ship1_orange = getSprites().create(Sprite.new(
			java.io.File.new(@playerShip1 + 'orange.png')))
		
		@ship1_damage1 = getSprites().create(Sprite.new(
			java.io.File.new(@playerShip1Damage + '1.png')))
		
		@ship1_damage2 = getSprites().create(Sprite.new(
			java.io.File.new(@playerShip1Damage + '2.png')))
		
		@ship1_damage3 = getSprites().create(Sprite.new(
			java.io.File.new(@playerShip1Damage + '3.png')))
		
		@button_blue = getSprites().create(Sprite.new(
			java.io.File.new(@ui + 'buttonBlue.png')))
	end
end

game = SpaceShooter.new(800, 500)
