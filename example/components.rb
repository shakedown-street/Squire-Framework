# class ComponentName < UIComponent
# 	def renderComponent(g)
# 	end
# end

class StartBackground < UIComponent
	def renderComponent(g)
		Sprites.purple_background.render(g, 0, 0, 800, 500)
	end
end


class StartPlayButton < UIButton
	def onClick

	end

	def onHover

	end

	def renderComponent(g)
		posX = 150
		posY = 250
		Sprites.button_blue.render(g, posX, posY)
		g.drawString("Play Now", posX + 25, posY + 20)
	end
end

class FPSLabel < UIComponent
	attr_accessor :fps

	def initialize
		@fps = 0
	end

	def renderComponent(g)
		g.drawString("FPS: " + @fps.to_s, 20, 20)
	end
end
