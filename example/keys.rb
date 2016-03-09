class FlyUp < KeyAction
	def act
		getState().getPlayer().move(0, -5)
	end
end