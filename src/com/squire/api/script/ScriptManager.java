package com.squire.api.script;

import java.io.File;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Probably going to be scrapped in the future. Currently not being utilized.
 *
 * @author Jordan Price
 *
 */
public class ScriptManager {

	private static final ScriptEngineManager scriptManager = new ScriptEngineManager();
	private static final ScriptEngine scriptEngine = scriptManager
			.getEngineByName("nashorn");

	/**
	 * Call a function from a script file
	 */
	public static String callFunc(String name, Object... args) {
		Invocable invoke = (Invocable) scriptEngine;
		try {
			return String.valueOf(invoke.invokeFunction(name, args));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Load Scripts from the initial directory and all sub directories.
	 */
	public static void loadScripts(String directory) {
		File dir = new File(directory);
		if (dir.exists() && dir.isDirectory()) {
			File[] children = dir.listFiles();
			for (File child : children) {
				if (child.isFile() && child.getName().endsWith(".js")) {
					try {
						scriptEngine.eval(new FileReader(child));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (child.isDirectory()) {
					loadScripts(child.getPath());
				}
			}
			System.out.println("Scripts loaded from: '" + dir.getName() + "'");
		}
	}
}
