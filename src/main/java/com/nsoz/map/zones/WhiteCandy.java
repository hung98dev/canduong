/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsoz.map.zones;

import com.nsoz.map.Map;
import com.nsoz.map.Waypoint;
import com.nsoz.map.world.World;
import com.nsoz.model.Char;
import org.jetbrains.annotations.NotNull;

/**
 * @author kitakeyos - Hoàng Hữu Dũng
 */
public class WhiteCandy extends ZWorld {

    public WhiteCandy(Map map, World world) {
        super(0, map.tilemap, map);
        setWorld(world);
    }

    @Override
    public void returnTownFromDead(@NotNull Char p) {
        p.setXY((short) 35, (short) 360);
        out(p);
        join(p);
    }

    @Override
    public void requestChangeMap(@NotNull Char p) {
        Waypoint wp = tilemap.findWaypoint(p.x, p.y);
        if (wp == null) {
            return;
        }
        Zone z = world.find(wp.next);
        p.outZone();
        p.setXY(wp.x, wp.y);
        z.join(p);
    }

}
