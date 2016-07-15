import java.io.IOException;

import controller.MainController;

public class Main
{
  public static void main(String[] args) throws InterruptedException, IOException
  {
    MainController mainController = new MainController();
    mainController.go();
  }
}
