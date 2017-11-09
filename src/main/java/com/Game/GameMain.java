package com.Game;


import com.Game.Helpers.FileLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class GameMain
{
	public static void main(String[] args)
	{
		String prefix = "com.Game.Character.";
		List<File> dirs = new ArrayList<>();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		FileLoader fileLoader = new FileLoader();
		fileLoader.getFilesFromFolder(prefix, dirs, classLoader);

		for (File file : dirs.get(0).listFiles())
		{
			String fileName = prefix +file.getPath().split("Character")[1].substring(1).replace(".class","");
			System.out.println(fileName);
			try
			{
				Class<?> character = classLoader.loadClass(fileName);
				Method[] methods = character.getMethods();
				Object newInstance = character.newInstance();
				for (Method method : methods)
				{
					Integer index = method.toString().indexOf("com");
					if (index > 0 && method.toString().substring(index).startsWith(prefix))
					{
						Object invoke = method.invoke(newInstance);
						System.out.println(invoke);
					}
				}

			} catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
	}


}
