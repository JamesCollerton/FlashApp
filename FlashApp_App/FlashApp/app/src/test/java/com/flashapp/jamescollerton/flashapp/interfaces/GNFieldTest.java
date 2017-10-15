package com.flashapp.jamescollerton.flashapp.interfaces;

import com.flashapp.jamescollerton.flashapp.enumerators.Power;
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
//@RunWith(Enclosed.class)
public class GNFieldTest extends InterfaceTest<GNField> {

    /*
    Note: Should probably be static, but as the inner declarations
    are static cannot be.
     */
//    @Parameterized.Parameters
//    public static Collection<Object[]> instancesToTest() {
//        return Arrays.asList(
//                new Object[]{new ApertureFragment(), ApertureFragment.class},
//                new Object[]{new DistanceFragment(), DistanceFragment.class},
//                new Object[]{new GuideNumberFragment(), GuideNumberFragment.class},
//                new Object[]{new ISOFragment(), ISOFragment.class},
//                new Object[]{new PowerFragment(), PowerFragment.class}
//        );
//    }

}
