package com.nuguna.freview.global;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import net.coobird.thumbnailator.Thumbnails;

public class FileUtil {

  public static final String BASE_DIR =
      System.getProperty("user.home") + File.separator + "Desktop" + File.separator
          + "FReview2-profile";

  // 원본 저장 디렉토리
  public static final String PROFILE_UPLOAD_DIR =
      BASE_DIR + File.separator + "profile" + File.separator;

  // 실제 데이터
  public static final String PROFILE_RESIZED_UPLOAD_DIR =
      BASE_DIR + File.separator + "resized" + File.separator;

  private static final String FILE_EXTENSION_SEPARATOR = ".";

  public static final int TARGET_WIDTH = 800;
  public static final int TARGET_HEIGHT = 800;

  static {
    File uploadDir = new File(PROFILE_UPLOAD_DIR);
    if (!uploadDir.exists()) {
      uploadDir.mkdirs();
    }

    File resizedDir = new File(PROFILE_RESIZED_UPLOAD_DIR);
    if (!resizedDir.exists()) {
      resizedDir.mkdirs();
    }
  }

  public static String getProfileFullPath(String filename) {
    return PROFILE_RESIZED_UPLOAD_DIR + filename;
  }

  public static File getProfileDestinationFilePath(String newProfileFileName) {
    return new File(PROFILE_UPLOAD_DIR, newProfileFileName);
  }

  public static String getSaveProfileFileName(String originalFilename) {
    return UUID.randomUUID() + FILE_EXTENSION_SEPARATOR + getExtension(originalFilename);
  }

  public static File getResizedProfileFilePath(String saveProfileFilename) {
    return new File(PROFILE_RESIZED_UPLOAD_DIR + saveProfileFilename);
  }

  private static String getExtension(String filename) {
    int lastIndex = filename.lastIndexOf(FILE_EXTENSION_SEPARATOR);
    if (lastIndex == -1 || lastIndex == filename.length() - 1) {
      return "";
    }
    return filename.substring(lastIndex + 1);
  }

  public static void resizeAndSave(File destinationFilePath, File resizedFilePath)
      throws IOException {
    Thumbnails.of(destinationFilePath)
        .size(TARGET_WIDTH, TARGET_HEIGHT)
        .keepAspectRatio(false)
        .toFile(resizedFilePath);
  }
}
