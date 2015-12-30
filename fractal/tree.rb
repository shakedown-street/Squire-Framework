require 'java'
require './lib/Squire.jar'

java_import 'com.squire.api.ObjectManager'
java_import 'com.squire.api.SquireGame'
java_import 'com.squire.api.SquireFrame'
java_import 'com.squire.api.Event'
java_import 'com.squire.api.State'
java_import 'com.squire.api.Sprite'
java_import 'com.squire.api.Animation'
java_import 'com.squire.api.SpriteSheet'
java_import 'com.squire.api.ui.UIComponent'
java_import 'com.squire.api.ui.UIButton'

java_import 'java.lang.Math'

class DrawState < State
	def init

	end

	def process

	end

	def render(g)

	end

	def endHook
		puts 'draw_state over'
	end

	def draw_tree(g, x1, y1, angle, depth)
		if (depth == 0)
			return
		end
		x2 = x1 + (Math.cos(Math.toRadians(angle)) * depth * 10.0)
		y2 = y1 + (Math.sin(Math.toRadians(angle)) * depth * 10.0)
		g.drawLine(x1, y1, x2, y2)
		drawTree(g, x2, y2, angle - 20, depth - 1)
		drawTree(g, x2, y2, angle + 20, depth - 1)
	end
end

class FractalTree < SquireGame
	def init
		getStateManager().create(DrawState.new(self, 'draw_state'))
		getStateManager().setState(getStateManager().getObject(0))
	end
end

fractals = FractalTree.new(960, 720)