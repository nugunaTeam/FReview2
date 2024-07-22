package com.nuguna.freview.global;

import java.io.File;

public class FileConstants {

  public static final String BASE_DIR =
      System.getProperty("user.home") + File.separator + "Desktop" + File.separator
          + "FReview2-profile";

  public static final String PROFILE_UPLOAD_DIR = BASE_DIR + File.separator;

}
