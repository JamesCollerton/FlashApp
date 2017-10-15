package com.flashapp.jamescollerton.flashapp.interfaces;

import com.flashapp.jamescollerton.flashapp.fragments.ApertureFragment;
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

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by JamesCollerton on 15/10/2017.
 */
@RunWith(Enclosed.class)
public class InterfaceTest<ImplementedInterface> {

    @Test
    public void tesy(){
        
    }

    @RunWith(Parameterized.class)
    public static class InterfaceTesting<ImplementedInterface> {

//        public ImplementedInterface implementedInterface;
//        public Class<?> implementedClass;

        public InterfaceTesting(ImplementedInterface implementedInterface, Class<?> implementedClass) {
//            this.implementedInterface = implementedInterface;
//            this.implementedClass = implementedClass;
        }

        @Test
        public final void testImplementsInterface() {
//            assertTrue(implementedInterface.getClass().isAssignableFrom(implementedClass));
        }

        @Test
        public final void testImplementsInterfaceMethods() {
//            for (Method method : GNField.class.getDeclaredMethods()) {
//                try {
//                    implementedInterface.getClass().getMethod(method.getName(), method.getParameterTypes());
//                } catch (NoSuchMethodException e){
//                    fail();
//                }
//            }
        }

        @Parameterized.Parameters
        public static Collection<Object[]> instancesToTest(){
//            fail("Did not override instances to test");
//            return Arrays.asList();
            return Arrays.asList(
                    new Object[]{new ApertureFragment(), ApertureFragment.class},
                    new Object[]{new DistanceFragment(), DistanceFragment.class}
//                    new Object[]{new GuideNumberFragment(), GuideNumberFragment.class},
//                    new Object[]{new ISOFragment(), ISOFragment.class},
//                    new Object[]{new PowerFragment(), PowerFragment.class}
            );
        }

    }

}
