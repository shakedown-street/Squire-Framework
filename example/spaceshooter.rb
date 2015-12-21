require 'java'
require './lib/Squire.jar'

java_import 'com.squire.api.SquireGame'
java_import 'com.squire.api.SquireFrame'
java_import 'com.squire.api.event.AbstractEvent'
java_import 'com.squire.api.state.AbstractState'
java_import 'com.squire.api.graphics.Animation'
java_import 'com.squire.api.graphics.Sprite'
java_import 'com.squire.api.graphics.SpriteSheet'
java_import 'com.squire.api.ui.UIComponent'
java_import 'com.squire.api.ui.UIButton'

require './components'
require './models'
require './resources'
require './states'


class SpaceShooter < SquireGame
	def init
		start_state = StartState.new(self, 'start_state')
		getStateManager().setState(start_state)
	end
end


game = SpaceShooter.new(800, 500)
