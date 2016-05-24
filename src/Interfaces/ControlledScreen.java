package Interfaces;

import dto.ScreensController;

/**
 *
 * @author Angie
 */
public interface ControlledScreen {

    //This method will allow the injection of the Parent ScreenPane
    public void setScreenParent(ScreensController screenPage);
}
