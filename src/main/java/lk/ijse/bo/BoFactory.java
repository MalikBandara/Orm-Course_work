package lk.ijse.bo;

import lk.ijse.bo.impl.UserBoImpl;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory() {

    }
    public static BoFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }
    public SuperBo getBo(BoTypes boType) {
            switch (boType) {
                case User :
                    return new UserBoImpl();

            }
            return null;
    }
}
