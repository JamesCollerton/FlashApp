package com.flashapp.jamescollerton.flashapp.interfaces;

import com.flashapp.jamescollerton.flashapp.fragments.ApertureFragment;
import com.flashapp.jamescollerton.flashapp.fragments.DistanceFragment;
import com.flashapp.jamescollerton.flashapp.fragments.GuideNumberFragment;
import com.flashapp.jamescollerton.flashapp.fragments.ISOFragment;
import com.flashapp.jamescollerton.flashapp.fragments.PowerFragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by JamesCollerton on 15/10/2017.
 */
public class InterfaceTest<ImplementedInterface> {

    @RunWith(Parameterized.class)
    public class InterfaceTesting {

        public ImplementedInterface implementedInterface;
        public Class<?> implementedClass;

        public InterfaceTesting(ImplementedInterface implementedInterface, Class<?> implementedClass) {
            this.implementedInterface = implementedInterface;
            this.implementedClass = implementedClass;
        }

        @Test
        public final void testImplementsInterface() {
            assertTrue(implementedInterface.getClass().isInstance(implementedClass));
        }

        @Test
        public final void testImplementsInterfaceMethods() {
            for (Method method : GNField.class.getDeclaredMethods()) {
                try {
                    implementedInterface.getClass().getMethod(method.getName());
                } catch (NoSuchMethodException e){
                    fail();
                }
            }
        }

        /*
        Note: Should probably be static, but as the inner declarations
        are static cannot be.
         */
        @Parameterized.Parameters
        private Collection<Object[]> instancesToTest() {
            return Arrays.asList(
                    new Object[]{new ApertureFragment()},
                    new Object[]{new DistanceFragment()},
                    new Object[]{new GuideNumberFragment()},
                    new Object[]{new ISOFragment()},
                    new Object[]{new PowerFragment()}
            );
        }
    }
}
