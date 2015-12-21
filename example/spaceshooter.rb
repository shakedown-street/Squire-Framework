require 'java'
require './lib/Squire.jar'

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
require './resources'
require './states'


class SpaceShooter < SquireGame
	def init
		getStateManager().create(StartState.new(self, 'start_state'))
		getStateManager().setState(getStateManager().getObject(0))
	end
end


game = SpaceShooter.new(800, 500)
