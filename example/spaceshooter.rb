require 'java'
require './lib/Squire.jar'

# Java imports

java_import 'com.squire.api.SquireGame'
java_import 'com.squire.api.SquireFrame'
java_import 'com.squire.api.SquireService'
java_import 'com.squire.api.models.Animation'
java_import 'com.squire.api.models.Sprite'
java_import 'com.squire.api.models.SpriteSheet'
java_import 'com.squire.api.models.Event'
java_import 'com.squire.api.models.State'
java_import 'com.squire.api.player.KeyAction'
java_import 'com.squire.api.player.Keys'
java_import 'com.squire.api.player.Mouse'
java_import 'java.awt.event.KeyEvent'

# Ruby imports

require './keys'
require './models'
require './states'

class Game < SquireGame
	def init
		getStateService().setState(StartState.new(self, 'start-state'))
	end
end

game = Game.new(800, 500).start()
