package com.nuguna.freview.global;

import java.io.File;
import java.util.UUID;

public class FileUtil {

  public static final String BASE_DIR =
      System.getProperty("user.home") + File.separator + "Desktop" + File.separator
          + "FReview2-profile";

  public static final String PROFILE_UPLOAD_DIR = BASE_DIR + File.separator;

  private static final String FILE_EXTENSION_SEPARATOR = ".";

  public static String getFullPath(String filename) {
    return PROFILE_UPLOAD_DIR + filename;
  }

  public static String getNewFileName(String originalFilename) {
    return UUID.randomUUID() + FILE_EXTENSION_SEPARATOR + getExtension(originalFilename);
  }

  private static String getExtension(String filename) {
    int lastIndex = filename.lastIndexOf(FILE_EXTENSION_SEPARATOR);
    if (lastIndex == -1 || lastIndex == filename.length() - 1) {
      return "";
    }
    return filename.substring(lastIndex + 1);
  }
}
