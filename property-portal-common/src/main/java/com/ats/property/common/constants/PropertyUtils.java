package com.ats.property.common.constants;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * The PropertyUtils.
 *
 * @author anbarasan.s
 */
public class PropertyUtils {
    public static <T extends Object, Y extends Object> void copyFields(T from, Y too) {

        Class<? extends Object> fromClass = from.getClass();
        Field[] fromFields = fromClass.getDeclaredFields();

        Class<? extends Object> tooClass = too.getClass();
        Field[] tooFields = tooClass.getDeclaredFields();
        Map<String, Field> fromFieldMap = new HashMap<String, Field>();

        for (Field field : fromFields) {
            fromFieldMap.put(field.getName().toLowerCase(), field);
        }

        if (fromFields != null && tooFields != null) {
            for (Field tooF : tooFields) {
                try {
                    Field fromF = fromFieldMap.get(tooF.getName().toLowerCase()); //fromClass.getDeclaredField(tooF.getName());
                    if (fromF != null && fromF.getType().equals(tooF.getType())) {
                        tooF.setAccessible(true);
                        fromF.setAccessible(true);
                        tooF.set(too, fromF.get(from));
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
