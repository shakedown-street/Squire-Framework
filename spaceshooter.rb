require 'java'
require './build/Squire.jar'

java_import 'com.squire.api.SquireGame'
java_import 'com.squire.api.state.AbstractState'
java_import 'com.squire.api.event.AbstractEvent'
java_import 'com.squire.api.graphics.Sprite'
java_import 'com.squire.api.graphics.SpriteSheet'
java_import 'com.squire.api.graphics.Animation'
java_import 'com.squire.api.ui.UIComponent'

class FPSLabel < UIComponent
	attr_accessor :fps

	def initialize
		@fps = 0
	end

	def renderComponent(g)
		g.drawString("FPS: " + @fps.to_s, 20, 20)
	end
end

class Sprites

	attr_reader :playerShip1

	@playerShip1 = './assets/spaceshooter/PNG/playerShip1_'

	def self.player_ship1_blue
		Sprite.new(
			java.io.File.new(@playerShip1 + 'blue.png'))
	end

	def self.player_ship1_red
		Sprite.new(
			java.io.File.new(@playerShip1 + 'red.png'))
	end

	def self.player_ship1_green
		Sprite.new(
			java.io.File.new(@playerShip1 + 'green.png'))
	end

	def self.player_ship1_orange
		Sprite.new(
			java.io.File.new(@playerShip1 + 'orange.png'))
	end
end

class StartTimer < AbstractEvent
	attr_accessor :seconds, :ticks

	def init
		@seconds = 0
		@ticks = 0
	end

	def execute
		@ticks += 1
		if @ticks >= 60
			@ticks = 0
			@seconds += 1
		end
	end
end

class StartState < AbstractState

	attr_accessor :timer

	def init
		@timer = StartTimer.new(1)
		getEventManager().submit(@timer)
	end

	def process
		puts @timer.seconds
		if @timer.seconds >= 2
			stop()
		end
	end

	def render(g)

	end

	def endHook
		play_state = PlayState.new(getGame(), 'play_state')
		getGame().getStateManager().setState(play_state)
	end
end

class PlayState < AbstractState

	attr_accessor :player, :switch_anim, :fpsL

	def init
		@fpsL = FPSLabel.new()

		switch_anim_sprites = [
			Sprites.player_ship1_blue,
			Sprites.player_ship1_green,
			Sprites.player_ship1_orange,
			Sprites.player_ship1_red
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
		@player.render(g)
		@fpsL.renderComponent(g)
	end

	def endHook

	end
end

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
end

class SpaceShooter < SquireGame
	def init
		start_state = StartState.new(self, 'start_state')
		getStateManager().setState(start_state)
	end
end

game = SpaceShooter.new(800, 500)
