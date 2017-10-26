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
 * This class is used to test all of the interfaces. It basically tests the contract between the
 * interface and the class that says if the class implements the interface it must implement the
 * methods.
 */
@RunWith(Enclosed.class)
public class InterfaceTest{

    @RunWith(Parameterized.class)
    public static class InterfaceTesting {

        public Object implementedClass;
        public Class<?> implementedInterface;

        public InterfaceTesting(Object implementedClass, Class<?> implementedInterface) {
            this.implementedClass = implementedClass;
            this.implementedInterface = implementedInterface;
        }

        /**
         * This is used to recursively get all of the interfaces used by a class. It finds all
         * interfaces implemented by a class, then goes onto the next class in the hierarchy, adding
         * them all to a list.
         *
         * @param currentClass The class we are looking at at the moment
         * @param interfaces The list of interfaces we are adding to
         * @return The list of interfaces
         */
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

        /**
         * This gets all interfaces, then checks to make sure the one we said has been implemented
         * has been implemented.
         */
        @Test
        public final void testImplementsInterface() {
            ArrayList<Class<?>> implementedClasss = getAllInterfaces(implementedClass.getClass(), new ArrayList<Class<?>>());
            assertTrue(implementedClasss.contains(implementedInterface));
        }

        /**
         * This is used to test that a class implements all of the methods in the interface
         */
        @Test
        public final void testImplementsInterfaceMethods() {
            for (Method method : implementedInterface.getDeclaredMethods()) {
                try {
                    implementedClass.getClass().getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e){
                    fail();
                }
            }
        }

        /**
         * @return List of interfaces we want to return
         */
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
