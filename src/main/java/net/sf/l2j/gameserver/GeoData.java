/*
 * Copyright © 2004-2020 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j.gameserver;

import java.util.logging.Logger;

import net.sf.l2j.Config;
import net.sf.l2j.gameserver.model.L2Object;
import net.sf.l2j.gameserver.model.Location;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * @author -Nemesiss-
 */
public class GeoData
{
	private static Logger _log = Logger.getLogger(GeoData.class.getName());
	private static GeoData _instance;
	
	public static GeoData getInstance()
	{
		if (_instance == null)
		{
			if (Config.GEODATA > 0)
			{
				_log.info("Geodata Engine: Enabled.");
				_instance = GeoEngine.getInstance();
			}
			else
			{
				_instance = new GeoData();
				_log.info("Geodata Engine: Disabled.");
			}
		}
		return _instance;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return Geo Block Type
	 */
	public short getType(int x, int y)
	{
		return 0;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @return Nearles Z
	 */
	public short getHeight(int x, int y, int z)
	{
		return (short) z;
	}
	
	public short getSpawnHeight(int x, int y, int zmin, int zmax, int spawnid)
	{
		return (short) zmin;
	}
	
	public String geoPosition(int x, int y)
	{
		return "";
	}
	
	/**
	 * @param cha
	 * @param target
	 * @return True if cha can see target (LOS)
	 */
	public boolean canSeeTarget(L2Object cha, L2Object target)
	{
		// If geo is off do simple check :]
		// Don't allow casting on players on different dungeon lvls etc
		return (Math.abs(target.getZ() - cha.getZ()) < 1000);
	}
	
	/**
	 * @param gm
	 * @param target
	 * @return True if cha can see target (LOS) and send usful info to PC
	 */
	public boolean canSeeTargetDebug(L2PcInstance gm, L2Object target)
	{
		return true;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @return Geo NSWE (0-15)
	 */
	public short getNSWE(int x, int y, int z)
	{
		return 15;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param tx
	 * @param ty
	 * @param tz
	 * @return Last Location (x,y,z) where player can walk - just befor wall
	 */
	public Location moveCheck(int x, int y, int z, int tx, int ty, int tz)
	{
		return new Location(tx, ty, tz);
	}
	
	/**
	 * @param gm
	 * @param comment
	 */
	public void addGeoDataBug(L2PcInstance gm, String comment)
	{
		// Do Nothing
	}
	
	public static void unloadGeodata(byte rx, byte ry)
	{
		
	}
	
	@Deprecated
	// TODO: cleanup?
	public static boolean loadGeodataFile(byte rx, byte ry)
	{
		return false;
	}
}
