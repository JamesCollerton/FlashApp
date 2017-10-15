package com.flashapp.jamescollerton.flashapp.interfaces;

import com.flashapp.jamescollerton.flashapp.fragments.ApertureFragment;
import com.flashapp.jamescollerton.flashapp.fragments.CalculationButtonsFragment;
import com.flashapp.jamescollerton.flashapp.fragments.DistanceFragment;
import com.flashapp.jamescollerton.flashapp.fragments.GuideNumberFragment;
import com.flashapp.jamescollerton.flashapp.fragments.ISOFragment;
import com.flashapp.jamescollerton.flashapp.fragments.PowerFragment;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.*;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by JamesCollerton on 15/10/2017.
 */
@RunWith(Enclosed.class)
public class InterfaceTest<ImplementedInterface> {

    @RunWith(Parameterized.class)
    public static class InterfaceTesting<ImplementedInterface> {

        public ImplementedInterface implementedInterface;
        public Class<?> implementedClass;

        public InterfaceTesting(ImplementedInterface implementedInterface, Class<?> implementedClass) {
            this.implementedInterface = implementedInterface;
            this.implementedClass = implementedClass;
        }

        private ArrayList<Class<?>> getAllInterfaces(Class<?> currentClass, ArrayList<Class<?>> interfaces){

            for(Class<?> classInterface: currentClass.getInterfaces()){
                interfaces.add(classInterface);
            }

            Class<?> superClass = currentClass.getSuperclass();

            if(superClass != null){
                getAllInterfaces(superClass, interfaces);
            }

            return interfaces;
        }

        @Test
        public final void testImplementsInterface() {
            ArrayList<Class<?>> implementedInterfaces = getAllInterfaces(implementedInterface.getClass(), new ArrayList<Class<?>>());
            assertTrue(implementedInterfaces.contains(implementedClass));
        }

        @Test
        public final void testImplementsInterfaceMethods() {
            for (Method method : implementedClass.getDeclaredMethods()) {
                try {
                    implementedInterface.getClass().getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e){
                    fail();
                }
            }
        }

        @Parameterized.Parameters
        public static Collection<Object[]> instancesToTest(){
            return Arrays.asList(
                    new Object[]{new ApertureFragment(),            GNField.class},
                    new Object[]{new DistanceFragment(),            GNField.class},
                    new Object[]{new GuideNumberFragment(),         GNField.class},
                    new Object[]{new ISOFragment(),                 GNField.class},
                    new Object[]{new PowerFragment(),               GNField.class},
                    new Object[]{new CalculationButtonsFragment(),  GNButton.class}
            );
        }

    }

}
