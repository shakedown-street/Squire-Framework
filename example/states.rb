# class NameOfState < AbstractState
# 	def init
# 	end
# 	def process
# 	end
# 	def render(g)
# 	end
# 	def endHook
# 	end
# end

class StartState < State
	def init
		getKeys().addAction(
			WalkKeyAction.new(KeyEvent::VK_W, KeyAction::Type::RELEASED))
	end

	def process

	end

	def render(g)

	end

	def endHook

	end
end