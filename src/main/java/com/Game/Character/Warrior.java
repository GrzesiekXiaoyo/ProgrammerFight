package com.Game.Character;

import com.Game.Interfaces.ICharacter;

public class Warrior implements ICharacter
{
	public int Hit()
	{
		return 0;
	}

	public int Defend()
	{
		return 0;
	}

	@Override
	public String getName()
	{
		return "Jestem wojownikiem";
	}
}
