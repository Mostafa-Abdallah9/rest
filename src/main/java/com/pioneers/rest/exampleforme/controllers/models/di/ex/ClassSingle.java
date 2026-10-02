package com.pioneers.rest.exampleforme.controllers.models.di.ex;

public class ClassSingle {
    /**
     * Eager SingleTon
     */
//    private static final ClassSingle INSTANCE = new ClassSingle();
//
//    private ClassSingle() {
//    }
//

//    public static ClassSingle getINSTANCE() {
//        return INSTANCE;
//    }
    /// //////////////////////////////////////////////
    /**
     * Lazy SingleTon
     */
//    private static ClassSingle INSTANCE ;
//
//    private ClassSingle() {
//
//    }
//
//    public static ClassSingle getINSTANCE() {
//        if (INSTANCE == null) {
//            INSTANCE = new ClassSingle();
//        }
//        return INSTANCE;
//    }
    /// ////////////////////////////////////////////////
    /**
     * Thread-Safe SingleTon
     */
//    private static ClassSingle INSTANCE ;
//
//    private ClassSingle() {
//
//    }
//
//    public static synchronized ClassSingle getINSTANCE() {
//        if (INSTANCE == null) {
//            INSTANCE = new ClassSingle();
//        }
//        return INSTANCE;
//    }
    /// ///////////////////////////////////////////////
    /**
     * Double-Checked Locking SingleTon
     */
//    private static ClassSingle INSTANCE ;
//
//    private ClassSingle() {
//
//    }
//
//    public static ClassSingle getINSTANCE() {
//        if (INSTANCE == null) {
//            synchronized (ClassSingle.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new ClassSingle();
//                }
//            }
//            }
//        return INSTANCE;
//
//    }
/// /////////////////////////////////////////////////////
    /**
     * Bill Pugh SingleTon
     */

//    public static ClassSingle getINSTANCE() {
//
//        return InnerClass.INSTANCE;
//
//    }
//
//    public static class InnerClass {
//        private static ClassSingle INSTANCE = new ClassSingle(); ;
//
//    }

/// ////////////////////////////////////////////////////////
    /**
     * Enum SingleTon
     */
//    public enum ClassEnum {
//
//        INSTANCE;
//    }

}
