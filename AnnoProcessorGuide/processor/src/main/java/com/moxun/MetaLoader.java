package com.moxun;

import java.lang.reflect.Constructor;

/**
 * Created by moxun on 16/8/18.
 */
public class MetaLoader {
    public static void load(Object obj) {
        String fullName = obj.getClass().getCanonicalName();
        String pkgName = fullName.substring(0, fullName.lastIndexOf('.'));
        String clsName = pkgName + "." + obj.getClass().getSimpleName() + "Gen";

        try {
            Class<Actor> clazz = (Class<Actor>) Class.forName(clsName);
            Constructor<Actor> constructor = clazz.getConstructor(obj.getClass());
            Actor actor = constructor.newInstance(obj);
            actor.action();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
